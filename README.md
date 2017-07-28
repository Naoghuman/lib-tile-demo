Lib-Tile-Demo
===



Intention
---

This project is a `demonstration` application to show the features from the 
project [Lib-Tile] and it's included sublibraries `lib-tile-core`, 
`lib-tile-transparenttextures` and `lib-tile-transparenttextures-images`.

_Background:_ Winter sunset shinning through the trees &#040;Earth / Sunbeam&#041;  
_Tile:_ Blu Stripes made by [Seb Jachec]  
![demo-application-modified.png][demo-application-modified]

> __Hint__  
> The background image is taken from https://wall.alphacoders.com/big.php?i=723891 
> and is under the license from CCO Public Domain Image. Big thanks to the autor for 
> his great work :smiley:.  
> The tile image is taken from https://www.transparenttextures.com/ and is free 
> to use. Big thanks to the autor for his great work :smiley:.

The current `version` is `0.2.0` from 08.27.2016.

The demo application is build with the `Project-Template-afterburnerfx-Naoghuman` 
from my project [Project-Templates].

> __Description:__  
> `Project-Templates` contains predefined `JavaFX` & `Maven` projects with 
> `afterburner.fx` and optional my own libraries. For example: [Lib-Action], 
> [Lib-Logger] and more.

Please have a look for more information in the project README [Project-Templates].



Content
---

* [Demonstration](#Demonstration)
    - [Project Lib-Tile](#LiTi)  
      _Library_ [_Lib-Tile-Core_](#LiTiCo)  
      _Library_ [_Lib-Tile-TransparentTextures_](#LiTiTr)  
      _Library_ [_Lib-Tile-TransparentTextures-Images_](#LiTiTrIm)
* [Features](#Features)
    - [TitledPane Background](#TiPaBa)  
      _Choose a_ [_Background Image_](#BaIm)  
      _Feedback:_ [_No Image Icon_](#NoImIc)  
      _Choose a_ [_Background Color_](#BaCo)
    - [TitledPane Tile](#TiPaTi)  
      _Tileset_ [_Transparent Textures_](#TrTe)
    - [TitledPane About](#TiPaAb)
* [Requirements](#Requirements)
* [Installation](#Installation)
* [Contribution](#Contribution)
* [License](#License)
* [Autor](#Autor)
* [Contact](#Contact)



Demonstration<a name="Demonstration" />
---

Like I said in the section `Intention` this application is a `demonstration` to 
show the features from the project [Lib-Tile] and it's included sublibraries 
`lib-tile-core`, `lib-tile-transparenttextures` and `lib-tile-transparenttextures-images`.


### Project Lib-Tile<a name="LiTi" />

`Lib-Tile` is a multi [Maven] project written in [JavaFX] and [NetBeans IDE] 8.0.2 
and provides the functionalities to use and handle easily [Tile]s in your [JavaFX] 
application.

A [Tile] is per definition a little transparent [Image] which overlay a 
background-color or -image with the help of repetitions from the image in a layer.

<br />
_Image:_ Crimson Night &#040;Dark / Landscape&#041; with different tile images

> __Hint__  
> Normally only one [Tile] can shown simultaneously. For demonstration purpose 
> I have merge different [Tile]s in one picture.

![different-tile-images.png][different-tile-images]

> __Hint__  
> This image is from the webpage https://wall.alphacoders.com. The image haven't 
> neither a `created by` or `shared by` flag &#040;see http://alphacoders.com/site/faq &#041;. 
> If anyone is the autor and won't that I use this image here in my open souce 
> project plz send me an email &#040;see [Contact](#Contact)&#041; and I will 
> remove it. Thanks for your great work :smiley:.

For more information plz see [Lib-Tile].


### _Library Lib-Tile-Core_<a name="LiTiCo" />

The library `Lib-Tile-Core` provides the main functionalities to load a [Tile] 
as a [Background] or an [Image] with a concrete implementation from the interface 
[AbstractTileLoader].

For more informations and examples plz see [Lib-Tile-Core].


### _Library Lib-Tile-TransparentTextures_<a name="LiTiTr" />

With the library `Lib-Tile-TransparentTextures` the developer have access to the 
tileset `Transparent Textures` from the internet page https://www.transparenttextures.com/ 
through the enum `TransparentTexturesTile`. Momentary that are `396` [Tile]s.

The tile images from this tileset are outsourced in a own library 
`Lib-Tile-TransparentTextures-Images` to reduce the size from this library. One 
more advance is that you can use an `own` [AbstractTileLoader] in combination 
with the library `Lib-Tile-TransparentTextures`. So you don't need to include the 
library `Lib-Tile-TransparentTextures-Images` into your project which size is 
momenatry `13MB`.
>
For more informations and examples plz see [Lib-Tile-TransparentTextures].


### _Library Lib-Tile-TransparentTextures-Images_<a name="LiTiTrIm" />

The library `Lib-Tile-TransparentTextures-Images` contains all images from the 
tileset `Transparent Textures` and the loader [TransparentTexturesTileLoader] 
which allowed the developer to load a [Tile] image from the enum 
[TransparentTexturesTile].

For more informations and examples plz see [Lib-Tile-TransparentTextures-Images].



Features<a name="Features" />
---

The main goal from this application is to demonstrate the features from the 
library [Lib-Tile] and its containing sub-libraries which are momentary 
`lib-core`, `lib-transparent-textures` and `lib-transparent-textures-images`.


### TitledPane Background<a name="TiPaBa" />

Over the [TitledPane] `Background` you can tweak the background image and / or 
the background color from the application.


### _Choose a Background Image_<a name="BaIm" />

With the [TextField] `Background image` the developer / user have the option to 
load an optional background image from the internet. Momentary only images from 
the internet are accepted. The loaded image will be `resized` to the size 
1280x720.

> __Hint__  
> For a future version I plan the option that the developer / user can also choose 
> a local stored images via a [FileChooser].

For example use this link in the demo application and click on the `Load` button:  
* https://cloud.githubusercontent.com/assets/8161815/17748160/601043ba-64b8-11e6-84dd-6e7075dbcf80.jpg

_Image:_ Loaded Crimson Night &#040;Dark / Landscape&#041;  
![loaded-crimson-night.png][loaded-crimson-night]

> __Hint__  
> This image is from the webpage https://wall.alphacoders.com. The image haven't 
> neither a `created by` or `shared by` flag &#040;see http://alphacoders.com/site/faq &#041;. 
> If anyone is the autor and won't that I use this image here in my open souce 
> project plz send me an email &#040;see [Contact](#Contact)&#041; and I will 
> remove it. Thanks for your great work :smiley:.

> __Ps__  
> A click on the `Example` button will prefilled the [TextField] `Background image` 
> with an example link. Then like above described click the `Load` button to load 
> the image.

Clicking the button `Reset` removes the loaded background image and clears the 
[TextField].


### _Feedback: No Image Icon_<a name="NoImIc" />

In the case that its shouldn't be possible to load an [Image] into the demo 
application a special image will be shown to signal that something gone wrong:

_Image:_ No Image Icon  
![no-image-icon.png][no-image-icon]

> __Hint__  
> The image is taken from https://www.iconfinder.com/icons/27836/approve_block_cancel_delete_reject_icon 
> and under the license: Creative Commons Attribution-No Derivative Works 3.0 
> Unported. Thanks for the great work :smiley:.


### _Choose a Background Color_<a name="BaCo" />

#### Single color
* Given is the selection from the [RadioButton] `Colorchooser`.  
* Click on the [ColorPicker] will open the color dialog where a new color can 
  choosen.
* Clicking the button `Reset` reset the background color to the default color 
  [AQUAMARINE].

_Image:_ Open ColorPicker  
![open-colorpicker.png][open-colorpicker]

Method onActionShowBackgroundSingleColor(Color) in the class [ApplicationPresenter]
```java
private void onActionShowBackgroundSingleColor(Color backgroundColor) {
    LoggerFacade.INSTANCE.debug(this.getClass(), "On action show Background SingleColor"); // NOI18N

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
```

#### Linear- and/or RadialGradient
* Given is the selection from the [RadioButton] `Linear- and/or RadialGradient`.
* Like the `prompt` text said in the [TextArea] the three flags `-fx-base` , 
  `-fx-background-color` and `-fx-control-inner-background` are for the tweaking 
  from interest.
* For a `css` example plz click on the `Example` button.
    * For additional information see [LinearGradient], [RadialGradient] and / or 
      [JavaFX CSS Reference Guide].
* Clicking the button `Reset` reset the background color to the default color 
  [AQUAMARINE].

_Image:_ Example `css` combined [LinearGradient] and [RadialGradient].
![css-example-gradient.png][css-example-gradient]

Method onActionShowBackgroundXyGradient(String) in the class [ApplicationPresenter]
```java
private void onActionShowBackgroundXyGradient(String backgroundColor) {
    LoggerFacade.INSTANCE.debug(this.getClass(), "On action show Background XyGradient"); // NOI18N
        
    Platform.runLater(() -> {
//        final String _fx_base = "-fx-base: "; // NOI18N
//        final String _fx_background_color = "-fx-background-color: ";
//        final String _fx_control_inner_background = "-fx-control-inner-background: "; // NOI18N
//            
//        apBackground.setStyle(
//                _fx_base + backgroundColor
//                + _fx_background_color + backgroundColor
//                + _fx_control_inner_background + backgroundColor);
            
        apBackground.setStyle(backgroundColor);
    });
}
```


### TitledPane Tile<a name="TiPaTi" />

The [TitledPane] `Tile` allowed you to choose a [Tile] from one of the available 
tilesets. Momentary only the [Transparent Textures] tiles are available.

> __Definition__  
> A [Tile] is per definition a little transparent [Image] which overlay a 
> background-color or -image with the help of repetitions from the image in a 
> layer.


### _Tileset Transparent Textures_<a name="TrTe" />

The [Transparent Textures] tiles are from the webpage https://www.transparenttextures.com/ 
and are free to use. Momentary there are `396` tiles in the demo application available.

_Background:_ Winter sunset shinning through the trees &#040;Earth / Sunbeam&#041;  
_Tile:_ Subtle White Feathers by Viahorizon  
![demo-application-modified2.png][demo-application-modified2]

> __Hint__  
> The background image is taken from https://wall.alphacoders.com/big.php?i=723891 
> and is under the license from CCO Public Domain Image. Big thanks to the autor for 
> his great work :smiley:.  
> The tile image is taken from https://www.transparenttextures.com/ and is free 
> to use. Big thanks to the autor for his great work :smiley:. 

The tiles are loaded with the help from the enum [TransparentTexturesTile] which 
is included into the library [Lib-Tile-TransparentTextures].

Enum [TransparentTexturesTile]
```java
/**
 * The <code>enum</code> TransparentTexturesTile is a collection from 
 * {@link com.github.naoghuman.lib.tile.core.Tile}s which representated the 
 * <code>Tileset</code> from the internet page https://www.transparenttextures.com/.
 * <p />
 * The individual {@link com.github.naoghuman.lib.tile.core.Tile} can be loaded 
 * with the class {@link com.github.naoghuman.lib.tile.transparenttextures.images.TransparentTexturesTileLoader} 
 * from the associated library <code>Lib-Tile-TransparentTextures-Images</code>.
 *
 * @author Naoghuman
 * @see com.github.naoghuman.lib.tile.core.Tile
 * @see com.github.naoghuman.lib.tile.transparenttextures.images.TransparentTexturesTileLoader
 */
public enum TransparentTexturesTile implements Tile {

    /**
     * The <code>Java</code> representation from the tile: 3Px Tile
     */
    TT_3PX_TILE("tt-3px-tile.png", "3Px Tile", 100, 100, "Gre3g", "http://gre3g.livejournal.com/"), // NOI18N
    
    /**
     * The <code>Java</code> representation from the tile: 45 Degree Fabric (Dark)
     */
    TT_45_DEGREE_FABRIC_DARK("tt-45-degree-fabric-dark.png", "45 Degree Fabric (Dark)", 315, 315, "Atle Mo", "http://atle.co/"), // NOI18N
    
    // and 394 more tiles! :))

    TransparentTexturesTile(
            final String name, final String header,
            final double width, final double height,
            final String autor
    ) {
        this(name, header, width, height, autor, ""); // NOI18N
    }

    TransparentTexturesTile(
            final String imageName, final String title,
            final double width, final double height,
            final String autor, final String autorUrl
    ) {
        this.imageName = imageName;
        this.title = title;
        this.width = width;
        this.height = height;
        this.autor = autor;
        this.autorUrl = autorUrl;
    }

    ...
}
```

For more informations and examples plz see the [ReadMe from Lib-Tile-TransparentTextures].


### TitledPane About<a name="TiPaAb" />

The [TitledPane] `About` show informations like description, autor, webpage, 
license about the project `Lib-Tile-Demo`, the [Transparent Textures] and the 
used icons in this application.

_Image:_ TitledPane About  
![titledpane-about.png][titledpane-about]



Requirements<a name="Requirements" />
---

* On your system you need [JRE 8] or [JDK 8] installed.
* You should have downloaded the demo application :smiley:.



Installation<a name="Installation" />
---

* Current version is [Lib-Tile-Demo v0.2.0] &#040;08.27.2016&#041;.
* Download it and unzip the folder to a place of your choose.
* Doubleclick the jar file inside the folder and have fun :smiley:.



Contribution<a name="Contribution" />
---

* If you find a `Bug` I will be glad if you will report an [Issue].
* If you want to contribute to the project plz fork the project and do a [Pull Request].



License<a name="License" />
---

The project `Lib-Tile-Demo` is licensed under [General Public License 3.0].



Autor<a name="Autor" />
---

The project `Lib-Tile-Demo` is maintained by me, Peter Rogge. See [Contact](#Contact).



Contact<a name="Contact" />
---

You can reach me under <peter.rogge@yahoo.de>.



[//]: # (Images)
[css-example-gradient]:https://cloud.githubusercontent.com/assets/8161815/18015218/fbc532e2-6bc6-11e6-9962-3173e3ef5df2.png
[demo-application-modified]:https://cloud.githubusercontent.com/assets/8161815/18012188/bb3bfeda-6bb8-11e6-97e9-d627b1c80e1c.png
[demo-application-modified2]:https://cloud.githubusercontent.com/assets/8161815/18013152/2db5feda-6bbd-11e6-85ea-bc77e10581ac.png
[different-tile-images]:https://cloud.githubusercontent.com/assets/8161815/18012472/e352d8c0-6bb9-11e6-8e59-96d25178c269.png
[loaded-crimson-night]:https://cloud.githubusercontent.com/assets/8161815/18012699/f3811530-6bba-11e6-84ea-4ff6cd714d61.png
[no-image-icon]:https://cloud.githubusercontent.com/assets/8161815/18012898/c7953680-6bbb-11e6-8823-d849d9e2ec7a.png
[open-colorpicker]:https://cloud.githubusercontent.com/assets/8161815/18013011/6e172c0c-6bbc-11e6-9fa9-e094bd38f5e1.png
[titledpane-about]:https://cloud.githubusercontent.com/assets/8161815/18013460/6706f5da-6bbe-11e6-8d80-9e86abd4bc13.png



[//]: # (Links)
[AbstractTileLoader]:https://github.com/Naoghuman/lib-tile/blob/master/Lib-Tile-Core/src/main/java/com/github/naoghuman/lib/tile/core/AbstractTileLoader.java
[ApplicationPresenter]:https://github.com/Naoghuman/lib-tile-demo/blob/master/src/main/java/com/github/naoghuman/lib/tile/demo/application/ApplicationPresenter.java
[AQUAMARINE]:https://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html#AQUAMARINE
[Background]:https://docs.oracle.com/javase/8/javafx/api/javafx/scene/layout/Background.html
[ColorPicker]:https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/ColorPicker.html
[FileChooser]:https://docs.oracle.com/javase/8/javafx/api/javafx/stage/FileChooser.html
[General Public License 3.0]:http://www.gnu.org/licenses/gpl-3.0.en.html
[Image]:https://docs.oracle.com/javase/8/javafx/api/javafx/scene/image/Image.html
[Issue]:https://github.com/Naoghuman/Lib-Tile-Demo/issues
[JavaFX]:http://docs.oracle.com/javase/8/javase-clienttechnologies.htm
[JavaFX CSS Reference Guide]:https://docs.oracle.com/javase/8/javafx/api/javafx/scene/doc-files/cssref.html
[JDK 8]:http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
[JRE 8]:http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html
[Lib-Action]:https://github.com/Naoghuman/lib-action
[Lib-Logger]:https://github.com/Naoghuman/lib-logger
[Lib-Tile]:https://github.com/Naoghuman/lib-tile
[Lib-Tile-Core]:https://github.com/Naoghuman/lib-tile/blob/master/Lib-Tile-Core
[Lib-Tile-Demo v0.2.0]:https://github.com/Naoghuman/lib-tile-demo/releases
[Lib-Tile-TransparentTextures]:https://github.com/Naoghuman/lib-tile/tree/master/Lib-Tile-TransparentTextures
[Lib-Tile-TransparentTextures-Images]:https://github.com/Naoghuman/lib-tile/blob/master/Lib-Tile-TransparentTextures-Images
[LinearGradient]:https://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/LinearGradient.html
[Maven]:http://maven.apache.org/
[NetBeans IDE]:https://netbeans.org/
[Project-Templates]:https://github.com/Naoghuman/Project-Templates
[Pull Request]:https://help.github.com/articles/using-pull-requests
[RadialGradient]:https://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/RadialGradient.html
[RadioButton]:https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/RadioButton.html
[ReadMe from Lib-Tile-TransparentTextures]:https://github.com/Naoghuman/lib-tile/blob/master/Lib-Tile-TransparentTextures
[Seb Jachec]:http://twitter.com/iamsebj
[TextArea]:https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TextArea.html
[TextField]:https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TextField.html
[Tile]:https://github.com/Naoghuman/lib-tile/blob/master/Lib-Tile-Core/src/main/java/com/github/naoghuman/lib/tile/core/Tile.java
[TitledPane]:https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TitledPane.html
[Transparent Textures]:https://www.transparenttextures.com/
[TransparentTexturesTile]:https://github.com/Naoghuman/lib-tile/blob/master/Lib-Tile-TransparentTextures/src/main/java/com/github/naoghuman/lib/tile/transparenttextures/TransparentTexturesTile.java
[TransparentTexturesTileLoader]:https://github.com/Naoghuman/lib-tile/blob/master/Lib-Tile-TransparentTextures-Images/src/main/java/com/github/naoghuman/lib/tile/transparenttextures/images/TransparentTexturesTileLoader.java
