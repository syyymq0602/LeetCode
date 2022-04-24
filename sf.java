
public class sf {
    public static void main(String[] args) {
        Runnable task = () ->  System.out.println("task执行");

        Thread thread = new Thread(task);
        thread.start();

        System.out.println("1111");
    }
}
