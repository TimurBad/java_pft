package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class ApplicationManager {
    public ChromeDriver driver;
    public String baseUrl;
    public boolean acceptNextAlert = true;
    public StringBuffer verificationErrors = new StringBuffer();

    public void init() {
        String key = "webdriver.chrome.driver";
        String value = "C:\\way_QA_Automation_Engineer\\webDriver\\chromedriver.exe";
        System.setProperty(key, value);
        driver = new ChromeDriver();
        baseUrl = "https://www.katalon.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void gotoWebPageLogin() {
        driver.get("https://www.postable.com/login#/");
    }

    public void login(GroupData groupData) {
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Get Addresses'])[1]/following::a[1]")).click();
        driver.findElement(By.id("InputEmail1")).click();
        driver.findElement(By.id("InputEmail1")).clear();
        driver.findElement(By.id("InputEmail1")).sendKeys(groupData.getLogin());
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(groupData.getPassword());
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Login'])[3]/following::button[1]")).click();
    }

    public void stop() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public String closeAlertAndGetItsText() {
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

    public void gotoWebPageAddressBook() {
        driver.findElement(By.linkText("Address Book")).click();
    }

    public void createAccountTest() {
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Export'])[1]/following::button[1]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Name & Address'])[1]/following::input[1]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Name & Address'])[1]/following::input[1]")).clear();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Name & Address'])[1]/following::input[1]")).sendKeys("testt");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Notes'])[1]/following::button[1]")).click();
    }

    public void deleteAccountTest() {
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Z'])[1]/following::li[1]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Edit contact'])[1]/following::button[1]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Delete contact'])[1]/following::button[1]")).click(); }
}
