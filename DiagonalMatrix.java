import java.util.Scanner;

public class DiagonalMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        int cols = sc.nextInt();

        int[][] mat = new int[rows][cols];

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                mat[i][j] = sc.nextInt();

        System.out.print("Main Diagonal: ");
        for (int i = 0; i < rows && i < cols; i++) {
            System.out.print(mat[i][i] + " ");
        }

        sc.close();
    }
}
