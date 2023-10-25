// Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.

// A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.

 

// Example 1:


// Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
// Output: [[5,4,11,2],[5,8,4,5]]
// Explanation: There are two paths whose sum equals targetSum:
// 5 + 4 + 11 + 2 = 22
// 5 + 8 + 4 + 5 = 22

//important way of traversing and using recursion in Tree ques

class Solution {
    public static void solve( TreeNode root, int targetSum, List<Integer>ds , List<List<Integer>> ans){
        if(root == null){
            return;
        }
        ds.add(root.val);
        if(root.left == null && root.right == null && root.val == targetSum){
            ans.add(new ArrayList<>(ds));
        }

        solve(root.left , targetSum - root.val, ds , ans);
        solve(root.right , targetSum - root.val, ds , ans);
        ds.remove(ds.size()-1);

    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
       
        solve(root , targetSum, new ArrayList<>() , ans);
        return ans;
    }
}