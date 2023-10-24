package com.example.pj.Controller;

import com.example.pj.Models.Item;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HomeController implements Initializable{

    @FXML
    private ImageView avatar;

    @FXML
    private Button dangXuatButton;

    @FXML
    private Button doAnButton;

    @FXML
    private Button doDungButton;

    @FXML
    private Button exitButton;

    @FXML
    private Button gioHangButton;

    @FXML
    private GridPane gridPane;

    @FXML
    private Button hoaDonButton;

    @FXML
    private Button khieuNaiButton;

    @FXML
    private Label nameUser;

    @FXML
    private Button quanAoButton;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private Button timKiemButton;

    @FXML
    private TextField timKiemField;

    //TẠO MỘT DANH SÁCH CÁC SẢN PHẨM ĐƯỢC THÊM VÀO GIỎ HÀNG
    public static List<Item> itemsGioHang = new ArrayList<>();

    //PHƯƠNG THỨC TRẢ VỀ DANH SÁCH CHỨA CÁC ITEM
    private List<Item> taoDS() {
        List<Item> ls = new ArrayList<>();
        Item item;

        item = new Item("/image/item/doAn/Chuoi.jpg", "Chuối", 12000, "/image/item/danhGia/5sao.gif");
        ls.add(item);

        item = new Item("/image/item/doAn/DauTay.jpg", "Dâu Tây", 20000, "/image/item/danhGia/5sao.gif");
        ls.add(item);

        item = new Item("/image/item/quanAo/converse-hong.jpg", "Giày Converse Hồng", 80000, "/image/item/danhGia/5sao.gif");
        ls.add(item);

        item = new Item("/image/item/doAn/kiwi-logo-clipart-3.png", "Kiwi", 18000, "/image/item/danhGia/5sao.gif");
        ls.add(item);

        item = new Item("/image/item/doDung/mayTinh.jpg", "Máy Tính", 300000, "/image/item/danhGia/5sao.gif");
        ls.add(item);

        item = new Item("/image/item/quanAo/evisu.jpg", "Áo Evisu", 110000, "/image/item/danhGia/5sao.gif");
        ls.add(item);

        item = new Item("/image/item/quanAo/Navy-Blue-Hoodie.jpg", "Áo Hoodie", 80000, "/image/item/danhGia/5sao.gif");
        ls.add(item);

        item = new Item("/image/item/quanAo/soMiTrang.jpg", "Áo Sơ Mi", 25000, "/image/item/danhGia/5sao.gif");
        ls.add(item);

        item = new Item("/image/item/quanAo/aoPhong.png", "Áo Phông", 40000, "/image/item/danhGia/5sao.gif");
        ls.add(item);

        item = new Item("/image/item/quanAo/aoPolo.jpg", "Áo Polo", 60000, "/image/item/danhGia/5sao.gif");
        ls.add(item);

        item = new Item("/image/item/doDung/noiCom.jpg", "Nồi Cơm", 78000, "/image/item/danhGia/5sao.gif");
        ls.add(item);

        item = new Item("/image/item/doDung/Smart-Tivi-OLED-LG-4K-55-inch-55GXPTA.jpg", "Tivi", 150000, "/image/item/danhGia/5sao.gif");
        ls.add(item);

        return ls;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        int column = 0;
        int row = 1;

        List<Item> itemsGoiY = new ArrayList<>(taoDS());

        try {
            for (Item item : itemsGoiY) {
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

    // SỰ KIỆN ẤN VÀO GIỎ HÀNG BUTTON
    public void onGioHangButton() throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/gioHang.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) gioHangButton.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    //SỰ KIỆN ẤN VÀO BUTTON QUẦN ÁO
    public void onQuanAo() throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/quanAo.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) quanAoButton.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    //SỰ KIỆN ẤN VÀO BUTTON ĐỒ ĂN
    public void onDoAn() throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/doAn.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) doAnButton.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    //SỰ KIỆN ẤN VÀO BUTTON ĐỒ DÙNG
    public void onDoDung() throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/doDung.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) doDungButton.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    //XỬ LÝ SỰ KIỆN BUTTON  HÓA ĐƠN
    public void onHoaDon() throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/hoaDon.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) hoaDonButton.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    //XỬ LÝ SỰ KIỆN BUTTON THOÁT
    public void onThoat() {
        System.exit(0);
    }

    //XỬ LÝ SỰ KIỆN BUTTON ĐĂNG XUẤT
    public void onDangXuat() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) dangXuatButton.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }


}
