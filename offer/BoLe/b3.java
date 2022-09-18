package offer.BoLe;

import java.util.Arrays;

public class b3 {
    public static void main(String[] args) {
        System.out.println(smallestRange(new int[]{1,3,6},3));
    }

    private static int smallestRange (int[] A, int K) {
        // write code here
        int max = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<A.length;i++){
            max = Math.max(max,A[i]);
            min = Math.min(min,A[i]);
        }
        int diff = max - min;
        int mid = (max + min) / 2;
        for(int i = 0;i<A.length;i++){
            if(A[i] > mid){
                A[i] -= K;
            }else{
                A[i] += K;
            }
        }
        Arrays.sort(A);
        int sDiff = A[A.length-1] - A[0];
        return Math.min(sDiff,diff);
    }
}
