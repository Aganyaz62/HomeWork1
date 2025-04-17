package HomeWork6;

import java.util.*;
public class Путь_в_графе {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] adjacencyMatrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adjacencyMatrix[i][j] = scanner.nextInt();
            }
        }

        int startNode = scanner.nextInt() - 1;
        int endNode = scanner.nextInt() - 1;

        List<Integer> shortestPath = findShortestPath(adjacencyMatrix, startNode, endNode);

        if (shortestPath == null) {
            System.out.println(-1);
        } else {
            System.out.println(shortestPath.size() - 1);
            if (shortestPath.size() > 1) {
                for (int node : shortestPath) {
                    System.out.print(node + 1 + " ");
                }
                System.out.println();
            }
        }
        scanner.close();

    }

    private static List<Integer> findShortestPath(int[][] adjacencyMatrix, int startNode, int endNode) {
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(List.of(startNode));
        boolean[] visited = new boolean[adjacencyMatrix.length];
        visited[startNode] = true;

        while (!queue.isEmpty()) {
            List<Integer> currentPath = queue.poll();
            int currentNode = currentPath.get(currentPath.size() - 1);

            if (currentNode == endNode) {
                return currentPath;
            }

            for (int neighbor = 0; neighbor < adjacencyMatrix.length; neighbor++) {
                if (adjacencyMatrix[currentNode][neighbor] == 1 && !visited[neighbor]) {
                    List<Integer> newPath = new ArrayList<>(currentPath);
                    newPath.add(neighbor);
                    queue.offer(newPath);
                    visited[neighbor] = true;
                }
            }
        }

        return null;
    }
}


