package com.example.logindashboard;

import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class LoginController {
    @FXML
    private VBox rootBox;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorLabel;

    @FXML
    protected void onLoginButtonClick() {
        String email = emailField.getText() == null ? "" : emailField.getText().trim();
        String password = passwordField.getText() == null ? "" : passwordField.getText();

        List<String> errors = new ArrayList<>();

        if (email.length() < 4) {
            errors.add("- Email must have at least 4 characters.");
        }
        if (!email.contains("@") || !email.contains(".")) {
            errors.add("- Email must include '@' and '.'.");
        }
        if (password.length() < 6) {
            errors.add("- Password must have at least 6 characters.");
        }

        if (!errors.isEmpty()) {
            errorLabel.setText(String.join("\n", errors));
            return;
        }

        errorLabel.setText("");
        rootBox.getChildren().clear();
        Label welcomeLabel = new Label("Welcome, " + email);
        rootBox.getChildren().add(welcomeLabel);
    }
}