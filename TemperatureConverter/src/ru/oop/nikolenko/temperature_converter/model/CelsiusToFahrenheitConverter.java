package ru.oop.nikolenko.temperature_converter.model;

public class CelsiusToFahrenheitConverter implements CelsiusConverter {
    @Override
    public String getSecondScaleName() {
        return "Fahrenheit";
    }

    @Override
    public double convertTemperatureFromCelsius(double temperature) {
        return temperature * 1.8 + 32;
    }

    @Override
    public double convertTemperatureToCelsius(double temperature) {
        return (temperature - 32) * 5 / 9;
    }
}
