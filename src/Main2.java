//field threadId --> unsafe
public class Main2 implements Runnable{

    long threadId;
    @Override
    public void run() {
        threadId = Thread.currentThread().getId(); //safe
        try {
            Thread.sleep((long) (((Math.random() * (Main.MAXSLEEPFOR - 1)) + 1) * 1000));
            if (threadId != Thread.currentThread().getId())
                System.out.println("NOT SAFE !!!!!");
            else
                System.out.println("Bye (thread: " + Thread.currentThread().getId() + ")");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}