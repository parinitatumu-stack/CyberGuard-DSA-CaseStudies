import java.util.*;

public class DFS {

    private int vertices;
    private LinkedList<Integer>[] adj;

    DFS(int v) {

        vertices = v;

        adj = new LinkedList[v];

        for(int i=0;i<v;i++)
            adj[i]=new LinkedList<>();
    }

    void addEdge(int v,int w) {
        adj[v].add(w);
    }

    void dfsUtil(int v,
                 boolean[] visited) {

        visited[v]=true;

        System.out.print(v+" ");

        Iterator<Integer> i=
                adj[v].listIterator();

        while(i.hasNext()) {

            int n=i.next();

            if(!visited[n])
                dfsUtil(n,visited);
        }
    }

    void dfs(int v) {

        boolean[] visited=
                new boolean[vertices];

        dfsUtil(v,visited);
    }

    public static void main(String[] args) {

        DFS g=new DFS(6);

        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(2,4);
        g.addEdge(4,5);

        System.out.println("DFS Traversal:");

        g.dfs(0);
    }
}
