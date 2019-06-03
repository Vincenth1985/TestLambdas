package be.intecbrussel.lambdatest.model;

@FunctionalInterface
public interface MeasurementGenerator {

     SensorMeasurement generateMeasurement();
}
