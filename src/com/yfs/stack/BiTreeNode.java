package com.yfs.stack;

public class BiTreeNode {
    private String name;
    private BiTreeNode left;
    private BiTreeNode right;

    public BiTreeNode() {
    }

    public BiTreeNode(String name, BiTreeNode left, BiTreeNode right) {
        this.name = name;
        this.left = left;
        this.right = right;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BiTreeNode getLeft() {
        return left;
    }

    public void setLeft(BiTreeNode left) {
        this.left = left;
    }

    public BiTreeNode getRight() {
        return right;
    }

    public void setRight(BiTreeNode right) {
        this.right = right;
    }
}
