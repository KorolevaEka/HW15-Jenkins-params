package pages;

import com.codeborne.selenide.SelenideElement;

import practiceForm.components.CalendarComponent;
import practiceForm.components.RegistrationResultModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    private CalendarComponent calendar = new CalendarComponent();
    private RegistrationResultModal registrationResultModal = new RegistrationResultModal();

    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            setDateOfBirthDate = $("#dateOfBirthInput"),
            genterWrapperInput = $("#genterWrapper"),
            userPhone = $("#userNumber"),
            subjects = $("#subjectsInput"),
            currentAddress = $("#currentAddress"),
            userHobbies = $("#hobbiesWrapper"),
            state = $("#state"),
            stateInput = $("#react-select-3-input"),
            city = $("#city"),
            cityInput = $("#react-select-4-input"),
            picture = $("#uploadPicture"),
            titleText = $("#example-modal-sizes-title-lg");

    public RegistrationPage openPage() {
        open("/automation-practice-form");

        return this;
    }

    public RegistrationPage closeBan() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genterWrapperInput.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setPhoneNumber(String value) {
        userPhone.setValue(value);

        return this;
    }

    public RegistrationPage setSubjects(String value) {
        subjects.setValue(value).pressEnter();

        return this;

    }

    public RegistrationPage setCurrentAddress(String value) {
        currentAddress.setValue(value);

        return this;

    }

    public RegistrationPage setBirthDate(String day, String month, String year) {
        setDateOfBirthDate.click();
        calendar.setDate(day, month, year);

        return this;
    }


    public RegistrationPage verifyResult(String key, String value) {
        registrationResultModal.verifyResult(key, value);

        return this;
    }

    public RegistrationPage clickButton() {
        registrationResultModal.buttonSubmit();

        return this;
    }


    public RegistrationPage titleText() {
        titleText.shouldHave(text("Thanks for submitting the form"));

        return this;
    }

    public RegistrationPage setHobbies(String value) {
        userHobbies.parent().$(byText(value)).click();
        return this;
    }

    public RegistrationPage uploadFile(String value) {
        picture.uploadFromClasspath(value);


        return this;
    }

    public RegistrationPage setState(String value) {
        state.click();
        stateInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setCity(String value) {
        city.click();
        cityInput.setValue(value).pressEnter();

        return this;
    }
}