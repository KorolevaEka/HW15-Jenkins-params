package practiceForm.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import practiceForm.utils.Utils;

import static io.qameta.allure.Allure.step;


public class PracticeFormTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    Utils utils = new Utils();

    @Feature("Форма регистрации")
    @Story("Начало")
    @Owner("kate")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Aaa", url = "ya.ru")
    @DisplayName("Регистрация нового пользователя")
    @Tag("smoke")
    @Test
    void successfulRegistrationTest() {
        step("Open form",() -> {
            registrationPage.openPage()
                    .closeBan();
        });
        step("Filling form", () -> {
            registrationPage.setFirstName(utils.userName)
                    .setLastName(utils.lastName)
                    .setEmail(utils.userEmail)
                    .setGender(utils.userGender)
                    .setPhoneNumber(utils.userNumber)
                    .setBirthDate(utils.day, utils.month, utils.year)
                    .setSubjects(utils.subject)
                    .setHobbies(utils.hobbies)
                    .uploadFile(utils.file)
                    .setCurrentAddress(utils.currentAddress)
                    .setState(utils.state)
                    .setCity(utils.city)
                    .clickButton();
        });
        step("Check form", () -> {
            registrationPage.titleText()
                    .verifyResult("Student Name", utils.userName + " " + utils.lastName)
                    .verifyResult("Student Email", utils.userEmail)
                    .verifyResult("Gender", utils.userGender)
                    .verifyResult("Mobile", utils.userNumber)
                    .verifyResult("Date of Birth", utils.day + " " + utils.month + "," + utils.year)
                    .verifyResult("Subjects", utils.subject)
                    .verifyResult("Hobbies", utils.hobbies)
                    .verifyResult("Picture", utils.file.replaceAll("src/test/resources/", ""))
                    .verifyResult("Address", utils.currentAddress)
                    .verifyResult("State and City", utils.state + " " + utils.city);
        });
    }

    @Tag("regress")
    @Feature("Форма регистрации")
    @DisplayName("Заполнение формы без проверки")
    @Test
    void shortRegistrationTest() {
        step("Открытие",() -> {
            registrationPage.openPage()
                    .closeBan();
        });
        step("Заполнение формы", () -> {
            registrationPage.setFirstName(utils.userName)
                    .setLastName(utils.lastName)
                    .setEmail(utils.userEmail)
                    .setGender(utils.userGender)
                    .setPhoneNumber(utils.userNumber)
                    .setBirthDate(utils.day, utils.month, utils.year)
                    .setSubjects(utils.subject)
                    .setHobbies(utils.hobbies)
                    .uploadFile(utils.file)
                    .setCurrentAddress(utils.currentAddress)
                    .setState(utils.state)
                    .setCity(utils.city)
                    .clickButton();
        });

    }

}