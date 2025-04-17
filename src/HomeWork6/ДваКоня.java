package HomeWork6;
import java.io.*;
import java.util.*;

public class ДваКоня {


    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    static final int N = 8;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = reader.readLine().split(" ");
        int[] start1 = convert(input[0]);
        int[] start2 = convert(input[1]);

        int[][] dist1 = bfs(start1);
        int[][] dist2 = bfs(start2);

        int result = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (dist1[i][j] != -1 && dist2[i][j] != -1 && dist1[i][j] == dist2[i][j]) {
                    result = Math.min(result, dist1[i][j]);
                }
            }
        }

        writer.write((result == Integer.MAX_VALUE ? -1 : result) + "\n");
        writer.flush();
        reader.close();
        writer.close();
    }

    // "a1" -> [0][0]
    static int[] convert(String pos) {
        int col = pos.charAt(0) - 'a';
        int row = pos.charAt(1) - '1';
        return new int[]{row, col};
    }

    static int[][] bfs(int[] start) {
        int[][] dist = new int[N][N];
        for (int[] row : dist) Arrays.fill(row, -1);

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        dist[start[0]][start[1]] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && dist[nx][ny] == -1) {
                    dist[nx][ny] = dist[x][y] + 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

        return dist;
    }
}


