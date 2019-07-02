package programmers.kakao;

import org.junit.Test;

import java.util.*;

public class FindingRoute {

    private TreeNode root;

    private TreeNode add(TreeNode node, TreeNode val) {
        if (node == null) {
            return val;
        }
        if (val.x < node.x) {
            node.left = add(node.left, val);
        } else {
            node.right = add(node.right, val);
        }
        return node;
    }
    private void preorder(TreeNode node, int[] list, int[] index) {
        // middle->left -> right
        if (node == null) return;
        list[index[0]++] = node.index;
        preorder(node.left, list, index);
        preorder(node.right, list, index);
    }
    private void postorder(TreeNode node, int[] list, int[] index) {
        // left -> right -> middle
        if (node == null) return;
        postorder(node.left, list, index);
        postorder(node.right, list, index);
        list[index[0]++] = node.index;
    }
    private class YCmparator implements Comparator<TreeNode> {
        @Override
        public int compare(TreeNode a1, TreeNode a2) {
            return a2.y - a1.y;
        }
    }
    public int[][] solution(int[][] nodeinfos) {
        List<TreeNode> list = new LinkedList<>();
        int i = 0;
        // create List of Nodes
        for (int[] nodeinfo: nodeinfos) {
            list.add(new TreeNode(nodeinfo[0], nodeinfo[1], ++i));
        }
        // sort y axis
        Collections.sort(list, new YCmparator());
        for (TreeNode node: list) {
            root = add(root, node);
        }
        int[][] ret = new int[2][nodeinfos.length];
        preorder(root, ret[0], new int[1]);
        postorder(root, ret[1], new int[1]);
        return ret;
    }

    private class TreeNode {
        private int x;
        private int y;
        private int index;
        private TreeNode left;
        private TreeNode right;
        private TreeNode(int x, int y, int index) {
            this.x = x;
            this.y = y;
            this.index = index;
        }
    }

    @Test
    public void test() {
        int[][] nodeinfo = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
        solution(nodeinfo);
    }

}
