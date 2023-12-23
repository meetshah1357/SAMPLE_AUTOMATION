package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Base {
    public static WebDriver driver;
    public static  WebDriver inheritance() {

        String driverPath ="C:\\Users\\meets\\IdeaProjects\\meet\\src\\chromedriver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",driverPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");


        WebDriver driver = new ChromeDriver(options);
        return driver;
    }
}
