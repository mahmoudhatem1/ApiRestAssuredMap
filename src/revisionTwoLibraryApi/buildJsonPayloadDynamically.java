package revisionTwoLibraryApi;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import files.convertingBacktoJson;
import files.payLoad;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
public class buildJsonPayloadDynamically {


	@Test
	(dataProvider="BooksData")
	public void addBook(String isbn,String aisle) throws IOException { 
	{
		RestAssured.baseURI="http://216.10.245.166";
		String giverResponse=
		given().log().all().header("Content-Type","application/json")
		.body(payLoad.returningLibraryApi(isbn, aisle)).when().post("/Library/Addbook.php")
		.then().log().all().assertThat().statusCode(200).extract().response().asString();
		JsonPath js1=convertingBacktoJson.convertingToJson(giverResponse);
		String id=js1.getString("ID");
		System.out.println(id);
	}
	@DataProvider(name="BooksData")
	public Object[][] getData() {
		//array is collection of elements
		//multidimenstional arrays is collection of arrays
		Object[][] x= new Object[][] {{"ahmed","12"},{"mahmoud","34"},{"yara","56"}};
		return x;
	}
}
