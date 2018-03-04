import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.ArrayList;

public class DashboardPage {
    private WebDriver driver;

    private By userIcon = By.className("employee_avatar_small");
    private By quiteButton = By.id("header_logout");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickUserIcon() {
        driver.findElement(userIcon).click();
    }

    public void clickQuiteButton() {
        driver.findElement(quiteButton).click();
    }
}
