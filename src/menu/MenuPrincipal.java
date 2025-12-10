package menu;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import db.DBConexion;
import sql.ScriptActualizarSalario;
import sql.ScriptCrearCampo;
import xml.GeneradorXML;

public class MenuPrincipal {

    private Scanner s = new Scanner(System.in);

    public void bistaratu() {
        int aukera;
        do {
            System.out.println("==== MENU NAGUSIA ====");
            System.out.println("1. Erabiltzaile berria sortu");
            System.out.println("2. XML sortu langileekin");
            System.out.println("3. SQL scriptak sortu");
            System.out.println("4. Langileen datu-basea erakutsi");
            System.out.println("5. Irten");
            System.out.print("Aukera: ");
            aukera = Integer.parseInt(s.nextLine());

            switch (aukera) {
                case 1 -> sortuErabiltzailea();
                case 2 -> GeneradorXML.sortuXML();
                case 3 -> menuaSQL();
                case 4 -> DBConexion.mostrarTabla();
                case 5 -> System.out.println("Agur!");
                default -> System.out.println("Aukera baliogabea");
            }
        } while (aukera != 5);
    }

    private void sortuErabiltzailea() {
        System.out.print("Erabiltzaile berria: ");
        String u = s.nextLine();
        System.out.print("Pasahitza: ");
        String p = s.nextLine();

        try (FileWriter fw = new FileWriter("Erabiltzaileak.txt", true)) {
            fw.write(u + "," + p + "\n");
            System.out.println("Erabiltzailea ongi gehitu da.");
        } catch (IOException e) {
            System.out.println("Errorea erabiltzailea gordetzean.");
        }
    }

    private void menuaSQL() {
        System.out.println("1. 'soldata' eremua sortzeko scripta");
        System.out.println("2. Soldatak eguneratzeko scripta");
        System.out.print("Aukera: ");
        int o = Integer.parseInt(s.nextLine());

        if (o == 1) ScriptCrearCampo.generar();
        else if (o == 2) ScriptActualizarSalario.generar();
        else System.out.println("Aukera baliogabea");
    }
}
