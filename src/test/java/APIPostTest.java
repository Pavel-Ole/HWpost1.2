import groovy.transform.ASTTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class APIPostTest {

    @Test
    public void shouldTestPost() {
        // Given - When - Then
// Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .body("some value") // отправляемые данные (заголовки и query можно выставлять аналогично)
// Выполняемые действия
                .when()
                .post("/post")
// Проверки
                .then()
                .statusCode(200)
                .body("data", equalTo("some value"))
        ;
    }


    @Test
    public void shouldTestRussiaText() {
        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body("Привет")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo("Привет"))
        ;
    }
}
