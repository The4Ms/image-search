function clearResults(){
	var results = document.getElementById('results');
	results.innerHTML = '';
}

function showResults(results){
	clearResults();
	
	var foundObjects = results.foundObjects;
	var results = document.getElementById('results');

	for(var i=0; i<foundObjects.length; i++){
		var object = foundObjects[i];

		var type = object.type;
		var extractedImageUrl = object.extractedImageUrl;
		var similarImagesUrls  = object.similarImagesUrls;

		var showData = document.createElement('div');
		
		var typeData = document.createElement('h1');
		typeData.innerHTML = type;
		showData.appendChild(typeData);
		
		var extractedimg = document.createElement('img');
		extractedimg.src = extractedImageUrl;
		showData.appendChild(extractedimg);

		var typeData = document.createElement('h2');
		typeData.innerHTML = 'Similar images';
		showData.appendChild(typeData);
		
		for(var j=0; j<similarImagesUrls.length; j++){
			var similarImg = document.createElement('img');
			similarImg.src = similarImagesUrls[i];
			showData.appendChild(similarImg);
		}
		
		results.appendChild(showData);	
	}
}
