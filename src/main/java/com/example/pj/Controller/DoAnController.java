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

public class DoAnController implements Initializable {

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

        item = new Item("/image/item/doAn/Chuoi.jpg", "Chuối", 12000, "/image/item/danhGia/5sao.gif");
        ls.add(item);

        item = new Item("/image/item/doAn/DauTay.jpg", "Dâu Tây", 20000, "/image/item/danhGia/5sao.gif");
        ls.add(item);

        item = new Item("/image/item/doAn/kiwi-logo-clipart-3.png", "Kiwi", 18000, "/image/item/danhGia/5sao.gif");
        ls.add(item);

        item = new Item("/image/item/doAn/duaHau.jpg.crdownload", "Dưa Hấu", 15000, "/image/item/danhGia/5sao.gif");
        ls.add(item);

        item = new Item("/image/item/doAn/cam.jpg", "Cam", 14000, "/image/item/danhGia/5sao.gif");
        ls.add(item);

        item = new Item("/image/item/doAn/tao.jpg", "Táo", 17000, "/image/item/danhGia/5sao.gif");
        ls.add(item);

        item = new Item("/image/item/doAn/hong.jpg", "Hồng", 15000, "/image/item/danhGia/5sao.gif");
        ls.add(item);

        item = new Item("/image/item/doAn/luu.jpg", "Lựu Đỏ", 21000, "/image/item/danhGia/5sao.gif");
        ls.add(item);

        item = new Item("/image/item/doAn/mangCut.jpeg", "Măng Cụt", 25000, "/image/item/danhGia/5sao.gif");
        ls.add(item);

        item = new Item("/image/item/doAn/mit.jpg", "Mít", 14000, "/image/item/danhGia/5sao.gif");
        ls.add(item);

        item = new Item("/image/item/doAn/sauRieng.jpg", "Sầu Riêng", 27000, "/image/item/danhGia/5sao.gif");
        ls.add(item);

        item = new Item("/image/item/doAn/vai.jpg", "Vải Thiều", 25000, "/image/item/danhGia/5sao.gif");
        ls.add(item);

        item = new Item("/image/item/doAn/xoai.png", "Xoài", 21000, "/image/item/danhGia/5sao.gif");
        ls.add(item);

        return ls;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        int column = 0;
        int row = 1;

        List<Item> itemsDoAn = new ArrayList<>(taoDS());

        try {
            for (Item item : itemsDoAn) {
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
