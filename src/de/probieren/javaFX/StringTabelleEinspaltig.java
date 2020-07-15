package de.probieren.javaFX;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.stage.Stage;
import javafx.util.Callback;

public class StringTabelleEinspaltig extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Tabelle (setTitle)");
        TableView<String> tView = new TableView<String>();
        TableColumn<String, String> junk = new TableColumn<String, String>("Junkfood");
        TableColumn<String, String> spalte2 = new TableColumn<String, String>("Preise");

        junk.setCellValueFactory(p -> new SimpleStringProperty(p.getValue()));

//        junk.setCellValueFactory(
//                new Callback<CellDataFeatures<String, String>, ObservableValue<String>>() {
//                    public ObservableValue<String> call(
//                            CellDataFeatures<String, String> p) {
//                        return new SimpleStringProperty(p.getValue());
//                    }
//                });
//
        // alternativ Lambda-Expr.
        // junk.setCellValueFactory((p) -> {
        // return new SimpleStringProperty(p.getValue());
        // });

        tView.getColumns().add(junk);
        tView.setItems(createList());
        tView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tView.getColumns().add(spalte2);
        tView.setItems(createList2());
        Scene scene = new Scene(tView, 300, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private ObservableList<String> createList() {
        return FXCollections.observableArrayList("Schaschlik", "Currywurst",
                "Frikadelle", "Pommes", "Hummer an Salbei-Zitonen-Schaum","Hähnchen","Döner","Hamburger","Cheeseburger","Baguette",
                "Schokolade","Lakritz","allet vonner Bude: Eis, Schokoalde, Knöterich");
    }

    private ObservableList<String> createList2() {
        return FXCollections.observableArrayList("22", "11",
                "3", "4.4", "Hummer an Salbei-Zitonen-Schaum", "Hähnchen", "Döner", "Hamburger", "Cheeseburger", "Baguette",
                "Schokolade", "Lakritz", "allet vonner Bude: Eis, Schokoalde, Knöterich");
    }

    public static void main(String[] args) {
        launch(args);
    }
}