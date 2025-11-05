import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JavaJDBC {
    public static void main(String[] args) {
        try {
            // Cargar el driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Conectar con la base de datos
            Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/MMKS", "root", ""
            );

            // Crear statement
            Statement statement = connection.createStatement();

            // Ejecutar consulta
            ResultSet resultSet = statement.executeQuery("SELECT * FROM inscripciones");

            // Variables para almacenar los resultados
            int totalPersonas = 0;
            int eventoCount[] = new int[4]; // Array para contar las inscripciones de los 4 eventos
            String[][] eventoPersonas = new String[4][100]; // Array para almacenar las personas inscritas en cada evento

            // Leer los resultados de la base de datos
            while (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                String apellidos = resultSet.getString("apellidos");
                String email = resultSet.getString("email");
                String telefono = resultSet.getString("telefono");
                String genero = resultSet.getString("genero");
                int edad = resultSet.getInt("edad");
                String eventos = resultSet.getString("eventos");

                // Aumentar el total de personas inscritas
                totalPersonas++;

                // Verificar en qué eventos se ha inscrito la persona
                if (eventos.contains("Bad Gyal")) {
                    eventoCount[0]++; // Incrementa el contador para Bad Gyal
                    eventoPersonas[0][eventoCount[0] - 1] = nombre + " " + apellidos + " | " + email + " | " + telefono + " | " + genero + " | " + edad;
                }
                if (eventos.contains("Duki")) {
                    eventoCount[1]++; // Incrementa el contador para Duki
                    eventoPersonas[1][eventoCount[1] - 1] = nombre + " " + apellidos + " | " + email + " | " + telefono + " | " + genero + " | " + edad;
                }
                if (eventos.contains("Metrika")) {
                    eventoCount[2]++; // Incrementa el contador para Metrika
                    eventoPersonas[2][eventoCount[2] - 1] = nombre + " " + apellidos + " | " + email + " | " + telefono + " | " + genero + " | " + edad;
                }
                if (eventos.contains("Quevedo")) {
                    eventoCount[3]++; // Incrementa el contador para Quevedo
                    eventoPersonas[3][eventoCount[3] - 1] = nombre + " " + apellidos + " | " + email + " | " + telefono + " | " + genero + " | " + edad;
                }
            }

            // Mostrar la cantidad total de personas inscritas
            System.out.println("Total de personas inscritas: " + totalPersonas);

            // Mostrar la cantidad de personas inscritas por evento
            System.out.println("Número de personas inscritas en Bad Gyal: " + eventoCount[0]);
            System.out.println("Número de personas inscritas en Duki: " + eventoCount[1]);
            System.out.println("Número de personas inscritas en Metrika: " + eventoCount[2]);
            System.out.println("Número de personas inscritas en Quevedo: " + eventoCount[3]);

            // Mostrar el listado de personas por evento
            System.out.println("\nListado de personas para el evento Bad Gyal:");
            for (int i = 0; i < eventoCount[0]; i++) {
                System.out.println(eventoPersonas[0][i]);
            }

            System.out.println("\nListado de personas para el evento Duki:");
            for (int i = 0; i < eventoCount[1]; i++) {
                System.out.println(eventoPersonas[1][i]);
            }

            System.out.println("\nListado de personas para el evento Metrika:");
            for (int i = 0; i < eventoCount[2]; i++) {
                System.out.println(eventoPersonas[2][i]);
            }

            System.out.println("\nListado de personas para el evento Quevedo:");
            for (int i = 0; i < eventoCount[3]; i++) {
                System.out.println(eventoPersonas[3][i]);
            }

            // Cerrar la conexión
            connection.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
