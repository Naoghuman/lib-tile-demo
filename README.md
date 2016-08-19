Lib-Tile-Demo
===



Intention
---

This project is a `demonstration` application to show the features from the 
project [Lib-Tile] and it's included sublibraries `lib-tile-core`, 
`lib-tile-transparenttextures` and `lib-tile-transparenttextures-images`.

The current `version` is `0.1.0` from MM.dd.2016.

<br />
_Background:_ Winter sunset shinning through the trees &#040;Earth / Sunbeam&#041;  
_Tile:_ Blu Stripes made by [Seb Jachec]  
![demo-application-modified.png][demo-application-modified]

> __Hint__  
> The background image is taken from https://wall.alphacoders.com/big.php?i=723891 
> and is under the license from CCO Public Domain Image. Big thanks to the autor for 
> his great work :smiley:.  
> The tile image is taken from https://www.transparenttextures.com/ and is free 
> to use. Big thanks to the autor for his great work :smiley:.  



<br />
Content
---

* [Features](#Features)
    - [TitledPane Background](#TiPaBa)  
      [_Background Image_](#BaIm)  
      [_Can't load Background Image_](#CaLoBaIm)  
      [_Background Color_](#BaCo)
    - [TitledPane Tile](#TiPaTi)  
      [_Transparent Textures_](#TrTe)
    - [TitledPane About](#TiPaAb)
* [Requirements](#Requirements)
* [Installation](#Installation)
* [Contribution](#Contribution)
* [License](#License)
* [Autor](#Autor)
* [Contact](#Contact)



<br />
Features<a name="Features" />
---

The main goal from this application is to demonstrate the features from the 
library [Lib-Tile] and its containing sub-libraries which are momentary 
`lib-core`, `lib-transparent-textures` and `lib-transparent-textures-images`.


<br />
### TitledPane Background<a name="TiPaBa" />

Over the [TitledPane] `Background` you can tweak the background image and / or 
the background color from the application.

<br />
### _Background Image_<a name="BaIm" />

With the [TextField] `Background image` the developer have the option to load 
an optional background image from the internet. Momentary only images from the 
internet are accepted. The loaded image will be `resized` to 1280x720.

For example use this link in the application:  
* https://cloud.githubusercontent.com/assets/8161815/17748160/601043ba-64b8-11e6-84dd-6e7075dbcf80.jpg

_Image:_ Loaded Crimson Night &#040;Dark / Landscape&#041;  
![loaded-crimson-night.png][loaded-crimson-night]

> __Hint__  
> This image is from the webpage https://wall.alphacoders.com. The image haven't 
> neither a `created by` or `shared by` flag &#040;see http://alphacoders.com/site/faq &#041;. 
> If anyone is the autor and won't that I use this image here in my open souce 
> project plz send me an email &#040;see [Contact](#Contact)&#041; and I will 
> remove it. Thanks for your great work :smiley:.

<br />
Clicking the button `Reset` removes the background image and clears the [TextField].

> __Hint__  
> For a future version I plan the option that the developer can also choose local 
> stored images via a [FileChooser].

<br />
### _Can't load Background Image_<a name="CaLoBaIm" />

In the case that it shouldn't be possible to load an [Image] into the demo 
application a `can't` load background image will be shown:

_Image:_ Can't load Background Image  
![cant-load-background-image.png][cant-load-background-image]

> __Hint__  
> The image is taken from https://www.iconfinder.com/icons/27836/approve_block_cancel_delete_reject_icon 
> and under the license: Creative Commons Attribution-No Derivative Works 3.0 
> Unported. Thanks for the great work :smiley:.

<br />
### _Background Color_<a name="BaCo" />

Momentary it's only possible to choose a `single` color over the [ColorPicker].

_Image:_ ColorPicker  
![open-colorpicker.png][open-colorpicker]

<br />
Clicking the button `Reset` reset the background color to the default color 
[AQUAMARINE].

> __Hint__  
> For a future version I plan to implement the option that the developer have the 
> option to define a [LinearGradient] or a [RadialGradient] colors as a 
> background color through `css` styling &#040;[JavaFX CSS Reference Guide]&#041;.


<br />
### TitledPane Tile<a name="TiPaTi" />

The [TitledPane] `Tile` allowed you to choose a [Tile] from one of the available 
tilesets. Momentary only the [Transparent Textures] tiles are available.

> __Reminder__  
> A [Tile] is per definition a little transparent [Image] which overlay a 
> background-color or -image with the help of repetitions from the image in a 
> layer.

<br />
### _Transparent Textures_<a name="TrTe" />

The [Transparent Textures] tiles are from the webpage https://www.transparenttextures.com/ 
and are free to use. Momentary there are `396` tiles in the demo application available.

The tiles are loaded with the help through the enum [TransparentTexturesTile] 
from the library [Lib-Tile-TransparentTextures].

_Enum_ TransparentTexturesTile
```Java
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
```

<br />
_Background:_ Winter sunset shinning through the trees &#040;Earth / Sunbeam&#041;  
_Tile:_ Subtle White Feathers by Viahorizon  
![demo-application-modified2.png][demo-application-modified2]

> __Hint__  
> The background image is taken from https://wall.alphacoders.com/big.php?i=723891 
> and is under the license from CCO Public Domain Image. Big thanks to the autor for 
> his great work :smiley:.  
> The tile image is taken from https://www.transparenttextures.com/ and is free 
> to use. Big thanks to the autor for his great work :smiley:. 



<br />
### TitledPane About<a name="TiPaAb" />

The [TitledPane] `About` show informations like description, autor, webpage, 
license about the project `Lib-Tile-Demo`, the [Transparent Textures] and the 
used icons in this application.

_Image:_ TitledPane About  
![titledpane-about.png][titledpane-about]



<br />
Requirements<a name="Requirements" />
---

* On your system you need [JRE 8] or [JDK 8] installed.
* You should have downloaded the demo application :smiley:.



<br />
Installation<a name="Installation" />
---

* Current version is [Lib-Tile-Demo v0.1.0] &#040;08.2016&#041;.
* Download it and unzip the folder to a place of your choose.
* Doubleclick the jar file inside the folder and have fun :smiley:.



<br />
Contribution<a name="Contribution" />
---

* If you find a `Bug` I will be glad if you will report an [Issue].
* If you want to contribute to the project plz fork the project and do a [Pull Request].



<br />
License<a name="License" />
---

The project `Lib-Tile-Demo` is licensed under [General Public License 3.0].



<br />
Autor<a name="Autor" />
---

The project `Lib-Tile-Demo` is maintained by me, Peter Rogge. See [Contact](#Contact).



<br />
Contact<a name="Contact" />
---

You can reach me under <peter.rogge@yahoo.de>.



[//]: # (Images)
[cant-load-background-image]:https://cloud.githubusercontent.com/assets/8161815/17814287/75c4604c-662f-11e6-8343-1f3aa844c5e6.png
[demo-application-default]:https://cloud.githubusercontent.com/assets/8161815/17342760/efe5803c-58fa-11e6-905b-f8a0d8ff856d.png
[demo-application-modified]:https://cloud.githubusercontent.com/assets/8161815/17342882/78c98ad8-58fb-11e6-8187-cd23bf50e3fd.jpg
[demo-application-modified2]:https://cloud.githubusercontent.com/assets/8161815/17816937/fbc190d2-663b-11e6-951b-5c9aedabc99a.png
[loaded-crimson-night]:https://cloud.githubusercontent.com/assets/8161815/17816075/99caeba2-6637-11e6-9b2e-b45dfe86057c.png
[open-colorpicker]:https://cloud.githubusercontent.com/assets/8161815/17674878/b3718380-6327-11e6-868f-7a7d5292031b.png
[titledpane-about]:https://cloud.githubusercontent.com/assets/8161815/17784549/377271a6-657d-11e6-85f1-7805c5bcd749.png



[//]: # (Links)
[AQUAMARINE]:https://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html#AQUAMARINE
[ColorPicker]:https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/ColorPicker.html
[FileChooser]:https://docs.oracle.com/javase/8/javafx/api/javafx/stage/FileChooser.html
[General Public License 3.0]:http://www.gnu.org/licenses/gpl-3.0.en.html
[Image]:https://docs.oracle.com/javase/8/javafx/api/javafx/scene/image/Image.html
[Issue]:https://github.com/Naoghuman/Lib-Tile-Demo/issues
[JavaFX CSS Reference Guide]:https://docs.oracle.com/javase/8/javafx/api/javafx/scene/doc-files/cssref.html
[JDK 8]:http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
[JRE 8]:http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html
[Lib-Tile]:https://github.com/Naoghuman/lib-tile
[Lib-Tile-Demo v0.1.0]:https://github.com/Naoghuman/lib-tile-demo/releases
[Lib-Tile-TransparentTextures]:https://github.com/Naoghuman/lib-tile/tree/master/Lib-Tile-TransparentTextures
[LinearGradient]:https://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/LinearGradient.html
[Pull Request]:https://help.github.com/articles/using-pull-requests
[RadialGradient]:https://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/RadialGradient.html
[Seb Jachec]:http://twitter.com/iamsebj
[TextField]:https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TextField.html
[Tile]:https://github.com/Naoghuman/lib-tile/blob/master/Lib-Tile-Core/src/main/java/com/github/naoghuman/lib/tile/core/Tile.java
[TitledPane]:https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TitledPane.html
[Transparent Textures]:https://www.transparenttextures.com/
[TransparentTexturesTile]:https://github.com/Naoghuman/lib-tile/blob/master/Lib-Tile-TransparentTextures/src/main/java/com/github/naoghuman/lib/tile/transparenttextures/TransparentTexturesTile.java