public class Solution224 { // ThreeStacks类
    public static void main(String[] args) {
        ThreeStacks ts = new ThreeStacks(1);
        System.out.println(ts.isEmpty(2));
        System.out.println(ts.isEmpty(0));
        System.out.println(ts.isEmpty(1));

        ts.push(0,1);
        System.out.println(ts.pop(0));
        ts.push(1,2);
        System.out.println(ts.peek(1));

//        ThreeStacks ts = new ThreeStacks(5);
//        ts.push(0,10);
//        ts.push(0,11);
//        ts.push(1,20);
//        ts.push(1,21);
//        System.out.println(ts.pop(0));
//        System.out.println(ts.pop(1));
//        System.out.println(ts.peek(1));
//        ts.push(2,30);
//        System.out.println(ts.pop(2));
//        System.out.println(ts.isEmpty(2));
//        System.out.println(ts.isEmpty(0));
    }
}

