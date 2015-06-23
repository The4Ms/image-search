package grad.project.webservice;

import grad.proj.utils.imaging.Image;

import java.util.List;

public interface CategorizedImages {
	List<Image> getClassImages(String name);
	String[] getClasses();
}
