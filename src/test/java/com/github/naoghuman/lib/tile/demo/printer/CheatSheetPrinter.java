package com.github.naoghuman.lib.tile.demo.printer;

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


import com.github.naoghuman.lib.tile.core.Tile;
import com.github.naoghuman.lib.tile.transparenttextures.TransparentTexturesTile;
import java.util.Optional;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

/**
 *
 * @author Naoghuman
 */
public class CheatSheetPrinter extends Application {
    
    private static final String BR = "<br />"; // NOI18N
    private static final String HEALDER_PREFIX = "### Tile "; // NOI18N
    private static final String HREF_PREFIX = "<a name=\""; // NOI18N
    private static final String HREF_SUFFIX = "\" />"; // NOI18N
    private static final String JAVA_DOC = " * The <code>Java</code> representation from the tile: "; // NOI18N
    private static final String JAVA_DOC_END = " */"; // NOI18N
    private static final String JAVA_DOC_START = "/**"; // NOI18N
    private static final String NEW_LINE = "\n"; // NOI18N
    private static final String SOURCE_CODE_BLOCK_END = "```"; // NOI18N
    private static final String SOURCE_CODE_BLOCK_START = "```Java"; // NOI18N
    
    public static void main(String[] args) {
        launch(args);
    }     
    
    @Override
    public void start(Stage primaryStage) {
        printTransparentTextures();
        
        Platform.exit();
    }

//    Example what should be print
// 
//    <br />
//    ### Tile TT_MAZE_BLACK<a name="TT_MAZE_BLACK" />
//    ```Java
//    /**
//     * The <code>Java</code> representation from the tile: Maze Black
//     */
//     TT_MAZE_BLACK("tt-maze-black.png", "Maze Black", 46, 23, "Peax", "http://www.peax-webdesign.com") // NOI18N
//    ```
    private static void print(String name, Tile tile) {
        final StringBuilder sb = new StringBuilder();
        sb.append(NEW_LINE);
        sb.append(BR).append(NEW_LINE);
        sb.append(HEALDER_PREFIX).append(name).append(HREF_PREFIX).append(name)
                .append(HREF_SUFFIX).append(NEW_LINE);
        sb.append(SOURCE_CODE_BLOCK_START).append(NEW_LINE);
        sb.append(JAVA_DOC_START).append(NEW_LINE);
        sb.append(JAVA_DOC).append(name).append(NEW_LINE);
        sb.append(JAVA_DOC_END).append(NEW_LINE);
        sb.append(name).append("(\"").append(tile.getImageName()).append("\", \"") // NOI18N
                .append(tile.getTitle()).append("\", ").append((int)tile.getWidth()) // NOI18N
                .append(", ").append((int)tile.getHeight()).append(", \"").append(tile.getAutor()) // NOI18N
                .append("\", \"").append(tile.getAutorUrl()).append("\") // NOI18N").append(NEW_LINE); // NOI18N
        sb.append(SOURCE_CODE_BLOCK_END);
        
//        System.out.println("--------");
        System.out.println(sb.toString());
//        System.out.println("--------");
    }
    
    protected static void printTransparentTextures() {
        // Test single print
        // print(TransparentTexturesTile.TT_3PX_TILE.name(), TransparentTexturesTile.TT_3PX_TILE);
        
        // Print all from...
        for (TransparentTexturesTile ttt : TransparentTexturesTile.values()) {
            print(ttt.name(), ttt);
        }
    }
    
}
