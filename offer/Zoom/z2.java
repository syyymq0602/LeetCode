package offer.Zoom;

import java.util.*;

public class z2 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while(cin.hasNextLine()) {
            int q = Integer.parseInt(cin.nextLine());
            Map<String,String> nameAndG = new HashMap<>();
            Set<String> G = new HashSet<>();
            List<String> list = new ArrayList<>();
            while (q > 0){
                Integer totalG = 0;
                String out = "";
                String line = cin.nextLine();
                String[] ws = line.split(" ");
                if("1".equals(ws[0])){
                    String g = cin.nextLine();
                    nameAndG.put(ws[1],g);
                    String[] gs = g.split(" ");
                    G.addAll(Arrays.asList(gs));
                    --q;
                    continue;
                }else {
                    String name = ws[1];
                    if(!nameAndG.containsKey(name)){
                        System.out.println("error");
                    }else {
                        String rgp = nameAndG.get(name);
                        String[] pres = rgp.split(" ");
                        for (String pre : pres){
                            if(!G.contains(pre)){
                                ++totalG;
                            }
                        }
                        out = totalG.toString();
                        System.out.println(out);
                    }
                    --q;
                }
            }
        }
    }
}
