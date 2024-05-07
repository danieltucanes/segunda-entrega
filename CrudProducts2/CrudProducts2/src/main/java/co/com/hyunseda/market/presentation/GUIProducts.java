/*
Cosas por hacer:
- implementar la eliminacion de un producto
*/

package co.com.hyunseda.market.presentation;


import co.com.hyunseda.market.service.CategoryService;
import co.com.hyunseda.market.service.ProductService;
import co.unicauca.microkernel.common.entities.Category;
import co.unicauca.microkernel.common.entities.Product;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import javax.swing.DefaultListModel;

/**
 *
 * @author Libardo Pantoja, Julio A. Hurtado
 */
public class GUIProducts extends javax.swing.JFrame {
    DefaultListModel<String> model = new DefaultListModel<>();
    private ProductService productService;
    private CategoryService categoryService;
    private boolean addOption;
    
    /**
     * Creates new form GUIProducts
     */
    public GUIProducts() {
        initComponents();
        stateInitial();
    }
    
    public GUIProducts(CategoryService categoryService, ProductService productService) {
        initComponents();
        this.productService = productService;
        this.categoryService = categoryService;
        stateInitial();
        initCats();
    }
    
    
    public void initCats(){
        listCategories.setModel(model);
        List<Category> cats = categoryService.findAllCategories();
        for(Category cat : cats){
            System.out.println(cat.getName());
            model.addElement(cat.getName());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlSouth = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnFind = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        btnConfirmar = new javax.swing.JButton();
        pnlCenter = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtDescription = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        listCategories = new javax.swing.JList<>();
        lbSlug = new javax.swing.JLabel();
        txtSlug = new javax.swing.JTextField();
        lbPrice = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        lbStock = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        lbKeywords = new javax.swing.JLabel();
        txtKeywords = new javax.swing.JTextField();
        lbImages = new javax.swing.JLabel();
        txtImages = new javax.swing.JTextField();
        lbCaracteristicas = new javax.swing.JLabel();
        txtCaracteristicas = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Productos");
        setPreferredSize(new java.awt.Dimension(641, 500));

        pnlSouth.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        pnlSouth.add(btnNuevo);

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        pnlSouth.add(btnEditar);

        btnSave.setText("Grabar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        pnlSouth.add(btnSave);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        pnlSouth.add(btnCancelar);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        pnlSouth.add(btnEliminar);

        btnFind.setText("Buscar");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });
        pnlSouth.add(btnFind);

        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        pnlSouth.add(btnCerrar);

        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarElimActionPerformed(evt);
            }
        });
        pnlSouth.add(btnConfirmar);

        getContentPane().add(pnlSouth, java.awt.BorderLayout.SOUTH);

        pnlCenter.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlCenter.setLayout(new java.awt.GridLayout(10, 2));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("*Id:");
        pnlCenter.add(jLabel1);

        txtId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIdFocusLost(evt);
            }
        });
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });
        pnlCenter.add(txtId);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("*Nombre:");
        pnlCenter.add(jLabel2);

        txtName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNameFocusLost(evt);
            }
        });
        pnlCenter.add(txtName);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Descripción:");
        pnlCenter.add(jLabel3);

        txtDescription.setColumns(20);
        txtDescription.setRows(5);
        pnlCenter.add(txtDescription);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Categoria(s):");
        pnlCenter.add(jLabel4);

        pnlCenter.add(listCategories);

        lbSlug.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbSlug.setText("*Slug:");
        pnlCenter.add(lbSlug);
        pnlCenter.add(txtSlug);

        lbPrice.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbPrice.setText("*Precio:");
        pnlCenter.add(lbPrice);
        pnlCenter.add(txtPrice);

        lbStock.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbStock.setText("*Stock:");
        pnlCenter.add(lbStock);
        pnlCenter.add(txtStock);

        lbKeywords.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbKeywords.setText("Palabras clave:");
        pnlCenter.add(lbKeywords);
        pnlCenter.add(txtKeywords);

        lbImages.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbImages.setText("*Imagenes");
        pnlCenter.add(lbImages);
        pnlCenter.add(txtImages);

        lbCaracteristicas.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbCaracteristicas.setText("Caracteristicas:");
        pnlCenter.add(lbCaracteristicas);
        pnlCenter.add(txtCaracteristicas);

        getContentPane().add(pnlCenter, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        stateNew();
        txtName.requestFocus();
        addOption = true;
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        stateInitial();
        cleanControls();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        
        if (addOption) {
            if (txtName.getText().trim().equals("")) {
                Messages.showMessageDialog("Debe ingresar el nombre del producto", "Atención");
                txtName.requestFocus();
                return;
            }
            //Agregar
            addProduct();

        } else {
            try{
                Long productId = Long.parseLong(txtId.getText());
                Product prod = productService.findProductById(productId);
                if (prod != null) {
                    if (txtName.getText().trim().equals("")) {
                        Messages.showMessageDialog("Debe ingresar el nombre del producto", "Atención");
                        txtName.requestFocus();
                        return;
                    }
                }
                
            }catch(NumberFormatException e){
                
            }
            //Editar
            editProduct();
        }

    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        addOption = false;
        stateEdit();
        txtId.requestFocus();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        stateElim();
        txtId.requestFocus();
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        GUIProductsFind instance = new GUIProductsFind(this, true, productService, categoryService);
        instance.setVisible(true);
    }//GEN-LAST:event_btnFindActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void txtIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdFocusLost
        if (txtId.getText().trim().equals("")) {
            return;
        }
        try{
            Long productId = Long.parseLong(txtId.getText());
            Product prod = productService.findProductById(productId);
            if (prod == null) {
                Messages.showMessageDialog("El identificador del producto no existe", "Error");
                txtId.setText("");
                txtId.requestFocus();
            } else {
                txtName.setEnabled(true);
                txtDescription.setEnabled(true);
                txtName.setText(prod.getName());
                txtDescription.setText(prod.getDescription());
            }
        }catch(NumberFormatException e){
            Messages.showMessageDialog("Se esperaba un numero en la casilla de la id", "Error");
            txtId.setText("");
            txtId.requestFocus();
        }
    }//GEN-LAST:event_txtIdFocusLost

    private void txtNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameFocusLost

    private void btnConfirmarElimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarElimActionPerformed
        // TODO add your handling code here:
        String id = txtId.getText().trim();
        if (id.equals("")) {
            Messages.showMessageDialog("Debe buscar el producto a eliminar", "Atención");
            txtId.requestFocus();
            return;
        }
        try{
            Long productId = Long.parseLong(id);
            Product prod = productService.findProductById(productId);
            if (prod != null) {
                if (Messages.showConfirmDialog("Está seguro que desea eliminar este producto?", "Confirmación") == JOptionPane.YES_NO_OPTION) {
                    if (productService.deleteProduct(productId)) {
                        Messages.showMessageDialog("Producto eliminado con éxito", "Atención");
                        stateInitial();
                        cleanControls();
                    }
                }
            }
        }catch(NumberFormatException e){
            
        }
        
    }//GEN-LAST:event_btnConfirmarElimActionPerformed
    private void stateEdit() {
        btnNuevo.setVisible(false);
        btnEditar.setVisible(false);
        btnEliminar.setVisible(true);
        btnCancelar.setVisible(true);
        btnCerrar.setVisible(false);
        btnSave.setVisible(true);
        btnFind.setVisible(false);
        txtId.setEnabled(true);
        txtName.setEnabled(true);
        txtDescription.setEnabled(true);
    }

    private void stateInitial() {
        btnNuevo.setVisible(true);
        btnEditar.setVisible(true);
        btnEliminar.setVisible(true);
        btnCancelar.setVisible(false);
        btnCerrar.setVisible(true);
        btnSave.setVisible(false);
        btnFind.setVisible(true);
        txtId.setEnabled(false);
        txtName.setEnabled(false);
        txtDescription.setEnabled(false);
        
        btnConfirmar.setVisible(false);
        txtId.setVisible(true);
        txtName.setVisible(true);
        txtDescription.setVisible(true);
        listCategories.setVisible(true);
        jLabel2.setVisible(true);
        jLabel3.setVisible(true);
        jLabel4.setVisible(true);

    }
    
    private void stateElim() {
        btnNuevo.setVisible(false);
        btnEditar.setVisible(false);
        btnEliminar.setVisible(false);
        btnCancelar.setVisible(true);
        btnCerrar.setVisible(false);
        btnSave.setVisible(false);
        btnFind.setVisible(false);
        btnConfirmar.setVisible(true);
        txtId.setVisible(true);
        txtName.setVisible(false);
        txtDescription.setVisible(false);
        listCategories.setVisible(false);
        jLabel2.setVisible(false);
        jLabel3.setVisible(false);
        jLabel4.setVisible(false);
        txtId.setEnabled(true);
        txtName.setEnabled(false);
        txtDescription.setEnabled(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lbCaracteristicas;
    private javax.swing.JLabel lbImages;
    private javax.swing.JLabel lbKeywords;
    private javax.swing.JLabel lbPrice;
    private javax.swing.JLabel lbSlug;
    private javax.swing.JLabel lbStock;
    private javax.swing.JList<String> listCategories;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlSouth;
    private javax.swing.JTextField txtCaracteristicas;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtImages;
    private javax.swing.JTextField txtKeywords;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtSlug;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables

    private void stateNew() {
        btnNuevo.setVisible(false);
        btnEditar.setVisible(false);
        btnEliminar.setVisible(false);
        btnCancelar.setVisible(true);
        btnCerrar.setVisible(false);
        btnSave.setVisible(true);
        btnFind.setVisible(false);
        txtId.setEnabled(false);
        txtName.setEnabled(true);
        txtDescription.setEnabled(true);

    }

    private void cleanControls() {
        txtId.setText("");
        txtName.setText("");
        txtDescription.setText("");
    }

    private void addProduct() {
        String name = txtName.getText().trim();
        String description = txtDescription.getText();
        String slug = txtSlug.getText().trim();
        double price = Double.parseDouble( txtPrice.getText().trim());
        int stock = Integer.parseInt(txtStock.getText().trim());
        String keywords = txtKeywords.getText().trim();
        String images = txtImages.getText().trim();
        String characteristics = txtCaracteristicas.getText().trim();
        
        
        List<String> catSelect = listCategories.getSelectedValuesList();
        System.out.println("Pslug:"+ slug);
        System.out.println("PPrice:"+ price);
        System.out.println("Pstock:"+ stock);
        
        
        int m = catSelect.size();
        System.out.println("size de cat selec por el usuario: " + m);
        List<Category> lcats = categoryService.findAllCategories();
        List<Category> cats = new ArrayList<Category>();
        for(String strselected : catSelect){
            for(Category cat : lcats){
                System.out.println(cat.getName()+" "+strselected);
                if(cat.getName().equals(strselected)){
                    cats.add(cat);
                }
            }
        }
        System.out.println("categorias de un producto a aniadir:");
        for(Category cat : cats){
            System.out.println(cat.getName());
        }
        
        if (productService.saveProduct(name, description, slug, price, stock, keywords, images, characteristics, cats)) {
            Messages.showMessageDialog("Se grabó con éxito", "Atención");
            cleanControls();
            stateInitial();
        } else {
            Messages.showMessageDialog("Error al grabar, lo siento mucho", "Atención");
        }
    }

    private void editProduct() {
        
        
        String id = txtId.getText().trim();
        if (id.equals("")) {
            Messages.showMessageDialog("Debe buscar el producto a editar", "Atención");
            txtId.requestFocus();
            return;
        }
        try{
            Long productId = Long.parseLong(id);
            Product prod = new Product();
            prod.setName(txtName.getText().trim());
            prod.setDescription(txtDescription.getText().trim());

            if (productService.editProduct(productId, prod)) {
                Messages.showMessageDialog("Se editó con éxito", "Atención");
                cleanControls();
                stateInitial();
            } else {
                Messages.showMessageDialog("Error al editar, lo siento mucho", "Atención");
            }
        }catch(NumberFormatException e){
            
        }
    }
}