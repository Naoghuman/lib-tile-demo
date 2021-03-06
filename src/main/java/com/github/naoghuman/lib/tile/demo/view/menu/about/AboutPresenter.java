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
package com.github.naoghuman.lib.tile.demo.view.menu.about;

import com.github.naoghuman.lib.logger.core.LoggerFacade;
import com.github.naoghuman.lib.properties.core.PropertiesFacade;
import com.github.naoghuman.lib.tile.demo.configuration.IApplicationConfiguration;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author Naoghuman
 */
public class AboutPresenter implements Initializable, IApplicationConfiguration {
    
    @FXML private Label lVersion;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        LoggerFacade.getDefault().info(this.getClass(), "Initialize AboutPresenter"); // NOI18N
        
        this.initializeLabelVersion();
    }

    private void initializeLabelVersion() {
        LoggerFacade.getDefault().info(this.getClass(), "Initialize label Version"); // NOI18N
        
        final String version = PropertiesFacade.getDefault().getProperty(
                KEY__APPLICATION__RESOURCE_BUNDLE, KEY__APPLICATION__VERSION);
        lVersion.setText(version);
    }
    
}
