public class Remove_Element_27 {
    public int removeElement(int[] nums, int val) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++; // 注意这个slow会取不到！先加和后加的区别，尤为容易出错！！！(注意边缘检测）
            }
            fast++;
        }
        return slow; // 相比于26，由于slow取不到，所以长度应为slow - 1 + 1 = slow;
    }
}
