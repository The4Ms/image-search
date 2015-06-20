// To be implemented by salah 
function loadSearchImageAsBinary(inputControl){
var imgReq = new XMLHttpRequest();
imgReq.open("GET", inputControl, true);
imgReq.responseType = "arraybuffer";

imgReq.onload = function (oEvent) {
  var arrayBuffer = imgReq.response; 
  if (arrayBuffer) {
    var byteArray = new Uint8Array(arrayBuffer);
  }
};
return byteArray;
}

// To be implemented by salah 
function loadSearchImageAsDataURI(inputControl){
var can = document.getElementById('canvas');
        var ctx = can.getContext('2d');
         
        var img = new Image();
		img.src = inputControl;
        img.onload = function (){
			
            can.width = img.width;
            can.height = img.height;
            ctx.drawImage(img, 0, 0, img.width, img.height);
		  
};
       var dataURL = canvas.toDataURL(inputControl);
       alert( dataURL.replace(/^data:image\/(png|jpg);base64,/, ""));
	   return dataURL;
}

// To be implemented by kamaly 
function doSearchRequest(){
	// return dummy data to be used in implementation
	// extractedImageUrl should be added after splitting images, it is put here so that search-results work don't wait for image-split work
	return {
		'foundObjects': [{
			'type': 'bike',
			'bounds': {
				'x': 0,
				'y': 0,
				'width': 10,
				'height': 10
			}, 
			'extractedImageUrl': 'dummyImages/bikeExtracted.jpg',
			'similarImagesUrls': [
				"dummyImages/bike1.jpg",
				"dummyImages/bike2.jpg"
			]
		}, {
			'type': 'apple',
			'bounds': {
				'x': 40,
				'y': 40,
				'width': 100,
				'height': 200
			}, 
			'extractedImageUrl': 'dummyImages/appleExtracted.jpg',
			'similarImagesUrls': [
				"dummyImages/apple1.jpg",
				"dummyImages/apple2.jpg"
			]
		}]
	};
}