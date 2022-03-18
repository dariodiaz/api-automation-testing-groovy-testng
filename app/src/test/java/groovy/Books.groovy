import io.restassured.response.Response
import org.testng.Assert
import org.testng.annotations.Test

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath
import static io.restassured.RestAssured.*

class Books extends Base {
    @Test
    void getBooksList() {
        Response response = get("/books")

        ArrayList<String> allBooks = response.path("data.title")
        Assert.assertTrue(allBooks.size() > 1, "No books returned")
    }

    @Test
    void booksSchemaIsValid() {
        get("/books")
        .then()
        .assertThat()
        .body(matchesJsonSchemaInClasspath("booksSchema.json"))
    }
}