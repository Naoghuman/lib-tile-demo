/*
 * Copyright (C) 2016 PRo
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author PRo
 */
public class TestBaseFlagInListViev extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        AnchorPane root = new AnchorPane();
        
        Scene scene = new Scene(root, 800, 600);
        
        primaryStage.setTitle("TestBaseFlagInListViev");
        primaryStage.setScene(scene);
        
        primaryStage.show();
        
        Platform.runLater(() -> {
            root.setStyle("-fx-base: AQUAMARINE;");
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
