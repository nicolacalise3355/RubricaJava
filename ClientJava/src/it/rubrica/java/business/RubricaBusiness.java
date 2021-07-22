package it.rubrica.java.business;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import it.rubrica.java.model.Contatti;
import com.google.gson.*;

public class RubricaBusiness {
	
	/*
	 * Qua mettiamo i metodi per mandare le richieste POST al db 
	 */
	
	private String urlForReq = "http://localhost/ServerRubrica/data.php";
	
	Gson js = new Gson();
	
	public String insertContact(String nome, String cognome, String telefono) throws IOException {
		HttpURLConnection connection = null;
		
		Map<String,Object> params = new LinkedHashMap<>();
		params.put("codice", 2);
		params.put("nome", nome);
		params.put("cognome", cognome);
		params.put("telefono", telefono);
		
		StringBuilder postData = new StringBuilder();
		
		for (Map.Entry<String,Object> param : params.entrySet()) {
            if (postData.length() != 0) postData.append('&');
            postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
            postData.append('=');
            postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
        }
		
		byte[] postDataBytes = postData.toString().getBytes("UTF-8");
		
		//Create connection
	    URL url = new URL(urlForReq);
	    connection = (HttpURLConnection) url.openConnection();
	    connection.setRequestMethod("POST");
	    connection.setRequestProperty("Content-Type", 
	        "application/x-www-form-urlencoded");

	    connection.setRequestProperty("Content-Length", 
	        Integer.toString(postDataBytes.length));
	    connection.setRequestProperty("Content-Language", "en-US");  

	    connection.setUseCaches(false);
	    connection.setDoOutput(true);
	    
	    //Send request
	    DataOutputStream wr = new DataOutputStream (
	        connection.getOutputStream());
	    wr.write(postDataBytes);
	    wr.close();
	    
	    //Get Response  
	    InputStream is = connection.getInputStream();
	    BufferedReader rd = new BufferedReader(new InputStreamReader(is));
	    StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
	    String line;
	    while ((line = rd.readLine()) != null) {
	      response.append(line);
	      response.append('\r');
	    }
	    rd.close();
	    //System.out.println(response.toString());
	    String jsonGot = response.toString();
	    return response.toString();
	}
	
	public String getContactsJson() throws IOException {
		int code = 1;
		//String params = "Default";
		
		HttpURLConnection connection = null;
		
		Map<String,Object> params = new LinkedHashMap<>();
		params.put("codice", code);
		
		StringBuilder postData = new StringBuilder();
		
		for (Map.Entry<String,Object> param : params.entrySet()) {
            if (postData.length() != 0) postData.append('&');
            postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
            postData.append('=');
            postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
        }
		
		byte[] postDataBytes = postData.toString().getBytes("UTF-8");
		
		//TODO per migliorare aggiungere un try/catch invece che lanciare un eccezione e basta
		
		//Create connection
	    URL url = new URL(urlForReq);
	    connection = (HttpURLConnection) url.openConnection();
	    connection.setRequestMethod("POST");
	    connection.setRequestProperty("Content-Type", 
	        "application/x-www-form-urlencoded");

	    connection.setRequestProperty("Content-Length", 
	        Integer.toString(postDataBytes.length));
	    connection.setRequestProperty("Content-Language", "en-US");  

	    connection.setUseCaches(false);
	    connection.setDoOutput(true);
	    
	    //Send request
	    DataOutputStream wr = new DataOutputStream (
	        connection.getOutputStream());
	    wr.write(postDataBytes);
	    wr.close();
	    
	    //Get Response  
	    InputStream is = connection.getInputStream();
	    BufferedReader rd = new BufferedReader(new InputStreamReader(is));
	    StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
	    String line;
	    while ((line = rd.readLine()) != null) {
	      response.append(line);
	      response.append('\r');
	    }
	    rd.close();
	    //System.out.println(response.toString());
	    String jsonGot = response.toString();
	    return response.toString();
		
	}
	
	public Contatti getContatti() throws IOException {
		String json = getContactsJson();
		Contatti c = js.fromJson(json, Contatti.class);
		return c;
	}
	
	

}
