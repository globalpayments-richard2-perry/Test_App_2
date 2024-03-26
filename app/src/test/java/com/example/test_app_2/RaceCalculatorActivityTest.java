package com.example.test_app_2;

import org.junit.Test;
import static org.junit.Assert.*;

public class RaceCalculatorActivityTest {
    RaceCalculatorActivity raceCalculatorActivity = new RaceCalculatorActivity();

    @Test
    public void testCalculateTime() {
        float distance = 100;
        float speed = 50;
        float expectedTime = 2;
        float actualTime = raceCalculatorActivity.calculateTime(distance, speed);
        assertEquals(expectedTime, actualTime, 0.001);
    }

    @Test
    public void testCalculateSpeed() {
        float distance = 100;
        float time = 2;
        float expectedSpeed = 50;
        float actualSpeed = raceCalculatorActivity.calculateSpeed(distance, time);
        assertEquals(expectedSpeed, actualSpeed, 0.001);
    }

    @Test
    public void testCalculateDistance() {
        float speed = 50;
        float time = 2;
        float expectedDistance = 100;
        float actualDistance = raceCalculatorActivity.calculateDistance(speed, time);
        assertEquals(expectedDistance, actualDistance, 0.001);
    }

    @Test
    public void testCalculateTimeWithZero() {
        float distance = 0;
        float speed = 50;
        float expectedTime = 0;
        float actualTime = raceCalculatorActivity.calculateTime(distance, speed);
        assertEquals(expectedTime, actualTime, 0.001);
    }

    @Test
    public void testCalculateSpeedWithLargeNumbers() {
        float distance = 1000000;
        float time = 2;
        float expectedSpeed = 500000;
        float actualSpeed = raceCalculatorActivity.calculateSpeed(distance, time);
        assertEquals(expectedSpeed, actualSpeed, 0.001);
    }

    @Test
    public void testCalculateDistanceWithDecimalNumbers() {
        float speed = 50.5f;
        float time = 2.2f;
        float expectedDistance = 111.1f;
        float actualDistance = raceCalculatorActivity.calculateDistance(speed, time);
        assertEquals(expectedDistance, actualDistance, 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculateTimeWithNegativeSpeed() {
        float distance = 100;
        float speed = -50;
        raceCalculatorActivity.calculateTime(distance, speed);
    }

    @Test
    public void testCalculateTime2() {
        assertEquals(2.0, raceCalculatorActivity.calculateTime(100, 50), 0.001);
        assertEquals(2.2, raceCalculatorActivity.calculateTime(110, 50), 0.001);
        assertEquals(0.0, raceCalculatorActivity.calculateTime(0, 50), 0.001);
    }

    @Test(expected = ArithmeticException.class)
    public void testCalculateTimeWithZeroSpeed() {
        raceCalculatorActivity.calculateTime(100, 0);
    }

    @Test
    public void testCalculateSpeed2() {
        assertEquals(50.0, raceCalculatorActivity.calculateSpeed(100, 2), 0.001);
        assertEquals(55.0, raceCalculatorActivity.calculateSpeed(110, 2), 0.001);
        assertEquals(0.0, raceCalculatorActivity.calculateSpeed(0, 2), 0.001);
    }

    @Test(expected = ArithmeticException.class)
    public void testCalculateSpeedWithZeroTime() {
        raceCalculatorActivity.calculateSpeed(100, 0);
    }

    @Test
    public void testCalculateDistance2() {
        assertEquals(100.0, raceCalculatorActivity.calculateDistance(50, 2), 0.001);
        assertEquals(110.0, raceCalculatorActivity.calculateDistance(50, 2.2f), 0.001);
        assertEquals(0.0, raceCalculatorActivity.calculateDistance(50, 0), 0.001);
    }

    @Test
    public void testConvertMetersToFeet() {
        assertEquals(328.084, raceCalculatorActivity.convertMetersToFeet(100), 0.001);
        assertEquals(0.0, raceCalculatorActivity.convertMetersToFeet(0), 0.001);
    }

    @Test
    public void testConvertFeetToMeters() {
        assertEquals(30.48, raceCalculatorActivity.convertFeetToMeters(100), 0.001);
        assertEquals(0.0, raceCalculatorActivity.convertFeetToMeters(0), 0.001);
    }
}