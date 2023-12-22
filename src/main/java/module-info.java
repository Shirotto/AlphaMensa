module com.example.alphamensa {
    requires javafx.controls;
    requires javafx.fxml;
            
        requires org.controlsfx.controls;
            requires com.dlsc.formsfx;
                        
    opens com.example.alphamensa to javafx.fxml;
    exports com.example.alphamensa;
}