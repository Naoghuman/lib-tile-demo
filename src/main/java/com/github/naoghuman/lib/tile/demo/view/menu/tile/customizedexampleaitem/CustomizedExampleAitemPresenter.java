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
package com.github.naoghuman.lib.tile.demo.view.menu.tile.customizedexampleaitem;

import com.github.naoghuman.lib.logger.api.LoggerFacade;
import com.github.naoghuman.lib.tile.core.Tile;
import com.github.naoghuman.lib.tile.core.TileLoader;
import com.github.naoghuman.lib.tile.core.TileProvider;
import com.github.naoghuman.lib.tile.transparenttextures.TransparentTexturesTileSet;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.text.Font;

/**
 *  - use the TileLoader from TransparentTexturesTileSet.
 *  - change the package from the images to original from TransparentTexturesTileSet
 * 
 *  - the example b will use then an own TileLoader.
 * 
 * @author Naoghuman
 */
public class CustomizedExampleAitemPresenter implements Initializable {
    
    @FXML private AnchorPane apBackground;
    @FXML private Label lAutor;
    @FXML private Label lHeader;
    
    private Optional<TileLoader> tileLoader = Optional.empty();

    private Parent parent;
    private Tile tile;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        LoggerFacade.getDefault().trace(this.getClass(), "Initialize CustomizedExamplesItemPresenter"); // NOI18N
    
    }
    
    public final void configure(final Parent parent, final Tile tile) {
        LoggerFacade.getDefault().trace(this.getClass(), "Configure tile: " + tile.getImageName()); // NOI18N
        
        this.parent     = parent;
        this.tile       = tile;
        this.tileLoader = TransparentTexturesTileSet.getDefault().getTileLoader(tile);
        
        // Header
        lHeader.setText(tile.getTitle());
	
        // Autor
        lAutor.setText(tile.getAutor());
		
        // Url
        final String url = tile.getAutorUrl();
        if (
                (url != null)
                && (!url.isEmpty())
        ) {
            // URL -> handling
            lAutor.setCursor(Cursor.CLOSED_HAND);
            lAutor.setOnMouseClicked(event -> {
                if (Desktop.isDesktopSupported()) {
                    try {
                        Desktop.getDesktop().browse(new URL(url).toURI());
                    } catch (URISyntaxException | IOException ex) {
                        LoggerFacade.getDefault().error(this.getClass(), "Can't open URL in system browser: " + url, ex); // NOI18N
                    }
                }
            });
        }
        else {
            // No URL - no handling
            lAutor.setFont(new Font("System Italic", 14.0d)); // NOI18N
        }
        
        // Background
        Platform.runLater(() -> { 
            if (tileLoader.isPresent()) {
                final Optional<Background> background = TileProvider.getDefault().loadAsBackground(tileLoader.get(), tile);
                if (background.isPresent()) {
                    apBackground.setBackground(background.get());
                }
            }
        });
    }
    
    public final Parent getParent() {
        return parent;
    }
    
    public final Tile getTile() {
        return tile;
    }
    
    public final Optional<TileLoader> getTileLoader() {
        return tileLoader;
    }
    
}
