/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author madhavadabare
 */
public class ShortestPath {

    static LinkList S;
    static LinkList Q;
    static int infinity;

    static void Initialise_Single_source(Graph graph, Vertex source) {
        for (Vertex v : graph.vertices) {
            v.setDistance(infinity);
            v.setParent(null);
        }
        source.setDistance(0);
    }

    static void Relax(Vertex u, Vertex v, int w) {
        if (u.getDistance() + w < v.getDistance()) {
            v.setDistance(u.getDistance() + w);
            v.setParent(u);
        }
    }

    static Vertex Extract_Min(LinkList L) {
        LinkListNode l = L.getHead();
        LinkListNode min = l;
        while (l != null) {
            if (l.compareTo(min) < 0) {
                min = l;
            }
            l = l.next;
        }
        return L.pop(min).v;
    }

    static Vertex[] ShortestPath_Dijkstra(Graph G, String start) {
        Vertex strt = G.find(start);
        S = new LinkList();
        Q = new LinkList();
        for (Vertex v : G.vertices) {
            Q.append(v);
        }
        Initialise_Single_source(G, strt);
        Vertex u = null;
        while (!Q.isEmpty()) {
            u = Extract_Min(Q);
            S.append(u);;

            for (Edge e : G.getAdjacent(u)) {
                Relax(e.source, e.destination, e.weight);
            }
        }

        return G.vertices;
    }

    static void Print_ShortestPath_Dijkstra(Graph G, String start) {
        System.out.println("Shortest paths from " + start + "to other vertices");
        ShortestPath_Dijkstra(G, start);
        LinkListNode ln = S.getHead();
        while (ln != null) {
            if (ln.v.getDistance() == ShortestPath.infinity) {
                System.out.println(start+"->" + ln.v.getID() + "\t\t" + "(inf)*");
            } else {
                Vertex tmp[] = G.getPath(ln.v);
                String s = "";
                for (int i = 1; i < tmp.length; i++) {
                    s = tmp[i].getID() + "->" + s;
                }
                s = s + tmp[0].getID() + "\t\t(" + ln.v.getDistance() + ")";
                System.out.println(s);
            }
            ln = ln.next;
        }
    }
}
