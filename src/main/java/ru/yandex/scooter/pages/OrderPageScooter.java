package ru.yandex.scooter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class OrderPageScooter {
  private WebDriver driver;
  private By firstName= By.xpath(".//input[@placeholder='* Имя']");
  private By lastName= By.xpath(".//input[@placeholder='* Фамилия']");
  private By address= By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
  private By metro= By.xpath(".//input[@placeholder='* Станция метро']");
  private By metroSelect=By.xpath(".//div[contains(@class,'select-search has-focus')]//button[contains(@class,'select-search__option')]");
  private By phoneNumber= By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
  private By whenToDeliver= By.xpath(".//input[@placeholder='* Когда привезти самокат']");
  private By calendarToday=By.xpath(".//div[@class='react-datepicker']//div[contains(@class,'selected')]");
  private By rentTimeDropDown= By.xpath(".//div[@class='Dropdown-control']");
  private By rentTimeDropDownItems=By.xpath(".//div[@class='Dropdown-option']");
  private By scooterColorCheckboxes=By.xpath(".//input[@class='Checkbox_Input__14A2w']");
  private By commentForCourier=By.xpath(".//input[@placeholder='Комментарий для курьера' ]");
  private By orderButton=By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать']");
  private By continueButton=By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Далее']");
  private By orderConfirmButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");
  private By successOrderModal = By.xpath(".//div[@class='Order_ModalHeadeчсмr__3FDaJ' and text()='Заказ оформлен']");

  public OrderPageScooter(WebDriver driver){
    this.driver=driver;
  }
  public boolean placeOrder(String firstName, String lastName, String address, String metro, String phoneNumber, String commentForCourier) {
    driver.findElement(this.firstName).sendKeys(firstName);
    driver.findElement(this.lastName).sendKeys(lastName);
    driver.findElement(this.address).sendKeys(address);
    driver.findElement(this.metro).sendKeys(metro);
    driver.findElement(this.metroSelect).click();
    System.out.println(driver.getPageSource());
    driver.findElement(this.phoneNumber).sendKeys(phoneNumber);
    driver.findElement(continueButton).click();

    driver.findElement(this.whenToDeliver).click();
    driver.findElement(this.calendarToday).click();
    driver.findElement(this.rentTimeDropDown).click();
    driver.findElements(this.rentTimeDropDownItems).get(2).click();
    driver.findElements(scooterColorCheckboxes).get(0).click();
    driver.findElement(this.commentForCourier).sendKeys(commentForCourier);
    driver.findElement(orderButton).click();
    driver.findElement(orderConfirmButton).click();

    return !driver.findElements(successOrderModal).isEmpty();

  }

}
