40
import java.util.Scanner;

public class Main {

    public static int value = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the value: ");
        value = scanner.nextInt();

        RecursionThread r = new RecursionThread();
        DynamicThread d = new DynamicThread();

        r.start();
        d.start();
    }

    static class RecursionThread extends Thread {
        public void run() {
            long startTime = System.currentTimeMillis();
            int result = fibonacci(value);
            long totalTime = System.currentTimeMillis() - startTime;
            System.out.println("Recursion Thread found the answer " + result +
                    " in " + totalTime + " ms");
        }

        int fibonacci(int n) {
            if(n == 0) return 0;
            if(n == 1) return 1;
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    static class DynamicThread extends Thread {
        public void run() {
            long startTime = System.currentTimeMillis();
            int result = fibonacci(value);
            long totalTime = System.currentTimeMillis() - startTime;
            System.out.println("Dynamic Thread found the answer " + result +
                    " in " + totalTime + " ms");
        }

        int fibonacci(int n) {
            int v1 = 0;
            int v2 = 1;
            int v3 = 0;
            for(int i = 2; i <= n; i++) {
                v3 = v1 + v2;
                v1 = v2;
                v2 = v3;
            }
            return v3;
        }
    }
}
