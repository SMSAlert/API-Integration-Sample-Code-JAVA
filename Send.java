import smsalert.co.in.*;

public class Send {
	//enter the SMS Alert username here between "" 
	static String username = "YOUR_USERNAME_HERE";
	//enter the SMS Alert password here between ""
	static String password = "YOUR_PASSWORD_HERE";
	// enter the sender id here between ""
	static String sender = "CVDEMO";
	// enter the api url here between ""
	static String api_url = "https://www.smsalert.co.in";
	// enter the message here between ""
	static String message = "message goes here";
	// enter the mobile no  here between ""
	static String mobileno = "91XXXXXXXXXX";
	// enter the route here between ""
	static String route = "demo";
	
	//If you want to use apikey for authentication uncomment below line. 
        //static String api_key = "56exxxxxx";
   
	
	public static void main(String[] args) throws Exception { 
		
		
	SendSms smsObj = new SendSms();
		
	//If you want to use apikey for authentication uncomment below line.
    	//smsObj.setparams(api_url,api_key,sender);
   
	smsObj.authparams(api_url, username, password);
   
	smsObj.send_sms(sender,mobileno, message, route); 
				
	}

}
