package offer.XiaoMi;

import java.util.Scanner;

class ListNode<T> {
    public T data;
    public ListNode next;
}

class so {

    /* Write Code Here */
    public ListNode<Integer> reverseBetween(ListNode<Integer> head, int left, int right) {
        ListNode<Integer> yummy = new ListNode<>();
        yummy.data = -1;
        yummy.next = head;
        ListNode<Integer> preRes = yummy;
        ListNode<Integer> leftTwo = head;
        ListNode<Integer> rightTwo = head;
        for(int i = 0;i<left-1;i++){
            preRes = preRes.next;
        }
        for(int i = 0;i<left-1;i++){
            leftTwo = leftTwo.next;
        }
        for(int i = 0;i<right-1;i++){
            rightTwo = rightTwo.next;
        }
        ListNode<Integer> store = rightTwo.next;
        ListNode<Integer> t1;
        ListNode<Integer> t2 = leftTwo;
        ListNode<Integer> pre = leftTwo.next;
        while(t2 != rightTwo){
            t1 = pre.next;
            pre.next = t2;
            t2 = pre;
            pre = t1;
        }

        preRes.next = rightTwo;
        leftTwo.next = store;
        return yummy.next;
    }
}

public class x1 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        ListNode<Integer> res = null;

        int head_size = 0;
        head_size = in.nextInt();
        ListNode<Integer> head = null, head_curr = null;
        for(int head_i = 0; head_i < head_size; head_i++) {
            int head_item = in.nextInt();
            ListNode<Integer> head_temp = new ListNode<Integer>();
            head_temp.data = head_item;
            head_temp.next = null;

            if (head == null) {
                head = head_curr = head_temp;
            } else {
                head_curr.next = head_temp;
                head_curr = head_temp;
            }
        }

        if(in.hasNextLine()) {
            in.nextLine();
        }

        int left;
        left = Integer.parseInt(in.nextLine().trim());

        int right;
        right = Integer.parseInt(in.nextLine().trim());

        res = new so().reverseBetween(head, left, right);
        while (res != null) {
            System.out.print(String.valueOf(res.data) + " ");
            res = res.next;
        }
        System.out.println();

    }
}
