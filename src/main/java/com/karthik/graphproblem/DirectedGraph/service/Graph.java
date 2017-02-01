package com.karthik.graphproblem.DirectedGraph.service;

import java.util.ArrayList;
import java.util.Hashtable;

import com.karthik.graphproblem.DirectedGraph.domain.Edge;
import com.karthik.graphproblem.DirectedGraph.domain.Node;

public class Graph {
	public Hashtable<Node, Edge> graph;
 
	public Graph() {
		this.graph = new Hashtable<Node, Edge>();
	}
	
	public void put (Node n, Edge e){
		graph.put(n, e);
	}
	
	public int distanceBetween(ArrayList<Node> cities) throws Exception{
		int distance,i;
		int depth = 0;
		distance = i = 0;
		
		while(i < cities.size() - 1) {
			if(this.graph.containsKey(cities.get(i))) {
				Edge route = this.graph.get(cities.get(i));
				while(route != null) {
					if(route.destination.equals(cities.get(i + 1))) {
						distance += route.weight;
						depth++;
						break;
					}
					route = route.next;
				}
			}
			else
				throw new Exception ("No Route Found");
			i++;
		}	 
		if(depth < cities.size() - 1 ){
			throw new Exception ("No Route Found");
		}
		return distance;
	}
	
	public int DijkstrasShortroute(Node start, Node end, int weight, int shortestRoute) throws Exception{
		if(this.graph.containsKey(start) && this.graph.containsKey(end)) {
			start.visited = true;		
			Edge edge = this.graph.get(start);
			while(edge != null) {
				if(edge.destination == end || !edge.destination.visited)
					weight += edge.weight;
 
				if(edge.destination.equals(end)) {
					if(shortestRoute == 0 || weight < shortestRoute)
						shortestRoute = weight;
					start.visited = false;
					return shortestRoute; 			
				}
				else if(!edge.destination.visited) {
					shortestRoute = DijkstrasShortroute(edge.destination, end, weight, shortestRoute);
					weight -= edge.weight;
				}
				edge = edge.next;
			}
		}
		start.visited = false;
		return shortestRoute;	 
	}
}


