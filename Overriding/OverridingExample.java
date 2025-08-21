package Overriding;

public class OverridingExample {
    class A {
        void display() {
            System.out.println("Displaying from A");
        }
    }

    class B extends A {
        @Override
        void display() { // Method overriding in class B
            System.out.println("Displaying from B");
        }
    }
    public static void main(String[] args) {
        // Create an object of class A
        OverridingExample obj = new OverridingExample();
        A a = obj.new A();
        a.display(); // Calls the method from class A

        // Create an object of class B
        B b = obj.new B();
        b.display(); // Calls the method from class B
    }
}
