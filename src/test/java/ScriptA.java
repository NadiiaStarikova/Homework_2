import org.openqa.selenium.WebDriver;

public class ScriptA extends BaseTest {

    public static void main(String[] args) {
        try {
            WebDriver driver = initChromeDriver();
            LogginPage logginPage = new LogginPage(driver);

            logginPage.open();
            logginPage.fillEmailField();
            logginPage.fillPasswdField();
            logginPage.clickLoginButton();

            Thread.sleep(1000);
            DashboardPage dashboardPage = new DashboardPage(driver);
            dashboardPage.clickUserIcon();
            dashboardPage.clickQuiteButton();

            quiteDriver(driver);

        } catch ( java.lang.InterruptedException ie) {
            System.out.println(ie);
            }
    }
}
