import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SomeTest {
    //public SelenideElement myActiveTicketsGrid = $("div#grid-1036");array-grid-1095
    //public SelenideElement myActiveTicketsGrid = $x("//div[@role='grid']");
    public SelenideElement myActiveTicketsGrid = $x("//span[text()='Basic Grid']");


    public SelenideElement password_input = $("div.password input");
    public SelenideElement btnLogin = $x("//span[text()='Login']");


    public SelenideElement loadIndicator = $("div#loadingSplashCircles");

    public ElementsCollection x = $$("div.loading-circle");

    @Test
    public void exp00() {
        open("https://examples.sencha.com/extjs/7.8.0/examples/classic/ticket-app/");
        //open("https://examples.sencha.com/extjs/7.8.0/examples/kitchensink/?classic#array-grid");

        //loadIndicator.should(exist);
        //loadIndicator.should(disappear);

        Selenide.sleep(5000);
        btnLogin.shouldBe(visible).click();
        password_input.shouldBe(visible).setValue("111");

//        Selenide.sleep(500);
//        System.out.println(x.size());
//        Selenide.sleep(500);
//        System.out.println(x.size());
//        Selenide.sleep(500);
//        System.out.println(x.size());
//        Selenide.sleep(500);
//        System.out.println(x.size());
//        Selenide.sleep(500);
//        System.out.println(x.size());
//
//        loadIndicator.should(disappear);
//
//        Selenide.sleep(1000);
//        myActiveTicketsGrid.shouldBe(visible).click();
//        Selenide.sleep(1000);

    }

}
