package io.schark.latbesh;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LatBeshFX extends Application {
	@Override
	public void start(Stage stage) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(LatBeshFX.class.getResource("lat-bash.fxml"));
		Scene scene = new Scene(fxmlLoader.load(), 400, 150);
		stage.setTitle("LatBesh by Player_Schark");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch();
	}
}