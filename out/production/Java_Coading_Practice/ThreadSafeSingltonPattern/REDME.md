# Thread-Safe Singleton Pattern in Java

## 🔍 Description

This project demonstrates how to implement a **thread-safe Singleton pattern** using **Double-Checked Locking** in Java.

The Singleton pattern ensures a class has **only one instance**, and provides a **global access point** to it.

---

## 🧠 Key Concepts

### ✅ Singleton Pattern

- Ensures only one instance of a class is created.
- Useful for resources like configuration, logging, caching, database connections, etc.

### ✅ Thread-Safety

- When multiple threads access `getInstance()` concurrently, it must not create multiple instances.
- Achieved via synchronization.

### ✅ Lazy Initialization

- The instance is **created only when needed**, not at class load time.
- Improves performance and memory efficiency.

### ✅ Double-Checked Locking

- Avoids the cost of synchronization **after the instance is initialized**.
- First check is unsynchronized for performance.
- Second check is synchronized for safety.

---

## 🧩 Code Structure

### `Singleton.java`

- Uses `private static volatile Singleton instance` to ensure visibility across threads.
- `getInstance()` method uses double-checked locking.
- `private Singleton()` prevents external instantiation.

### `Main.java`

- Demonstrates thread safety by creating multiple threads accessing the Singleton.
- Shows that only one instance is created regardless of thread count.

---

## 🧙‍♂️ Spooky Facts about Singleton 🕷️

> 💀 **The Singleton Conjuring**  
> Once a Singleton is created, **it can never die** — unless the whole JVM goes down. 
> That instance will haunt your heap, immortal and unavoidable, lurking in memory...

> 🧟 **The Phantom Debugger**  
> Developers often believe they fixed a bug, only to find the Singleton **retaining state from a previous test run**, 
> causing ghostly, unexplained behavior.

> 👻 **Multithreaded Nightmares**  
> If you write a non-thread-safe Singleton and test it single-threaded, all seems calm... until the system is deployed. 
> Then the **duplicate instances emerge from the shadows**, leading to corrupt state and horror stories in production.

> 🔮 **Reflection: The Forbidden Ritual**  
> Java's reflection API can **resurrect** the Singleton class with a new instance, breaking its sacred contract. 
> To defend against this dark art, developers seal their constructors — or use Enums (the holy relic).

---

## 🚀 How to Run

1. Compile both Java files:
   ```bash
   javac Singleton.java Main.java


































////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
1. The Singleton Conjuring – Immortal Instance
   Once a Singleton is created, it cannot die. It haunts the heap until the JVM is exorcised (shut down).

java
Copy
Edit
// SingletonConjuring.java
public class SingletonConjuring {
private static volatile SingletonConjuring instance;

    private SingletonConjuring() {
        System.out.println("👻 A ghostly SingletonConjuring instance has appeared...");
    }

    public static SingletonConjuring getInstance() {
        if (instance == null) {
            synchronized (SingletonConjuring.class) {
                if (instance == null) {
                    instance = new SingletonConjuring();
                }
            }
        }
        return instance;
    }

    public void haunt() {
        System.out.println("💀 The Singleton still haunts this heap...");
    }
}
Run in Main.java:

java
Copy
Edit
public class Main {
public static void main(String[] args) {
SingletonConjuring ghost = SingletonConjuring.getInstance();
ghost.haunt();
}
}
✅ 2. The Phantom Debugger – Singleton Retaining Old State
Singleton can remember previous state between test runs, causing ghost-like bugs.

java
Copy
Edit
// PhantomDebugger.java
public class PhantomDebugger {
private static PhantomDebugger instance;
private String cursedData = "👻 Default Curse";

    private PhantomDebugger() {}

    public static PhantomDebugger getInstance() {
        if (instance == null) {
            instance = new PhantomDebugger();
        }
        return instance;
    }

    public void setCurse(String curse) {
        this.cursedData = curse;
    }

    public void revealCurse() {
        System.out.println("🧙‍♂️ The curse is: " + cursedData);
    }
}
Run in Main.java:

java
Copy
Edit
public class Main {
public static void main(String[] args) {
PhantomDebugger ghostA = PhantomDebugger.getInstance();
ghostA.setCurse("☠️ You’ll debug this forever...");
ghostA.revealCurse();

        // Imagine running this in another test or thread later
        PhantomDebugger ghostB = PhantomDebugger.getInstance();
        ghostB.revealCurse(); // Still haunted by the same curse!
    }
}
✅ 3. Multithreaded Nightmares – Broken Singleton with No Locking
When Singleton is not thread-safe, multiple ghosts (instances) appear under load.

java
Copy
Edit
// NightmareSingleton.java (NOT thread-safe!)
public class NightmareSingleton {
private static NightmareSingleton instance;

    private NightmareSingleton() {
        System.out.println("😱 A duplicate NightmareSingleton was born!");
    }

    public static NightmareSingleton getInstance() {
        if (instance == null) {
            instance = new NightmareSingleton(); // Race condition here!
        }
        return instance;
    }
}
Run multithreaded in Main.java:
 
public class Main {
public static void main(String[] args) {
Runnable summon = () -> {
NightmareSingleton badSingleton = NightmareSingleton.getInstance();
};

        for (int i = 0; i < 10; i++) {
            new Thread(summon).start();
        }
    }
}
🧟‍♂️ Output (sometimes):

😱 A duplicate NightmareSingleton was born!
😱 A duplicate NightmareSingleton was born!
✅ 4. Reflection – Breaking the Seal of the Singleton
Reflection can break the Singleton pattern by invoking the private constructor.
 

// ReflectionAttack.java
import java.lang.reflect.Constructor;

public class ReflectionAttack {
public static void main(String[] args) {
try {
Singleton victim = Singleton.getInstance();
System.out.println("🛡️ Original instance: " + victim);

            // Use reflection to break the singleton
            Constructor<Singleton> constructor = Singleton.class.getDeclaredConstructor();
            constructor.setAccessible(true); // Forbidden ritual!
            Singleton evilTwin = constructor.newInstance();

            System.out.println("🔮 Evil twin instance: " + evilTwin);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
💡 Fix tip: Defend your Singleton constructor:

 
private Singleton() {
if (instance != null) {
throw new RuntimeException("🚫 You cannot create another Singleton! It already exists!");
}
}