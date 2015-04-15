/**
 * Created by Yoder on 7/8/2014.
 */
public class WeeklyWeatherData {
    private double[] rain = {0.0};
    private double[] pressure = {0.0};
    private double maxRain;
    private double avgRain;

    public WeeklyWeatherData() {
        maxRain = rain[0];
        avgRain = 0.0;
    }

    public void setData(double[] rain, double[] pressure) {
        this.rain = rain;
        this.pressure = pressure;
    }

    public void calculateStats() {
        for(int i = 0; i < rain.length; i++) {
            if (maxRain < rain[i])
                maxRain = rain[i];

            avgRain += rain[i];
        }
        avgRain = avgRain/rain.length;
    }

    public double getMaxRain() {
        return maxRain;
    }

    public double getAvgRain() {
        return avgRain;
    }
}
