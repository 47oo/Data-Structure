package com.search.base.binarytree;

import java.util.LinkedList;
import java.util.Queue;

import com.sort.util.Utils;

/**
 * 2 1 3
 * 
 * @author 47
 */
public class BinaryTree<K extends Comparable<K>, V> {

	private class Node {
		K key;
		V value;
		Node left;
		Node right;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
			this.left = null;
			this.right = null;
		}
		public Node(Node node){
			this.left = node.left;
			this.right = node.right;
			this.key = node.key;
			this.value = node.value;
		}
	}

	private Node root;
	private int count;

	public BinaryTree() {
		root = null;
		count = 0;
	}

	public void insert(K key, V value) {
		root = insert(root, key, value);
	}

	public boolean contain(K key) {
		return contain(root, key);
	}

	public V search(K key) {
		return (V) search(root, key);
	}

	// 以node为节点进行先序遍历
	public void preOrder() {
		preOrder(root);
	}

	private void preOrder(Node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.value + " ");
		preOrder(node.left);
		preOrder(node.right);
	}

	// 以node为节点进行中序遍历
	public void inOrder() {
		inOrder(root);
	}

	private void inOrder(Node node) {
		if (node == null) {
			return;
		}
		inOrder(node.left);
		System.out.print(node.value + " ");
		inOrder(node.right);
	}

	// 以node为节点进行后序遍历
	public void postOrder() {
		postOrder(root);
	}

	private void postOrder(Node node) {
		if (node == null) {
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.value + " ");
	}

	// 以node为起点进行层序遍历
	public void levelOrder() {
		levelOrder(root);
	}

	private void levelOrder(Node node) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		while (!queue.isEmpty()) {
			Node top = queue.poll();
			System.out.print(top.value + " ");
			if (top.left != null) {
				queue.add(top.left);
			}
			if (top.right != null) {
				queue.add(top.right);
			}
		}
	}

	// 寻找最小值
	public K minKey() {
		if (count == 0) {
			throw new RuntimeException("没有数据了");
		}
		Node min = minKey(root);
		return min.key;
	}

	private Node minKey(Node node) {
		if (node.left == null) {
			return node;
		}
		return minKey(node.left);
	}

	// 寻找最大值
	public K maxKey() {
		if (count == 0) {
			throw new RuntimeException("没有数据了");
		}
		Node max = maxKey(root);
		return max.key;
	}

	private Node maxKey(Node node) {
		if (node.right == null) {
			return node;
		}
		return maxKey(node.right);
	}

	// 删除最小key,返回删除节点后新的树的根
	public void removeMinKey() {
		if (count == 0) {
			throw new RuntimeException("没有数据了");
		}
		count--;
		root = removeMinKey(root);
	}

	private Node removeMinKey(Node node) {
		if (node.left == null) {

			return node.right;
		}
		node.left = removeMinKey(node.left);
		return node;
	}
	//删除最大key
	public void removeMaxKey(){
		if (count == 0) {
			throw new RuntimeException("没有数据了");
		}
		count--;
		root = removeMaxKey(root);
	}
	private Node removeMaxKey(Node node) {
		if(node.right==null){
			return node.left;
		}
		node.right = removeMaxKey(node.right);
		return node;
	}
	//从二叉树中删除键值为key的节点
	public void removeKey(K key){
		root = removeKey(root,key);
	}
	private Node removeKey(Node node, K key) {
		if(node==null){
			return null;
		}
		if(Utils.aLb(key, node.key)){
			node.left = removeKey(node.left,key);
			return node;
		}else if(Utils.aRb(key, node.key)){
			node.right = removeKey(node.right,key);
			return node;
		}else{
			if(node.left==null){
				count--;
				return node.right;
			}
			if(node.right==null){
				return node.left;
			}
			//当左右节点都不为null的时候
			Node successor = new Node(minKey(node.right));
			count++;
			
			successor.right = removeMinKey(node.right);
			successor.left = node.left;
			count--;
			return successor;
		}
	}

	private V search(Node node, K key) {
		if (node == null) {
			return null;
		}
		if (Utils.aEb(key, node.key)) {
			return node.value;
		} else if (Utils.aLb(key, node.key)) {
			return search(node.left, key);
		} else {
			return search(node.right, key);
		}
	}

	private boolean contain(Node node, K key) {
		if (node == null) {
			return false;
		}
		if (Utils.aEb(key, node.key)) {
			return true;
		} else if (Utils.aLb(key, node.key)) {
			return contain(node.left, key);
		} else {
			return contain(node.right, key);
		}
	}

	private Node insert(Node node, K key, V value) {
		if (node == null) {
			count++;
			return new Node(key, value);
		}
		if (Utils.aEb(key, node.key)) {
			node.value = value;
		} else if (Utils.aLb(key, node.key)) {
			node.left = insert(node.left, key, value);
		} else {
			node.right = insert(node.right, key, value);
		}
		return node;
	}

	public int size() {
		return count;
	}

	public boolean isEmpty() {
		return count == 0;
	}

	public static void main(String[] args) {
		Integer[] arr = { 1, 4, 6, 7, 9, 3 };
		BinaryTree<Integer, String> bt = new BinaryTree<>();
		for (int i = 0; i < arr.length; i++) {
			bt.insert(arr[i], "value: " + arr[i]);
		}
		System.out.println(bt.contain(2));
		System.out.println(bt.search(2));
		bt.preOrder();
		System.out.println("====");
		bt.inOrder();
		System.out.println("====");
		bt.postOrder();
		System.out.println("====");
		bt.levelOrder();
		System.out.println("====");
//		bt.removeMaxKey();
//		System.out.println(bt.size());
		bt.removeKey(1);
		System.out.println("====");
		bt.preOrder();
	}
}
