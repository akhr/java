Anatomy of a Graph A tree A spanning forest# Graphs
## Introduction (Courtesy - https://algs4.cs.princeton.edu/41graph/)
- A graph is a set of vertices and a collection of edges that each connect a pair of vertices.
- A self-loop is an edge that connects a vertex to itself.
- Two edges are parallel if they connect the same pair of vertices.
- When an edge connects two vertices, we say that the vertices are adjacent to one another and that the edge is incident on both vertices.
- The degree of a vertex is the number of edges incident on it.
- A subgraph is a subset of a graph's edges (and associated vertices) that constitutes a graph.
- A path in a graph is a sequence of vertices connected by edges. A simple path is one with no repeated vertices.
- A cycle is a path (with at least one edge) whose first and last vertices are the same. A simple cycle is a cycle with no repeated edges or vertices (except the requisite repetition of the first and last vertices).
- The length of a path or a cycle is its number of edges.
- We say that one vertex is connected to another if there exists a path that contains both of them.
- A graph is connected if there is a path from every vertex to every other vertex.
- _A graph that is not connected consists of a set of connected components, which are maximal connected subgraphs._
- An acyclic graph is a graph with no cycles.
- A tree is an acyclic connected graph.
- _A forest is a disjoint set of trees._
- _A spanning tree of a connected graph is a subgraph that contains all of that graph's vertices and is a single tree. A spanning forest of a graph is the union of the spanning trees of its connected components._
- _A bipartite graph is a graph whose vertices we can divide into two sets such that all edges connect a vertex in one set with a vertex in the other set._

![alt text](https://algs4.cs.princeton.edu/41graph/images/graph-anatomy.png)
![alt text](https://algs4.cs.princeton.edu/41graph/images/tree.png)
![alt text](https://algs4.cs.princeton.edu/41graph/images/forest.png)

## Undirected graph data type
![alt text](https://algs4.cs.princeton.edu/41graph/images/graph-api.png)

### Graph Data File
![alt text](https://algs4.cs.princeton.edu/41graph/images/graph-input.png)

### Graph representation
- We use the adjacency-lists representation
- We maintain a vertex-indexed array of lists of the vertices connected by an edge to each vertex.
![alt text](https://algs4.cs.princeton.edu/41graph/images/adjacency-lists.png)
- Can we represented using adjacent matrix also

### Graph.java
```
public class Graph {

    private final int V; //vertices
    private int E; //edges
    private Bag<Integer>[] adj; //adjacency list
    
    //Here name of vertex crossponds to the array index (BAG index)
    //Sometimes BAG can contain Object instead of simple Integer.
    //In that case how to find a vertex from BAG effitively?
    
    public Graph(In in) {
    
        //CREATE Vertices
        this.V = in.readInt();
        //Create a BAG for each Vertex
        adj = (Bag<Integer>[]) new Bag[V];        
        for (int v = 0; v < V; v++) {
            //Each vertex has a BAG for itself to store adjacent vertices
            adj[v] = new Bag<Integer>();
        }
            
        //CREATE Edges
        int E = in.readInt();
        //Data format is 
        //  0 5
        //  4 3
        //  0 1
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w); 
        }
    }
    
    public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        E++;
        adj[v].add(w);
        adj[w].add(v);
    }
    
    //Vertex name is its INDEX 
    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }
    
    
    //DEEP Copying from a Graph
    public Graph(Graph G) {
        this(G.V());
        this.E = G.E();
        for (int v = 0; v < G.V(); v++) {
            
            // reverse so that adjacency list is in same order as original
            Stack<Integer> reverse = new Stack<Integer>();
            for (int w : G.adj[v]) {
                reverse.push(w);
            }
            for (int w : reverse) {
                adj[v].add(w);
            }
        }
    }
}
```

```
public class Bag<Item> implements Iterable<Item> {
    private Node<Item> first;    // beginning of bag
    private int n;               // number of elements in bag

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }
    
    public void add(Item item) {
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        n++;
    }
}
```

### Depth First Search (DFS)
- Recursive
- Mark visited nodes
- Visit (recursively) all the vertices that are adjacent to it and that have not yet been marked.


