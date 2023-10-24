package com.example.pj.Controller;

import com.example.pj.Models.HoaDon;
import com.example.pj.Models.Item;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static com.example.pj.Controller.HomeController.itemsGioHang;

public class GioHangController implements Initializable {

    @FXML
    private ImageView avatar;

    @FXML
    private Label nameUser;

    @FXML
    private Button quayLaiButton;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private Button thanhToanButton;

    @FXML
    private Button timKiemButton;

    @FXML
    private TextField timKiemField;

    @FXML
    private Label tongTienField;

    @FXML
    private VBox vBox;

    private List<Item> ds = itemsGioHang;

    public static List<HoaDon> dsHoaDon = new ArrayList<>();

    List<Item> itemsGioHangTemp;

    private URL url;
    private ResourceBundle resourceBundle;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.url = url;
        this.resourceBundle = resourceBundle;

        try {
            for(Item item : ds) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/fxml/itemGioHang.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();
                ItemGioHangController itemGioHangController = fxmlLoader.getController();
                itemGioHangController.setData(item);

                vBox.getChildren().add(anchorPane);
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }

        int tong = 0;
        for (Item a : itemsGioHang) {
            tong = tong + a.getItemPrice()*a.getItemNumber();
        }

        tongTienField.setText(String.valueOf(tong));
    }

    //SỰ KIỆN BUTTON QUAY LẠI
    public void onButtonQuayLai() throws Exception{

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/home.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) quayLaiButton.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    //SỰ KIỆN KHI NHẤN VÀO NÚT THANH TOÁN
    public void onButtonThanhToan() throws Exception{

        // TẠO ĐỐI TƯỢNG HOADON MOI SAU ĐÓ THÊM NÓ VÀO DANH SÁCH HÓA ĐƠN THANH TOÁN
        itemsGioHangTemp = new ArrayList<>(itemsGioHang);
        dsHoaDon.add(new HoaDon(itemsGioHangTemp));
        //XÓA CÁC SẢN PHẨM TRONG GIỎ HÀNG
        itemsGioHang.clear();
        //CẬP NHẬT LẠI GIAO DIỆN
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/gioHang.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) thanhToanButton.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }


    //SỬ LÝ SỰ KIỆN TÌM KIẾM
    public void onButtonTimKiem() throws Exception{

    }

}
