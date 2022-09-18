import java.util.Arrays;

public class q9 {
    // 合并两个有序数组
    public static void main(String[] args) {
        merge(new int[]{4,5,6,0,0,0},3,new int[]{1,2,3},3);
    }

    public static void merge(int A[], int m, int B[], int n) {
        int[] nums = new int[m + n];
        int index1 = 0;
        int index2 = 0;
        int index = 0;
        while (index1 < m && index2 < n){
            if(A[index1] <= B[index2]){
                nums[index] = A[index1];
                index1++;
            }else {
                nums[index] = B[index2];
                index2++;
            }
            index++;
        }

        while (index1 < m || index2 < n){
            if(index1 < m){
                nums[index] = A[index1];
                index1++;
            }else {
                nums[index] = B[index2];
                index2++;
            }
            index++;
        }

        System.out.println(Arrays.toString(nums));
    }

}
