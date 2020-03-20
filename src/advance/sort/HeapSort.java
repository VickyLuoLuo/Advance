package advance.sort;

/**
 * 查找数组中某个数的父结点和左右孩子结点，比如已知索引为i的数，那么:
 * 1.父结点索引：(i-1)/2（这里计算机中的除以2，省略掉小数）
 * 2.左孩子索引：2*i+1
 * 3.右孩子索引：2*i+2
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] datas = {3, 6, 1, 10, 5, 3};
        heapSort(datas);
        print(datas);
    }

    public static void heapSort(int[] datas) {
        // 构造大根堆
        heapInsert(datas);
        int size = datas.length;
        while (size > 1) {
            // 将构造的大根堆的根结点（最大值）与树的末尾节点交换，即固定最大值到末尾节点。
            swap(datas, 0, size - 1);
            size --;
            // 使用剩下的数据重新构造大根堆
            heapInsert(datas, 0, size);
        }
    }

    /**
     * 遍历数组元素，通过新插入的元素上升来构造大根堆。
     * @param datas
     */
    public static void heapInsert(int[] datas) {
        for (int i = 0; i < datas.length; i ++) {
            int currentIndex = i;
            int fatherIndex = (currentIndex - 1) / 2;
            // 当前节点值大于父节点时，交换值，并将索引指向父节点，继续与上层父节点比较，直到不大于父节点。
            while (datas[currentIndex] > datas[fatherIndex]) {
                swap(datas, currentIndex, fatherIndex);
                currentIndex = fatherIndex;
                fatherIndex = (currentIndex - 1) / 2;
            }
        }
    }

    /**
     * 通过顶点元素下降来构造大根堆。
     * @param datas
     * @param index
     * @param size
     */
    public static void heapInsert(int[] datas, int index, int size) {
        // 左节点索引
        int leftIndex = index * 2 + 1;
        // 右节点索引
        int rightIndex = index * 2 + 2;
        while (leftIndex < size) {
            // 比较左右节点，选取较大值所在索引赋值给largestIndex
            int largestIndex;
            if (datas[leftIndex] < datas[rightIndex] && rightIndex < size) {
                largestIndex = rightIndex;
            } else {
                largestIndex = leftIndex;
            }
            // 比较较大值与父节点值，选取大的赋值给largestIndex
            if (datas[index] > datas[largestIndex]) {
                largestIndex = index;
            }
            // 如果父节点值最大，则已经符合条件，停止此次循环，继续下一个循环
            if (index == largestIndex) {
                break;
            }
            // 如果父节点值不大于子节点，交换值
            swap(datas, index, largestIndex);
            // 将父节点索引指向较大的子节点
            index = largestIndex;
            // 重新赋值交换后的子节点
            leftIndex = index * 2 + 1;
            rightIndex = index * 2 + 2;
        }
    }

    public static void swap(int[] datas, int i, int j) {
        int temp = datas[i];
        datas[i] = datas[j];
        datas[j] = temp;
    }

    public static void print(int[] datas) {
        for (int data : datas) {
            System.out.print(data + " ");
        }
        System.out.println();
    }
}
