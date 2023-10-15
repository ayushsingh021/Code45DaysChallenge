// Given the head of a singly linked list where elements are sorted in ascending order, convert it to a 
// height-balanced
//  binary search tree.

 

// Example 1:


// Input: head = [-10,-3,0,5,9]
// Output: [0,-3,9,-10,null,5]
// Explanation: One possible answer is [0,-3,9,-10,null,5], which represents the shown height balanced BST.


class Solution {
    public TreeNode solve(int[] arr, int si , int ei){
          if(si>ei){
            return null;
        }
        int mid = (si + ei)/2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = solve(arr, si, mid -1);
        root.right = solve(arr, mid+1, ei);
        
        return root;

    }
    public TreeNode sortedListToBST(ListNode head) {
        ListNode temp = head;
        int size = 0;
        while(temp != null){
            temp = temp.next;
            size++;
        }
       int arr[] = new int[size];
       ListNode dummy = head;
       int i =0 ;
       while(dummy != null){
           arr[i] = dummy.val;
           dummy = dummy.next;
           i++;
       }
       TreeNode ans = solve(arr , 0 , arr.length-1);
       return ans;
    }
}

//another approach

/*
    MY YOUTUBE VIDEO ON THIS Qn : https://www.youtube.com/watch?v=4zvmruet_H0
    Company Tags                : Google, Flipkart, Amazon
    Leetcode Link               : https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
*/

/*
Time complexity: O(n log(n)).
There are log(n) recursive levels because each time we split it to half, and in each level we loop through the whole list, divided into small parts.
Space complexity: O(log(n)).
We don't consider the returning tree as extra space, but we have log(n) recursive calls on stack.
*/
class Solution {
public:
    TreeNode* sortedListToBST(ListNode* head) {
        if(!head)
            return NULL;
        if(!head->next)
            return new TreeNode(head->val);
        
        //Find mid and make it root
        ListNode* slow = head;
        ListNode* fast = head;
        ListNode* slow_prev = NULL;
        while(fast && fast->next) {
            slow_prev = slow;
            slow = slow->next;
            fast = fast->next->next;
        }
        
        
        TreeNode* root = new TreeNode(slow->val); //Make root
        slow_prev->next = NULL; //We only want left half of linked list for left subtree
        
        root->left  = sortedListToBST(head);       //Make left subtree
        root->right = sortedListToBST(slow->next); //Make right subtree
        
        return root; //return root
        
    }
};