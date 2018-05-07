package sample;

import controllerquery.ControllerQ;
import dto.ActieveAanbiedingenRow;
import dto.VdagenSindsRow;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class Controller {
    public Label aanbiedingenLabel;
    public TextField inactiefTextField;
    public TextArea inactief;
    ControllerQ ctr = new ControllerQ();

    public void testFunctie(ActionEvent event) {

        System.out.println();
        System.out.println("testing getActieveAanbiedingen");
        ArrayList<String> aanbiedingenLijst = new ArrayList<>();

        for (ActieveAanbiedingenRow row : ctr.getActieveAanbiedingen()) {
            System.out.println(row);
            String aanbiedingString = row.toString();
            aanbiedingenLijst.add(aanbiedingString);
            System.out.println(aanbiedingenLijst);

        }
        aanbiedingenLabel.setText("Zie console voor resultaten Actieve aanbiedingen hierboven");
    }

    public void InactiefQuery(ActionEvent event) {

        System.out.println();
        System.out.println("Testing GetInactiefVanaf");

        for (VdagenSindsRow row : ctr.GetInactiefVanaf(50)) {
            System.out.println(row);
          //  inactiefTextField.setText(String.valueOf(row));

            inactief.setText(String.valueOf(row));
        }

}

    public void getActieveAanbiedingen(ActionEvent event) {
        aanbiedingenLabel.setText("test");
    }
}
