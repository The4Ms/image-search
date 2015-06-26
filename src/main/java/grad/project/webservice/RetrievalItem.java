package grad.project.webservice;

import java.awt.Rectangle;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.List;

public class RetrievalItem extends AbstractList<Double> implements Comparable<RetrievalItem>, Serializable {

	private static final long serialVersionUID = -3082823238024187424L;
	
	Rectangle bounds;
	List<Double> featureVector;
	String imageFile;
	
	
	public RetrievalItem(Rectangle bounds, List<Double> featureVector,
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


	public List<Double> getFeatureVector() {
		return featureVector;
	}


	public void setFeatureVector(List<Double> featureVector) {
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
	public Double get(int index) {
		return featureVector.get(index);
	}

	@Override
	public int size() {
		return featureVector.size();
	}
	
}
