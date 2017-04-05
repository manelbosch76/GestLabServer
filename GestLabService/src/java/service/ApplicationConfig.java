/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author manel
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(service.EmpresaFacadeREST.class);
        resources.add(service.UsuarioFacadeREST.class);
        resources.add(service.ClienteFacadeREST.class);
        resources.add(service.EquipoFacadeREST.class);
        resources.add(service.ProductoFacadeREST.class);
        resources.add(service.HistorialProductosFacadeREST.class);
        resources.add(service.HistorialEquiposFacadeREST.class);
    }
    
    
}
