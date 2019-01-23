package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

public class DeleteAccount extends TestBase{

  @Test
  public void testDeleteAccount() throws Exception {
    app.gotoWebPageLogin();
    app.login(new GroupData("bad@mail.ru", "nhjkjkj19993"));
    app.gotoWebPageAddressBook();
    app.deleteAccountTest();//test fail
  }

}
