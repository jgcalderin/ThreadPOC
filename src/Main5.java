//wrapper instead of primitive: unsafe when it's static
public class Main5 implements Runnable{

    @Override
    public void run() {
        MyThreadWrapperStatic mtw = new MyThreadWrapperStatic(Thread.currentThread().getId());
        try {
            Thread.sleep((long) (((Math.random() * (Main.MAXSLEEPFOR - 1)) + 1) * 1000));
            if (mtw.getThreadId() != Thread.currentThread().getId())
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