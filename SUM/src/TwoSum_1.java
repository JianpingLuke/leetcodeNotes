/*
*   https://leetcode.com/problems/two-sum/
*   1. two sum
*   key: hash map
* */

import java.util.HashMap;

public class TwoSum_1 {
    int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < n; i++)
            index.put(nums[i],i);
        for (int i = 0; i < n; i++) {
            int other = target - nums[i];
            if(index.containsKey(other) && index.get(other) != i)
                return  new int[] {i, index.get(other)};
        }
        return new int[] {-1, -1};
    }
}

/*
* using hash map to store value
* a sum can be transformed into x and sum - x
* store x and find sum - x again
* O(n) O(n)
* */