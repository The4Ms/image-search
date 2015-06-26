// To be implemented by salah 
var getSubImage = (function(){
	var canvas = document.createElement('canvas');
	var context = canvas.getContext('2d');

	return function(image, bounds){
		// draw cropped image on the canvas
		context.drawImage(image, bounds.x, bounds.y, bounds.width, bounds.height, 0, 0, bounds.width, bounds.height);

		// get canvas data in DataURL format
		var dataURL = canvas.toDataURL();

		// clear the canvas
		context.clearRect(0, 0, bounds.width, bounds.height);

		return dataURL;
	}
})();