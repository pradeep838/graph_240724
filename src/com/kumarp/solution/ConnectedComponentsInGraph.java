package com.kumarp.solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectedComponentsInGraph {
	private static List[] adj_array;
	private static Logger logger = Logger.getLogger("graph");
	static int[] visitedNode;

	public static List[] buildgraph() {
		logger.setLevel(Level.INFO);
		System.out.println("enter number of nodes");
		int input = new Scanner(System.in).nextInt();
		adj_array = new ArrayList[input];
		visitedNode = new int[input];
		logger.info(" " + adj_array.length);
		for (int i = 0; i < input; i++) {
			String connection = new Scanner(System.in).nextLine();
			adj_array[i] = new ArrayList<Integer>();
			for (String item : connection.split(" ")) {
				adj_array[i].add(Integer.parseInt(item));
			}

		}
		return adj_array;
	}

	public static void displaygraph() {
		for (List array : adj_array) {
			logger.info(array.toString());
		}

	}

	public static int findConnectedComponent() {
		int connectedComp = 0;
		for (int i = 0; i < visitedNode.length; i++) {
			if (visitedNode[i] == 0) {
				connectedComp++;
				dfsTraversal(i);
			}

		}
		return connectedComp;

	}

	public static void dfsTraversal(int i) {
		if (visitedNode[i] == 1) {
			return;
		} else {
			visitedNode[i] = 1;
			ArrayList<Integer> al = (ArrayList<Integer>) adj_array[i];
			for (int k = 0; k < al.size(); k++) {
				Integer index = al.get(k);
				dfsTraversal(index);

			}

		}

	}

	public static void bfsTraversal(int startNode) {
		LinkedList<Integer> ll = new LinkedList<Integer>();
		int[] visitedNode = new int[adj_array.length];
		ArrayList<Integer> bfs = new ArrayList<Integer>();
		ll.add(startNode);
		visitedNode[startNode] = 1;

		while (!ll.isEmpty()) {
			int bfsNode = (int) ll.pop();
			bfs.add(bfsNode);
			ArrayList<Integer> al = (ArrayList<Integer>) adj_array[bfsNode];
			for (int k = 0; k < al.size(); k++) {
				if (visitedNode[al.get(k)] == 0) {
					int index = al.get(k);
					ll.addLast(index);
					visitedNode[index] = 1;
				}

			}

		}
		System.out.println(bfs + "traversal");

	}

	public static void main(String[] args) {
		buildgraph();
		displaygraph();
//		logger.info("Total number of connected components- " + findConnectedComponent());
		bfsTraversal(4);
	}

}
