package myaccounts;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;
import java.util.UUID;

public class MyAccountsTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    public void selectMyAccountOptions(String option) {

        clickOnElement(By.linkText("My Account"));
        List<WebElement> optionsList = driver.findElements(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//li/a"));
        for (WebElement element : optionsList) {
            if (element.getText().equalsIgnoreCase(option)) {
                clickOnElement(element);
                break;
            }
        }
    }

    @Test
    //1. Test name verifyUserShouldNavigateToRegisterPageSuccessfully()
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        //1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOptions("Register");

        //1.3 Verify the text “Register Account”.
        assertVerifyText(By.xpath("//h1[normalize-space()='Register Account']"), "Register Account");
    }

    //2. Test name verifyUserShouldNavigateToLoginPageSuccessfully()
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {

        //2.2 Call the method “selectMyAccountOptions” method and pass the parameter“Login”
        selectMyAccountOptions("Login");

        //2.3 Verify the text “Returning Customer”.
        //verifyElements(By.xpath("//h2[normalize-space()='Returning Customer']"),"actualText ");
        By actualText = By.xpath("//h2[normalize-space()='Returning Customer']");
        System.out.println(driver.findElement(By.xpath("//h2[normalize-space()='Returning Customer']")).getText());
        assertVerifyText(actualText, "actualText ");
    }

    @Test
    //Test name verifyThatUserRegisterAccountSuccessfully()
    public void verifyThatUserRegisterAccountSuccessfully()throws InterruptedException {

        //3.1 Click on My Account Link
        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOptions("Register");

        //3.3 Enter First Name
        sendTextToElement(By.name("firstname"), "John");

        //3.4 Enter Last Name
        sendTextToElement(By.name("lastname"), "Wood");

        //3.5 Enter Email
        final String randomEmail = randomEmail();
        sendTextToElement(By.name("email"), " randomEmail@gmail.com");

        //3.7 Enter Telephone
        sendTextToElement(By.name("telephone"),"07895432164");

        //3.8 Enter Password
        sendTextToElement(By.name("password"),"Jwood123");

       Thread.sleep(2000);

       //3.8 Enter Password Confirm
        sendTextToElement(By.name("confirm"),"Jwood123");

        //3.9 Select Subscribe Yes radio button
        clickOnElement(By.name("newsletter"));

        //3.10 Click on Privacy Policy check box
        clickOnElement(By.name("agree"));

        //3.11 Click on Continue button
        clickOnElement(By.xpath("//input[@value='Continue']"));

        Thread.sleep(2000);

        //3.12 Verify the message “Your Account Has Been Created!”
        WebElement elementMessage2 = driver.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']"));
        String actual2 = elementMessage2.getText();
        System.out.println(actual2);
        String expected2 = "Your Account Has Been Created!";

        System.out.println(expected2);
        boolean message2 = actual2.contains(expected2.trim());
        Assert.assertTrue(message2);
        Thread.sleep(2000);


        //3.13 Click on Continue button
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));

        //3.14 Click on My Account Link.
        clickOnElement(By.xpath("//h2[normalize-space()='My Account']"));

        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter
        selectMyAccountOptions("My Account");
Thread.sleep(2000);
        //“Logout”
        clickOnElement(By.linkText("Logout"));

        //3.16 Verify the text “Account Logout”
        assertVerifyText(By.xpath("//h1[normalize-space()='Account Logout']"),"Account Logout");

        //3.17 Click on Continue button
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));
    }
    private static String randomEmail() {
        return "random-" + UUID.randomUUID().toString() + "@example.com";
    }
@Test
    //4. Test name verifyThatUserShouldLoginAndLogoutSuccessfully()
    public void verifyThatUserShouldLoginAndLogoutSuccessfully(){

    //4.1 Click on My Account Link.
    //4.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login"
    selectMyAccountOptions("Login");

    //4.3 Enter Email address
    sendTextToElement(By.name("email"),"randomEmail@gmail.com");

    //4.4 Enter Last Name
   // sendTextToElement(By.name("lastname"), "Wood");

    //4.5 Enter Password
    sendTextToElement(By.name("password"),"Jwood123");

    //4.6 Click on Login button
clickOnElement(By.xpath("//input[@value='Login']"));

    //4.7 Verify text “My Account”
    assertVerifyText(By.xpath("//h2[normalize-space()='My Account']"),"My Account");

    //4.8 Clickr on My Account Link.
    clickOnElement(By.xpath("//h2[normalize-space()='My Account']"));

    //4.9 Call the method “selectMyAccountOptions” method and pass the parameter
    selectMyAccountOptions("My Account");

    //“Logout”
    clickOnElement(By.linkText("Logout"));

    //4.10 Verify the text “Account Logout”
    assertVerifyText(By.xpath("//h1[normalize-space()='Account Logout']"),"Account Logout");

    //4.11 Click on Continue button
    clickOnElement(By.xpath("//a[normalize-space()='Continue']"));
}
public void tearDown(){
        //closing the browser
    driver.quit();
}
}







    /*WebElement element = driver.findElement(By.cssSelector("input[value='1']"));
        element.clear();
    sendTextToElement(By.cssSelector("input[value='1']"), "2");
        Thread.sleep(2000);*/
    //code for 1.3
    /*
    selectMenu("Computers");
        selectMenu("electronics");
        selectMenu("Apparel");
        selectMenu("Digital downloads");
        selectMenu("Books");
        selectMenu("Jewelry");
        selectMenu("Gift Cards");
     */
    /*
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
     */

