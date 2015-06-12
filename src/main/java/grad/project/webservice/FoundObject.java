package grad.project.webservice;

import java.awt.Rectangle;
import java.util.List;

public class FoundObject {
	private Rectangle bounds;
	private List<String> similarImagesPaths;
	
	public Rectangle getBounds() {
		return bounds;
	}
	public void setBounds(Rectangle bounds) {
		this.bounds = bounds;
	}
	public List<String> getSimilarImagesPaths() {
		return similarImagesPaths;
	}
	public void setSimilarImagesPaths(List<String> similarImagesPaths) {
		this.similarImagesPaths = similarImagesPaths;
	}
}
