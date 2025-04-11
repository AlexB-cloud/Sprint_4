package ru.yandex.scooter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPageScooter {
  private WebDriver driver;
  private By questions = By.xpath(".//div[@class= 'accordion__button']");
  private By answer = By.xpath(".//div[contains(@class, 'accordion__panel') and not(@hidden)]/p");
  private By topOrderButton= By.xpath(".//div[@class='Header_Nav__AGCXC']/button[contains(@class,'Button_Button__ra12g')]");
  private By bottomOrderButton= By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[contains(@class,'Button_Button__ra12g')]");

  public MainPageScooter(WebDriver driver) {
    this.driver = driver;
  }

  public void clickQuestion(int index) {
    ((JavascriptExecutor) driver).executeScript(
        "arguments[0].scrollIntoView({block: 'center'});",
        driver.findElements(questions).get(index)
    );

    new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(
        driver.findElements(questions).get(index)
    )).click();
  }

  public String getAnswer() {
    new WebDriverWait(driver, Duration.ofSeconds(5))
        .until(ExpectedConditions.visibilityOfElementLocated(answer));
    return driver.findElement(answer).getText();
  }
  public void clickTopOrderButton(){
    driver.findElement(topOrderButton).click();
  }
  public void clickBottomOrderButton(){
    ((JavascriptExecutor) driver).executeScript(
        "arguments[0].scrollIntoView({block: 'center'});",
        driver.findElement(bottomOrderButton)
    );
    driver.findElement(bottomOrderButton).click();
  }
}
