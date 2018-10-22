import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;

public class Reservation {
    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "C:\\Code\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testReservation() throws Exception {
        driver.get("https://www.phptravels.net/");
        driver.findElement(By.xpath("//form[@name='fCustomHotelSearch']//*[@class='select2-choice']")).click();
        driver.findElement(By.className("select2-focused")).sendKeys("singa");
        driver.findElement(By.xpath("//ul[@class='select2-results']//*[contains(text(), 'pore, Singapore')]")).click();
        driver.findElement(By.name("checkin")).sendKeys("01/12/2018");
        driver.findElement(By.name("checkout")).sendKeys("10/12/2018");
        driver.findElement(By.id("travellersInput")).click();
        driver.findElement(By.id("adultPlusBtn")).click();
        driver.findElement(By.id("adultPlusBtn")).click();
        driver.findElement(By.className("search-button")).click();
        driver.findElement(By.xpath("//*[contains(text(), 'Details')]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Hyatt Regency Perth'])[1]/following::a[1]")).click();
        if(driver.getPageSource().contains("Hyatt Regency Perth, Adelaide Terrace, Perth"))
        {
            System.out.println("Hyatt Regency Perth found");
        }
        else
        {
            fail("Hyatt Regency Perth not found");
        }
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
