import java.util.concurrent.atomic.AtomicInteger;

public class q8 {
    static int c1 = -1;
    static q8 q = new q8();
    static int c2 = 2;
    static int c3 = 5;
    static {
        c3++;
    }
    private q8(){
        c1++;
        c2++;
        ++c3;
    }
    public static q8 getInstance(){
        return q;
    }
    public static void main(String[] args) {
        q8 qq = q8.getInstance();
        System.out.println(q8.c1);
        System.out.println(q8.c2);
        System.out.println(q8.c3);
    }
}
