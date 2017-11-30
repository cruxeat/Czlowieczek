package sample;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    Stage okno;
    TableView<Czlowieczek> stół;
    TextField nameInput,surnameInput, idInput, ageInput, highInput;


    @Override
    public void start(Stage primaryStage) throws Exception {

        okno = primaryStage;
        okno.setTitle("Hello World");

        //Name Column
        TableColumn<Czlowieczek, String> nameColumn = new TableColumn<>("Imię");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<Czlowieczek, String>("Imie"));
        //Surname Column
        TableColumn<Czlowieczek, String> surnameColumn = new TableColumn<>("Nazwisko");
        surnameColumn.setMinWidth(200);
        surnameColumn.setCellValueFactory(new PropertyValueFactory<Czlowieczek, String>("Nazwisko"));
        //Id Column
        TableColumn<Czlowieczek, String> idColumn = new TableColumn<>("Pesel");
        idColumn.setMinWidth(200);
        idColumn.setCellValueFactory(new PropertyValueFactory<Czlowieczek, String>("Pesel"));
        //Age Column
        TableColumn<Czlowieczek, String> ageColumn = new TableColumn<>("Wiek");
        ageColumn.setMinWidth(200);
        ageColumn.setCellValueFactory(new PropertyValueFactory<Czlowieczek, String>("Wiek"));
        //High Column
        TableColumn<Czlowieczek, String> highColumn = new TableColumn<>("Wzrost");
        highColumn.setMinWidth(200);
        highColumn.setCellValueFactory(new PropertyValueFactory<Czlowieczek, String>("Wzrost"));


        //Name Input
        nameInput =  new TextField();
        nameInput.setPromptText("Imię");
        nameInput.setMinWidth(100);
        //Surname Input
        surnameInput =  new TextField();
        surnameInput.setPromptText("Nazwiwsko");
        surnameInput.setMinWidth(100);
        //Id Input
        idInput =  new TextField();
        idInput.setPromptText("Pesel");
        idInput.setMinWidth(100);
        //Age Input
        ageInput =  new TextField();
        ageInput.setPromptText("Wiek");
        ageInput.setMinWidth(100);
        //High Input
        highInput =  new TextField();
        highInput.setPromptText("Wzrost");
        highInput.setMinWidth(100);


        //Buttons

        Button addButton = new Button("Add");
        addButton.setOnAction(e-> addButtonClicked());
        Button deleteButton =  new Button("Delete");
        deleteButton.setOnAction(e -> deleteButtonClicked());

        //horizontal layot
        HBox hBox =  new HBox();
        hBox.setPadding(new Insets (10, 10, 10, 10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(nameInput, surnameInput, idInput, ageInput, highInput, addButton, deleteButton);


        //Stół to moja javofxowa tabelka
        stół = new TableView<>();
        stół.setItems(getCzlowieczek());
        stół.getColumns().addAll(nameColumn, surnameColumn, idColumn, ageColumn, highColumn);

        VBox vBox =  new VBox();
        vBox.getChildren().addAll(stół, hBox); //Wrzucam stół i hBoxa do layota vBoxa

        Scene scene =  new Scene(vBox);
        okno.setScene(scene);
        okno.show();

    }


    public static void main(String[] args) {
        launch(args);
    }


    public void addButtonClicked(){
        Czlowieczek czlowieczek =  new Czlowieczek();
        czlowieczek.setImie(nameInput.getText());
        czlowieczek.setNazwisko(surnameInput.getText());
        czlowieczek.setPesel(idInput.getText());
        czlowieczek.setWiek(ageInput.getText());
        //gdybysmy mieli nie Stringa tylko Integera byloby ...setWiek(Integer.parseInt(ageInput.getText())
        czlowieczek.setWzrost(highInput.getText());

        stół.getItems().add(czlowieczek);
        nameInput.clear();
        surnameInput.clear();
        idInput.clear();
        ageInput.clear();
        highInput.clear();

    }


   public void deleteButtonClicked(){
        ObservableList<Czlowieczek> czlowieczekWybrany, wszystkieCzlowieczki;
        wszystkieCzlowieczki = stół.getItems();
        czlowieczekWybrany = stół.getSelectionModel().getSelectedItems();
        czlowieczekWybrany.forEach(wszystkieCzlowieczki::remove);
   }

    //Tworzę ObservableList, zbieram grupę człowieczków, to dopiero wrzucę do JavaFX.
    public ObservableList<Czlowieczek> getCzlowieczek(){
        ObservableList<Czlowieczek> czlowieczki = FXCollections.observableArrayList();
        czlowieczki.add(new Czlowieczek ("Agnieszka", "Kulesza", "1", "2", "3"));
        czlowieczki.add(new Czlowieczek ("Nika", "Sidorowidz", "1", "2", "3"));
        czlowieczki.add(new Czlowieczek ("Kasia", "Rode", "1", "2", "3"));
        return czlowieczki;
    }


}
