public class BinarySearch_704 {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length;
        int cur = 0;
        while (l <= r) {
            cur = l + (r - l) / 2;
            if (nums[cur] == target) return cur;
            if (nums[cur] < target) {
                l = cur + 1;
                continue;
            } else {
                r = cur - 1;
                continue;
            }
        }
        return -1;
    }
}
