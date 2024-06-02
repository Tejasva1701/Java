public class MainThreadOperations {
    public static void main(String[] args) {
        displayThreadInfo(Thread.currentThread());
        changeThreadName("Main New");
        changeThreadPriority(Thread.MAX_PRIORITY);
        performOperations();
    }

    private static void displayThreadInfo(Thread thread) {
        System.out.println("Name of the thread: " + thread.getName());
        System.out.println("Priority of the thread: " + thread.getPriority());
    }

    private static void changeThreadName(String newName) {
        Thread.currentThread().setName(newName);
        System.out.println("New name of the thread: " + Thread.currentThread().getName());
    }

    private static void changeThreadPriority(int newPriority) {
        Thread.currentThread().setPriority(newPriority);
        System.out.println("New priority of the thread: " + Thread.currentThread().getPriority());
    }

    private static void performOperations() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("Main thread is running.. " + i);
                Thread.sleep(1000); 
            }
        } catch (InterruptedException e) {
            System.out.println("Interruption Occurred.");
        }
    }
}
