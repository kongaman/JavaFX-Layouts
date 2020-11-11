package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;

import java.io.File;

public class Controller {

    private String iniDir = "D:\\";
    private String iniFileName = "";

    @FXML
    private Button btnOpen;
    @FXML
    private Button btnSaveDir;
    @FXML
    private Button btnGo;
    @FXML
    private Label lErrors;
    @FXML
    private Label lOpen;
    @FXML
    private Label lSave;
    @FXML
    private TextField tfTableName;

    @FXML
    public void handleKeyReleased(KeyEvent keyEvent) {
        if (keyEvent.getText().isBlank() || keyEvent.getCharacter().isEmpty()){
            lErrors.setText("In Feld " + keyEvent.getSource() + " muss ein numerischer Wert vorgegeben werden");
        } else {
            lErrors.setText("");
        }
    }
    @FXML
    public void onBtnClicked(ActionEvent event) {
        if (event.getSource().equals(btnOpen)){
            FileChooser fc = new FileChooser();
            fc.setInitialDirectory(new File("D:\\"));
            File f = fc.showOpenDialog(null);
            if(f != null){
                iniDir = f.getPath().substring(0, f.getPath().lastIndexOf("\\"));
                iniFileName = f.getName();
            }
            lOpen.setText((f != null) ? f.getAbsoluteFile().toString() : "");
        } else if (event.getSource().equals(btnSaveDir)){
            FileChooser fc = new FileChooser();
            fc.setInitialDirectory(new File(iniDir));
            fc.setInitialFileName(iniFileName + "-generated4u.xml");
            File f = fc.showSaveDialog(null);
            lSave.setText((f != null) ? f.getAbsoluteFile().toString() : "");
        } else if (event.getSource().equals(btnGo)){
            System.out.println("btnGo gedrückt");
        }
    }
}
