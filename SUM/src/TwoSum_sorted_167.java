public class TwoSum_sorted_167 {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            if (numbers[l] + numbers[r] == target) break;
            if (numbers[l] + numbers[r] < target) l++;
            else r--;
        }
        return new int[]{l+1, r+1};
    }
}
// 双指针，左右夹逼，若快慢指针则会复杂度上升一个幂次