package js.caf.logic;

import java.util.List;

import js.caf.domain.DailyForecast;
import js.caf.exception.NotEnoughDataPointsException;

/**
 * Created by mentlsve on 22/11/16.
 */
public class AverageForecastCalculator {

    public float calculateAverageMaxTemperatureOverDays(List<DailyForecast> dailyForecasts, int numberOfDays){
		if (dailyForecasts.size() <= 2) {
			throw new NotEnoughDataPointsException();
		}

		float average = 0.0f;

		int min = Math.min(dailyForecasts.size(), numberOfDays);
		for (int i = 0; i < min; i++) {
			average += dailyForecasts.get(i).getMaxTemperatureInCelsius();
		}
		average /= min;

		return average;
    }

}
