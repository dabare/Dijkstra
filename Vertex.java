/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author madhavadabare
 */
public class Vertex {

    private String ID;
    private int distance;
    private Vertex parent;

    public Vertex(String ID, int distance, Vertex parent) {
        this.ID = ID;
        this.distance = distance;
        this.parent = parent;
    }

    public Vertex(String ID) {
        this(ID, -1, null);
    }

    public void setParent(Vertex parent) {
        this.parent = parent;
    }

    public Vertex getParent() {
        return parent;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getID() {
        return ID;
    }

   
}
