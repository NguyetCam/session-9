package session9lab1;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;

import java.io.IOException;

public class addcontactController {
    public TextField txtName,txtPhone;
    public Text noti;

    public void submit(){
        try {
            if(txtName.getText().isEmpty() || txtPhone.getText().isEmpty()){
                throw new Exception("Please fill all the fields");
            }
            for(contact ct:Main.phoneList){
                if(ct.getName().equals(txtName.getText())){
                    for(String s:ct.phonenumber){
                        if(s.equals(txtPhone.getText())){
                            this.noti.setText("This contact has already existed");
                            this.noti.setFill(Paint.valueOf("RED"));
                            this.noti.setVisible(true);
                            return;
                        }
                    }
                    ct.phonenumber.add(txtPhone.getText());
                    this.noti.setText("New phone number has been added");
                    this.noti.setFill(Paint.valueOf("BLUE"));
                    this.noti.setVisible(true);
                    return;
                }
            }
            Main.phoneList.add(new contact(txtName.getText(),txtPhone.getText()));
            this.noti.setText("New contact has been added");
            this.noti.setFill(Paint.valueOf("BLUE"));
            this.noti.setVisible(true);
        }catch (Exception e){
            noti.setText(e.getMessage());
            noti.setVisible(true);
            noti.setFill(Paint.valueOf("RED"));
        }
    }

    public void listScreen() throws IOException {
        Parent root = FXMLLoader.load((getClass().getResource("phonelist.fxml")));
        Main.rootStage.setScene(new Scene(root,600,750));
    }
}
