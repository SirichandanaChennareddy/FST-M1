package JavaActivities;

import java.time.Duration;
import java.time.LocalDateTime;

public class Activity3 {
	
	public static void main(String[] args) {
        LocalDateTime dateTime = LocalDateTime.of(1972, 06, 01, 00, 00, 00);
        Duration showSeconds = calculateAgeDuration(dateTime, LocalDateTime.now());
        long myAgeInSeconds=calculateTime(showSeconds.getSeconds());

        double EarthSeconds =     31557600; // 1 year = 365.4 days considering leap year
        double MercurySeconds =   7603200;  // 1 year = 88 days
        double VenusSeconds =     19440000; // 1 year=  225 days
        double MarsSeconds =      59356800; // 1 year=  687 days
        double JupiterSeconds =   374371200;// 1 year=  4333 days
        double SaturnSeconds =    929577600;// 1 year = 10759 days
        double UranusSeconds =    265135680;// 1 year = 30687 days actual seconds are 30687*24*3600
        double NeptuneSeconds =   520041600;// 1 year = 60190 days actual seconds are 60190*24*3600

        System.out.println("Age on Mercury: " + myAgeInSeconds / MercurySeconds);
        System.out.println("Age on Venus: " +   myAgeInSeconds / VenusSeconds);
        System.out.println("Age on Earth: " +   myAgeInSeconds / EarthSeconds);
        System.out.println("Age on Mars: " +    myAgeInSeconds / MarsSeconds);
        System.out.println("Age on Jupiter: " + myAgeInSeconds / JupiterSeconds);
        System.out.println("Age on Saturn: " +  myAgeInSeconds / SaturnSeconds);
        System.out.println("Age on Uranus: " +  myAgeInSeconds / UranusSeconds);
        System.out.println("Age on Neptune: " + myAgeInSeconds / NeptuneSeconds);
    }
    //Method to calculate the Age in Years and Months and Days
    public static Duration calculateAgeDuration(LocalDateTime dayBefore, LocalDateTime currentDay) {
        return Duration.between(dayBefore, currentDay);
    }
    public static long calculateTime(long timeSeconds) {
        long days = timeSeconds / 86400; // 24*60*60
        long hours = timeSeconds / 3600;
        long minutes = (timeSeconds % 3600) / 60;
        long seconds = (timeSeconds % 3600) % 60;

        long  totalSeconds= (hours)*60*60 +(minutes)*60+(seconds);
        
        System.out.println("Your age in Seconds :"+totalSeconds);
        return totalSeconds;
    }

}
