package grad.project.webservice;

import grad.proj.utils.imaging.Image;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ClassImages {
	private List<Image> images;
	private List<File> files;
	
	public ClassImages(List<Image> images, List<File> files) {
		this.images = images;
		this.files = files;
	}
	
	public List<Image> getImages(){
		return images;
	}
	
	public List<String> getPathFor(List<Integer> indicies){
		List<String> paths = new ArrayList<String>(); 
		for(Integer index : indicies){
			paths.add(files.get(index).getName());
		}
		return paths;
	}
}
