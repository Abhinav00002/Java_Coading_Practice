package Javaclass;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;

public class ObjectCreationExample {
    //1. Using the 'new' Keyword
    //2. Using reflection
    //3. Using Clone()
    //4. Using Deserialization
    //5. Using a Factory Method
    //6. Using Dependency Injection
    //7. Enum Singleton Pattern
    //8. Using Anonymous Classes
    //9. Using 'var' With 'new'
    public static void main(String[] args) throws Exception {

        //    1. Using the 'new' Keyword
        Car myCar = new Car();
        myCar.drive();

        // 2. Using reflection
        Object object = createWithReflection("Javaclass.ObjectCreationExample$Car");
        if (object instanceof Car) ((Car) object).drive();

        //3. Using Clone()
        CarClone carClone = new CarClone();
        CarClone clone = (CarClone) carClone.clone();
        System.out.println("Cloned Car Model: " + clone.model);

        //4. Using Deserialization
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        CarSerializable carSerializable = new CarSerializable();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(carSerializable);

        //5. Using a Factory Method
        Car myCar1 = CarFactory.createCar();
        myCar1.drive();

        //  6. Using Dependency Injection
        Engine engine = new Engine();
        CarWithEngine carWithEngine = new CarWithEngine(engine);
        carWithEngine.drive();

        //7. Enum Singleton Pattern
        SingletonCar.INSTANCE.drive();

        //8. Using Anonymous Classes
        ObjectCreationExample objectCreationExample = new ObjectCreationExample();
        objectCreationExample.createAnonymousCar();

        //9. Using 'var' With 'new'
        var car = new Car();
        car.drive();
    }
        //8. Using Anonymous Classes
    private void createAnonymousCar(){
        Car car = new Car(){
            @Override
            public void drive(){
                System.out.println("Anonymous car is driving..............");
            }
        };

    }

    //        7. Enum Singleton Pattern
    public  enum  SingletonCar{
        INSTANCE;
        public  void  drive(){
            System.out.println("Singleton car is Driving..............");
        }
    }

    //        6. Using Dependency Injection
    public static class Engine {
        public void start() {
            System.out.println("Engine Started .......");
        }
    }

    public static class CarWithEngine {
        private Engine engine;

        //      simulating Dependency Injection
        public CarWithEngine(Engine engine) {
            this.engine = engine;
        }

        public void drive() {
            engine.start();
            System.out.println("Car is driving........");
        }
    }

    //        5. Using a Factory Method
    public static class CarFactory {
        public static Car createCar() {
            return new Car();
        }
    }

    //    4. Using Deserialization (Serialization)
    public static class CarSerializable implements Serializable {
        public String model = "BMW";
    }

    //    3. Using Clone
    public static class CarClone implements Cloneable {
        public String model = "Tesla";

        @Override
        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }


    //    2. Using Reflection (Class.forName() and newInstance())
    public static Object createWithReflection(String className) throws Exception {
        Class<?> clazz = Class.forName(className);
        Constructor<?> constructor = clazz.getDeclaredConstructor(); // get no-arg constructor
        constructor.setAccessible(true); // in case it's private
        return constructor.newInstance(); // create instance
    }

    //    1. Using the 'new' Keyword
    public static class Car {
        public void drive() {
            System.out.println("Driving a Car..........");
        }
    }
}
