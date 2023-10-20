// Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

// You should preserve the original relative order of the nodes in each of the two partitions.

 

// Example 1:


// Input: head = [1,4,3,2,5,2], x = 3
// Output: [1,2,2,4,3,5]
// Example 2:

// Input: head = [2,1], x = 2
// Output: [1,2]

//using two list and connecting them
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode higher = new ListNode(0);

        ListNode smallHead = small , higherHead =higher;
        while(head!= null){
            if(head.val < x){
                //small list
                smallHead.next = head ;
                smallHead = smallHead.next;
            }else{
                 higherHead.next = head ;
                higherHead = higherHead.next;
            }
            head = head.next;
        }

        higherHead.next = null;
        smallHead.next = higher.next;
        return small.next;

    }
}