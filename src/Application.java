import Vehicle.Car;

public class Application {

    public static void main(String[] args) {
        for(int i=0; i<=1000; i++){
            Car car = new Car(20, "Car " + i);
            car.start();
        }

    }

}
