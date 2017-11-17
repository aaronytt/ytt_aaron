package test.Stream;

import org.junit.Test;

import java.util.Spliterator;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class SpliteratorTest {

    //这个是用来统计单词个数的
    public int countWordsIteratily(String word){
        int count = 0;

        boolean lastSpace = true;

        for (char c: word.toCharArray()) {
            if(Character.isWhitespace(c)){
                lastSpace = true;
            }else {
                if(lastSpace) count++;
                lastSpace = false;
            }
        }

        return count;
    }

    @Test
    public void testCountWordsIteratily(){
        System.out.println(countWordsIteratily(" aaron is niu"));
    }

    public int getCountWords(Stream<Character> stream){

//        return stream.reduce(new WordCounter(0,true),(w,c) -> w.accumulate(c),(w1,w2) -> w1.combine(w2)).getCounter();
        return stream.reduce(new WordCounter(0,true),WordCounter::accumulate,WordCounter::combine).getCounter();
    }

    @Test
    public void testGetCountWords(){
        String string = " aaron is niu .";
        System.out.println(getCountWords(IntStream.range(0,string.length()).mapToObj(string::charAt).parallel()));
    }

    @Test
    public void testWordCounterSpliterator(){
        String string = " aaron is niu .";
        System.out.println(getCountWords(StreamSupport.stream(new WordCounterSpliterator(string),true)));
    }

}

class WordCounterSpliterator implements Spliterator<Character>{

    private final String string;
    private int currentChar = 0;

    public WordCounterSpliterator(String string) {
        this.string = string;
    }

    @Override
    public boolean tryAdvance(Consumer<? super Character> action) {
        //处理当前字符
        action.accept(string.charAt(currentChar++));
        //如果还有字符要处理，就返回true
        return currentChar < string.length();
    }

    @Override
    public Spliterator<Character> trySplit() {
        System.out.println(">>> " + string + ">>> " + currentChar);
        int currentSize = string.length() - currentChar;
        //string已经足够小了就可以顺序处理了
        if(currentSize < 10){
            return null;
        }
        //将试探拆分位置设定要解析的String的中间（把第一部分用新得的分割迭代器分割）
        for (int splitPos = currentSize /2 + currentChar; splitPos < string.length(); splitPos++) {
            //让拆分位置前进直到下一个空格
            if(Character.isWhitespace(string.charAt(splitPos))){
               //创建一个新的分割迭代器来解析String 从开始到拆分位置的部分（第一部分）
               Spliterator<Character> spliterator =
                    new WordCounterSpliterator(string.substring(currentChar,splitPos));
                System.out.println(string.substring(currentChar,splitPos));
               //将自身的起始位置设置成拆分位置（第二部分的起始值）
               currentChar = splitPos;
               
               return spliterator;
             }
        }
        return null;
    }

    //返回一个估计的元素的数目会遇到由{@链接# foreachremaining }遍历，
    // 或者返回{@链接长# max_value }如果无限的，未知的，以免花大代价去计算。
    @Override
    public long estimateSize() {
        return string.length() - currentChar;
    }

    @Override
    public int characteristics() {
        return ORDERED + SIZED + SUBSIZED + NONNULL + IMMUTABLE;
    }
}

class WordCounter{

    private final int counter;
    private final boolean lastSpace;


    public WordCounter(int counter, boolean lastSpace) {
        this.counter = counter;
        this.lastSpace = lastSpace;
    }

    public WordCounter accumulate(Character c){
        if(Character.isWhitespace(c)){
            return lastSpace ? this : new WordCounter(counter,true);
        }else {
            return lastSpace ? new WordCounter(counter + 1,false) : this;
        }
    }

    public WordCounter combine(WordCounter wordCounter){
        return new WordCounter(counter + wordCounter.counter,wordCounter.lastSpace);
    }

    public int getCounter(){
        return counter;
    }

}
