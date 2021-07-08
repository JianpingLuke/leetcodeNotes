import java.util.LinkedList;

public class SlidingWindowMax_239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        LinkedList<Integer> l = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            while (!l.isEmpty() && nums[i] > l.getLast()) // 不取等于的原因是，如果取了，则后面不知道删的第一个元素的位置，始终删最后一个
                l.removeLast(); // 利用后加的元素生命周期肯定更长的特性，只要后加的元素更大，就把前面小的移除
            l.add(nums[i]);
        }
        res[0] = l.getFirst();
        int j = 0;
        for (int i = k; i < nums.length; i++) {
            if (nums[i-k] == l.peek()) // 到了该元素，就从l中删去
                l.poll();
            while (!l.isEmpty() && nums[i] > l.getLast())
                l.removeLast();
            l.add(nums[i]);
            res[++j] = l.peek();
        }
        return res;
    }
}
