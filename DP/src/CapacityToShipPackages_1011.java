import java.util.Arrays;

public class CapacityToShipPackages_1011 {
    public int shipWithinDays(int[] weights, int days) {
        int[] sorted = Arrays.stream(weights).sorted().toArray();
        int capacity = sorted[sorted.length - 1] - 1;
        int curDays = days + 1;
        while (curDays > days) {
            capacity++;
            curDays = 1;
            int remain = capacity;
            int i = 0;
            while (i < weights.length) {
                if (remain < weights[i]) {
                    remain = capacity;
                    curDays++;
                }else {
                    remain -= weights[i];
                    i++;
                }
            }
        }
        return capacity;
    }

    public int so2(int[] weights, int days) {
        int l = 1;
        int r = Integer.MAX_VALUE;
        int mid = 0;
        while (l < r) {
            mid = l + (r - l)/2;
            if (!canShip(mid, weights, days)) {
                l = mid + 1;
            }else {
                r = mid;
            }
        }
        return l;
    }

    private boolean canShip(int mid, int[] weights, int days) {
        int i = 0, realDays = 0;
        while (i < weights.length) {
            int temp = 0;
            while (i < weights.length && temp + weights[i] <= mid) { // 注意点1：这里用while表示一直装货，逻辑更佳
                temp += weights[i];
                i++; // 注意点2：当装不上时i要停住不能跳过去，所以不能简单的用for loop.
            }
            realDays++;
            if (realDays > days)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        CapacityToShipPackages_1011 test = new CapacityToShipPackages_1011();
        int[] testExp = new int[]{3,2,2,4,1,4};
        test.shipWithinDays(testExp, 3);
        System.out.println();
    }
}
