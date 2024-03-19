package com.example.exercises;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.example.domain.Director;
import com.example.domain.Movie;
import com.example.service.InMemoryMovieService;
import com.example.service.MovieService;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise1 {
	private static final MovieService movieService = InMemoryMovieService.getInstance();

	public static void main(String[] args) {
		// Find the number of movies of each director
        final Collection<Movie> movies = movieService.findAllMovies();
        Map<Director,Long> directorsMovieCount =
        movies.stream() 								// Stream<Movie>
              //.map(movie -> movie.getDirectors())     
              .map(Movie::getDirectors)                 // Stream<List<Director>>
              .flatMap(List::stream)					// Stream<Director> 
              .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        
        directorsMovieCount.forEach((director,movieCount)->System.out.println("%s: %d".formatted(director.getName(),movieCount)));      
	}

}
