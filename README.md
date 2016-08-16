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
      [_Background Color_](#BaCo)
    - [TitledPane Tile](#TiPaTi)  
      [_Transparent Textures_](#TrTe)
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
internet are accepted with the size from 1280x720.

_For example:_  
* TODO add example link

<br />
_Image:_ TODO add image description  
TODO add image

<br />
Clicking the button `Reset` removes the background image and clears the content 
from the [TextField].

<br />
_Hint:_  
For a future version I plan the option that the developer can also choose local 
stored images via a [FileChooser].

<br />
### _Background Color_<a name="BaCo" />

Momentary it's only possible to choose a `single` color over the [ColorPicker].

<br />
_Image:_ ColorPicker  
![open-colorpicker.png][open-colorpicker]

<br />
Clicking the button `Reset` reset the background color to the default color 
[AQUAMARINE].

<br />
_Hint:_  
For a future version I plan to implement the option that the developer have the 
option to define a [LinearGradient] or a [RadialGradient] colors as a 
background color through `css` styling &#040;[JavaFX CSS Reference Guide]&#041;.


<br />
### TitledPane Tile<a name="TiPaTi" />

TODO


<br />
### _Transparent Textures_<a name="TrTe" />

TODO



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
[open-colorpicker]:https://cloud.githubusercontent.com/assets/8161815/17674878/b3718380-6327-11e6-868f-7a7d5292031b.png
[demo-application-default]:https://cloud.githubusercontent.com/assets/8161815/17342760/efe5803c-58fa-11e6-905b-f8a0d8ff856d.png
[demo-application-modified]:https://cloud.githubusercontent.com/assets/8161815/17342882/78c98ad8-58fb-11e6-8187-cd23bf50e3fd.jpg



[//]: # (Links)
[AQUAMARINE]:https://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html#AQUAMARINE
[ColorPicker]:https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/ColorPicker.html
[FileChooser]:https://docs.oracle.com/javase/8/javafx/api/javafx/stage/FileChooser.html
[General Public License 3.0]:http://www.gnu.org/licenses/gpl-3.0.en.html
[JavaFX CSS Reference Guide]:https://docs.oracle.com/javase/8/javafx/api/javafx/scene/doc-files/cssref.html
[Lib-Tile]:https://github.com/Naoghuman/lib-tile
[LinearGradient]:https://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/LinearGradient.html
[RadialGradient]:https://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/RadialGradient.html
[Seb Jachec]:http://twitter.com/iamsebj
[TextField]:https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TextField.html
[TitledPane]:https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TitledPane.html
