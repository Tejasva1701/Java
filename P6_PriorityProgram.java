class NewThread extends Thread {
    private int threadPriority;

    public NewThread(String name, int threadPriority) {
        super(name);
        this.threadPriority = threadPriority;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(this.getName() + " is running..");
        }
    }

    public void setThreadPriority(int priority) {
        this.threadPriority = priority;
        super.setPriority(priority);
    }

    public int getThreadPriority() {
        return threadPriority;
    }
}

public class PriorityProgram {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Enter priorites for thread 1 and thread 2 respectively");
            return;
        }

        int thread1Priority = Integer.parseInt(args[0]);
        int thread2Priority = Integer.parseInt(args[1]);

        NewThread t1 = new NewThread("Thread 1", thread1Priority);
        NewThread t2 = new NewThread("Thread 2", thread2Priority);

        t1.setThreadPriority(thread1Priority);
        t2.setThreadPriority(thread2Priority);

        t1.start();
        t2.start();

        System.out.println("Thread 1 Priority: " + t1.getThreadPriority());
        System.out.println("Thread 2 Priority: " + t2.getThreadPriority());
    }
}
