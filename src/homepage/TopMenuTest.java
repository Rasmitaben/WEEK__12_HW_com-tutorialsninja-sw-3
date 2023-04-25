package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    public void selectMenu(String menu) {
        if (menu == "Computers") {
            //Select computer tab and click
            clickOnElement(By.linkText("Computers"));
            //Verify the page navigation
            assertVerifyText(By.xpath("//div[@class='page-title']"),"Computers");
        } else if (menu == "electronics") {
            clickOnElement(By.linkText("electronics"));
            assertVerifyText(By.className("page-title"), "electronics");
        } else if (menu == "Apparel") {
            clickOnElement(By.linkText("Apparel"));
            assertVerifyText(By.className("page-title"),"Apparel");
        } else if (menu == "Digital downloads") {
            clickOnElement(By.linkText("Digital downloads"));
            assertVerifyText(By.className("page-title"),"Digital downloads");
        } else if (menu == "Books") {
            clickOnElement(By.linkText("Books"));
            assertVerifyText(By.className("page-title"),"Books");
        } else if (menu == "Jewelry") {
            clickOnElement(By.linkText("Jewelry"));
            assertVerifyText(By.className("page-title"),"Jewelry");
        } else if (menu == "Gift Cards") {
            clickOnElement(By.linkText("Gift Cards"));
            assertVerifyText(By.className("page-title"),"Gift Cards");
        } else {
            System.out.println("Please enter valid Top-menu tab or check actual name");
        }
    }

    @Test
    //1. verifyUserShouldNavigateToDesktopsPageSuccessfully()
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully(){
        //1.1 Mouse hover on “Desktops” Tab and click
        mouseHoverOnElement(By.linkText("Desktops"));

        //1.2 call selectMenu method and pass the menu = “Show All Desktops”
        String menu = "Show AllDesktops";
        selectMenu(menu);

        //1.3 Verify the text ‘Desktops’
        assertVerifyText(By.xpath("//h2[normalize-space()='Desktops']"),"Desktops");
    }
    @Test
    //2. verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully()
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully(){
        //2.1 Mouse hover on “Laptops & Notebooks” Tab and click
        mouseHoverOnElement(By.linkText("Laptops & Notebooks"));

        //2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        String menu = "Show All Laptops & Notebooks";
        selectMenu(menu);

        //2.3 Verify the text ‘Laptops & Notebooks’
        assertVerifyText(By.xpath("//h2[normalize-space()='Laptops & Notebooks']"),"Show All Laptops & Notebooks");
    }

@After
    public void tearDown(){
        //closing the Browser
    driver.close();

}

}


