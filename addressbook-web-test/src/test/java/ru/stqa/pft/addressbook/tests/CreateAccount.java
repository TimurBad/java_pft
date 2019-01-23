package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class CreateAccount extends TestBase{

  @Test
  public void testCreateAccount() throws Exception {
    app.gotoWebPageLogin();
    app.login(new GroupData("bad@mail.ru", "nhjkjkj19993"));
    app.gotoWebPageAddressBook();
    app.createAccountTest();


  }

}
