package frogbook;

public class Driver {

    public static void main(String[] args) {
        Car car = new Car(new KoreaTire());
        System.out.println(car.getTireBrand());
    }

}
