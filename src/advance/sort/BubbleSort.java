package advance.sort;

import javax.sound.midi.Soundbank;
import javax.sql.DataSource;
import java.util.List;

public class BubbleSort {
    public static void main(String[] args) {
        int[] datas = {3, 6, 1, 10, 5, 6, 3, 1, 3};
        print(bubbleSort(datas));
    }

    public static int[] bubbleSort(int[] datas) {
        for(int i = 0; i < datas.length - 1; i ++) {  // 外循环为排序趟数，len个数进行len-1趟
            for (int j = 0; j < datas.length - 1 - i; j ++) { // 内循环为每趟比较的次数，第i趟比较len-i次
                if (datas[j] > datas[j + 1]) { // 相邻元素比较，若逆序则交换(此处为升序，每一趟会将最大值放到最后)
                    int temp = datas[j];
                    datas[j] = datas[j + 1];
                    datas[j + 1] = temp;
                }
                print(datas);
            }
        }
        return datas;
    }

    public static void print(int[] datas) {
        for (int data : datas) {
            System.out.print(data + " ");
        }
        System.out.println();
    }
}
