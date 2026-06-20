public class BellmanFord {

    static class Edge {
        int src,dest,weight;

        Edge(int s,int d,int w){
            src=s;
            dest=d;
            weight=w;
        }
    }

    public static void main(String args[]) {

        int V=5;
        Edge edges[]={
                new Edge(0,1,6),
                new Edge(0,2,7),
                new Edge(1,2,8),
                new Edge(1,3,5),
                new Edge(1,4,-4),
                new Edge(2,3,-3),
                new Edge(2,4,9),
                new Edge(3,1,-2),
                new Edge(4,3,7)
        };

        int dist[]=new int[V];

        for(int i=0;i<V;i++)
            dist[i]=9999;

        dist[0]=0;

        for(int i=1;i<V;i++){
            for(Edge e:edges){
                if(dist[e.src]!=9999 &&
                        dist[e.src]+e.weight<dist[e.dest]){
                    dist[e.dest]=dist[e.src]+e.weight;
                }
            }
        }

        System.out.println("Shortest Distances:");
        for(int i=0;i<V;i++)
            System.out.println(i+" -> "+dist[i]);
    }
}
