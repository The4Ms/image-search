package grad.project.webservice;

import grad.proj.utils.FilesImageList;
import grad.proj.utils.imaging.Image;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.List;

public class FolderCategorizedImages implements CategorizedImages{
	private File folder;
	
	public FolderCategorizedImages(File folder) {
		this.folder = folder;
	}

	@Override
	public ClassImages getClassImages(String name) {
		File[] imagesFiles = new File(folder, name).listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return new File(dir, name).isDirectory();
			}
		});
		List<File> imagesFilesList =  Arrays.asList(imagesFiles);
		return new ClassImages(new FilesImageList(imagesFilesList), imagesFilesList);
	}

	@Override
	public String[] getClasses() {
		return folder.list(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return new File(dir, name).isDirectory();
			}
		});
	}

}
