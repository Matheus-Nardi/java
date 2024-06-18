package com.mafn.movie_libary.domain.models;

public enum Genre {

    ACTION(20, "Action"),
    ADVENTURE(21, "Adventure"),
    COMEDY(22, "Comedy"),
    DRAMA(23, "Drama"),
    FANTASY(24, "Fantasy"),
    HORROR(25, "Horror"),
    ROMANCE(26, "Romance"),
    SCIENCE_FICTION(27, "Science Fiction"),
    THRILLER(28, "Thriller");

    private final int id;
    private final String label;

    Genre(int id, String label) {
        this.id = id;
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }
    
    public static void showValues() {
    	for (Genre genre : values()) {
			System.out.println(genre.getId() + " - " + genre.getLabel());
		}
    }
    public static Genre valueOf(Integer id) {
    	for (Genre genre : values()) {
            if (genre.getId() == id) {
                return genre;
            }
        }
        throw new IllegalArgumentException("No matching Genre for id " + id);
    }
}
