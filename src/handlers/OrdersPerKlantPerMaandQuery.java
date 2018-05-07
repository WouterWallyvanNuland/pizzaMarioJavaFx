package handlers;

import dal.IExcecuteQueryHandler;
import dto.OrdersPerKlantRow;

import java.sql.ResultSet;
import java.util.ArrayList;

public class OrdersPerKlantPerMaandQuery implements IExcecuteQueryHandler<OrdersPerKlantRow> {
    private final String sp_name = "{call dbo.orders_per_klant_per_maand}";

    private ArrayList<OrdersPerKlantRow> ordersPerKlant;

    public OrdersPerKlantPerMaandQuery() {
        ordersPerKlant = new ArrayList<>();
    }

    @Override
    public void ProcessResult(ResultSet rs) {
        try{
            while(rs.next()){
                OrdersPerKlantRow row = new OrdersPerKlantRow(rs.getInt("klant_id"),
                        rs.getString("voornaam"),
                        rs.getString("achternaam"),
                        rs.getString("maand"),
                        rs.getInt("aantal_bestellingen"));
                ordersPerKlant.add(row);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<OrdersPerKlantRow> getResults() {
        return ordersPerKlant;
    }

    @Override
    public String GetSpName() {
        return sp_name;
    }
}
