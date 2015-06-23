package grad.project.webservice;

import java.awt.Rectangle;
import java.util.List;

public class FoundObject {
	private int x;
	private int y;
	private int width;
	private int height;
	
	private List<String> similarImagesPaths;
	private String className;
	
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	
	public List<String> getSimilarImagesPaths() {
		return similarImagesPaths;
	}
	public void setSimilarImagesPaths(List<String> similarImagesPaths) {
		this.similarImagesPaths = similarImagesPaths;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	
}
