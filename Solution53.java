import java.util.Stack;
public class Solution53 {
    public static String reverseWords(String s) {
        // write your code here
        if(s=="") {
            return "";
        }
        Stack<String> stack = new Stack<>();
        String s1 = "";
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)!=' ') {
                s1 += s.charAt(i);
            }else{
                if(!s1.isEmpty()) {
                    stack.push(s1);
                }
                s1 = "";
            }
        }
        if(!s1.isEmpty()) {
            stack.push(s1);
        }
        String res = stack.pop();
        while (!stack.isEmpty()) {
            res += " " + stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        String s1 = "the sky is blue";
        String s2 = "hello world";
        System.out.println(reverseWords(s1));
        System.out.println(reverseWords(s2));
    }
}

