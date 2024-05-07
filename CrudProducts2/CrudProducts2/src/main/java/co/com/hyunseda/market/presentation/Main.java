
package co.com.hyunseda.market.presentation;

import co.com.hyunseda.market.access.FactoryCategory;
import co.com.hyunseda.market.access.FactoryProduct;
import co.com.hyunseda.market.access.ICategoryRepository;
import co.com.hyunseda.market.access.IProductRepository;
import co.com.hyunseda.market.service.CategoryService;
import co.com.hyunseda.market.service.ProductService;
import co.unicauca.microkernel.common.entities.Category;
import co.unicauca.microkernel.plugin.manager.PluginManager;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Libardo Pantoja
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        String basePath = getBaseFilePath2();
        try {
            PluginManager.init(basePath);
        } catch (Exception ex) {
            Logger.getLogger("Application").log(Level.SEVERE, "Error al ejecutar la aplicación", ex);
        }
       
        IProductRepository ipr = FactoryProduct.getInstance().getRepository("default");
        ICategoryRepository cr = FactoryCategory.getInstance().getRepository("default");
        
        CategoryService categoryService = new CategoryService(cr);
        ProductService productService = new ProductService(ipr);
       Category cat = new Category((long)1,"aretes");
       Category cat2 = new Category((long)2,"pendientes"); 
       //categoria ruana
       Category cat3 = new Category((long)3,"ruana");
       Category cat4 = new Category((long)4,"estampadas");
       // categoria pañoleta
       Category cat5 = new Category((long)5,"pañoletas");
       Category cat6 = new Category((long)6,"estampadas");
       categoryService.addCategory(cat.getName());
       categoryService.addCategory(cat2.getName());
       categoryService.addCategory(cat3.getName());
       categoryService.addCategory(cat4.getName());
       categoryService.addCategory(cat5.getName());
       categoryService.addCategory(cat6.getName());
       
         List<Category> listaC = new ArrayList<>();
         List<Category> lista = new ArrayList<>();
         List<Category> listaP = new ArrayList<>();
         listaP.add(cat5);
         listaC.add(cat3);
         listaC.add(cat4);
        lista.add(cat);
        lista.add(cat2);
        
        productService.saveProduct("Aretes","Arestes Rosados","lo",20000,2,"arete,pendiente,accersorio,joyeria","\\src\\main\\java\\com\\raven\\image\\a.png","Arete de porselana,largo 6cm, ancho 3 cm",lista);
        productService.saveProduct("Aretes","Arestes De seda Multicolor","lo",30000,1,"arete,pendiente,accersorio,joyeria","\\src\\main\\java\\com\\raven\\image\\aM.png","Arete de porselana,largo 6cm, ancho 3 cm",listaC);
        productService.saveProduct("Aretes","Aretes De seda Azul","lo",25000,2,"arete,pendiente,accersorio,joyeria","\\src\\main\\java\\com\\raven\\image\\amr.png","Arete de porselana,largo 6cm, ancho 3 cm",lista);
        productService.saveProduct("Pañoleta","Pañoleta Dorada Naranja","lo",90000,2,"arete,pendiente,accersorio,joyeria","\\src\\main\\java\\com\\raven\\image\\pa.png","Arete de porselana,largo 6cm, ancho 3 cm",listaP);
        productService.saveProduct("Ruana","Ruana Azul","lo",330000,2,"Ruana,poncho,abrigo,ropainvierno","\\src\\main\\java\\com\\raven\\image\\ru.png","Ruana Azul largo 128, ancho 128",listaC);
        productService.saveProduct("Aretes","Arestes Rosados","lo",20000,2,"arete,pendiente,accersorio,joyeria","\\src\\main\\java\\com\\raven\\image\\a.png","Arete de porselana,largo 6cm, ancho 3 cm",lista);
        GUIInicio instanceI = new GUIInicio(categoryService, productService );
        GUIProducts instance = new GUIProducts(categoryService, productService);
        GUICategory instance2 = new GUICategory(categoryService);

        instanceI.setVisible(true);
        /*String basePath = getBaseFilePath();
     
        try {
            PluginManager.init(basePath);

            Consola presentationObject = new Consola();
            presentationObject.start();

        } catch (Exception ex) {
            Logger.getLogger("Application").log(Level.SEVERE, "Error al ejecutar la aplicación", ex);
        }*/
        
         
        instanceI.setVisible(true);
    }
    
        private static String getBaseFilePath() {
        try {
            String path = Main.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            path = URLDecoder.decode(path, "UTF-8"); //This should solve the problem with spaces and special characters.
            File pathFile = new File(path);
            if (pathFile.isFile()) {
                path = pathFile.getParent();
                
                if (!path.endsWith(File.separator)) {
                    path += File.separator;
                }
                
            }

            return path;
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, "Error al eliminar espacios en la ruta del archivo", ex);
            return null;
        }
    }
     
    private static String getBaseFilePath2() {
        String path = Main.class.getProtectionDomain().getCodeSource().getLocation().getPath();

        File pathFile = new File(path);
        if (pathFile.isFile()) {
            path = pathFile.getParent();

            if (!path.endsWith(File.separator)) {
                path += File.separator;
            }
        }
        return path;
    }

}
