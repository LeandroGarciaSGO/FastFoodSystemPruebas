package Logica;

import Datos.Cliente;
import Datos.Comida;
import Datos.DetallePedido;
import Datos.Facturacion;
import Datos.Pedido;
import Datos.Zona;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author Leandro
 */
public class OperacionesFacturacion {
    
    public ArrayList<Facturacion> obtenerInformacionPedidosListos() throws ClassNotFoundException, SQLException {
        ResultSet pedidoslistos;
        Pedido ped = new Pedido();
        Facturacion factura = new Facturacion();
        ArrayList<Facturacion> listafacturas = new ArrayList<Facturacion>();
        pedidoslistos = ped.obtenerPedidosListos();
        while (pedidoslistos.next()) {
            factura = new Facturacion();
            ped = new Pedido();
            ped.setIdPedido(pedidoslistos.getInt("idPedido"));
            ped.setIdCliente(pedidoslistos.getInt("idCliente"));
            ped.setEstado(pedidoslistos.getInt("estado"));
            ped.setFecha(pedidoslistos.getDate("fecha"));
            ped.setHora(pedidoslistos.getTime("hora"));
            ped.setLugarDeEnvio(pedidoslistos.getString("lugarDeEnvio"));
            ped.setZona(pedidoslistos.getInt("zona"));
            ped.setIdCadete(pedidoslistos.getInt("idCadete"));         
            System.out.print(pedidoslistos.getInt("idPedido"));
            System.out.print(ped.getIdPedido());
            OperacionesCliente opCli = new OperacionesCliente();
            Cliente cli =  new Cliente(); 
            cli = opCli.buscarClienteConId(ped.getIdCliente());
            if (cli != null) {
                factura.setDatospedido(ped);
                factura.setDatoscliente(cli);
                //listafacturas.add(factura);
                //return listafacturas;
            }
            listafacturas.add(factura);
        }
        return listafacturas;
    }

     public ArrayList<DetallePedido> obtenerDetallesDePedidos(Facturacion fac) throws SQLException, ClassNotFoundException{
        ResultSet listadetalles =  null;
        DetallePedido detalle = new DetallePedido();
        Pedido pd = new Pedido();
        ArrayList<DetallePedido> listaDetalles = new ArrayList<DetallePedido>();        
        listadetalles = pd.obtenerDetallesPedidosListos(fac.getDatospedido().getIdPedido());
        while (listadetalles.next()) {
            //ped = new Pedido2();
            detalle = new DetallePedido();
            detalle.setNumLinea(listadetalles.getInt("numLinea"));
            detalle.setCantidad(listadetalles.getInt("cantidad"));
            Comida C = new Comida();
            ResultSet comida = C.consultaComidaId(listadetalles.getInt("idComida"));
            if(comida.first()){
                C.setDescripcion(comida.getString("descripcion"));
                C.setPrecio(comida.getFloat("precio"));
                detalle.setDatoscomida(C);
            }
            listaDetalles.add(detalle);
        }
        return listaDetalles;
    }
     
     
   public Zona obtenerZona(int idZona) throws ClassNotFoundException, SQLException{
       Zona z = new Zona ();
       ResultSet resultado = z.consultaZonaPorId(idZona);
       if(resultado.first())
       {
           z.setIdZona(resultado.getInt("idZona"));
           z.setDescripcion(resultado.getString("descripcion"));
           z.setPrecio(resultado.getFloat("precio"));
           return z;
       }
       return null;
   }
   
   public void guardarDetalle(Facturacion factura, ArrayList<DetallePedido> listaDetalles) throws SQLException, ClassNotFoundException{
       for (int i = 0; i < listaDetalles.size(); i++) {
           Pedido p = new Pedido();
           p = factura.getDatospedido();
           p.setDetalle(listaDetalles.get(i));
           factura.setDatospedido(p);
           System.out.println(factura.getDatospedido().getDetalle().getCantidad());
           System.out.println(factura.getDatospedido().getDetalle().getIdComida());
           System.out.println(factura.getDatospedido().getDetalle().getNumLinea());
           System.out.println(factura.getDatospedido().getDetalle().getIdPedido());
           System.out.println(factura.getDatospedido().getDetalle().getDatoscomida().getDescripcion());
           System.out.println(factura.getDatospedido().getDetalle().getDatoscomida().getPrecio());
           factura.insertarDetalle();
       }
   }

    public Facturacion buscarFactura(int id) throws SQLException, ClassNotFoundException {
        ResultSet datosFactura;        
        Facturacion f = new Facturacion();
        datosFactura = f.obtenerFactura(id);
        if(datosFactura.first()){
            f = new Facturacion();
            f.setNumFactura(datosFactura.getInt("numFactura"));
            f.setImporte(0);
            Pedido p = new Pedido();
            p.setFecha(datosFactura.getDate("fecha"));
            p.setIdPedido(datosFactura.getInt("idPedido"));
            //p.setHora(datosFactura.getTime("hora"));            
            p.setHora(null);
            f.setDatospedido(p);
            Cliente c = new Cliente();
            //c.setIdCliente(datosFactura.getInt("idCliente"));
            c.setIdCliente(0);
            c.setNombre(datosFactura.getString("nombreCliente"));
            f.setDatoscliente(c);
            f.setEstado(datosFactura.getBoolean("estado"));
            return f;
        }
        return null;
    }
    
    
    public Cliente buscarCliente(long telefono) throws ClassNotFoundException, SQLException {
        ResultSet datosCliente;
        Cliente miCliente = new Cliente();
        datosCliente = miCliente.obtenerCliente(telefono);
        if (datosCliente.first()) {
            miCliente.setIdCliente(datosCliente.getInt("idCliente"));
            miCliente.setNombre(datosCliente.getString("nombre"));
            miCliente.setApellido(datosCliente.getString("apellido"));
            miCliente.setDomicilio(datosCliente.getString("domicilio"));
            miCliente.setTelefono(datosCliente.getLong("telefono"));
            miCliente.setEstado(datosCliente.getBoolean("estado"));
            return miCliente;            
        }
        return null;
    }
    
   

    
}
