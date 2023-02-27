import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selectors.byAttribute;

public class UpdatingLoans {


    @BeforeAll
    public static void setupAllureReports() {
        Configuration.browser = "internet explorer";
        Configuration.browserSize = "1920x1080";
    }




    @Test
    public void updateLoans(){


        //Sign in
        $("http://10.192.64.1/MENU1/LOGIN7.CSP?LoginGUID=&CSPCHD=00fp00000000t7gBY0wBWgDROBNTGbttxjoQYgqrdO3MvSX8j7");
        $(byAttribute("name", "Username")).setValue("GILF");
        $(byAttribute("name", "Password")).setValue("Louie2022Taf");
        $("div.loginBtns input").click();
        $("div#MetroDash").shouldBe(Condition.visible);


        //Select company
        $(byXpath("//strong[.='כלים וניהול המערכת']/parent::a")).click();
        $(byXpath("//strong[.='החלפת חברה']/parent::a")).click();
        $("input#sHev").click();
//        $$(byXpath("//td[.='מכשיר ייעודי למימון טסט']")).last().click();
//        $(byXpath("//font[@color='white'][contains(text(), ' חברה : 50 - ')]")).shouldBe(Condition.visible);

        //test company
        $$(byXpath("//td[.='test company']")).last().click();
        $(byXpath("//font[@color='white'][contains(text(), ' חברה : 90 - ')]")).shouldBe(Condition.visible);

        //back to menu
        $(byXpath("//img[@src='/nikuv/image/tafnit7/metro/exit.png']")).click();

        //open loans
        $(byXpath("//strong[.='תפעול פיקדונות']/parent::a")).click();
        $(byXpath("//strong[.='ניהול פקדונות']/parent::a")).click();
        $(byXpath("//strong[.='קליטה וניהול פקדונות']/parent::a")).click();
        $(byXpath("//strong[.='סילוק פקדון']/parent::a")).click();
        $("div.newHeader").shouldBe(Condition.visible);


        //THIS PART SHOULD BE IN A CYCLE

        //update loan

        String pikadon = "test";

        $("input#sMKMH").click();
        $(byXpath("a[.='" + pikadon + "']")).click();
        $("input#MKMH").shouldHave(Condition.value(pikadon));


        //updating dates
        cleanInputValue($("input#ADTR"));
        $("input#ADTR").setValue("10/02/2023");
        $("input#ADTR").shouldHave(Condition.value("10/02/2023"));

        cleanInputValue($("input#TRHC"));
        $("input#TRHC").setValue("11/02/2023");
        $("input#TRHC").shouldHave(Condition.value("11/02/2023"));

        cleanInputValue($("input#TRHH"));
        $("input#TRHH").setValue("10/02/2023");
        $("input#TRHH").shouldHave(Condition.value("10/02/2023"));

        cleanInputValue($("input#TRSR"));
        $("input#TRSR").setValue("10/02/2023");
        $("input#TRSR").shouldHave(Condition.value("10/02/2023"));

        cleanInputValue($("input#TRDVH"));
        $("input#TRDVH").setValue("10/02/2023");
        $("input#TRDVH").shouldHave(Condition.value("10/02/2023"));


        //update other fields
        $("select#KMM").selectOption("לא מחויב");
        $("select#NSH").selectOption("14 מכירה בין 10 ל");
        $("input#SNIF").setValue("1");
        $("input#ADTR").click();

        //click to save
        $("//input[@value='אישור']/parent::div").click();




        sleep(15000);
    }

    public static void cleanInputValue(SelenideElement input){
        input.click();
        input.clear();
        int size = input.getValue().length();
        while(size>=0){
            input.sendKeys(Keys.BACK_SPACE, Keys.DELETE);
            size--;
        }
    }


}
