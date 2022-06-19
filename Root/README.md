# Image-Processing

The goal of this program is to be able to take in an image, read it, mutate it, and create a new
image (PPM P3 file, or jpeg, png). To do so, we created:

## 1. A model with the following:

### A. Image interface
This interface can read and produce an image. Some methods can store properties of an
image (READ METHODS), like getHeight, getWidth and getPixel, and some methods can create a new image
based on the first one with some modifications such as flipVertically flipHorizontally, brightenBy
(and a few more) given a grid of pixels.
####  ImageImpl class
This class is the implementation of the Image interface. It contains implemented methods getHeight,
getWidth, getPixel, flipVertically flipHorizontally, brightenBy, redToGreyScale, greenToGreyScale,
and blueToGreyScale, valueToGreyScale, intensityToGreyScale, and lumaToGreyScale.

### B. Pixel interface
This interface stores RBG properties with methods getRedValue, getGreenValue, getBlueValue,
getValue, getIntensity and getLuma. These methods monitor the state of a pixel without changing
it as Pixels are considered immutable.
#### PixelImpl class
This class is the implementation of the Pixel interface. It represents a single picture as an image,
containing RBG values that vary between 0 and 255. Methods contained in this class are mentioned
above in the interface.

### C. ImageProcessingModel interface
This interface can read an image and mutate the state of an Image Processor Application. An Image
Processor Application can contain one or multiple images. The read method is getImage, the methods
that mutate an image or multiple images are addImage, flipHorizontally, flipVertically, brightenBy,
redToGreyScale, greenToGreyScale and blueToGreyScale.
#### ImageProcessingModelImpl class
This class implements the ImageProcessingModel interface. Other than addImage which is fully
implemented in this class, the rest of the methods redirect to imageImpl class, where they are
completely implemented.


## 2. A Controller with the following:

### A. ImageController interface
This interface represents a controller fot an Image Processing Application.
The controller gives the client the ability to read from a readable. Each line in the readable
contains a command.
####  ImageControllerImpl class
This class implements ImageController interface. It contains the following commands:  
commandViewToRenderWelcomeMessage, commandViewToRenderHelpMessage, runApplication,
intensityComponentCommand, lumaComponentCommand, valueComponentCommand, blueComponentCommand,
greenComponentCommand, redComponentCommand, brightenCommand, verticalFlipCommand,
horizontalFlipCommand, loadCommand, saveCommand, saveImage and loadImage.


## 3. A View with the following:

### A. ImageView interface
This interface represents operations that should be offered by a view for Image Processing.

####  ImageViewImpl class
This class acts as the view for an Image Processing Application. It contains method renderMessage. 

### All parts of the program are complete, the biggest design change was utilizing the command design pattern to reduce the size of the switch statement in the controller.



