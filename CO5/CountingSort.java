public class CountingSort {

    void countSort(int arr[]) {

        int n = arr.length;

        int output[] = new int[n];

        int max = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] > max)
                max = arr[i];
        }

        int count[] = new int[max + 1];

        for (int i = 0; i < n; i++)
            count[arr[i]]++;

        for (int i = 1; i <= max; i++)
            count[i] += count[i - 1];

        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        for (int i = 0; i < n; i++)
            arr[i] = output[i];
    }

    static void printArray(int arr[]) {

        for (int value : arr)
            System.out.print(value + " ");

        System.out.println();
    }

    public static void main(String args[]) {

        int ratings[] = {5, 4, 5, 3, 4, 2};

        System.out.println("========= Counting Sort =========");

        System.out.println("\nOriginal Customer Ratings");

        printArray(ratings);

        CountingSort obj = new CountingSort();

        obj.countSort(ratings);

        System.out.println("\nSorted Customer Ratings");

        printArray(ratings);
    }
}
