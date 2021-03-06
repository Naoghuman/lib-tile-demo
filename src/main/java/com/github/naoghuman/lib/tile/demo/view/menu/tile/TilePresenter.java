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
package com.github.naoghuman.lib.tile.demo.view.menu.tile;

import com.github.naoghuman.lib.action.core.ActionHandlerFacade;
import com.github.naoghuman.lib.action.core.RegisterActions;
import com.github.naoghuman.lib.action.core.TransferData;
import com.github.naoghuman.lib.action.core.TransferDataBuilder;
import com.github.naoghuman.lib.logger.core.LoggerFacade;
import com.github.naoghuman.lib.tile.core.Tile;
import com.github.naoghuman.lib.tile.core.TileLoader;
import com.github.naoghuman.lib.tile.core.TileProvider;
import com.github.naoghuman.lib.tile.customized.examples.reducedtileset.CustomizedExampleReducedTileSet;
import com.github.naoghuman.lib.tile.demo.configuration.IActionConfiguration;
import com.github.naoghuman.lib.tile.demo.view.learnmore.LearnMoreView;
import com.github.naoghuman.lib.tile.demo.view.menu.tile.customizedexampleaitem.CustomizedExampleAitemCell;
import com.github.naoghuman.lib.tile.demo.view.menu.tile.customizedexampleaitem.CustomizedExampleAitemPresenter;
import com.github.naoghuman.lib.tile.demo.view.menu.tile.customizedexampleaitem.CustomizedExampleAitemView;
import com.github.naoghuman.lib.tile.demo.view.menu.tile.transparenttexturesitem.TransparentTexturesItemCell;
import com.github.naoghuman.lib.tile.demo.view.menu.tile.transparenttexturesitem.TransparentTexturesItemPresenter;
import com.github.naoghuman.lib.tile.demo.view.menu.tile.transparenttexturesitem.TransparentTexturesItemView;
import com.github.naoghuman.lib.tile.transparenttextures.TransparentTexturesTileSet;
import java.awt.Desktop;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.ListView;
import javafx.scene.layout.Background;
import javafx.stage.Modality;

/**
 *
 * @author Naoghuman
 */
public class TilePresenter implements Initializable, IActionConfiguration, RegisterActions {
    
    private static final int NO_SELECTION_INDEX = -1;
    
    @FXML private ListView lvCustomizedTileExampleA;
    @FXML private ListView lvTransparentTextures;
    
    private int selectionIndex = NO_SELECTION_INDEX;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        LoggerFacade.getDefault().info(this.getClass(), "Initialize TilePresenter"); // NOI18N
                
        this.initializeCustomizedTileExamples();
        this.initializeTransparentTextures();
        
        this.register();
    }

    private void initializeCustomizedTileExamples() {
        LoggerFacade.getDefault().info(this.getClass(), "Initialize CustomizedExamples"); // NOI18N
        
        lvCustomizedTileExampleA.getItems().clear();
        lvCustomizedTileExampleA.setCellFactory(value -> new CustomizedExampleAitemCell());
        
        final Task task = new Task<ObservableList<CustomizedExampleAitemPresenter>>() {
            @Override
            protected ObservableList<CustomizedExampleAitemPresenter> call() throws InterruptedException {

                final ObservableList<Tile> tiles = FXCollections.observableArrayList();
                tiles.addAll(CustomizedExampleReducedTileSet.getDefault().getTiles());

                final List<CustomizedExampleAitemPresenter> presenters = tiles.stream()
                        .map((Tile tile) -> {
                            final CustomizedExampleAitemView view = new CustomizedExampleAitemView();
                            final CustomizedExampleAitemPresenter presenter = view.getRealPresenter();
                            presenter.configure(view.getView(), tile);

                            return presenter;
                        })
                        .collect(Collectors.toCollection(ArrayList::new));

                return FXCollections.observableArrayList(presenters);
            }
        };
        lvCustomizedTileExampleA.itemsProperty().bind(task.valueProperty());
        new Thread(task).start();
        
        lvCustomizedTileExampleA.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {

            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if (newValue instanceof CustomizedExampleAitemPresenter) {
                    final CustomizedExampleAitemPresenter presenter = (CustomizedExampleAitemPresenter) newValue;
                    final Optional<TileLoader> tileLoader = presenter.getTileLoader();
                    if (tileLoader.isPresent()) {
                        final Tile tile = presenter.getTile();
                        TilePresenter.this.onActionShowTileBackground(tileLoader.get(), tile);
                    }
                }
            }
        });
    }

    private void initializeTransparentTextures() {
        LoggerFacade.getDefault().info(this.getClass(), "Initialize TransparentTextures"); // NOI18N
        
        lvTransparentTextures.getItems().clear();
        lvTransparentTextures.setCellFactory(value -> new TransparentTexturesItemCell());
        
        final Task task = new Task<ObservableList<TransparentTexturesItemPresenter>>() {
            @Override
            protected ObservableList<TransparentTexturesItemPresenter> call() throws InterruptedException {
                final ObservableList<Tile> tiles = FXCollections.observableArrayList();
                tiles.addAll(TransparentTexturesTileSet.getDefault().getTiles());

                final List<TransparentTexturesItemPresenter> presenters = tiles.stream()
                        .map((Tile tile) -> {
                            final TransparentTexturesItemView view = new TransparentTexturesItemView();
                            final TransparentTexturesItemPresenter presenter = view.getRealPresenter();
                            presenter.configure(view.getView(), tile);

                            return presenter;
                        })
                        .collect(Collectors.toCollection(ArrayList::new));

                return FXCollections.observableArrayList(presenters);
            }
        };
        lvTransparentTextures.itemsProperty().bind(task.valueProperty());
        new Thread(task).start();
        
        lvTransparentTextures.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {

            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if (newValue instanceof TransparentTexturesItemPresenter) {
                    final TransparentTexturesItemPresenter presenter = (TransparentTexturesItemPresenter) newValue;
                    final Optional<TileLoader> tileLoader = presenter.getTileLoader();
                    if (tileLoader.isPresent()) {
                        final Tile tile = presenter.getTile();
                        TilePresenter.this.onActionShowTileBackground(tileLoader.get(), tile);
                    }
                }
            }
        });
    }
    
    public void onActionResetTileBackground() {
        LoggerFacade.getDefault().debug(this.getClass(), "On action reset Tile background"); // NOI18N
        
        lvTransparentTextures.getSelectionModel().clearSelection();
        ActionHandlerFacade.getDefault().handle(ON_ACTION__RESET_TILE_BACKGROUND);
    }
    
    public void onActionShowLearnMore() {
        LoggerFacade.getDefault().debug(this.getClass(), "On action reset Tile background"); // NOI18N
        
        // Show LearnMore in default browser if available
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().browse(new URL("https://github.com/Naoghuman/lib-tile-demo#BaIm").toURI()); // NOI18N
            } catch (MalformedURLException ex) {
                Logger.getLogger(TilePresenter.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException | URISyntaxException ex) {
                Logger.getLogger(TilePresenter.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            return;
        }
        
        // Otherwise show LearnMore in a dialog
        final Dialog<Parent> dialog = new Dialog<>();
        dialog.initModality(Modality.NONE);
        dialog.setTitle("Learn more..."); // NOI18N
        dialog.setResizable(Boolean.FALSE);
    
        final ButtonType buttonTypeOk = new ButtonType("Okay", ButtonBar.ButtonData.OK_DONE); // NOI18N
        dialog.getDialogPane().getButtonTypes().add(buttonTypeOk);
        
        // TODO check from where the dialog should be open -> opens different urls
        final LearnMoreView view = new LearnMoreView();
        dialog.getDialogPane().setContent(view.getView());
        
        dialog.show();
    }

    private void onActionShowTileBackground(final TileLoader tileLoader, final Tile tile) {
        LoggerFacade.getDefault().debug(this.getClass(), "On action show Tile background"); // NOI18N
        
        final Optional<Background> background = TileProvider.getDefault().loadAsBackground(tileLoader, tile);
        if (background.isPresent()) {
            final TransferData data = TransferDataBuilder.create()
                    .actionId(ON_ACTION__SHOW_TILE_BACKGROUND)
                    .objectValue(background.get())
                    .build();

            ActionHandlerFacade.getDefault().handle(data);
        }
    }

    private void onActionSwitchSelection(boolean titledPaneExpand) {
        LoggerFacade.getDefault().debug(this.getClass(), "On action show switch Selection"); // NOI18N
        
        /*
        try a hack for the false background color when the selection is vanished.
         - don't work
        */
//        System.out.println("titledPaneExpand: " + titledPaneExpand);
//        if (titledPaneExpand) {
//            System.out.println("(selectionIndex != NO_SELECTION_INDEX): " + (selectionIndex != NO_SELECTION_INDEX));
//            if (selectionIndex != NO_SELECTION_INDEX) {
//                System.out.println("0) selectionIndex: " + selectionIndex);
//                Platform.runLater(() -> {
//                    lvTransparentTextures.getSelectionModel().select(selectionIndex);
//                    lvTransparentTextures.getFocusModel().focus(selectionIndex);
////                    lvTransparentTextures.scrollTo(selectionIndex);
//                });
//            }
//        }
//        else {
//            System.out.println("lvTransparentTextures.getSelectionModel().isEmpty(): " + lvTransparentTextures.getSelectionModel().isEmpty());
//            if (lvTransparentTextures.getSelectionModel().isEmpty()) {
//                selectionIndex = NO_SELECTION_INDEX;
//                System.out.println("1) selectionIndex: " + selectionIndex);
//            }
//            else {
//                selectionIndex = lvTransparentTextures.getSelectionModel().getSelectedIndex();
//                System.out.println("2) selectionIndex: " + selectionIndex);
//            }
//            
//            lvTransparentTextures.getSelectionModel().clearSelection();
//        }
    }
    
    @Override
    public void register() {
        LoggerFacade.getDefault().debug(this.getClass(), "Register actions in TilePresenter"); // NOI18N
        
        this.registerOnActionSwitchSelection();
    }
    
    private void registerOnActionSwitchSelection() {
        LoggerFacade.getDefault().debug(this.getClass(), "Register on Action switch Selection"); // NOI18N
        
        ActionHandlerFacade.getDefault().register(
                ON_ACTION__SWITCH_SELECTION,
                (ActionEvent event) -> {
                    final TransferData data = (TransferData) event.getSource();
                    final Optional<Boolean> titledPaneExpand = data.getBoolean();
                    if (titledPaneExpand.isPresent()) {
                        this.onActionSwitchSelection(titledPaneExpand.get());
                    }
                });
    }
    
}
