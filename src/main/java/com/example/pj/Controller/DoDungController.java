package com.example.pj.Controller;

import com.example.pj.Models.Item;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class DoDungController implements Initializable {

    @FXML
    private GridPane gridPane;

    @FXML
    private Button quayLaiButton;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private Button timKiemButton;

    @FXML
    private TextField timKiemField;

    //PHƯƠNG THỨC TRẢ VỀ DANH SÁCH CHỨA CÁC ITEM
    private List<Item> taoDS() {
        List<Item> ls = new ArrayList<>();
        Item item;

        item = new Item("/image/item/doDung/ban.jpg", "Cái Bàn", 99000, "/image/item/danhGia/5sao.gif");
        ls.add(item);

        item = new Item("/image/item/doDung/dienthoai.jpg", "Điện Thoại", 200000, "/image/item/danhGia/5sao.gif");
        ls.add(item);

        item = new Item("/image/item/doDung/ghe.jpg.crdownload", "Cái Ghế", 40000, "/image/item/danhGia/5sao.gif");
        ls.add(item);

        item = new Item("/image/item/doDung/gioDo.jpg", "Giỏ Đồ", 15000, "/image/item/danhGia/5sao.gif");
        ls.add(item);

        item = new Item("/image/item/doDung/mayTinh.jpg", "Máy Tính", 300000, "/image/item/danhGia/5sao.gif");
        ls.add(item);

        item = new Item("/image/item/doDung/noiCom.jpg", "Nồi Cơm", 78000, "/image/item/danhGia/5sao.gif");
        ls.add(item);

        item = new Item("/image/item/doDung/Smart-Tivi-OLED-LG-4K-55-inch-55GXPTA.jpg", "Tivi", 150000, "/image/item/danhGia/5sao.gif");
        ls.add(item);

        item = new Item("/image/item/doDung/tuLanh.jpg", "Tủ Lạnh", 120000, "/image/item/danhGia/5sao.gif");
        ls.add(item);

        return ls;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        int column = 0;
        int row = 1;

        List<Item> itemsDoDung = new ArrayList<>(taoDS());

        try {
            for (Item item : itemsDoDung) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/fxml/item.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                ItemController itemController = fxmlLoader.getController();
                itemController.setData(item);

                if (column == 5) {
                    column = 0;
                    ++row;
                }
                gridPane.add(anchorPane, column++, row);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }

    }

    // XỬ LÝ SỰ KIỆN BUTTON QUAY LẠI
    public void onButtonQuayLai() throws Exception{

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/home.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) quayLaiButton.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
