package com.han.sort;

import java.util.Arrays;

/**
 * Created by hanfei3 on 2017/7/4.
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] datas = {2, 8, 5, 3, 6, 1};
        sort(datas, 0, datas.length - 1);
        Arrays.stream(datas).forEach(data -> System.out.println(data));
    }
    public static void sort(int[] datas, int low, int high) {
        int key = datas[low];
        int start = low;
        int end = high;
        while (start < end) {
            while (start < end && datas[end] > key) {
                end--;
            }
            datas[start] = datas[end];
            while (start < end && datas[start] < key) {
                start++;
            }
            datas[end] = datas[start];
        }
        datas[start] = key;//此时start == end
        if (low < start - 1) {
            sort(datas, low, start - 1);
        }
        if (start + 1 < high) {
            sort(datas, start + 1, high);
        }
    }
}
