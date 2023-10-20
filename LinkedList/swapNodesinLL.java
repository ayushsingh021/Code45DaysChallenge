// You are given the head of a linked list, and an integer k.

// Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).

 

// Example 1:


// Input: head = [1,2,3,4,5], k = 2
// Output: [1,4,3,2,5]
// Example 2:

// Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
// Output: [7,9,6,6,8,7,3,0,9,5]
 

//In two traversal
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        int size = 0;
        ListNode temp = head;
        while(temp != null){
            temp = temp.next;
            size++;
        }
        ListNode first = head;
        ListNode sec = head;
        int firstK = k;
        while(firstK -- > 1){
            first = first.next;
        }
        int secK = size-k+1;
        while(secK -- >1 ){
            sec = sec.next;
        }
        int tempVal = first.val;
        first.val = sec.val;
        sec.val = tempVal;
        // System.out.print(size);
        return head;
    }
}

//in 1 traversal

class Solution {
public:
    ListNode* swapNodes(ListNode* head, int k) {
        ListNode* p1 = NULL;
        ListNode* p2 = NULL;
        
        ListNode* temp = head;
        
        while(temp) {
            
            if(p2 != NULL)
                p2 = p2->next;
                
            
            k--;
            if(k == 0) {
                p1 = temp;
                p2 = head;
            }
            
            
            temp = temp->next;
            
        }
        
        swap(p1->val, p2->val);
        return head;
    }
};