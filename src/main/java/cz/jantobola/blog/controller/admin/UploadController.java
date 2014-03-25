package cz.jantobola.blog.controller.admin;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cz.jantobola.blog.controller.common.AbstractController;
import cz.jantobola.blog.domain.Article;
import cz.jantobola.blog.domain.MediaFile;
import cz.jantobola.blog.form.FileForm;
import cz.jantobola.blog.form.JQueryUploadResponse;
import cz.jantobola.blog.form.JQueryUploadResponseWrapper;
import cz.jantobola.blog.repository.ArticleRepository;
import cz.jantobola.blog.repository.MediaFileRepository;

@Controller
public class UploadController extends AbstractController {

	public static final String RESOURCE_PATH_PREFIX = "/Volumes/WORKSPACE/UPLOAD/";

	@Autowired
	private ArticleRepository articleRepository;
	
	@Autowired
	private MediaFileRepository mediaRepository;

	@ResponseBody
	@RequestMapping(value = "/admin/processUpload/{id}", method = RequestMethod.POST)
	public JQueryUploadResponseWrapper processUpload(@PathVariable Long id, @ModelAttribute("fileForm") FileForm fileForm, BindingResult result, Model model,
			HttpServletRequest request) throws IOException {

		String dirName = String.valueOf(id);

		File dir = new File(RESOURCE_PATH_PREFIX + dirName);
		if (!dir.exists()) {
			dir.mkdir();
		}

		MultipartFile file = fileForm.getFile();
		// resource path prefix will be in database
		String path = RESOURCE_PATH_PREFIX + dirName + "/" + file.getOriginalFilename();

		File saveFile = new File(path);
		FileUtils.writeByteArrayToFile(saveFile, file.getBytes());

		JQueryUploadResponse uploadResponse = new JQueryUploadResponse();
		uploadResponse.setName(file.getOriginalFilename());
		uploadResponse.setSize(file.getSize());
		uploadResponse.setDeleteType(RequestMethod.DELETE.name());
		uploadResponse.setDeleteUrl(request.getContextPath() + "/admin/upload/" + dirName + "/" + file.getOriginalFilename());
		uploadResponse.setUrl(request.getContextPath() + "/resource/" + dirName + "/" + file.getOriginalFilename());
		uploadResponse.setThumbnailUrl(request.getContextPath() + "/resource/80/50/" + dirName + "/" + file.getOriginalFilename());

		MediaFile mediaDB = persistFileInfo(id, uploadResponse);
		uploadResponse.setDeleteUrl(uploadResponse.getDeleteUrl() + "/" + mediaDB.getId());
		mediaDB.setDeleteUrl(mediaDB.getDeleteUrl() + "/" + mediaDB.getId());
		mediaRepository.save(mediaDB);

		JQueryUploadResponseWrapper jsonResponse = new JQueryUploadResponseWrapper();
		jsonResponse.getFiles().add(uploadResponse);

		return jsonResponse;
	}

	private MediaFile persistFileInfo(Long id, JQueryUploadResponse info) {
		Article article = articleRepository.findOne(id);
		MediaFile file = new MediaFile();
		
		file.setName(info.getName());
		file.setSize(info.getSize());
		file.setDeleteType(info.getDeleteType());
		file.setDeleteUrl(info.getDeleteUrl());
		file.setThumbnailUrl(info.getThumbnailUrl());
		file.setUrl(info.getUrl());
		file.setPage(article);
		
		mediaRepository.save(file);
		return file;
	}

	@ResponseBody
	@RequestMapping(value = "/admin/upload/{folder}/{file}/{mediaId}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteFile(@PathVariable("folder") String folder, @PathVariable("file") String file, @PathVariable("mediaId") Long mediaId,
			Model model) {
		
		File fileOnFS = new File(RESOURCE_PATH_PREFIX + folder + "/" + file);

		if (fileOnFS.delete()) {
			mediaRepository.delete(mediaId);
			return new ResponseEntity<String>(HttpStatus.OK);
		}

		return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
