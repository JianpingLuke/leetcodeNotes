/*
* https://leetcode.com/problems/3sum/
* 15. 3Sum
* key : Array.sort, two points
* */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15 {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            if (nums.length == 0 || nums == null) return res;
            int n = nums.length;
            Arrays.sort(nums); // key1 : using Arrays.sort to sort arrays.
            for (int i = 0; i < n - 2; i++) {
                int left = i + 1, right = n - 1;
                int sum = -nums[i];
                while (left < right) {
                    int cur = nums[left] + nums[right];
                    if (cur < sum) {
                        left++;
                    } else if (cur > sum) {
                        right--;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    }
                }
                while (i < n-2 && nums[i+1] == nums[i]) i++; // the sum can be the same and lead to duplicates
            }
            return res;
        }
    }
}
