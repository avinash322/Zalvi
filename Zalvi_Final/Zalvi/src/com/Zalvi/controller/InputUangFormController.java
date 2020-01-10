/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Zalvi.controller;

import com.Zalvi.dao.UserDao;
import com.Zalvi.entity.User;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class InputUangFormController implements Initializable {

    @FXML
    private AnchorPane rootI;
    @FXML
    private TextField txt5;
    @FXML
    private TextField txt100;
    @FXML
    private TextField txt50;
    @FXML
    private TextField txt20;
    @FXML
    private TextField txt10;
    @FXML
    private Button Submit;
    UserDao userDao;
    ObservableList<User> users;
    private javafx.scene.control.Button closeButton;



    @Override
    public void initialize(URL url, ResourceBundle rb) {
         try {
            getUserDao();
            getUsers();
        } catch (SQLException ex) {
            Logger.getLogger(InputUangFormController.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    
    }    

    @FXML
    private void OnSubmit(ActionEvent event) {
          int total = 0;
        total += Integer.valueOf(0 + txt100.getText()) * 100000;
        total += Integer.valueOf(0 + txt50.getText()) * 50000;
        total += Integer.valueOf(0 + txt20.getText()) * 20000;
        total += Integer.valueOf(0 + txt10.getText()) * 10000;
        total += Integer.valueOf(0 + txt5.getText()) * 5000;
        User newUser = new User();
        newUser.setIdUser(users.get(users.size() - 1).getIdUser());
        newUser.setNama(users.get(users.size() - 1).getNama());
        newUser.setMoney(users.get(users.size() - 1).getMoney() + total);
        userDao.updatedData(newUser);
        Stage stage = (Stage) Submit.getScene().getWindow();
        stage.close();
        
    }
    
    public UserDao getUserDao() {
        if (userDao == null) {
            userDao = new UserDao();
        }
        return userDao;
    }

    public ObservableList<User> getUsers() throws SQLException {
        if (users == null) {
            users = FXCollections.observableArrayList();
            users.addAll(getUserDao().GetAllData());
        }
        return users;
    }

    void setinputUangController(MainFormController aThis) {
    }
    
}
