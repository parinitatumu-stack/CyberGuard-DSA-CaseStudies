public class FenwickTree {

    static int[] BIT;
    static int n;

    static void update(int index,
                       int value) {

        while (index <= n) {

            BIT[index] += value;

            index +=
                    index & (-index);
        }
    }

    static int query(int index) {

        int sum = 0;

        while (index > 0) {

            sum += BIT[index];

            index -=
                    index & (-index);
        }

        return sum;
    }

    public static void main(String[] args) {

        int[] events =
                {12, 8, 15, 10, 18, 7, 20, 14};

        n = events.length;

        BIT = new int[n + 1];

        for (int i = 0; i < n; i++) {
            update(i + 1, events[i]);
        }

        System.out.println(
                "Prefix Sum upto Hour 5 = "
                        + query(5));
    }
}
