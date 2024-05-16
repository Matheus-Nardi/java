package javacore.ZZDoptional.model;

public class Manga {
	private Integer id;
	private String title;
	private Integer chapters;

	public Manga(Integer id, String title, Integer chapters) {
		super();
		this.id = id;
		this.title = title;
		this.chapters = chapters;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setChapters(Integer chapters) {
		this.chapters = chapters;
	}

	public Integer getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public Integer getChapters() {
		return chapters;
	}

	@Override
	public String toString() {
		return "Manga [id=" + id + ", title=" + title + ", chapters=" + chapters + "]";
	}
	
	
}
