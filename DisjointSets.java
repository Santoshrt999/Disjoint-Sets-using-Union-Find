package com.graphs;
import java.util.*;

public class DisjointSets {
	
	private Map<Integer, TreeNode> map = new HashMap<>();
	
	class TreeNode{
		int data;
		int rank;
		TreeNode parent;
	}
	
	/**
	 * Create a set with single data
	 * @param args
	 */
	public void makeSet(int data) {
		TreeNode node = new TreeNode();
		node.data=data;
		node.parent=node;
		node.rank=0;
		map.put(data, node);
	}
	
	public boolean union(int data1, int data2) {
		TreeNode node1 = map.get(data1);
		TreeNode node2 = map.get(data2);
		
		TreeNode parent = findSet(node1);
		TreeNode parent2 = findSet(node2);
		
		//if they are part of same set
		if(parent.data == parent2.data)
			return false;
		
		if(parent.rank >= parent2.rank) {
			
			parent.rank = (parent.rank == parent2.rank) ? parent.rank +1 : parent.rank;
			parent2.parent=parent;
		} else {
			parent.parent = parent2;
		}
		
		
		return true;
	}
	
	public int findSet(int data) {
		return findSet(map.get(data)).data;
	}
	
	
	//find parent
    private TreeNode findSet(TreeNode node) {
    	TreeNode parent = node.parent;
    	if(parent == node)
    		return parent;
    	
    	
    	node.parent = findSet(node.parent);
    	return node.parent;
    	
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        DisjointSets ds = new DisjointSets();
        ds.makeSet(1);
        ds.makeSet(2);
        ds.makeSet(3);
        ds.makeSet(4);
        ds.makeSet(5);
        ds.makeSet(6);
        ds.makeSet(7);

        ds.union(1, 2);
        ds.union(2, 3);
        ds.union(4, 5);
        ds.union(6, 7);
        ds.union(5, 6);
        ds.union(3, 7);

        System.out.println(ds.findSet(1));
        System.out.println(ds.findSet(2));
        System.out.println(ds.findSet(3));
        System.out.println(ds.findSet(4));
        System.out.println(ds.findSet(5));
        System.out.println(ds.findSet(6));
        System.out.println(ds.findSet(7));

	}

}
