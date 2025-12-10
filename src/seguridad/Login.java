package seguridad;

import java.io.*;
import java.util.*;

public class Login {
	private final String fitxategia;

	public Login(String fitxategia) {
		this.fitxategia = fitxategia;
	}

	public boolean hasiSaioa() {
		Scanner s = new Scanner(System.in);
		int saiakerak = 4;

		while (saiakerak > 0) {
			System.out.print("Erabiltzailea: ");
			String u = s.nextLine();
			System.out.print("Pasahitza: ");
			String p = s.nextLine();

			if (egiaztatu(u, p))
				return true;

			saiakerak--;
			System.out.println("Okerreko datuak. Geratzen diren saiakerak: " + saiakerak);
		}
		return false;
	}

	private boolean egiaztatu(String u, String p) {
		try (BufferedReader br = new BufferedReader(new FileReader(fitxategia))) {
			String lerroa;
			while ((lerroa = br.readLine()) != null) {
				String[] datuak = lerroa.split(",");
				if (datuak.length == 2 && datuak[0].equals(u) && datuak[1].equals(p)) {
					return true;
				}
			}
		} catch (Exception e) {
			System.out.println("Errorea fitxategia irakurtzean: " + e.getMessage());
		}
		return false;
	}
}