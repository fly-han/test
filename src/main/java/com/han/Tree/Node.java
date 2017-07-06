package com.han.Tree;

/**
 * Created by hanfei3 on 2017/6/27.
 */
public class Node {
    String value;
    Node left;
    Node right;

    public Node(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" + "value=" + value + '}';
    }

}
