package random;

/*
The selection sort algorithm sorts an array by repeatedly finding the minimum element 
(considering ascending order) from unsorted part and putting it at the beginning. 

arr[] = 64 25 12 22 11

// Find the minimum element in arr[0...4]
// and place it at beginning
11 25 12 22 64

// Find the minimum element in arr[1...4]
// and place it at beginning of arr[1...4]
11 12 25 22 64

// Find the minimum element in arr[2...4]
// and place it at beginning of arr[2...4]
11 12 22 25 64

// Find the minimum element in arr[3...4]
// and place it at beginning of arr[3...4]
11 12 22 25 64 

Time Complexity = O(n^2)
Space Complexity = O(1)
Unstable
*/
public class SelectionSort {
    public static void main(String[] args) {
        int arr[] = {5, 4, 3, 2, 1, 0, -1};
        selectionSort(arr);
        for(int x : arr) {
            System.out.print(x+" ");
        }
    }
    
    static void selectionSort(int arr[]) {
        int n = arr.length;
        for(int i=0; i<n; i++) {
            int minInd = i;
            for(int j=i+1; j<n; j++) {
                if(arr[j] < arr[minInd]) {
                    minInd = j;
                }
            }
            //Swap ith element with the minIndex
            int temp = arr[minInd];
            arr[minInd] = arr[i];
            arr[i] = temp;
        }
    }
}
