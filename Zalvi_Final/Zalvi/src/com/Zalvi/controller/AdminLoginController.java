/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Zalvi.controller;

import com.Zalvi.Main;
import com.Zalvi.controller.MainFormController;
import com.Zalvi.dao.UserDao;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class AdminLoginController  {
    @FXML
    private ImageView Home;
    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Button Submit;
    private UserDao userDao;
    private Stage mainstage;
    public BorderPane rootG;
    private Stage AdminLoginStage;




        @FXML
    private void onSubmit(ActionEvent actionEvent) {
        if(txtUsername.getText().equals ("admin")&&txtPassword.getText().equals("12345")){
            try{

                Parent root = FXMLLoader.load(getClass().getResource("/com/Zalvi/view/BarangForm.fxml"));
                Stage mainStage = new Stage();
                mainStage.setTitle("Barang Form");
                mainStage.setScene(new Scene(root));
                mainStage.show();
                ((Stage)rootG.getScene().getWindow()).close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("error");
            alert.setContentText("Password/username yang anda masukan salah");
            alert.show();
        }

    }


    public void setAdminLoginController(MainFormController mainFormController) {
    }
}
