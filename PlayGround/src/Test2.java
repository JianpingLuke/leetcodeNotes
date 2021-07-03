public class Test2 {
    public static void main(String[] args) {
//        char a = '1';
//        System.out.println(a);
//        a--;
//        System.out.println(a);
        String s = "123456";
        char[] sc = s.toCharArray();
        System.out.println(sc[0]);
        String test2_1 = sc.toString(); //返回地址
        String test2_2 = new String(sc);
        System.out.println("toString: " + test2_1);
        System.out.println("String: " + test2_2);
        StringBuilder test2_3 = new StringBuilder();
        for (char c : sc)test2_3.append(c);
        System.out.println(test2_3.toString().equals(test2_2));
        String temp = new String(test2_3);
        System.out.println(temp.equals(test2_2));
        System.out.println(test2_3.equals(test2_2));
    }
}
