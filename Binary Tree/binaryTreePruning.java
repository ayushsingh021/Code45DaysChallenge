// Given the root of a binary tree, return the same tree where every subtree (of the given tree) not containing a 1 has been removed.

// A subtree of a node node is node plus every node that is a descendant of node.

 

// Example 1:


// Input: root = [1,null,0,0,1]
// Output: [1,null,0,null,1]
// Explanation: 
// Only the red nodes satisfy the property "every subtree not containing a 1".
// The diagram on the right represents the answer.

//T.C = O(n^2)
class Solution {
    public static boolean isOne(TreeNode root){
        if(root == null) return false;
        if(root.val == 1){
            return true;
        }
        boolean leftV = isOne(root.left);
        boolean rightV = isOne(root.right);
        return leftV || rightV;

    }
   
    public TreeNode pruneTree(TreeNode root) {
       if(root == null) return null;
       if(!isOne(root.left)) {
           root.left = null;
       }
        if(!isOne(root.right)) {
           root.right = null;
       }

       pruneTree(root.left);
       pruneTree(root.right);

       if(root.left == null && root.right == null && root.val == 0){
           return null;
       }
       return root;


    }
}


//Single iternation -- O(n)

class Solution {
    public static boolean isOne(TreeNode root){
        if(root == null) return false;
        boolean leftV = isOne(root.left);
        boolean rightV = isOne(root.right);
        if(!leftV) {
            root.left = null;
        }
        if(!rightV ){
            root.right = null;
        }
        return leftV || rightV || (root.val==1);

    }
   
    public TreeNode pruneTree(TreeNode root) {
       return isOne(root) == false ? null : root ;

    }