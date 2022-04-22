module io.schark.latbesh {
	requires javafx.controls;
	requires javafx.fxml;

	opens io.schark.latbesh to javafx.fxml;
	exports io.schark.latbesh;
}