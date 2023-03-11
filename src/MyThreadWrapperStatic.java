public class MyThreadWrapperStatic {

    private static long threadId; //unsafe

    public MyThreadWrapperStatic(long _threadId) {
        threadId = _threadId;
    }


    public long getThreadId() {
        return threadId;
    }
}
