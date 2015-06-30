function clearResults(){
	var results = document.getElementById('results');
	results.innerHTML = '';
}

function showResults(results){
	clearResults();
	
	var template = document.getElementById('resultTemplate').innerHTML;
	Mustache.parse(template);
	var renderedResults = Mustache.render(template, results);
	
	var resultsTag = document.getElementById('results');
	resultsTag.innerHTML = renderedResults;
}

function showResults2(results){
	var foundObjects = results.foundObjects;
	var results = document.getElementById('results');

	for(var i=0; i<foundObjects.length; i++){
		var object = foundObjects[i];

		var className = object.className;
		var extractedImageUrl = object.extractedImageUrl;
		var similarImagesUrls  = object.similarImagesPaths;

		var singleResultTag = document.createElement('div');
		singleResultTag.className = 'col-md-10 col-md-offset-1';
		
		var classNameTag = document.createElement('h1');
		classNameTag.innerHTML = className;
		classNameTag.className = 'page-header';
		
		singleResultTag.appendChild(classNameTag);
		
		var extractedImgTag = document.createElement('img');
		extractedImgTag.className = 'thumbnail';
		extractedImgTag.src = extractedImageUrl;
		singleResultTag.appendChild(extractedImgTag);

		var similarLabelTag = document.createElement('h2');
		similarLabelTag.innerHTML = 'Similar images';
		singleResultTag.appendChild(similarLabelTag);
		
		for(var j=0; j<similarImagesUrls.length; j++){
			var similarImg = document.createElement('img');
			similarImg.className = 'img-thumbnail'
			similarImg.src = similarImagesUrls[j];
			singleResultTag.appendChild(similarImg);
		}
		
		results.appendChild(singleResultTag);
	}
}
