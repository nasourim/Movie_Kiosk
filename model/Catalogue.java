package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Catalogue {

    private final Kiosk kiosk;
    private static ObservableList<model.Movie> moviesAvailable = null;
    private static ObservableList<model.Movie> moviesRented = null;
    private static ObservableList<model.Genre> genres = null;

    public Catalogue(Kiosk kiosk) {
        this.kiosk = kiosk;
        moviesAvailable = FXCollections.observableArrayList();
        moviesRented = FXCollections.observableArrayList();
        genres = FXCollections.observableArrayList();
                
        //DATA BASE OF MOVIES
        model.Genre g = new model.Genre("SciFi");
        addGenre(g);
        
        moviesAvailable.add(new model.Movie("Matrix", 1999, g, 3));
        moviesAvailable.add(new model.Movie("Jurassic Park", 1993, g, 4));
        moviesAvailable.add(new model.Movie("Terminator 2", 1991, g, 3));
        
        g = new model.Genre("Drama");
        addGenre(g);
        
        moviesAvailable.add(new model.Movie("Titanic", 1997, g, 4));
        
        g = new model.Genre("Crime");
        addGenre(g);
        moviesAvailable.add(new model.Movie("The Silence of the Lambs", 1991, g, 3));
        
    }


    private void addMovie(model.Movie movie) {

        if (!moviesAvailable.contains(movie))
            moviesAvailable.add(movie);

    }

    public void addMovie(String title, int year, String genre, int price) {
        model.Genre g = oldGenre(genre) ? retrieveGenre(genre) : new model.Genre(genre);
        addGenre(g);

        this.addMovie(new model.Movie(title, year, g, price));
    }

    private void addGenre(model.Genre genre) {

        if (!genres.contains(genre))
            genres.add(genre);

    }

    public static ObservableList<model.Movie> getAllMovies() {

        ObservableList<model.Movie> allMovies = FXCollections.observableArrayList();
        allMovies.addAll(moviesRented);
        allMovies.addAll(moviesAvailable);        
        return allMovies;
    }

    public static ObservableList<model.Movie> getAvailableMovies() {
        return moviesAvailable;
    }

    private model.Movie getMovieByTitle(String title) {
        for (model.Movie b : getAllMovies()) {
            if (b.titleMatches(title))
                return b;
        }

        return null;
    }

    public boolean rentMovieToCustomer(model.Movie movie, model.Customer customer) {
        if(customer.getBalance() >= movie.getPrice()) {
            customer.rentMovie(movie);
            customer.deductAmount(movie.getPrice());
            moviesRented.add(movie);
            moviesAvailable.remove(movie); 
            return true;
        }
        return false;
    }

    private boolean oldGenre(String genre) {

        for (model.Genre g : genres) {
            if (g.isSameGenreAs(genre))
                return true;
        }

        return false;
    }

    private model.Genre retrieveGenre(String genre) {

        for (model.Genre g : genres) {
            if (g.isSameGenreAs(genre))
                return g;
        }

        return null;
    }

    public boolean returnMovieFromCustomer(model.Movie movie, model.Customer customer) {

        if (customer.hasMovie(movie)) {

            customer.returnMovie(movie);
            moviesRented.remove(movie);
            moviesAvailable.add(movie);
            return true;

        }
        return false;
    }
    
    public boolean hasMovie(String title, int year) {

        for (model.Movie m : getAllMovies()) {
            if (m.titleMatches(title) && m.getYear() == year) {
                return true;
            }
        }

        return false;
    }
    
    public static void removeMovie(model.Movie movie) {
        moviesAvailable.remove(movie);
        model.Genre genre = movie.getGenre();
         
         if (getMoviesInGenre(genre).isEmpty()) {
            genres.remove(genre);
        }
    }
   
    public static ObservableList<model.Movie> getMoviesInGenre(model.Genre genre) {
        ObservableList<model.Movie> moviesInGenre = FXCollections.observableArrayList();

        for (model.Movie m : getAllMovies()) {
            if (m.getGenre().isSameGenreAs(genre)) {
                moviesInGenre.add(m);
            }
        }

        return moviesInGenre;
    }
          
    public ObservableList<model.Movie> getMoviesByYear(int year) {

       ObservableList<model.Movie> moviesByYear = FXCollections.observableArrayList();

        for (model.Movie m : getAllMovies()) {
            if (m.getYear() == year) {
                moviesByYear.add(m);
            }
        }
        
        return moviesByYear;     
    }

    public static ObservableList<model.Genre> getGenres() {
        return genres;
    }
    
    public ObservableList<Integer> getYears() {
        ObservableList<Integer> availableYears = FXCollections.observableArrayList();

        for (model.Movie m : getAllMovies()) {
            int year = m.getYear();
            if(!availableYears.contains(year))
                availableYears.add(year);
            
        }
        
        return availableYears;    
    }
    
    public model.Customer getCustomer(int id) {
        return this.kiosk.getCustomer(id);
    }
}
