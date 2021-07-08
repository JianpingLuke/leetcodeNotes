import java.util.HashMap;
import java.util.Map;

public class MinWinSubstring_76 {
//    public String minWindow(String s, String t) { // ! wrong 只能找到第一个
//        HashMap<Character,Integer> sMp = new HashMap<>();
//        HashMap<Character,Integer> tMp = new HashMap<>();
//        char[] tc = t.toCharArray();
//        for (char c : tc) {
//            int count = tMp.getOrDefault(c,0);
//            count++;
//            tMp.put(c,count);
//        }
//        char[] sc = s.toCharArray(); // char array of s
//        int l = 0;
//        int r = tc.length - 1;
//        for (int i = 0; i <= r; i++) {
//            int count = sMp.getOrDefault(sc[i],0);
//            count++;
//            sMp.put(sc[i],count);
//        }
//        while (r < sc.length) {
//            if (isSub(sMp,tMp))
//                break;
//            r++;
//            if (r < sc.length) {
//                int count = sMp.getOrDefault(sc[r],0);
//                count++;
//                sMp.put(sc[r],count);
//            }
//        }
//        while (isSub(sMp, tMp)) {
//            int count = sMp.getOrDefault(sc[l],0);
//            count--;
//            sMp.put(sc[l],count);
//            l++;
//        }
//        l--;
//        StringBuilder resbuf = new StringBuilder();
//        for (int i = l; i <= r; i++)
//            resbuf.append(sc[i]);
//        return resbuf.toString();
//    }
//
//    private boolean isSub(HashMap<Character, Integer> sMp, HashMap<Character, Integer> tMp) {
//        for(char key : tMp.keySet()) {
//            if (sMp.get(key) != tMp.get(key))
//                return false;
//        }
//        return true;
//    }

    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0)
            return "";
        Map<Character,Integer> dictT = new HashMap<>();
        Map<Character,Integer> dictS = new HashMap<>();
        char[] c = t.toCharArray();
        for (char cc : c) {
            int count = dictT.getOrDefault(cc,0);
            dictT.put(cc,count+1);
        }
        int l = 0, r = 0;
        int needSize = dictT.size();
        int countS = 0;
        int start = 0, len = -1;
        while (r < s.length()) {
            int count2 = dictS.getOrDefault(s.charAt(r),0);
            dictS.put(s.charAt(r),count2 + 1);
            if (dictT.containsKey(s.charAt(r)) &&
                dictT.get(s.charAt(r)).intValue() ==
                dictS.get(s.charAt(r)).intValue())
                countS++;
            while (l <= r && countS == needSize) {
                if (len == -1 || r - l + 1 < len) {
                    len = r - l + 1;
                    start = l;
                }
                int count3 = dictS.getOrDefault(s.charAt(l),0);
                dictS.put(s.charAt(l),count3 - 1);
                if (dictT.containsKey(s.charAt(l)) &&
                        dictT.get(s.charAt(l)).intValue() >
                        dictS.get(s.charAt(l)).intValue())
                    countS--;
                l++;
            }
            r++;
        }
        return (len == -1)
                ? ""
                : s.substring(start,len + start);
    }

}
