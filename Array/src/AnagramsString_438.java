import java.util.ArrayList;
import java.util.List;

public class AnagramsString_438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() == 0 || p.length() == 0 || s.length() < p.length()) return res;
        int[] map_s = new int[26];
        int[] map_p = new int[26];
        for (int i = 0; i < p.length(); i++) {
            map_p[p.charAt(i) - 'a']++;
            map_s[s.charAt(i) - 'a']++;
        }
        int l = 0, r = p.length() - 1;
        while (l < r) {
            if (matchMap(map_s, map_p)) res.add(l);
            map_s[s.charAt(l) - 'a']--;
            r++;
            l++;
            if (r < s.length()) map_s[s.charAt(r) - 'a']++;
        }
        return res;
    }

    private boolean matchMap(int[] map_s, int[] map_p) {
        int len = map_s.length;
        for (int i = 0; i < len; i++) {
            if (map_s[i] != map_p[i]) return false;
        }
        return true;
    }
}
// 巧妙运用ASCII码作为数组下标
