package datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

For example, you may serialize the following tree

    1
   / \
  2   3
     / \
    4   5

as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless. 
 * @author VictorQian
 *
 */
public class SerializeDeserializeBinaryTree {
	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
    	if (root == null) return "null";
        StringBuilder tree = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                tree.append("null,");
            }
            else {
                tree.append(node.val).append(',');
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        tree.deleteCharAt(tree.length()-1);
        return tree.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	String[] nodes = data.split("\\,");
        if (nodes.length == 1) return null;

        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int i = 1;           // starting from the second node if root is not null
        while (i < nodes.length) {
            TreeNode node = queue.poll();
            String left = nodes[i++], right = nodes[i++];
            if (!left.equals("null")) {
                TreeNode lChild = new TreeNode(Integer.parseInt(left));
                node.left = lChild;
                queue.offer(lChild);
            }
            if (!right.equals("null")) {
                TreeNode rChild = new TreeNode(Integer.parseInt(right));
                node.right = rChild;
                queue.offer(rChild);
            }
        }
        return root;
    }
    
    public static void main(String[] args){
    	SerializeDeserializeBinaryTree s = new SerializeDeserializeBinaryTree();

//    	TreeNode t = new TreeNode(1);
//    	t.left=new TreeNode(2);
//    	//t.left.left=new TreeNode(21);
//    	t.right=new TreeNode(3);
//    	t.right.left=new TreeNode(4);
//    	t.right.right=new TreeNode(5);
//    	System.out.println(s.serialize(t));
//    	TreeNode t1 = s.deserialize(s.serialize(t));
//    	System.out.println(s.serialize(t1));
    	TreeNode t = s.deserialize("1,null,2,null,3,null,4,null,5,null,6");
    	System.out.println();
    	System.out.println(s.serialize(t));
    }
}
