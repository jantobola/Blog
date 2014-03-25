package cz.jantobola.blog.form;

import java.util.ArrayList;
import java.util.List;

import cz.jantobola.blog.domain.MediaFile;

public class JQueryUploadResponseWrapper {
	
	private List<JQueryUploadResponse> files;

	public List<JQueryUploadResponse> getFiles() {
		if(files == null){
			files = new ArrayList<JQueryUploadResponse>();
		}
		return files;
	}

	public void setFiles(List<JQueryUploadResponse> files) {
		this.files = files;
	}
	
	public void assembleFiles(List<MediaFile> media) {
		for (MediaFile mediaFile : media) {
			JQueryUploadResponse response = new JQueryUploadResponse();
			response.setDeleteType(mediaFile.getDeleteType());
			response.setDeleteUrl(mediaFile.getDeleteUrl());
			response.setName(mediaFile.getName());
			response.setSize(mediaFile.getSize());
			response.setThumbnailUrl(mediaFile.getThumbnailUrl());
			response.setUrl(mediaFile.getUrl());
			
			getFiles().add(response);
		}
	}

}
