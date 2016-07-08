package random;

/*
MergeSort is a Divide and Conquer algorithm. 
It divides input array in two halves, calls itself for the two halves and 
then merges the two sorted halves. 
The merg() function is used for merging two halves. 
The merge(arr, l, m, r) is key process that assumes that arr[l..m] and 
arr[m+1..r] are sorted and merges the two sorted sub-arrays into one.


MergeSort(arr[], l,  r)
If r > l
     1. Find the middle point to divide the array into two halves:  
             middle m = (l+r)/2
     2. Call mergeSort for first half:   
             Call mergeSort(arr, l, m)
     3. Call mergeSort for second half:
             Call mergeSort(arr, m+1, r)
     4. Merge the two halves sorted in step 2 and 3:
             Call merge(arr, l, m, r)

Time Complexity = O(nlogn)
Space Complexity = O(n)
Stable
*/
public class MergeSort {
    public static void main(String[] args) {
        int arr[] = {5, 4, 3, 2, 1};
        int l = 0; 
        int r = arr.length-1;
        mergeSort(arr, l, r);
        for(int x : arr) {
            System.out.print(x+" ");
        }
    }
    
    static void mergeSort(int arr[], int l , int r) {
        if(l<r) {
            int m = (l+r)/2;
            mergeSort(arr, l, m);
            mergeSort(arr, m+1, r);
            merge(arr, l, m, r);
        }
    }
    
    static void merge(int arr[], int l, int m, int r) {
        // Merges two subarrays of arr[].
        // First subarray is arr[l..m]
        // Second subarray is arr[m+1..r]
        int n1 = m - l + 1;
        int n2 = r - m;
        
        int L[] = new int[n1];
        int R[] = new int[n2];
        for(int i=0; i<n1; i++) {
            L[i] = arr[l+i];
        }
        for(int i=0; i<n2; i++) {
            R[i] = arr[m+1+i];
        }
        
        int i=0, j=0, k=l;
        while(i<n1 && j<n2) {
            if(L[i]<R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        
        while(i<n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        
        while(j<n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
