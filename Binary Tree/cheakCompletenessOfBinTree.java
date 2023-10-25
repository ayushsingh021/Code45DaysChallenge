// Given the root of a binary tree, determine if it is a complete binary tree.

// In a complete binary tree, every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

 

// Example 1:


// Input: root = [1,2,3,4,5,6]
// Output: true
// Explanation: Every level before the last is full (ie. levels with node-values {1} and {2, 3}), and all nodes in the last level ({4, 5, 6}) are as far left as possible.
// Example 2:



class Solution {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
      
            boolean past = false;
        while(!q.isEmpty()){
            TreeNode curr = q.remove();
            if(curr == null){
                past = true;
            }else{
                if(past == true) {
                    return false;
                }
                    q.add(curr.left);
                    q.add(curr.right);
            }

       
    }
     
        return  true;
}
}    
