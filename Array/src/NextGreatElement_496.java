import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreatElement_496 { // 可转化成看楼房问题
    public int[] nextGreaterElement(int[] nums1, int[] nums2) { // 正存
        int[] res = new int[nums1.length];
        Stack<Integer> s = new Stack<>();
        Map<Integer, Integer> m = new HashMap<>();
        for (int num:nums2) {
            while (!s.isEmpty() && num > s.peek()) m.put(s.pop(), num); // 这个时候存进去
            s.push(num);
        }
        for (int i = 0; i < nums1.length; i++) res[i] = m.getOrDefault(nums1[i], -1);
        return res;
    }

    public int[] so2(int[] nums1, int[] nums2) { // 反存
        int[] res = new int[nums1.length];
        Stack<Integer> s = new Stack<>();
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && nums2[i] > s.peek()) s.pop(); // 把遮住的去掉
            int temp = s.isEmpty()?-1:s.peek();
            s.push(nums2[i]);
            m.put(nums2[i], temp); // 这个时候存进去
        }
        for (int i = 0; i < nums1.length; i++) res[i] = m.get(nums1[i]);
        return res;
    }
}
