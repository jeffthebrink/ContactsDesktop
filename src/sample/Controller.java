package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import javax.xml.soap.Text;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    ObservableList<Contact> contactList = FXCollections.observableArrayList();


    @FXML
    ListView list;

    @FXML
    TextField name;

    @FXML
    TextField phone;

    @FXML
    TextField email;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list.setItems(contactList);
        name.setText("name");
        phone.setText("phone number");
        email.setText("email address");

    }

    public void addContact() {
        Contact newContact = new Contact(name.getText(), phone.getText(), email.getText());
        if (!name.getText().equals("name")) {
            if (!(name.getText().isEmpty())) {
                if (!(phone.getText().isEmpty())) {
                    if (!(email.getText().isEmpty())) {
                        contactList.add(newContact);
                        name.clear();
                        phone.clear();
                        email.clear();
                    }
                }
            }
        }
    }

    public void removeContact() {
        Contact newContact = (Contact) list.getSelectionModel().getSelectedItem();
        contactList.remove(newContact);

    }

    public void onKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            addContact();
        }
    }

}
