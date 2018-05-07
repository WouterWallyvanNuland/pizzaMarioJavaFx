package dto;

public class OrdersPerKlantRow {
    private int klant_id;
    private String voornaam;
    private String achternaam;
    private String maand;
    private int aantal_bestellingen;

    public OrdersPerKlantRow(int klant_id, String voornaam, String achternaam, String maand, int aantal_bestellingen) {
        this.klant_id = klant_id;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.maand = maand;
        this.aantal_bestellingen = aantal_bestellingen;
    }

    public int getKlant_id() {
        return klant_id;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public String getMaand() {
        return maand;
    }

    public int getAantal_bestellingen() {
        return aantal_bestellingen;
    }

    @Override
    public String toString() {
        return "OrdersPerKlantRow{" +
                "klant_id=" + klant_id +
                ", voornaam='" + voornaam + '\'' +
                ", achternaam='" + achternaam + '\'' +
                ", maand='" + maand + '\'' +
                ", aantal_bestellingen=" + aantal_bestellingen +
                '}';
    }
}
