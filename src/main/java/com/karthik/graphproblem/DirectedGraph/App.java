package com.karthik.graphproblem.DirectedGraph;

import java.util.ArrayList;
import com.karthik.graphproblem.DirectedGraph.domain.Edge;
import com.karthik.graphproblem.DirectedGraph.domain.Node;
import com.karthik.graphproblem.DirectedGraph.service.Graph;

/**
 * Hello world!
 *
 */


public class App 
{
	static Graph graph;
	static Node a, b, c, d, e;
	
    public static void main( String[] args ) throws Exception
    {
    	graph = new Graph(); //Build graph
    	 
		a = new Node("A");
		b = new Node("B");
		c = new Node("C");
		d = new Node("D");
		e = new Node("E");
 
		//Graph: AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7*/
		graph.put(a, new Edge(a, b, 5).next(new Edge(a, d, 5).next(new Edge(a, e, 7))));
		graph.put(b, new Edge(b, c, 4));
		graph.put(c, new Edge(c, d, 8).next(new Edge(c, e, 2)));
		graph.put(d, new Edge(d, c, 8).next(new Edge(d, e, 6)));
		graph.put(e, new Edge(e, b, 3));
		
		
		ArrayList<Node> solution1 = new ArrayList<Node>(); 
		solution1.add(a);
		solution1.add(b);
		solution1.add(c);
		System.out.println("Answer 1 : "+graph.distanceBetween(solution1));
		
		ArrayList<Node> solution2 = new ArrayList<Node>(); 
		solution2.add(a);
		solution2.add(d);
		System.out.println("Answer 2 : "+graph.distanceBetween(solution2));

		
		ArrayList<Node> solution3 = new ArrayList<Node>(); 
		solution3.add(a);
		solution3.add(d);
		solution3.add(c);
		System.out.println("Answer 3 : "+graph.distanceBetween(solution3));

		
		ArrayList<Node> solution4 = new ArrayList<Node>(); 
		solution4.add(a);
		solution4.add(e);
		solution4.add(b);
		solution4.add(c);
		solution4.add(d);
		System.out.println("Answer 4 : "+graph.distanceBetween(solution4));

		
		ArrayList<Node> solution5 = new ArrayList<Node>(); 
		solution5.add(a);
		solution5.add(e);
		solution5.add(d);
		try{
			System.out.println("Answer 5 : "+graph.distanceBetween(solution5));
		}catch (Exception e){
			System.out.println("Answer 5 : "+"No Route Found");
		}

		System.out.println("Answer 8 : "+graph.DijkstrasShortroute(a, c,0,0));
		System.out.println("Answer 9 : "+graph.DijkstrasShortroute(b, b,0,0));
	}
    
  }
