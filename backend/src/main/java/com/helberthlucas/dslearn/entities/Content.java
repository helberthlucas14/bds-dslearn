package com.helberthlucas.dslearn.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_content")
public class Content extends Lesson {
	private static final long serialVersionUID = 1L;

	private String textContent;
	private String videoURI;
	
	public Content() {
	}
			
	public Content(String textContent, String videoURI) {
		super();
		this.textContent = textContent;
		this.videoURI = videoURI;
	}

	public String getTextContent() {
		return textContent;
	}
	public void setTextContent(String textContent) {
		this.textContent = textContent;
	}
	public String getVideoURI() {
		return videoURI;
	}
	public void setVideoURI(String videoURI) {
		this.videoURI = videoURI;
	}
	
	
}
