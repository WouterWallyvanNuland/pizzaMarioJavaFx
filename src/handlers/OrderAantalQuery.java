package handlers;

import dal.IExcecuteQueryHandler;

import dto.OrderAantalRow;

import java.sql.ResultSet;
import java.util.ArrayList;

public class OrderAantalQuery implements IExcecuteQueryHandler<OrderAantalRow> {
    private final String sp_name = "{call dbo.order_aantal_with_ratio}";

    private ArrayList<OrderAantalRow> orders;

    public OrderAantalQuery() {
        orders = new ArrayList<>();
    }

    @Override
    public String GetSpName() {
        return sp_name;
    }

    @Override
    public ArrayList<OrderAantalRow> getResults() {
        return orders;
    }

    @Override
    public void ProcessResult(ResultSet rs) {
        try {
            while (rs.next()) {
                OrderAantalRow row = new OrderAantalRow(rs.getString("id"), rs.getString("voornaam"),
                        rs.getString("achternaam"), rs.getInt("totaal_aantal"),
                        rs.getDouble("ratio_custom_pizzas"));
                orders.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}