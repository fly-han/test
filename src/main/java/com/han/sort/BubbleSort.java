package com.han.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * Created by hanfei3 on 2017/7/13.
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] datas = {2, 8, 5, 3, 6, 7};
        sort(datas);
        Arrays.stream(datas).forEach(data -> System.out.println(data));
    }

    public static void sort(int[] data) {
        int max = data.length - 1;
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < max - i; j++) {
                if (data[j] > data[j + 1]) {
                    data[j + 1] = data[j] ^ data[j + 1];
                    data[j] = data[j] ^ data[j + 1];
                    data[j + 1] = data[j] ^ data[j + 1];
                }
            }
        }
    }
}
