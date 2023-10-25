// Given the root of a binary tree, each node in the tree has a distinct value.

// After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).

// Return the roots of the trees in the remaining forest. You may return the result in any order.

 

// Example 1:


// Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
// Output: [[1,2,null,4],[6],[7]]
// Example 2:

// Input: root = [1,2,4,null,3], to_delete = [3]
// Output: [[1,2,4]]
 

//Post Order Traversal  --- bottom to Top approach
 Solution {
    public static TreeNode solve( List<TreeNode> ans, Set<Integer> hs,TreeNode root ){
        if(root == null){
            return null;
        }
        root.left = solve(ans, hs ,root.left);
        root.right = solve(ans,hs , root.right);
        if(hs.contains(root.val)){
            if(root.left != null) ans.add(root.left);
            if(root.right != null) ans.add(root.right);
            return null;
        }else{
            return root;
        }
      
       
    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
       List<TreeNode> ans = new ArrayList<>();
       Set<Integer> hs = new HashSet<>();
       for(int i : to_delete){
           hs.add(i);
       }
       solve(ans , hs , root);
       if(!hs.contains(root.val)){
           ans.add(root);
       }

       return ans;
        
    }
}