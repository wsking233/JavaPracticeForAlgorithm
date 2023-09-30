/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maze;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author xhu
 */
public class Panel extends JPanel {

    private FileManager fileManager;
    private Graph graph;

    public Panel() {
        this.fileManager = null;
        this.graph = new Graph();
    }

    public Panel(String fileName) {
        this.fileManager = new FileManager(fileName);
        this.fileManager.readFile(fileName);
        this.graph = new Graph();
    }

    public void initFileManager(String fileName) {
        this.fileManager = new FileManager(fileName);
        this.fileManager.readFile(fileName);
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
                    graph.getNode(nodeName).setX(x);
                    graph.getNode(nodeName).setY(y);
                }
                
                graph.addEdge(nodeName, neighbourA); // add the edges for the node
                graph.addEdge(nodeName, neighbourB); // add the edges for the node

            }
        }
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

            g.drawString("Here is your MAZE:", 10, 20);

            // draw circles for the nodes, and put the node name in the circle
            for (Node node : graph.getNodes().values()) {
                System.out.println(node.getData() + " " + node.getX() + " " + node.getY());
                g.setColor(Color.BLUE);
                g.drawOval(node.getX() * 10, node.getY() * 10, 20, 20);
                g.setColor(Color.BLACK);
                g.drawString(node.getData(), node.getX() * 10, node.getY() * 10);
            }

        } else {
            g.drawString("No file is selected", 10, 20);
        }

        repaint();
    }

}
