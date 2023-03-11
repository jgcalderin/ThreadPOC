//local threadID --> safe
public class Main1 implements Runnable{

    @Override
    public void run() {
        long threadId = Thread.currentThread().getId(); //safe
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