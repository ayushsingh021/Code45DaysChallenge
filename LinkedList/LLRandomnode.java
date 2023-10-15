// Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.

// Implement the Solution class:

// Solution(ListNode head) Initializes the object with the head of the singly-linked list head.
// int getRandom() Chooses a node randomly from the list and returns its value. All the nodes of the list should be equally likely to be chosen.
 

// Example 1:


// Input
// ["Solution", "getRandom", "getRandom", "getRandom", "getRandom", "getRandom"]
// [[[1, 2, 3]], [], [], [], [], []]
// Output
// [null, 1, 3, 2, 2, 3]


class Solution {

    ArrayList<Integer> arr = new ArrayList<>();
    public Solution(ListNode head) {
        ListNode temp = head;
        while(temp != null){
            arr.add(temp.val);
            temp = temp.next;
        }

    }
    
    public int getRandom() {
        int n = arr.size();

        int ran_Idx = ((int)(Math.random()*n)%n);
        return arr.get(ran_Idx);
    }
}
