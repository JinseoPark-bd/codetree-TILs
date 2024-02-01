import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
public class Main {
    public static int N, M;
    public static final int MAX_N = 1000;
    public static ArrayList<Integer>[] list = new ArrayList[MAX_N+1];
    public static boolean[] visited = new boolean[MAX_N+1];
    public static int cnt = 0;

    public static void DFS(int vertex) {
        for(int i = 0; i < list[vertex].size(); i++) {
            int currV = list[vertex].get(i);
            if(!visited[currV]) {
                visited[currV] = true;
                cnt++;
                DFS(currV);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= N; i++) 
            list[i] = new ArrayList<>();

        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            
            list[s].add(e);
            list[e].add(s);
        }

        visited[1] = true;
        DFS(1);
        System.out.println(cnt);
    }
}