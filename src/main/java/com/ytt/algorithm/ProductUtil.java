package com.ytt.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Optional;

public class ProductUtil {

    /**
     * For String using
     * @param multiplierLeft
     * @param multiplierRight
     * @return
     */
    public static int[] productForMax(String multiplierLeft,String multiplierRight,Boolean isParallel){
        return productForMax(multiplierLeft.toCharArray(),multiplierRight.toCharArray(),isParallel);
    }

    /**
     * For String using
     * @param multiplierLeft
     * @param multiplierRight
     * @return
     */
    public static int[] productForMax(String multiplierLeft,String multiplierRight){
        return productForMax(multiplierLeft.toCharArray(),multiplierRight.toCharArray());
    }

    /**
     * For char[] using
     * @param leftMuls
     * @param rightMuls
     * @return
     */
    public static int[] productForMax(char[] leftMuls, char[] rightMuls,Boolean isParallel) {
        return productForMax(charToInt(leftMuls),charToInt(rightMuls),isParallel);
    }

    /**
     * For char[] using
     * @param leftMuls
     * @param rightMuls
     * @return
     */
    public static int[] productForMax(char[] leftMuls, char[] rightMuls) {
        return productForMax(charToInt(leftMuls),charToInt(rightMuls));
    }

    private static int[] productForMax(int[] leftMuls, int[] rightMuls, Boolean isParallel) {
        Objects.requireNonNull(leftMuls,"The frist multiplier is null!");
        Objects.requireNonNull(rightMuls,"The second multiplier is null!");

        if(leftMuls[0] == 0 || rightMuls[0] == 0){
            return new int[]{0};
        }

        //定义一个二位数组，用来保存位数相加的结果
        //       [ [1,2,3],
        //         [4,5,6]
        //         ...     ]
        int[][] calculateEachDigit = new int[leftMuls.length][rightMuls.length];
        //使用缓存减少计算，最多算10种第二个参数的结果
        HashMap<String,int[]> calculateCache = new HashMap<String,int[]>();

        for(int i = 0; i < leftMuls.length; i++) {
            Optional<int[]> optionalInts = Optional.ofNullable(calculateCache.get(leftMuls[i] + ""));
            if(optionalInts.isPresent()){
                calculateEachDigit[i] = optionalInts.get();
                continue;
            }
            for (int j = 0; j < rightMuls.length; j++) {
                calculateEachDigit[i][j] = leftMuls[i] * rightMuls[j];
            }
            calculateCache.put(leftMuls[i] + "",calculateEachDigit[i]);
        }


        return null;
    }


    /**
     * For int[] using
     * @param leftMuls
     * @param rightMuls
     * @return
     */
    public static int[] productForMax(int[] leftMuls, int[] rightMuls) {
        Objects.requireNonNull(leftMuls,"The frist multiplier is null!");
        Objects.requireNonNull(rightMuls,"The second multiplier is null!");

        if(leftMuls[0] == 0 || rightMuls[0] == 0){
            return new int[]{0};
        }

        //定义一个二位数组，用来保存位数相加的结果
        //       [ [1,2,3],
        //         [4,5,6]
        //         ...     ]
        int[][] calculateEachDigit = new int[leftMuls.length][rightMuls.length];
        //使用缓存减少计算，最多算10种第二个参数的结果
        HashMap<String,int[]> calculateCache = new HashMap<String,int[]>();

        for(int i = 0; i < leftMuls.length; i++) {
            Optional<int[]> optionalInts = Optional.ofNullable(calculateCache.get(leftMuls[i] + ""));
            if(optionalInts.isPresent()){
                calculateEachDigit[i] = optionalInts.get();
                continue;
            }
            for (int j = 0; j < rightMuls.length; j++) {
                calculateEachDigit[i][j] = leftMuls[i] * rightMuls[j];
            }
            calculateCache.put(leftMuls[i] + "",calculateEachDigit[i]);
        }

        //将计算数位的数组，第二层数组整理成一个数组
        int[] product = new int[leftMuls.length + rightMuls.length];

        for(int i = leftMuls.length-1; i >= 0; i--) {
            int[] twoArray = calculateEachDigit[i];
            for(int j = rightMuls.length-1;j >= 0; j--) {
                product[i+j] = product[i+j] + twoArray[j] / 10 ;
                product[i+j+1] = product[i+j+1] + twoArray[j] % 10;

            }

        }

        return product;
    }

    /**
     * char[] to int[]
     * if all chars are 0,return null;
     * @param charArray
     * @return
     */
    public static int[] charToInt(char[] charArray){
        int[] intArray = {0};
        if(Optional.of(charArray).isPresent()){
            boolean digitFlag = true;
            int index = 0;
            for(int i=0; i < charArray.length;i++ ){
                intArray[i] = Character.getNumericValue(charArray[i]);
                if(digitFlag && charArray[i] == '0'){
                    if(i==charArray.length-1){
                        return new int[]{0};
                    }
                    continue;
                }else{
                    if(digitFlag){//只赋值一次
                        intArray = new int[charArray.length - i];
                        index = new Integer(i);
                    }
                    digitFlag = false;
                    intArray[i-index] = Character.getNumericValue(charArray[i]);
                }
            }
            return intArray;
        }
        return null;

    }

}
