package hw3;

import java.util.regex.Pattern;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class UntitledTestCase {

	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/Users/wuchen/Downloads/chromedriver");
		driver = new ChromeDriver();
		baseUrl = "https://www.katalon.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void test233() throws Exception {

		String filePathxlsx = "/Users/wuchen/Downloads/input.xlsx";
		// Object [][] objxls =DP_Demo.getTestData(filePathxls);
		Object[][] objxlsx = read.getTestData(filePathxlsx);

		for (int i = 0; i < objxlsx.length; i++) {
			//System.out.println(objxlsx[i][0] + " " + objxlsx[i][1]);
			
			String name = objxlsx[i][0].toString();
			
			BigDecimal b = new BigDecimal(name);
			name = b.toPlainString();
			if(objxlsx[i][1] == null) {
				System.out.println("你啥也没写啊" + name);
				continue;
			}
			String url = objxlsx[i][1].toString();
			
			driver.get("https://psych.liebes.top/st");
			driver.findElement(By.id("username")).click();
			driver.findElement(By.id("username")).clear();
			driver.findElement(By.id("username")).sendKeys(name);
			driver.findElement(By.id("password")).clear();
			driver.findElement(By.id("password")).sendKeys(name.substring(name.length()-6));
			driver.findElement(By.id("submitButton")).click();
			if(url.equals(driver.findElement(By.xpath("//p")).getText() ) ) {
				//成功
				System.out.println(name + " 's " + url+ " is ok");
			}
			else {
				System.out.println(name + " 's " + url+ " is wrong");
			}
			//assertEquals(url, driver.findElement(By.xpath("//p")).getText());
			
		}

		/*
		 * Object[] obj1 = objxlsx[0];
		 * 
		 * for (int i = 0; i < obj1.length; i++) { System.out.print("[" + obj1[i] +
		 * "] "); }
		 */
		
		
		

		
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}
