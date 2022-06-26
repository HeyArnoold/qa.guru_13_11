package tests;

import com.github.javafaker.Faker;
import utils.*;

public class DataForTests {
    private static Faker faker = new Faker();
    private static RandomUtils randomUtils = new RandomUtils();

    public static final String FIRST_NAME = faker.address().firstName();
    public static final String LAST_NAME = faker.address().lastName();
    public static final String USER_EMAIL = faker.internet().emailAddress();
    public static final String GENDER = randomUtils.setRandomGender();
    public static final String USER_NUMBER = faker.phoneNumber().subscriberNumber(10);
    public static final String[] DATE = randomUtils.setRandomDateBetween(1980, 2010);
    public static final String[] SUBJECTS = randomUtils.setRandomSubjects();
    public static final String[] HOBBIES = randomUtils.setRandomHobbies();
    public static final String FILE_NAME = "testPicture.png";
    public static final String CURRENT_ADDRESS = faker.address().streetAddress();
    public static final String STATE = randomUtils.setRandomState();
    public static final String CITY = randomUtils.setRandomCity(STATE);

    public static final String FULL_NAME_LINE = "Student Name";
    public static final String EMAIL_LINE = "Student Email";
    public static final String GENDER_LINE = "Gender";
    public static final String MOBILE_LINE = "Mobile";
    public static final String DATE_OF_BIRTH_LINE = "Date of Birth";
    public static final String SUBJECTS_LINE = "Subjects";
    public static final String HOBBIES_LINE = "Hobbies";
    public static final String PICTURE_LINE = "Picture";
    public static final String ADDRESS_LINE = "Address";
    public static final String STATE_AND_CITY_LINE = "State and City";
}
