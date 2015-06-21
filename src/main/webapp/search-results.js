
<html>
<head>
</head>
<body>
<center>
<br> <br> <br> <br> <br> <br> <br> <br> <br> <b> Google Search<b> <br> <br> <br>
<form method="get" action="http://www.google.com/search"> 
<input type="text" name="q" size="31" maxlength="255" value="" /> 
<input type="submit" value="Google Search" /> 
</form>
</center>
<script>
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
</script>
</body>
</html>
