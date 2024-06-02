class ChildThread extends Thread {
    private int threadNum;

    public ChildThread(int threadNum) {
        this.threadNum = threadNum;
    }

    public void run() {
        System.out.println("Child Thread " + threadNum + " started.");
        try {
            Thread.sleep(2000); 
        } catch (InterruptedException e) {
            System.out.println("Interruption Occurred.");
        }
        System.out.println("Child Thread " + threadNum + " finished.");
    }
}

public class MainThread {
    public static void main(String[] args) {
        System.out.println("Main Thread started.");

        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new ChildThread(i);
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Interruption Occurred.");
            }
        }

        System.out.println("Main Thread finished.");
    }
}
