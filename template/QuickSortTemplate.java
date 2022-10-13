import java.util.Scanner;

/**
 * @Author 鳄鱼儿
 * @Description TODO
 * @date 2022/10/11 13:23
 * @Version 1.0
 */

public class QuickSortTemplate {
    public static void main(String[] args) {

        int[] nums = new int[]{2, 5, 4, 3, 1, 8, 9, 7, 6};
        QuickSortTemplate sort = new QuickSortTemplate();
        sort.quickSort(nums, 0, nums.length - 1);
        for (int item : nums)
            System.out.print(item + " ");


        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }
            sort.quickSort(nums, 0, nums.length - 1);
            for (int item : nums)
                System.out.print(item + " ");
        }

    }

    /**
     * 快速排序模版 start
     * 1. 确定分界点——基数，可以取数组第一个元素、中间元素或者随机取一个数
     * 2. ⭐️调整分界点左右的元素，使得分界点左边元素都小于分界点元素值，右边元素都大于分界点元素值。
     * 3. 递归处理左右两端
     **/
    public void quickSort(int[] nums, int l, int r) {
        if (l >= r) return;
        int i = l - 1, j = r + 1, x = nums[l + r >> 1];
        while (i < j) {
            do i++; while (nums[i] < x);
            do j--; while (nums[j] > x) ;
            if (i < j) swap(nums, i, j);
        }
        quickSort(nums, l, j);
        quickSort(nums, j + 1, r);
    }

    /**
     * 快速排序模版 end
     **/

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
