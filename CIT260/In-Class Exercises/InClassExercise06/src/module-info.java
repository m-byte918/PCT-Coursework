module ICE6_Rodriguez {
	requires javafx.controls;
	requires javafx.fxml;
	requires transitive javafx.graphics;
	
	opens com.rodriguez.ice6 to javafx.fxml;
	exports com.rodriguez.ice6;
}