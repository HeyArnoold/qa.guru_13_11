package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static tests.DataForTests.*;

public class PracticeFormTests extends TestBase {

    @Test
    @Owner("Max")
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Заполнение полей и корректная выдача на проверку")
    @Story("Форма должна корректно заполнятся и выдавать ожидаемый результат")
    @DisplayName("Set and check fields")
    @Description("Этот тетс проверяет заолнение полей, а так же выдачу в окне результата")
    @Link(name = "Practice Form", url = "https://demoqa.com/")
    void setAndCheckFields() {

        step("Открываем страницу с web формой", () -> {
            practiceForm.openPage();
        });

        step("Зполняем поля web формы", () -> {
            practiceForm.setFullName(FIRST_NAME, LAST_NAME)
                    .setEmail(USER_EMAIL)
                    .setGender(GENDER)
                    .setMobileNumber(USER_NUMBER)
                    .setDayOfBirth(DATE)
                    .setSubject(SUBJECTS)
                    .setHobbies(HOBBIES)
                    .uploadPicture(FILE_NAME)
                    .setCurrentAddress(CURRENT_ADDRESS)
                    .setStateAndCity(STATE, CITY);
        });

        step("Нажимаем кнопку submit", () -> {
            practiceForm.submit();
        });

        step("Проверяем построчно результат в появившемся окне", () -> {
            practiceForm.checkResult(FULL_NAME_LINE, FIRST_NAME + " " + LAST_NAME)
                    .checkResult(EMAIL_LINE, USER_EMAIL)
                    .checkResult(GENDER_LINE, GENDER)
                    .checkResult(MOBILE_LINE, USER_NUMBER)
                    .checkDate(DATE_OF_BIRTH_LINE, DATE)
                    .checkResult(SUBJECTS_LINE, SUBJECTS)
                    .checkResult(HOBBIES_LINE, HOBBIES)
                    .checkResult(PICTURE_LINE, FILE_NAME)
                    .checkResult(ADDRESS_LINE, CURRENT_ADDRESS)
                    .checkResult(STATE_AND_CITY_LINE, STATE + " " + CITY);
        });
    }
}
