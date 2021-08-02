# API-Integration-Sample-Code-JAVA
A simple JAVA client package to send SMS messages using SMS Alert Gateway.

To use this package, you must have a valid account on https://www.smsalert.co.in.

For any questions, please contact us at support@cozyvision.com

## Features
Send sms to any mobile number using username, password, senderid, route.

## Requirements
username : SMS Alert account username
password : SMS Alert account password
mobileno : Destination mobile number (Keep number in international format)
message : Message Content to send
sender : Receiver will see this as sender's ID
route : If your operator supports multiple routes then give one route name

## How to use
```java
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
   
	public static void main(String[] args) throws Exception { 
	   SendSms smsObj = new SendSms();
	   smsObj.authparams(api_url, username, password);
	   smsObj.send_sms(sender,mobileno, message, route); 
	}
}
```  
## More Info
You can check out our website https://www.smsalert.co.in .
