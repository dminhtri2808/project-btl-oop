package com.example.pj.Controller;

import com.example.pj.Models.HoaDon;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import static com.example.pj.Controller.GioHangController.dsHoaDon;

public class HoaDonGioController {

    @FXML
    private Button chiTietButton;

    @FXML
    private Label soHoaDon;

    @FXML
    private Label trangThai;

    @FXML
    private Label tienHoaDon;

    private HoaDon hoadon;

    public static HoaDon detail;

    public void setData(HoaDon hoadon) {
        this.hoadon = hoadon;
        soHoaDon.setText(String.valueOf(hoadon.getId()));
        tienHoaDon.setText(String.valueOf(hoadon.getTien()));
    }

    //XỬ LÝ SỰ KIỆN BUTTON CHI TIẾT
    public void onChiTietbutton() throws Exception{
        for (HoaDon a : dsHoaDon) {
            if(a.getId() == hoadon.getId()) {
                detail = a;
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/HoaDonDetail.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                Stage stage = (Stage) chiTietButton.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
                return;
            }
        }
    }

}
