package com.kumarp.solution;



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cycledetection {
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


	public static boolean bfsTraversal(int startNode) {
		LinkedList<int []> ll = new LinkedList<int []>();
		int[] visitedNode = new int[adj_array.length];
		ArrayList<Integer> bfs = new ArrayList<Integer>();
		ll.add(new int []{startNode,-1});
		visitedNode[startNode] = 1;

		while (!ll.isEmpty()) {
			int [] node = (int[]) ll.pop();
			int bfsNode = node[0];
			int parentNode=node[1];
			bfs.add(bfsNode);
			ArrayList<Integer> al = (ArrayList<Integer>) adj_array[bfsNode];
			for (int k = 0; k < al.size(); k++) {
				if (visitedNode[al.get(k)] == 0) {
					int index = al.get(k);
					ll.addLast(new int [] {index,bfsNode});
					visitedNode[index] = 1;
				}else if (parentNode!=al.get(k)) {
					return true;
				}

			}

		}
		
		return false;

	}

	public static void main(String[] args) {
		buildgraph();
		displaygraph();
//		logger.info("Total number of connected components- " + findConnectedComponent());
		System.out.println(bfsTraversal(1));
	}

}
