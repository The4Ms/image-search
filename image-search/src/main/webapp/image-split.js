// To be implemented by salah 
function getSubImage(image, bounds){
var canvas = document.getElementById('myCanvas');
      var context = canvas.getContext('2d');
      var imageObj = new Image();

      imageObj.onload = function() {
        // draw cropped image
        var sourceX = bounds[0];
        var sourceY = bounds[1];
        var sourceWidth = bounds[2];
        var sourceHeight = bounds[3];
        var destWidth = sourceWidth;
        var destHeight = sourceHeight;
        var destX = canvas.width / 2 - destWidth / 2;
        var destY = canvas.height / 2 - destHeight / 2;

        context.drawImage(imageObj, sourceX, sourceY, sourceWidth, sourceHeight, destX, destY, destWidth, destHeight);
      };
      imageObj.src = image;
	  return imageObj;
//return 'data:image/jpeg;base64,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';
}