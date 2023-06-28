package ait.cars.test;

import ait.cars.dao.Garage;
import ait.cars.dao.GarageImpl;
import ait.cars.model.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GarageTest {
    Garage garage;
    Car[] cars;

    @BeforeEach
    void setUp() {
        garage = new GarageImpl(5);
        cars = new Car[4];
        cars[0] = new Car("Number1", "Model1", "Company1", 1.5, "Red");
        cars[1] = new Car("Number2", "Model2", "Company1", 2.5, "Green");
        cars[2] = new Car("Number3", "Model3", "Company2", 1.5, "Red");
        cars[3] = new Car("Number4", "Model4", "Company2", 2.0, "Green");
        for (int i = 0; i < cars.length; i++) {
            garage.addCar(cars[i]);
        }
    }

    @Test
    void addCar() {
        assertFalse(garage.addCar(cars[0]));
        Car car = new Car("Number5", "Model4", "Company2", 2.0, "Green");
        assertTrue(garage.addCar(car));
        car = new Car("Number6", "Model4", "Company2", 2.0, "Green");
        assertFalse(garage.addCar(car));
    }

    @Test
    void removeCar() {
        assertEquals(cars[0], garage.removeCar("Number1"));
        assertNull(garage.removeCar("Number1"));
    }

    @Test
    void findCarByRegNumber() {
        Car car = garage.findCarByRegNumber("Number4");
        assertEquals(cars[3], car);
        assertEquals(cars[3].getColor(), car.getColor());
        assertEquals(cars[3].getEngine(), car.getEngine());
        assertEquals(cars[3], garage.findCarByRegNumber(new String("Number4")));
    }

    @Test
    void findCarsByModel() {
        Car[] expecteds = { cars[2] };
        Car[] actuals = garage.findCarsByModel(new String("Model3"));
        assertArrayEquals(expecteds, actuals);
    }

    @Test
    void findCarsByCompany() {
        Car[] expecteds = { cars[2], cars[3] };
        Car[] actuals = garage.findCarsByCompany("Company2");
        assertArrayEquals(expecteds, actuals);
    }

    @Test
    void findCarsByEngine() {
        Car[] expecteds = { cars[1], cars[3] };
        Car[] actuals = garage.findCarsByEngine(1.9, 2.6);
        assertArrayEquals(expecteds, actuals);
    }

    @Test
    void findCarsByColor() {
        Car[] expecteds = { cars[0], cars[2] };
        Car[] actuals = garage.findCarsByColor(new String("Red"));
        assertArrayEquals(expecteds, actuals);
        assertArrayEquals(new Car[0], garage.findCarsByColor("Black"));
    }
}