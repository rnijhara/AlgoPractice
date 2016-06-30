package greedyalgos;


import java.io.*;
import java.util.*;

class ActivitySelection {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // No. of testcases
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine()); // No. of activities
            int activity[][] = new int[n][2]; // Nx2 array which will store start and finish time of each activity
            for (int i = 0; i < n; i++) {
                String s[] = br.readLine().split(" ");
                activity[i][0] = Integer.parseInt(s[0]);
                activity[i][1] = Integer.parseInt(s[1]);
            }
            //Input Taken. Now sort the activity array according to the finish time.
            Comparator cmp = new Comparator<int[]>() {
                @Override
                public int compare(int a[], int b[]) {
                    return a[1] - b[1]; // since we have to sort acc. to fin time we use 1 here. fin time is stored in activity[i][1]
                }
            };
            Arrays.sort(activity, cmp);
            int count = 1;
            System.out.println("0 ");
            int selectedFinishTime = activity[0][1]; // first activity is always selected.
                    // now if next activity has start time greater than the fin time of previously selected activity, then select it.
            for (int i = 1; i < n; i++) {
                if (activity[i][0] > selectedFinishTime) {
                    selectedFinishTime = activity[i][1];
                    count++;
                    System.out.println(i + " ");
                }
            }
            System.out.println("");
            System.out.println(count);
        }
    }
}
