package ar.com.currencyConvert.interfaces;

public enum Coins {
	ARG("Argentina"),
	BRA("Brazil"),
	PE("Perú"), 
	CO("Colombia"), 
	USD("Estados Unidos");
	
	private final String label;

    Coins(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
