module com.gui.alphamensa {
    requires javafx.controls;
    requires javafx.fxml;
            
        requires org.controlsfx.controls;
            requires com.dlsc.formsfx;
                        
    opens bigmensa.gui.alphamensa to javafx.fxml;
    exports bigmensa.gui.alphamensa;
}