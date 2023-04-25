package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;

    public void openBrowser(String baseUrl) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        // Launce the URL
        driver.get(baseUrl);
        // Maximise Window
        driver.manage().window().maximize();
        //Implicit Time out
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //Explicit Wait
          /*  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
            WebElement selectSortByPosition = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='input-sort']")));
*/
    }
        public void closeBrowser () {
            driver.quit();
        }


    }


