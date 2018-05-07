package dto;
public class VdagenSindsRow {
    private int klant_id;
    private int aantal_dagen;

    public VdagenSindsRow(int klant_id, int aantal_dagen) {
        this.klant_id = klant_id;
        this.aantal_dagen = aantal_dagen;
    }

    public int getKlant_id() {
        return klant_id;
    }

    public int getAantal_dagen() {
        return aantal_dagen;
    }

    @Override
    public String toString() {
        return "VdagenSindsRow{" +
                "klant_id='" + klant_id + '\'' +
                ", aantal_dagen=" + aantal_dagen +
                '}';
    }
}
