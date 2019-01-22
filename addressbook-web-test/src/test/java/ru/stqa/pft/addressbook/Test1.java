package ru.stqa.pft.addressbook;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;

public class Test1 {
  public ChromeDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    String key= "webdriver.chrome.driver";
    String value= "C:\\way_QA_Automation_Engineer\\webDriver\\chromedriver.exe";
    System.setProperty(key,value);
    driver = new ChromeDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void test1() throws Exception {
    gotoWebPage();
    login(new GroupData("bad@mail.ru", "nhjkjkj19993"));
  }

  private void gotoWebPage() {
    driver.get("https://www.postable.com/login#/");
  }

  private void login(GroupData groupData) {
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Get Addresses'])[1]/following::a[1]")).click();
    driver.findElement(By.id("InputEmail1")).click();
    driver.findElement(By.id("InputEmail1")).clear();
    driver.findElement(By.id("InputEmail1")).sendKeys(groupData.getLogin());
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys(groupData.getPassword());
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Login'])[3]/following::button[1]")).click();
  }

  @AfterClass(alwaysRun = true)
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
