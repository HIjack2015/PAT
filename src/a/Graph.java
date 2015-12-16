package a;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Graph {
	public static final Cost INFINITY = new Cost(Integer.MAX_VALUE,
			Integer.MAX_VALUE);
	public static final Cost NO_COST = new Cost(0, 0);

	private Map<String, Vertex> vertexMap = new HashMap<String, Vertex>();

	public void addEdge(String sourceName, String destName, Cost cost) {
		Vertex from = getVertex(sourceName);
		Vertex dest = getVertex(destName);
		from.adj.add(new Edge(dest, cost));
	}

	public void dijkstra(String startName) {
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		Vertex start = vertexMap.get(startName);
		if (start == null) {
			System.err.println("no such start");
		}
		clearAll();
		pq.add(new Edge(start, NO_COST));
		start.cost = NO_COST;
		int nodeSeen = 0;
		while (!pq.isEmpty() && nodeSeen < vertexMap.size()) {
			Edge path = pq.remove();
			Vertex vertex = path.dest;
			if (vertex.scratch != 0) {
				continue;
			}
			vertex.scratch = 1;
			nodeSeen++;
			for (Edge edge : vertex.adj) {
				Vertex next = edge.dest;
				Cost cost = edge.cost;
				Cost addCost = cost.add(vertex.cost);
				if (next.cost.compareTo(addCost) > 0) {
					next.cost = addCost;
					next.pre = vertex;
					pq.add(new Edge(next, next.cost));
				}
			}

		}

	}

	public Cost getCost(String destName) {
		return vertexMap.get(destName).cost;
	}

	private Vertex getVertex(String vertexName) {
		Vertex vertex = vertexMap.get(vertexName);
		if (vertex == null) {
			vertex = new Vertex(vertexName);
			vertexMap.put(vertexName, vertex);
		}
		return vertex;
	}

	private void clearAll() {
		for (Vertex v : vertexMap.values()) {
			v.reset();
		}
	}

	public void printPath(String destName) {
		Vertex destVertex = vertexMap.get(destName);
		printPath(destVertex);
	}

	public List<String> getPath(String destName) {
		List<String> pathList = new LinkedList<String>();
		pathList.add(destName);
		Vertex destVertex = vertexMap.get(destName);
		while (destVertex.pre != null) {
			pathList.add(0, destVertex.pre.name);
			destVertex = destVertex.pre;
		}
		return pathList;
	}

	private void printPath(Vertex dest) {
		if (dest.pre != null) {
			printPath(dest.pre);
			System.out.print(" to ");
		}
		System.out.print(dest.name);
	}

	public class Edge implements Comparable<Edge> {
		public Vertex dest;
		public Cost cost;

		public Edge(Vertex dest, int length, int money) {
			cost = new Cost(length, money);
			this.dest = dest;
		}

		public Edge(Vertex dest, Cost cost) {
			this.dest = dest;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return cost.compareTo(o.cost);
		}
	}

	static class Vertex {
		public String name;
		public List<Edge> adj;
		public Cost cost;
		public Vertex pre;
		public int scratch;

		public Vertex(String name) {
			this.name = name;
			adj = new LinkedList<Edge>();
			reset();
		}

		public void reset() {
			cost = INFINITY;
			pre = null;
			scratch = 0;
		}
	}

	public static class Cost implements Comparable<Cost> {
		public int length;
		public int money;

		public Cost(int length, int money) {
			super();
			this.length = length;
			this.money = money;
		}

		@Override
		public int compareTo(Cost o) {
			if (length < o.length || (length == o.length && money < o.money)) {
				return -1;
			}
			if (length == o.length && money == o.money) {
				return 0;
			}

			return 1;

		}

		public Cost add(Cost cost) {
			int length = this.length + cost.length;
			int money = this.money + cost.money;
			Cost addCost = new Cost(length, money);
			return addCost;

		}

	}

}
