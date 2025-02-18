
package HomeWork1;

import java.util.ArrayList;
import java.util.List;

class Задание5ForJava {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 1; i <= numRows; i++) {
            List<Integer> inner = new ArrayList<>();
            int temp = 1;
            inner.add(temp);
            for (int j = 1; j < i; j++) {
                temp *= (i - j);
                temp /= j;
                inner.add(temp);
            }
            ans.add(inner);
        }
        return ans;
    }

    public static void main(String[] args) {
        Задание5ForJava  solution = new Задание5ForJava();
        int numRows = 5;
        List<List<Integer>> result = solution.generate(numRows);

        for (List<Integer> row : result) {
            System.out.println(row);
        }
    }
}
