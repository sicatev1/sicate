package logicaNegocio;

import dao.BodegaDAO;
import dao.IBodegaDAO;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import logicaNegocio.interfaces.IControlaBodega;
import modelo.Bodega;

@Stateless
public class ControlaBodega implements IControlaBodega {

    private IBodegaDAO bodegaDAO = new BodegaDAO();

    public ControlaBodega() {
    }

    //*prueba sin conexion bd/
    public List<Bodega> consultarBodegas() {

//        List<Bodega> listBodega = new ArrayList<Bodega>();
//        listBodega.add(new Bodega("1", "Primer Piso", "12448884", "no existe"));

        return bodegaDAO.consultarTodos();
//        return listBodega;
    }

    public boolean guardarBodega(Bodega bodega) {
        return bodegaDAO.guardarBodega(bodega);
    }

    @Override
    public boolean editarBodega(Bodega bodega) {
        return bodegaDAO.editarBodega(bodega);
    }
}
