package main.java;

public class YodaClient {
	public static void main(String[] args) {
		YodaConverter yoda = new YodaConverter();
		System.out.println(yoda.translate("This string will be coverted."));
	}
}
