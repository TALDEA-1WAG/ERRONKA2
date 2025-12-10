package xml;

import java.io.*;
import java.util.*;

import modelos.Empleado;

public class GeneradorXML {
	public static void sortuXML() {
		Scanner s = new Scanner(System.in);
		List<Empleado> zerrenda = new ArrayList<>();

		System.out.println("Zenbat langile gehitu nahi dituzu XML-ean?");
		int n = Integer.parseInt(s.nextLine());

		for (int i = 0; i < n; i++) {
			System.out.println("Langilea " + (i + 1));
			System.out.print("Izena: ");
			String iz = s.nextLine();
			System.out.print("Abizenak: ");
			String ab = s.nextLine();
			System.out.print("Emaila: ");
			String em = s.nextLine();
			System.out.print("Telefonoa: ");
			String te = s.nextLine();

			zerrenda.add(new Empleado(iz, ab, em, te));
		}

		try (PrintWriter pw = new PrintWriter(new FileWriter("langileak.xml"))) {
			pw.println("<langileak>");
			for (Empleado l : zerrenda)
				pw.println(l.toXML());
			pw.println("</langileak>");
		} catch (Exception e) {
			System.out.println("Errorea XML-a sortzean.");
		}

		System.out.println("XML sortua: langileak.xml");
	}
}