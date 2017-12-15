/*
 * DesktopApplication1View.java
 */

package desktopapplication1;

import Collections.CustomerList;
import Collections.OrderList;
import Collections.ProductList;
import org.jdesktop.application.Action;
import org.jdesktop.application.ResourceMap;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.FrameView;
import org.jdesktop.application.TaskMonitor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.Timer;
import javax.swing.Icon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import myapp.CorporateCustomer;
import myapp.Customer;
import myapp.Order;
import myapp.Product;
import myapp.RegularCustomer;
import utils.GUIFunctions;
import utils.Methods;

/**
 * The application's main frame.
 */
public class DesktopApplication1View extends FrameView {

ProductList productList=new ProductList();
CustomerList customerList=new CustomerList();
OrderList orderList=new OrderList();

    public DesktopApplication1View(SingleFrameApplication app) {
        super(app);
        //NETBEANS CODE
        initComponents();
        //************************************************************

        //setup methods
        addCategories();
        //************************************************************

        //load xml file of products
        //************************************************************
        productList.LoadProductList(productList);
        //************************************************************

        //load xml file of customer
        //************************************************************
        customerList.LoadCustomerList(customerList);
        //************************************************************

        //load orderFile
        //************************************************************
        orderList.LoadOrderList(orderList);
        //************************************************************

        //load customer details into combobox
        //************************************************************
        LoadCustomerDetailsinOrderForm();

        //load order details
        LoadProductDetailsinOrderForm();
        //************************************************************


        //NETBEANS CODE
        // status bar initialization - message timeout, idle icon and busy animation, etc
        ResourceMap resourceMap = getResourceMap();
        int messageTimeout = resourceMap.getInteger("StatusBar.messageTimeout");
        messageTimer = new Timer(messageTimeout, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                statusMessageLabel.setText("");
            }
        });
        messageTimer.setRepeats(false);
        int busyAnimationRate = resourceMap.getInteger("StatusBar.busyAnimationRate");
        for (int i = 0; i < busyIcons.length; i++) {
            busyIcons[i] = resourceMap.getIcon("StatusBar.busyIcons[" + i + "]");
        }
        busyIconTimer = new Timer(busyAnimationRate, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                busyIconIndex = (busyIconIndex + 1) % busyIcons.length;
                statusAnimationLabel.setIcon(busyIcons[busyIconIndex]);
            }
        });
        idleIcon = resourceMap.getIcon("StatusBar.idleIcon");
        statusAnimationLabel.setIcon(idleIcon);
        progressBar.setVisible(false);

        // connecting action tasks to status bar via TaskMonitor
        TaskMonitor taskMonitor = new TaskMonitor(getApplication().getContext());
        taskMonitor.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                String propertyName = evt.getPropertyName();
                if ("started".equals(propertyName)) {
                    if (!busyIconTimer.isRunning()) {
                        statusAnimationLabel.setIcon(busyIcons[0]);
                        busyIconIndex = 0;
                        busyIconTimer.start();
                    }
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(true);
                } else if ("done".equals(propertyName)) {
                    busyIconTimer.stop();
                    statusAnimationLabel.setIcon(idleIcon);
                    progressBar.setVisible(false);
                    progressBar.setValue(0);
                } else if ("message".equals(propertyName)) {
                    String text = (String)(evt.getNewValue());
                    statusMessageLabel.setText((text == null) ? "" : text);
                    messageTimer.restart();
                } else if ("progress".equals(propertyName)) {
                    int value = (Integer)(evt.getNewValue());
                    progressBar.setVisible(true);
                    progressBar.setIndeterminate(false);
                    progressBar.setValue(value);
                }
            }
        });
    }

    @Action
    public void showAboutBox() {
        if (aboutBox == null) {
            JFrame mainFrame = DesktopApplication1.getApplication().getMainFrame();
            aboutBox = new DesktopApplication1AboutBox(mainFrame);
            aboutBox.setLocationRelativeTo(mainFrame);
        }
        DesktopApplication1.getApplication().show(aboutBox);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        btnAddCustomer = new javax.swing.JButton();
        txtBalance = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        btnAddCorporateCustomer = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btnPrevCustomer = new javax.swing.JButton();
        btnFirstCustomer = new javax.swing.JButton();
        btnNextCustomer = new javax.swing.JButton();
        btnLastCustomer = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        panelCorporateDetails = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txtContactName = new javax.swing.JTextField();
        txtWebSite = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        JLablel15 = new javax.swing.JLabel();
        btnUpdateCustomer = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtProductID = new javax.swing.JTextField();
        txtCategory = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        txtStockQuantity = new javax.swing.JTextField();
        txtImage = new javax.swing.JTextField();
        txtProductName = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtProductDesc = new javax.swing.JTextArea();
        btnAddProduct = new javax.swing.JButton();
        btnSetImage = new javax.swing.JButton();
        cboCategories = new javax.swing.JComboBox();
        jPanel6 = new javax.swing.JPanel();
        btnPrevProduct = new javax.swing.JButton();
        btnFirstProduct = new javax.swing.JButton();
        btnNextProduct = new javax.swing.JButton();
        btnLastProduct = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        btnUpdateProduct = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txtOrderID = new javax.swing.JTextField();
        txtOrderDate = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        txtID1 = new javax.swing.JTextField();
        txtName1 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAddress1 = new javax.swing.JTextArea();
        txtBalance1 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        cboCustomerDetails = new javax.swing.JComboBox();
        jLabel23 = new javax.swing.JLabel();
        panelProductsOrdered = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        cboOrderedProducts = new javax.swing.JComboBox();
        jLabel25 = new javax.swing.JLabel();
        txtOrderTotal = new javax.swing.JTextField();
        listOrderedProducts = new java.awt.List();
        jLabel26 = new javax.swing.JLabel();
        btnCreateOrder = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        txtOrderID1 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtOrderDate1 = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        txtID2 = new javax.swing.JTextField();
        txtName2 = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtAddress2 = new javax.swing.JTextArea();
        txtBalance2 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        btnPrevOrder = new javax.swing.JButton();
        btnFirstOrder = new javax.swing.JButton();
        btnNextOrder = new javax.swing.JButton();
        btnLastOrder = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        listOrderedProducts1 = new java.awt.List();
        txtOrderTotal1 = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        javax.swing.JMenu fileMenu = new javax.swing.JMenu();
        mnuLoadProducts = new javax.swing.JMenuItem();
        mnuSaveProducts = new javax.swing.JMenuItem();
        mnuLoadCustomers = new javax.swing.JMenuItem();
        mnuSaveCustomers = new javax.swing.JMenuItem();
        javax.swing.JMenuItem exitMenuItem = new javax.swing.JMenuItem();
        javax.swing.JMenu helpMenu = new javax.swing.JMenu();
        javax.swing.JMenuItem aboutMenuItem = new javax.swing.JMenuItem();
        statusPanel = new javax.swing.JPanel();
        javax.swing.JSeparator statusPanelSeparator = new javax.swing.JSeparator();
        statusMessageLabel = new javax.swing.JLabel();
        statusAnimationLabel = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();
        lblStatus = new javax.swing.JLabel();

        mainPanel.setName("mainPanel"); // NOI18N

        jTabbedPane1.setName("jTabbedPane1"); // NOI18N

        jPanel1.setName("jPanel1"); // NOI18N

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(desktopapplication1.DesktopApplication1.class).getContext().getResourceMap(DesktopApplication1View.class);
        jLabel1.setText(resourceMap.getString("jLabel1.text")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        txtID.setText(resourceMap.getString("txtID.text")); // NOI18N
        txtID.setName("txtID"); // NOI18N

        jLabel2.setText(resourceMap.getString("jLabel2.text")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        txtName.setText(resourceMap.getString("txtName.text")); // NOI18N
        txtName.setName("txtName"); // NOI18N

        javax.swing.ActionMap actionMap = org.jdesktop.application.Application.getInstance(desktopapplication1.DesktopApplication1.class).getContext().getActionMap(DesktopApplication1View.class, this);
        btnAddCustomer.setAction(actionMap.get("addCustomer")); // NOI18N
        btnAddCustomer.setToolTipText(resourceMap.getString("btnAddCustomer.toolTipText")); // NOI18N
        btnAddCustomer.setLabel(resourceMap.getString("btnAddCustomer.label")); // NOI18N
        btnAddCustomer.setName("btnAddCustomer"); // NOI18N
        btnAddCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCustomerActionPerformed(evt);
            }
        });

        txtBalance.setText(resourceMap.getString("txtBalance.text")); // NOI18N
        txtBalance.setName("txtBalance"); // NOI18N

        jLabel3.setText(resourceMap.getString("jLabel3.text")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        jLabel4.setText(resourceMap.getString("jLabel4.text")); // NOI18N
        jLabel4.setName("jLabel4"); // NOI18N

        jScrollPane1.setName("jScrollPane1"); // NOI18N

        txtAddress.setColumns(20);
        txtAddress.setRows(5);
        txtAddress.setText(resourceMap.getString("txtAddress.text")); // NOI18N
        txtAddress.setName("txtAddress"); // NOI18N
        jScrollPane1.setViewportView(txtAddress);

        btnAddCorporateCustomer.setText(resourceMap.getString("btnAddCorporateCustomer.text")); // NOI18N
        btnAddCorporateCustomer.setName("btnAddCorporateCustomer"); // NOI18N
        btnAddCorporateCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCorporateCustomerActionPerformed(evt);
            }
        });

        jPanel5.setName("jPanel5"); // NOI18N

        btnPrevCustomer.setText(resourceMap.getString("btnPrevCustomer.text")); // NOI18N
        btnPrevCustomer.setName("btnPrevCustomer"); // NOI18N
        btnPrevCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevCustomerActionPerformed(evt);
            }
        });

        btnFirstCustomer.setText(resourceMap.getString("btnFirstCustomer.text")); // NOI18N
        btnFirstCustomer.setName("btnFirstCustomer"); // NOI18N
        btnFirstCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstCustomerActionPerformed(evt);
            }
        });

        btnNextCustomer.setText(resourceMap.getString("btnNextCustomer.text")); // NOI18N
        btnNextCustomer.setName("btnNextCustomer"); // NOI18N
        btnNextCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextCustomerActionPerformed(evt);
            }
        });

        btnLastCustomer.setText(resourceMap.getString("btnLastCustomer.text")); // NOI18N
        btnLastCustomer.setName("btnLastCustomer"); // NOI18N
        btnLastCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastCustomerActionPerformed(evt);
            }
        });

        jLabel15.setText(resourceMap.getString("jLabel15.text")); // NOI18N
        jLabel15.setName("jLabel15"); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnFirstCustomer)
                        .addGap(18, 18, 18)
                        .addComponent(btnPrevCustomer)
                        .addGap(18, 18, 18)
                        .addComponent(btnNextCustomer)
                        .addGap(10, 10, 10)
                        .addComponent(btnLastCustomer))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jLabel15)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFirstCustomer)
                    .addComponent(btnPrevCustomer)
                    .addComponent(btnNextCustomer)
                    .addComponent(btnLastCustomer))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        panelCorporateDetails.setName("panelCorporateDetails"); // NOI18N

        jLabel13.setText(resourceMap.getString("jLabel13.text")); // NOI18N
        jLabel13.setName("jLabel13"); // NOI18N

        txtContactName.setText(resourceMap.getString("txtContactName.text")); // NOI18N
        txtContactName.setName("txtContactName"); // NOI18N

        txtWebSite.setText(resourceMap.getString("txtWebSite.text")); // NOI18N
        txtWebSite.setName("txtWebSite"); // NOI18N

        jLabel14.setText(resourceMap.getString("jLabel14.text")); // NOI18N
        jLabel14.setName("jLabel14"); // NOI18N

        txtEmail.setText(resourceMap.getString("txtEmail.text")); // NOI18N
        txtEmail.setName("txtEmail"); // NOI18N

        JLablel15.setText(resourceMap.getString("JLablel15.text")); // NOI18N
        JLablel15.setName("JLablel15"); // NOI18N

        javax.swing.GroupLayout panelCorporateDetailsLayout = new javax.swing.GroupLayout(panelCorporateDetails);
        panelCorporateDetails.setLayout(panelCorporateDetailsLayout);
        panelCorporateDetailsLayout.setHorizontalGroup(
            panelCorporateDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCorporateDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCorporateDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(JLablel15))
                .addGap(35, 35, 35)
                .addGroup(panelCorporateDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtWebSite, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                    .addComponent(txtContactName, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelCorporateDetailsLayout.setVerticalGroup(
            panelCorporateDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCorporateDetailsLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panelCorporateDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtContactName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCorporateDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtWebSite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCorporateDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLablel15)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btnUpdateCustomer.setText(resourceMap.getString("btnUpdateCustomer.text")); // NOI18N
        btnUpdateCustomer.setName("btnUpdateCustomer"); // NOI18N
        btnUpdateCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateCustomerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnAddCustomer)
                                .addGap(41, 41, 41)
                                .addComponent(btnAddCorporateCustomer)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                                .addComponent(btnUpdateCustomer)
                                .addGap(41, 41, 41))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(61, 61, 61)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtID)
                                        .addComponent(txtName)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 155, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(panelCorporateDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtBalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelCorporateDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAddCustomer)
                            .addComponent(btnAddCorporateCustomer)
                            .addComponent(btnUpdateCustomer))))
                .addGap(36, 36, 36))
        );

        jTabbedPane1.addTab(resourceMap.getString("jPanel1.TabConstraints.tabTitle"), jPanel1); // NOI18N

        jPanel2.setName("jPanel2"); // NOI18N

        jLabel5.setText(resourceMap.getString("jLabel5.text")); // NOI18N
        jLabel5.setName("jLabel5"); // NOI18N

        jLabel6.setText(resourceMap.getString("jLabel6.text")); // NOI18N
        jLabel6.setName("jLabel6"); // NOI18N

        jLabel7.setText(resourceMap.getString("jLabel7.text")); // NOI18N
        jLabel7.setName("jLabel7"); // NOI18N

        jLabel8.setText(resourceMap.getString("jLabel8.text")); // NOI18N
        jLabel8.setName("jLabel8"); // NOI18N

        jLabel9.setText(resourceMap.getString("jLabel9.text")); // NOI18N
        jLabel9.setName("jLabel9"); // NOI18N

        jLabel10.setText(resourceMap.getString("jLabel10.text")); // NOI18N
        jLabel10.setName("jLabel10"); // NOI18N

        jLabel11.setText(resourceMap.getString("jLabel11.text")); // NOI18N
        jLabel11.setName("jLabel11"); // NOI18N

        txtProductID.setText(resourceMap.getString("txtProductID.text")); // NOI18N
        txtProductID.setName("txtProductID"); // NOI18N

        txtCategory.setText(resourceMap.getString("txtCategory.text")); // NOI18N
        txtCategory.setName("txtCategory"); // NOI18N

        txtPrice.setText(resourceMap.getString("txtPrice.text")); // NOI18N
        txtPrice.setName("txtPrice"); // NOI18N

        txtStockQuantity.setText(resourceMap.getString("txtStockQuantity.text")); // NOI18N
        txtStockQuantity.setName("txtStockQuantity"); // NOI18N

        txtImage.setText(resourceMap.getString("txtImage.text")); // NOI18N
        txtImage.setName("txtImage"); // NOI18N

        txtProductName.setText(resourceMap.getString("txtProductName.text")); // NOI18N
        txtProductName.setName("txtProductName"); // NOI18N

        jScrollPane2.setName("jScrollPane2"); // NOI18N

        txtProductDesc.setColumns(20);
        txtProductDesc.setRows(5);
        txtProductDesc.setName("txtProductDesc"); // NOI18N
        jScrollPane2.setViewportView(txtProductDesc);

        btnAddProduct.setText(resourceMap.getString("btnAddProduct.text")); // NOI18N
        btnAddProduct.setName("btnAddProduct"); // NOI18N
        btnAddProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProductActionPerformed(evt);
            }
        });

        btnSetImage.setText(resourceMap.getString("btnSetImage.text")); // NOI18N
        btnSetImage.setName("btnSetImage"); // NOI18N
        btnSetImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetImageActionPerformed(evt);
            }
        });

        cboCategories.setName("cboCategories"); // NOI18N
        cboCategories.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCategoriesActionPerformed(evt);
            }
        });

        jPanel6.setName("jPanel6"); // NOI18N

        btnPrevProduct.setText(resourceMap.getString("btnPrevProduct.text")); // NOI18N
        btnPrevProduct.setName("btnPrevProduct"); // NOI18N
        btnPrevProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevProductActionPerformed(evt);
            }
        });

        btnFirstProduct.setText(resourceMap.getString("btnFirstProduct.text")); // NOI18N
        btnFirstProduct.setName("btnFirstProduct"); // NOI18N
        btnFirstProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstProductActionPerformed(evt);
            }
        });

        btnNextProduct.setText(resourceMap.getString("btnNextProduct.text")); // NOI18N
        btnNextProduct.setName("btnNextProduct"); // NOI18N
        btnNextProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextProductActionPerformed(evt);
            }
        });

        btnLastProduct.setText(resourceMap.getString("btnLastProduct.text")); // NOI18N
        btnLastProduct.setName("btnLastProduct"); // NOI18N
        btnLastProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastProductActionPerformed(evt);
            }
        });

        jLabel12.setText(resourceMap.getString("jLabel12.text")); // NOI18N
        jLabel12.setName("jLabel12"); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnFirstProduct)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnPrevProduct)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnNextProduct)
                        .addGap(10, 10, 10)
                        .addComponent(btnLastProduct))
                    .addComponent(jLabel12)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addGap(12, 12, 12)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFirstProduct)
                    .addComponent(btnPrevProduct)
                    .addComponent(btnNextProduct)
                    .addComponent(btnLastProduct))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        btnUpdateProduct.setText(resourceMap.getString("btnUpdateProduct.text")); // NOI18N
        btnUpdateProduct.setName("btnUpdateProduct"); // NOI18N
        btnUpdateProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateProductActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8))
                        .addGap(75, 75, 75)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtImage, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSetImage))
                            .addComponent(txtStockQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(btnUpdateProduct)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtProductID, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                                            .addComponent(txtProductName, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)
                                            .addComponent(txtCategory, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cboCategories, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(266, 266, 266))))
                    .addComponent(btnAddProduct)
                    .addComponent(jLabel11))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtProductID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel9))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboCategories, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel10))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSetImage))
                    .addComponent(jLabel8))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(txtStockQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAddProduct)
                            .addComponent(btnUpdateProduct))
                        .addContainerGap(53, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        jTabbedPane1.addTab(resourceMap.getString("jPanel2.TabConstraints.tabTitle"), jPanel2); // NOI18N

        jPanel3.setName("jPanel3"); // NOI18N

        jLabel16.setText(resourceMap.getString("jLabel16.text")); // NOI18N
        jLabel16.setName("jLabel16"); // NOI18N

        txtOrderID.setText(resourceMap.getString("txtOrderID.text")); // NOI18N
        txtOrderID.setName("txtOrderID"); // NOI18N

        txtOrderDate.setText(resourceMap.getString("txtOrderDate.text")); // NOI18N
        txtOrderDate.setName("txtOrderDate"); // NOI18N

        jLabel17.setText(resourceMap.getString("jLabel17.text")); // NOI18N
        jLabel17.setName("jLabel17"); // NOI18N

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel7.setName("jPanel7"); // NOI18N

        txtID1.setEditable(false);
        txtID1.setText(resourceMap.getString("txtID1.text")); // NOI18N
        txtID1.setName("txtID1"); // NOI18N

        txtName1.setText(resourceMap.getString("txtName1.text")); // NOI18N
        txtName1.setName("txtName1"); // NOI18N

        jScrollPane3.setName("jScrollPane3"); // NOI18N

        txtAddress1.setColumns(20);
        txtAddress1.setRows(5);
        txtAddress1.setText(resourceMap.getString("txtAddress1.text")); // NOI18N
        txtAddress1.setName("txtAddress1"); // NOI18N
        jScrollPane3.setViewportView(txtAddress1);

        txtBalance1.setText(resourceMap.getString("txtBalance1.text")); // NOI18N
        txtBalance1.setName("txtBalance1"); // NOI18N

        jLabel18.setText(resourceMap.getString("jLabel18.text")); // NOI18N
        jLabel18.setName("jLabel18"); // NOI18N

        jLabel19.setText(resourceMap.getString("jLabel19.text")); // NOI18N
        jLabel19.setName("jLabel19"); // NOI18N

        jLabel20.setText(resourceMap.getString("jLabel20.text")); // NOI18N
        jLabel20.setName("jLabel20"); // NOI18N

        jLabel21.setText(resourceMap.getString("jLabel21.text")); // NOI18N
        jLabel21.setName("jLabel21"); // NOI18N

        jLabel22.setText(resourceMap.getString("jLabel22.text")); // NOI18N
        jLabel22.setName("jLabel22"); // NOI18N

        cboCustomerDetails.setName("cboCustomerDetails"); // NOI18N
        cboCustomerDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboCustomerDetailsActionPerformed(evt);
            }
        });

        jLabel23.setText(resourceMap.getString("jLabel23.text")); // NOI18N
        jLabel23.setName("jLabel23"); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addContainerGap())
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel19)
                            .addComponent(jLabel18)
                            .addComponent(jLabel21)
                            .addComponent(jLabel23))
                        .addGap(61, 61, 61)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtID1, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(txtBalance1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtName1)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))
                            .addComponent(cboCustomerDetails, 0, 193, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboCustomerDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel21)
                    .addComponent(txtID1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel20))
                    .addComponent(txtName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(txtBalance1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(104, 104, 104))
        );

        panelProductsOrdered.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelProductsOrdered.setName("panelProductsOrdered"); // NOI18N

        jLabel24.setText(resourceMap.getString("jLabel24.text")); // NOI18N
        jLabel24.setName("jLabel24"); // NOI18N

        cboOrderedProducts.setToolTipText(resourceMap.getString("cboOrderedProducts.toolTipText")); // NOI18N
        cboOrderedProducts.setName("cboOrderedProducts"); // NOI18N
        cboOrderedProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboOrderedProductsActionPerformed(evt);
            }
        });

        jLabel25.setText(resourceMap.getString("jLabel25.text")); // NOI18N
        jLabel25.setName("jLabel25"); // NOI18N

        txtOrderTotal.setEditable(false);
        txtOrderTotal.setText(resourceMap.getString("txtOrderTotal.text")); // NOI18N
        txtOrderTotal.setName("txtOrderTotal"); // NOI18N

        listOrderedProducts.setName("listOrderedProducts"); // NOI18N
        listOrderedProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listOrderedProductsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                listOrderedProductsMouseEntered(evt);
            }
        });
        listOrderedProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listOrderedProductsActionPerformed(evt);
            }
        });

        jLabel26.setText(resourceMap.getString("jLabel26.text")); // NOI18N
        jLabel26.setName("jLabel26"); // NOI18N

        javax.swing.GroupLayout panelProductsOrderedLayout = new javax.swing.GroupLayout(panelProductsOrdered);
        panelProductsOrdered.setLayout(panelProductsOrderedLayout);
        panelProductsOrderedLayout.setHorizontalGroup(
            panelProductsOrderedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProductsOrderedLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelProductsOrderedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelProductsOrderedLayout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addGap(38, 38, 38)
                        .addComponent(cboOrderedProducts, 0, 291, Short.MAX_VALUE))
                    .addGroup(panelProductsOrderedLayout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addGap(56, 56, 56)
                        .addComponent(txtOrderTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 189, Short.MAX_VALUE))
                    .addComponent(jLabel26)
                    .addComponent(listOrderedProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        panelProductsOrderedLayout.setVerticalGroup(
            panelProductsOrderedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProductsOrderedLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelProductsOrderedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(cboOrderedProducts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(jLabel26)
                .addGap(9, 9, 9)
                .addComponent(listOrderedProducts, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelProductsOrderedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(txtOrderTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        btnCreateOrder.setText(resourceMap.getString("btnCreateOrder.text")); // NOI18N
        btnCreateOrder.setName("btnCreateOrder"); // NOI18N
        btnCreateOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateOrderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17))
                        .addGap(82, 82, 82)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtOrderID)
                            .addComponent(txtOrderDate, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)))
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCreateOrder)
                    .addComponent(panelProductsOrdered, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(panelProductsOrdered, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCreateOrder))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txtOrderID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtOrderDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab(resourceMap.getString("jPanel3.TabConstraints.tabTitle"), jPanel3); // NOI18N

        jPanel4.setName("jPanel4"); // NOI18N

        txtOrderID1.setText(resourceMap.getString("txtOrderID1.text")); // NOI18N
        txtOrderID1.setName("txtOrderID1"); // NOI18N

        jLabel27.setText(resourceMap.getString("jLabel27.text")); // NOI18N
        jLabel27.setName("jLabel27"); // NOI18N

        jLabel28.setText(resourceMap.getString("jLabel28.text")); // NOI18N
        jLabel28.setName("jLabel28"); // NOI18N

        txtOrderDate1.setText(resourceMap.getString("txtOrderDate1.text")); // NOI18N
        txtOrderDate1.setName("txtOrderDate1"); // NOI18N

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel8.setName("jPanel8"); // NOI18N

        txtID2.setEditable(false);
        txtID2.setText(resourceMap.getString("txtID2.text")); // NOI18N
        txtID2.setName("txtID2"); // NOI18N

        txtName2.setText(resourceMap.getString("txtName2.text")); // NOI18N
        txtName2.setName("txtName2"); // NOI18N

        jScrollPane4.setName("jScrollPane4"); // NOI18N

        txtAddress2.setColumns(20);
        txtAddress2.setRows(5);
        txtAddress2.setText(resourceMap.getString("txtAddress2.text")); // NOI18N
        txtAddress2.setName("txtAddress2"); // NOI18N
        jScrollPane4.setViewportView(txtAddress2);

        txtBalance2.setText(resourceMap.getString("txtBalance2.text")); // NOI18N
        txtBalance2.setName("txtBalance2"); // NOI18N

        jLabel29.setText(resourceMap.getString("jLabel29.text")); // NOI18N
        jLabel29.setName("jLabel29"); // NOI18N

        jLabel30.setText(resourceMap.getString("jLabel30.text")); // NOI18N
        jLabel30.setName("jLabel30"); // NOI18N

        jLabel31.setText(resourceMap.getString("jLabel31.text")); // NOI18N
        jLabel31.setName("jLabel31"); // NOI18N

        jLabel32.setText(resourceMap.getString("jLabel32.text")); // NOI18N
        jLabel32.setName("jLabel32"); // NOI18N

        jLabel33.setText(resourceMap.getString("jLabel33.text")); // NOI18N
        jLabel33.setName("jLabel33"); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31)
                            .addComponent(jLabel30)
                            .addComponent(jLabel29)
                            .addComponent(jLabel32))
                        .addGap(65, 65, 65)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtID2, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(txtBalance2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtName2)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel32)
                    .addComponent(txtID2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel31))
                    .addComponent(txtName2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29)
                    .addComponent(txtBalance2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(104, 104, 104))
        );

        jPanel9.setName("jPanel9"); // NOI18N

        btnPrevOrder.setText(resourceMap.getString("btnPrevOrder.text")); // NOI18N
        btnPrevOrder.setName("btnPrevOrder"); // NOI18N
        btnPrevOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevOrderActionPerformed(evt);
            }
        });

        btnFirstOrder.setText(resourceMap.getString("btnFirstOrder.text")); // NOI18N
        btnFirstOrder.setName("btnFirstOrder"); // NOI18N
        btnFirstOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstOrderActionPerformed(evt);
            }
        });

        btnNextOrder.setText(resourceMap.getString("btnNextOrder.text")); // NOI18N
        btnNextOrder.setName("btnNextOrder"); // NOI18N
        btnNextOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextOrderActionPerformed(evt);
            }
        });

        btnLastOrder.setText(resourceMap.getString("btnLastOrder.text")); // NOI18N
        btnLastOrder.setName("btnLastOrder"); // NOI18N
        btnLastOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastOrderActionPerformed(evt);
            }
        });

        jLabel34.setText(resourceMap.getString("jLabel34.text")); // NOI18N
        jLabel34.setName("jLabel34"); // NOI18N

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnFirstOrder)
                        .addGap(18, 18, 18)
                        .addComponent(btnPrevOrder)
                        .addGap(18, 18, 18)
                        .addComponent(btnNextOrder)
                        .addGap(10, 10, 10)
                        .addComponent(btnLastOrder))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jLabel34)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel34)
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFirstOrder)
                    .addComponent(btnPrevOrder)
                    .addComponent(btnNextOrder)
                    .addComponent(btnLastOrder))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel10.setName("jPanel10"); // NOI18N

        jLabel35.setText(resourceMap.getString("jLabel35.text")); // NOI18N
        jLabel35.setName("jLabel35"); // NOI18N

        listOrderedProducts1.setName("listOrderedProducts1"); // NOI18N
        listOrderedProducts1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listOrderedProducts1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                listOrderedProducts1MouseEntered(evt);
            }
        });
        listOrderedProducts1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listOrderedProducts1ActionPerformed(evt);
            }
        });

        txtOrderTotal1.setEditable(false);
        txtOrderTotal1.setText(resourceMap.getString("txtOrderTotal1.text")); // NOI18N
        txtOrderTotal1.setName("txtOrderTotal1"); // NOI18N

        jLabel36.setText(resourceMap.getString("jLabel36.text")); // NOI18N
        jLabel36.setName("jLabel36"); // NOI18N

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 377, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel10Layout.createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel10Layout.createSequentialGroup()
                            .addComponent(jLabel36)
                            .addGap(56, 56, 56)
                            .addComponent(txtOrderTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel35)
                        .addComponent(listOrderedProducts1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(14, Short.MAX_VALUE)))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel10Layout.createSequentialGroup()
                    .addGap(35, 35, 35)
                    .addComponent(jLabel35)
                    .addGap(9, 9, 9)
                    .addComponent(listOrderedProducts1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel36)
                        .addComponent(txtOrderTotal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(36, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addComponent(jLabel28))
                        .addGap(82, 82, 82)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtOrderID1)
                            .addComponent(txtOrderDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(txtOrderID1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtOrderDate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab(resourceMap.getString("jPanel4.TabConstraints.tabTitle"), jPanel4); // NOI18N

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 756, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
                .addGap(433, 433, 433))
        );

        menuBar.setName("menuBar"); // NOI18N

        fileMenu.setText(resourceMap.getString("fileMenu.text")); // NOI18N

        mnuLoadProducts.setText(resourceMap.getString("mnuLoadProducts.text")); // NOI18N
        mnuLoadProducts.setName("mnuLoadProducts"); // NOI18N
        mnuLoadProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuLoadProductsActionPerformed(evt);
            }
        });
        fileMenu.add(mnuLoadProducts);

        mnuSaveProducts.setText(resourceMap.getString("mnuSaveProducts.text")); // NOI18N
        mnuSaveProducts.setName("mnuSaveProducts"); // NOI18N
        mnuSaveProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSaveProductsActionPerformed(evt);
            }
        });
        fileMenu.add(mnuSaveProducts);

        mnuLoadCustomers.setText(resourceMap.getString("mnuLoadCustomers.text")); // NOI18N
        mnuLoadCustomers.setName("mnuLoadCustomers"); // NOI18N
        mnuLoadCustomers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuLoadCustomersActionPerformed(evt);
            }
        });
        fileMenu.add(mnuLoadCustomers);

        mnuSaveCustomers.setText(resourceMap.getString("mnuSaveCustomers.text")); // NOI18N
        mnuSaveCustomers.setName("mnuSaveCustomers"); // NOI18N
        mnuSaveCustomers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSaveCustomersActionPerformed(evt);
            }
        });
        fileMenu.add(mnuSaveCustomers);

        exitMenuItem.setAction(actionMap.get("quit")); // NOI18N
        exitMenuItem.setName("exitMenuItem"); // NOI18N
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        helpMenu.setText(resourceMap.getString("helpMenu.text")); // NOI18N
        helpMenu.setName("helpMenu"); // NOI18N

        aboutMenuItem.setAction(actionMap.get("showAboutBox")); // NOI18N
        aboutMenuItem.setName("aboutMenuItem"); // NOI18N
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        statusPanel.setName("statusPanel"); // NOI18N

        statusPanelSeparator.setName("statusPanelSeparator"); // NOI18N

        statusMessageLabel.setName("statusMessageLabel"); // NOI18N

        statusAnimationLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        statusAnimationLabel.setName("statusAnimationLabel"); // NOI18N

        progressBar.setName("progressBar"); // NOI18N

        lblStatus.setText(resourceMap.getString("lblStatus.text")); // NOI18N
        lblStatus.setName("lblStatus"); // NOI18N

        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(statusPanelSeparator, javax.swing.GroupLayout.DEFAULT_SIZE, 807, Short.MAX_VALUE)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(statusMessageLabel)
                    .addComponent(lblStatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 602, Short.MAX_VALUE)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusAnimationLabel)
                .addContainerGap())
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addComponent(statusPanelSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(statusPanelLayout.createSequentialGroup()
                        .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(statusMessageLabel)
                            .addComponent(statusAnimationLabel)
                            .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3))
                    .addComponent(lblStatus)))
        );

        setComponent(mainPanel);
        setMenuBar(menuBar);
        setStatusBar(statusPanel);
    }// </editor-fold>//GEN-END:initComponents

    private void cboCategoriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCategoriesActionPerformed
        // TODO add your handling code here:
        Object s=cboCategories.getSelectedItem();
        System.out.println(s.toString());

    }//GEN-LAST:event_cboCategoriesActionPerformed

    private void btnSetImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetImageActionPerformed
        // TODO add your handling code here:
        String sFile=GUIFunctions.openFileDialog(true);
        if(sFile!="")
            txtImage.setText(sFile);
    }//GEN-LAST:event_btnSetImageActionPerformed

    private void btnAddProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProductActionPerformed
        // TODO add your handling code here:

        int id=Methods.StringToInt(txtProductID.getText());
        String sName=txtProductName.getText();
        String sDesc=txtProductDesc.getText();
        String sCat=txtCategory.getText();
        double productPrice=Methods.StringToDouble(txtPrice.getText());
        int stockQ=Methods.StringToInt(txtStockQuantity.getText());
        String sImg=txtImage.getText();

        //int ID,String sName, String sDecription ,double price,String sProductImage,String sCat
        Product p=new Product(id,sName,sDesc,productPrice,sImg,sCat);

        productList.add(p);

        //save product to file
        productList.SaveProductList();

        GUIFunctions.showMsgBox("Added New Product.");

        p.display();
}//GEN-LAST:event_btnAddProductActionPerformed

    private void btnAddCorporateCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCorporateCustomerActionPerformed
        // TODO add your handling code here:

        int id=Methods.StringToInt(txtID.getText());
        String sName=txtName.getText();
        String sAddress=txtAddress.getText();
        double balance=Methods.StringToDouble(txtBalance.getText());

        String sEmail=txtEmail.getText();
        String sContactName=txtContactName.getText();
        String sWebsite=txtWebSite.getText();

        Customer c=new CorporateCustomer(id,sName,sAddress,balance,sWebsite,sEmail,sContactName);

        customerList.add(c);

        lblStatus.setText("Added New Corporate Customer.");
        GUIFunctions.showMsgBox("Added New Corporate Customer.");
}//GEN-LAST:event_btnAddCorporateCustomerActionPerformed

    private void btnAddCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCustomerActionPerformed
        // TODO add your handling code here:
        int id=Methods.StringToInt(txtID.getText());
        String sName=txtName.getText();
        String sAddress=txtAddress.getText();
        double balance=Methods.StringToDouble(txtBalance.getText());

        Customer c=new RegularCustomer(id,sName,sAddress,balance);

        customerList.add(c);

        GUIFunctions.showMsgBox("Added New Customer.");

        //save to file
        customerList.SaveCustomerList();

        lblStatus.setText("Saved Customer Details to File");
}//GEN-LAST:event_btnAddCustomerActionPerformed

    private void btnFirstCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstCustomerActionPerformed
        // TODO add your handling code here:
        CurrentCustomerIndex=0;
        displayCustomer(CurrentCustomerIndex);
    }//GEN-LAST:event_btnFirstCustomerActionPerformed

    private void btnNextCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextCustomerActionPerformed
        // TODO add your handling code here
        if(CurrentCustomerIndex+1>-1 && CurrentCustomerIndex+1<customerList.size())
        {
            CurrentCustomerIndex++;
            displayCustomer(CurrentCustomerIndex);
        }
    }//GEN-LAST:event_btnNextCustomerActionPerformed

    private void btnPrevCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevCustomerActionPerformed
        // TODO add your handling code here:
        if(CurrentCustomerIndex-1>-1 && CurrentCustomerIndex-1<customerList.size())
        {
            CurrentCustomerIndex--;
            displayCustomer(CurrentCustomerIndex);
        }
    }//GEN-LAST:event_btnPrevCustomerActionPerformed

    private void btnLastCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastCustomerActionPerformed
        // TODO add your handling code here:
            CurrentCustomerIndex=customerList.size()-1;
            displayCustomer(CurrentCustomerIndex);
    }//GEN-LAST:event_btnLastCustomerActionPerformed

    private void btnPrevProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevProductActionPerformed
        // TODO add your handling code here:
       System.out.println("CurrentProductIndex "+CurrentProductIndex);
       System.out.println("productList.size() "+productList.size());

       if(CurrentProductIndex-1>-1 && CurrentProductIndex-1<productList.size())
        {
            CurrentProductIndex--;
            displayProduct(CurrentProductIndex);
            lblStatus.setText("Showing Previous Product.");
        }
    }//GEN-LAST:event_btnPrevProductActionPerformed

    private void btnFirstProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstProductActionPerformed
        // TODO add your handling code here:
        CurrentProductIndex=0;
        displayProduct(CurrentProductIndex);
        lblStatus.setText("Showing First Product." );

    }//GEN-LAST:event_btnFirstProductActionPerformed

    private void btnNextProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextProductActionPerformed
        // TODO add your handling code here:
        if(CurrentProductIndex>-1 && CurrentProductIndex+1<productList.size())
        {
            CurrentProductIndex++;
            displayProduct(CurrentProductIndex);
            lblStatus.setText("Showing Next Product.");
        }
    }//GEN-LAST:event_btnNextProductActionPerformed

    private void btnLastProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastProductActionPerformed
        // TODO add your handling code here:
        CurrentProductIndex=productList.size()-1;
        displayProduct(CurrentProductIndex);
        lblStatus.setText("Showing Last Product.");
    }//GEN-LAST:event_btnLastProductActionPerformed

    private void btnUpdateProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateProductActionPerformed
        // TODO add your handling code here:
        int id=Methods.StringToInt(txtProductID.getText());
        String sName=txtProductName.getText();
        String sDesc=txtProductDesc.getText();
        String sCat=txtCategory.getText();
        double productPrice=Methods.StringToDouble(txtPrice.getText());
        int stockQ=Methods.StringToInt(txtStockQuantity.getText());
        String sImg=txtImage.getText();

        Product p=new Product(id,sName,sDesc,productPrice,sImg,sCat);

        productList.updateProduct(CurrentProductIndex, p);

        lblStatus.setText("Updated Product.");
    }//GEN-LAST:event_btnUpdateProductActionPerformed

    private void mnuSaveCustomersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSaveCustomersActionPerformed
        // TODO add your handling code here:
        customerList.SaveCustomerList();
    }//GEN-LAST:event_mnuSaveCustomersActionPerformed

    private void mnuLoadCustomersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuLoadCustomersActionPerformed
        // TODO add your handling code here:
        customerList.LoadCustomerList(customerList);
    }//GEN-LAST:event_mnuLoadCustomersActionPerformed

    private void mnuLoadProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuLoadProductsActionPerformed
        // TODO add your handling code here:
        productList.LoadProductList(productList);
    }//GEN-LAST:event_mnuLoadProductsActionPerformed

    private void mnuSaveProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSaveProductsActionPerformed
        // TODO add your handling code here:
        productList.SaveProductList();
    }//GEN-LAST:event_mnuSaveProductsActionPerformed

    private void btnUpdateCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateCustomerActionPerformed
        // TODO add your handling code here:
        int id=Methods.StringToInt(txtID.getText());
        String sName=txtName.getText();
        String sAddress=txtAddress.getText();
        double balance=Methods.StringToDouble(txtBalance.getText());

        String sEmail=txtEmail.getText();
        String sContactName=txtContactName.getText();
        String sWebsite=txtWebSite.getText();

        Customer c1=new RegularCustomer(id,sName,sAddress,balance);
        //Customer c2=new CorporateCustomer(id,sName,sAddress,balance,sWebsite,sEmail,sContactName);

        //TO DO!! need to check if its regular or corporate
        customerList.updateCustomer(CurrentCustomerIndex, c1);

        //save to file
        customerList.SaveCustomerList();

        lblStatus.setText("Saved Customer Details to File");


    }//GEN-LAST:event_btnUpdateCustomerActionPerformed

    private void cboCustomerDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboCustomerDetailsActionPerformed
        // TODO add your handling code here:
        String s=cboCustomerDetails.getSelectedItem().toString();
        //search for customer
        Customer c=customerList.searchCustomerName(s);
        if(c!=null)
        {
            int id=c.getID();
            String sName=c.getsName();
            String sAddress=c.getsAddress();
            double dBalance=c.getBalance();

            //display details
            txtID1.setText(Methods.IntToString(id));
            txtName1.setText(c.getsName());
            txtAddress1.setText(c.getsAddress());
            txtBalance1.setText(Methods.DoubleToString(dBalance));
        }
    }//GEN-LAST:event_cboCustomerDetailsActionPerformed

    private void cboOrderedProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboOrderedProductsActionPerformed
        // TODO add your handling code here:

        String sProductName=cboOrderedProducts.getSelectedItem().toString();
        Product p=productList.searchProductName(sProductName);
        
        if(p!=null)
        {
            listOrderedProducts.add(sProductName);
            getOrderTotalAmount();
        }
    }//GEN-LAST:event_cboOrderedProductsActionPerformed

    private void listOrderedProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listOrderedProductsActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_listOrderedProductsActionPerformed

    private void listOrderedProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listOrderedProductsMouseClicked
        // TODO add your handling code here:
        if(listOrderedProducts.countItems()>0)
        {
            System.out.println(listOrderedProducts.getSelectedIndex());
            listOrderedProducts.remove(listOrderedProducts.getSelectedIndex());

            //todo update price
            getOrderTotalAmount();
        }
    }//GEN-LAST:event_listOrderedProductsMouseClicked

    private void btnCreateOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateOrderActionPerformed
        // TODO add your handling code here:

        int tot=0;
        int id=Methods.StringToInt(txtOrderID.getText());
        String sDate=txtOrderDate.getText();
        String sCustomerName;
        String sProductName;

        sCustomerName=cboCustomerDetails.getSelectedItem().toString();

        //get the customer object
        Customer c=customerList.searchCustomerName(sCustomerName);

        //tot of products ordered
        tot=listOrderedProducts.countItems();

        //get products
        if(tot>0)
        {
            Vector <Product> OrderedProducts =new Vector();
            //get an item
            for(int i=0;i<tot;i++)
            {
                sProductName=listOrderedProducts.getItem(i);

                Product p=productList.searchProductName(sProductName);
                if(p!=null)
                {
                    //add order to vector
                    OrderedProducts.add(p);
                }
            }
            //create order object
            Order o=new Order(id,sDate,c,OrderedProducts);
            o.display();
            orderList.add(o);
            //save order to fill
            orderList.SaveOrderList();
            lblStatus.setText("Created Order");
        }

        
        

    }//GEN-LAST:event_btnCreateOrderActionPerformed

    private void listOrderedProductsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listOrderedProductsMouseEntered
        // TODO add your handling code here:
        lblStatus.setText("Click on a Product to Remove From Order.");
    }//GEN-LAST:event_listOrderedProductsMouseEntered

    private void btnPrevOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevOrderActionPerformed
        // TODO add your handling code here:
        if(CurrentOrderIndex-1>-1 && CurrentOrderIndex-1<orderList.size())
        {
            CurrentOrderIndex--;
            displayOrder(CurrentOrderIndex);
            lblStatus.setText("Showing Previous Order.");
        }
    }//GEN-LAST:event_btnPrevOrderActionPerformed

    private void btnFirstOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstOrderActionPerformed
        // TODO add your handling code here:
        CurrentOrderIndex=0;
        displayOrder(CurrentOrderIndex);
    }//GEN-LAST:event_btnFirstOrderActionPerformed

    private void btnNextOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextOrderActionPerformed
        // TODO add your handling code here:
        if(CurrentOrderIndex>-1 && CurrentOrderIndex+1<orderList.size())
        {
            CurrentOrderIndex++;
            displayOrder(CurrentOrderIndex);
            lblStatus.setText("Showing Next Order.");
        }
    }//GEN-LAST:event_btnNextOrderActionPerformed

    private void btnLastOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastOrderActionPerformed
        // TODO add your handling code here:
        CurrentOrderIndex=orderList.size()-1;
        displayOrder(CurrentOrderIndex);
    }//GEN-LAST:event_btnLastOrderActionPerformed

    private void listOrderedProducts1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listOrderedProducts1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_listOrderedProducts1MouseClicked

    private void listOrderedProducts1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listOrderedProducts1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_listOrderedProducts1MouseEntered

    private void listOrderedProducts1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listOrderedProducts1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_listOrderedProducts1ActionPerformed

    //read each product name in the list and get the price
    //and add to the total text box
    public void getOrderTotalAmount()
    {
        int tot=listOrderedProducts.countItems();
        String sProductName;
        double itemPrice=0;
        double orderTotal=0;

        if(tot>0)
        {
            //get an item
            for(int i=0;i<tot;i++)
            {
                sProductName=listOrderedProducts.getItem(i);
                //get the price
                Product p=productList.searchProductName(sProductName);
                itemPrice=p.getPrice();
                orderTotal=orderTotal+itemPrice;
            }
            txtOrderTotal.setText(Methods.DoubleToString(orderTotal));
        }
        else
            txtOrderTotal.setText(Methods.DoubleToString(0));

    }


    private void addCategories()
    {
        //cboCategories.removeAllItems();
        cboCategories.addItem("DVD");
        cboCategories.addItem("Games");
        cboCategories.addItem("Books");
    }

    public void displayCustomer(int i)
    {
        //load data from vector
        //put in the text boxes
        Customer c=customerList.getCustomerByNumber(i);
        int id=c.getID();
        String sName=c.getsName();
        String sAddress=c.getsAddress();
        double dBalance=c.getBalance();


        txtID.setText(Methods.IntToString(id));
        txtName.setText(c.getsName());
        txtAddress.setText(c.getsAddress());
        txtBalance.setText(Methods.DoubleToString(dBalance));
    }

    public void displayProduct(int i)
    {
        Product p=productList.getProductByNumber(i);

        int id=p.getID();
        double dPrice=p.getPrice();
        int stockQuantity=p.getM_StockQuantity();

        txtProductID.setText(Methods.IntToString(id));
        txtProductName.setText(p.getsName());
        txtProductDesc.setText(p.getsDecription());
        txtCategory.setText(p.getM_Category());
        txtPrice.setText(Methods.DoubleToString(dPrice));
        txtStockQuantity.setText(Methods.IntToString(stockQuantity));
        txtImage.setText(p.getsImage());
    }

    public void displayOrder(int i)
    {
        Order o=orderList.getOrderByNumber(i);
        Customer c=o.getCustomer();

        //get details and display
        String orderid=Methods.IntToString(o.getId());
        String sDate=o.getdDate();
        String orderTotal=Methods.DoubleToString(orderList.getOrderTotal(i));

        //customer details
        String customerID=Methods.IntToString(c.getID());
        String sCustomerName=c.getsName();
        String sCustomerAddress=c.getsAddress();
        String bBalance=Methods.DoubleToString(c.getBalance());

        //display
        txtOrderID1.setText(orderid);
        txtOrderDate1.setText(sDate);

        txtID2.setText(customerID);
        txtName2.setText(sCustomerName);
        txtAddress2.setText(sCustomerAddress);
        txtBalance2.setText(bBalance);

        //get products order
        Vector <Product> orderedProducts=o.getProductsOrdered();

        listOrderedProducts1.clear();
        for(int x=0;x<orderedProducts.size();x++)
        {
            //add products to list
            listOrderedProducts1.add(orderedProducts.elementAt(x).getsName());
        }

        //display total
        txtOrderTotal1.setText(orderTotal);
    }

    public void LoadCustomerDetailsinOrderForm()
    {
        if(customerList.size()>0)
        {
            for(int i=0;i<customerList.size();i++)
            {
                Customer c=customerList.getCustomerByNumber(i);
                cboCustomerDetails.addItem(c.getsName());
            }
        }
    }


    public void LoadProductDetailsinOrderForm()
    {
        if(productList.size()>0)
        {
            for(int i=0;i<productList.size();i++)
            {
                Product p=productList.getProductByNumber(i);
                cboOrderedProducts.addItem(p.getsName());
            }
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLablel15;
    private javax.swing.JButton btnAddCorporateCustomer;
    private javax.swing.JButton btnAddCustomer;
    private javax.swing.JButton btnAddProduct;
    private javax.swing.JButton btnCreateOrder;
    private javax.swing.JButton btnFirstCustomer;
    private javax.swing.JButton btnFirstOrder;
    private javax.swing.JButton btnFirstProduct;
    private javax.swing.JButton btnLastCustomer;
    private javax.swing.JButton btnLastOrder;
    private javax.swing.JButton btnLastProduct;
    private javax.swing.JButton btnNextCustomer;
    private javax.swing.JButton btnNextOrder;
    private javax.swing.JButton btnNextProduct;
    private javax.swing.JButton btnPrevCustomer;
    private javax.swing.JButton btnPrevOrder;
    private javax.swing.JButton btnPrevProduct;
    private javax.swing.JButton btnSetImage;
    private javax.swing.JButton btnUpdateCustomer;
    private javax.swing.JButton btnUpdateProduct;
    private javax.swing.JComboBox cboCategories;
    private javax.swing.JComboBox cboCustomerDetails;
    private javax.swing.JComboBox cboOrderedProducts;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblStatus;
    private java.awt.List listOrderedProducts;
    private java.awt.List listOrderedProducts1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem mnuLoadCustomers;
    private javax.swing.JMenuItem mnuLoadProducts;
    private javax.swing.JMenuItem mnuSaveCustomers;
    private javax.swing.JMenuItem mnuSaveProducts;
    private javax.swing.JPanel panelCorporateDetails;
    private javax.swing.JPanel panelProductsOrdered;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JLabel statusAnimationLabel;
    private javax.swing.JLabel statusMessageLabel;
    private javax.swing.JPanel statusPanel;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JTextArea txtAddress1;
    private javax.swing.JTextArea txtAddress2;
    private javax.swing.JTextField txtBalance;
    private javax.swing.JTextField txtBalance1;
    private javax.swing.JTextField txtBalance2;
    private javax.swing.JTextField txtCategory;
    private javax.swing.JTextField txtContactName;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtID1;
    private javax.swing.JTextField txtID2;
    private javax.swing.JTextField txtImage;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtName1;
    private javax.swing.JTextField txtName2;
    private javax.swing.JTextField txtOrderDate;
    private javax.swing.JTextField txtOrderDate1;
    private javax.swing.JTextField txtOrderID;
    private javax.swing.JTextField txtOrderID1;
    private javax.swing.JTextField txtOrderTotal;
    private javax.swing.JTextField txtOrderTotal1;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextArea txtProductDesc;
    private javax.swing.JTextField txtProductID;
    private javax.swing.JTextField txtProductName;
    private javax.swing.JTextField txtStockQuantity;
    private javax.swing.JTextField txtWebSite;
    // End of variables declaration//GEN-END:variables

    private final Timer messageTimer;
    private final Timer busyIconTimer;
    private final Icon idleIcon;
    private final Icon[] busyIcons = new Icon[15];
    private int busyIconIndex = 0;

    private JDialog aboutBox;

    //app variables
    private int CurrentCustomerIndex;
    private int CurrentProductIndex;
    private int CurrentOrderIndex;
}
