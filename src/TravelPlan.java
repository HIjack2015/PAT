import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;


public class TravelPlan extends MiddleSolution {
	String startCity;
	String endCity;
	int cityCount;
	Graph g = new Graph();

	@Override
	public void input() {

		cityCount = scanner.nextInt();
		int lineCount = scanner.nextInt();
		startCity = scanner.next();
		endCity = scanner.next();

		while (lineCount > 0) {
			String fromCity = scanner.next();
			String toCity = scanner.next();
			int length = scanner.nextInt();
			int money = scanner.nextInt();
			if (Integer.valueOf(fromCity) >= cityCount
					|| Integer.valueOf(endCity) >= cityCount) {
				lineCount--;
				continue;
			}
			g.addEdge(fromCity, toCity, new Graph.Cost(length, money));

			lineCount--;
		}
	}

	@Override
	public void deal() throws Exception {
		g.dijkstra(startCity, endCity);

	}

	@Override
	public void output() {

		System.out.print(printListWithSpace(g.getPath(startCity, endCity)));

		Graph.Cost cost = g.getCost(endCity);
		System.out.print(" " + cost.length + " " + cost.money);

	}
}

class Graph {
	public static final Cost INFINITY = new Cost(Integer.MAX_VALUE / 2,
			Integer.MAX_VALUE / 2);
	public static final Cost NO_COST = new Cost(0, 0);

	private Map<String, Vertex> vertexMap = new HashMap<String, Vertex>();

	public void addEdge(String sourceName, String destName, Cost cost) {
		Vertex from = getVertex(sourceName);
		Vertex dest = getVertex(destName);
		from.adj.add(new Edge(dest, cost));
	}

	public void dijkstra(String startName, String destName) throws Exception {

		PriorityQueue<Path> pq = new PriorityQueue<Path>();
		Vertex start = vertexMap.get(startName);
		Vertex end = vertexMap.get(destName);
		if (start == null || end == null) {
			throw new Exception();
		}
		clearAll();
		pq.add(new Path(start, NO_COST));
		start.cost = NO_COST;

		while (!pq.isEmpty()) {
			Path path = pq.remove();
			Vertex vertex = path.dest;
			if (vertex.scratch != 0) {
				continue;
			}
			vertex.scratch = 1;
			if (vertex == end) {
				return;
			}
			for (Edge edge : vertex.adj) {
				Vertex next = edge.dest;
				Cost cost = edge.cost;
				Cost addCost = Cost.add(cost, vertex.cost);
				if (next.cost.compareTo(addCost) > 0) {
					next.cost = addCost;
					next.pre = vertex;
					pq.add(new Path(next, addCost));
				}
			}

		}
	}

	public Cost getCost(String destName) {
		Vertex end = vertexMap.get(destName);

		return end.cost;
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

	public List<String> getPath(String startName, String destName) {
		List<String> pathList = new LinkedList<String>();
		pathList.add(destName);
		Vertex destVertex = vertexMap.get(destName);
		while (!destVertex.name.equals(startName)) {
			pathList.add(0, destVertex.pre.name);
			destVertex = destVertex.pre;
		}
		return pathList;
	}

	public class Edge {
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

		public String toString() {
			return " dest " + dest.name + cost;
		}
	}

	public class Path implements Comparable<Path> {
		public Vertex dest;
		public Cost cost;

		public Path(Vertex dest, int length, int money) {
			cost = new Cost(length, money);
			this.dest = dest;
		}

		public Path(Vertex dest, Cost cost) {
			this.dest = dest;
			this.cost = cost;
		}

		@Override
		public int compareTo(Path o) {
			return cost.compareTo(o.cost);
		}

		public String toString() {
			return " dest " + dest.name + cost;
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

		public String toString() {
			return name + cost;
		}
	}

	public static class Cost implements Comparable<Cost>, Cloneable {
		public int length;
		public int money;

		public Cost(int length, int money) {
			super();
			this.length = length;
			this.money = money;

		}

		public Cost clone() {
			return new Cost(length, money);

		}

		public String toString() {
			return " length " + length + " money " + money;

		}

		@Override
		public int compareTo(Cost o) {
			if (length < o.length || (length == o.length && money < o.money)) {
				return -1;
			} else if (length == o.length && money == o.money) {
				return 0;
			} else {
				return 1;
			}

		}

		public static Cost add(Cost cost1, Cost cost2) throws Exception {

			int length = cost2.length + cost1.length;
			int money = cost2.money + cost1.money;
			if (length < 0 || money < 0) {
				throw new Exception();
			}
			Cost addCost = new Cost(length, money);
			return addCost;

		}

	}

}