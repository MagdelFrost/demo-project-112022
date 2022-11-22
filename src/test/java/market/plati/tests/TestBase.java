package market.plati.tests;

import market.plati.config.Project;
import market.plati.config.platimarket.App;
import market.plati.helpers.AllureAttachments;
import market.plati.helpers.DriverSettings;
import market.plati.helpers.DriverUtils;
import market.plati.tests.data.TestData;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.junit5.AllureJunit5;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;


@ExtendWith({AllureJunit5.class})
public class TestBase {
    @BeforeAll
    static void beforeAll() {
        DriverSettings.configure();
        RestAssured.baseURI = App.config.apiUrl();
        Configuration.baseUrl = App.config.webUrl();
    }

    @BeforeEach
    public void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    public void afterEach() {
        String sessionId = DriverUtils.getSessionId();

        AllureAttachments.addScreenshotAs("Last screenshot");
        AllureAttachments.addPageSource();
        AllureAttachments.addBrowserConsoleLogs();

        Selenide.closeWebDriver();

        if (Project.isVideoOn()) {
            AllureAttachments.addVideo(sessionId);
        }
    }

    TestData testData = new TestData();

    String password = testData.getPassword();
    String firstName = testData.getFirstName();
    String lastName = testData.getLastName();
    String email = testData.getEmail();
    String anotherEmail = testData.getAnotherEmail();
    String anotherName = testData.getAnotherName();
    String anotherLastName = testData.getAnotherLastName();
}
