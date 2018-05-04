/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;

import logicaNegocio.interfaces.IControlaBodega;
import modelo.Bodega;

/**
 *
 * @author JOLU
 */
public class UtilCombos {

    public static List<SelectItem> getComboBodega(IControlaBodega control) {

        List<Bodega> listaBodegas = control.consultarBodegas();
        List<SelectItem> resultado = new ArrayList<>();
        for (Bodega objeto : listaBodegas) {
            SelectItem temp = new SelectItem(objeto.getCodigo(), objeto.getNombre());
            resultado.add(temp);

        }
        return resultado;

    }

}
