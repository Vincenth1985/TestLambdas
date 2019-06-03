package be.intecbrussel.lambdatest.model;

import java.math.BigDecimal;
import java.util.Random;

/*
* Hier worden de randoms bijgevoegd aan de constructor van de SensorMeasurement.
* Deze methode gaat dienen om een array van Sensormeasurements te vullen.
*
* */


public class RandomMeasurementGenerator implements MeasurementGenerator {

    @Override
    public SensorMeasurement generateMeasurement() {

        Random random = new Random();
        SensorMeasurement sensorMeasurement = new SensorMeasurement(
                new BigDecimal(random.doubles(1, 0, 101).findFirst().getAsDouble()),
                new BigDecimal(random.doubles(1, -70, 70).findFirst().getAsDouble()),
                new BigDecimal(random.doubles(1, 0, 1001).findFirst().getAsDouble()));


        return sensorMeasurement;
    }
}
