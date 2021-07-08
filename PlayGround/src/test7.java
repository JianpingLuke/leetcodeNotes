/*
*  test >> << >>>
*  https://zhuanlan.zhihu.com/p/30108890
* */
public class test7 {
    public static void main(String[] args) {
        int a = -733183670;
        String sa = Integer.toBinaryString(a);
        System.out.println(sa);
        int b = a<<1;
        String sb = Integer.toBinaryString(b);
        System.out.println(sb);
        System.out.println(b);
        int c = a>>1;
        String sc = Integer.toBinaryString(c);
        System.out.println(sc);
        System.out.println(c);
        System.out.println("-----------");
        int testHash = sb.hashCode();
        System.out.println(testHash);
        System.out.println(testHash^(testHash>>>16));
        System.out.println("-----------");
        System.out.println(testHash%16);
        System.out.println((testHash & (16 - 1))); // 相当于取模（大于的数全被0给同化了）
        System.out.println(1<<4);
    }
}
