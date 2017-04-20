package com.testwithspring.intermediate.web;

import com.testwithspring.intermediate.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.testwithspring.intermediate.EndToEndTestUsers.*;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SeleniumTestRunner.class)
@SeleniumTest(driver = ChromeDriver.class)
@Category(EndToEndTest.class)
public class SubmitLoginFormWithCorrectUsernameAndPasswordTest {

    @SeleniumWebDriver
    private WebDriver browser;

    private LoginPage loginPage;

    @Before
    public void openLoginPage() {
        loginPage = new LoginPage(browser).open();
    }

    @Test
    public void shouldRenderTaskListPage() {
        TaskListPage shownPage = loginPage.login(JohnDoe.EMAIL_ADDRESS, JohnDoe.PASSWORD);

        String taskListPageUrl = shownPage.getPageUrl();
        assertThat(browser.getCurrentUrl()).isEqualTo(taskListPageUrl);
    }

    @After
    public void logoutUser() {
        loginPage.logout();
    }
}
