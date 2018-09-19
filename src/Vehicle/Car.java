package Vehicle;

import java.util.Random;

public class Car extends Vehicle implements Runnable, Driveable {
    private Thread t;
    private String threadName;
    private boolean angry = false;

    public Car(int fuelTank, String name) {
        super(fuelTank);
        threadName = name;
        System.out.println("Creating " + threadName);
    }

    @Override
    public void drive() {
        drainFuel();
        System.out.println(this.threadName + "Is driving");
    }

    public void run() {
        try {
            for (int i = 21; i > 0; i--) {
                if (crashChance() >= 7) {
                    System.out.println(threadName + " crashed!");
                    t.stop();
                } else {
                    if (crashChance() == 4) {
                        honk(threadName);
                    }

                    if(getFuel()<= 8 && !angry){
                        System.out.println("I need some fuel!");
                        angry=true;
                    }

                    if(getFuel()<=0){
                        System.out.println(threadName + " OUT OF FUEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEL");
                        t.stop();
                    }

                    drive();
                    System.out.println("Red light," + threadName + " is waiting..");
                    Thread.sleep(500);
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " interrupted.");
        }
        System.out.println(threadName + " is parked.");
    }

    public void start() {
        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }

    public int crashChance() {
        Random rand = new Random();
        return rand.nextInt(10) - 1;
    }
}