public class DeadlockDemo {
    //Create a Deadlock
    static class Resources{
        public synchronized void  method1(Resources resources){
            System.out.println(Thread.currentThread().getName()+ " is Holding "+ this);
            try  {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO: handle exception
            }
            System.out.println(Thread.currentThread().getName()+" waiting for "+resources);
            resources.method2();
        }
        public synchronized void method2(){
            System.out.println(Thread.currentThread().getName()+" in the Mwthod 2");
        }

    }
    
    public static void main(String[] args) {
        final Resources resources1= new Resources();
        final Resources resources2= new Resources();
        new Thread(()-> resources1.method1(resources2),"Thread 1").start();
        new Thread(() -> resources2.method1(resources1), "Thread 2").start();
    }
}
