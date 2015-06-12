package grad.project.webservice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Arrays;

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

//		saveToFile(inputImage, "image.jpg");		
		
//		try {
//			BufferedImage image = ImageIO.read(inputImage);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

		SearchResults results = new SearchResults();
		results.setFoundObjects(Arrays.asList(new FoundObject(), new FoundObject()));

		return results;
	}

	private void saveToFile(InputStream input, String filePath){
		try {
			FileOutputStream out = new FileOutputStream(new File(filePath));
			
			byte[] bytes = new byte[1024];
			int read = 0;

			while((read = input.read(bytes)) != -1){
				out.write(bytes, 0, read);
			}

			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
