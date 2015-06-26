 
function showResults(results){
	var foundObjects = results.foundObjects;
	document.getElementById('results');

	for(var i=0; i<foundObjects.length; i++){
		var object = foundObjects[i];

		var type = object.type;
		var extractedImageUrl = object.extractedImageUrl;
		var similarImagesUrls  = object.similarImagesUrls;

	var showData=document.createElement('div');
	var typeData=document.createElement('h1');
	typeData.innerHtml=type;
	alert("ssas");
	showData.appendChild(typeData);
	
	var extractedimg=document.createElement('img');
	extractedimg.src=extractedImageUrl;
	showData.appendChild(extractedimg);
	alert("ssasasaas");
	for(var j=0; j<similarImagesUrls.length; j++){
			var sim_arr=similarImagesUrls[j];
		alert("aaaa");
	var similarimg=document.createElement('h2');
		similarimg.innerHtml=sim_arr;
		similarimg.src=similarImagesUrls;
		similarimg.push(sim_arr);
		showData.appendChild(similarimg);
	}	
		alert("cc");
	results.appendChild(showData);
	
	}
		
}
