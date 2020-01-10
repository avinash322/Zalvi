/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Zalvi.controller;

import com.Zalvi.dao.TransaksiDao;
import com.Zalvi.entity.Transaksi;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class OutputBarangFormController implements Initializable {

    @FXML
    private ImageView barang;
    @FXML
    private Label txtBarang;
    ObservableList<Transaksi> transaksis;
    TransaksiDao transasksiDao;
    
    public ObservableList<Transaksi> getTransaksis() {
        if (transaksis == null) {
            transaksis = FXCollections.observableArrayList();
            transaksis.addAll(getTransasksiDao().GetAllData());
        }
        return transaksis;
    }

    public TransaksiDao getTransasksiDao() {
        if (transasksiDao == null) {
            transasksiDao = new TransaksiDao();
        }
        return transasksiDao;
    }

 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       getTransasksiDao();
        getTransaksis();

        Transaksi lastTransaksi = transaksis.get(transaksis.size() - 1);
        String x = String.valueOf(lastTransaksi.getItem().getIdItem());
        barang.setImage(new Image("images/" + x + ".jpg"));
        txtBarang.setText(lastTransaksi.getNamaItem());
    }    

    void setOutputBarangFormController(MainFormController aThis) {
    }
    
}
