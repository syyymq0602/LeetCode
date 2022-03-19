
import java.util.*;

public class q5 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while(cin.hasNextLine()) {
            String n1 = cin.nextLine();
            List<String> rows = new ArrayList<>();
            int index = 0;
            while (index < 2) {
                rows.add(cin.nextLine());
                index++;
            }
            int n = Integer.parseInt(n1);
            String[] row1 = rows.get(0).split(" ");
            String[] row2 = rows.get(1).split(" ");
            int[] colors = new int[row1.length];
            for (int i = 0; i < row1.length; i++) {
                colors[i] = Integer.parseInt(row1[i]);
            }
            int[] pos = new int[row2.length];
            for (int i = 0; i < row2.length; i++) {
                pos[i] = Integer.parseInt(row2[i]);
            }
            int black = 0;
            int white = 0;
            Map<Integer,Integer> map = new Hashtable<>();
            for (int i = 0; i < colors.length; i++) {
                int whiteCount = 0;
                int blackCount = 0;
                for (int j = 0; j < pos.length; j++) {
                    if (colors[i] == 0) {
                        whiteCount++;
                        map.put(i,whiteCount);
                    }
                }
            }
        }
    }
}
