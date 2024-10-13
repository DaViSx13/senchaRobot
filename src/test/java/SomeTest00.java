import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SomeTest00 {
    public SelenideElement tableText = $x("//div[text()=\"Table with sorting\"]");
    public SelenideElement table = $x("//table-sorting-example/table");

    public SelenideElement loadIndicator = $("div#loadingSplashCircles");

    @Test
    public void exp00() {
        open("https://material.angular.io/components/table/overview#sorting");

        tableText.shouldBe(visible).scrollIntoView(true);



        pause(1000);
        String column_No = ".//div[text()=' No. ']//ancestor::th";
        table.$x(column_No).click();
        pause(1000);
        table.$x(column_No).click();
        pause(1000);
        table.$x(column_No).click();


        pause(3000);
    }

    private static void pause(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
