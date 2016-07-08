package random;

/*
The idea of binary search is to use the information that the array is sorted and 
reduce the time complexity to O(Logn). 
We basically ignore half of the elements just after one comparison.
1) Compare x with the middle element.
2) If x matches with middle element, we return the mid index.
3) Else If x is greater than the mid element, 
   then x can only lie in right half subarray after the mid element. 
   So we recur for right half.
4) Else (x is smaller) recur for the left half.
*/
public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6};
        System.out.println(binarySearch(arr, 0, 5, 4));
    }
    
    static int binarySearch(int arr[], int l, int r, int x) {
        if(r >= l) {
            int m = (l+r)/2;
            
            if(arr[m] == x) {
                return m;
            }
            
            if(arr[m] > x) {
                return binarySearch(arr, l, m-1, x);
            } else {
                return binarySearch(arr, m+1, r, x);
            }
        }
        return -1;
    }
}
