package dto;

public class ActieveAanbiedingenRow {
    private int id;
    private String Omschrijving;
    private int aantal_keren_gebruikt;

    public ActieveAanbiedingenRow(int id, String omschrijving, int aantal_keren_gebruikt) {
        this.id = id;
        Omschrijving = omschrijving;
        this.aantal_keren_gebruikt = aantal_keren_gebruikt;
    }

    public int getId() {
        return id;
    }

    public String getOmschrijving() {
        return Omschrijving;
    }

    public int getAantal_keren_gebruikt() {
        return aantal_keren_gebruikt;
    }

    @Override
    public String toString() {
        return "ActieveAanbiedingenRow{" +
                "id=" + id +
                ", Omschrijving='" + Omschrijving + '\'' +
                ", aantal_keren_gebruikt=" + aantal_keren_gebruikt +
                '}';
    }
}
