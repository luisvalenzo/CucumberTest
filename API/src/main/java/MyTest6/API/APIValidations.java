package MyTest6.API;

import java.util.HashMap;
import java.util.List;

public class APIValidations {
	boolean flag = false;
	public boolean validate_status(int statuscode) {
		if(statuscode == 200) {
			System.out.println("Successful GET request: "+statuscode);
			flag=true;
		}else {
			System.out.println("Unsuccessful GET request: "+statuscode);
		}
		return flag;
	}
	
	public boolean validate_resp_time(long responsetime) {
		if(responsetime < 1000){
			System.out.println("Response time is less than 1000ms: "+responsetime+"ms");
			flag=true;
		}else {
			System.out.println("Response time is more than 1000ms: "+responsetime+"ms");
		}
		return flag;
	}
	
	public boolean validate_string(List<HashMap<String, Object>> responsebodylist, String text) {
		if(responsebodylist.get(0).get("title").equals(text)) {
			System.out.println("Body contains the string: "+text);	
			flag=true;
		}else {
			System.out.println("Body does not contain the string: "+text);
		}
		return flag;
	}
}
