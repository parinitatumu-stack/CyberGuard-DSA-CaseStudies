import java.util.Arrays;

public class MemoizationVsTabulation {

    static int memo[];

    static int fibMemo(int n) {

        if (n <= 1)
            return n;

        if (memo[n] != -1)
            return memo[n];

        memo[n] = fibMemo(n - 1) + fibMemo(n - 2);

        return memo[n];
    }

    static int fibTab(int n) {

        int dp[] = new int[n + 1];

        dp[0] = 0;

        if (n > 0)
            dp[1] = 1;

        for (int i = 2; i <= n; i++)
            dp[i] = dp[i - 1] + dp[i - 2];

        return dp[n];
    }

    public static void main(String args[]) {

        int n = 10;

        memo = new int[n + 1];

        Arrays.fill(memo, -1);

        System.out.println("========= Memoization vs Tabulation =========");

        System.out.println("\nFinding Fibonacci of " + n);

        System.out.println("\nMemoization Result : " + fibMemo(n));

        System.out.println("Tabulation Result : " + fibTab(n));

        System.out.println("\nBoth approaches produce the same result.");
    }
}
