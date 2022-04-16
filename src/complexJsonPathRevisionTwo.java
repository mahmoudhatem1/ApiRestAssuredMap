import files.convertingBacktoJson;
import files.payLoad;
import io.restassured.path.json.JsonPath;

public class complexJsonPathRevisionTwo {
	public static void main(String[]args) {
		JsonPath js1=convertingBacktoJson.convertingToJson(payLoad.implementingJsonOfGivenRequest());
		//print no of courses returned by API
		int noOfCourses=js1.getInt("courses.size()");
		System.out.println(noOfCourses);
		int purcshaseAmount=js1.getInt("dashboard.purchaseAmount");
		System.out.println(purcshaseAmount);
		String titleOfFirstCourse=js1.getString("courses[0].title");
		System.out.println(titleOfFirstCourse);
		
		for(int i=0;i<noOfCourses;i++) {
			String courseTitle=js1.getString("courses.title["+i+"]");
			int coursePrice=js1.get("courses.price["+i+"]");
			System.out.println(courseTitle+coursePrice);
		}
		for(int i=0;i<noOfCourses;i++) {
			String courseName=js1.getString("courses.title["+i+"]");
			if(courseName.equals("RPA")) {
				int noOfCopies=js1.getInt("courses["+i+"].copies");
				System.out.println(noOfCopies);
			break;
			}
			
			
		}
	}
	


}
