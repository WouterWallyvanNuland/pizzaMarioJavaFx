package handlers;

import dal.IExcecuteQueryHandler;
import dto.DifLaatsteVoorlaatsteRow;

import java.sql.ResultSet;
import java.util.ArrayList;

public class LaatsteVoorLaatsteBestellingQuery implements IExcecuteQueryHandler<DifLaatsteVoorlaatsteRow>{
    private final String sp_name = "{call dbo.dagen_verschil_laatste_voorlaatste_bestelling}";

    private ArrayList<DifLaatsteVoorlaatsteRow> bestellingen;

    public LaatsteVoorLaatsteBestellingQuery() {
        bestellingen = new ArrayList<>();
    }

    @Override
    public void ProcessResult(ResultSet rs) {
        try{
            while(rs.next()){
                DifLaatsteVoorlaatsteRow row = new DifLaatsteVoorlaatsteRow(rs.getInt("klant_id"),
                        rs.getInt("aantal_dagen_verschil"));
                bestellingen.add(row);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<DifLaatsteVoorlaatsteRow> getResults() {
        return bestellingen;
    }

    @Override
    public String GetSpName() {
        return sp_name;
    }
}
