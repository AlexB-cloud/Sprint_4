package ru.yandex.scooter.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.scooter.pages.OrderPageScooter;
import org.junit.Assert;

@RunWith(Parameterized.class)
public class scooterOrderTest extends GeneralTest {
private String firstName;
private String lastName;
private String address;
private String subway;
private String phoneNumber;
private String commentForCourier;

  public scooterOrderTest(String firstName, String lastName, String address, String subway, String phoneNumber, String commentForCourier){
    this.firstName=firstName;
    this.lastName=lastName;
    this.address=address;
    this.subway = subway;
    this.phoneNumber=phoneNumber;
    this.commentForCourier=commentForCourier;
  }

  @Parameterized.Parameters
      public static Object[][] getTestData(){
    return new Object[][]{
      {"Иван","Иванов","адрес мж","Комсомольская", "+74995553535","оставить у двери"},
        {"Олег","Олегов","ул. Вилиса лациса","Планерная", "+79999999999","чаевые под ковриком"},
        {"Кузя","Домовенок","Москва","Баррикадная", "+79197622436","доставить в первой половине дня"}
    };
  }


  @Test
  public void placeOrderWithTopButton(){
    mainPage.clickTopOrderButton();
    OrderPageScooter orderPage= new OrderPageScooter(driver);
    boolean result = orderPage.placeOrder(firstName,lastName,address, subway,phoneNumber,commentForCourier);
    Assert.assertTrue(result);
  }
  @Test
  public void placeOrderWithBottomButton(){
    mainPage.clickBottomOrderButton();
    OrderPageScooter orderPage= new OrderPageScooter(driver);
    boolean result = orderPage.placeOrder(firstName,lastName,address, subway,phoneNumber,commentForCourier);
    Assert.assertTrue(result);
  }

}
