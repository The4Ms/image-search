// To be implemented by salah 
//function loadSearchImageAsBinary(inputControl){
//	var xhr = new XMLHttpRequest();
//	xhr.open('GET', inputControl, true);
//	xhr.responseType = 'arraybuffer';
//	
//	xhr.onload = function(e) {
//	  
//	  var responseArray = new Uint8Array(this.response); 
//	};
//	
//	xhr.send();
////ctx.drawImage(img, 0, 0, img.width, img.height); 
// return responseArray; 
//}

// To be implemented by salah

function loadSearchImageAsDataURI(inputControl, outputImage, callback){
	if(FileReader){
		var fr = new FileReader();
		fr.onload = function(){
			outputImage.src = fr.result;
			callback(outputImage);
		};
		fr.readAsDataURL(inputControl.files[0]);
	}
}

// To be implemented by kamaly 
function doSearchRequest(imageInputControl, callback){
	// return dummy data to be used in implementation
	// extractedImageUrl should be added after splitting images, it is put here so that search-results work don't wait for image-split work
	callback({
		'foundObjects': [{
			'type': 'bike',
			'x': 0,
			'y': 0,
			'width': 300,
			'height': 400, 
			'extractedImageUrl': 'dummyImages/bikeExtracted.jpg',
			'similarImagesUrls': [
				"dummyImages/bike1.png",
				"dummyImages/bike2.png"
			]
		}, {
			'type': 'apple',
			'x': 600,
			'y': 600,
			'width': 500,
			'height': 500,
			'extractedImageUrl': 'dummyImages/appleExtracted.jpg',
			'similarImagesUrls': [
				"dummyImages/apple1.png",
				"dummyImages/apple2.png"
			]
		}]
	});
}