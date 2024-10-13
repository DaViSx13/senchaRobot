import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.google.common.collect.Ordering;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SomeTest01 {
    public SelenideElement table = $("table.sort");

    @Test
    public void exp00() {

        open("https://htmlweb.ru/java/example/sort_table2.php");

        table.shouldBe(visible).scrollIntoView(true);

        System.out.println("getColumnNumber(\"Имя\") = " + getColumnNumber("Имя"));
        System.out.println("getColumnNumber(\"Сайт\") = " + getColumnNumber("Сайт"));
        System.out.println("getColumnNumber(\"ID\") = " + getColumnNumber("ID"));

        System.out.println(getColumnValues("Имя"));
        System.out.println("isOrdered = " + Ordering.natural().isOrdered(getColumnValues("Имя")));
        System.out.println(getColumnValues("ID"));

        pause(1000);
        clickCloumnHeader("Имя");
        System.out.println(getColumnValues("Имя"));
        System.out.println("isOrdered = " + Ordering.natural().isOrdered(getColumnValues("Имя")));


        pause(1000);
        System.out.println("getColumnNumber(\"ID\") = " + getColumnNumber("ID"));
        clickCloumnHeader("ID");
        System.out.println(getColumnValues("ID"));

        pause(1000);
        System.out.println("getColumnNumber(\"Фамилия\") = " + getColumnNumber("Фамилия"));
        clickCloumnHeader("Фамилия");
        System.out.println(getColumnValues("Фамилия"));
        System.out.println("isOrdered = " + Ordering.natural().isOrdered(getColumnValues("Фамилия")));


        pause(3000);
    }

    private int getColumnNumber(String column) {
        table.shouldBe(visible);
        String xp = ".//thead/tr/*[text()='%s']".formatted(column);
        ElementsCollection cols = table.$$x(".//thead/tr/td");
        List<String> names = new ArrayList<>();
        cols.forEach(selenideElement -> names.add(selenideElement.getOwnText()));
        //System.out.println("names = " + names);
        int i = names.indexOf(column)+1;
        return i;
    }

    private List<String> getColumnValues(String column) {
        table.shouldBe(visible);
        int columnNumber = getColumnNumber(column);
        List<String> texts = table.$$x("./tbody//td[%d]".formatted(columnNumber)).texts();
        return texts;
    }

    public void clickCloumnHeader(String column) {
        table.shouldBe(visible);
        int columnNumber = getColumnNumber(column);
        table.$x(".//thead/tr//td[%d]".formatted(columnNumber)).click();
    }

    private static void pause(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
