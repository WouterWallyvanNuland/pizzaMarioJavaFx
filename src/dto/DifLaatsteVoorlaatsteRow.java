package dto;

public class DifLaatsteVoorlaatsteRow {
    private int klant_id;
    private int aantal_dagen_verschil;

    public DifLaatsteVoorlaatsteRow(int klant_id, int aantal_dagen_verschil) {
        this.klant_id = klant_id;
        this.aantal_dagen_verschil = aantal_dagen_verschil;
    }

    public int getKlant_id() {
        return klant_id;
    }

    public int getAantal_dagen_verschil() {
        return aantal_dagen_verschil;
    }

    @Override
    public String toString() {
        return "DifLaatsteVoorlaatsteRow{" +
                "klant_id=" + klant_id +
                ", aantal_dagen_verschil=" + aantal_dagen_verschil +
                '}';
    }
}
