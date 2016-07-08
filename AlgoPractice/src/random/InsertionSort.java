package random;

/*
Algorithm
// Sort an arr[] of size n
insertionSort(arr, n)
Loop from i = 1 to n-1.
……a) Pick element arr[i] and insert it into sorted sequence arr[0…i-1]

Example: 
12, 11, 13, 5, 6
Let us loop for i = 1 (second element of the array) to 5 (Size of input array)

i = 1. Since 11 is smaller than 12, move 12 and insert 11 before 12
11, 12, 13, 5, 6

i = 2. 13 will remain at its position as all elements in A[0...i-1] are smaller than 13
11, 12, 13, 5, 6

i = 3. 5 will move to the beginning and all other elements from 11 to 13 will move one position ahead of their current position.
5, 11, 12, 13, 6

i = 4. 6 will move to position after 5, and elements from 11 to 13 will move one position ahead of their current position.
5, 6, 11, 12, 13

Time Complexity = O(n^2)
Space Complexity = O(1)
Stable
*/
public class InsertionSort {
    public static void main(String[] args) {
        int arr[] = {12, 11, 13, 5, 6};
        InsertionSort is = new InsertionSort();
        is.insertionSort(arr);
        for(int x : arr) {
            System.out.print(x+" ");
        }
    }
    
    void insertionSort(int arr[]) {
        int n = arr.length;
        for(int i=1; i<n; i++) {
            int hole = arr[i];
            int j=i-1;
            while(j>=0 && arr[j] > hole) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = hole;
        }
    }
}
