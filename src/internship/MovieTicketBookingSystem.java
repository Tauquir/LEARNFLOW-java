package internship;

import java.util.*;

public class MovieTicketBookingSystem {
    static Map<String, Movie> movies = initializeMovies();
    static Map<String, Showtime> showtimes = initializeShowtimes();

    public static void main(String[] args) {
        displayMovieList();

        // Let's assume the user selects a movie (Movie 1) and showtime (Showtime 1)
        String selectedMovieId = "1";
        String selectedShowtimeId = "1";

        Movie selectedMovie = movies.get(selectedMovieId);
        Showtime selectedShowtime = showtimes.get(selectedShowtimeId);

        displayShowtimeDetails(selectedShowtime);

        // Let's assume the user selects seats (row 0, col 0) and (row 1, col 1)
        List<List<Integer>> selectedSeats = new ArrayList<>();
        selectedSeats.add(Arrays.asList(0, 0));
        selectedSeats.add(Arrays.asList(1, 1));

        // Generate a unique booking ID (You might use a more sophisticated method)
        String bookingId = UUID.randomUUID().toString();

        Booking newBooking = new Booking(bookingId, selectedShowtime, selectedSeats);
        displayBookingDetails(newBooking);
    }

    static Map<String, Movie> initializeMovies() {
        Map<String, Movie> movies = new HashMap<>();
        movies.put("1", new Movie("Movie 1", "Action", 120));
        movies.put("2", new Movie("Movie 2", "Comedy", 90));
        return movies;
    }

    static Map<String, Showtime> initializeShowtimes() {
        Map<String, Showtime> showtimes = new HashMap<>();
        Movie movie1 = movies.get("1");
        Date startTime1 = new Date(); // Current time (you may use a date library for real-world scenarios)
        showtimes.put("1", new Showtime(movie1, "Theater A", startTime1, 5, 5));
        return showtimes;
    }

    static void displayMovieList() {
        System.out.println("Movie List:");
        for (Map.Entry<String, Movie> entry : movies.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue().title);
        }
    }

    static void displayShowtimeDetails(Showtime showtime) {
        System.out.println("\nShowtime Details:");
        System.out.println("Movie: " + showtime.movie.title);
        System.out.println("Theater: " + showtime.theater);
        System.out.println("Start Time: " + showtime.startTime);
        System.out.println("Seat Availability:");

        for (int i = 0; i < showtime.seatMap.size(); i++) {
            List<Boolean> row = showtime.seatMap.get(i);
            for (int j = 0; j < row.size(); j++) {
                System.out.print(row.get(j) ? "O " : "X "); // O: Available, X: Booked
            }
            System.out.println();
        }
    }

    static void displayBookingDetails(Booking booking) {
        System.out.println("\nBooking Details:");
        System.out.println("Booking ID: " + booking.bookingId);
        System.out.println("Movie: " + booking.showtime.movie.title);
        System.out.println("Theater: " + booking.showtime.theater);
        System.out.println("Start Time: " + booking.showtime.startTime);
        System.out.println("Selected Seats:");

        for (List<Integer> seat : booking.selectedSeats) {
            System.out.println("Row: " + seat.get(0) + ", Col: " + seat.get(1));
        }
    }
}
