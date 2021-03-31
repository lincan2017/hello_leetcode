package first;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        // 从大到小排序
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            while (start < end) {
                if (nums[i] + nums[start] + nums[end] > 0) {
                    end--;
                } else if (nums[i] + nums[start] + nums[end] < 0) {
                    start++;
                } else {
                    // ==0 符合要求
                    List<Integer> each = new ArrayList<>();
                    each.add(nums[i]);
                    each.add(nums[start]);
                    each.add(nums[end]);
                    result.add(each);
                    // 递增和递减是为了避免死循环
                    start++;
                    end--;
                    // 不能用if是因为可能有某个数超过两次重复
                    // 加 start < end 是为了避免数组越界
                    while (nums[start] == nums[start - 1] && start < end) {
                        start++;
                    }
                    while (nums[end] == nums[end + 1] && end > start) {
                        end--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
        System.out.println(threeSum(new int[]{}));
        System.out.println(threeSum(new int[]{0}));
        System.out.println(threeSum(new int[]{-2, 0, 0, 2, 2}));
        System.out.println(threeSum(new int[]{-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6}));
        System.out.println(threeSum(new int[]{-2, 0, 3, -1, 4, 0, 3, 4, 1, 1, 1, -3, -5, 4, 0}));
        System.out.println(threeSum(new int[]{0, 0, 0}));
    }
}
