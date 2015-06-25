package grad.project.webservice;

import grad.proj.localization.ObjectsLocalizer;
import grad.proj.localization.impl.BranchAndBoundObjectLocalizer;
import grad.proj.localization.impl.MaxRectangleQualityFunction;
import grad.proj.matching.ImageMatcher;
import grad.proj.matching.MeanSquareErrorMatcher;
import grad.proj.classification.FeatureVectorGenerator;
import grad.proj.classification.ImageClassifier;
import grad.proj.utils.DataSetLoader;
import grad.proj.utils.imaging.Image;
import grad.proj.utils.imaging.SubImage;
import grad.proj.utils.opencv.Loader;

import java.awt.Rectangle;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SearchHandler {
	private DataSetLoader dataSetLoader;
	
	private FeatureVectorGenerator generator;
	
	private ImageClassifier classifier;
	
	private ObjectsLocalizer localizer;
	
	private ImageMatcher matcher;
	
	private CategorizedImages retrievalImages;
		
	public void init(String datasetFolder, String retrievalImagesFolder){
		Loader.load();
		
		dataSetLoader = new DataSetLoader(new File(datasetFolder));
		
		classifier = dataSetLoader.loadTrainedClassifier();
		
		if(classifier == null){
			dataSetLoader.generateAndSave();
			classifier = dataSetLoader.loadTrainedClassifier();			
		}
		
		generator = classifier.getFeatureVectorGenerator();
		
		localizer = new ObjectsLocalizer(new BranchAndBoundObjectLocalizer(new MaxRectangleQualityFunction()), classifier);
		
		matcher = new ImageMatcher(generator, new MeanSquareErrorMatcher());
		retrievalImages = new FolderCategorizedImages(new File(retrievalImagesFolder));
	}
	
	public SearchResults doSearch(Image image){
		Map<String, Rectangle> objectsBounds = localizer.getObjectsBounds(image);
		
		List<FoundObject> foundObjects = new ArrayList<FoundObject>();
		
		for(Entry<String, Rectangle> boundsEntry : objectsBounds.entrySet()){
			String classLabel = boundsEntry.getKey();
			Rectangle bounds = boundsEntry.getValue();
			
			System.err.println(classLabel + " " + bounds.toString());
			
			Image objectImage = new SubImage(image, bounds.x, bounds.y, bounds.width, bounds.height);
			
			ClassImages classImages = retrievalImages.getClassImages(classLabel);
			
			List<Integer> topMatches = matcher.match(objectImage, classImages.getImages(), 5);
			List<String> topMatchesPaths = classImages.getPathFor(topMatches);
			
			FoundObject obj = new FoundObject();
			obj.setClassName(classLabel);
			obj.setX(bounds.x);
			obj.setY(bounds.y);
			obj.setWidth(bounds.width);
			obj.setHeight(bounds.height);
			obj.setSimilarImagesPaths(topMatchesPaths);
			
			foundObjects.add(obj);
		}
		
		SearchResults results = new SearchResults();
		results.setFoundObjects(foundObjects);
		
		return results;
	}
	
	
	// Singleton access
	private static SearchHandler instance;
	
	public static SearchHandler getInstance(){
		if(instance == null)
			instance = new SearchHandler();
		return instance;
	}
}
