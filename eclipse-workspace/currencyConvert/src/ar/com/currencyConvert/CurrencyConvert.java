package ar.com.currencyConvert;

import java.net.HttpURLConnection;
import java.net.URL;

import org.json.*;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class CurrencyConvert {

	public String access_token = "80e809405b7e435442990ecf96bdf947";

	public String currencyToCovert;
	
	public String conversionCurrency;
	
	public double amount;
	
	public CurrencyConvert(String conversionCurrency, String currencyToConvert, double amount) {
		this.conversionCurrency = conversionCurrency;
		this.currencyToCovert = currencyToConvert;
		this.amount = amount;
	}
		
	public void HttpResponse() {
		try {
			
			String uri = "http://api.exchangeratesapi.io/v1/latest" + "?base=" + this.conversionCurrency + "&access_key=" + this.access_token;
			
			// Se establece la conexion y se le pasa la url a consultar
			HttpURLConnection connection = (HttpURLConnection) new URL(uri).openConnection();
			
			// Se le asigna un metodo a la cadena de conexion
			connection.setRequestMethod("GET");
			
			// Se crea un BufferReader que sirve para leer datos de una entrada, sea de un input o una conexion
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			
			// Leemos el reader
			String response = reader.readLine();
			reader.close();

			// Parseamos los datos obtenidos a un formato JSON
			JSONObject responseJson = new JSONObject(response);

			// Obtenemos los datos de la respuesta y buscamos "rates" y ademas dentro de "rates" le decimso que busque un dato de tipo double y que se llame "nombre de la moneda a convertir"
			double exchangeRate = responseJson.getJSONObject("rates").getDouble(this.currencyToCovert);

					
			// Guardamos la multiplicacion de la moneda que se quiere convertir por la cantidad que quiere convertir
			double convertAmount = exchangeRate * this.amount;

			System.out.println(convertAmount);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
