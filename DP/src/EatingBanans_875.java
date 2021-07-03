import java.util.Arrays;

public class EatingBanans_875 {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1; // 注意l可以比最小值小
        int r = max(piles);
        while (l < r) { // 这里r永远使满足的，所以当l大于r的时候也必定满足
            int k = l + (r - l) / 2;
            if (eatTime(piles, k) > h) l = k+1; // 因为k不满足，所以l不用考虑k的情况了，直接取k+1
            else if (eatTime(piles, k) <= h) r = k;
        }
        return l;
    }

    private int max(int[] piles) {
        int max = piles[0];
        for (int b : piles) {
            if (b > max) max = b;
        }
        return max;
    }

    private int eatTime(int[] piles, int k) {
        int res = 0;
        for (int banana : piles) res += (banana - 1)/k + 1; // 向上取余的标准形式（因为整除的存在，不能暴力加1）
        return res;
    }
}
