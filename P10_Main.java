import java.util.LinkedList;

class ProducerConsumer {
    LinkedList<Integer> buffer = new LinkedList<>();
    int capacity = 5;
    int totalProduced = 0;
    int totalConsumed = 0;
    final int MAX_ITEMS = 10;

    public void produce() throws InterruptedException {
        int value = 0;
        while (totalProduced < MAX_ITEMS) {
            synchronized (this) {
                while (buffer.size() == capacity) {
                    wait();
                }

                if (totalProduced >= MAX_ITEMS) {
                    break;
                }

                System.out.println("Producer produced: " + value);
                buffer.add(value++);
                totalProduced++;

                notify();

                Thread.sleep(1000);
            } 
        }
    }

    public void consume() throws InterruptedException {
        while (totalConsumed < MAX_ITEMS) {
            synchronized (this) {
                while (buffer.isEmpty()) {
                    wait();
                }

                if (totalConsumed >= MAX_ITEMS) {
                    break;
                }

                int val = buffer.removeFirst();
                System.out.println("Consumer consumed: " + val);
                totalConsumed++;

                notify();

                Thread.sleep(1000);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        final ProducerConsumer pc = new ProducerConsumer();

        Thread producerThread = new Thread(() -> {
            try {
                pc.produce();
            } catch (InterruptedException e) {
                System.out.println("Interruption Occurred.");
            }
        });

        Thread consumerThread = new Thread(() -> {
            try {
                pc.consume();
            } catch (InterruptedException e) {
                System.out.println("Interruption Occurred.");
            }
        });

        producerThread.start();
        consumerThread.start();
    }
}
