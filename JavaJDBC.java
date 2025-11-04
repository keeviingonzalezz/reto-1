import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class JavaJDBC {
    public static void main(String[] args) {
        try {
            // Cargar driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Conectar con la base de datos
            Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/eventos", "root", ""
            );

            // Crear statement
            Statement statement = connection.createStatement();

            // Ejecutar consulta
            ResultSet resultSet = statement.executeQuery("SELECT * FROM inscripciones");

            // Mostrar resultados
            while (resultSet.next()) {
                System.out.println(
                    resultSet.getInt("id") + " - " +
                    resultSet.getString("nombre") + " " +
                    resultSet.getString("apellidos") + " | " +
                    resultSet.getString("email") + " | " +
                    resultSet.getString("telefono") + " | " +
                    resultSet.getString("genero") + " | " +
                    resultSet.getInt("edad") + " | " +
                    resultSet.getString("eventos") + " | " +
                    resultSet.getString("comentarios")
                );
            }

            // Cerrar conexión
            connection.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
