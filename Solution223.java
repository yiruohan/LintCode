import javax.swing.*;
import java.util.List;
class ListNode{
    public int val;
    ListNode next;
    ListNode(int x) {
        this.val=x;
        next = null;
    }
}

public class Solution223 {
    // 判断是否回文链表
    public static boolean isPalindrome(ListNode head) {
        // write your code here
        boolean isP = true;
        if(head==null || head.next==null) {
            return isP;
        }

        ListNode reverse = reverse(head);
        ListNode current = head;
        ListNode cur = reverse;
        while(current!=null) {
            if(current.val!=cur.val) {
                isP = false;
                break;
            }
            current = current.next;
            cur = cur.next;
        }
        return isP;
    }

    // 翻转链表
    public static ListNode reverse(ListNode head) {
        if(head==null || head.next==null) {
            return head;
        }

        ListNode currrent = head;
        ListNode tmp = head;
        ListNode post = null;
        head = null;
        while(currrent!=null) {
            tmp = new ListNode(currrent.val);
            tmp.next = head;
            head = tmp;
            currrent = currrent.next;
        }
        return head;
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
        int[] a = {1,2,1,2};
        int[] b = {1,2,1};
        int[] c = {2,2,1};
        int[] d = {1,1,0,0,1};
        ListNode headA = generateListNode(a);
        ListNode headB = generateListNode(b);
        ListNode headC = generateListNode(c);
        ListNode headD = generateListNode(d);
        System.out.println(isPalindrome(headA));
        System.out.println(isPalindrome(headB));
        System.out.println(isPalindrome(headC));
        System.out.println(isPalindrome(headD));

        ListNode reverseA = reverse(headA);
        printListNode(reverseA);
        ListNode reverseB = reverse(headB);
        printListNode(reverseB);
        ListNode reverseC= reverse(headC);
        printListNode(reverseC);
        ListNode reverseD = reverse(headD);
        printListNode(reverseD);
    }
}

