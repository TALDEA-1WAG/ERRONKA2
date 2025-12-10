package sql;

import java.io.*;

import java.io.*;

public class ScriptCrearCampo {
	public static void generar() {
		try (PrintWriter pw = new PrintWriter(new FileWriter("sortu_soldata_eremua.sql"))) {
			pw.println("ALTER TABLE langileak ADD soldata DECIMAL(10,2);");
			System.out.println("Scripta sortua: sortu_soldata_eremua.sql");
		} catch (Exception e) {
			System.out.println("Errorea scripta sortzean.");
		}
	}
}