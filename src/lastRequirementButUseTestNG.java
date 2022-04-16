import org.testng.Assert;
import org.testng.annotations.Test;

import files.convertingBacktoJson;
import files.payLoad;
import io.restassured.path.json.JsonPath;

public class lastRequirementButUseTestNG {
	
	@Test
	public void sumOfCourses() {
		JsonPath js1=convertingBacktoJson.convertingToJson(payLoad.implementingJsonOfGivenRequest());
		int noOfCourses=js1.getInt("courses.size()");
		int purchaseAmount=js1.getInt("dashboard.purchaseAmount");
		int sum=0;
		for(int i=0;i<noOfCourses;i++) {
			int courseprice=js1.getInt("courses.price["+i+"]");
			int noOfCopies=js1.getInt("courses.copies["+i+"]");
			int totalPurschaseOfSpecifiedCourse=courseprice*noOfCopies;
			sum=sum+totalPurschaseOfSpecifiedCourse;
		}
		Assert.assertEquals(sum, purchaseAmount);
		
	}

}
