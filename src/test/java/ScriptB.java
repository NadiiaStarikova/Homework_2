import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class ScriptB extends BaseTest {

    public static void main(String[] args) {
        try {
            WebDriver driver = initChromeDriver();
            //логин в Админ панель
            LogginPage logginPage = new LogginPage(driver);
            logginPage.open();
            logginPage.fillEmailField();
            logginPage.fillPasswdField();
            logginPage.clickLoginButton();

            //ожидание загрузки страницы
            Thread.sleep(1000);

            //создание списка значений локаторов веб элементов пунктов главного меню
            ArrayList<String> sections  = new ArrayList<String>();
            sections.add(".//*[@id='tab-AdminDashboard']/a/span");
            sections.add(".//*[@id='subtab-AdminParentOrders']/a/span");
            sections.add(".//*[@id='subtab-AdminCatalog']/a/span");
            sections.add("/html/body/nav/ul/li[5]/a/span");
            sections.add(".//*[@id='subtab-AdminParentCustomerThreads']/a/span");
            sections.add(".//*[@id='subtab-AdminStats']/a/span");
            sections.add(".//*[@id='subtab-AdminParentModulesSf']/a/span");
            sections.add("/html/body/nav/ul/li[10]/a/span");
            sections.add(".//*[@id='subtab-AdminParentShipping']/a/span");
            sections.add(".//*[@id='subtab-AdminParentPayment']/a/span");
            sections.add(".//*[@id='subtab-AdminInternational']/a/span");
            sections.add(".//*[@id='subtab-ShopParameters']/a/span");
            sections.add(".//*[@id='subtab-AdminAdvancedParameters']/a/span");

            //клик на каждом видимом пункте главного меню;
            // вывод в консоль заголовка открытого раздела;
            // обновление страницы и проверка сохранения url после него
            for( int i = 0 ; i < sections.size() ; i++ ) {
                driver.findElement(By.xpath(sections.get(i))).click();
                Thread.sleep(1000);
                System.out.println(driver.findElement(By.tagName("h2")).getText());
                String urlBeforeRegresh = driver.getCurrentUrl();
                driver.navigate().refresh();
                Thread.sleep(1000);
                String urlAfterRefresh = driver.getCurrentUrl();
                {
                    if (urlBeforeRegresh.equals(urlAfterRefresh))
                        System.out.println("True");
                    else
                        System.out.println("False");
                }
                Thread.sleep(1000);
            }
            //закрытие браузера
            driver.quit();


        } catch ( java.lang.InterruptedException ie) {
            System.out.println(ie);
            }
    }
}