/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Zalvi.controller;

import com.Zalvi.dao.ItemDao;
import com.Zalvi.dao.TransaksiDao;
import com.Zalvi.dao.UserDao;
import com.Zalvi.entity.Item;
import com.Zalvi.entity.Transaksi;
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
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class KembalianFormController implements Initializable {

    @FXML
    private Label txthargatotal;
    @FXML
    private Label txt50;
    @FXML
    private Label txt100;
    @FXML
    private Label txt20;
    @FXML
    private Label txt10;
    @FXML
    private Label txt5;
    @FXML
    private Label txtkembalian;
    @FXML
    private Button Submit;
    UserDao userDao;
    ObservableList<User> users;
    TransaksiDao transaksiDao;
    ObservableList<Transaksi> transaksis;
    ItemDao itemDao;
    ObservableList<Item> items;
    
    
    public TransaksiDao getTransaksiDao() {
        if (transaksiDao == null) {
            transaksiDao = new TransaksiDao();
        }
        return transaksiDao;
    }

    public ObservableList<Transaksi> getTransaksis() throws SQLException {
        if (transaksis == null) {
            transaksis = FXCollections.observableArrayList();
            transaksis.addAll(getTransaksiDao().GetAllData());
        }
        return transaksis;
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

    public ItemDao getItemDao() {
        if (itemDao == null) {
            itemDao = new ItemDao();
        }
        return itemDao;
    }

    public ObservableList<Item> getItems() throws SQLException {
        if (items == null) {
            items = FXCollections.observableArrayList();
            items.addAll(getItemDao().GetAllData());
        }
        return items;
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         try {
            getTransaksiDao();
            getTransaksis();
            getUserDao();
            getUsers();
            getItemDao();
            getItems();
        } catch (SQLException ex) {
            Logger.getLogger(KembalianFormController.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
         
        Transaksi lastTransaksi = transaksis.get(transaksis.size() - 1);
        int kembalian = users.get(users.size() - 1).getMoney();
        txtkembalian.setText(String.valueOf(kembalian));
        Item lastitem = items.get(lastTransaksi.getItem().getIdItem() - 1);
        txthargatotal.setText(String.valueOf(lastitem.getHarga()));
        int lembar100k=0;
        int lembar50k = 0;
        int lembar20k = 0;
        int lembar10k = 0;
        int lembar5k = 0;
        int sisa0 = 0;
        int sisa1 = 0;
        int sisa2 = 0;
        int sisa3 = 0;
        int sisa4 = 0;
        lembar100k = kembalian / 100000;
        sisa0 = kembalian - lembar100k * 100000;
        lembar50k = kembalian / 50000;
        sisa1 = kembalian - lembar50k * 50000;
        lembar20k = sisa1 / 20000;
        sisa2 = sisa1 - lembar20k * 20000;
        lembar10k = sisa2 / 10000;
        sisa3 = sisa2 - lembar10k * 10000;
        lembar5k = sisa3 / 5000;
        sisa3 = kembalian - lembar5k * 5000;
        txt100.setText(String.valueOf(lembar100k));
        txt50.setText(String.valueOf(lembar50k));
        txt20.setText(String.valueOf(lembar20k));
        txt10.setText(String.valueOf(lembar10k));
        txt5.setText(String.valueOf(lembar5k));
    }    

    @FXML
    private void OnSubmit(ActionEvent event) {
        Stage stage = (Stage) Submit.getScene().getWindow();
        stage.close();
    }

    void setKembalianController(MainFormController aThis) {
    }
    
}
