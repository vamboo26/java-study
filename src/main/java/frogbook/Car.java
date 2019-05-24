package frogbook;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Car {

    Tire tire;

    public Car(Tire tire) {
        this.tire = tire;
    }

    public String getTireBrand() {
        return "장착 된 타이어: " + tire.getBrand();
    }

    @Test
    public void test() {
        Car car = new Car(new KoreaTire());
        assertEquals("장착 된 타이어: 코리아 타이어", car.getTireBrand());
    }
}
