package co.unicauca.microkernel.infra;

import co.unicauca.microkernel.common.interfaces.IPublisherPlugin;
import co.unicauca.microkernel.plugin.manager.PluginManager;

/**
 *
 * @author ahurtado, wpantoja
 */
public class Publisher {

    public Publisher() {
    }
    
    
    public void publish(String msg){
        
        PluginManager manager = PluginManager.getInstance();
        IPublisherPlugin publisher = manager.getPublisherPlugin("publisherTech");
        publisher.publish(msg);
    }
  
}
