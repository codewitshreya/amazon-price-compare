import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;

public class Cmpr {

    public static void main(String[] args) {
        // Set path to chromedriver.exe (Modify path if required)
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\shreya\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Product to Search
        String product = "iPhone 13";

        // Get Prices
        Integer amazonPrice = getAmazonPrice(driver, product);
        Integer flipkartPrice = getFlipkartPrice(driver, product);

        // Close browser
        driver.quit();

        // Compare and Print Results
        if (amazonPrice != null && flipkartPrice != null) {
            System.out.println("Amazon Price: ₹" + amazonPrice);
            System.out.println("Flipkart Price: ₹" + flipkartPrice);
            
            if (amazonPrice < flipkartPrice) {
                System.out.println("Amazon has the lower price.");
            } else if (flipkartPrice < amazonPrice) {
                System.out.println("Flipkart has the lower price.");
            } else {
                System.out.println("Both have the same price.");
            }
        } else if (amazonPrice != null) {
            System.out.println("Amazon Price: ₹" + amazonPrice);
            System.out.println("Flipkart price not found.");
        } else if (flipkartPrice != null) {
            System.out.println("Flipkart Price: ₹" + flipkartPrice);
            System.out.println("Amazon price not found.");
        } else {
            System.out.println("Product not found on both platforms.");
        }
    }

    // Function to get price from Amazon
    public static Integer getAmazonPrice(WebDriver driver, String product) {
        try {
            driver.get("https://www.amazon.in/");
            WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
            searchBox.sendKeys(product);
            searchBox.sendKeys(Keys.RETURN);

            // Wait and fetch the price of the first product
            Thread.sleep(2000);
            WebElement priceElement = driver.findElement(By.cssSelector("span.a-price-whole"));
            String priceText = priceElement.getText().replace(",", "").trim();
            return Integer.parseInt(priceText);
        } catch (Exception e) {
            return null; // Product not found
        }
    }

    // Function to get price from Flipkart
    public static Integer getFlipkartPrice(WebDriver driver, String product) {
        try {
            driver.get("https://www.flipkart.com/");

            // Close login popup if it appears
            try {
                WebElement closePopup = driver.findElement(By.cssSelector("button._2KpZ6l._2doB4z"));
                closePopup.click();
                Thread.sleep(1000);
            } catch (Exception ignored) {}

            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys(product);
            searchBox.sendKeys(Keys.RETURN);

            // Wait and fetch the price of the first product
            Thread.sleep(2000);
            WebElement priceElement = driver.findElement(By.cssSelector("div._30jeq3"));
            String priceText = priceElement.getText().replace("₹", "").replace(",", "").trim();
            return Integer.parseInt(priceText);
        } catch (Exception e) {
            return null; // Product not found
        }
    }
}
