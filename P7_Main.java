class PrintTable {
    synchronized void printTable(int num) {
        System.out.println("Table of " + num);
        for (int i = 1; i <= 10; i++) {
            System.out.println(num + " * " + i + " = " + (num * i));
        }
        System.out.println("");
    }
}

class TablePrinter implements Runnable {
    PrintTable printTable;
    int num;

    TablePrinter(PrintTable printTable, int num) {
        this.printTable = printTable;
        this.num = num;
    }

    public void run() {
        printTable.printTable(num);
    }
}

public class Main {
    public static void main(String[] args) {
        PrintTable printTable = new PrintTable();
        Thread t1 = new Thread(new TablePrinter(printTable, 5));
        Thread t2 = new Thread(new TablePrinter(printTable, 7));

        t1.start();
        t2.start();
    }
}
