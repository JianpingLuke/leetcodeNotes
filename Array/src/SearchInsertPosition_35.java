public class SearchInsertPosition_35 {
    public int searchInsert(int[] nums, int target) {
        int l = 0 , r = nums.length - 1;
        if (nums[r] < target) return nums.length; // 要取到nums.length的话，r最大是nums.length-1,永远搜索不到
        while (l < r) {
            int mid = l + ( r - l ) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) l = mid + 1;
            else if (nums[mid] > target) r = mid; // 不减1的原因是这里就算比mid大，但是可能也是答案
        }
        return l;
    }
}
/*
* 启发极大，对边界的理解是二分法的重点
* */