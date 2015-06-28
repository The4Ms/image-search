package grad.project.webservice;

import grad.proj.classification.FeatureVector;

import java.awt.Rectangle;
import java.io.Serializable;
import java.util.Iterator;

public class RetrievalItem implements Comparable<RetrievalItem>, Serializable, FeatureVector {

	private static final long serialVersionUID = -3082823238024187424L;
	
	Rectangle bounds;
	FeatureVector featureVector;
	String imageFile;
	
	
	public RetrievalItem(Rectangle bounds, FeatureVector featureVector,
			String imageFile) {
		super();
		this.bounds = bounds;
		this.featureVector = featureVector;
		this.imageFile = imageFile;
	}

	public Rectangle getBounds() {
		return bounds;
	}


	public void setBounds(Rectangle bounds) {
		this.bounds = bounds;
	}


	public FeatureVector getFeatureVector() {
		return featureVector;
	}


	public void setFeatureVector(FeatureVector featureVector) {
		this.featureVector = featureVector;
	}


	public String getImageFile() {
		return imageFile;
	}


	public void setImageFile(String imageFile) {
		this.imageFile = imageFile;
	}


	@Override
	public int compareTo(RetrievalItem o) {
		int fileNameCompare = imageFile.compareTo(o.imageFile);
		if(fileNameCompare == 0){
			return bounds.equals(o.bounds) ? 0 : -1;
		}
		return fileNameCompare;
	}

	@Override
	public double get(int index) {
		return featureVector.get(index);
	}

	@Override
	public int size() {
		return featureVector.size();
	}

	@Override
	public Iterator<Double> iterator() {
		return featureVector.iterator();
	}

	@Override
	public void set(int index, double element) {
		featureVector.set(index, element);
	}
	
}
