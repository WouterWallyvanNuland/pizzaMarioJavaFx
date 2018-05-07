package dal;

import dto.*;
import handlers.*;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.ArrayList;

public class Database {
    public ArrayList<ActieveAanbiedingenRow> ExecuteActieveAanbiedingen() {
        ActieveAanbiedingenQuery handler = new ActieveAanbiedingenQuery();
        Proc.Execute(handler);
        return handler.getResults();
    }

    public ArrayList<VdagenSindsRow> ExecuteInactiefVanaf(int vanaf) {
        //TODO:  rewrite Proc to support parameters
        InactiefVanafQuery handler = new InactiefVanafQuery();
//        Proc.Execute(handler);
        try (
                Connection con = DbConn.connect();
                CallableStatement cmd = con.prepareCall(handler.GetSpName()))
        {
            cmd.setInt("dagen", vanaf);
            boolean success = cmd.execute();
            if (success) {
                handler.ProcessResult(cmd.getResultSet());
            }
            else{
                System.out.println("something went wrong with the database");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return handler.getResults();
    }

    public ArrayList<DifLaatsteVoorlaatsteRow> ExecuteLaatsteVoorLaatsteBestelling() {
        LaatsteVoorLaatsteBestellingQuery handler = new LaatsteVoorLaatsteBestellingQuery();
        Proc.Execute(handler);
        return handler.getResults();
    }

    public ArrayList<OrderAantalRow> ExecuteOrderAantal(){
        OrderAantalQuery handler = new OrderAantalQuery();
        Proc.Execute(handler);
        return handler.getResults();
    }

    public ArrayList<OrdersPerKlantRow> ExecuteOdersPerMaand() {
        OrdersPerKlantPerMaandQuery handler = new OrdersPerKlantPerMaandQuery();
        Proc.Execute(handler);
        return handler.getResults();
    }

    public ArrayList<Top10Row> ExecuteTop10Bestsellers() {
        Top10BestsellersQuery handler = new Top10BestsellersQuery();
        Proc.Execute(handler);
        return handler.getResults();
    }
}
