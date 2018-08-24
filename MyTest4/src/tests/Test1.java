package tests;

import org.testng.annotations.Test;
import org.testng.Assert;
import pages.Home;
import pages.LogIn;
import pages.MyNotes;
import utilities.*;

public class Test1 extends BaseTest{

  @Test(dataProvider = "Authentication")

  public void MyTest(String sUsername, String sPassword) {
	  page.GetInstance(Home.class).LoginClick();
	  page.GetInstance(LogIn.class).EnterCredentials(sUsername, sPassword);
	  //Verify.verify(page.GetInstance(LogIn.class).ValidateErrorMsg());
	  Assert.assertTrue(page.GetInstance(MyNotes.class).verify_mynotes_page());
  }
}
