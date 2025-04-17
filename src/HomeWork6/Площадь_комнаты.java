package HomeWork6;

import java.util.Scanner;

public class Площадь_комнаты {

    private static char[][] labyrinth;
    private static int n;
    private static boolean[][] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        labyrinth = new char[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String row = scanner.next();
            labyrinth[i] = row.toCharArray();
        }

        int startRow = scanner.nextInt() - 1;
        int startCol = scanner.nextInt() - 1;

        System.out.println(calculateArea(startRow, startCol));
        scanner.close();
    }

    private static int calculateArea(int row, int col) {
        if (row < 0 || row >= n || col < 0 || col >= n || labyrinth[row][col] == '*' || visited[row][col]) {
            return 0;
        }

        visited[row][col] = true;
        return 1 + calculateArea(row + 1, col) + calculateArea(row - 1, col) +
                calculateArea(row, col + 1) + calculateArea(row, col - 1);
    }
}
