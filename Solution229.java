import java.util.Stack;

public class Solution229 {
    public static void stackSorting(Stack<Integer> stk) {
        // write your code here
        Stack<Integer> stack = new Stack<>();
        while(!stk.isEmpty()) {
            int top = stk.pop();
            if(stack.isEmpty() || top<=stack.peek()) {
                stack.push(top);
                continue;
            }
            while(!stack.isEmpty() && top>stack.peek()) {
                stk.push(stack.pop());
            }
            stack.push(top);
        }

        while(!stack.isEmpty()) {
            stk.push(stack.pop());
        }
    }

    public static Stack<Integer> generateStack(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for(int i=arr.length-1; i>=0;  i--) {
            stack.push(arr[i]);
        }
        return stack;
    }

    public static void printStack(Stack<Integer> stack) {
        for(Integer i:stack) { // top 3 1 2 4 栈底
            System.out.print(i+" "); // 打印 4 2 1 3
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] a = {3,1,2,4};
        int[] b = {3,1,2,0,-1,8,19};
        Stack<Integer> stackA = generateStack(a);
        Stack<Integer> stackB = generateStack(b);
        stackSorting(stackA);
//        stackSorting(stackB);
        printStack(stackA);
//        printStack(stackB);
//        System.out.println(stackA.peek());
    }
}

