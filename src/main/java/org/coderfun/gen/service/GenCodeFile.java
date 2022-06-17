package org.coderfun.gen.service;

public class GenCodeFile {
	private String name;
	/**
	 * "/"开头,同时"/"结束
	 */
	private String path;
	private String content;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
