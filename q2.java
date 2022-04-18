import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class q2 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while(cin.hasNextInt()) {
            int T = cin.nextInt();
            while (T-- >0){
                int n = cin.nextInt();
                int[] nums = new int[n];
                for (int i = 0; i < n; i++) {
                    nums[i] = cin.nextInt();
                }
                List<Integer> list = new ArrayList<>();
                int pre;
                if(nums[0] >= nums[1]){
                    pre = 0;
                    list.add(nums[0]);
                }else {
                    pre = 1;
                    list.add(nums[1]);
                }
                while (pre + 2 < n){
                    if(nums[pre + 1] >= nums[pre+2]){
                        list.add(nums[pre+1]);
                        pre = pre+1;
                    }else {
                        list.add(nums[pre+2]);
                        pre = pre +2;
                    }
                }
                if(pre != n-1){
                    if(nums[pre] < nums[n-1]){
                        list.add(nums[n-1]);
                    }
                }
                int[] ans = new int[list.size()];
                for (int i = 0; i < list.size(); i++) {
                    ans[i] = list.get(i);
                }
                Arrays.sort(ans);
                int index = list.size()/2;
                if(list.size()%2 == 1){
                    System.out.println(ans[index]);
                }else {
                    System.out.println(ans[index-1]);
                }
            }
        }
    }
}
