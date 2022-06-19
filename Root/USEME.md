# USEME File

**All script commands supported by the application are listed below:**
+ load image-path image-name
+ save image-path image-name
+ red-component image-name dest-image-name 
+ green-component image-name dest-image-name
+ blue-component image-name dest-image-name
+ value-component image-name dest-image-name
+ luma-component image-name dest-image-name
+ intensty-component image-name dest-image-name
+ blur image-name dest-image-name
+ sharpen image-name dest-image-name
+ greyscale image-name dest-image-name
+ sepia image-name dest-image-name
+ h-flip image-name dest-image-name
+ v-flip image-name dest-image-name
+ brighten amount image-name dest-image-name
+ file script-file-name.txt
+ quit
+ help

**Conditions**

1) image-path must be valid
2) script-file-name.txt must exist
3) image-name must have been previously created/specified to be used


**An example of using these commands is the following script file:**

load res/board.png board

blur board blurredBoard

save res/blurredBoard.jpeg blurredBoard

brighten 10 board board-brighter

sharpen board sharpenedBoard

save res/sharpenedBoard.png sharpenedBoard

greyscale board greyscaleBoard

save res/greyscaleBoard.png greyscaleBoard

sepia board sepiaBoard

save res/sepiaBoard.png sepiaBoard

help

red-component board red-grey-board

green-component board green-grey-board

blue-component board blue-grey-board

value-component board value-grey-board

luma-component board luma-grey-board

intensity-component board intensity-grey-board

h-flip board h-flip-board

v-flip board v-flip-board

quit
