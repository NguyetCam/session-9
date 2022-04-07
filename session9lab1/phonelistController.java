package session9lab1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class phonelistController implements Initializable {
    public TableView<contact> tbView;
    public TableColumn<contact,String> cName;
    public TableColumn<contact, String> cPhone;
    public TableColumn<contact, Button> cEdit,cRemove;
    public TextField txtSearch;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cName.setCellValueFactory(new PropertyValueFactory<contact,String>("name"));
        cPhone.setCellValueFactory(new PropertyValueFactory<contact,String>("phonenumber"));
        cEdit.setCellValueFactory(new PropertyValueFactory<contact,Button>("edit"));
        cRemove.setCellValueFactory(new PropertyValueFactory<contact,Button>("remove"));
        tbView.setItems(Main.phoneList);
    }

    public void addScreen() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("addcontact.fxml"));
        Main.rootStage.setScene(new Scene(root,400,500));
    }

    public void findByName(){
        String s = txtSearch.getText();
        List<contact> kq = Main.phoneList.stream().filter(contact -> contact.getName().contains(s)).collect(Collectors.toList());
        ObservableList result = FXCollections.observableArrayList();
        result.addAll(kq);
        tbView.setItems(result);
    }
}
