
import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;

public class q7 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while(cin.hasNextLine()) {
            int T = Integer.parseInt(cin.nextLine());
            while (T-- >0){
                int n = Integer.parseInt(cin.nextLine());
                String[] mls = new String[n];
                for (int i = 0; i < n; i++) {
                    mls[i] = cin.nextLine().trim();
                }
                String out = "Yes";
                if(n % 2 == 1 || !mls[n-1].startsWith("end")){
                    System.out.println("No");
                    continue;
                }
                Stack<String> stack = new Stack<>();
                int index = 0;
                while (index < n){
                    if(!mls[index].startsWith("end")){
                        stack.push(mls[index]);
                    }else {
                        String judge = mls[index].split(" ")[1].trim();
                        if(stack.isEmpty()){
                            out = "No";
                            break;
                        }else {
                            String res = stack.pop();
                            if(!judge.equals(res)){
                                out = "No";
                                break;
                            }
                        }
                    }
                    index++;
                }
                if(!stack.isEmpty()){
                    out = "No";
                }
                System.out.println(out);
            }
        }
    }
}
