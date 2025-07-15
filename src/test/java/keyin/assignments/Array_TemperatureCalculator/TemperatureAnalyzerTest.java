package keyin.assignments.Array_TemperatureCalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureAnalyzerTest {


    @Test
    void calculatesCorrectAverage() {
        int[] temperatures = {10, 20, 30};
        double result = TemperatureAnalyzer.calculateAverage(temperatures);
        assertEquals(20.00, result);
    }

    @Test
    void countDaysAboveAverage_returnsCorrectCountForMixedValues() {
        int[] temperatures = {10, 20, 30};
        double averageTemperature = 20.00;
        double result = TemperatureAnalyzer.countDaysAboveAverage(temperatures, averageTemperature);
        assertEquals(1, result);
    }

    @Test
    void countDaysAboveAverage_returnsZeroWhenAllEqual() {
        int[] temperatures = {20, 20, 20};
        double averageTemperature = 20.00;
        double result = TemperatureAnalyzer.countDaysAboveAverage(temperatures, averageTemperature);
        assertEquals(0, result);
    }
}