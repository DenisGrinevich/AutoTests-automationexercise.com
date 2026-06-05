/*
Утилитный класс для создания и настройки драйвера для chrome
 */

package basic;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class ChromeUtils {
    public static WebDriver createDriver() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--headless=new");
        options.addArguments("--window-size=1920,1080");

        //Удаление рекламы
        BrowserMobProxy proxy = new BrowserMobProxyServer();
        proxy.start(0);
        proxy.blacklistRequests(".*googlesyndication.*", 404);
        proxy.blacklistRequests(".*doubleclick.*", 404);
        proxy.blacklistRequests(".*googleadservices.*", 404);
        proxy.blacklistRequests(".*pagead.*", 404);
        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
        options.setProxy(seleniumProxy);
        options.setAcceptInsecureCerts(true);


        WebDriver driver = new ChromeDriver(options);


        return driver;
    }
}
