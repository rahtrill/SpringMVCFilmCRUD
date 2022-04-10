package com.skilldistillery.mvcfilmsite.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.mvcfilmsite.entities.Actor;
import com.skilldistillery.mvcfilmsite.entities.Film;
import com.skilldistillery.mvcfilmsite.entities.Language;

public class FilmDaoJdbcImpl implements FilmDAO {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Mountain";
	private String user = "student";
	private String pass = "student";

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.err.println("Driver not found.");
			throw new RuntimeException("Unable to load MYSQL driver class");
		}

	}

	public Film findFilmById(int filmId) {
		Film fm = null;
		Connection conn;
		try {
			conn = DriverManager.getConnection(URL, user, pass);
			String sqltxt;
			sqltxt = "SELECT * FROM film WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sqltxt);
			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				fm = new Film();
				fm.setId(rs.getInt("id"));
				fm.setTitle(rs.getString("title"));
				fm.setDescription(rs.getString("description"));
				fm.setReleaseYear(rs.getInt("release_year"));
				fm.setLanguageId(rs.getInt("language_id"));
				fm.setRentalRate(rs.getDouble("rental_rate"));
				fm.setLength(rs.getInt("length"));
				fm.setReplacementCost(rs.getDouble("replacement_cost"));
				fm.setRating(rs.getString("rating"));
				fm.setSpecialFeatures(rs.getString("special_features"));

				int languageId = fm.getLanguageId();

				fm.setActorList(findActorsByFilmId(filmId));
				fm.setLanguageList(languageFromId(languageId));

				
				
				System.out.println("ID: " + fm.getId());
				System.out.println("Title: " + fm.getTitle() + ", Release Year: " + fm.getReleaseYear() + ", Rating: "
						+ fm.getRating() + ", Descripton: " + fm.getDescription());
				System.out.println(fm.getLanguageList());
				System.out.println("Actors: " + fm.getActorList());
				System.out.println();

			}
			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Invalid Response");
		}
		return fm;
	}

	public Actor findActorById(int actorId) {
		Actor actor = null;
		Connection conn;
		try {
			conn = DriverManager.getConnection(URL, user, pass);
			String sqltxt;
			sqltxt = "SELECT * FROM actor WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sqltxt);
			stmt.setInt(1, actorId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				actor = new Actor();
				actor.setId(rs.getInt("id"));
				actor.setFirstName(rs.getString("first_name"));
				actor.setLastName(rs.getString("last_name"));
			}
			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Invalid Response");
		}
		return actor;
	}

	public List<Actor> findActorsByFilmId(int filmId) {
		List<Actor> actorList = new ArrayList<>();
		Connection conn;
		try {
			conn = DriverManager.getConnection(URL, user, pass);
			String sqltxt;
			sqltxt = "SELECT a.id, a.first_name, a.last_name FROM Actor a JOIN film_actor fa ON a.id = fa.actor_id JOIN film f ON f.id = fa.film_id WHERE fa.film_id = ?";
			PreparedStatement stmt = conn.prepareStatement(sqltxt);
			stmt.setInt(1, filmId);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Actor actor = new Actor();
				actor.setId(rs.getInt("id"));
				actor.setFirstName(rs.getString("first_name"));
				actor.setLastName(rs.getString("last_name"));
				actorList.add(actor);
			}
			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Invalid Response");
		}
		return actorList;
	}

	public Film findFilmByKeyword(String input) {
		Film fm = null;
		Connection conn;
		try {
			conn = DriverManager.getConnection(URL, user, pass);
			String sqltxt;
			sqltxt = "SELECT * FROM film WHERE film.title LIKE ? OR film.description LIKE ?  ";
			PreparedStatement stmt = conn.prepareStatement(sqltxt);
			stmt.setString(1, "%" + input + "%");
			stmt.setString(2, "%" + input + "%");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				fm = new Film();
				fm.setId(rs.getInt("id"));
				fm.setTitle(rs.getString("title"));
				fm.setDescription(rs.getString("description"));
				fm.setReleaseYear(rs.getInt("release_year"));
				fm.setLanguageId(rs.getInt("language_id"));
				fm.setRentalRate(rs.getDouble("rental_rate"));
				fm.setLength(rs.getInt("length"));
				fm.setReplacementCost(rs.getDouble("replacement_cost"));
				fm.setRating(rs.getString("rating"));
				fm.setSpecialFeatures(rs.getString("special_features"));
				int filmId = fm.getId();
				int languageId = fm.getLanguageId();
				fm.setActorList(findActorsByFilmId(filmId));
				fm.setLanguageList(languageFromId(languageId));
//				System.out.println("Title: " + fm.getTitle() + ", Release Year: " + fm.getReleaseYear() + ", Rating: "
//						+ fm.getRating() + ", Descripton: " + fm.getDescription());
//				System.out.println(fm.getLanguageList());
//				System.out.println("Cast: " + fm.getActorList());
//				System.out.println();
			}
			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Invalid Response");
		}

		return fm;
	}

	public Language languageFromId(int idForLanguage) {
		Language listLang = null;
		Connection conn;
		try {
			conn = DriverManager.getConnection(URL, user, pass);
			String sqltxt;
			sqltxt = "SELECT l.name FROM language l JOIN film f ON f.language_id = l.id WHERE language_id = ?";
			PreparedStatement stmt = conn.prepareStatement(sqltxt);
			stmt.setInt(1, idForLanguage);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				listLang = new Language();
				listLang.setName(rs.getString("name"));

			}
			rs.close();
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("Invalid Response");
		}
		return listLang;
	}

	public Film createFilm(Film film) {
		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "INSERT INTO film " + " (title, description, release_year, language_id, rental_duration, rental_rate, length, replacement_cost, rating, special_features) "
			// TODO: Add the rest of the film properties
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			
			stmt.setString(1, film.getTitle());
			stmt.setString(2, film.getDescription());
			stmt.setInt(3, film.getReleaseYear());
			stmt.setInt(4, film.getLanguageId());
			stmt.setInt(5, film.getRentalDuration());
			stmt.setDouble(6, film.getRentalRate());
			stmt.setInt(7, film.getLength());
			stmt.setDouble(8, film.getReplacementCost());
			stmt.setString(9, film.getRating());
			stmt.setString(10, film.getSpecialFeatures());
			
			
			
			
			int updateCount = stmt.executeUpdate();
			if (updateCount == 1) {
				ResultSet rs = stmt.getGeneratedKeys();
				if (rs.next()) {
					film.setId(rs.getInt(1));
				}
				rs.close();
			}

			stmt.close();
			conn.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			film = null;
		}

		return film;
	}

	@Override
	public boolean updateFilm(Film film) {

		Connection conn = null;

		try {
			conn = DriverManager.getConnection(URL, user, pass);
			conn.setAutoCommit(false);

			String sql = "UPDATE film SET title = ?, description = ?, release_year = ?, language_id = ?, rental_duration = ?, rental_rate = ?, length = ?, replacement_cost = ?, rating = ?, special_features = ?"
					+ " WHERE id= ?";

			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setString(1, film.getTitle());
			stmt.setString(2, film.getDescription());
			stmt.setInt(3, film.getReleaseYear());
			stmt.setInt(4, film.getLanguageId());
			stmt.setInt(5, film.getRentalDuration());
			stmt.setDouble(6, film.getRentalRate());
			stmt.setInt(7, film.getLength());
			stmt.setDouble(8, film.getReplacementCost());
			stmt.setString(9, film.getRating());
			stmt.setString(10, film.getSpecialFeatures());
			
			stmt.setInt(11, film.getId());

			
			int updateCount = stmt.executeUpdate();
			if (updateCount == 1) {

				sql = "DELETE FROM film_actor WHERE film_id = ?";
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, film.getId());
				System.out.println(film.getId());
				
				
				updateCount = stmt.executeUpdate();
				sql = "INSERT INTO film_actor (film_id, actor_id) VALUES (?,?)";
				stmt = conn.prepareStatement(sql);

				for (Actor actor : film.getActorList()) {
					stmt.setInt(1, film.getId());
					stmt.setInt(2, actor.getId());
					updateCount = stmt.executeUpdate();
				}
				conn.commit(); // COMMIT TRANSACTION
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} // ROLLBACK TRANSACTION ON ERROR
				catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
			return false;
		}

		return true;
	}
// we changed parameter to int id ***

	@Override
	public boolean deleteFilm(int id) {

		// Use if statement to determine if film id is less than 100 tio

		Connection conn = null;
		try {

			conn = DriverManager.getConnection(URL, user, pass);

			conn.setAutoCommit(false);

			String sql = "DELETE FROM film_actor WHERE film_id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.setInt(1, id);

			int updateCount = stmt.executeUpdate();
			sql = "DELETE FROM film WHERE id = ?";

			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, id);
			updateCount = stmt.executeUpdate();
			conn.commit(); // COMMIT TRANSACTION
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException sqle2) {
					System.err.println("Error trying to rollback");
				}
			}
			return false;
		}
		return true;
	}

}
