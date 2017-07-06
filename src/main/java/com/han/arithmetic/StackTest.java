package com.han.arithmetic;

import java.util.Stack;

/**
 * Created by hanfei3 on 2017/6/26.
 */
public class StackTest {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
//        stack.push(1);
//        stack.push(2);
//        stack.push(3);
//        stack.push(4);
//        stack.push(5);
////        reverse(stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    private static <T> T getAndRemoveBottom(Stack<T> stack) {
        T pop = stack.pop();
        if (stack.isEmpty()) {
            return pop;
        } else {
            T bottom = getAndRemoveBottom(stack);
            stack.push(pop);
            return bottom;
        }
    }

    public static <T> void reverse(Stack<T> stack) {
        if (!stack.isEmpty()) {
            T bottom = getAndRemoveBottom(stack);
            reverse(stack);
            stack.push(bottom);
        }
    }

}
