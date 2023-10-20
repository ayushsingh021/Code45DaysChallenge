
//imp concept
// Given the head of a linked list, we repeatedly delete consecutive sequences of nodes that sum to 0 until there are no such sequences.

// After doing so, return the head of the final linked list.  You may return any such answer.

 

// (Note that in the examples below, all sequences are serializations of ListNode objects.)

// Example 1:

// Input: head = [1,2,-3,3,1]
// Output: [3,1]
// Note: The answer [1,2,1] would also be accepted.
// Example 2:

// Input: head = [1,2,3,-3,4]
// Output: [1,2,4]
// Example 3:

// Input: head = [1,2,3,-3,-2]
// Output: [1]
 

class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        HashMap<Integer , ListNode> hm = new HashMap<>();
        hm.put(0 , dummy);
        int prefixSum = 0;
        while(head != null){
            prefixSum += head.val;
            if(hm.containsKey(prefixSum)){
                ListNode start = hm.get(prefixSum);
                ListNode temp = start;
                int pSum = prefixSum;
                while(temp != head){
                    temp = temp.next;
                    pSum += temp.val;
                    if(temp != head){
                        hm.remove(pSum);
                    }
                }

                start.next = head.next;
            }else{
                hm.put(prefixSum , head);
            }
            head = head.next;
        }

        return dummy.next;
    }
}