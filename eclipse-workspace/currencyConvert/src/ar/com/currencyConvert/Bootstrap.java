package ar.com.currencyConvert;

import javax.swing.JOptionPane;
import ar.com.currencyConvert.interfaces.Coins;

public class Bootstrap {
	
	public static void main(String[] args) {
		
		Coins[] coins = Coins.values();
		
        String[] coinLabels = new String[coins.length];
        
        for (int i = 0; i < coins.length; i++) {
            coinLabels[i] = "De peso a " + coins[i].getLabel();
        }
        
        int option = 0;
		
		while(option != 3) {
			
			String quantity = JOptionPane.showInputDialog("Ingrese la cantidad que desea convertir");
			
			if(quantity == null) return;
			
			Object conversionCurrency = JOptionPane.showInputDialog(null, "Elije a que moneda quieres convertir", "Conversor de moneda", JOptionPane.INFORMATION_MESSAGE, null, coinLabels, coinLabels[0]);
			
			if(conversionCurrency == null) return;
			
		}
		
		//CurrencyConvert currency = new CurrencyConvert("EUR", "ARS", Integer.parseInt(quantity));
		
		//currency.HttpResponse();
	
	}
}
