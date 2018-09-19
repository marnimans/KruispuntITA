package Vehicle;

public class Vehicle {

    private int fuelTank;

    public Vehicle(int fuelTank) {
        this.fuelTank = fuelTank;
    }

    public void honk(String string) {
        System.out.println(string + " Honking!");
    }

    public void drainFuel() {
        fuelTank--;
    }

    public int getFuel() {
        return this.fuelTank;
    }

    public void tank(int amount){
        this.fuelTank+= amount;
    }

    public void drive(String car) {
        drainFuel();
        System.out.println(car + "Is driving");
    }

}
