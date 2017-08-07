/*
 * Copyright (C) 2016 Naoghuman
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
package com.github.naoghuman.lib.tile.demo.view.learnmore;

import com.github.naoghuman.lib.logger.api.LoggerFacade;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.concurrent.Worker;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 *
 * @author Naoghuman
 */
public class LearnMorePresenter implements Initializable {
    
    @FXML private AnchorPane apLoadingBackground;
    @FXML private ProgressIndicator piLoadingProgress;
    @FXML private StackPane spLearnMore;
    @FXML private WebView wvLearnMore;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        LoggerFacade.getDefault().info(this.getClass(), "Initialize LearnMorePresenter"); // NOI18N
        
        this.initializeLearnMore();
    }

    private void initializeLearnMore() {
        LoggerFacade.getDefault().info(this.getClass(), "Initialize LearnMore"); // NOI18N
        
        apLoadingBackground.setVisible(Boolean.TRUE);
        apLoadingBackground.setManaged(Boolean.TRUE);
        piLoadingProgress.setVisible(Boolean.TRUE);
        piLoadingProgress.setManaged(Boolean.TRUE);
        
        spLearnMore.setPrefSize(1280.0d, 720.0d);
        
        final WebEngine webEngine = wvLearnMore.getEngine();
        webEngine.load("https://github.com/Naoghuman/lib-tile-demo#BaIm"); // NOI18N
        webEngine.getLoadWorker().stateProperty().addListener((obs, oldState, newState) -> {
            if (newState == Worker.State.SUCCEEDED) {
                apLoadingBackground.setVisible(Boolean.FALSE);
                apLoadingBackground.setManaged(Boolean.FALSE);
                piLoadingProgress.setVisible(Boolean.FALSE);
                piLoadingProgress.setManaged(Boolean.FALSE);
            }
        });
    }
    
    
    
}
