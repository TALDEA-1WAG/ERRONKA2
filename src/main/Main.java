package main;


import menu.MenuPrincipal;
import seguridad.*;


public class Main {
	public static void main(String[] args) {
		Login login = new Login("erabiltzaileak.txt");
		if (!login.hasiSaioa()) {
			System.out.println("Saiakera gehiegi. Programa itxiko da.");
			return;
		}

		MenuPrincipal menua = new MenuPrincipal();
		menua.bistaratu();
	}
}