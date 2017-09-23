package modelo.persistencia.JDBC;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.entidades.Cliente;
import modelo.entidades.ClienteImpl;
import modelo.entidades.Factura;
import modelo.entidades.FacturaImpl;
import modelo.persistencia.FacturaDAO;
import sun.print.PSPrinterJob;

public class FacturaDAOJDBC implements FacturaDAO {

    @Override
    public Factura read(String pk) {
        String sql = "Select * from facturas where identificador like " + pk;
        Factura f = null;

        try {
            Statement stmt = Persistencia.createConnection().createStatement();
            ResultSet res = stmt.executeQuery(sql);

            if (res.next()) {
                String identificador = res.getString("identificador");
                String id_cliente = res.getString("id_cliente");
                Double importe = res.getDouble("importe");

                Cliente cliente = (new ClienteDAOJDBC()).read(id_cliente);

                f = new FacturaImpl(identificador, cliente, importe);

            }

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            Persistencia.closeConnection();
        }

        return f;
    }

    @Override
    public void create(Factura factura) {
        String sql = "insert into facturas (identificador, id_cliente, importe) values (?,?,?)";

        try {
            PreparedStatement pstmt = Persistencia.createConnection().prepareStatement(sql);
            pstmt.setString(1, factura.getIdentificador());
            pstmt.setString(2, factura.getCliente().getDNI());
            pstmt.setDouble(3, factura.getImporte());

            pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            Persistencia.closeConnection();
        }
    }

    @Override
    public void update(Factura factura) {
        String sql = "update facturas set id_cliente = ?, importe = ? where identificador = ?";

        try {
            PreparedStatement pstmt = Persistencia.createConnection().prepareStatement(sql);
            pstmt.setString(1, factura.getCliente().getDNI());
            pstmt.setDouble(2, factura.getImporte());
            pstmt.setString(3, factura.getIdentificador());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            Persistencia.closeConnection();
        }
    }

    @Override
    public void delete(Factura factura) {
        String sql = "delete from facturas where identificador = ?";
        try {
            PreparedStatement pstmt = Persistencia.createConnection().prepareStatement(sql);

            pstmt.setString(1, factura.getIdentificador());

            pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            Persistencia.closeConnection();
        }


    }

    @Override
    public List<Factura> list() {
        String sql = "Select * from facturas";
        List<Factura> facturas = new ArrayList<Factura>();
        try {
            Statement stmt = Persistencia.createConnection().createStatement();
            ResultSet res = stmt.executeQuery(sql);
            String identificador, id_cliente;
            Double importe;
            while (res.next()) {
                identificador = res.getString("identificador");
                id_cliente = res.getString("id_cliente");
                importe = res.getDouble("importe");

                Cliente c = (new ClienteDAOJDBC()).read(id_cliente);

                facturas.add(new FacturaImpl(identificador, c, importe));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            Persistencia.closeConnection();
        }
        return facturas;
    }

    @Override
    public List<Factura> listByCliente(String dni) {
        String sql = "select * from facturas where id_cliente = "+dni;
        List<Factura> cfacturas = new ArrayList<Factura>();
        
        try {
            Statement stm = Persistencia.createConnection().createStatement();
            ResultSet res = stm.executeQuery(sql);
            String identificador, nombre, direccion;
            double importe;
            while(res.next()){
                nombre=res.getString("nombre");
                direccion=res.getString("direccion");
                identificador= res.getString("identificador");
                importe= res.getDouble("importe");
                
                Cliente c = new ClienteImpl(dni, nombre, direccion);
                cfacturas.add(new FacturaImpl(identificador, c, importe));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }finally{
            Persistencia.closeConnection();
        }
        return cfacturas;
    }
}
