package com.example.pj.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginController {
    @FXML
    private Hyperlink forgotPassword;

    @FXML
    private Button loginButton;

    @FXML
    private Hyperlink register;

    @FXML
    private TextField userName;

    @FXML
    private PasswordField userPassword;

    @FXML
    private Label text;

    // XỬ LÝ SỰ KIỆN ĐĂNG KÍ
    public void onDangKi() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/register.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) loginButton.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    //XỬ LÝ SỰ KIỆN QUÊN MẬT KHẨU
    public void onQuenMK() throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/forgotPassword.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage) loginButton.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    //XỬ LÝ SỰ KIỆN ĐĂNG NHẬP
    public void onLogin() throws Exception {
        //KẾT NỐI CƠ SỞ DỮ LIỆU
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/btl", "root", "2808200416092004");
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM taiKhoan WHERE  (userPassword = ?) AND (userName = ?)");
        preparedStatement.setString(1, userPassword.getText());
        preparedStatement.setString(2, userName.getText());
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/home.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) loginButton.getScene().getWindow();
            stage.setScene(scene);
            //ĐÓNG KẾT NỐI ĐẾN DATABASE
            preparedStatement.close();
            resultSet.close();
            connection.close();

            stage.show();
            return;
        }

        text.setText("Tài khoản hoặc mật khẩu không chính xác");

    }


}
