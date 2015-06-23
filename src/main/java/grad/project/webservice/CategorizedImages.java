package grad.project.webservice;

import grad.proj.utils.imaging.Image;

import java.util.List;

public interface CategorizedImages {
	ClassImages getClassImages(String name);
	String[] getClasses();
}
