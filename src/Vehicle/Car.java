package Vehicle;

import java.util.Random;

public class Car extends Vehicle implements Runnable {
    private Thread t;
    private String carName;
    private boolean angry = false;

    public Car(int fuelTank, String name) {
        super(fuelTank);
        carName = name;
        System.out.println("Creating " + carName);
    }

    public void run() {
        try {
            for (int i = 21; i > 0; i--) {
                if (randomNumberGenerator() >= 7) {
                    System.out.println(carName + " crashed!");
                    t.stop();
                } else {
                    if (randomNumberGenerator() == 4) {
                        honk(carName);
                    }

                    if (getFuel() <= 8 && !angry) {
                        System.out.println("I need some fuel!");
                        angry = true;
                    }

                    if (getFuel() <= 1) {
                        System.out.println(carName + " is out of fuel");
                        if (randomNumberGenerator() >= 4) {
                            System.out.println(carName + " Has tanked");
                            tank(randomNumberGenerator());
                        } else {
                            System.out.println(carName + " Has no money and can't tank...");
                            t.stop();
                        }
                    }

                    drive(carName);
                    System.out.println("Red light," + carName + " is waiting..");
                    Thread.sleep(500);
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + carName + " interrupted.");
        }
        System.out.println(carName + " is parked.");
    }

    public void start() {
        System.out.println("Starting " + carName);
        if (t == null) {
            t = new Thread(this, carName);
            t.start();
        }
    }

    public int randomNumberGenerator() {
        Random rand = new Random();
        return rand.nextInt(10) - 1;
    }
}