package session9lab1;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import java.util.ArrayList;
import java.util.Objects;

public class contact {
    public String name;
    public ArrayList<String> phonenumber = new ArrayList<String>();
    public Button edit,remove;

    public contact(String name, String phonenumber) {
        this.name = name;
        this.phonenumber.add(phonenumber);
        this.edit = new Button("Edit");
        this.edit.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("editcontact.fxml"));
                Parent root = loader.load();
                editcontactController a = loader.getController();
                a.setData(this);
                Main.rootStage.setScene(new Scene(root,400,500));
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        });
        this.remove = new Button("Remove");
        this.remove.setOnAction(event -> {
            Main.phoneList.remove(this);
        });
    }

    public Button getEdit() {
        return edit;
    }

    public void setEdit(Button edit) {
        this.edit = edit;
    }

    public Button getRemove() {
        return remove;
    }

    public void setRemove(Button remove) {
        this.remove = remove;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenumber() {
        String s = "";
        for(String s1:phonenumber){
            s+=s1+ "\n";
        }
        return s;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber.add(phonenumber);
    }
}
