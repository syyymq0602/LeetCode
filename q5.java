
import java.util.*;

public class q5 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while(cin.hasNextLine()) {
            String[] split = cin.nextLine().split(" ");
            int n = Integer.parseInt(split[0]);
            int m = Integer.parseInt(split[1]);
            int total = 2 * m;
            String[] titles = new String[m];
            String[] contents = new String[m];
            int index = 0;
            while (index < total){
                if(index % 2 == 0){
                    titles[index/2] = cin.nextLine();
                }else {
                    contents[index/2] = cin.nextLine();
                }
                index++;
            }
            Map<String,Integer> map = new Hashtable<>();
            for (int i = 0; i < m; i++) {
                String[] split1 = titles[i].split(" ");
                for (int j = 0; j < split1.length; j++) {
                    map.put(split1[j],map.getOrDefault(split1[j],0)+3);
                }
            }
            for (int i = 0; i < m; i++) {
                String[] split1 = contents[i].split(" ");
                for (int j = 0; j < split1.length; j++) {
                    map.put(split1[j],map.getOrDefault(split1[j],0)+1);
                }
            }
            int size = map.size();
            int[] counts = new int[size];
            int i=0;
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                counts[i] = entry.getValue();
                i++;
            }
            List<Integer> ans = new ArrayList<>();
            Arrays.sort(counts);
            for (int j = counts.length-1; j >=0; j--) {
                if(n == 0){
                    break;
                }
                ans.add(counts[j]);
                while (j>0&&counts[j-1] == counts[j]){
                    j--;
                }
                n--;
            }
            String s = "";
            for (int j = 0; j < ans.size(); j++) {
                s += ans.get(j) + " ";
            }
            System.out.println(s.trim());
        }
    }
}

