package groovy

import io.restassured.response.Response
import org.testng.Assert
import org.testng.annotations.Test

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath
import static io.restassured.RestAssured.*

class Booking extends Base {

    @Test
    void "Get Bookings"() {
        Response response = get("/booking")

        ArrayList<String> allBookings = response.path("bookingid")
        Assert.assertTrue(allBookings.size() >= 1, "No bookings returned")
    }

//     @Test
//     void "Validate Book Schema"() {
//         get("/books")
//                 .then()
//                 .assertThat()
//                 .body(matchesJsonSchemaInClasspath("bookSchema.json"))
//     }

//     @Test
//     void "Create And Delete Book"() {
//         File bookFile = new File(getClass().getResource("/book.json").toURI())
//         Response createResponse =
//                 given()
//                         .body(bookFile)
//                         .when()
//                         .post("/books")
//         String responseId = createResponse.jsonPath().getString("post.book_id")

//         Assert.assertEquals(createResponse.getStatusCode(), 201)

//         Response deleteResponse =
//                 given()
//                         .body("{\n" +
//                                 "\t\"book_id\": " + responseId + "\n" +
//                                 "}")
//                         .when()
//                         .delete("/books")

//         Assert.assertEquals(deleteResponse.getStatusCode(), 200)
//         Assert.assertEquals(deleteResponse.jsonPath().getString("message"), "Book successfully deleted")
//     }

//     @Test
//     void "Delete NonExistent Book"() {
//         String nonExistentBook = "9512"
//         Response deleteResponse =
//                 given()
//                         .body("{\n" +
//                                 "\t\"book_id\": " + nonExistentBook + "\n" +
//                                 "}")
//                         .when()
//                         .delete("/books")

//         Assert.assertEquals(deleteResponse.getStatusCode(), 500)

//     }
}