import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class templateInput1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String s = scanner.nextLine();
            int n = Integer.parseInt(s.split(" ")[0]);
            int m = Integer.parseInt(s.split(" ")[1]);
            int c = 0;
            List<String> inputs = new ArrayList<>();
            while (c < n){
                String in = scanner.nextLine();
                inputs.add(in);
                c++;
            }
            String[] row1 = inputs.get(0).split(" ");
            String[] row2 = inputs.get(1).split(" ");
            int[] colors = new int[row1.length];
            for (int i = 0; i < row1.length; i++) {
                colors[i] = Integer.parseInt(row1[i]);
            }
            int[] pos = new int[row2.length];
            for (int i = 0; i < row2.length; i++) {
                pos[i] = Integer.parseInt(row2[i]);
            }
            System.out.println(colors.length);
            System.out.println(pos.length);
        }
    }
}
