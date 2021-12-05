package com.data.geektime.week03;

// 106. 从中序与后序遍历序列构造二叉树
public class Solution106 {
  int[] inorder;
  int[] postorder;

  public TreeNode buildTree(int[] inorder, int[] postorder) {
    this.inorder = inorder;
    this.postorder = postorder;

    return build(0, inorder.length - 1, 0, postorder.length - 1);
  }

  // 由inorder[l1...r1]和postorder[l2...r2]来创建二叉树
  private TreeNode build(int l1, int r1, int l2, int r2) {
    if (l2 > r2) {
      return null;
    }

    TreeNode root = new TreeNode(postorder[r2]);

    // 找root在inorder中的位置
    int mid = l1;
    while (inorder[mid] != root.val) {
      mid++;
    }

    // 构建左右子树
    root.left = build(l1, mid - 1, l2, l2 + mid - l1 - 1);
    root.right = build(mid + 1, r1, l2 + mid - l1, r2 - 1);
    return root;
  }

}
