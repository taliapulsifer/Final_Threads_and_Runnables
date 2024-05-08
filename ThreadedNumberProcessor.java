public class ThreadedNumberProcessor {
    private static final double[] numbers = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0};

    public static void main(String[] args) {
        Runnable squareRootCalculator = () -> {
            for (double number : numbers) {
                System.out.println("  Square root of " + number + " is " + Math.sqrt(number));
            }
        };

        Runnable squareCalculator = () -> {
            for (double number : numbers) {
                System.out.println("    Square of " + number + " is " + (number * number));
            }
        };

        Runnable recipCalc = () -> {
            for (double number : numbers) {
                System.out.println(" Reciprocal of " + number + " is " + (1/number));
            }
        };

        Thread thread1 = new Thread(squareRootCalculator);
        Thread thread2 = new Thread(squareCalculator);
        Thread thread3 = new Thread(recipCalc);

        // Start the threads
        thread1.start();
        thread2.start();
        thread3.start();

        try {
            // Wait for both threads to finish execution
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            System.err.println("Thread interrupted: " + e.getMessage());
        }

        System.out.println("All computations are done!");
    }
}