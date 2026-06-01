import java.util.*;

public class KruskalsAlgorithm {

    static class Edge
            implements Comparable<Edge> {

        int src,dest,weight;

        public int compareTo(
                Edge compareEdge) {

            return this.weight
                    - compareEdge.weight;
        }
    }

    static int V = 4;
    static int E = 5;

    int find(int parent[],
             int i) {

        if(parent[i]==i)
            return i;

        return find(parent,
                parent[i]);
    }

    void union(int parent[],
               int x,
               int y) {

        int xset =
                find(parent,x);

        int yset =
                find(parent,y);

        parent[xset]=yset;
    }

    void kruskalMST(
            Edge edges[]) {

        Arrays.sort(edges);

        int parent[] =
                new int[V];

        for(int i=0;i<V;i++)
            parent[i]=i;

        int cost=0;
        int count=0;

        for(int i=0;
            count<V-1;
            i++) {

            Edge next=
                    edges[i];

            int x=
                    find(parent,
                            next.src);

            int y=
                    find(parent,
                            next.dest);

            if(x!=y) {

                cost+=next.weight;

                union(parent,x,y);

                count++;
            }
        }

        System.out.println(
                "Minimum Cost = "
                        + cost);
    }

    public static void main(
            String[] args) {

        KruskalsAlgorithm g =
                new KruskalsAlgorithm();

        Edge edges[] =
                new Edge[E];

        for(int i=0;i<E;i++)
            edges[i]=new Edge();

        edges[0].src=0;
        edges[0].dest=1;
        edges[0].weight=10;

        edges[1].src=0;
        edges[1].dest=2;
        edges[1].weight=6;

        edges[2].src=0;
        edges[2].dest=3;
        edges[2].weight=5;

        edges[3].src=1;
        edges[3].dest=3;
        edges[3].weight=15;

        edges[4].src=2;
        edges[4].dest=3;
        edges[4].weight=4;

        g.kruskalMST(edges);
    }
}
