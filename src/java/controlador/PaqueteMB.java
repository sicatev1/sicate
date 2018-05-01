/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.PaqueteDAO;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import modelo.Paquete;
import dao.IPaqueteDAO;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import logicaNegocio.interfaces.IControlaBodega;
import logicaNegocio.interfaces.IControlaPaquete;
import modelo.Bodega;

@ManagedBean
@RequestScoped
public class PaqueteMB {

    @EJB
    private IControlaPaquete controlaPaqueteInterface;
    
    @EJB
    private IControlaBodega controlaBodegaInterface;

    private Paquete paqueteSelected;
    private List<Paquete> lstPaquete;
    private List<Bodega> lstBodega;

    public PaqueteMB() {
        paqueteSelected = new Paquete();
        lstPaquete = new ArrayList<>();
        lstBodega = new ArrayList<>();
    }

    public void guardarPaquete() {

        boolean guardado = controlaPaqueteInterface.guardarPaquete(paqueteSelected);
        if (guardado) {

            lstPaquete = controlaPaqueteInterface.consultarPaquete();
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Paquete Guardada", "");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
    }
    
    @PostConstruct
    public void init(){
        consultarBodegas();
    }
    
    
    public void consultarBodegas(){
        
        lstBodega = controlaBodegaInterface.consultarBodegas();
    }
    
    public void limpiar() {
        paqueteSelected = new Paquete();
    }

    public Paquete getPaqueteSelected() {
        return paqueteSelected;
    }

    public void setPaqueteSelected(Paquete paqueteSelected) {
        this.paqueteSelected = paqueteSelected;
    }

    public List<Paquete> getLstPaquete() {
        return lstPaquete;
    }

    public void setLstPaquete(List<Paquete> lstPaquete) {
        this.lstPaquete = lstPaquete;
    }

    public List<Bodega> getLstBodega() {
        return lstBodega;
    }

    public void setLstBodega(List<Bodega> lstBodega) {
        this.lstBodega = lstBodega;
    }
    
    
    
    

}
