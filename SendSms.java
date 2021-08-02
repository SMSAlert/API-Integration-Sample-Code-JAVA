package smsalert.co.in;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.*;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class SendSms {
	public void addSslCertificate() throws NoSuchAlgorithmException, KeyManagementException {

		TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
			public java.security.cert.X509Certificate[] getAcceptedIssuers() {
				return null;
			}

			public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {

			}

			public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {

			}

		} };

		SSLContext sc = SSLContext.getInstance("SSL");
		sc.init(null, trustAllCerts, new java.security.SecureRandom());
		HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

		// Create all-trusting host name verifier
		HostnameVerifier allHostsValid = new HostnameVerifier() {
			public boolean verify(String hostname, SSLSession session) {

				return false;
			}
		};
		// Install the all-trusting host verifier
		HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
		/*
		 * end of the fix
		 */

	}

	// declaring class variable
	static String api_key;
	static String username;
	static String password;

	static String sender_id;
	static String api_url;
	static String start;

	String time;
	String mob_no;
	String message;
	String unicode;
	String dlr_url;
	String type;
	String route;

	// function to set sender id
	public static void setsender_id(String sid) {
		sender_id = sid;
		return;
	}

	// function to set api_key key
	public static void setapi_key(String apk) {
		// checking for valid working key
		api_key = apk;
		return;
	}

	// function to set username 
	public static void setusername(String user) {
		// checking for valid working key
		username = user;
		return;
	}

	// function to set password 
	public static void setpassword(String pwd) {
		// checking for valid working key
		password = pwd;
		return;
	}

	// function to set Api url
	public static void setapi_url(String ap) {
		// checking for valid url format
		String check = ap;
		String str = check.substring(0, 7);
		String t = "http://";
		String s = "https:/";
		String st = "https://";
		if (str.equals(t)) {
			start = t;
			api_url = check.substring(7);
		} else if (check.substring(0, 8).equals(st)) {
			start = st;
			api_url = check.substring(8);
		} else if (str.equals(s)) {
			start = st;
			api_url = check.substring(7);
		} else {
			start = t;
			api_url = ap;
		}
	}

	// function to set parameter import java.net.URLEncoder;
	public void setparams(String ap, String apk, String sd) {
		setapi_key(apk);
		setsender_id(sd);
		setapi_url(ap);
	}

	// function to set parameter import java.net.URLEncoder;
	public void authparams(String url,String user, String pwd) {
		setusername(user);
		setpassword(pwd);
		setapi_url(url);
	}

	/*
	 * function to send sms
	 * 
	 * @ Simple message : last two field are set to null
	 * 
	 * @ Unicode message :set unicode parameter to one
	 * 
	 * @ Scheduled message : give time in 'ddmmyyyyhhmm' format
	 */
	public String process_sms(String sender, String mob_no, String message, String route, String unicode, String time)
			throws IOException, MalformedURLException, KeyManagementException, NoSuchAlgorithmException {

		message = URLEncoder.encode(message, "UTF-8");
		if (unicode == null)
			unicode = "0";
		unicode = "&unicode=" + unicode;
		if (time == null)
			time = "";
		else
			time = "&time=" + URLEncoder.encode(time, "UTF-8");
		URL url = new URL("" + start + api_url+"/api/push.json?user=" + username + "&pwd=" + password + "&sender=" + sender
				+ "&mobileno=" + mob_no + "&text=" + message + "&route=" + route + unicode + time);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		con.setRequestMethod("POST");
		con.setDoOutput(true);
		con.getOutputStream();
		con.getInputStream();
		BufferedReader rd;
		String line;
		String result = "";
		rd = new BufferedReader(new InputStreamReader(con.getInputStream()));
		while ((line = rd.readLine()) != null) {
			result += line;
		}
		rd.close();
		return result;

	}

	public void send_sms(String sender,String mob_no, String message, String route)
			throws IOException, MalformedURLException, KeyManagementException, NoSuchAlgorithmException {
		process_sms(sender, mob_no, message, route,unicode = null, time = null);

	}

}
