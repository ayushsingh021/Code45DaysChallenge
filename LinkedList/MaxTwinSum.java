// In a linked list of size n, where n is even, the ith node (0-indexed) of the linked list is known as the twin of the (n-1-i)th node, if 0 <= i <= (n / 2) - 1.

// For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the twin of node 2. These are the only nodes with twins for n = 4.
// The twin sum is defined as the sum of a node and its twin.

// Given the head of a linked list with even length, return the maximum twin sum of the linked list.

 

// Example 1:


// Input: head = [5,4,2,1]
// Output: 6
// Explanation:
// Nodes 0 and 1 are the twins of nodes 3 and 2, respectively. All have twin sum = 6.
// There are no other nodes with twins in the linked list.
// Thus, the maximum twin sum of the linked list is 6. 
// Example 2:


// Input: head = [4,2,2,3]
// Output: 7
// Explanation:
// The nodes with twins present in this linked list are:
// - Node 0 is the twin of node 3 having a twin sum of 4 + 3 = 7.
// - Node 1 is the twin of node 2 having a twin sum of 2 + 2 = 4.
// Thus, the maximum twin sum of the linked list is max(7, 4) = 7. 

class Solution {
    public int pairSum(ListNode head) {
        int n = 0 ;
        ListNode temp = head;
        while(temp != null){
            n++;
            temp = temp.next;
        }
        int arr[] = new int[n];
        temp = head;
        for(int i = 0 ; i < n ; i++){
            arr[i] = temp.val;
            temp = temp.next;
        }

        int i = 0 ; 
        int j = n-1;
        int ans = Integer.MIN_VALUE;
        while(i<j){
            int sum = arr[i] + arr[j];
            if(sum > ans){
                ans = sum;
            }
            i++;
            j--;
        }
        return ans;
    }

}

//Approach-2 (Using Stack)
class Solution {
public:
    int pairSum(ListNode* head) {
        stack<int> st;
        ListNode* curr = head;
        
        while(curr) {
            st.push(curr->val);
            curr = curr->next;
        }
        
        curr = head;
        int count = 1;
        int N = st.size();
        int result = 0;
        
        while(count <= N/2) {
            result = max(result, curr->val + st.top());
            curr = curr->next;
            st.pop();
            count++;
        }
        
        return result;
    }
};


//Approach-3 (Reversing the second half of the linkedlist)
class Solution {
public:
    int pairSum(ListNode* head) {
        ListNode* mid = NULL;
        
        ListNode* slow = head;
        ListNode* fast = head;
        
        while(fast && fast->next) {
            slow = slow->next;
            fast = fast->next->next;
        }
        mid = slow;
        
        //Reversing Part
        ListNode* nextNode = NULL;
        ListNode* prev = NULL;
        while(mid) {
            nextNode = mid->next;
            mid->next = prev;
            prev = mid;
            mid = nextNode;
        }
        //Reversing Part
        
        ListNode* curr = head;
        int result = 0;
        while(prev) {
            result = max(result, curr->val + prev->val);
            curr = curr->next;
            prev = prev->next;
        }
        
        return result;
        
    }
};