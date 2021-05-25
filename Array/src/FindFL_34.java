public class FindFL_34 {
    public int[] searchRange(int[] nums, int target) { //暴力解法时间太长
        int flag = 0, l = -1, r = -1;
        while (flag < nums.length) {
            if (nums[flag] == target) {
                if (l == -1) {
                    l = flag;
                    r = flag;
                }else {
                    r = flag;
                }
            }
            flag ++;
        }
        return new int[]{l, r};
    }

    public int[] s2(int[] nums, int target) {//思想的高度非常高
        int l = findl(nums, target);
        int r = findr(nums,target);
        return new int[]{l, r};
    }

    public int findl(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) r = mid - 1;
            else if (nums[mid] < target) l = mid + 1; // 固定左边界，当它不再比target小的时候，利用减小右边界退出循环
            else if (nums[mid] > target) r = mid - 1;
        }
        if (l > nums.length - 1) return -1; // 注意二分搜索检查出界情况
        return nums[l] == target ? l:-1;
    }

    public int findr(int nums[], int target) {
        if (nums.length == 0) return -1;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) l = mid + 1;
            else if (nums[mid] > target) r = mid - 1;
            else if (nums[mid] < target) l = mid + 1;
        }
        if (r < 0) return -1;
        return nums[r] == target ? r:-1;
    }
}
