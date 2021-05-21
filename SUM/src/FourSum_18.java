import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* https://leetcode.com/problems/4sum/
* 18. 4Sum
* key :
* */
public class FourSum_18 {
    class Solution {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            List<List<Integer>> res = new ArrayList<>();
            int n = nums.length;
            Arrays.sort(nums);
            for (int i = 0; i < n - 3; i++) {
                for (int j = i + 1; j < n - 2; j++) {
                    int cursum = target - nums[i] - nums[j];
                    int left = j + 1, right = n - 1;
                    while (left < right) {
                        int realsum  = nums[right] + nums[left];
                        if (realsum < cursum) {
                            left++;
                        }else if (realsum > cursum) {
                            right--;
                        }else {
                            res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                            while (left < right && nums[left] == nums[left + 1]) left++;
                            while (left < right && nums[right] == nums[right -1]) right--;
                            left++;
                            right--;
                        }
                    }
                    while (j < n - 2 && nums[j] == nums[j + 1]) j++;
                }
                while (i < n - 3 && nums[i] == nums[i + 1]) i++;
            }
            return res;
        }
    }
}
/*
*  无非比3sum多了个循环而已
*  但要特别注意，第二个循环从第一个循环的遍历字母+1开始而不是从0开始！
* */

