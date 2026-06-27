public class QuickSort {

    int partition(int arr[], int low, int high) {

        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (arr[j] < pivot) {

                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    void quickSort(int arr[], int low, int high) {

        if (low < high) {

            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static void printArray(int arr[]) {

        for (int i : arr)
            System.out.print(i + " ");

        System.out.println();
    }

    public static void main(String args[]) {

        int prices[] = {899, 349, 499, 1200, 799, 250};

        System.out.println("========= Quick Sort =========");

        System.out.println("\nOriginal Product Prices");

        printArray(prices);

        QuickSort obj = new QuickSort();

        obj.quickSort(prices, 0, prices.length - 1);

        System.out.println("\nSorted Product Prices");

        printArray(prices);
    }
}
