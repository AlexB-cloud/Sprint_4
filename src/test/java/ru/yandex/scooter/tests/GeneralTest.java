package ru.yandex.scooter.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.scooter.pages.MainPageScooter;

public class GeneralTest {
  protected WebDriver driver;
  protected MainPageScooter mainPage;

  @Before
  public void startUp() {
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.get("https://qa-scooter.praktikum-services.ru/");
    mainPage = new MainPageScooter(driver);
  }

@After
  public void teardown() {
  driver.quit();
}



}

