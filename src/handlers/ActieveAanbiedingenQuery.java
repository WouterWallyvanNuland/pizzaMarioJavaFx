package handlers;

import dal.IExcecuteQueryHandler;
import dto.ActieveAanbiedingenRow;

import java.sql.ResultSet;
import java.util.ArrayList;

public class ActieveAanbiedingenQuery implements IExcecuteQueryHandler<ActieveAanbiedingenRow> {
    private final String sp_name = "{call dbo.actieve_aanbiedingen}";

    ArrayList<ActieveAanbiedingenRow> actieveAanbiedingen;

    public ActieveAanbiedingenQuery() {
        actieveAanbiedingen = new ArrayList<>();
    }

    @Override
    public void ProcessResult(ResultSet rs) {
        try{
            while (rs.next()){
                ActieveAanbiedingenRow row = new ActieveAanbiedingenRow(rs.getInt("id"),
                        rs.getString("omschrijving"),
                        rs.getInt("aantal_keren_gebruikt"));
                actieveAanbiedingen.add(row);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<ActieveAanbiedingenRow> getResults() {
        return actieveAanbiedingen;
    }

    @Override
    public String GetSpName() {
        return sp_name;
    }
}
