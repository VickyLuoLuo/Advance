package advance.sort;

public class QuickSort {
    public static void main(String[] args) {
        int[] datas = {3, 6, 1, 10, 5, 6, 3, 1, 3};
        quickSort(datas, 0, datas.length - 1);
        print(datas);
    }
    /**
     * 以第一个元素为基准，头为low，尾为hight。
     * 基准>hight值，则交换值，否则hight前移。
     * 基准<low值，则交换值，否则low后移。直到low>=hight,low或hight值为基准值。
     * 基准值将数据分为两部分，分别用同样的方法迭代。
     */
    public static void quickSort(int[] datas, int low, int high) {
        if (low > high) {
            return;
        }
        int temp = getIndex(datas, low, high);
        quickSort(datas, low, temp - 1);
        quickSort(datas, temp + 1, high);
    }

    public static int getIndex(int[] datas, int low, int high) {
        int temp = datas[low];
        while (low < high) {
            // 基准>hight值，则交换值，否则hight前移
            while (low < high && temp <= datas[high]) {
                high --;
            }
            datas[low] = datas[high];
            // 基准<low值，则交换值，否则low后移
            while (low < high && temp >= datas[low]) {
                low ++;
            }
            datas[high] = datas[low];
        }
        datas[low] = temp;
        return low;
    }

    public static void print(int[] datas) {
        for (int data : datas) {
            System.out.print(data + " ");
        }
        System.out.println();
    }
}
