package modelos;

public class Empleado {
    private String izena, abizenak, email, telefonoa;

    public Empleado(String i, String a, String e, String t) {
        this.izena = i;
        this.abizenak = a;
        this.email = e;
        this.telefonoa = t;
    }

    public String toXML() {
        return
            "<langilea>\n" +
            "    <izena>" + izena + "</izena>\n" +
            "    <abizenak>" + abizenak + "</abizenak>\n" +
            "    <email>" + email + "</email>\n" +
            "    <telefonoa>" + telefonoa + "</telefonoa>\n" +
            "</langilea>";
    }
}
