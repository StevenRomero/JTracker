package uitilities;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.apache.commons.io.IOUtils;

public final class FileUtil {
    
    	private FileUtil(){}

	public static File processImage(InputStream input) throws IOException {

		// Create a buffered image by reading in the upload
		BufferedImage originalImage = ImageIO.read(input);

		// Create a new image with the desired dimensions (180x180) and
		// re-draw the
		// original into the new canvas.
		BufferedImage bufferedScaledImage = new BufferedImage(180, 180,
				BufferedImage.TYPE_INT_BGR);
		bufferedScaledImage.createGraphics().drawImage(originalImage, 0, 0,
				180, 180, null);

		// Write the newly resized image out to a temporary file in PNG
		// format
		File image = new File("nasa.jpg");
		ImageIO.write(bufferedScaledImage, "jpg", image);

		return image;

	}

	public static File processVideo(InputStream input) throws IOException {

		BufferedInputStream buffInput = new BufferedInputStream(input);

		File video = new File("callofduty.avi");
		BufferedOutputStream output = new BufferedOutputStream(
				new FileOutputStream(video));

		IOUtils.copyLarge(buffInput, output);

		output.close();
		input.close();

		return video;

	}

}
