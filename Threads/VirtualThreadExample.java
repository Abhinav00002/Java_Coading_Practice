package Threads;

public class VirtualThreadExample {
    public static void main(String[] args) {
        Runnable task = () -> System.out.println("Running in: " + Thread.currentThread());
        Thread.currentThread();
    }
}

