package be.intecbrussel.lambdatest.model;

import java.math.BigDecimal;
import java.util.Random;
import java.util.stream.DoubleStream;

public class RandomMeasurementGenerator implements MeasurementGenerator {

    @Override
    public SensorMeasurement generateMeasurement() {

        Random random = new Random();
        SensorMeasurement sensorMeasurement = new SensorMeasurement(
                new BigDecimal(random.doubles(1, 0, 100).findFirst().getAsDouble()),
                new BigDecimal(random.doubles(1, 0, 10001).findFirst().getAsDouble()),
                new BigDecimal(random.doubles(1, -70, 70).findFirst().getAsDouble()));


        return sensorMeasurement;
    }
}
