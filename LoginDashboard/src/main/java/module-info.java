module com.example.logindashboard {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.logindashboard to javafx.fxml;
    exports com.example.logindashboard;
}