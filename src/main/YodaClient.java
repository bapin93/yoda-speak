package main;

public class YodaClient {

	public static void main(String[] args) {
		YodaConverter yoda = new YodaConverter();
		System.out.println(yoda.translate("The potato has three heads"));
	}
}
