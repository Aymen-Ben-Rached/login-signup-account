package com.example.journey;

import com.example.journey.UI.HomeUI;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Objects;

public class SceneSwitch {
    public SceneSwitch(AnchorPane currentAnchorPane, String fxml) throws IOException{
        AnchorPane nextAnchorPane = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource((fxml))));
        currentAnchorPane.getChildren().removeAll();
        currentAnchorPane.getChildren().setAll(nextAnchorPane);
    }
}
