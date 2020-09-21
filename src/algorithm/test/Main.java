package algorithm.test;

import java.util.Arrays;
import java.util.Map;

/**
 * 给一个int类型数组arr，将数组中非0的元素移动到最前面，并返回非0元素数量: N。
 * 要求 在原数组上操作、移动完成后元素可以是任意顺序，除前N个位置外的元素任意。时间复杂度O(n), 空间O(1)
 * 例如：
 * 对于数组[1, 0, 2, 0, 3, 4] ，其中一种解为 返回值=4， 移动后数组为：[1, 2, 3, 4, 3, 4]
 *
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 0, 3, 4, 4, 5, 1, 34, 0, 2, 5, 56, 20, 7, 8, 0, 34, 0, 0, 0 ,0, 2};
        Main.simplestMethod(arr);
        int[] arr2 = {1, 0, 2, 0, 3, 4, 4, 5, 1, 34, 0, 2, 5, 56, 20, 7, 8, 0, 34, 0, 0, 0 ,0, 2};
        Main.myMethod(arr2);
    }

    public static void simplestMethod(int[] arr) {
        long start = System.currentTimeMillis();
        int i = 0;
        for (int ele : arr) {
            if (0 != ele) {
                arr[i ++] = ele;
            }
        }
        System.out.println("SimplestMethod | Sorted arr: " + Arrays.toString(arr));
        System.out.println("SimplestMethod | Sorted arr length: " + i);
        long end = System.currentTimeMillis();
        System.out.println("SimplestMethod | time: " + (end - start));
    }

    public static void myMethod(int[] arr) {
        long start = System.currentTimeMillis();
        int count = 0;
        for (int i = 0; i < arr.length; i ++) {
            if (0 == arr[i]) {
                ++ count;
                while (0 == arr[arr.length - count]) {
                    ++ count;
                }
                arr[i] = arr[arr.length - count];
            }
            if (arr.length == i + count) {
                break;
            }
        }
        System.out.println("MyMethod | Sorted arr: " + Arrays.toString(arr));
        System.out.println("MyMethod | Sorted arr length: " + (arr.length - count));
        long end = System.currentTimeMillis();
        System.out.println("MyMethod | time: " + (end - start));
    }
}
