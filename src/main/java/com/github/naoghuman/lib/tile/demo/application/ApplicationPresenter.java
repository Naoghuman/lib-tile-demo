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
package com.github.naoghuman.lib.tile.demo.application;

import com.github.naoghuman.lib.action.core.ActionHandlerFacade;
import com.github.naoghuman.lib.action.core.RegisterActions;
import com.github.naoghuman.lib.action.core.TransferData;
import com.github.naoghuman.lib.action.core.TransferDataBuilder;
import com.github.naoghuman.lib.logger.core.LoggerFacade;
import com.github.naoghuman.lib.tile.demo.configuration.IActionConfiguration;
import com.github.naoghuman.lib.tile.demo.images.ImagesLoader;
import com.github.naoghuman.lib.tile.demo.view.menu.about.AboutView;
import com.github.naoghuman.lib.tile.demo.view.menu.background.BackgroundView;
import com.github.naoghuman.lib.tile.demo.view.menu.tile.TileView;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

/**
 *
 * @author Naoghuman
 */
public class ApplicationPresenter implements Initializable, IActionConfiguration, RegisterActions {
    
    @FXML private AnchorPane apBackground;
    @FXML private AnchorPane apTileBackground;
    @FXML private BorderPane bpMenuAbout;
    @FXML private BorderPane bpMenuBackground;
    @FXML private BorderPane bpMenuTile;
    @FXML private ImageView ivBackgroundImage;
    @FXML private TitledPane tpBackground;
    @FXML private TitledPane tpTile;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        LoggerFacade.getDefault().info(this.getClass(), "Initialize ApplicationPresenter"); // NOI18N
        
//        assert (apView != null) : "fx:id=\"apView\" was not injected: check your FXML file 'Application.fxml'."; // NOI18N

        this.initializeBackgroundImage();
        this.initializeMenuAbout();
        this.initializeMenuBackground();
        this.initializeMenuTile();
        this.initializeTitledPaneTile();
        
        this.register();
    }
    
    private void initializeTitledPaneTile() {
        LoggerFacade.getDefault().info(this.getClass(), "Initialize TitledPane tile"); // NOI18N
    
        tpTile.expandedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
            final TransferData data = TransferDataBuilder.create()
                    .actionId(ON_ACTION__SWITCH_SELECTION)
                    .booleanValue(newValue)
                    .build();
            
            ActionHandlerFacade.getDefault().handle(data);
        });
    }
    
    public void initializeAfterWindowIsShowing() {
        LoggerFacade.getDefault().info(this.getClass(), "Initialize ApplicationPresenter after window is showing"); // NOI18N
    
        Platform.runLater(() -> {
            tpBackground.setExpanded(true);
        });
    }
    
    private void initializeBackgroundImage() {
        LoggerFacade.getDefault().info(this.getClass(), "Initialize Background image"); // NOI18N
        
        ivBackgroundImage.setImage(null);
        ivBackgroundImage.setFitWidth(1280.0d);
        ivBackgroundImage.setFitHeight(720.0d);
    }
    
    private void initializeMenuAbout() {
        LoggerFacade.getDefault().info(this.getClass(), "Initialize menu About"); // NOI18N
        
        final AboutView view = new AboutView();
        
        bpMenuAbout.setCenter(view.getView());
    }

    private void initializeMenuBackground() {
        LoggerFacade.getDefault().info(this.getClass(), "Initialize menu Background"); // NOI18N
        
        final BackgroundView view = new BackgroundView();
        bpMenuBackground.setCenter(view.getView());
    }

    private void initializeMenuTile() {
        LoggerFacade.getDefault().info(this.getClass(), "Initialize menu Tile"); // NOI18N
        
        final TileView view = new TileView();
        bpMenuTile.setCenter(view.getView());
    }
    
    private void onActionResetBackgroundColor() {
        LoggerFacade.getDefault().debug(this.getClass(), "On action reset Background image"); // NOI18N

        Platform.runLater(() -> {
            apBackground.setStyle("-fx-base: AQUAMARINE;" // NOI18N
                    + "-fx-control-inner-background: AQUAMARINE;" // NOI18N
                    + "-fx-background-color: AQUAMARINE;"); // NOI18N
        });
    }
    
    private void onActionResetBackgroundImage() {
        LoggerFacade.getDefault().debug(this.getClass(), "On action reset Background image"); // NOI18N
        
        ivBackgroundImage.setImage(null);
    }
    
    private void onActionResetTileBackground() {
        LoggerFacade.getDefault().debug(this.getClass(), "On action reset Tile background"); // NOI18N
        
        apTileBackground.setBackground(null);
    }
    
    private void onActionShowBackgroundSingleColor(Color backgroundColor) {
        LoggerFacade.getDefault().debug(this.getClass(), "On action show Background SingleColor"); // NOI18N

        Platform.runLater(() -> {
            final String _fx_base = "-fx-base: rgba("; // NOI18N
            final String _fx_control_inner_background = "-fx-control-inner-background: rgba("; // NOI18N

            final StringBuilder sb = new StringBuilder();
            sb.append((int)(backgroundColor.getRed() * 255));
            sb.append(", "); // NOI18N
            sb.append((int)(backgroundColor.getGreen() * 255));
            sb.append(", "); // NOI18N
            sb.append((int)(backgroundColor.getBlue() * 255));
            sb.append(", "); // NOI18N
            sb.append(backgroundColor.getOpacity());
            sb.append("); "); // NOI18N

            apBackground.setStyle(_fx_base + sb.toString()
                    + _fx_control_inner_background + sb.toString());
        });
    }
    
    private void onActionShowBackgroundXyGradient(String backgroundColor) {
        LoggerFacade.getDefault().debug(this.getClass(), "On action show Background XyGradient"); // NOI18N
        
        Platform.runLater(() -> {
//            final String _fx_base = "-fx-base: "; // NOI18N
//            final String _fx_background_color = "-fx-background-color: ";
//            final String _fx_control_inner_background = "-fx-control-inner-background: "; // NOI18N
//            
//            apBackground.setStyle(
//                    _fx_base + backgroundColor
//                    + _fx_background_color + backgroundColor
//                    + _fx_control_inner_background + backgroundColor);
            
            apBackground.setStyle(backgroundColor);
        });
    }
    
    private void onActionShowBackgroundImage(ProgressBar pbImageLoading, String url) {
        LoggerFacade.getDefault().debug(this.getClass(), "On action show Background image with url: " + url); // NOI18N
        
        this.initializeBackgroundImage();
        try {
            final Image image = new Image(url, 1280.0d, 720.0d, true, true, true);
            ivBackgroundImage.setImage(image);
            
            // ImageLoadTracker.java
            // https://gist.github.com/jewelsea/2556122
            pbImageLoading.progressProperty().unbind();
            pbImageLoading.progressProperty().bind(image.progressProperty());
            image.errorProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                    if (newValue) {
                        ivBackgroundImage.setFitWidth(256.0d);
                        ivBackgroundImage.setFitHeight(256.0d);
                        ivBackgroundImage.setImage(ImagesLoader.getDefault().loadCantLoadTheImage());
                    }
                }
            });
        } catch (NullPointerException | IllegalArgumentException ex) {
            LoggerFacade.getDefault().error(this.getClass(), 
                    "Can't load the Background image with the URL: " + url, ex); // NOI18N
            
            ivBackgroundImage.setFitWidth(256.0d);
            ivBackgroundImage.setFitHeight(256.0d);
            ivBackgroundImage.setImage(ImagesLoader.getDefault().loadCantLoadTheImage());
        }
    }
    
    private void onActionShowTileBackground(Background background) {
        LoggerFacade.getDefault().debug(this.getClass(), "On action show Tile background"); // NOI18N
        
        apTileBackground.setBackground(background);
    }
    
    @Override
    public void register() {
        LoggerFacade.getDefault().debug(this.getClass(), "Register actions in ApplicationPresenter"); // NOI18N
        
        this.registerOnActionResetBackgroundColor();
        this.registerOnActionResetBackgroundImage();
        this.registerOnActionResetTileImage();
        
        this.registerOnActionShowBackgroundSingleColor();
        this.registerOnActionShowBackgroundXyGradient();
        this.registerOnActionShowBackgroundImage();
        this.registerOnActionShowTileImage();
    }

    private void registerOnActionResetBackgroundColor() {
        LoggerFacade.getDefault().debug(this.getClass(), "Register on Action reset Background color"); // NOI18N
        
        ActionHandlerFacade.getDefault().register(
                ON_ACTION__RESET_BACKGROUND_COLOR,
                (ActionEvent event) -> {
                    this.onActionResetBackgroundColor();
                });
    }

    private void registerOnActionResetBackgroundImage() {
        LoggerFacade.getDefault().debug(this.getClass(), "Register on Action reset Background image"); // NOI18N
        
        ActionHandlerFacade.getDefault().register(
                ON_ACTION__RESET_BACKGROUND_IMAGE,
                (ActionEvent event) -> {
                    this.onActionResetBackgroundImage();
                });
    }

    private void registerOnActionResetTileImage() {
        LoggerFacade.getDefault().debug(this.getClass(), "Register on Action reset Tile background"); // NOI18N
        
        ActionHandlerFacade.getDefault().register(
                ON_ACTION__RESET_TILE_BACKGROUND,
                (ActionEvent event) -> {
                    this.onActionResetTileBackground();
                });
    }
    
    private void registerOnActionShowBackgroundSingleColor() {
        LoggerFacade.getDefault().debug(this.getClass(), "Register on Action show Background SingleColor"); // NOI18N
        
        ActionHandlerFacade.getDefault().register(
                ON_ACTION__SHOW_BACKGROUND_SINGLECOLOR,
                (ActionEvent event) -> {
                    final TransferData data = (TransferData) event.getSource();
                    final Optional<Object> optionalColor = data.getObject();
                    if (
                            optionalColor.isPresent()
                            && (optionalColor.get() instanceof Color)
                    ) {
                        final Color background = (Color) optionalColor.get();
                        this.onActionShowBackgroundSingleColor(background);
                    }
                });
    }
    
    private void registerOnActionShowBackgroundXyGradient() {
        LoggerFacade.getDefault().debug(this.getClass(), "Register on Action show Background XyGradient"); // NOI18N
        
        ActionHandlerFacade.getDefault().register(
                ON_ACTION__SHOW_BACKGROUND_XY_GRADIENT,
                (ActionEvent event) -> {
                    final TransferData data = (TransferData) event.getSource();
                    final Optional<String> optionalBackground = data.getString();
                    if (optionalBackground.isPresent()) {
                        final String background = optionalBackground.get();
                        this.onActionShowBackgroundXyGradient(background);
                    }
                });
    }

    private void registerOnActionShowBackgroundImage() {
        LoggerFacade.getDefault().debug(this.getClass(), "Register on Action show Background image"); // NOI18N
        
        ActionHandlerFacade.getDefault().register(
                ON_ACTION__SHOW_BACKGROUND_IMAGE,
                (ActionEvent event) -> {
                    final TransferData data = (TransferData) event.getSource();
                    final Optional<Object> optionalProgressBar = data.getObject();
                    final Optional<String> optionalURL = data.getString();
                    
                    if (
                            optionalProgressBar.isPresent()
                            && (optionalProgressBar.get() instanceof ProgressBar)
                            && optionalURL.isPresent()
                    ) {
                        final ProgressBar pbImageLoading = (ProgressBar) optionalProgressBar.get();
                        final String url = optionalURL.get();
                        this.onActionShowBackgroundImage(pbImageLoading, url);
                    }
                });
    }

    private void registerOnActionShowTileImage() {
        LoggerFacade.getDefault().debug(this.getClass(), "Register on Action show Tile background"); // NOI18N
        
        ActionHandlerFacade.getDefault().register(
                ON_ACTION__SHOW_TILE_BACKGROUND,
                (ActionEvent event) -> {
                    final TransferData data = (TransferData) event.getSource();
                    final Optional<Object> optionalBackground = data.getObject();
                    if (
                            optionalBackground.isPresent()
                            && (optionalBackground.get() instanceof Background)
                    ) {
                        final Background background = (Background) optionalBackground.get();
                        this.onActionShowTileBackground(background);
                    }
                });
    }
    
}
