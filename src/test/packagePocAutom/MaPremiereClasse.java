package packagePocAutom;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.Sleeper;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class MaPremiereClasse {
    private WebDriver driver;

    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.chrome.driver",   "/tmp/chromedriver");
        Map<String, Object> prefs = new HashMap<>();
        // permet tous les cookies pour Chrome en deux etapes
        // 1 - allow all cookies
        prefs.put("profile.default_content_setting_values.cookies", 1);
        // 2 - bloque seulement les cookies tiers : non
        prefs.put("profile.block_third_party_cookies", false);
        // Meme chose, pour Firefox
        prefs.put("network.cookie.cookieBehavior", 0);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("window-size=1920x1080", "--headless", "--no-sandbox");
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
    @test
    @DisplayName("Test POC ouverture google.fr")
    public void POCGoogle{
        driver.get("http://www.google.fr");
        driver.manage().window().maximize();
    }
}
