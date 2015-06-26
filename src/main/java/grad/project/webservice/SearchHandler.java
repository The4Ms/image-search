package grad.project.webservice;

import grad.proj.localization.ObjectsLocalizer;
import grad.proj.localization.impl.BranchAndBoundObjectLocalizer;
import grad.proj.localization.impl.MaxRectangleQualityFunction;
import grad.proj.matching.Matcher;
import grad.proj.matching.MeanSquareErrorMatcher;
import grad.proj.classification.FeatureVectorGenerator;
import grad.proj.classification.ImageClassifier;
import grad.proj.utils.DataSetLoader;
import grad.proj.utils.imaging.Image;
import grad.proj.utils.imaging.ImageLoader;
import grad.proj.utils.imaging.SubImage;
import grad.proj.utils.opencv.Loader;

import java.awt.Rectangle;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.mapdb.DB;
import org.mapdb.DBMaker;

public class SearchHandler {
	private DataSetLoader dataSetLoader;
	
	private FeatureVectorGenerator generator;
	
	private ImageClassifier classifier;
	
	private ObjectsLocalizer localizer;
	
	private Matcher<List<Double>> matcher;

	private DB db;

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
		
		matcher = new MeanSquareErrorMatcher();
		
		File dbFile = new File("cachedRetrieval");
		boolean reCreate = !dbFile.exists();
		
		db = DBMaker
				.newFileDB(dbFile)
				.make();

		System.out.println("building Db");
		if(reCreate){
			buildRetrievalDB(new File(retrievalImagesFolder));
		}
		System.out.println("loaded");
	}
	
	public void buildRetrievalDB(File retrievalImagesFolder){
		for(File imageFile : retrievalImagesFolder.listFiles()){
			Image image = ImageLoader.loadImage(imageFile);
			Map<String, Rectangle> objectsBounds = localizer.getObjectsBounds(image);
			for(Entry<String, Rectangle> foundObj : objectsBounds.entrySet()){
				String className = foundObj.getKey();
				Rectangle bounds = foundObj.getValue();
				Image foundSubImage = new SubImage(image, bounds.x, bounds.y, bounds.width, bounds.height);
				List<Double> featureVector = generator.generateFeatureVector(foundSubImage);
				
				Set<RetrievalItem> classDb = db.getHashSet(className);
				classDb.add(new RetrievalItem(bounds, featureVector, imageFile.getName()));
				System.out.println(className + " " + classDb.size());
			}
		}
		db.commit();
	}
	
	public SearchResults doSearch(Image image){
		System.out.println("Starting search");
		Map<String, Rectangle> objectsBounds = localizer.getObjectsBounds(image);

		System.out.println("Done search");
		
		List<FoundObject> foundObjects = new ArrayList<FoundObject>();
		
		for(Entry<String, Rectangle> boundsEntry : objectsBounds.entrySet()){
			String classLabel = boundsEntry.getKey();
			Rectangle bounds = boundsEntry.getValue();
			
			System.out.println("Matching for :" + classLabel + " " + bounds.toString());
			
			Image objectImage = new SubImage(image, bounds.x, bounds.y, bounds.width, bounds.height);
			
			List<Double> objectImageFeature = generator.generateFeatureVector(objectImage);
			Set<RetrievalItem> classDb = db.getHashSet(classLabel);
			
			List<RetrievalItem> topMatches = matcher.match(objectImageFeature, classDb, 5);

			System.out.println("Found  :" + topMatches.size() + " matches in " + classDb.size());
			
			List<String> topMatchesPaths = new ArrayList<>();
			for(RetrievalItem item : topMatches)
				topMatchesPaths.add(item.getImageFile());

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
