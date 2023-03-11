//wrapper instead of primitive: safe when it's non static
public class Main6 implements Runnable{

    @Override
    public void run() {
        MyThreadWrapperNonStatic mtw = new MyThreadWrapperNonStatic(Thread.currentThread().getId());
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