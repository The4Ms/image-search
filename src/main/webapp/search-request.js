// To be implemented by salah 
function loadSearchImageAsBinary(inputControl){

}

// To be implemented by salah 
function loadSearchImageAsDataURI(inputControl){

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