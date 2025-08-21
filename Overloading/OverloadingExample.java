package Overloading;

public class OverloadingExample {
    static class A {
        void show() {
            System.out.println("A");
        }
    }
    static class B extends A {
        void show(int x) {
            System.out.println("B");
        }
    }

    public class Test {
        public static void main(String[] args) {
            B obj = new B();
            obj.show();
        }
    }


//    public static void main(String[] args) {
//        A a= new A();
//        // Call Method
//        a.display(1);
//        a.display("Ghost");
//        a.display(1);
//    }
}
