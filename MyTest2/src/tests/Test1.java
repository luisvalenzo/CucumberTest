package tests;

import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import org.testng.Assert;
import pages.Home;
import pages.LogIn;
import pages.MyNotes;
import utilities.BaseTest;

public class Test1 extends BaseTest{

  @Test
  @Parameters({"sUsername","sPassword"})
  public void MyTest1(String sUsername, String sPassword) {
	  page.GetInstance(Home.class).LoginClick();
	  page.GetInstance(LogIn.class).EnterCredentials(sUsername, "");
	  Assert.assertTrue(page.GetInstance(MyNotes.class).verify_mynotes_page());
  }
  
  @Test
  @Parameters({"sUsername",""})
  public void MyTest2(String sUsername, String sPassword) {
	  page.GetInstance(Home.class).LoginClick();
	  page.GetInstance(LogIn.class).EnterCredentials(sUsername, "");
	  Assert.assertTrue(page.GetInstance(LogIn.class).ValidateErrorMsg());
  }

}
