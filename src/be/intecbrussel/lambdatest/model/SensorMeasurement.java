package be.intecbrussel.lambdatest.model;

import java.math.BigDecimal;

public class SensorMeasurement {

    private BigDecimal humidity;
    private BigDecimal temperature;
    private BigDecimal lightIntensity;


    public SensorMeasurement(BigDecimal humidity, BigDecimal temperature, BigDecimal lightIntensity) {
        this.humidity = humidity;
        this.temperature = temperature;
        this.lightIntensity = lightIntensity;
    }


    public BigDecimal getHumidity() {
        return humidity;
    }

    public BigDecimal getLightIntensity() {
        return lightIntensity;
    }

    public BigDecimal getTemperatureCelcius() {
        return temperature;
    }

    public BigDecimal getTemperatureFahrenheit() {
        double temperatureFahr;
        temperatureFahr = (temperature.doubleValue() * 1.8) + 32;
        return new BigDecimal(temperatureFahr);
    }

    @Override
    public String toString() {
        return String.format("SensorMeasurements " + "Humidity = %5.2f%% " + "Temperature = %6.2f Celcius (%6.2f Fahrenheit) " + "LightIntensity = %6.2f Lummen "
                , humidity.doubleValue()
                , temperature.doubleValue()
                , getTemperatureFahrenheit()
                , lightIntensity.doubleValue());
    }
}
