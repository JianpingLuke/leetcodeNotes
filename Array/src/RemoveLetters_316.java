import java.util.Stack;

public class RemoveLetters_316 {
    public String removeDuplicateLetters(String s) {
        boolean[] instack = new boolean[126];
        Stack<Character> stk = new Stack<>();
        int[] count = new int[126];
        for (char c : s.toCharArray()) count[c]++;
        for (char c : s.toCharArray()) {
            count[c]--;
            if (instack[c]) continue;
            while (!stk.isEmpty() && stk.peek() > c) {
                if (count[stk.peek()] == 0) break;
                instack[stk.pop()] = false; // 弹出重复元素，并标志栈中没有此元素了
            }
            instack[c] = true;
            stk.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while (!stk.isEmpty()) sb.append(stk.pop());
        return sb.reverse().toString();
    }
}
// 栈的思维到达了顶峰，应时常回顾
