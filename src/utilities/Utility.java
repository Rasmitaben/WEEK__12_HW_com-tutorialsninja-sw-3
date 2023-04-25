package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {
    /*
1.1 create method with name "selectMenu" it has one parameter name "menu" of type string
1.2 This method should click on the menu whatever name is passed as parameter.Write the following Test:
     */
    /*public void selectMenu(String menu) {
        driver.findElement(By.linkText(menu)).click();
    }*/
    public void selectMenu(String menu) {
        driver.findElement(By.linkText(menu)).click();
       /* List<WebElement> listOfMenuElements = driver.findElements(By.xpath("//ul[@class='nav navbar-nav']"));
        for (WebElement element : listOfMenuElements) {
            System.out.println(element.getText());

            if (element.getText().trim().equalsIgnoreCase(menu)) {
                element.click();
                break;*/
            }

    /**
     * This  Method will MouseHover on an element
     */
    public void mouseHoverOnElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }

    /**
     * This  Method will click on MouseHover
     */
    public void clickOnMouseHover(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).click().build().perform();
    }
    /**
     * This method will click on element
     */
    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }
    public void clickOnElement(WebElement element) {
        element.click();
    }

    /**
     *Ths Method will get text from an element
     */
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    /**
     *This Method will verify an element
     */
    public void assertVerifyText(By by, String expectedText) {
        String actualText = getTextFromElement(by);
        String expectedText1= expectedText;
        Assert.assertEquals("Error= Test Failed", expectedText1, actualText);
    }

    /**
     * his Method will select an element from dropdown
     */
    public void selectFromDropDown(By by, String text) {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }
    /**
     * This method will send text to element
     */
    public void sendTextToElement(By by, String number) {
        driver.findElement(by).sendKeys(number);

    }





}
