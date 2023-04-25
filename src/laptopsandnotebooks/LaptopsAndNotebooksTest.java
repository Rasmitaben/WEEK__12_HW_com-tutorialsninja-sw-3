package laptopsandnotebooks;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LaptopsAndNotebooksTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test

    //1. Test name verifyProductsPriceDisplayHighToLowSuccessfully()
    public void verifyProductsPriceDisplayHighToLowSuccessfully()throws InterruptedException {
        //1.1 Mouse hover on Laptops & Notebooks Tab.and click
        mouseHoverOnElement(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));

        //1.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"));
       Thread.sleep(2000);

        //1.3 Select Sort By "Price (High > Low)"
        selectFromDropDown(By.xpath("//select[@id='input-sort']"),"Price (High > Low)");

        //1.4 Verify the Product price will arrange in High to Low order.
        List<WebElement> list = driver.findElements(By.xpath("//p[@class='price']"));
        List<String> expectedlistOfPrice= new ArrayList<>();

        for(int i =0; i<list.size();i++){
            String s = list.get(i).getText();
            String[] a = s.split("E");
            String s1 = a[0].substring(1);
            expectedlistOfPrice.add(s1.trim());
        }
        Collections.reverse(expectedlistOfPrice);
        System.out.println(expectedlistOfPrice);
        selectFromDropDown(By.xpath("//select[@id='input-sort']"),"Price (High > Low)");
        //1.4 Verify the Product price will arrange in High to Low order.1.1 Mouse hover on Laptops & Notebooks Tab.and click
        List<WebElement> list1 = driver.findElements(By.xpath("//p[@class='price']"));
        List<String> acctuallistOfPrice = new LinkedList<>();
        for(int i =0; i<list1.size();i++){
            String s = list1.get(i).getText();
            String[] a = s.split("E");
            String s1 = a[0].substring(1);
            acctuallistOfPrice.add(s1.trim());
        }



    }

    @Test
    //2. Test name verifyThatUserPlaceOrderSuccessfully()
    public void verifyThatUserPlaceOrderSuccessfully()throws InterruptedException {

        //2.1 Mouse hover on Laptops & Notebooks Tab and click
        mouseHoverOnElement(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));

        //2.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"));
        Thread.sleep(2000);

        //2.3 Select Sort By "Price (High > Low)"
        selectFromDropDown(By.xpath("//select[@id='input-sort']"),"Price (High > Low)");

        //2.4 Select Product “MacBook”
        clickOnElement(By.xpath("//a[normalize-space()='MacBook']"));

        //2.5 Verify the text “MacBook”
        assertVerifyText(By.xpath("//h1[normalize-space()='MacBook']"),"MacBook");

        //2.6 Click on ‘Add To Cart’ button
        clickOnElement(By.xpath("//button[@id='button-cart']"));
       Thread.sleep(2000);

        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        WebElement elementMessage = driver.findElement(By.xpath("(//div[@class='alert alert-success alert-dismissible'])[1]"));
        String actual = elementMessage.getText();
        System.out.println(actual);
        String expected = "Success: You have added MacBook to your shopping cart!";

        System.out.println(expected);
        boolean message = actual.contains(expected.trim());
        Assert.assertTrue(message);
        Thread.sleep(2000);

        //2.8 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));

        //2.9 Verify the text "Shopping Cart"
        assertVerifyText(By.xpath("//h1[contains(text(),'Shopping Cart')]"),"Shopping Cart  (0.00kg)");

        //2.10 Verify the Product name "MacBook"
        assertVerifyText(By.xpath("(//a[contains(text(),'MacBook')])[2]"),"MacBook");
Thread.sleep(2000);
        //2.11 Change Quantity "2"
        WebElement element1 = driver.findElement(By.cssSelector("input[value='1']"));
        element1.clear();
        sendTextToElement(By.cssSelector("input[value='1']"),"2");

        String expectedQuantity = "2";
        String actualQuantity =element1.getAttribute("value");
        Assert.assertEquals("Doesn't match",expectedQuantity,actualQuantity);
Thread.sleep(2000);
        //2.12 Click on “Update” Tab
        clickOnElement(By.xpath("//i[@class='fa fa-refresh']"));

        //2.13 Verify the message “Success: You have modified your shopping cart!”

        WebElement elementMessage1= driver.findElement(By.xpath("(//div[@class='alert alert-success alert-dismissible'])[1]"));
        String actual1 = elementMessage1.getText();
        System.out.println(actual1);
        String expected1 = "Success: You have modified your shopping cart!";

        System.out.println(expected);
        boolean message1 = actual.contains(expected.trim());
        Assert.assertTrue(message1);
        Thread.sleep(2000);
Thread.sleep(2000);
        //2.14 Verify the Total £737.45
        assertVerifyText(By.xpath("//tbody//tr//td[6]"),"$1,204.00");

        //2.15 Click on “Checkout” button
        clickOnElement(By.xpath("//a[@class='btn btn-primary']"));

        //2.16 Verify the text “Checkout”
        assertVerifyText(By.xpath("//h1[normalize-space()='Checkout']"),"Checkout");
Thread.sleep(2000);
        //2.17 Verify the Text “New Customer”
        assertVerifyText(By.xpath("(//h2[normalize-space()='New Customer'])[1]"),"New Customer");

        //2.18 Click on “Guest Checkout” radio button
        clickOnElement(By.xpath("//label[normalize-space()='Guest Checkout']"));
Thread.sleep(2000);
        //2.19 Click on “Continue” tab
        clickOnElement(By.xpath("(//input[@id='button-account'])[1]"));
Thread.sleep(2000);
        //2.20 Fill the mandatory fields
        sendTextToElement(By.name("firstname"),"Zara");
        sendTextToElement(By.name("lastname"),"Lee");
        sendTextToElement(By.id("input-payment-email"),"zara123@gmail.com");
        sendTextToElement(By.name("telephone"),"0779563425");
        sendTextToElement(By.name("address_1"),"190,Harrow view");
        sendTextToElement(By.id("input-payment-city"),"London");
        sendTextToElement(By.name("postcode"),"HA0 5AD");
        selectFromDropDown(By.id("input-payment-country"),"United Kingdom");
        selectFromDropDown(By.name("zone_id"),"Devon");

        //2.21 Click on “Continue” Button
        clickOnElement(By.xpath("//input[@id='button-guest']"));

        //2.22 Add Comments About your order into text area
        sendTextToElement(By.xpath("//textarea[@name='comment']"),"All is Well");

        //2.23 Check the Terms & Conditions check box
        clickOnElement(By.xpath("//input[@name='agree']"));

        //2.24 Click on “Continue” button
        clickOnElement(By.xpath("//input[@id='button-payment-method']"));

        //2.25 Verify the message “Warning: Payment method required!”

        WebElement elementMessage2 = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
        String actual2 = elementMessage2.getText();
        System.out.println(actual2);
        String expected2 = "Warning: Payment method required!";

        System.out.println(expected2);
        boolean message2 = actual2.contains(expected2.trim());
        Assert.assertTrue(message2);
        Thread.sleep(2000);

    }

}
