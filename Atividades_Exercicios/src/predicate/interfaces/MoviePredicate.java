package predicate.interfaces;

import predicate.model.Movie;

public interface MoviePredicate {
	boolean test(Movie movie);
}
