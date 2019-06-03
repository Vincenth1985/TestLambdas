package be.intecbrussel.lambdatest.model;

import java.util.Arrays;
import java.util.Objects;
import java.util.OptionalDouble;
import java.util.stream.Stream;

/*
 * 5 Statiche methode met gebruik maken van streams.
 * De generateMeasurementArray methode vul SensorMeasurements in een SensorMeasurement.
 *
 * */

public class MeasurementApp {


    public static SensorMeasurement[] generateMeasurementArray(int numberOfMeasurements) {

        SensorMeasurement[] measurements = new SensorMeasurement[ numberOfMeasurements ];
        for (int i = 0; i < measurements.length; i++) {
            measurements[ i ] = new RandomMeasurementGenerator().generateMeasurement();
        }
        return measurements;
    }

    public static void printHighestTemperature(SensorMeasurement[] sensorMeasurements) {

        Stream.of(sensorMeasurements).mapToDouble(s -> s.getTemperatureFahrenheit()
                .doubleValue())
                .max()
                .stream()
                .forEach(s -> System.out.format("\nHighest temperature in Fahrenheit : %11.2f Fahr.", s));

        Stream.of(sensorMeasurements).mapToDouble(s -> s.getTemperatureCelcius()
                .doubleValue())
                .max()
                .stream()
                .forEach(s -> System.out.format("\nHighest temperature in Celcius : %14.2f Celcius.", s));
    }

    public static void printSortedByLighIntensity(SensorMeasurement[] sensorMeasurements) {

        Stream.of(sensorMeasurements).mapToDouble(s -> s.getLightIntensity().doubleValue())
                .sorted()
                .forEach(s -> System.out.format("%4.2f Lummen\n", s));

    }

    public static String[] mapToInfoString(SensorMeasurement[] sensorMeasurements) {

        String[] sensorMeasurementsToString = Arrays.stream(sensorMeasurements)
                .map(Objects::toString)
                .toArray(String[]::new);


        return sensorMeasurementsToString;
    }

    public static void printAverageTemperature(SensorMeasurement[] sensorMeasurements) {

        OptionalDouble average = Arrays.stream(sensorMeasurements)
                .mapToDouble(s -> s.getTemperatureCelcius().doubleValue())
                .average();
        OptionalDouble averageFahrenheit = Arrays.stream(sensorMeasurements)
                .mapToDouble(s -> s.getTemperatureFahrenheit().doubleValue())
                .average();

        System.out.format("Average Temperature %.2f Celcius \n", average.getAsDouble());
        System.out.format("Average Temperature %.2f Fahrenheit \n", averageFahrenheit.getAsDouble());


    }

    public static void main(String[] args) {

        System.out.println("\nTest Lambdas en Steams");
        System.out.println("-".repeat(40));
        SensorMeasurement[] sensorMeasurements = generateMeasurementArray(3);

        Stream.of(sensorMeasurements).forEach(s -> System.out.println(s.toString()));
        System.out.println();

        printHighestTemperature(sensorMeasurements);
        System.out.println();

        System.out.println("\nSorting LightIntensity");
        System.out.println("-".repeat(40));
        printSortedByLighIntensity(sensorMeasurements);
        System.out.println();


        System.out.println("Convert in to String Array");
        System.out.println("-".repeat(40));
        String[] convertToString = mapToInfoString(sensorMeasurements);
        Stream.of(convertToString).forEach(s -> System.out.println(s));
        System.out.println();

        System.out.println("Average of Temperature");
        System.out.println("-".repeat(40));
        printAverageTemperature(sensorMeasurements);


    }
}
