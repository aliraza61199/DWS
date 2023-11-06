package GenericUtility;

import org.checkerframework.common.value.qual.StaticallyExecutable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


import com.aventstack.extentreports.ExtentTest;

import ObjectRepository.BookPage;
import ObjectRepository.Computerpage;
import ObjectRepository.HomePage;
import ObjectRepository.JavaUtility;
import ObjectRepository.JewelyPage;
import ObjectRepository.LogInPage;
import ObjectRepository.RegisterPage;
import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass implements IAutoConstant {
	
     
	public static	ExtentTest logger;
	public static WebDriver driver;
	public static PropertyUtility Property;
	public static TakesScreenshotUtility ts;
	public static  WebDriverUtility webDriverUtility;
	public static DatabaseUtility dbUtility;
	public static  JavaUtility javaUtility;
	public static LogInPage login;
	public static RegisterPage registerpage;
	public static HomePage  homepage ;
	public static JewelyPage jewelypage;
	public static BookPage bookpage ;
	private Computerpage computerpage;
	

		
	
	@BeforeClass(alwaysRun = true)
	public void launchingBrowserAndNavigateToApp(TakesScreenshotUtility ts) {
		Property = new PropertyUtility();
		

		if (Browser.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
			
		} else if (Browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} 
		else {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.get(Property.readingDataFromPropertyFile("url"));
		webDriverUtility=new WebDriverUtility(driver);
		ts = new TakesScreenshotUtility(driver);
		dbUtility=new DatabaseUtility();
		javaUtility=new JavaUtility();
		
	}

	@BeforeMethod(alwaysRun = true)
	public void loginToApplication() {
     login = new LogInPage(driver);
     registerpage = new RegisterPage(driver);
     homepage = new HomePage(driver);
     computerpage =new Computerpage(driver);
     jewelypage =new JewelyPage(driver); 
		System.out.println("logged in to application");
	}

	@AfterMethod(alwaysRun=true)
	public void logOutFromApplication() {
		System.out.println("logged out from apllication");

	}

	@AfterClass(alwaysRun=true)
	public void teardownTheBrowser() {
		driver.quit();
	}

}