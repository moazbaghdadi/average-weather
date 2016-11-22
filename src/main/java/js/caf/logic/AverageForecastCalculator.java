package js.caf.logic;

import java.util.List;

import js.caf.domain.DailyForecast;
import js.caf.exception.NotEnoughDataPointsException;

/**
 * Created by mentlsve on 22/11/16.
 */
public class AverageForecastCalculator {

    public float calculateAverageMaxTemperatureOverDays(List<DailyForecast> dailyForecasts, int numberOfDays){
        if(dailyForecasts.size() <= 1) {
        	throw new NotEnoughDataPointsException();
        }
        
        if(dailyForecasts.size() < numberOfDays) {
        	throw new NotEnoughDataPointsException();
        }
        float sum = 0f;
        
        for (int i = 0; i<numberOfDays; i++) {
        	sum += dailyForecasts.get(i).getMaxTemperatureInCelsius() + 32;
        }
        float result = sum/numberOfDays; 
    	return result;
    }

}
