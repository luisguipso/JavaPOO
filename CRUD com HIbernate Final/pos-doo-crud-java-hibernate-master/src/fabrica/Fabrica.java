
package fabrica;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Fabrica {
    
    public static EntityManagerFactory fabrica;
    
    static {
        
        fabrica = Persistence.createEntityManagerFactory("crudPU");
    }
    
    public static EntityManagerFactory get(){
        return fabrica;
    }
    
    
}