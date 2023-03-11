//
public class Main7 implements Runnable {

    @Override
    public void run() {
        try {
            if (method1(Thread.currentThread().getId()) != Thread.currentThread().getId())
                System.out.println("NOT SAFE !!!!!");
            else
                System.out.println("Bye (thread: " + Thread.currentThread().getId() + ")");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private long method1(long param1) throws InterruptedException {
        long ret = param1;
        Thread.sleep((long) (((Math.random() * (Main.MAXSLEEPFOR - 1)) + 1) * 1000));
        return ret;
    }
}