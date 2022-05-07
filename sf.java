import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class sf {
    public static void main(String[] args) throws InterruptedException {
        var list = new ArrayList<Integer>(5);
        for (int i = 0; i < 12; i++) {
            list.add(i);
            System.out.println(list.toString());
        }
    }
}
