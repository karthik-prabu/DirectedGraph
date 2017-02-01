package com.karthik.graphproblem.DirectedGraph.domain;


public class Node {
	public String name;
	public boolean visited;
 
	public Node(String name) {
		this.name = name;
		this.visited = false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
	
}
