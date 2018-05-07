package controllerquery;
import dal.Database;
import dto.*;

import javafx.event.ActionEvent;
import java.util.ArrayList;

public class ControllerQ {
    Database db;

    public ControllerQ() {
        this.db = new Database();
    }

    public ArrayList<ActieveAanbiedingenRow> getActieveAanbiedingen() {
        return db.ExecuteActieveAanbiedingen();
    }

    public ArrayList<VdagenSindsRow> GetInactiefVanaf(int vanaf) {
        return db.ExecuteInactiefVanaf(vanaf);
    }

    public ArrayList<DifLaatsteVoorlaatsteRow> GetLaatsteVoorLaatsteBestelling() {
        return db.ExecuteLaatsteVoorLaatsteBestelling();
    }

    public ArrayList<OrderAantalRow> GetOrderAantal(){
        return db.ExecuteOrderAantal();
    }

    public ArrayList<OrdersPerKlantRow> GetOrdersPerMaand() {
        return db.ExecuteOdersPerMaand();
    }

    public ArrayList<Top10Row> GetTop10Bestsellers() {
        return db.ExecuteTop10Bestsellers();
    }
}