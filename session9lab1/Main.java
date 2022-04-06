package session9lab1;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static Stage rootStage;
    public static ObservableList<contact> phoneList = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) throws Exception{
        rootStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("phonelist.fxml"));
        primaryStage.setTitle("Session 9 lab 1");
        primaryStage.setScene(new Scene(root, 600, 750));
        primaryStage.show();
    }


    public static void main(String[] args) {
        phoneList.add(new contact("Nguyệt Cầm","0359903359"));
        launch(args);
    }
}
