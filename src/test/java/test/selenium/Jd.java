package test.selenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class Jd {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.hao123.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testJd() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("京东商城")).click();
    driver.findElement(By.id("J-toolbar-load-hook")).click();
    driver.findElement(By.id("key")).clear();
    driver.findElement(By.id("key")).sendKeys("口红");
    driver.findElement(By.id("J-toolbar-load-hook")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=&3AB9D23F7A4B3C9B=ID66K5JRXVYIHWJ7GIVMDTLKGTB32NKTPFVL7DR7ZDPCCB6NZS6YBTPXFCRHRQ7XXYXRJ4YW5BODSVOJCJ5IUKUR3E | ]]
    driver.findElement(By.cssSelector("a.pn-next > em")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=&3AB9D23F7A4B3C9B=ID66K5JRXVYIHWJ7GIVMDTLKGTB32NKTPFVL7DR7ZDPCCB6NZS6YBTPXFCRHRQ7XXYXRJ4YW5BODSVOJCJ5IUKUR3E | ]]
    driver.findElement(By.cssSelector("img.err-product")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=圣罗兰（YSL） 口红唇膏迷魅方管/圆管/唇釉 保湿持久不脱色 方管52#号 星星千颂伊色__scrollTop__flag | ]]
    driver.findElement(By.xpath("//div[@id='stock-address']/div/div[2]/dl[2]/dd/div/ul/li[2]")).click();
    driver.findElement(By.id("J-toolbar-load-hook")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=圣罗兰（YSL） 口红唇膏迷魅方管/圆管/唇釉 保湿持久不脱色 方管52#号 星星千颂伊色__scrollTop__flag&3AB9D23F7A4B3C9B=ID66K5JRXVYIHWJ7GIVMDTLKGTB32NKTPFVL7DR7ZDPCCB6NZS6YBTPXFCRHRQ7XXYXRJ4YW5BODSVOJCJ5IUKUR3E | ]]
    driver.findElement(By.xpath("//div[@id='detail']/div/ul/li[5]")).click();
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
