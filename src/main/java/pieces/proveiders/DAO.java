package pieces.proveiders;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DAO {

	ArrayList<Provides> miProvides;

	private static ConectionDB conexion = new ConectionDB();
	private static ResultSet resultado;

	public DAO() {
		miProvides = new ArrayList<Provides>();
	}
	public void addProvide(Provides provide) {
		miProvides.add(provide);
	}
	public ArrayList<Provides> getAllProvides() {
		resultado = conexion.getQuery("SELECT * FROM Provides");
		Provides provide;
		try {
			while (resultado.next()) {
				provide = new Provides();
				provide.setPiece(Integer.parseInt(resultado.getString("Piece")));
				provide.setProvider(resultado.getString("Provider"));
				provide.setPrice(Integer.parseInt(resultado.getString("Price")));
				addProvide(provide);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return miProvides;
	}

	public void deleteProvides(int price) {

		conexion.setQuery("DELETE FROM Provides WHERE Price='" + price + "'");
	}

	public Provides getProvides(int price) {

		Provides p = new Provides();
		resultado = conexion.getQuery("SELECT * FROM Provides WHERE Price='"
				+ price + "'");
		try {
			while (resultado.next()) {

				p.setPiece(Integer.parseInt(resultado.getString("Piece")));
				p.setProvider(resultado.getString("Provider"));
				p.setPrice(Integer.parseInt(resultado.getString("Price")));

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return p;
	}

	public static void updateProvides(Provides p) {
		int pieza, precio;
		String provedor;

		pieza = p.getPiece();
		provedor = p.getProvider();
		precio = p.getPrice();

		String nombre = "UPDATE Provides SET Price=" + precio
				+ "WHERE Provider='" + provedor + "' AND Piece=" + pieza;
		System.out.println("Name: " + nombre);
		conexion.setQuery("UPDATE Provides SET Price=" + precio
				+ " WHERE Provider='" + provedor + "' AND Piece=" + pieza);

	}

}
