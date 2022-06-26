package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class RandomUtils {
    private final String ncr = "NCR", uttar = "Uttar Pradesh", haryana = "Haryana", rajasthan = "Rajasthan";

    public String setRandomGender() {
        int randomNum = getRandomInt(1, 3);

        if (randomNum == 1) {
            return "Male";
        } else if (randomNum == 2) {
            return "Female";
        } else {
            return "Other";
        }
    }

    public String[] setRandomDateBetween(int firstYear, int lastYear) {
        Calendar randomDate = new GregorianCalendar();

        int year = getRandomInt(firstYear, lastYear);

        randomDate.set(randomDate.YEAR, year);

        int dayOfYear = getRandomInt(1, randomDate.getActualMaximum(randomDate.DAY_OF_YEAR));

        randomDate.set(randomDate.DAY_OF_YEAR, dayOfYear);

        LocalDate localDate = LocalDate.of(randomDate.get(randomDate.YEAR),
                (randomDate.get(randomDate.MONTH) + 1), randomDate.get(randomDate.DAY_OF_MONTH));

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.ENGLISH);
        String fullDate = dateTimeFormatter.format(localDate);
        String[] arrayOfDate = fullDate.split(" ");

        return arrayOfDate;
    }

    public String[] setRandomSubjects() {
        String[] allSubjects = {"Computer Science", "English", "Chemistry", "Commerce", "Economics", "Social Studies",
                "Arts", "Maths", "History", "Accounting", "Physics", "Biology", "Hindi", "Civics"};

        return getShuffledStringArrayWithRandomLength(allSubjects);
    }

    public String[] setRandomHobbies() {
        String[] allHobbies = {"Music", "Reading", "Sports"};

        return getShuffledStringArrayWithRandomLength(allHobbies);
    }

    public String setRandomState() {
        int randomNum = getRandomInt(1, 4);

        if (randomNum == 1) {
            return ncr;
        } else if (randomNum == 2) {
            return uttar;
        } else if (randomNum == 3) {
            return haryana;
        } else {
            return rajasthan;
        }
    }

    public String setRandomCity(String currentState) {
        int randomNumFor3 = getRandomInt(1, 3);
        int randomNumFor2 = getRandomInt(1, 2);

        switch (currentState) {
            case (ncr):
                if (randomNumFor3 == 1) {
                    return "Delhi";
                } else if (randomNumFor3 == 2) {
                    return "Gurgaon";
                } else {
                    return "Noida";
                }

            case (uttar):
                if (randomNumFor3 == 1) {
                    return "Agra";
                } else if (randomNumFor3 == 2) {
                    return "Lucknow";
                } else {
                    return "Merrut";
                }

            case (haryana):
                return randomNumFor2 == 1 ? "Karnal" : "Panipat";

            default:
                return randomNumFor2 == 1 ? "Jaipur" : "Jaiselmer";
        }
    }

    private int getRandomInt(int min, int max) {
        Random r = new Random();

        return r.nextInt((max - min) + 1) + min;
    }

    private String[] getShuffledStringArrayWithRandomLength(String[] array) {

        List<String> subjects = new ArrayList<>(List.of(array));
        Collections.shuffle(subjects);
        int randomLength = getRandomInt(1, subjects.size());

        String[] randomArray = new String[randomLength];
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = subjects.get(i);
        }

        return randomArray;
    }
}
