
import java.util.*;

public class q6 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while(cin.hasNextLine()) {
            int n = Integer.parseInt(cin.nextLine());
            String[] datas = cin.nextLine().split(" ");
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(datas[i]);
            }
            char[] colors = cin.nextLine().toCharArray();
            int ans = 0;
            Map<Integer,Integer> R = new HashMap<>();
            Map<Integer,Integer> B = new HashMap<>();
            for (int i = 0; i < colors.length; i++) {
                if(colors[i] == 'B'){
                    B.put(nums[i],B.getOrDefault(nums[i],0)+1);
                    ans += R.getOrDefault(nums[i],0);
                }else {
                    R.put(nums[i],R.getOrDefault(nums[i],0)+1);
                    ans += B.getOrDefault(nums[i],0);
                }
            }
            System.out.println(ans);
        }
    }
}

