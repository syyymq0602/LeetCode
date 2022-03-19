package NK;

import java.util.Scanner;

public class NK1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            int count = scanner.nextInt();
            int index = 0;
            while (index < count){
                int num = scanner.nextInt();
                int[] x = new int[num];
                int[] y = new int[num];
                for (int i = 0; i < num; i++) {
                    x[i] = scanner.nextInt();
                }
                for (int i = 0; i < num; i++) {
                    y[i] = scanner.nextInt();
                }
                int sum =0;
                for (int i = 0; i < num; i++) {
                    for (int j = i; j < num; j++) {
                        if((x[i] > x[j]&&y[i]>y[j])||(x[i] < x[j]&&y[i]<y[j])){
                            sum++;
                        }
                    }
                }
                System.out.println(sum);
                index++;
            }
        }
    }
}
