public class LCS {

    public static void main(String args[]) {

        String X="ABCBDAB";
        String Y="BDCABA";

        int m=X.length();
        int n=Y.length();

        int L[][]=new int[m+1][n+1];

        for(int i=0;i<=m;i++){

            for(int j=0;j<=n;j++){

                if(i==0 || j==0)
                    L[i][j]=0;

                else if(X.charAt(i-1)==Y.charAt(j-1))
                    L[i][j]=L[i-1][j-1]+1;

                else
                    L[i][j]=Math.max(L[i-1][j],L[i][j-1]);

            }

        }

        System.out.println("========= Longest Common Subsequence =========");

        System.out.println("\nShipment Record 1 : "+X);

        System.out.println("Shipment Record 2 : "+Y);

        System.out.println("\nLength of LCS : "+L[m][n]);

    }

}
