package ru.sutochno.tests.api;

import org.junit.jupiter.api.Test;
import ru.sutochno.config.Project;

public class SutochnoApiTests extends TestBase {
    @Test
    void makeAdvertisementApiTest() {
        requests.getAuth(Project.config.userPhone(), Project.config.userPassword());
    }
}
