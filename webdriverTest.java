package webdrivertest;

import static org.junit.Assert.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;

public class webdriverTest {
	WebDriver driver;
    Map<String,String> map;


	@Before
	public void setUp() {
		File pathToFirefoxBinary = new File("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");  
    	FirefoxBinary firefoxbin = new FirefoxBinary(pathToFirefoxBinary);  
        try {
        	driver = new FirefoxDriver(firefoxbin,null);
            map = webdriver.read();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}

	@Test
	public void test() {
		for(Map.Entry<String,String> entry:map.entrySet()){

            driver.get("http://121.193.130.195:8080/");
            String a = entry.getKey();
            WebElement element = driver.findElement(By.id("name"));
            element.clear();
            element.sendKeys(a);
            WebElement password = driver.findElement(By.id("pwd"));
            password.clear();
            password.sendKeys(a.substring(4));

            //WebElement button = driver.findElement(By.xpath(".//*[@id='submit']"));
            driver.findElement(By.id("pwd")).findElement(By.xpath("..")).click(); 
            WebElement button = driver.findElement(By.id("submit"));
            button.click();
            
            
            //System.out.println(button.getTagName());

            WebElement mail = driver.findElement(By.xpath("//tbody[@id='table-main']/tr[3]/td[2]"));
            assertEquals(mail.getText(),entry.getValue());
        }
	}

}
