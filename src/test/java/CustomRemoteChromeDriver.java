import com.overstock.arch.automation.WebDriverProvider;
import com.overstock.clubo.common.enums.TestServer;
import com.overstock.clubo.common.util.BaseUtils;
import com.overstock.clubo.common.util.COUtils;
import com.overstock.framework.Bordello;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CustomRemoteChromeDriver implements DriverSource {

//    static {
//        COUtils.init(true);
//    }
//
    @Override
    public WebDriver newDriver() {
        final ChromeOptions chromeOptions = new ChromeOptions();
        return Bordello.get(WebDriverProvider.class).driver();
    }

    public final boolean takesScreenshots() {
        return true;
    }
}