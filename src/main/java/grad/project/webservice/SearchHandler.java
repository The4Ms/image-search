package grad.project.webservice;

import grad.proj.localization.ObjectsLocalizer;
import grad.proj.localization.impl.SlidingWindowObjectLocalizer;
import grad.proj.matching.ImageMatcher;
import grad.proj.matching.MeanSquareErrorMatcher;
import grad.proj.recognition.FeatureVectorClassifier;
import grad.proj.recognition.FeatureVectorGenerator;
import grad.proj.recognition.ImageClassifier;
import grad.proj.utils.DataSetLoader;
import grad.proj.utils.imaging.Image;
import grad.proj.utils.opencv.Loader;

import java.io.File;

public class SearchHandler {
	private DataSetLoader dataSetLoader;
	
	private FeatureVectorGenerator generator;
	private FeatureVectorClassifier vecClassifier;
	
	private ImageClassifier classifier;
	
	private ObjectsLocalizer localizer;
	
	private ImageMatcher matcher;
		
	public void init(String datasetFolder){
		Loader.load();
		
		dataSetLoader = new DataSetLoader(new File(datasetFolder));
		
		classifier = dataSetLoader.loadTrainedClassifier();
		
		generator = classifier.getFeatureVectorGenerator();
		
		localizer = new ObjectsLocalizer(new SlidingWindowObjectLocalizer(), classifier);
		
		matcher = new ImageMatcher(generator, new MeanSquareErrorMatcher());
	}
	
	public SearchResults doSearch(Image image){
		return null;
	}
	
	
	// Singleton access
	private static SearchHandler instance;
	
	public static SearchHandler getInstance(){
		if(instance == null)
			instance = new SearchHandler();
		return instance;
	}
}
