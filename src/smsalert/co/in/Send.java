package smsalert.co.in;

public class Send {
	// enter the api key here between ""
			static String api_key = "56exxxxxx" ;
			// enter the sender id here between ""
			static String sender_id = "CVxxxx";
			// enter the api url here between ""
			static String api_url = "http://www.smsalert.co.in";
			// enter the message here between ""
			static String message = "message goes here";
			// enter the mobile no  here between ""
			static String mob_no = "90xxxxxxx";
			
		    public static void main(String[] args) throws Exception { 
				
				
				SendSms smsObj = new SendSms(); 
				
				smsObj.setparams(api_url,api_key,sender_id); 
				
				smsObj.send_sms(mob_no, message); 
				
				
		}

}
