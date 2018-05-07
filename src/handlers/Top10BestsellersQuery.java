package handlers;

import dal.IExcecuteQueryHandler;

import dto.Top10Row;

import java.sql.ResultSet;
import java.util.ArrayList;

public class Top10BestsellersQuery implements IExcecuteQueryHandler<Top10Row> {
    private final String sp_name = "{call dbo.top10_bestsellers}";

    private ArrayList<Top10Row> top10;

    public Top10BestsellersQuery() {
        top10 = new ArrayList<>();
    }

    @Override
    public void ProcessResult(ResultSet rs) {
        try{
            while (rs.next()){
                Top10Row row = new Top10Row(rs.getString("naam"), rs.getInt("totaal_aantal_pizzas"));
                top10.add(row);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Top10Row> getResults() {
        return top10;
    }

    @Override
    public String GetSpName() {
        return sp_name;
    }
}
