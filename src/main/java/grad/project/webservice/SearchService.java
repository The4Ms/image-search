package grad.project.webservice;

import grad.proj.utils.imaging.Image;
import grad.proj.utils.imaging.ImageLoader;

import java.io.InputStream;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

@Path("/search")
public class SearchService {

	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public SearchResults search(@FormDataParam("image") InputStream inputImage, 
			@FormDataParam("image") FormDataContentDisposition imageInfo){

		Image image = ImageLoader.loadImage(inputImage);
		SearchResults results = SearchHandler.getInstance().doSearch(image);

		return results;
	}

}
