import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SomeTest {
    //public SelenideElement myActiveTicketsGrid = $("div#grid-1036");array-grid-1095
    //public SelenideElement myActiveTicketsGrid = $x("//div[@role='grid']");
    public SelenideElement myActiveTicketsGrid = $x("//div[text()=\"Basic Grid\"]");

    public SelenideElement loadIndicator = $("div#loadingSplashCircles");

    public ElementsCollection x = $$("div.loading-circle");

    @Test
    public void exp00() {
        //open("https://examples.sencha.com/extjs/7.8.0/examples/classic/ticket-app/");
        open("https://examples.sencha.com/extjs/7.8.0/examples/kitchensink/?classic#array-grid");


        pause(500);
        System.out.println(x.size());
        pause(500);
        System.out.println(x.size());
        pause(500);
        System.out.println(x.size());
        pause(500);
        System.out.println(x.size());
        pause(500);
        System.out.println(x.size());

        loadIndicator.should(disappear);

        pause(1000);
        myActiveTicketsGrid.shouldBe(visible).click();
        pause(1000);

    }

    private static void pause(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
