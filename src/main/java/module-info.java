module com.src.dxfgeneratorv2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.poi.poi;
    requires java.desktop;
    requires jdxf;


    opens com.src.dxfgeneratorv2 to javafx.fxml;
    exports com.src.dxfgeneratorv2;
}