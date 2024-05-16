package javacore.ZZClambdas.model;

public class Anime {
	private String title;
	private Integer episodes;

	public Anime(String title, Integer episodes) {
		super();
		this.title = title;
		this.episodes = episodes;
	}

	public String getTitle() {
		return title;
	}

	public Integer getEpisodes() {
		return episodes;
	}

	@Override
	public String toString() {
		return "Anime [title=" + title + ", episodes=" + episodes + "]";
	}

}
