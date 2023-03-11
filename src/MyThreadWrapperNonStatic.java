public class MyThreadWrapperNonStatic {
    private final long threadId; //safe

    public MyThreadWrapperNonStatic(long _threadId) {
        threadId = _threadId;
    }


    public long getThreadId() {
        return threadId;
    }
}
