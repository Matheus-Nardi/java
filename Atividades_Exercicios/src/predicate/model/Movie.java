package predicate.model;

import java.util.Objects;

public class Movie implements Comparable<Movie> {
	private String title;
	private Integer duration;
	private Integer lunchYear;
	public Movie(String title, Integer duration, Integer lunchYear) {
		super();
		this.title = title;
		this.duration = duration;
		this.lunchYear = lunchYear;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public Integer getLunchYear() {
		return lunchYear;
	}
	public void setLunchYear(Integer lunchYear) {
		this.lunchYear = lunchYear;
	}
	@Override
	public int hashCode() {
		return Objects.hash(duration, lunchYear, title);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		return Objects.equals(duration, other.duration) && Objects.equals(lunchYear, other.lunchYear)
				&& Objects.equals(title, other.title);
	}
	@Override
	public String toString() {
		return "Title: " + title + " Duration: " + duration + " LaunchYear: " + lunchYear;
	}
	@Override
	public int compareTo(Movie o) {
		return title.compareToIgnoreCase(o.getTitle());
	}
	
	
}
