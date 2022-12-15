package packagePocAutom;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Sleeper;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootTest
public class MaPremiereClasseTest {
    private WebDriver driver;
    private static final Logger LOGGER = LoggerFactory.getLogger(MaPremiereClasseTest.class);
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

    @Test
    @DisplayName("Test POC ouverture google.fr")
    public void POCGoogle(){
        LOGGER.info("Ouverture de la page google.fr");
        driver.get("http://www.google.fr");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("/html/body/ntp-app//div/div[1]/ntp-realbox//div/input")).sendKeys("tsts");
        LOGGER.info("Fin d'ouverture de google.fr");
    }
    @Test
    @DisplayName("POCAssertionFausse")
    public void POCAssertionFausse(){
        try {
            LOGGER.info("Essai d'assertion fausse");
            Assertions.assertEquals(1,2);
        }
        catch (Exception e){
            LOGGER.info("Assertion fausse, message : " + e);
        }
    }
    @Test
    @DisplayName("POCAssertionFausse")
    public void POCAssertionVraie() {
        try {
            LOGGER.info("Essai d'assertion vraie");
            Assertions.assertEquals(1, 1);
            LOGGER.info("Assertion vraie, 1 = 1");
        } catch (Exception e) {
        }
    }
}
