package practiceForm.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationResultModal {
    public void buttonSubmit(){
        $("#submit").click();

    }

    public void verifyResult(String key, String value){
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));

    }

}