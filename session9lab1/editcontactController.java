package session9lab1;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;

import java.io.IOException;

public class editcontactController {
    public TextField txtName;
    public TextArea txtPhone;
    public Text noti;
    public contact contact;

    public void setData(contact contact){
        this.contact = contact;
        txtName.setText(this.contact.getName());
        txtPhone.setText(this.contact.getPhonenumber());
    }

    public void submit(){
        try {
            if(txtName.getText().isEmpty() || txtPhone.getText().isEmpty()){
                throw new Exception("Please fill all the fields");
            }
            contact ct = new contact(txtName.getText(),txtPhone.getText());
            int i = Main.phoneList.indexOf(this.contact);
            Main.phoneList.set(i,ct);
            this.noti.setVisible(true);
            this.noti.setFill(Paint.valueOf("BLUE"));
            this.noti.setText("Edit successful");
        }catch (Exception e){
            this.noti.setVisible(true);
            this.noti.setFill(Paint.valueOf("RED"));
            this.noti.setText(e.getMessage());
        }

    }

    public void listScreen() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("phonelist.fxml"));
        Main.rootStage.setScene(new Scene(root,600,750));
    }
}
