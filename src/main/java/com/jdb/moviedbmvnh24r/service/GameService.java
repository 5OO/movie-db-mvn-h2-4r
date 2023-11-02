package com.jdb.moviedbmvnh24r.service;

import com.jdb.moviedbmvnh24r.model.Movie;
import com.jdb.moviedbmvnh24r.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

@Service
public class GameService {
    private Random random = new Random();

    @Autowired
    private MovieService movieService;

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        String choice;
        int score = 0;
        do {



            System.out.println("Please choose the category: ");
            System.out.println("1 - vote_average, 2 - popularity, 3 - runtime, 4 - revenue: ");

            int category;
            do {
                category = scanner.nextInt();
                if (category < 1 || category > 4) {
                    System.out.println("Invalid category selection. Please choose a number between 1 and 4.");
                }
            } while (category < 1 || category > 4);

            // select two movies

            Movie firstMovie = getRandomMovie();
            Movie secondMovie = getRandomMovieWhileDifferentFrom(firstMovie);

            // asking for evaluation Higher or Lower

            while (true) {
                displayMovieComparison(firstMovie, secondMovie);

                System.out.println("Has the second film higher or lower " + category + " value ? ");
                System.out.println("Enter 8 for 'higher' or 2 for 'lower') ");
                int answer;
                do {
                    answer = scanner.nextInt();
                    if (answer != 8 && answer != 2) {
                        System.out.println("Invalid choice! Please enter 8 for 'higher' or 2 for 'lower'.");
                    }
                } while (answer != 8 && answer != 2);

                if (isAnswerCorrect(firstMovie, secondMovie, category, answer)) {
                    score++;
                    System.out.println(" Yes! Correct Answer! ");
                    System.out.println("Current score: " + score);
                    firstMovie = secondMovie;
                    secondMovie = getRandomMovieWhileDifferentFrom(firstMovie);
                } else {
                    System.out.println(" Wrong answer! Game is OVER!\r\n Your score was:" + score);
                    break;
                }
            }
            System.out.println("Would you like to play again? (Y/N)");
            choice = scanner.next().toLowerCase();
        } while ("y".equals(choice));
        System.out.println("Bye! Your score was: " + score + "\r\nCU!");
    }

    private Movie getRandomMovie() {
        List<Movie> allMovies = movieService.findAllMovies();
        return allMovies.get(this.random.nextInt(allMovies.size()));
    }

    private Movie getRandomMovieWhileDifferentFrom(Movie firstMovie) {
        Movie newMovie;
        do {
            newMovie = getRandomMovie();
        } while (newMovie.getId().equals(firstMovie.getId()));
        return newMovie;
    }

    private void displayMovieComparison(Movie firstMovie, Movie secondMovie) {
        System.out.println("1st movie " + firstMovie.getTitle() + " - " + firstMovie.getTagline());
        System.out.println("2nd movie " + secondMovie.getTitle() + " - " + secondMovie.getTagline());
    }

    private boolean isAnswerCorrect(Movie firstMovie, Movie secondMovie, int category, int answer) {
        BigDecimal firstValue = getCategoryValue(firstMovie, category);
        BigDecimal secondValue = getCategoryValue(secondMovie, category);

        return switch (answer) {
            case 8 -> // higher
                    secondValue.compareTo(firstValue) > 0;
            case 2 -> //lower
                    secondValue.compareTo(firstValue) < 0;
            default -> throw new IllegalStateException("Unexpected value: 8 - higher, 2 - lower " + answer);
        };
    }

    private BigDecimal getCategoryValue(Movie movie, int category) {

            return switch (category) {
                case 1 -> //  vote_average
                        movie.getVoteAverage();
                case 2 -> // popularity
                        movie.getPopularity();
                case 3 -> // runtime
                        movie.getRuntime();
                case 4 -> // revenue
                        BigDecimal.valueOf(movie.getRevenue());
                default -> throw new AssertionError("Unexpected value: " + category);
            };


    }
}
