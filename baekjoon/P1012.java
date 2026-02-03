import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.BufferedWriter;

class Main {
    final static int[] dx = {-1, 1, 0, 0};
    final static int[] dy = {0, 0, -1, 1};

    public static void bfs(int[][] map, boolean[][] visited, int N, int M, int x, int y) {
        final Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            x = current[0];
            y = current[1];

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                if (map[nx][ny] == 0 || visited[nx][ny] == true) continue;

                queue.add(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int answer = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[][] map = new int[N][M];
            boolean[][] visited = new boolean[N][M];
            
            for (int j = 0; j < K; j++) {
                StringTokenizer sts = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(sts.nextToken());
                int y = Integer.parseInt(sts.nextToken());
                
                map[y][x] = 1;
            }

            for (int ni = 0; ni < N; ni++) {
                for (int mi = 0; mi < M; mi++){
                    if (map[ni][mi] == 1 && !visited[ni][mi]) {
                        answer += 1;
                        bfs(map, visited, N, M, ni, mi);
                    }
                }
            }
            bw.write(answer + "\n");
        }
        bw.close();
    }
}
