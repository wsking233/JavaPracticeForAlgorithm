package maze;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author William Wang
 * @StudnetID 18017970
 *
 *            This class is used to create the graph for the maze.
 *            it contains a map of nodes and a method to add nodes and edges.
 *            and a method to get a node from the map.
 *
 *
 */

public class Graph {
    private Map<String, Node> nodes;

    public Graph() {
        this.nodes = new HashMap<>();
    }

    public void addNode(String name) {
        nodes.put(name, new Node(name));
    }

    public Node getNode(String name) {
        return nodes.get(name);
    }

    public Map<String, Node> getNodes() {
        return this.nodes;
    }

    public void addEdge(String from, String to) {
        Node fromNode = nodes.get(from);
        Node toNode = nodes.get(to);

        if (fromNode != null && toNode != null) {
            fromNode.addNeighbour(toNode);
            toNode.addNeighbour(fromNode);
        }
    }

}