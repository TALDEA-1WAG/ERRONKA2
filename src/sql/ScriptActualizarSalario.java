package sql;

import java.io.*;

public class ScriptActualizarSalario {
	public static void generar() {
		try (PrintWriter pw = new PrintWriter(new FileWriter("actualizar_salarios.sql"))) {
		pw.println("UPDATE langile SET soldata = soldata * 1.05 WHERE postua = 'SALTZAILE';");
		pw.println("UPDATE langile SET soldata = soldata * 1.02 WHERE postua = 'NAGUSI';");


		System.out.println("Script creado: actualizar_salarios.sql");
		} catch (Exception e) {
		System.out.println("Error creando script");
		}
		}
		}