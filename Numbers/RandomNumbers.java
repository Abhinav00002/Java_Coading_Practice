package Numbers;



public class RandomNumbers {
    /*by Using  Linear Congruential Generator (LCG) */   
    
    private static long seed;

    // LCG parameters
    private static final long a = 1664525;
    private static final long c = 1013904223;
    private static final long m = (1L << 32); // 2^32

    // Initialize the random generator with a seed
    public RandomNumbers(long seed) {
        this.seed = seed;
    }

    // Generate the next random number
    public int nextInt() {
        seed = (a * seed + c) % m;
        return (int) seed;
    }

    // Generate a random number within a specified range
    public int nextInt(int bound) {
        return nextInt() % bound; // Random number between 0 (inclusive) and bound (exclusive)
    }

    public static void main(String[] args) {
        // Example usage
        RandomNumbers random = new RandomNumbers(System.currentTimeMillis());

        System.out.println("Random Numbers:");
        for (int i = 0; i < 10; i++) {
            System.out.println("Random Integer: " + random.nextInt());
            System.out.println("Random Integer (0-9): " + random.nextInt(10));
        }
    }
}
