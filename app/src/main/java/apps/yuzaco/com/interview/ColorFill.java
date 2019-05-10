package apps.yuzaco.com.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by jung on 12/7/15.
 */
public class ColorFill {
    private static int N;

    public static void main(String[] args) {
        int P;
        int row;
        int col;
        int colorValue;
        int num;
        Scanner stdin = new Scanner(System.in);
        String op;
        String sRow = new String("ROW");
        String sCol = new String("COL");
        Map<Integer, ArrayList<Integer>> colorTable;


        N = stdin.nextInt();
        P = stdin.nextInt();
        if ((N <= 0) || (N > 60000)) {
            System.out.println("Size of color table out of boundary ");
            return;
        }
        if ((P <= 0) || (P > 400000)) {
            System.out.println("Number of operation out of boundary ");
            return;
        }
        colorTable = create(N);
        while (P-- > 0) {
            op = stdin.next();
            num = stdin.nextInt();
            col = stdin.nextInt();
            if ((num < 1) || (num > N)) {
                System.out.println("Out of bound Index" + num);
                return;
            }
            colorValue = stdin.nextInt();
            if (op.equals(sRow)) {
                updateRow(colorTable, num - 1, colorValue);
/            } else if (op.equals(sCol)) {
                updateColumn(colorTable, num - 1);
            } else {
                System.out.println("Unsupported operation " + op);
                return;
            }
            System.out.println(sum(colorTable));
        }

    }

    private static double sum(Map<Integer, ArrayList<Integer>> table) {
        double total = 0;
        for (int y = 0; y < N; y++) {
            ArrayList<Integer> array = table.get(y);
            for (int x = 0; x < N; x++) {
                total += array.get(x);
            }

        }
    }


    private static void updateRow(Map<Integer, ArrayList<Integer>> table, int Row, int color) {
        ArrayList<Integer> array = table.get(Row);
        for (int i = 0; i < N; i++) {
            array.add(i, color);
        }
    }

    private static void updateColumn(Map<Integer, ArrayList<Integer>> table, int row, int color) {
        for (int i = 0; i < N; i++) {
            ArrayList<Integer> array = table.get(i);
            array.add(row, color);
        }
    }

    private static Map<Integer, ArrayList<Integer>> create(int size) {
        Map<Integer, ArrayList<Integer>> colorMap = new HashMap<Integer, ArrayList<Integer>>();
        for (int y = 0; y < size; y++) {
            ArrayList<Integer> newRow = new ArrayList<Integer>();
            colorMap.put(y, newRow);
            for (int x = 0; x < size; x++) {
                newRow.add(x, 0);
            }
            colorMap.put(y, newRow);
        }
        return colorMap;
    }
}