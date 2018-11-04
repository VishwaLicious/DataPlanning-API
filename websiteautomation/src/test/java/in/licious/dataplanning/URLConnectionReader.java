package in.licious.dataplanning;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class URLConnectionReader {
	public static void main(String[] args) throws Exception {
		HostnameVerifier allHostsValid = new HostnameVerifier() {
			public boolean verify(String hostname, SSLSession session) {
				return true;
			}
		};

		HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);

		String httpsURL = URLEncoder.encode("https"
				+ "://52.66.9.219:9200/_sql?sql=select count(*) from orderdataplannew");
		URL myurl = new URL(httpsURL);
		HttpURLConnection con = (HttpURLConnection) myurl.openConnection();

		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String input;
		while ((input = br.readLine()) != null) {
			System.out.println(input);
		}
		br.close();
	}
}
