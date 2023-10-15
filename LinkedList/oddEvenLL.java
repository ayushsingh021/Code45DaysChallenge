// Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.

// The first node is considered odd, and the second node is even, and so on.

// Note that the relative order inside both the even and odd groups should remain as it was in the input.

// You must solve the problem in O(1) extra space complexity and O(n) time complexity.

 

// Example 1:


// Input: head = [1,2,3,4,5]
// Output: [1,3,5,2,4]


  /*
            Story : 
            1. Hume odd and even ko segregate karna hai
            2. To let's take two pointers to point to ODD and EVEN nodes
            3. Unko alag alag segregate kardenge
            4. Last me connect kardenge odd ko even se
            
        */


        class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode temp = even;
        while(even != null && even.next != null){
            odd.next = even.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = temp;

        return head;

    }
}