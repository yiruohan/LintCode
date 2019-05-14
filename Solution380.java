class ListNode{
    public int val;
    ListNode next;
    ListNode(int x) {
        this.val=x;
        next = null;
    }
}

public class Solution380 {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // write your code here
        int sizeA = 0;
        int sizeB = 0;
        ListNode curA = headA;
        while (curA!=null) {
            sizeA++;
            curA = curA.next;
        }
        ListNode curB = headB;
        while (curB!=null) {
            sizeB++;
            curB = curB.next;
        }

        curA = headA;
        curB = headB;
        if(sizeA>sizeB) {
            int size = sizeA-sizeB;
            while(size>0) {
                curA = curA.next;
                size--;
            }
        }else{
            int size = sizeB-sizeA;
            while(size>0) {
                curB = curB.next;
                size--;
            }
        }

        while (curA!=null) {
            if(curA.val==curB.val) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }

    // 优化
    public static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        // write your code here
        int size = 0;
        ListNode curA = headA;
        while (curA!=null) {
            size++;
            curA = curA.next;
        }
        ListNode curB = headB;
        while (curB!=null) {
            size--;
            curB = curB.next;
        }

        curA = headA;
        curB = headB;
        if(size>0) {
            while(size>0) {
                curA = curA.next;
                size--;
            }
        }else{
            while(size<0) {
                curB = curB.next;
                size++;
            }
        }

        while (curA!=null) {
            if(curA.val==curB.val) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }

    // 数组生成链表
    public static ListNode generateListNode(int[] a) {
        ListNode head = new ListNode(a[0]);
        ListNode tmp = new ListNode(a[1]);
        for(int i=1; i<a.length; i++) {
            if(i==1) {
                head.next = tmp;
            }else{
                ListNode tmp1 = new ListNode(a[i]);
                tmp.next = tmp1;
                tmp = tmp.next;
            }
        }
        return head;
    }

    // 打印链表
    public static void printListNode(ListNode head) {
        ListNode current = head;
        while(current!=null) {
            System.out.print(current.val+"->");
            current = current.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9,10,11,12,13};
        int[] b = {6,7,8,9,10,11,12,13};
        ListNode headA = generateListNode(a);
        ListNode headB = generateListNode(b);
        ListNode resultA = getIntersectionNode(headA,headB);
        ListNode resultB = getIntersectionNode1(headA,headB);
        printListNode(resultA);
        printListNode(resultB);
    }
}

