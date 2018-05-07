package sample;

import dto.*;
import javafx.event.ActionEvent;
import sample.Controller;
import controllerquery.ControllerQ;
import handlers.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        //   Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        StackPane root = new StackPane();

        primaryStage.setTitle("Pizza Mario JavaFx");
        Scene scene = new Scene(root, 600, 500);

        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
//        ScatterChart chart = new ScatterChart(xAxis, yAxis, getChartData());

        // door yves getypt
//        ScatterChart chartAanbiedingen = new ScatterChart(xAxis, yAxis, getAanbiedingenData());
//        chartAanbiedingen.setTitle("Actieve aanbiedingen.. ");
//        root.getChildren().add(chartAanbiedingen);

//        // barchart // werkt met sql en printscreen
//        BarChart chartOrdersPerKlantPerMaand = new BarChart(xAxis, yAxis, getOrdersPerKlantPerMaandData());
//        chartOrdersPerKlantPerMaand.setTitle("Orders per klant per maand");
//        root.getChildren().add(chartOrdersPerKlantPerMaand);

        // werkt maar klopt niet zo veel van
//        BarChart chartOrdersPerKlant = new BarChart(xAxis, yAxis, getOrderAantalPerKlantData());
//        chartOrdersPerKlant.setTitle("Meeste orders per klant");
//        root.getChildren().add(chartOrdersPerKlant);

        // dif laatste voorlaatste -> barchart
        BarChart chartDifLaatsteVoorlaatste = new BarChart(xAxis, yAxis, getDifLaatsteVoorlaatsteData());
        chartDifLaatsteVoorlaatste.setTitle("Aantal dagen verschil tussen laatste orders");
        root.getChildren().add(chartDifLaatsteVoorlaatste);

        // werkt met sql, duurt alleen beetje lang op mn laptop - inactief sinds - Linechart
//        LineChart chartInactiefSinds = new LineChart(xAxis, yAxis, getInactiefVanafData());
//        chartInactiefSinds.setTitle("Aantal dagen inactief");
//        root.getChildren().add(chartInactiefSinds);

        // werkt met sql maar komt er niet lekker uit
//        ScatterChart chartTop10 = new ScatterChart(xAxis, yAxis, getTop10Data());
//        chartTop10.setTitle("Top 10 selling items");
//        root.getChildren().add(chartTop10);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }

    private ObservableList<XYChart.Series<String, Integer>> getAanbiedingenData() {
        ControllerQ ctr = new ControllerQ();
        ObservableList<XYChart.Series<String, Integer>> data = FXCollections.observableArrayList();

        for (ActieveAanbiedingenRow row: ctr.getActieveAanbiedingen()) {
            XYChart.Series<String, Integer> actieveAanbieding = new XYChart.Series<>();
            actieveAanbieding.setName("%korting");
            actieveAanbieding.getData().add(new XYChart.Data<>(row.getOmschrijving(),
                            row.getAantal_keren_gebruikt()));
            data.add(actieveAanbieding);
        }

        return data;
    }

    private ObservableList<XYChart.Series<String, Integer>> getInactiefVanafData() {
        ControllerQ ctr = new ControllerQ();
        ObservableList<XYChart.Series<String, Integer>> dataInactiefSinds = FXCollections.observableArrayList();
        for (DifLaatsteVoorlaatsteRow row: ctr.GetLaatsteVoorLaatsteBestelling()) {
            XYChart.Series<String, Integer> laatsteVoorlaatste = new XYChart.Series<>();
            laatsteVoorlaatste.setName("Dagen verschil sinds laatste bestelling");
            laatsteVoorlaatste.getData().add(new XYChart.Data<>(row.toString(), row.getAantal_dagen_verschil()));
            dataInactiefSinds.add(laatsteVoorlaatste);
        }

        return dataInactiefSinds;
    }

    private ObservableList<XYChart.Series<String, Integer>> getDifLaatsteVoorlaatsteData() {

        ObservableList<XYChart.Series<String, Integer>> dataDifLaatsteVoorlaatste = FXCollections.observableArrayList();

        ControllerQ ctr = new ControllerQ();
        for (DifLaatsteVoorlaatsteRow row: ctr.GetLaatsteVoorLaatsteBestelling())
        {
            XYChart.Series<String, Integer> verschilLaatsteBestelling = new XYChart.Series<>();
            verschilLaatsteBestelling.setName("verschil tussen laatste en voorlaatste bestelling");
            verschilLaatsteBestelling.getData().add(new XYChart.Data<>(row.toString(), row.getAantal_dagen_verschil()));
            dataDifLaatsteVoorlaatste.add(verschilLaatsteBestelling);
        }


        return dataDifLaatsteVoorlaatste;
    }

    private ObservableList<XYChart.Series<String, Integer>> getOrderAantalPerKlantData() {

        ObservableList<XYChart.Series<String, Integer>> dataOrderAantalPerKlant = FXCollections.observableArrayList();
        ControllerQ ctr = new ControllerQ();
        for (OrderAantalRow row: ctr.GetOrderAantal())
        {
            XYChart.Series<String, Integer> orderAantalPerKlant = new XYChart.Series<>();
            orderAantalPerKlant.setName("orders per klant");
            orderAantalPerKlant.getData().add(new XYChart.Data<>(row.getId(), row.getAantal()));
            dataOrderAantalPerKlant.add(orderAantalPerKlant);
        }
        return dataOrderAantalPerKlant;
    }

    private ObservableList<XYChart.Series<String, Integer>> getOrdersPerKlantPerMaandData() {
        ControllerQ ctr = new ControllerQ();
        ObservableList<XYChart.Series<String, Integer>> dataOrdersPerKlantPerMaand = FXCollections.observableArrayList();

        for (OrdersPerKlantRow row: ctr.GetOrdersPerMaand()) {
            XYChart.Series<String, Integer> ordersPerMaand = new XYChart.Series<>();
            ordersPerMaand.getData().add(new XYChart.Data<>(row.getMaand(),
                    row.getAantal_bestellingen()));
            dataOrdersPerKlantPerMaand.add(ordersPerMaand);
        }

        return dataOrdersPerKlantPerMaand;
    }

    private ObservableList<XYChart.Series<String, Integer>> getTop10Data() {
        ControllerQ ctr = new ControllerQ();

        ObservableList<XYChart.Series<String, Integer>> dataTop10 = FXCollections.observableArrayList();

        for (Top10Row row: ctr.GetTop10Bestsellers()) {
            XYChart.Series<String, Integer> top10 = new XYChart.Series<>();
            top10.getData().add(new XYChart.Data<>(row.getNaam(),
                    row.getTotaal_aantal()));
            dataTop10.add(top10);
        }

        return dataTop10;
    }

    // voorbeeld java fx simulatie
    private ObservableList<XYChart.Series<String, Double>> getChartData() {
        Double javaValue = 17.56;
        Double cValue = 12.43;
        Double cppValue = 11.11;

        ObservableList<XYChart.Series<String, Double>> data = FXCollections.observableArrayList();

        XYChart.Series<String, Double> java = new XYChart.Series<>();
        XYChart.Series<String, Double> c = new XYChart.Series<>();
        XYChart.Series<String, Double> cpp = new XYChart.Series<>();

        java.setName("Java");
        c.setName("C");
        cpp.setName("Cpp");

        for (int i = 2011; i < 2021; i++) {
            java.getData().add(new XYChart.Data<>(Integer.toString(i), javaValue));
            javaValue = javaValue + 4 * Math.random() - 0.2;

            c.getData().add(new XYChart.Data<>(Integer.toString(i), cValue));
            cValue = cValue + 4 * Math.random() - 0.2;

            cpp.getData().add(new XYChart.Data<>(Integer.toString(i), cppValue));
            cppValue = cppValue + 4 * Math.random() - 0.2;
        }

        data.addAll(java, c, cpp);
        return data;
    }

}