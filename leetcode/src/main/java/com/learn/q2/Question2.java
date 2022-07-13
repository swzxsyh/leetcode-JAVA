package com.learn.q2;

/**
 * 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author swzxsyh
 */
public class Question2 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        ListNode result = addTwoNumbers(l1, l2);
        System.out.println("result: " + result);
        ListNode answer = answer(l1, l2);
        System.out.println("answer: " + answer);
    }



    /**
     * 输入：l1 = [2,4,3], l2 = [5,6,4]
     * 输出：[7,0,8]
     * 解释：342 + 465 = 807.
     * <p>
     * 即 342 逆序 -> [2,4,3]
     * 即 465 逆序 -> [5,6,4]
     * [7,0,8] = 5+2，4+6，3+4 其中4+6进一位
     * [7,0,8] = 7，10，7  逆序则代表10进一进到后面的7上
     * [7,0,8] = 7，0，8  逆序则代表10进一进到后面的7上
     * <p>
     * core:
     * 1. 求和
     * 2. 进位
     */
    public void define() {

    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //TODO
        return new ListNode();
    }



    public static ListNode answer(ListNode l1, ListNode l2) {
        //结果链表虚拟头结点
        ListNode dummyNode = new ListNode(-1);
        //结果链表工作指针
        ListNode cur = dummyNode;
        //定义进位
        int carry = 0;
        //模拟两数相加
        while (l1 != null || l2 != null) {
            //本题难点：如果l1为空，l2不为空，则将l1的空对应值置为0，否则置为l1.val。l2亦然。
            //此处需要画图理解。
            int x = (l1 == null) ? 0 : l1.val;
            int y = (l2 == null) ? 0 : l2.val;
            //两数原始和（0-18）
            int sum = x + y + carry;
            //进位
            carry = sum / 10;
            //两数和（0-9）
            sum = sum % 10;
            //sum = sum / 10; 这里第一次搞错了，记录。
            //新建链表结点，将val赋值为sum
            cur.next = new ListNode(sum);
            //指针后移到新结点上
            cur = cur.next;
            //两个工作指针后移
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        //难点：最后的进位是特殊情况，需要增加新结点并赋val值为1
        if (carry == 1) {
            cur.next = new ListNode(1);
        }
        //返回结果链表的头结点
        return dummyNode.next;


    }

}
