package be.intecbrussel.lambdatest.model;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class MeasurementApp {


    public SensorMeasurement[] generateMeasurementArray(int numberOfMeasurements) {

        SensorMeasurement[] measurements = new SensorMeasurement[ numberOfMeasurements ];
        for (int i = 0; i < measurements.length; i++) {
            measurements[ i ] = new RandomMeasurementGenerator().generateMeasurement();
        }
        return measurements;
    }


    public void printHighestTemperature(SensorMeasurement[] sensorMeasurements) {

        Stream.of(sensorMeasurements).forEach(s -> System.out.println(s.getHumidity().max(s.getHumidity())));
    }


    public void printSortedByLighIntensity(SensorMeasurement[] sensorMeasurements) {

        Stream.of(sensorMeasurements).sorted().forEach(s -> s.getLightIntensity());

    }

    public String[] mapToInfoString(SensorMeasurement[] sensorMeasurements) {

        String[] sensorMeasurementsToString = Arrays.stream(sensorMeasurements).toArray(String[]::new);
        return sensorMeasurementsToString;
    }

   /* public void printAverageTemperature(SensorMeasurement[] sensorMeasurements) {

        double result1 = DoubleStream.
                .reduce("", (carry, e) -> carry + e);


    }*/

    public static void main(String[] args) {

        RandomMeasurementGenerator randomMeasurementGenerator = new RandomMeasurementGenerator();
        randomMeasurementGenerator.generateMeasurement();


    }
}
