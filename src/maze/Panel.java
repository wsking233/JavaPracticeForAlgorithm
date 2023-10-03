/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maze;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.List;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author xhu
 */
public class Panel extends JPanel {

    private FileManager fileManager;
    private Graph graph;

    private Set<Node> visited;
    private Map<Node, Node> parentMap;
    private LinkedList<Node> shortestPath;
    private Node start;
    private Node exit;

    public Panel() {
        this.fileManager = null; // no file is selected
        this.graph = new Graph();
        this.visited = new HashSet<>();
        this.parentMap = new HashMap<>();
        this.start = null;
        this.exit = null;
    }

    public void restCanvas(String fileName) {
        // reset all the data when a new file is selected
        this.fileManager = new FileManager(fileName);
        this.fileManager.readFile(fileName);
        this.graph = new Graph();
        this.start = null;
        this.exit = null;
    }

    public void createGraph() {
        if (fileManager != null) { // make sure the file manager is initialized

            // read the file by line
            for (int i = 1; i < fileManager.numberOfLines; i++) { // start from 1 to skip the first line

                String line = fileManager.lineData[i];
                String[] lineData = line.split(","); // split the line by ','
                // get the elements from the line
                String nodeName = lineData[0];
                if (i == 1) {
                    if (!nodeName.equals("START")) {

                        System.out.println("Wrong file format");
                        JOptionPane.showMessageDialog(null, "Wrong file format", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                }

                // get the x and y coordinates
                int x = Integer.parseInt(lineData[1]);
                int y = Integer.parseInt(lineData[2]);
                String neighbourA = lineData[3]; // get the first connected nodes
                String neighbourB = lineData[4]; // get the second connected nodes

                // Node newNode = new Node(nodeName, x , y);
                if (graph.getNode(nodeName) == null) {
                    graph.addNode(nodeName);
                    graph.getNode(nodeName).setPosition(x, y);
                }
                if (neighbourA.equals("W")) { // W means connected to the exit
                    graph.addEdge(nodeName, "EXIT");
                    graph.addEdge(nodeName, neighbourB);
                } else if (neighbourB.equals("W")) {
                    graph.addEdge(nodeName, neighbourA);
                    graph.addEdge(nodeName, "EXIT");

                } else {
                    graph.addEdge(nodeName, neighbourA);
                    graph.addEdge(nodeName, neighbourB);
                }

            }

        }

    }

    public LinkedList<Node> findPath(Node start, Node exit) {
        // find the shortest path from start to exit

        LinkedList<Node> path = new LinkedList<>(); // this list is used to store the shortest path

        // clear the visited set and parent map
        this.visited.clear();
        this.parentMap.clear();

        // create a queue to store the nodes by order
        Queue<Node> queue = new LinkedList<>(); // First in First out
        queue.offer(start); // start from the start node
        visited.add(start); // to add the start node to the visited set

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll(); // get the first node from the queue

            if (currentNode == exit) { // the exit is found
                // store the path in a list
                path.add(currentNode);
                while (currentNode != start) {
                    currentNode = parentMap.get(currentNode);
                    path.add(currentNode);
                }

                break;
            }

            // get the neighbours of the current node
            for (Node neighbour : currentNode.getNeighbours()) {
                if (!visited.contains(neighbour)) {
                    queue.offer(neighbour);
                    visited.add(neighbour);
                    parentMap.put(neighbour, currentNode);
                }
            }

        }

        return path;

    }

    public void paint(Graphics g) {

        this.paintComponent(g);
        createGraph();

        if (fileManager != null) { // can only run while the file manager is initialized
            // draw the File manager data
            // g.drawString("File Name: "+fileManager.name, 10, 20);
            // g.drawString("Number of Lines: "+fileManager.numberOfLines, 10, 40);
            // for(int i = 0; i < fileManager.numberOfLines; i++)
            // {
            // g.drawString(fileManager.lineData[i], 10, 60+i*20);
            // }

            // draw the maze graph

            g.setColor(Color.BLACK);
            g.drawString("Here is your MAZE:", 10, 20);

            // draw circles for the nodes, and put the node name in the circle
            for (Node node : graph.getNodes().values()) {
                // System.out.println(node.getData() + " " + node.getX() + " " + node.getY());

                // scale the x and y by 50, so the nodes will not overlap each other
                // add 100 to x and y so the nodes will not be too close to the edge
                int width = 30; // diameter of the circle
                int height = width;
                int scale = 60; // scale for the x and y position
                int offsetC = 100; // offset for the circle
                int offsetL = 115; // offset for the line = offsetC + width/2
                g.setColor(Color.DARK_GRAY); // color of the node
                g.fillOval(node.getX() * scale + 100, node.getY() * scale + offsetC, width, height);
                g.setColor(Color.BLACK); // color of the text
                g.drawString(node.getData(), node.getX() * scale + offsetC, node.getY() * scale + offsetC);

                // draw the connections between the nodes
                if (node.getNeighbours() != null) {
                    for (Node neighbour : node.getNeighbours()) {
                        g.setColor(Color.ORANGE);
                        g.drawLine(node.getX() * scale + offsetL, node.getY() * scale + offsetL,
                                neighbour.getX() * scale + offsetL,
                                neighbour.getY() * scale + offsetL);
                    }
                }

                // initialize the start and exit node
                this.start = graph.getNode("START");
                this.exit = graph.getNode("EXIT");

                // only draw the shortest path when the start and exit node are found
                if (this.start != null && this.exit != null) {
                    this.shortestPath = findPath(this.start, this.exit);

                    // draw the shortest path
                    if (this.shortestPath != null) {
                        g.setColor(Color.GREEN);

                        for (int i = 0; i < this.shortestPath.size() - 1; i++) {
                            g.setColor(Color.GREEN);
                            g.drawLine(this.shortestPath.get(i).getX() * scale + offsetL,
                                    this.shortestPath.get(i).getY() * scale + offsetL,
                                    this.shortestPath.get(i + 1).getX() * scale + offsetL,
                                    this.shortestPath.get(i + 1).getY() * scale + offsetL);
                        }
                    }

                    // draw labels
                    g.setColor(Color.ORANGE);
                    g.drawLine(450, 500, 500, 500);
                    g.setColor(Color.BLACK);
                    g.drawString("Path between nodes", 510, 505);
                    
                    // draw labels
                    g.setColor(Color.GREEN);
                    g.drawLine(450, 550, 500, 550);
                    g.setColor(Color.BLACK);
                    g.drawString("Path from START to EXIT node", 510, 555);

                }

            }

        } else {
            g.drawString("No file is selected", 10, 20);
        }

        repaint();
    }

}
