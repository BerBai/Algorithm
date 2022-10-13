import java.util.Scanner;

/**
 * @Author 鳄鱼儿
 * @Description TODO
 * @date 2022/10/11 13:59
 * @Version 1.0
 */

public class MergeSort {
    static int[] tmp;

    public static void main(String[] args) {
        MergeSort sort = new MergeSort();
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            tmp = new int[n];
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }
            sort.mergeSort(nums, 0, n - 1);
            for (int item : nums)
                System.out.printf(item + " ");
        }
    }

    /**
     * 归并排序模版 start
     *
     * 1. 确定分界点——中间点，(l+r)/2
     * 2. 递归处理分界点左右两端
     * 3. ⭐️归并——将左右两个数组合二为，两个指针分别指向两端数组开头，选取两指针较小的数放入临时数组
     **/
    public void mergeSort(int[] nums, int l, int r) {
        if (l >= r) return;
        int mid = l + r >> 1;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        int k = 0, i = l, j = mid + 1;

        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j]) tmp[k++] = nums[i++];
            else tmp[k++] = nums[j++];
        }
        while (i <= mid) tmp[k++] = nums[i++];
        while (j <= r) tmp[k++] = nums[j++];
        for (i = l, j = 0; i <= r; i++, j++) nums[i] = tmp[j];
    }
    /** 归并排序模版 end **/

}
