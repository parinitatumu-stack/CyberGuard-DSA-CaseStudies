public class RadixSort {

    int getMax(int arr[], int n) {
        int max = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] > max)
                max = arr[i];
        }

        return max;
    }

    void countSort(int arr[], int n, int exp) {

        int output[] = new int[n];
        int count[] = new int[10];

        for (int i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;

        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (int i = n - 1; i >= 0; i--) {

            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        for (int i = 0; i < n; i++)
            arr[i] = output[i];
    }

    void radixSort(int arr[], int n) {

        int max = getMax(arr, n);

        for (int exp = 1; max / exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }

    static void printArray(int arr[]) {

        for (int value : arr)
            System.out.print(value + " ");

        System.out.println();
    }

    public static void main(String args[]) {

        int shipmentIDs[] = {8031, 1050, 9502, 4210, 1500, 6023};

        System.out.println("========= Radix Sort =========");

        System.out.println("\nOriginal Shipment IDs");

        printArray(shipmentIDs);

        RadixSort obj = new RadixSort();

        obj.radixSort(shipmentIDs, shipmentIDs.length);

        System.out.println("\nSorted Shipment IDs");

        printArray(shipmentIDs);
    }
}
