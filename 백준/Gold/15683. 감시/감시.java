

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Point{
        int x;
        int y;
        int cctvNum;
        Point(int x, int y, int cctvNum) {
            this.x = x;
            this.y = y;
            this.cctvNum = cctvNum;
        }
    }
    static int N, M;
    static int min = Integer.MAX_VALUE;
    static List<Point> cctv = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];


        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] != 0 && map[i][j] != 6) {
                    cctv.add(new Point(i, j, map[i][j]));
                }
            }
        }

        dfs(0, map);
        System.out.println(min);
    }

    public static void dfs(int cnt, int[][] map) {
        if(cnt == cctv.size()) {
            min = Math.min(min, getZeroCnt(map));
            return;
        }

        int cctvNum = cctv.get(cnt).cctvNum;
        int x = cctv.get(cnt).x;
        int y = cctv.get(cnt).y;
        int[][] tmp;
        if(cctvNum == 1) {
            tmp = copyMap(map);
            checkLeft(tmp, x, y);
            dfs(cnt+1, tmp);

            tmp = copyMap(map);
            checkRight(tmp, x, y);
            dfs(cnt+1, tmp);

            tmp = copyMap(map);
            checkDown(tmp, x, y);
            dfs(cnt+1, tmp);

            tmp = copyMap(map);
            checkUp(tmp, x, y);
            dfs(cnt+1, tmp);
        } else if (cctvNum == 2) {
            tmp = copyMap(map);
            checkLeft(tmp, x, y);
            checkRight(tmp, x, y);
            dfs(cnt+1, tmp);

            tmp = copyMap(map);
            checkUp(tmp, x, y);
            checkDown(tmp, x, y);
            dfs(cnt+1, tmp);
        } else if (cctvNum == 3) {
            tmp = copyMap(map);
            checkLeft(tmp, x, y);
            checkUp(tmp, x, y);
            dfs(cnt+1, tmp);

            tmp = copyMap(map);
            checkUp(tmp, x, y);
            checkRight(tmp, x, y);
            dfs(cnt+1, tmp);

            tmp = copyMap(map);
            checkRight(tmp, x, y);
            checkDown(tmp, x, y);
            dfs(cnt+1, tmp);

            tmp = copyMap(map);
            checkDown(tmp, x, y);
            checkLeft(tmp, x, y);
            dfs(cnt+1, tmp);
        } else if(cctvNum == 4) {
            tmp = copyMap(map);
            checkLeft(tmp, x, y);
            checkUp(tmp, x, y);
            checkRight(tmp, x, y);
            dfs(cnt+1, tmp);

            tmp = copyMap(map);
            checkUp(tmp, x, y);
            checkRight(tmp, x, y);
            checkDown(tmp, x, y);
            dfs(cnt+1, tmp);

            tmp = copyMap(map);
            checkRight(tmp, x, y);
            checkDown(tmp, x, y);
            checkLeft(tmp ,x , y);
            dfs(cnt+1, tmp);

            tmp = copyMap(map);
            checkDown(tmp, x, y);
            checkLeft(tmp ,x , y);
            checkUp(tmp, x, y);
            dfs(cnt+1, tmp);
        } else if(cctvNum == 5) {
            tmp = copyMap(map);
            checkRight(tmp, x, y);
            checkDown(tmp, x, y);
            checkLeft(tmp ,x , y);
            checkUp(tmp, x, y);
            dfs(cnt+1, tmp);
        }
    }

    public static void checkLeft(int[][] map, int x, int y) {
        for(int i=y-1; i>=0; i--) {
            if(map[x][i] == 6) return;
            if(map[x][i] != 0) continue;
            map[x][i] = -1;
        }
    }

    public static void checkRight(int[][] map, int x, int y) {
        for(int i=y+1; i<M; i++) {
            if(map[x][i] == 6) return;
            if(map[x][i] != 0) continue;
            map[x][i] = -1;
        }
    }

    public static void checkUp(int[][] map, int x, int y) {
        for(int i=x-1; i>=0; i--) {
            if(map[i][y] == 6) return;
            if(map[i][y] != 0) continue;
            map[i][y] = -1;
        }
    }

    public static void checkDown(int[][] map, int x, int y) {
        for(int i=x+1; i<N; i++) {
            if(map[i][y] == 6) return;
            if(map[i][y] != 0) continue;
            map[i][y] = -1;
        }
    }

    public static int getZeroCnt(int[][] map) {
        int zerCnt = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] == 0) zerCnt++;
            }
        }
        return zerCnt;
    }

    public static int[][] copyMap(int[][] map) {
        int[][]tmp = new int[N][M];
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                tmp[i][j] = map[i][j];
            }
        }
        return tmp;
    }

}
