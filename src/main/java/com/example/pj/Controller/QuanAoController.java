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

public class QuanAoController implements Initializable {

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

        item = new Item("/image/item/quanAo/aoLen.jpg", "Áo Len", 50000, "/image/item/danhGia/5sao.gif");
        ls.add(item);

        item = new Item("/image/item/quanAo/aoPhong.png", "Áo Phông", 40000, "/image/item/danhGia/5sao.gif");
        ls.add(item);

        item = new Item("/image/item/quanAo/aoPolo.jpg", "Áo Polo", 60000, "/image/item/danhGia/5sao.gif");
        ls.add(item);

        item = new Item("/image/item/quanAo/bomber.jpg", "Áo Bomber", 100000, "/image/item/danhGia/5sao.gif");
        ls.add(item);

        item = new Item("/image/item/quanAo/cardigan.jpg", "Áo Cardigan", 70000, "/image/item/danhGia/5sao.gif");
        ls.add(item);

        item = new Item("/image/item/quanAo/converse-hong.jpg", "Giày Converse Hồng", 80000, "/image/item/danhGia/5sao.gif");
        ls.add(item);

        item = new Item("/image/item/quanAo/muLen.jpg", "Mũ Len", 10000, "/image/item/danhGia/5sao.gif");
        ls.add(item);

        item = new Item("/image/item/quanAo/quanDui.jpg", "Quần Đùi", 15000, "/image/item/danhGia/5sao.gif");
        ls.add(item);

        item = new Item("/image/item/quanAo/quanHoaQua.png", "Quần Hoa", 11000, "/image/item/danhGia/5sao.gif");
        ls.add(item);

        item = new Item("/image/item/quanAo/evisu.jpg", "Áo Evisu", 110000, "/image/item/danhGia/5sao.gif");
        ls.add(item);

        item = new Item("/image/item/quanAo/Navy-Blue-Hoodie.jpg", "Áo Hoodie", 80000, "/image/item/danhGia/5sao.gif");
        ls.add(item);

        item = new Item("/image/item/quanAo/soMiTrang.jpg", "Áo Sơ Mi", 25000, "/image/item/danhGia/5sao.gif");
        ls.add(item);

        item = new Item("/image/item/quanAo/giay-Nike.jpg", "Giày Nike", 120000, "/image/item/danhGia/5sao.gif");
        ls.add(item);

        item = new Item("/image/item/quanAo/quanJogger.jpg", "Quần Jogger", 30000, "/image/item/danhGia/5sao.gif");
        ls.add(item);

        item = new Item("/image/item/quanAo/quanAu.jpg.crdownload", "Quần Âu", 48000, "/image/item/danhGia/5sao.gif");
        ls.add(item);

        return ls;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        int column = 0;
        int row = 1;

        List<Item> itemsQuanAo = new ArrayList<>(taoDS());

        try {
            for (Item item : itemsQuanAo) {
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
