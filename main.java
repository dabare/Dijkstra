/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author madhavadabare
 */
public class main {

    public static void main(String[] args) {
        ShortestPath.infinity = 100000; // here the 100 000 is used as infinity

        String vertices[] = {"A", "B", "C", "D", "E", "F", "G", "H"};
        String edges[][] = {//source , destination , weight
            {"A", "B", "2"},
            {"A", "F", "8"},
            {"A", "G", "9"},
            {"B", "C", "1"},
            {"C", "D", "5"},
            {"C", "F", "4"},
            {"D", "E", "2"},
            {"D", "F", "1"},
            {"D", "C", "1"},
            {"F", "D", "1"},
            {"F", "G", "2"},
            {"G", "A", "2"},
            {"H", "B", "5"},
            {"H", "G", "3"},};

        String start = "A";
        
        Graph graph = new Graph(vertices, edges);
        ShortestPath.Print_ShortestPath_Dijkstra(graph, start);

    }
}
