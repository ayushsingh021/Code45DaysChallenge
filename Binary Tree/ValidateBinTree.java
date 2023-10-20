// You have n binary tree nodes numbered from 0 to n - 1 where node i has two children leftChild[i] and rightChild[i], return true if and only if all the given nodes form exactly one valid binary tree.

// If node i has no left child then leftChild[i] will equal -1, similarly for the right child.

// Note that the nodes have no values and that we only use the node numbers in this problem.

 

// Example 1:


// Input: n = 4, leftChild = [1,-1,3,-1], rightChild = [2,-1,-1,-1]
// Output: true
// Example 2:


// Input: n = 4, leftChild = [1,-1,3,-1], rightChild = [2,3,-1,-1]
// Output: false

// Properties of Binary Tree
//1.Every child -- Only one parent
//2.Only one root --it has no parent
//3.Connected only one component

class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        Map<Integer, Integer> hm = new HashMap<>();

        //Child to Parent Map create which one is not present in map is root
        for (int i = 0; i < n; i++) {
            int node = i;
            int leftChildNode = leftChild[i];
            int rightChildNode = rightChild[i];

            if (leftChildNode != -1) {
                adj.computeIfAbsent(node, k -> new ArrayList<>()).add(leftChildNode);

                if (hm.containsKey(leftChildNode)) {
                    return false;
                } else {
                    hm.put(leftChildNode, node);
                }
            }

            if (rightChildNode != -1) {
                adj.computeIfAbsent(node, k -> new ArrayList<>()).add(rightChildNode);

                if (hm.containsKey(rightChildNode)) {
                    return false;
                } else {
                    hm.put(rightChildNode, node);
                }
            }
        }

        int root = -1;
    //root finding
        for (int i = 0; i < n; i++) {
            if (!hm.containsKey(i)) {
                if (root != -1) {
                    return false;
                } else {
                    root = i;
                }
            }
        }
        if (root == -1) {
            return false;
        }

    //DFS
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        int count = 1;
        queue.add(root);
        visited[root] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int child : adj.getOrDefault(node, Collections.emptyList())) {
                if (!visited[child]) {
                    visited[child] = true;
                    count++;
                    queue.add(child);
                }
            }
        }
        if(count != n) return false;

        return true;
}
}

