package cz.jantobola.blog.controller.common;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cz.jantobola.blog.controller.admin.UploadController;

@Controller
public class ResourceAccessorController {

	public static final String RESOURCE_PATH_PREFIX = UploadController.RESOURCE_PATH_PREFIX;
	public static final String HEADER_MIME_TYPE = "Content-Type";

	@ResponseBody
	@RequestMapping(value = "/resource/{folder}/{file:.*}", method = RequestMethod.GET)
	public HttpEntity<byte[]> getResource(@PathVariable("folder") String folder, @PathVariable("file") String file) throws IOException {

		String path = RESOURCE_PATH_PREFIX + folder + "/" + file;
		String ext = FilenameUtils.getExtension(path);

		return new HttpEntity<byte[]>(getByteArray(path), specifyHeaders(ext));
	}

	@ResponseBody
	@RequestMapping(value = "/resource/{width}/{height}/{folder}/{file:.*}", method = RequestMethod.GET)
	public HttpEntity<byte[]> generateThubnail(@PathVariable("width") int width, @PathVariable("height") int height, @PathVariable("folder") String folder,
			@PathVariable("file") String file, Model model) throws IOException {

		String path = RESOURCE_PATH_PREFIX + folder + "/" + file;
		String ext = FilenameUtils.getExtension(path);

		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		img.createGraphics().drawImage(ImageIO.read(new File(path)).getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);
		ImageIO.write(img, ext, baos);
		baos.flush();
		byte[] asByteArray = baos.toByteArray();
		baos.close();		

		return new HttpEntity<byte[]>(asByteArray, specifyHeaders(ext));
	}

	private HttpHeaders specifyHeaders(String extension) {
		MediaType type = getTypeByExtension(extension);

		HttpHeaders headers = new HttpHeaders();
		headers.set(HEADER_MIME_TYPE, type.toString());
		return headers;
	}

	private byte[] getByteArray(String path) throws IOException {
		return FileUtils.readFileToByteArray(new File(path));
	}

	/**
	 * Najit neco co uz tohle umi.
	 * 
	 * @param ext
	 * @return
	 */
	private MediaType getTypeByExtension(String ext) {

		switch (ext.toLowerCase()) {
		case "jpg":
			return MediaType.IMAGE_JPEG;

		case "jpeg":
			return MediaType.IMAGE_JPEG;

		case "png":
			return MediaType.IMAGE_PNG;

		case "gif":
			return MediaType.IMAGE_GIF;

		default:
			return null;
		}
	}

}
