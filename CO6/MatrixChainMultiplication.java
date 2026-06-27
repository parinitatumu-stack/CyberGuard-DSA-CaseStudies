public class MatrixChainMultiplication {

    static int matrixChainOrder(int p[], int n) {

        int m[][] = new int[n][n];

        for (int i = 1; i < n; i++)
            m[i][i] = 0;

        for (int L = 2; L < n; L++) {

            for (int i = 1; i < n - L + 1; i++) {

                int j = i + L - 1;

                m[i][j] = Integer.MAX_VALUE;

                for (int k = i; k <= j - 1; k++) {

                    int q = m[i][k] + m[k + 1][j]
                            + p[i - 1] * p[k] * p[j];

                    if (q < m[i][j])
                        m[i][j] = q;
                }
            }
        }

        return m[1][n - 1];
    }

    public static void main(String args[]) {

        int arr[] = {30, 35, 15, 5, 10, 20, 25};

        System.out.println("========= Matrix Chain Multiplication =========");

        System.out.println("\nMatrix Dimensions");

        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");

        System.out.println();

        System.out.println("\nMinimum Multiplication Cost : "
                + matrixChainOrder(arr, arr.length));
    }
}
