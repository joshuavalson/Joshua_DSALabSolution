package com.Lab3Solution2.controller;

import java.util.HashSet;
import java.util.Set;

public class BSTSumFinder {
    static class Node {
        int nodeData;
        Node leftNode, rightNode;
    };

    static Node newNode(int nodeData) {
        Node tempNode = new Node();
        tempNode.nodeData = nodeData;
        tempNode.leftNode = null;
        tempNode.rightNode = null;
        return tempNode;
    }

    public Node insertNode(Node root, int key) {

        if (root == null) {
            return newNode(key);
        }
        if (key < root.nodeData) {
            root.leftNode = insertNode(root.leftNode, key);
        } else {
            root.rightNode = insertNode(root.rightNode, key);
        }
        return root;
    }

    public boolean findPair(Node root, int sum, Set<Integer> set) {

        if (root == null) {
            return false;
        }
        if (findPair(root.leftNode, sum, set)) {
            return true;
        }
        if (set.contains(sum - root.nodeData)) {
            System.out.println("Pair is found : (" + (sum - root.nodeData) + ", " + root.nodeData + ")");
            return true;
        } else {
            set.add(root.nodeData);
        }
        return findPair(root.rightNode, sum, set);
    }

    public void findPairWithGivenSum(Node root, int sum) {
        Set<Integer> nodesSet = new HashSet<Integer>();
        if (!findPair(root, sum, nodesSet)) {
            System.out.println("Pair does not exist!");
        }
    }

    public static void main(String[] args) {
        BSTSumFinder bstSumFinder = new BSTSumFinder();
        Node root = null;
        /*
                    40
                 /      \
               20        60
             /   \      /   \
            10   30    50   70    */
        root = bstSumFinder.insertNode(root, 40);
        root = bstSumFinder.insertNode(root, 20);
        root = bstSumFinder.insertNode(root, 60);
        root = bstSumFinder.insertNode(root, 10);
        root = bstSumFinder.insertNode(root, 30);
        root = bstSumFinder.insertNode(root, 50);
        root = bstSumFinder.insertNode(root, 70);

        int inputSum = 70;

        bstSumFinder.findPairWithGivenSum(root, inputSum);

    }
}
