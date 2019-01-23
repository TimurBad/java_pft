package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

public class InitializLogPasw extends TestBase{

  @Test
  public void test1() throws Exception {
    app.gotoWebPageLogin();
    app.login(new GroupData("bad@mail.ru", "nhjkjkj19993"));
  }

}
