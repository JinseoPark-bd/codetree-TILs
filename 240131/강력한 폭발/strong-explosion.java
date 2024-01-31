import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

class Pair {
    int x, y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static final int BOMB_TYPE_NUM = 3;
    public static final int MAX_N = 20;

    public static int n;
    public static int[][] bombType = new int[MAX_N][MAX_N];
    public static boolean[][] bombed = new boolean[MAX_N][MAX_N];

    public static int ans;
    public static ArrayList<Pair> bombPos = new ArrayList<>();

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    public static void bomb(int x, int y, int bType) {
        Pair[][] bombShapes = {
            {},
            {new Pair(-2,0), new Pair(-1,0), new Pair(0,0), new Pair(1,0), new Pair(2,0)},
            {new Pair(-1,0), new Pair(1,0), new Pair(0,0), new Pair(0,-1), new Pair(0,1)},
            {new Pair(-1,-1), new Pair(-1,1), new Pair(0,0), new Pair(1,-1), new Pair(1,1)}
        };

        for(int i = 0; i < 5; i++) {
            int dx = bombShapes[bType][i].x;
            int dy = bombShapes[bType][i].y;
            int nx = x + dx, ny = y + dy;
            if(inRange(nx, ny))
                bombed[nx][ny] = true;
        }
    }

    public static int calc() {
        // 1. 폭탄이 터진 위치 초기화
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                bombed[i][j] = false;
            }
        }

        // 2. 폭탄 타입에 다라 초토화 영역 표시
        for(int i = 0;  i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(bombType[i][j] > 0)
                    bomb(i,j,bombType[i][j]);
            }
        }

        // 3. 초토확 영역 수 구하기
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(bombed[i][j]) cnt++;
            }
        }

        return cnt;
    }

    public static void findMaxArea(int cnt) {
        if(cnt == (int) bombPos.size()) {
            ans = Math.max(ans, calc());
            return;
        }
        for(int i = 1; i <= 3; i++) {
            int x = bombPos.get(cnt).x;
            int y = bombPos.get(cnt).y;

            bombType[x][y] = i;
            findMaxArea(cnt +1);
            bombType[x][y] = 0;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                int bombPlace = Integer.parseInt(st.nextToken());
                if(bombPlace > 0)
                    bombPos.add(new Pair(i,j));
            }
        }

        findMaxArea(0);
        System.out.print(ans);
    }
}