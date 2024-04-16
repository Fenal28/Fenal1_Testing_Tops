package main;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Com.Base;
import Com.ExcellReader;

public class LoginTest extends Base
{
	@Test(dataProvider = "dp")
	public void test(String uname, String pass,String title)
	{
		driver = connect();
		LoginPage login = new LoginPage(driver);
		login.enterrUsername(uname);
		login.enterPassword(pass);
		login.clickLogin();

		try
		{
			driver.switchTo().alert().accept();
			assertEquals(driver.getTitle(), title);
		} 
		catch (Exception e) 
		{	
			assertEquals(driver.getTitle(), title);
		}
	}

	@DataProvider(name="dp")
	public Object[][] getdata()
	{
		ExcellReader rd = new ExcellReader("C:\\Users\\ADMIN\\Desktop\\test\\project.xlsx", "login");
		int row = rd.rowCount();
		int col = rd.colCount();

		Object obj[][] = new Object[row-1][col];

		for(int i=1;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
				String data = rd.getData(i, j);
				obj[i-1][j] = data;
			}
		}

		return obj;


	}

}