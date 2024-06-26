package problem.easy;

import java.util.*;

/**
94. Binary Tree Inorder Traversal

Given the root of a binary tree, return the inorder traversal of its nodes' values.

 { 1 }
   \
    \
    { 2 }        ==> example with "Example 1:"
     /
    /
 { 3 }

Example 1:
----------
Input: root = [1,null,2,3]
Output: [1,3,2]


Example 2:
----------
Input: root = []
Output: []


Example 3:
----------
Input: root = [1]
Output: [1]
 

Constraints:
------------
* The number of nodes in the tree is in the range [0, 100].
* -100 <= Node.val <= 100
 

Follow up: Recursive solution is trivial, could you do it iteratively?
 */

public class Solution_0094 {
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currNode = root;

        while(!stack.isEmpty() || currNode != null){
            while(currNode != null){
                stack.add(currNode);
                currNode = currNode.left;
            }

            currNode = stack.pop();
            list.add(currNode.val);

            currNode = currNode.right;
        }

        return list;
    }
}
