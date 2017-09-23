package modelo.persistencia.JDBC;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.entidades.Cliente;
import modelo.entidades.ClienteImpl;
import modelo.persistencia.ClienteDAO;

public class ClienteDAOJDBC implements ClienteDAO {

    @Override
    public Cliente read(String pk) {
        Cliente c = null;
        String sql = "SELECT * FROM cliente where nombre LIKE " + pk;
        try {
            Statement stmt = Persistencia.createConnection().createStatement();
            ResultSet res = stmt.executeQuery(sql);

            c = new ClienteImpl(res.getString("dni"), res.getString("nombre"), res.getString("direccion"));

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            Persistencia.closeConnection();
        }
        return c;
    }

    @Override
    public void create(Cliente contacto) {
        String sql = "insert into clientes(dni,nombre,direccion) values (?,?,?)";

        try {
            PreparedStatement pstmt = Persistencia.createConnection().prepareStatement(sql);

            pstmt.setString(1, contacto.getDNI());
            pstmt.setString(2, contacto.getNombre());
            pstmt.setString(3, contacto.getDireccion());

            pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            Persistencia.closeConnection();
        }
    }

    @Override
    public void update(Cliente contacto) {
        String sql = "update cliente set nombre=?, direccion=? where dni=?";

        try {
            PreparedStatement pstmt = Persistencia.createConnection().prepareStatement(sql);

            pstmt.setString(1, contacto.getNombre());
            pstmt.setString(1, contacto.getDireccion());
            pstmt.setString(1, contacto.getDNI());

            pstmt.executeUpdate();


        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            Persistencia.closeConnection();
        }
    }

    @Override
    public void delete(Cliente contacto) {
        String sql = "delete froma clientes where dni like ?";

        try {
            PreparedStatement pstmt = Persistencia.createConnection().prepareStatement(sql);

            pstmt.setString(1, contacto.getDNI());

            pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            Persistencia.closeConnection();
        }
    }

    @Override
    public List<Cliente> list() {
        String sql = "Select * from clientes";
        List<Cliente> clientes = new ArrayList<Cliente>();

        try {
            Statement stmt = Persistencia.createConnection().createStatement();
            ResultSet res = stmt.executeQuery(sql);
            while (res.next()) {
                clientes.add(new ClienteImpl(res.getString("dni"), res.getString("nombre"), res.getString("direccion")));
            }
            res.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            Persistencia.closeConnection();
        }
        return clientes;
    }
}
