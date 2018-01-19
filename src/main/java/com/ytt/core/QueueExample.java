package com.ytt.core;

import java.time.LocalDate;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 16:55 2018/1/15
 * @Modiflid By:
 */
public class QueueExample {

    public static void main(String[] args) {

        Queue<LocalDate> queue = new PriorityQueue<>();


        queue.add(LocalDate.of(1991,1,1));
        queue.add(LocalDate.of(1993,1,1));
        queue.add(LocalDate.of(1994,1,1));
        queue.add(LocalDate.of(1992,1,1));

        System.out.println("Iterating over elements...");

        for (LocalDate ld: queue) {
            System.out.println(ld);


        }

        System.out.println("Removing elements...");
        System.out.println(">>> " + queue.poll());
        while (!queue.isEmpty()){
            System.out.println(queue.remove());
        }




    }

}
