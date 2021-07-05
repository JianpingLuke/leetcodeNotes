public class CheckK_1437 {
    public boolean kLengthApart(int[] nums, int k) {
        int slow = 0;
        int fast = 1;
        while (fast < nums.length) {
            while (nums[slow] != 1) {
                    slow++;
                    if (slow == nums.length) return true;
            }
            fast = slow + 1;
            while (nums[fast] != 1 && fast <nums.length) {
                fast++;
                if (fast == nums.length) return true;
            }
            int step = fast - slow - 1;
            if (step < k)
                return false;
            slow = fast;
            fast++;
        }
        return true;
    }

    public boolean so2(int[] nums, int k) { // 正面讨论的情况太多，可以想想反面考虑
        if (k==0) return true;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == 1) {
                for (int j = 0; j <= k; j++) {
                    i++;
                    if (i < nums.length && nums[i] == 1) return false;
                }
            }
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] test = new int[]{1,0,0,0,1,0,0,1};
        CheckK_1437 testC = new CheckK_1437();
        testC.kLengthApart(test,2);
    }
}
