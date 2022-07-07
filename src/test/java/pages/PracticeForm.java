package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponents;
import pages.components.ResultsTableComponent;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class PracticeForm {
    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement emailInput = $("#userEmail");
    private final SelenideElement genderElement = $("#genterWrapper");
    private final SelenideElement mobileNumberInput = $("#userNumber");
    private final SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    private final CalendarComponents calendarComponents = new CalendarComponents();
    private final SelenideElement subjectInput = $("#subjectsInput");
    private final SelenideElement hobbyElement = $("#hobbiesWrapper");
    private final SelenideElement pictureInput = $("#uploadPicture");
    private final SelenideElement addressInput = $("#currentAddress");
    private final SelenideElement stateElement = $("#state");
    private final SelenideElement cityElement = $("#city");
    private final SelenideElement submitElement = $("#submit");
    private final ResultsTableComponent resultsTableComponent = new ResultsTableComponent();

    public PracticeForm openPage() {
        open("automation-practice-form");
        executeJavaScript("$('#RightSide_Advertisement').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public PracticeForm setFullName(String firstName, String lastName) {
        firstNameInput.setValue(firstName);
        lastNameInput.setValue(lastName);

        return this;
    }

    public PracticeForm setEmail(String email) {
        emailInput.setValue(email);

        return this;
    }

    public PracticeForm setGender(String gender) {
        genderElement.$(byText(gender)).click();

        return this;
    }

    public PracticeForm setMobileNumber(String mobileNumber) {
        mobileNumberInput.setValue(mobileNumber);

        return this;
    }

    public PracticeForm setDayOfBirth(String... date) {

        dateOfBirthInput.click();
        calendarComponents.setDate(date[0], date[1], date[2]);

        return this;
    }

    public PracticeForm setSubject(String... subjects) {
        for (String subject : subjects) {
            subjectInput.sendKeys(subject);
            subjectInput.pressEnter();
        }

        return this;
    }

    public PracticeForm setHobbies(String... hobbies) {
        for (String hobby : hobbies) {
            hobbyElement.$(byText(hobby)).click();
        }

        return this;
    }

    public PracticeForm uploadPicture(String fileName) {
        pictureInput.uploadFromClasspath(fileName);

        return this;
    }

    public PracticeForm setCurrentAddress(String address) {
        addressInput.setValue(address);

        return this;
    }

    public PracticeForm setStateAndCity(String state, String city) {
        stateElement.click();
        $(byText(state)).scrollTo().click();
        cityElement.click();
        $(byText(city)).scrollTo().click();

        return this;
    }

    public PracticeForm submit() {
        submitElement.scrollTo().click();

        return this;
    }

    public PracticeForm checkResult(String key, String value) {
        resultsTableComponent.checkResult(key, value);

        return this;
    }

    public PracticeForm checkResult(String key, String... values) {
        StringBuilder valuesAsString = new StringBuilder();

        for (String value : values) {
            valuesAsString.append(value);
            valuesAsString.append(", ");
        }
        valuesAsString.delete(valuesAsString.length() - 2, valuesAsString.length());

        resultsTableComponent.checkResult(key, String.valueOf(valuesAsString));

        return this;
    }

    public PracticeForm checkDate(String key, String... date) {
        String dateAsString = date[0] + " " + date[1] + "," + date[2];
        resultsTableComponent.checkResult(key, dateAsString);

        return this;
    }
}
