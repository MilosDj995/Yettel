package prviTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

import static utils.DriverUtils.setUpDriver;

public class PrviTestLogin {
    public static class OpenLoginPageTest {
        private WebDriver driver;
        private final String EMAIL = "milos.djordjevic@transperfect.com";
        private final String PASSWORD = "Password1!";
        @BeforeEach
        public void setUpDriverForTest(){
            driver = setUpDriver();
        }

        @Test
        public void openLoginPageTest(){
            MainPage mainPage = new MainPage(driver)
                    .open()
                    .verifyLoginPage();

        }
        @AfterEach
        public void finisTest(){
            //        driver.quit();
        }
    }

}



