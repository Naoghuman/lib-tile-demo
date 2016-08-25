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
package com.github.naoghuman.lib.tile.demo.view.menu.background;

import com.github.naoghuman.lib.action.api.ActionFacade;
import com.github.naoghuman.lib.action.api.IRegisterActions;
import com.github.naoghuman.lib.action.api.TransferData;
import com.github.naoghuman.lib.logger.api.LoggerFacade;
import com.github.naoghuman.lib.tile.demo.configuration.IActionConfiguration;
import com.github.naoghuman.lib.tile.demo.configuration.IApplicationConfiguration;
import com.github.naoghuman.lib.tile.demo.configuration.IBackgroundConfiguration;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.paint.Color;

/**
 * 
 * @author Naoghuman
 */
public class BackgroundPresenter implements Initializable, IActionConfiguration, 
        IBackgroundConfiguration, IRegisterActions {
    
    @FXML private Button bResetSingleColor;
    @FXML private Button bResetXyGradient;
    @FXML private Button bShowExampleXyGradient;
    @FXML private Button bShowXyGradient;
    @FXML private ColorPicker cpBackgroundColor;
    @FXML private ProgressBar pbImageLoading;
    @FXML private TextArea taXyGrandient;
    @FXML private TextField tfUrlBackgroundImage;
    @FXML private ToggleGroup tgColorMode;
    
    private String backgroundExampleCSS;
    private String backgroundExampleImageURL;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        LoggerFacade.INSTANCE.info(this.getClass(), "Initialize BackgroundPresenter"); // NOI18N
        
        this.initializeBackgroundParameters(resources);
        this.initializeColorComponents();
        this.initializeColorPickerForBackgroundColor();
        this.initializeTextFieldForBackgroundImage();
    }
    
    private void initializeBackgroundParameters(ResourceBundle resources) {
        LoggerFacade.INSTANCE.info(this.getClass(), "Initialize Background parameters"); // NOI18N
        
        try {
            backgroundExampleCSS = resources.getString(KEY__BACKGROUND__EXAMPLE_CSS);
            backgroundExampleImageURL = resources.getString(KEY__BACKGROUND__EXAMPLE_IMAGE_URL);
        } catch (Exception e) {
            backgroundExampleCSS = "<no example.css avaiable>"; // NOI18N
            backgroundExampleImageURL = "<no example.image.url available>"; // NOI18N
        }
    }
    
    private void initializeColorComponents() {
        LoggerFacade.INSTANCE.info(this.getClass(), "Initialize Color components"); // NOI18N
        
        cpBackgroundColor.setDisable(Boolean.FALSE);
        bResetSingleColor.setDisable(Boolean.FALSE);
        
        taXyGrandient.setDisable(Boolean.TRUE);
        bShowExampleXyGradient.setDisable(Boolean.TRUE);
        bShowXyGradient.setDisable(Boolean.TRUE);
        bResetXyGradient.setDisable(Boolean.TRUE);
    }
    
    private void initializeColorPickerForBackgroundColor() {
        LoggerFacade.INSTANCE.info(this.getClass(), "Initialize ColorPicker for background color"); // NOI18N
        
        cpBackgroundColor.setValue(IApplicationConfiguration.DEFAULT_BACKGROUND_COLOR);
    }
    
    private void initializeTextFieldForBackgroundImage() {
        LoggerFacade.INSTANCE.info(this.getClass(), "Initialize TextField for background image"); // NOI18N
        
        final Tooltip tt = new Tooltip("Images will be resized to 1280x720" // NOI18N
                + "\nEmpty URL reset the background image"); // NOI18N
        tfUrlBackgroundImage.setTooltip(tt);
    }
    
    @Override
    public void registerActions() {
        LoggerFacade.INSTANCE.debug(this.getClass(), "Register actions in BackgroundPresenter"); // NOI18N
    }
    
    public void onActionResetBackgroundColor() {
        LoggerFacade.INSTANCE.debug(this.getClass(), "On action reset Background color"); // NOI18N
        
        cpBackgroundColor.setValue(IApplicationConfiguration.DEFAULT_BACKGROUND_COLOR);
        taXyGrandient.setText(null);
        ActionFacade.INSTANCE.handle(ON_ACTION__RESET_BACKGROUND_COLOR);
    }
    
    public void onActionResetBackgroundImage() {
        LoggerFacade.INSTANCE.debug(this.getClass(), "On action reset Background image"); // NOI18N
        
        tfUrlBackgroundImage.setText(null);
        pbImageLoading.progressProperty().unbind();
        pbImageLoading.setProgress(0.0d);
        ActionFacade.INSTANCE.handle(ON_ACTION__RESET_BACKGROUND_IMAGE);
    }
    
    public void onActionSelectSingleColor(ActionEvent event) {
        LoggerFacade.INSTANCE.debug(this.getClass(), "On action select Singlecolor"); // NOI18N
        
        if (!(event.getSource() instanceof RadioButton)) {
            return;
        }
        
        final RadioButton rb = (RadioButton) event.getSource();
        final boolean isSelected = rb.isSelected();
        
        cpBackgroundColor.setDisable(!isSelected);
        bResetSingleColor.setDisable(!isSelected);
        
        taXyGrandient.setDisable(isSelected);
        bShowExampleXyGradient.setDisable(isSelected);
        bShowXyGradient.setDisable(isSelected);
        bResetXyGradient.setDisable(isSelected);
    }
    
    public void onActionSelectXyGradient(ActionEvent event) {
        LoggerFacade.INSTANCE.debug(this.getClass(), "On action select XyGradient"); // NOI18N
        
        if (!(event.getSource() instanceof RadioButton)) {
            return;
        }
        
        final RadioButton rb = (RadioButton) event.getSource();
        final boolean isSelected = rb.isSelected();
        
        cpBackgroundColor.setDisable(isSelected);
        bResetSingleColor.setDisable(isSelected);
        
        taXyGrandient.setDisable(!isSelected);
        bShowExampleXyGradient.setDisable(!isSelected);
        bShowXyGradient.setDisable(!isSelected);
        bResetXyGradient.setDisable(!isSelected);
    }
    
    public void onActionShowBackgroundColor() {
        LoggerFacade.INSTANCE.debug(this.getClass(), "On action select Background color"); // NOI18N
        
        final TransferData data = new TransferData();
        data.setActionId(ON_ACTION__SHOW_BACKGROUND_SINGLECOLOR);
        
        final Color backgroundColor = cpBackgroundColor.getValue();
        data.setObject(backgroundColor);
        
        ActionFacade.INSTANCE.handle(data);
    }
    
    public void onActionShowBackgroundImage() {
        LoggerFacade.INSTANCE.debug(this.getClass(), "On action show Background image"); // NOI18N
        
        // Check URL
        final String url = tfUrlBackgroundImage.getText().trim();
        if (
                (url == null)
                || (url.isEmpty())
        ) {
            // Reset the Background image
            ActionFacade.INSTANCE.handle(ON_ACTION__RESET_BACKGROUND_IMAGE);
            return;
        }
        
        // Load new Background image
        final TransferData data = new TransferData();
        data.setActionId(ON_ACTION__SHOW_BACKGROUND_IMAGE);
        data.setString(url);
        data.setObject(pbImageLoading);
        
        ActionFacade.INSTANCE.handle(data);
    }
    
    public void onActionShowBackgroundXyGradient() {
        LoggerFacade.INSTANCE.debug(this.getClass(), "On action show Background XyGradient"); // NOI18N
        
        // Check backgroundColor
        final String backgroundColor = taXyGrandient.getText();
        if (
                (backgroundColor == null)
                || (backgroundColor.isEmpty())
        ) {
            return;
        }
        
        // Load new Background XyGradient
        final TransferData data = new TransferData();
        data.setActionId(ON_ACTION__SHOW_BACKGROUND_XY_GRADIENT);
        data.setString(backgroundColor);
        
        ActionFacade.INSTANCE.handle(data);
    }
    
    public void onActionShowExampleBackgroundImage() {
        LoggerFacade.INSTANCE.debug(this.getClass(), "On action show Example Background image"); // NOI18N
        
        tfUrlBackgroundImage.setText(backgroundExampleImageURL);
    }
    
    public void onActionShowExampleXyGradient() {
        LoggerFacade.INSTANCE.debug(this.getClass(), "On action show Example XyGradient"); // NOI18N
        
        taXyGrandient.setText(backgroundExampleCSS);
    }
    
}
