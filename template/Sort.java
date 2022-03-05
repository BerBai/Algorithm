import java.util.Arrays;

/**
 * @author ber
 * @version 1.0
 * @date 22/3/4 20:49
 */
public class Sort {
    // 冒泡排序
    public <T extends Comparable<T>> T[] BubbleSort(T list[]) {
        int len = list.length;
        for (int i = 1; i < len; i++) {
            for (int j = len - 1; j >= i; j--) {
                if (list[j].compareTo(list[j - 1]) < 0) {
                    T tmp = list[j];
                    list[j] = list[j - 1];
                    list[j - 1] = tmp;
                }
            }
        }
        return list;
    }

    public int[] BubbleSort(int[] list) {
        int len = list.length;
        for (int i = 1; i < len; i++) {
            for (int j = len - 1; j >= i; j--) {
                if (list[j] < list[j - 1]) {
                    int tmp = list[j];
                    list[j] = list[j - 1];
                    list[j - 1] = tmp;
                }
            }
        }
        return list;
    }

    // 选择排序
    public <T extends Comparable<T>> T[] SelectionSort(T[] list) {
        int len = list.length, minT;
        for (int i = 0; i < len; i++) {
            minT = i;
            for (int j = i + 1; j < len; j++) {
                if (list[j].compareTo(list[minT]) < 0) {
                    minT = i;
                }
            }
            T tmp = list[minT];
            list[minT] = list[i];
            list[i] = tmp;
        }
        return list;
    }

    public int[] SelectionSort(int[] list) {
        int len = list.length, minT;
        for (int i = 0; i < len; i++) {
            minT = i;
            for (int j = i + 1; j < len; j++) {
                if (list[j] < list[minT]) {
                    minT = i;
                }
            }
            int tmp = list[minT];
            list[minT] = list[i];
            list[i] = tmp;
        }
        return list;
    }

    // 插入排序
    public <T extends Comparable<T>> T[] InsertionSort(T list[]) {
        int len = list.length;
        for (int i = 1; i < len; i++) {
            T tmp = list[i];
            int j = i - 1;
            // 将比插入元素值大的数往后移动
            while (j >= 0 && list[j].compareTo(tmp) > 0) {
                list[j + 1] = list[j];
                j--;
            }
            // 插入元素
            list[j + 1] = tmp;
        }
        return list;
    }

    public int[] InsertionSort(int list[]) {
        int len = list.length;
        for (int i = 1; i < len; i++) {
            int tmp = list[i];
            int j = i - 1;
            // 将比插入元素值大的数往后移动
            while (j >= 0 && list[j] > tmp) {
                list[j + 1] = list[j];
                j--;
            }
            // 插入元素
            list[j + 1] = tmp;
        }
        return list;
    }

    // 希尔排序
    public <T extends Comparable<T>> T[] ShellSort(T list[]) {
        int len = list.length;
        int d = len;
        do {
            d /= 2;
            for (int i = 0; i < len - d; i++) {
                int j = i + d;
                if (list[j].compareTo(list[i]) < 0) {
                    T tmp = list[i];
                    list[i] = list[j];
                    list[j] = tmp;
                }
            }
        } while (d > 1);
        return list;
    }

    public int[] ShellSort(int list[]) {
        int len = list.length;
        int d = len;
        do {
            d /= 2;
            for (int i = 0; i < len - d; i++) {
                int j = i + d;
                if (list[j] < list[i]) {
                    int tmp = list[i];
                    list[i] = list[j];
                    list[j] = tmp;
                }
            }
        } while (d > 1);
        return list;
    }

    // 归并排序
    public int[] MergeSort(int list[]) {
        int tmp[] = new int[list.length]; //在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        MergeSort(list, 0, list.length - 1, tmp);
        return list;
    }

    public void MergeSort(int[] list, int l, int r, int tmp[]) {
        if (l < r) {
            int mid = (l + r) / 2;
            MergeSort(list, l, mid, tmp);
            MergeSort(list, mid + 1, r, tmp);
            Merge(list, l, mid, r, tmp);
        }
    }

    void Merge(int list[], int l, int mid, int r, int tmp[]) {
        int i = l; //左序列指针
        int j = mid + 1; //右序列指针
        int t = 0; //临时数组指针
        while (i <= mid && j <= r) {
            if (list[i] <= list[j]) {
                tmp[t++] = list[i++];
            } else {
                tmp[t++] = list[j++];
            }
        }
        while (i <= mid) { //将左边剩余元素填充进temp中
            tmp[t++] = list[i++];
        }
        while (j <= r) { //将右序列剩余元素填充进temp中
            tmp[t++] = list[j++];
        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while (l <= r) {
            list[l++] = tmp[t++];
        }
    }

    // 堆排序
    public int[] HeapSort(int list[]) {
        BuildMaxHeap(list);
        for (int i = list.length - 1; i >= 0; i--) {
            int tmp = list[0];
            list[0] = list[i];
            list[i] = tmp;
            MaxHeapify(list, 0, i);
        }
        return list;
    }

    public void BuildMaxHeap(int list[]) {
        // 构建大顶堆
        int heapSize = list.length;
        for (int i = (heapSize / 2); i >= 0; i--) {
            MaxHeapify(list, i, heapSize);
        }
    }

    public void MaxHeapify(int list[], int i, int heapSize) {
        // 维护堆
        int l = LEFT(i);
        int r = RIGHT(i);
        int largest;
        if (l <= heapSize - 1 && list[l] > list[i]) {
            largest = l;
        } else {
            largest = i;
        }
        if (r <= heapSize - 1 && list[r] > list[largest]) {
            largest = r;
        }
        if (largest != i) {
            int tmp = list[i];
            list[i] = list[largest];
            list[largest] = tmp;
            MaxHeapify(list, largest, heapSize);
        }
    }

    public int PARENT(int i) {
        return (i - 1) / 2;
    }

    public int LEFT(int i) {
        return 2 * i + 1;
    }

    public int RIGHT(int i) {
        return 2 * i + 2;
    }

    // 快速排序
    public int[] QuickSort(int list[]) {
        QuickSort(list, 0, list.length - 1);
        return list;
    }

    public void QuickSort(int list[], int l, int r) {
        if (l < r) {
            int mid = Partition(list, l, r);
            QuickSort(list, l, mid - 1);
            QuickSort(list, mid + 1, r);
        }
    }

    public int Partition(int list[], int l, int r) {
        int x = list[r];
        int i = l - 1;
        for (int j = l; j <= r - 1; j++) {
            if (list[j] <= x) {
                i = i + 1;
                int tmp = list[i];
                list[i] = list[j];
                list[j] = tmp;
            }
        }
        int tmp = list[i + 1];
        list[i + 1] = list[r];
        list[r] = tmp;
        return i + 1;
    }

    // 计数排序
    public int[] CountingSort(int list[]) {
        int maxNum = Arrays.stream(list).max().getAsInt();
        CountingSort(list, maxNum);
        return list;
    }

    public void CountingSort(int list[], int maxNum) {
        int tmp[] = new int[maxNum + 1];
        int res[] = new int[list.length];
        for (int item : list) {
            tmp[item]++;
        }
        for (int i = 1; i < tmp.length; i++) {
            tmp[i] += tmp[i - 1];
        }
        for (int i = list.length - 1; i >= 0; i--) {
            // 数组下标从0开始，此处减1
            res[tmp[list[i]] - 1] = list[i];
            tmp[list[i]]--;
        }
    }

    // 基数排序
    public int[] RadixSort(int list[]) {
        int maxNum = Arrays.stream(list).max().getAsInt();
        int d = 0;
        while (maxNum != 0) {
            maxNum /= 10;
            d++;
        }
        RadixSort(list, d);
        return list;
    }

    public void RadixSort(int list[], int d) {
        int[] res = new int[list.length];//结果数组
        int[] tmp = new int[10];//计数数组，范围为每位上的取值范围0-9

        //一个十进制数m，它的个位数是m/1%10，十位数是m/10%10,百位数是m/100%10
        for (int i = 0; i < d; i++) {
            int division = (int) Math.pow(10, i);//取个位::/1 十位:/10 百位:/100中的基本划分点
            for (int j = 0; j < list.length; j++) {
                int num = list[j] / division % 10;//取个位 十位 或百位上的数，每轮由此位置上的数大小进行计数排序

                tmp[num] = tmp[num] + 1;//进行计数排序中计数数组的更新
            }

            //计数排序中计数数组count的累加，保证稳定性
            for (int m = 1; m < tmp.length; m++) {
                tmp[m] = tmp[m] + tmp[m - 1];
            }

            //计数排序中逆序遍历原数组A，根据累加后的数组count将A中每个元素正确填入result中正确的位置中
            for (int j = list.length - 1; j >= 0; j--) {
                int num = list[j] / division % 10;
                res[tmp[num] - 1] = list[j];
                tmp[num] = tmp[num] - 1;
            }

            //将数组A更新为数组B
            for (int j = 0; j < list.length; j++) {
                list[j] = res[j];
            }
            //将数组C清零，进行下一轮的循环
            for (int j = 0; j < tmp.length; j++) {
                tmp[j] = 0;
            }
        }
    }

    // 桶排序
    class LinkedNode {

        public int value;
        public LinkedNode next;

        public LinkedNode(int value) {
            this.value = value;
        }

    }

    public int[] BucketSort(int list[]) {
        int length = list.length;
        LinkedNode[] bucket = new LinkedNode[length];  // 桶的个数等于length
        int max = list[0];  // 求max
        for (int i = 1; i < list.length; i++) {
            if (list[i] > max) {
                max = list[i];
            }
        }
        // 入桶
        for (int i = 0; i < length; i++) {
            int value = list[i];  // 扫描每个元素
            int hash = hash(list[i], max, length);  // 桶的下标
            if (bucket[hash] == null) {
                bucket[hash] = new LinkedNode(value);  // 初始化链表
            } else {
                insertInto(value, bucket[hash], bucket, hash);  // 插入链表
            }
        }
        int k = 0; // 记录数组下标
        // 出桶，回填arr
        for (LinkedNode node : bucket) {
            if (node != null) {
                while (node != null) {
                    list[k++] = node.value;
                    node = node.next;
                }
            }
        }
        return list;
    }

    private int hash(int element, int max, int length) {
        return (element * length) / (max + 1);
    }

    private void insertInto(int value, LinkedNode head, LinkedNode[] bucket, int hash) {
        LinkedNode newNode = new LinkedNode(value);
        // 小于头节点，放在头上
        if (value <= head.value) {
            newNode.next = head;
            // 替换头节点
            bucket[hash] = newNode;
            return;
        }
        // 往后找第一个比当前值大的节点，放在这个节点的前面
        LinkedNode p = head;
        LinkedNode pre = p;
        while (p != null && value > p.value) {
            pre = p;
            p = p.next;
        }
        if (p == null) {  // 跑到末尾了
            pre.next = newNode;
        } else {             // 插入pre和p之间
            pre.next = newNode;
            newNode.next = p;
        }
    }

    public static void main(String[] args) {
        Sort sort = new Sort();
        Integer nums[] = new Integer[]{3, 1, 6, 4};
        Integer[] bubbleSort = sort.BubbleSort(nums);
        System.out.println("冒泡排序-泛型版");
        for (int i : bubbleSort) {
            System.out.printf(i + " ");
        }

        System.out.println("\n冒泡排序--int[]");
        int[] nums2 = new int[]{9, 54, 2, 6, 3, 8};
        int[] bubbleSort1 = sort.BubbleSort(nums2);
        for (int i : bubbleSort1) {
            System.out.printf(i + " ");
        }
        System.out.println("\n选择排序-泛型版");
        Integer[] selectionSort1 = sort.SelectionSort(nums);
        for (int i : selectionSort1) {
            System.out.printf(i + " ");
        }
        System.out.println("\n选择排序-int版");
        int[] selectionSort2 = sort.SelectionSort(nums2);
        for (int i : selectionSort2) {
            System.out.printf(i + " ");
        }
        System.out.println("\n插入排序-泛型版");
        Integer[] insertionSort1 = sort.InsertionSort(nums);
        for (int i : insertionSort1) {
            System.out.printf(i + " ");
        }
        System.out.println("\n插入排序-int版");
        int[] insertionSort2 = sort.InsertionSort(nums2);
        for (int i : insertionSort2) {
            System.out.printf(i + " ");
        }
        System.out.println("\n希尔排序-泛型版");
        Integer[] shellSort1 = sort.ShellSort(nums);
        for (int i : shellSort1) {
            System.out.printf(i + " ");
        }
        System.out.println("\n希尔排序-int版");
        int[] shellSort2 = sort.ShellSort(nums2);
        for (int i : shellSort2) {
            System.out.printf(i + " ");
        }
        System.out.println("\n归并排序-int版");
        int[] mergeSort1 = sort.MergeSort(nums2);
        for (int i : mergeSort1) {
            System.out.printf(i + " ");
        }
        System.out.println("\n堆排序-int版");
        int[] heapSort1 = sort.HeapSort(nums2);
        for (int i : heapSort1) {
            System.out.printf(i + " ");
        }
        System.out.println("\n快速排序-int版");
        int[] quickSort1 = sort.QuickSort(nums2);
        for (int i : quickSort1) {
            System.out.printf(i + " ");
        }
        System.out.println("\n计数排序-int版");
        int[] countingSort1 = sort.CountingSort(nums2);
        for (int i : countingSort1) {
            System.out.printf(i + " ");
        }
        System.out.println("\n基数排序-int版");
        int[] radixSort1 = sort.RadixSort(nums2);
        for (int i : radixSort1) {
            System.out.printf(i + " ");
        }
        System.out.println("\n桶排序-int版");
        int[] bucketSort1 = sort.BucketSort(nums2);
        for (int i : bucketSort1) {
            System.out.printf(i + " ");
        }
    }

}
