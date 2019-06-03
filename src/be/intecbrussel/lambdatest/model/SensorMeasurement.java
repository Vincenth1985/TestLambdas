package be.intecbrussel.lambdatest.model;

import java.math.BigDecimal;

public class SensorMeasurement {

    private BigDecimal humidity;
    private BigDecimal temperature;
    private BigDecimal lightIntesity;


    public SensorMeasurement(BigDecimal humidity, BigDecimal temperature, BigDecimal lightIntesity) {
        this.humidity = humidity;
        this.temperature = temperature;
        this.lightIntesity = lightIntesity;
    }

    public BigDecimal getHumidity() {
        return humidity;
    }

    public BigDecimal getLightIntesity() {
        return lightIntesity;
    }

    public BigDecimal getTemperatureCelcius() {
        return temperature;
    }

    public BigDecimal getTemperatureFahrenheit(){
        return temperature;
    }


}
