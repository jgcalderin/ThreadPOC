//local threadID --> safe
//field threadId --> unsafe
//field threadId + synchronized(this) --> safe, but slow (sequential)
//field threadId + synchronized(new Main()) --> unsafe
//field threadId + (new Thread(new Main())).start(); --> safe and fast (one new object for each thread)
//if wrapper instead of primitive: same behaviour: safe when field is not static, unsafe when it's static
public class Main  {
    public static final long MAXSLEEPFOR = 15;
    public static final long THREADCOUNT = 50;
    public static void main(String[] args) {

        int scenario = -1;
        if (args.length>=1) scenario =  Integer.parseInt(args[0]);

        if (scenario == -1 || scenario == 1)
        {
            System.out.println("Scenario 1: local threadID --> safe");
            ThreadGroup tg1 = new ThreadGroup("Group m1");
            Main1 m1 = new Main1();
            for (int i = 0; i < THREADCOUNT; i++) {
                (new Thread(tg1,m1)).start();
            }
            waitForThreadGroup(tg1);
        }
        else if (scenario == -1 || scenario == 2)
        {
            System.out.println("\n-------------------------------------");
            System.out.println("Scenario 2: field threadID --> unsafe");
            ThreadGroup tg2 = new ThreadGroup("Group m2");
            Main2 m2 = new Main2();
            for (int i = 0; i < THREADCOUNT; i++) {
                (new Thread(tg2,m2)).start();
            }

            waitForThreadGroup(tg2);
        }
        else if (scenario == -1 || scenario == 3) {
            System.out.println("\n-------------------------------------");
            System.out.println("Scenario 3: field threadId + synchronized(this) --> safe, but slow (sequential)");
            ThreadGroup tg3 = new ThreadGroup("Group m3");
            Main3 m3 = new Main3();
            for (int i = 0; i < THREADCOUNT; i++) {
                (new Thread(tg3,m3)).start();
            }

            waitForThreadGroup(tg3);
        }
        else if (scenario == -1 || scenario == 4) {
            System.out.println("\n-------------------------------------");
            System.out.println("Scenario 4: field threadId + synchronized(new Main()) --> unsafe though fast");
            ThreadGroup tg4 = new ThreadGroup("Group m4");
            Main4 m4 = new Main4();
            for (int i = 0; i < THREADCOUNT; i++) {
                (new Thread(tg4,m4)).start();
            }

            waitForThreadGroup(tg4);
        }
        else if (scenario == -1 || scenario == 5) {
            System.out.println("\n-------------------------------------");
            System.out.println("Scenario 5: same as 2, but (new Thread(new Main2())).start(); --> safe and fast (one new object for each thread)");
            ThreadGroup tg5 = new ThreadGroup("Group m5");
            //Main2 m2 = new Main2();
            for (int i = 0; i < THREADCOUNT; i++) {
                (new Thread(tg5,new Main2())).start();
            }

            waitForThreadGroup(tg5);
        }
        else if (scenario == -1 || scenario == 6) {
            System.out.println("\n-------------------------------------");
            System.out.println("Scenario 6: wrapper instead of primitive: unsafe when it's static");
            ThreadGroup tg6 = new ThreadGroup("Group m6");
            Main5 m5 = new Main5();
            for (int i = 0; i < THREADCOUNT; i++) {
                (new Thread(tg6,m5)).start();
            }

            waitForThreadGroup(tg6);
        }
        else if (scenario == -1 || scenario == 7) {
            System.out.println("\n-------------------------------------");
            System.out.println("Scenario 7: wrapper instead of primitive: safe when it's not static");
            ThreadGroup tg7 = new ThreadGroup("Group m7");
            Main6 m6 = new Main6();
            for (int i = 0; i < THREADCOUNT; i++) {
                (new Thread(tg7,m6)).start();
            }

            waitForThreadGroup(tg7);
        }
        else if (scenario == -1 || scenario == 8) {
            System.out.println("\n-------------------------------------");
            System.out.println("Scenario 8: internal method: safe");
            ThreadGroup tg8 = new ThreadGroup("Group m8");
            Main7 m7 = new Main7();
            for (int i = 0; i < THREADCOUNT; i++) {
                (new Thread(tg8,m7)).start();
            }

            waitForThreadGroup(tg8);
        }

    }

    private static void waitForThreadGroup(ThreadGroup tg)
    {
        do {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } while (tg.activeCount() > 0);
    }
}