package maze;

import java.util.List;
import java.util.ArrayList;

public class Node {

    private String data;
    private int x;
    private int y;
    private List<Node> neighbours;

    public Node(String data) {
        this.data = data;
        this.neighbours = new ArrayList<>();
    }

    public Node(String data, int x, int y) {
        this.data = data;
        this.x = x;
        this.y = y;
        this.neighbours = new ArrayList<>();
    }

    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return this.data;
    }

    public void addNeighbour(Node node) {
        this.neighbours.add(node);
    }

    public List<Node> getNeighbours() {
        if (this.neighbours == null) {
            return null;
        }
        return this.neighbours;
    }

    public String toString() {
        return this.data;
    }

}
