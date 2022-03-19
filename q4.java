
import java.util.Scanner;

public class q4 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while(cin.hasNextLine()) {
            String row1 = cin.nextLine();
            int N = Integer.parseInt(row1.split(" ")[0]);
            int L = Integer.parseInt(row1.split(" ")[1]);
            for(;L<=100;L++){
                double a1=(2*N+L-L*L)/(2.0*L);
                System.out.println(a1);
                int a11= (int) a1;
                if(a1>=0 && Math.abs(a1-a11)<0.0001){
                    for(int i=0;i<L;i++) {
                        int res=a11+i;
                        System.out.print(res+" ");
                    }
                    return;
                }
            }
            System.out.print("No");
        }
    }
}
