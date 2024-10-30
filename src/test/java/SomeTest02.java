import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.google.common.collect.Ordering;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.github.seregamorph.hamcrest.OrderMatchers.softOrdered;
import static org.hamcrest.MatcherAssert.assertThat;

public class SomeTest02 {
    //public SelenideElement myActiveTicketsGrid = $("div#grid-1036");array-grid-1095
    public SelenideElement myActiveTicketsGrid = $x("//div[@role='grid']");
    //public SelenideElement myActiveTicketsGrid = $x("//span[text()='Basic Grid']");

    public SelenideElement col = myActiveTicketsGrid.$x(".//div[@role='columnheader']//span[text()='Price']");

    public SelenideElement passwordInput = $("div.password input");
    public SelenideElement btnLogin = $x("//span[text()='Login']");


    public SelenideElement loadIndicator = $("div#loadingSplashCircles");

    public ElementsCollection x = $$("div.loading-circle");

    private List<String> getColValues(String colName) {
        SortedMap<Integer, String> colValues = new TreeMap<>();
        String colId = getColIdByName(colName);

        String rowID = "";
        ElementsCollection rows = myActiveTicketsGrid.$$x(".//table[@data-recordindex]");

        //scroll up
        //ElementsCollection rows = myActiveTicketsGrid.$$x(".//table[@data-recordindex]");
        while ( !rowID.equalsIgnoreCase(rows.first().getAttribute("data-recordindex")) ) {
            rowID = rows.first().getAttribute("data-recordindex");
            rows.first().scrollIntoView(true);
            sleep(1000);
        }

        rows.forEach(row -> {
            String id = row.getAttribute("data-recordindex");
            String value = row.$x(".//td[@role='gridcell'][@data-columnid='%s']".formatted(colId)).text();
            colValues.put(Integer.valueOf(id), value);
        });

        //scroll down
        //ElementsCollection rows = myActiveTicketsGrid.$$x(".//table[@data-recordindex]");
        rowID = "";
        while ( !rowID.equalsIgnoreCase(rows.last().getAttribute("data-recordindex")) ) {
            rowID = rows.last().getAttribute("data-recordindex");
            rows.last().scrollIntoView(true);

            rows.forEach(row -> {
                String id = row.getAttribute("data-recordindex");
                String value = row.$x(".//td[@role='gridcell'][@data-columnid='%s']".formatted(colId)).text();
                colValues.put(Integer.valueOf(id), value);
            });

            sleep(200);
        }

        System.out.println(colValues);
        System.out.println(colValues.size());

        return colValues.values().stream().toList();

//        String colId = getColIdByName(colName);
//        ElementsCollection cols = myActiveTicketsGrid.$$x(".//td[@role='gridcell'][@data-columnid='%s']".formatted(colId));
//        System.out.println("cols.size() = " + cols.size());
//        System.out.println(cols.texts());
//        cols.last().scrollIntoView(true);
    }

    private String getColIdByName(String colName) {
        return myActiveTicketsGrid.$x(".//div[@role='columnheader'][//span[text()='%s']]".formatted(colName)).getAttribute("id");
    }

    private SelenideElement getColByName(String colName) {
        return myActiveTicketsGrid.$x(".//div[@role='columnheader']//span[text()='%s']".formatted(colName));
    }

    @BeforeTest
    private void setUp(){
        //open("https://examples.sencha.com/extjs/7.8.0/examples/classic/ticket-app/");
        open("https://examples.sencha.com/extjs/7.8.0/examples/kitchensink/?classic#array-grid");
        switchTo().frame( $x("//iframe") );

        //loadIndicator.should(exist);
        loadIndicator.should(disappear);
    }


    @Test
    public void exp00() {

        myActiveTicketsGrid.should(visible);
//        getColByName("Price").click();
//        System.out.println("getColIdByName(\"Price\") = " + getColIdByName("Price"));
//        sleep(2000);
//        getColByName("Price").click();
//        sleep(2000);
//        getColByName("Change").click();

        List<String> values = new ArrayList<>();

//        values = getColValues("Company");
//        System.out.println(values);
//        assertThat(values, softOrdered(Ordering.natural()));

        sleep(2000);
        getColByName("Company").click();
        sleep(2000);
        values = getColValues("Company");
        System.out.println(values);
        assertThat(values, softOrdered(Ordering.natural()));
        Assert.assertTrue( Ordering.natural().isOrdered(values) );

        sleep(2000);
        getColByName("Company").click();
        sleep(2000);
        values = getColValues("Company");
        System.out.println(values);
        assertThat(values, softOrdered(Ordering.natural().reversed()));
        Assert.assertTrue( Ordering.natural().reverse().isOrdered(values) );

        //passwordInput.shouldBe(visible).setValue("111");
        //btnLogin.shouldBe(visible).click();
        //Selenide.sleep(5000);
        //switchTo().newWindow(WindowType.TAB);
        //Selenide.sleep(5000);

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
