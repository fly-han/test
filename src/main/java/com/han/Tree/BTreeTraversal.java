package com.han.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 逐层遍历一棵二叉树，要求相邻两层遍历方向相反
 * Created by hanfei3 on 2017/6/27.
 */
public class BTreeTraversal {
    public static void main(String[] args) {
        Node root = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        root.setLeft(b);
        root.setRight(c);
        Node d = new Node("d");
        Node e = new Node("e");
        b.setLeft(d);
        b.setRight(e);
        Node f = new Node("f");
        c.setLeft(f);
        Node g = new Node("g");
        Node h = new Node("h");
        d.setLeft(g);
        d.setRight(h);
        Node i = new Node("i");
        Node j = new Node("j");
        f.setLeft(i);
        f.setRight(j);
        Node k = new Node("k");
        Node l = new Node("l");
        j.setLeft(k);
        j.setRight(l);
        traversal(root);
    }

    public static void traversal(Node root) {
        List<Node> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        boolean status = true;
        Stack<Node> layerNodes = stack;
        while (layerNodes.size() > 0) {
            result.addAll(layerNodes);
            layerNodes = getNextLayer(layerNodes, status);
            status = !status;
        }
        System.out.println(result);
    }

    public static Stack<Node> getNextLayer(Stack<Node> stack, boolean status) {
        Stack<Node> layerNodes = new Stack();
        while (stack.size() > 0) {
            Node node = stack.pop();
            if (status) {
                if (node.right != null) {
                    layerNodes.add(node.right);
                }
                if (node.left != null) {
                    layerNodes.add(node.left);
                }
            } else {
                if (node.left != null) {
                    layerNodes.add(node.left);
                }
                if (node.right != null) {
                    layerNodes.add(node.right);
                }
            }
        }
        return layerNodes;
    }
}
