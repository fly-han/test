package com.han.sort;

import java.util.Arrays;

/**
 * 选择排序
 * Created by hanfei3 on 2017/7/13.
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] datas = {2, 8, 5, 3, 6, 1};
        sort(datas);
        Arrays.stream(datas).forEach(data -> System.out.println(data));
    }
    public static void sort(int[] data) {
        int length = data.length;
        for (int i = 0; i < length -1; i++) {
            int tmp = i;
            for (int j = i; j < length; j++) {
                if ( data[j] < data[tmp]) {
                    tmp = j;
                }
            }
            if (tmp != i) {
                data[tmp] = data[i] ^ data[tmp];
                data[i] = data[i] ^ data[tmp];
                data[tmp] = data[i] ^ data[tmp];
            }
        }
    }
}
