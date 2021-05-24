public class Remove_Duplicates_26 {
    public int removeDuplicates(int[] nums) {
        //if (nums.length == 0) return 0;
        int slow = 0, fast = 0; // fast取0取1无影响
        while (fast < nums.length) { // fast是下标，所以可以取到length - 1
            if (nums[slow] < nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1; // 注意结尾返回的是长度，或者写成++slow,但不能写成slow++
    }
}
