module id {
    requires javafx.controls;
    requires javafx.fxml;

    opens id to javafx.fxml;
    exports id;
}
