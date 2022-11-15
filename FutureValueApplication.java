package com.example.futurevaluecalculator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.NumberFormat;

public class FutureValueApplication extends Application {
    //Textfields are declared outside of the start method
    // so the calculateButtonClicked() method can update them
    private TextField investmentField;
    private TextField interestRateField;
    private TextField yearsField;
    private TextField futureValueField;


    public void start(Stage primarystage) throws IOException {
        // set stage title
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Future Value Calculator");

        // create grid, create scene, and add grid to scene
        GridPane grid = new GridPane();

        //Most applications use one or more labels to display text that identifies the other controls in the GUI.
        // In JavaFX, you use the Label class to create a label.
        grid.add(new Label("Monthly Investment:"), 0, 0);
        grid.add(new Label("Yearly Interest Rate:"), 0, 1);
        grid.add(new Label("Years:"), 0, 2);
        grid.add(new Label("Future Value:"), 0, 3);

        //Set the alignment and add padding around the GUI widgets
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setPadding(new Insets(25, 25, 25, 25));

        //Add the text fields
        investmentField = new TextField();
        grid.add(investmentField, 1, 0);
        interestRateField = new TextField();
        grid.add(interestRateField, 1, 1);
        yearsField = new TextField();
        grid.add(yearsField, 1, 2);
        futureValueField = new TextField();
        futureValueField.setEditable(false);
        grid.add(futureValueField, 1, 3);

        // create two buttons
        Button calculateButton = new Button("Calculate");
        calculateButton.setOnAction(event -> calculateButtonClicked());
        Button exitButton = new Button("Exit");
        exitButton.setOnAction(event -> exitButtonClicked());

        // create a horizontal box and add the buttons to it
        HBox buttonBox = new HBox(10);
        buttonBox.getChildren().add(calculateButton);
        buttonBox.getChildren().add(exitButton);
        buttonBox.setAlignment(Pos.BOTTOM_RIGHT);

        // add the box to row 5, spanning 2 columns and 1 row
        grid.add(buttonBox, 0, 4, 2, 1);


        //Create the scene
        Scene scene = new Scene(grid, 500, 200);

        // set scene and display primarystage
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        // start the application by calling its static launch() method
        launch(args);
    }

    private void calculateButtonClicked() {
        // get data from text field
        double investment = Double.parseDouble(investmentField.getText());
        double rate = Double.parseDouble(interestRateField.getText());
        int years = Integer.parseInt(yearsField.getText());

        // calculate future value
        //Simple interest rate: Future value = investment amount x (1 + (interest rate x length of investment)
        double futureValue = investment * (1 + (rate * years));

        // set data in read-only text field
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        futureValueField.setText(currency.format(futureValue));
    }

    private void exitButtonClicked() {
        System.exit(0);    // 0 indicates a normal exit
    }

}//end class