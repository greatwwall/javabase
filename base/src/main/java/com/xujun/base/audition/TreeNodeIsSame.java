package com.xujun.base.audition;

import java.util.Arrays;

/**
  * 判断两个二叉树是否完全相等
  * @author xujun
  * @version 1.0
  * @date 2018年8月10日 下午9:49:15 
  */

public class TreeNodeIsSame {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        a.left = c;
        b.left = c;

        boolean flag = isSame(a, b);
        System.out.println(flag);

        // test System.arraycopy
        int[] aa = new int[7];
        aa[0] = 1;
        aa[2] = 2;
        int[] bb = {4, 5};
        System.arraycopy(bb, 0, aa, 3, 2);
        System.out.println(Arrays.toString(aa));
    }

    /**
      * @todo 
      * @param a
      * @param b
      * @return
      * @return boolean
      */
    private static boolean isSame(TreeNode a, TreeNode b) {
        if (a == null && b == null)
            return true;
        if (a != null && b == null)
            return false;
        if (a == null && b != null)
            return false;
        if (a.val != b.val)
            return false;
        else
            return isSame(a.left, b.left) && isSame(a.right, b.right);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            this.val = x;
        }
    }
}
