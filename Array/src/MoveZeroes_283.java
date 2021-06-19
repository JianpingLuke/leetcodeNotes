public class MoveZeroes_283 {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int l = 0, r = 0;
        while (r < n) {
            if (nums[r] == 0) {
                r++;
                continue;
            }
            nums[l] = nums[r];
            // if (l != r) nums[r] = 0; // 这一步可以省去下面那个循环
            l++;
            r++;
        }
        while (l < n) {
            nums[l] = 0;
            l++;
        }
    }
}
