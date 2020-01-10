/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Zalvi.controller;

import com.Zalvi.dao.ItemDao;
import com.Zalvi.dao.TransaksiDao;
import com.Zalvi.entity.Item;
import com.Zalvi.entity.Transaksi;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;


public class BarangFormController implements Initializable {

    @FXML
    private Button update;
    @FXML
    private TextField txtID;
    @FXML
    private TextField txtnama;
    @FXML
    private TextField txtQty;
     @FXML
    private TextField txtHarga;
    @FXML
    private ComboBox<String> print;
    @FXML
    private TableView<Item> tabelBarang;
    @FXML
    private TableColumn<Item, String> colID;
    @FXML
    private TableColumn<Item, String> colNama;
    @FXML
    private TableColumn<Item, String> colHarga;
    @FXML
    private TableColumn<Item, String> colQty;
    private Item selectedItem;

    TransaksiDao transaksiDao;
    ItemDao itemDao;
    ObservableList<Transaksi> transaksis;
    ObservableList<Item> items;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         try {
            getTransaksis();
            getTransaksiDao();
        } catch (SQLException ex) {
            Logger.getLogger(MainFormController.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        refreshTable();

    }
        
    
       

    @FXML
    private void OnUpdate(ActionEvent event) {
        Item newItem = new Item();
        newItem.setIdItem(Integer.valueOf(txtID.getText()));
        newItem.setNama(txtnama.getText());
        newItem.setHarga(Integer.valueOf(txtHarga.getText()));
        newItem.setStock(Integer.valueOf(txtQty.getText()));
        newItem.setUrutan(items.get(Integer.valueOf(txtID.getText())).
                getUrutan());

        itemDao.updatedData(newItem);
        txtID.clear();
        txtHarga.clear();
        txtnama.clear();
        txtQty.clear();
        items = null;
        try {
            getItems();
        } catch (SQLException ex) {
            Logger.getLogger(BarangFormController.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        refreshTable();
        tabelBarang.refresh();
    }
    
    
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

    private void refreshTable() {
         getItemDao();
        try {
            getItems();
        } catch (SQLException ex) {
            Logger.getLogger(BarangFormController.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        tabelBarang.setItems(items);
        colID.setCellValueFactory((data) -> {
            Item item = (Item) data.getValue();
            return new SimpleStringProperty(String.valueOf(item.getIdItem()));
        });
        colNama.setCellValueFactory((data) -> {
            Item item = (Item) data.getValue();
            return new SimpleStringProperty(item.getNama());
        });

        colHarga.setCellValueFactory(new PropertyValueFactory<>("harga"));
        colQty.setCellValueFactory((data) -> {
            Item item = (Item) data.getValue();
            return new SimpleStringProperty(String.valueOf(item.
                    getStock()));
        });
    }
    
     @FXML
    private void tableclicked(MouseEvent event) {
        selectedItem = tabelBarang.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            selectedItem.getIdItem();
            txtnama.setText(selectedItem.getNama());
            txtID.setText(String.valueOf(selectedItem.getIdItem()));
            txtHarga.setText(String.valueOf(selectedItem.getHarga()));
            txtQty.setText(String.valueOf(selectedItem.getStock()));
        }
    }

    

}