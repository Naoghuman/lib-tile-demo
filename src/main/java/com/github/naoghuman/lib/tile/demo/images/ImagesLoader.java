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
package com.github.naoghuman.lib.tile.demo.images;

import com.github.naoghuman.lib.logger.core.LoggerFacade;
import java.net.URI;
import java.util.Optional;
import javafx.scene.image.Image;

/**
 *
 * @author Naoghuman
 */
public class ImagesLoader {
    
    private static final String CANT_LOAD_THE_IMAGE = "cancel-icon.png"; // NOI18N
	
    private static final Optional<ImagesLoader> instance = Optional.of(new ImagesLoader());

    public static final ImagesLoader getDefault() {
        return instance.get();
    }

    private ImagesLoader() {

    }
    
    public Image loadCantLoadTheImage() {
        Image img = null;
        try {
            final URI uri = ImagesLoader.class.getResource(CANT_LOAD_THE_IMAGE).toURI();
            img = new Image(uri.toString(), 256.0d, 256.0d, true, true, true);
        } catch (Exception ex) {
            LoggerFacade.getDefault().error(this.getClass(), "Can't load the image: " + CANT_LOAD_THE_IMAGE, ex); // NOI18N
        }
        
        return img;
    }
    
}
