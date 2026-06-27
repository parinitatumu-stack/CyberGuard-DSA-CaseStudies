import java.util.*;

public class MergeSort {

    void merge(int arr[], int l, int m, int r) {

        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for(int i=0;i<n1;i++)
            L[i]=arr[l+i];

        for(int j=0;j<n2;j++)
            R[j]=arr[m+1+j];

        int i=0,j=0,k=l;

        while(i<n1 && j<n2){

            if(L[i]<=R[j]){
                arr[k]=L[i];
                i++;
            }
            else{
                arr[k]=R[j];
                j++;
            }
            k++;
        }

        while(i<n1){
            arr[k]=L[i];
            i++;
            k++;
        }

        while(j<n2){
            arr[k]=R[j];
            j++;
            k++;
        }
    }

    void sort(int arr[],int l,int r){

        if(l<r){

            int m=(l+r)/2;

            sort(arr,l,m);
            sort(arr,m+1,r);

            merge(arr,l,m,r);
        }

    }

    static void printArray(int arr[]){

        for(int i:arr)
            System.out.print(i+" ");

        System.out.println();

    }

    public static void main(String args[]){

        int orderID[]={1089,1023,1056,1001,1045,1012};

        System.out.println("========= Merge Sort =========");

        System.out.println("\nOriginal Customer Order IDs");

        printArray(orderID);

        MergeSort obj=new MergeSort();

        obj.sort(orderID,0,orderID.length-1);

        System.out.println("\nSorted Customer Order IDs");

        printArray(orderID);

    }

}
