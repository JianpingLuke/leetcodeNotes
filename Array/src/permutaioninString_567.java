public class permutaioninString_567 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] map1 = new int[26];
        int[] map2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            map1[s1.charAt(i)-'a']++;
            map2[s2.charAt(i)-'a']++;
        }
        int l = 0, r = s1.length() - 1;
        while (l <= r) { // 易错点：l可以等于r，如s1的长度为1的时候如果不置=就会直接跳过循环
            if (isMatch(map1, map2)) return true;
            map2[s2.charAt(l)-'a']--;
            l++;
            if (r < s2.length()-1) {
                r++;
                map2[s2.charAt(r) - 'a']++;
            }
        }
        return false;
    }

    private boolean isMatch(int[] map1, int[] map2) {
        for (int i = 0; i < 26; i++) {
            if (map1[i] != map2[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        permutaioninString_567 a = new permutaioninString_567();
        a.checkInclusion("a", "ab");
    }
}
