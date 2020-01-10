/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Zalvi.controller;

import com.Zalvi.Main;
import com.Zalvi.controller.OutputBarangFormController;
import com.Zalvi.dao.ItemDao;
import com.Zalvi.dao.TransaksiDao;
import com.Zalvi.dao.UserDao;
import com.Zalvi.entity.Item;
import com.Zalvi.entity.Transaksi;
import com.Zalvi.entity.User;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class MainFormController implements Initializable {

    @FXML
    private BorderPane root;
    @FXML
    private Label Qty1;
    @FXML
    private ImageView img1;
    @FXML
    private RadioButton Barang1;
    @FXML
    private ToggleGroup a;
    @FXML
    private Label lblHarga1;
    @FXML
    private Button arrowleft;
    @FXML
    private Button arrowright;
    @FXML
    private Label Qty3;
    @FXML
    private ImageView img3;
    @FXML
    private RadioButton Barang3;
    @FXML
    private Label lblHarga3;
    @FXML
    private Label Qty4;
    @FXML
    private ImageView img4;
    @FXML
    private RadioButton Barang4;
    @FXML
    private Label lblHarga4;
    @FXML
    private Label Qty2;
    @FXML
    private ImageView img2;
    @FXML
    private RadioButton Barang2;
    @FXML
    private Label lblHarga2;
    @FXML
    private Label Qty5;
    @FXML
    private ImageView img5;
    @FXML
    private RadioButton Barang5;
    @FXML
    private Label lblHarga5;
    @FXML
    private Label Qty6;
    @FXML
    private ImageView img6;
    @FXML
    private RadioButton Barang6;
    @FXML
    private Label lblHarga6;
    @FXML
    private Label Qty7;
    @FXML
    private ImageView img7;
    @FXML
    private RadioButton Barang7;
    @FXML
    private Label lblHarga7;
    @FXML
    private Label Qty8;
    @FXML
    private ImageView img8;
    @FXML
    private RadioButton Barang8;
    @FXML
    private Label lblHarga8;
    @FXML
    private Label Qty9;
    @FXML
    private ImageView img9;
    @FXML
    private RadioButton Barang9;
    @FXML
    private Label lblHarga9;
    @FXML
    private Label Qty10;
    @FXML
    private ImageView img10;
    @FXML
    private RadioButton Barang10;
    @FXML
    private Label lblHarga10;
    @FXML
    private Label Qty11;
    @FXML
    private ImageView img11;
    @FXML
    private RadioButton Barang11;
    @FXML
    private Label lblHarga11;
    @FXML
    private Label Qty12;
    @FXML
    private ImageView img12;
    @FXML
    private RadioButton Barang12;
    @FXML
    private Label lblHarga12;
    @FXML
    private Label jumlahuang;
    @FXML
    private Button inputuang;
    @FXML
    private Button submit;
    @FXML
    private Button change;
    @FXML
    private Button ambilbarang;
    @FXML
    private ImageView admin;
     UserDao userDao;
    ObservableList<User> users;
    ItemDao itemDao;
    ObservableList<Item> items;
    TransaksiDao transaksiDao;
    ObservableList<Transaksi> transaksis;
    static Item tes;
    private Stage inputStage;
    private Stage outputStage;
    private Stage AdminLoginStage;
    private Stage PushClickedStage;

    /**
     * Initializes the controller class.
     */
   @Override
    public void initialize(URL url, ResourceBundle rb) {
         try {
            getTransaksis();
            getTransaksiDao();
            getUserDao();
            getUsers();
            getItemDao();
            getItems();
        } catch (SQLException ex) {
            Logger.getLogger(com.Zalvi.controller.MainFormController.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        CheckStok1();
        jumlahuang.setText(String.valueOf(users.get(users.size() - 1).getMoney()));
        OnLeft(null);
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
public void CheckStok1() {
        if (items.get(0).getStock() == 0) {
            Barang1.setDisable(true);
        } else {
            Barang1.setDisable(false);
        }
        if (items.get(1).getStock() == 0) {
            Barang2.setDisable(true);
        } else {
            Barang2.setDisable(false);
        }
        if (items.get(2).getStock() == 0) {
            Barang3.setDisable(true);
        } else {
            Barang3.setDisable(false);
        }
        if (items.get(3).getStock() == 0) {
            Barang4.setDisable(true);
        } else {
            Barang4.setDisable(false);
        }
        if (items.get(4).getStock() == 0) {
            Barang5.setDisable(true);
        } else {
            Barang5.setDisable(false);
        }
        if (items.get(5).getStock() == 0) {
            Barang6.setDisable(true);
        } else {
            Barang6.setDisable(false);
        }
        if (items.get(6).getStock() == 0) {
            Barang7.setDisable(true);
        } else {
            Barang7.setDisable(false);
        }
        if (items.get(7).getStock() == 0) {
            Barang8.setDisable(true);
        } else {
            Barang8.setDisable(false);
        }
        if (items.get(8).getStock() == 0) {
            Barang9.setDisable(true);
        } else {
            Barang9.setDisable(false);
        }
        if (items.get(9).getStock() == 0) {
            Barang10.setDisable(true);
        } else {
            Barang10.setDisable(false);
        }
        if (items.get(10).getStock() == 0) {
            Barang11.setDisable(true);
        } else {
            Barang11.setDisable(false);
        }
        if (items.get(11).getStock() == 0) {
            Barang12.setDisable(true);
        } else {
            Barang12.setDisable(false);
        }
    }
     public void CheckStok2() {
        if (items.get(12).getStock() == 0) {
            Barang1.setDisable(true);
        } else {
            Barang1.setDisable(false);
        }
        if (items.get(13).getStock() == 0) {
            Barang2.setDisable(true);
        } else {
            Barang2.setDisable(false);
        }
        if (items.get(14).getStock() == 0) {
            Barang3.setDisable(true);
        } else {
            Barang3.setDisable(false);
        }
        if (items.get(15).getStock() == 0) {
            Barang4.setDisable(true);
        } else {
            Barang4.setDisable(false);
        }
        if (items.get(16).getStock() == 0) {
            Barang5.setDisable(true);
        } else {
            Barang5.setDisable(false);
        }
        if (items.get(17).getStock() == 0) {
            Barang6.setDisable(true);
        } else {
            Barang6.setDisable(false);
        }
        if (items.get(18).getStock() == 0) {
            Barang7.setDisable(true);
        } else {
            Barang7.setDisable(false);
        }
        if (items.get(19).getStock() == 0) {
            Barang8.setDisable(true);
        } else {
            Barang8.setDisable(false);
        }
        if (items.get(20).getStock() == 0) {
            Barang9.setDisable(true);
        } else {
            Barang9.setDisable(false);
        }
        if (items.get(21).getStock() == 0) {
            Barang10.setDisable(true);
        } else {
            Barang10.setDisable(false);
        }
        if (items.get(22).getStock() == 0) {
            Barang11.setDisable(true);
        } else {
            Barang11.setDisable(false);
        }
        if (items.get(23).getStock() == 0) {
            Barang12.setDisable(true);
        } else {
            Barang12.setDisable(false);
        }
     }
     
     
     public Item getChosen1() {
        if (Barang1.isSelected() == true) {
            tes = items.get(0);
        } else if (Barang2.isSelected() == true) {
            tes = items.get(1);
        } else if (Barang3.isSelected() == true) {
            tes = items.get(2);
        } else if (Barang4.isSelected() == true) {
            tes = items.get(3);
        } else if (Barang5.isSelected() == true) {
            tes = items.get(4);
        } else if (Barang6.isSelected() == true) {
            tes = items.get(5);
        } else if (Barang7.isSelected() == true) {
            tes = items.get(6);
        } else if (Barang8.isSelected() == true) {
            tes = items.get(7);
        } else if (Barang9.isSelected() == true) {
            tes = items.get(8);
        } else if (Barang10.isSelected() == true) {
            tes = items.get(9);
        } else if (Barang11.isSelected() == true) {
            tes = items.get(10);
        } else if (Barang12.isSelected() == true) {
            tes = items.get(11);
        }
        return tes;
    }

    public Item getChosen2() {
        if (Barang1.isSelected() == true) {
            tes = items.get(12);
        } else if (Barang2.isSelected() == true) {
            tes = items.get(13);
        } else if (Barang3.isSelected() == true) {
            tes = items.get(14);
        } else if (Barang4.isSelected() == true) {
            tes = items.get(15);
        } else if (Barang5.isSelected() == true) {
            tes = items.get(16);
        } else if (Barang6.isSelected() == true) {
            tes = items.get(17);
        } else if (Barang7.isSelected() == true) {
            tes = items.get(18);
        } else if (Barang8.isSelected() == true) {
            tes = items.get(19);
        } else if (Barang9.isSelected() == true) {
            tes = items.get(20);
        } else if (Barang10.isSelected() == true) {
            tes = items.get(21);
        } else if (Barang11.isSelected() == true) {
            tes = items.get(22);
        } else if (Barang12.isSelected() == true) {
            tes = items.get(23);
        }
        return tes;
    }

    @FXML
    private void OnLeft(ActionEvent event) {
         arrowleft.setDisable(true);
        arrowright.setDisable(false);

        img1.setImage(new Image("images/1.jpg"));

        Qty1.setText(String.valueOf(items.get(0).getStock()));
        lblHarga1.setText(String.valueOf(items.get(0).getHarga()) + ",-");

        img2.setImage(new Image("images/2.jpg"));
        Qty2.setText(String.valueOf(items.get(1).getStock()));
        lblHarga2.setText(String.valueOf(items.get(1).getHarga()) + ",-");

        img3.setImage(new Image("images/3.jpg"));
        Qty3.setText(String.valueOf(items.get(2).getStock()));
        lblHarga3.setText(String.valueOf(items.get(2).getHarga()) + ",-");

        img4.setImage(new Image("images/4.jpg"));
        Qty4.setText(String.valueOf(items.get(3).getStock()));
        lblHarga4.setText(String.valueOf(items.get(3).getHarga()) + ",-");

        img5.setImage(new Image("images/5.jpg"));
        Qty5.setText(String.valueOf(items.get(4).getStock()));
        lblHarga5.setText(String.valueOf(items.get(4).getHarga()) + ",-");

        img6.setImage(new Image("images/6.jpg"));
        Qty6.setText(String.valueOf(items.get(5).getStock()));
        lblHarga6.setText(String.valueOf(items.get(5).getHarga()) + ",-");

        img7.setImage(new Image("images/7.jpg"));
        Qty7.setText(String.valueOf(items.get(6).getStock()));
        lblHarga7.setText(String.valueOf(items.get(6).getHarga()) + ",-");

        img8.setImage(new Image("images/8.jpg"));
        Qty8.setText(String.valueOf(items.get(7).getStock()));
        lblHarga8.setText(String.valueOf(items.get(7).getHarga()) + ",-");

        img9.setImage(new Image("images/9.jpg"));
        Qty9.setText(String.valueOf(items.get(8).getStock()));
        lblHarga9.setText(String.valueOf(items.get(8).getHarga()) + ",-");

        img10.setImage(new Image("images/10.jpg"));
        Qty10.setText(String.valueOf(items.get(9).getStock()));
        lblHarga10.setText(String.valueOf(items.get(9).getHarga()) + ",-");

        img11.setImage(new Image("images/11.jpg"));
        Qty11.setText(String.valueOf(items.get(10).getStock()));
        lblHarga11.setText(String.valueOf(items.get(10).getHarga()) + ",-");

        img12.setImage(new Image("images/12.jpg"));
        Qty12.setText(String.valueOf(items.get(11).getStock()));
        lblHarga12.setText(String.valueOf(items.get(11).getHarga()) + ",-");

        CheckStok1();
    }

    @FXML
    private void OnRight(ActionEvent event) {
         arrowright.setDisable(true);
        arrowleft.setDisable(false);

        img1.setImage(new Image("images/13.jpg"));
        Qty1.setText(String.valueOf(items.get(12).getStock()));
        lblHarga1.setText(String.valueOf(items.get(12).getHarga()) + ",-");

        img2.setImage(new Image("images/14.jpg"));
        Qty2.setText(String.valueOf(items.get(13).getStock()));
        lblHarga2.setText(String.valueOf(items.get(13).getHarga()) + ",-");

        img3.setImage(new Image("images/15.jpg"));
        Qty3.setText(String.valueOf(items.get(14).getStock()));
        lblHarga3.setText(String.valueOf(items.get(14).getHarga()) + ",-");

        img4.setImage(new Image("images/16.jpg"));
        Qty4.setText(String.valueOf(items.get(15).getStock()));
        lblHarga4.setText(String.valueOf(items.get(15).getHarga()) + ",-");

        img5.setImage(new Image("images/17.jpg"));
        Qty5.setText(String.valueOf(items.get(16).getStock()));
        lblHarga5.setText(String.valueOf(items.get(16).getHarga()) + ",-");

        img6.setImage(new Image("images/18.jpg"));
        Qty6.setText(String.valueOf(items.get(17).getStock()));
        lblHarga6.setText(String.valueOf(items.get(17).getHarga()) + ",-");

        img7.setImage(new Image("images/19.jpg"));
        Qty7.setText(String.valueOf(items.get(18).getStock()));
        lblHarga7.setText(String.valueOf(items.get(18).getHarga()) + ",-");

        img8.setImage(new Image("images/20.jpg"));
        Qty8.setText(String.valueOf(items.get(19).getStock()));
        lblHarga8.setText(String.valueOf(items.get(19).getHarga()) + ",-");

        img9.setImage(new Image("images/21.jpg"));
        Qty9.setText(String.valueOf(items.get(20).getStock()));
        lblHarga9.setText(String.valueOf(items.get(20).getHarga()) + ",-");

        img10.setImage(new Image("images/22.jpg"));
        Qty10.setText(String.valueOf(items.get(21).getStock()));
        lblHarga10.setText(String.valueOf(items.get(21).getHarga()) + ",-");

        img11.setImage(new Image("images/23.jpg"));
        Qty11.setText(String.valueOf(items.get(22).getStock()));
        lblHarga11.setText(String.valueOf(items.get(22).getHarga()) + ",-");

        img12.setImage(new Image("images/24.jpg"));
        Qty12.setText(String.valueOf(items.get(23).getStock()));
        lblHarga12.setText(String.valueOf(items.get(23).getHarga()) + ",-");
        CheckStok2();
    }

    @FXML
    private void RefreshAction(ActionEvent event) {
         users = null;
        items = null;
        try {
            getItems();
            getUsers();
        } catch (SQLException ex) {
            Logger.getLogger(com.Zalvi.controller.MainFormController.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        jumlahuang.setText(String.valueOf(users.get(users.size() - 1).getMoney()));
         if (arrowleft.isDisable() == true) {
            OnLeft(event);
            CheckStok1();
        } else if (arrowright.isDisable() == true) {
            OnRight(event);
            CheckStok2();
        }
    }

    @FXML
    private void OnInsertMoney(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/com/Zalvi/view/InputUangForm.fxml"));
            AnchorPane pane = loader.load();
            InputUangFormController controller = loader.getController();
            controller.setinputUangController(this);

            Scene scene = new Scene(pane);
            inputStage = new Stage();
            inputStage.setScene(scene);
            inputStage.setTitle("input uang");
            inputStage.initModality(Modality.APPLICATION_MODAL);

        } catch (Exception e) {
            e.printStackTrace();
        }
        inputStage.show();
    }

    @FXML
    private void submit(ActionEvent event) {
          if (arrowleft.isDisable() == true) {
            getChosen1();
        } else if (arrowright.isDisable() == true) {
            getChosen2();
        }
        if (users.get(users.size() - 1).getMoney() > tes.getHarga()) {
            User newUser = users.get(users.size() - 1);
            newUser.setMoney(newUser.getMoney() - tes.getHarga());
            userDao.updatedData(newUser);
            Item newItem = tes;
            newItem.setStock(newItem.getStock() - 1);
            itemDao.updatedData(newItem);
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            Transaksi newTransaksi = new Transaksi(newItem, users.get(users.
                    size()- 1), date, newItem.getNama());
            transaksiDao.addData(newTransaksi);
            submit.setDisable(true);
            if (arrowleft.isDisable() == true) {
                CheckStok1();
            } else if (arrowright.isDisable() == true) {
                CheckStok2();
            }
        } else {
            OnInsertMoney(event);
        }
        if (arrowleft.isDisable() == true) {
            OnLeft(event);
            CheckStok1();
        } else if (arrowright.isDisable() == true) {
            OnRight(event);
            CheckStok2();
        }

    }

    @FXML
    private void OnChange(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/com/Zalvi/view/KembalianForm.fxml"));
            AnchorPane pane = loader.load();
            KembalianFormController controller = loader.getController();
            controller.setKembalianController(this);
            Scene scene = new Scene(pane);
            outputStage = new Stage();
            outputStage.setScene(scene);
            outputStage.setTitle("Kembalian ");
            outputStage.initModality(Modality.APPLICATION_MODAL);


        } catch (Exception e) {
            e.printStackTrace();
        }
        outputStage.show();
        jumlahuang.setText(String.valueOf("0"));

    }

  

    @FXML
    private void OnBarang(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/com/Zalvi/view/OutputBarangForm.fxml"));
            AnchorPane pane = loader.load();
            OutputBarangFormController controller = loader.getController();
            controller.setOutputBarangFormController(this);
            Scene scene = new Scene(pane);
            PushClickedStage = new Stage();
            PushClickedStage.setScene(scene);
            PushClickedStage.setTitle("Output Barang");
            PushClickedStage.initModality(Modality.APPLICATION_MODAL);


        } catch (Exception e) {
            e.printStackTrace();
        }
        PushClickedStage.show();
    }

    @FXML
    private void OnAdmin(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/com/Zalvi/view/AdminLogin.fxml"));
            BorderPane pane = loader.load();
            AdminLoginController controller = loader.getController();
            controller.setAdminLoginController(this);
            Scene scene = new Scene(pane);
            AdminLoginStage = new Stage();
            AdminLoginStage.setScene(scene);
            AdminLoginStage.setTitle("Login Admin");
            AdminLoginStage.initModality(Modality.APPLICATION_MODAL);
        } catch (Exception e) {
            e.printStackTrace();
        }
        AdminLoginStage.show();
    }
    
}
