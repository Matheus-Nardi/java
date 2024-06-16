package com.mafn.movie_libary.domain.models;

public enum Genre {

    ACTION(1, "Action"),
    ADVENTURE(2, "Adventure"),
    COMEDY(3, "Comedy"),
    DRAMA(4, "Drama"),
    FANTASY(5, "Fantasy"),
    HORROR(6, "Horror"),
    ROMANCE(7, "Romance"),
    SCIENCE_FICTION(8, "Science Fiction"),
    THRILLER(9, "Thriller");

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
}
