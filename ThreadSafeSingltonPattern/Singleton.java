package ThreadSafeSingltonPattern;

public class Singleton {
    // Step 1: Create a private static volatile instance of Singleton
    private static volatile Singleton instance;

    // Step 2: Private constructor to prevent instantiation
    private Singleton() {
        //Optional: Add intialization logic
        System.out.println("Singleton instance created");
    }

    // Step 3: Public method to provide global access point with double-checked locking
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                //Double check
                if (instance == null)
                    instance = new Singleton();
            }
        }
        return instance;
    }
    // Example Method
    public void showMsg() {
        System.out.println("Hello From  👻Ghost!");
    }

    //     Main Method
    public static void main(String[] args) {
            // Create multiple treads to thread safety
        Runnable task = () -> {
            Singleton sing = Singleton.getInstance();
            sing.showMsg();
        };

         // create and Start Multiple Threads
        Thread t1 = new Thread(task);
        Thread thread = new Thread(task);
        Thread thread1 = new Thread(task);
         t1.run();
         thread1.run();
         thread.run();


    }


}
