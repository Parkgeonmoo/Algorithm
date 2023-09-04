import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
    static boolean[]visited;
    static ArrayList<treenode>[] list;
    static int n;
    static int firstnode = 0;
    static int maxdistance = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n+1];
        visited = new boolean[n+1];

        for (int i = 0; i < n+1; i++) {
            list[i] = new ArrayList<treenode>();
        }

        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int startnode = Integer.parseInt(st.nextToken());
            int endnode = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[startnode].add(new treenode(endnode,weight));
            list[endnode].add(new treenode(startnode,weight));
        }

        dfs(1,0);
        visited = new boolean[n+1];
        dfs(firstnode,0);

        System.out.println(maxdistance);





    }
    public static void dfs(int startnode,int weight) {
        visited[startnode] = true;

        if (weight > maxdistance) {
            maxdistance = weight;
            firstnode = startnode;
        }

        for (treenode temp : list[startnode]) {
            if (!visited[temp.node]) {
                visited[temp.node] = true;
                dfs(temp.node,weight+temp.weight);
            }
        }
    }
}
class treenode{
    int node;
    int weight;

    public treenode(int node,int weight) {
        this.node = node;
        this.weight = weight;
    }
}
