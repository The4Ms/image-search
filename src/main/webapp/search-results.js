
// To be implemented by yusuf 
function showResults(results){
	var foundObjects = results.foundObjects;

	// this to show you the structure of the results object

	for(var i=0; i<foundObjects.length; i++){
		var object = foundObjects[i];

		var type = object.type;
		var extractedImageUrl = object.extractedImageUrl;
		var similarImagesUrls  = object.similarImagesUrls;

		console.log('object no ' + i);
		console.log('type: ' + type);
		console.log('extractedImageUrl: ' + extractedImageUrl);
		console.log('similarImagesUrls: ');

		for(var j=0; j<similarImagesUrls.length; j++){
			console.log(similarImagesUrls[j]);
		}
	}
}