package dto;

public class OrderAantalRow {
    private String id;
    private String voornaam;
    private String achternaam;
    private int aantal;
    private double ratio;

    public OrderAantalRow() {
    }

    public OrderAantalRow(String id, String voornaam, String achternaam, int aantal, double ratio) {
        this.id = id;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.aantal = aantal;
        this.ratio = ratio;
    }

    public String getId() {
        return id;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public int getAantal() {
        return aantal;
    }

    public double getRatio() {
        return ratio;
    }

    @Override
    public String toString() {
        return "OrderAantalRow{" +
                "id='" + id + '\'' +
                ", voornaam='" + voornaam + '\'' +
                ", achternaam='" + achternaam + '\'' +
                ", aantal=" + aantal +
                ", ratio=" + ratio +
                '}';
    }
}
