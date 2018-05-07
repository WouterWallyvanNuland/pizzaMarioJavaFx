package handlers;

import dal.IExcecuteQueryHandler;
import dto.VdagenSindsRow;

import java.sql.ResultSet;
import java.util.ArrayList;

public class InactiefVanafQuery implements IExcecuteQueryHandler<VdagenSindsRow> {
    private final String sp_name = "{call dbo.klanten_inactief_vanaf(?)}";

    ArrayList<VdagenSindsRow> klanten;

    public InactiefVanafQuery() {
        klanten = new ArrayList<>();
    }

    @Override
    public void ProcessResult(ResultSet rs) {
        try{
            while(rs.next()){
                VdagenSindsRow row = new VdagenSindsRow(rs.getInt("klant_id"), rs.getInt("aantal_dagen"));
                klanten.add(row);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<VdagenSindsRow> getResults() {
        return klanten;
    }

    @Override
    public String GetSpName() {
        return sp_name;
    }
}
