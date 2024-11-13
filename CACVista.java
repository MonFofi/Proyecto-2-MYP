import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class CACVista implements CACObservador, ActionListener{
    //atributos del login
    public CACModeloInterface model;
    public ControladorInterface controller;
    private JFrame viewFrame; 
    private JButton botonIngresar;
    private JButton botonSalirSistema;
    private JLabel contraseniaLabel;
    private JTextField contraseniaTxt;
    private JPanel jPanel1;
    private JLabel logoInDoor;
    private JLabel logoUsuarios;
    private JPanel nombreCAC;
    private JLabel tituloCAC;
    private JLabel tituloIS;
    private JLabel usuarioLabel;
    private JTextField usuarioTxt;

    //atributos del MenuPrincipalAlmacen
    private JFrame viewFrame2;
    private JButton botonCerrarSesion;
    private JButton botonConsultarChips;
    private JButton botonRegistrarCaja;
    private JButton botonRevisarSolicitudes;
    private JPanel fondoPanel;
    private JPanel jPanel2;
    private JLabel logoCarrito;
    private JLabel subtituloopciones;
    private JLabel tituloBienvenidaAlmacen;

    //atributos del MenuPrincipalVendedor
    private JFrame viewFrame3;
    private JButton botonCancelarReservacion;
    private JButton botonReservarChip;
    private JButton botonSolicitarChips;
    private JButton botonVenderChip;
    private JPanel fondoPane;
    private JPanel jPanel3;
    private JLabel logoVendedor;
    private JLabel subtopciones;
    private JLabel tituloBienvenidaVendedor;

    //atributos submenu solicitarchips
    private JFrame viewFrame4;
    private JPanel jPanel4;
    private JLabel logoCheck;
    private JLabel subtituloenviada;
    private JLabel tituloSolicitud;

    //atributos submenu escanearChip
    private JFrame viewFrame5;
    private JPanel jPanel5;
    private JLabel logoCodigoBarras;
    private JTextField numerodeserie;
    private JLabel subtituloChip;
    private JLabel tituloEscaneaCodigo;

    //atributos submenu escanearCaja
    private JFrame viewFrame6;
    private JPanel jPanel6;
    private JLabel logoCodigoBar;
    private JTextField numerodeCaja;
    private JLabel subtituloCaja;
    private JLabel tituloEscaneaCod;

    private JFrame frame;    

    public CACVista(ControladorInterface controller, CACModeloInterface model){
        this.controller = controller;
        this.model = model;
        model.registrarObservador((CACObservador)this);
    }
    
    public void initLogin(){
        viewFrame = new JFrame("Login");
        nombreCAC = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        tituloCAC = new javax.swing.JLabel();
        botonSalirSistema = new javax.swing.JButton();
        logoUsuarios = new javax.swing.JLabel();
        logoInDoor = new javax.swing.JLabel();
        tituloIS = new javax.swing.JLabel();
        usuarioLabel = new javax.swing.JLabel();
        contraseniaTxt = new javax.swing.JTextField();
        contraseniaLabel = new javax.swing.JLabel();
        usuarioTxt = new javax.swing.JTextField();
        botonIngresar = new javax.swing.JButton();
        viewFrame.setVisible(true);

        viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewFrame.setSize(new Dimension(800, 500));

        nombreCAC.setBackground(new java.awt.Color(255, 255, 255));
        nombreCAC.setForeground(new java.awt.Color(255, 255, 255));
        nombreCAC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jPanel1.setBackground(new java.awt.Color(255, 255, 153));
        jPanel1.setForeground(new java.awt.Color(255, 255, 0));

        tituloCAC.setFont(new java.awt.Font("URW Bookman", 0, 24));
        tituloCAC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloCAC.setText("Centro de Atencion a Clientes");

        botonSalirSistema.setFont(new java.awt.Font("Cantarell", 0, 18));
        botonSalirSistema.setText("SALIR DEL SISTEMA");
        botonSalirSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirSistemaActionPerformed(evt);
            }
        });

        logoUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("imagenes/users_people_workers_customers_icon_124243.png")));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);

        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(logoUsuarios)
                .addComponent(tituloCAC, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(botonSalirSistema))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(logoUsuarios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tituloCAC, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(botonSalirSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        logoInDoor.setFont(new java.awt.Font("Cantarell Extra Bold", 0, 24)); 
        logoInDoor.setIcon(new javax.swing.ImageIcon(getClass().getResource("imagenes/in_door_communication_enter_log_in_login_icon_191647 (1).png"))); 
        logoInDoor.setText("LOGIN");

        tituloIS.setFont(new java.awt.Font("Cantarell Extra Bold", 0, 24)); 
        tituloIS.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloIS.setText("INICIAR SESION");

        usuarioLabel.setFont(new java.awt.Font("Cantarell", 0, 18)); 
        usuarioLabel.setText("USUARIO");

        contraseniaTxt.setForeground(new java.awt.Color(204, 204, 204));
        contraseniaTxt.setText("Ingrese su contraseña");
        contraseniaTxt.setCaretColor(new java.awt.Color(255, 255, 255));
        contraseniaTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                contraseniaTxtMousePressed(evt);
            }
        });
        contraseniaTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contraseniaTxtActionPerformed(evt);
            }
        });

        contraseniaLabel.setFont(new java.awt.Font("Cantarell", 0, 18));
        contraseniaLabel.setText("CONTRASEÑA");

        usuarioTxt.setForeground(new java.awt.Color(204, 204, 204));
        usuarioTxt.setText("Ingrese su nombre de usuario");
        usuarioTxt.setCaretColor(new java.awt.Color(255, 255, 255));
        usuarioTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                usuarioTxtMousePressed(evt);
            }
        });
        usuarioTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioTxtActionPerformed(evt);
            }
        });

        botonIngresar.setBackground(new java.awt.Color(255, 255, 153));
        botonIngresar.setFont(new java.awt.Font("Cantarell", 0, 18));
        botonIngresar.setText("INGRESAR");
        botonIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonIngresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout nombreCACLayout = new javax.swing.GroupLayout(nombreCAC);
        nombreCAC.setLayout(nombreCACLayout);
        nombreCACLayout.setHorizontalGroup(
            nombreCACLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nombreCACLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(nombreCACLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logoInDoor, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(nombreCACLayout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(tituloIS))
                    .addGroup(nombreCACLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(usuarioLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(nombreCACLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(usuarioTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(nombreCACLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(contraseniaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(nombreCACLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(contraseniaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(nombreCACLayout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(botonIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        nombreCACLayout.setVerticalGroup(
            nombreCACLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nombreCACLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(logoInDoor, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(tituloIS)
                .addGap(40, 40, 40)
                .addComponent(usuarioLabel)
                .addGap(8, 8, 8)
                .addComponent(usuarioTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(contraseniaLabel)
                .addGap(8, 8, 8)
                .addComponent(contraseniaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(botonIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        GroupLayout layout = new GroupLayout(viewFrame.getContentPane());
        viewFrame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(nombreCAC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(nombreCAC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        viewFrame.pack();
    }

    private void contraseniaTxtActionPerformed(java.awt.event.ActionEvent evt) {
        //aqui guardaria lo que introduzca el usuario
        String contrasenia = contraseniaTxt.getText();

        //aqui el modelo mandaria a llamar el metodo de login
        //model.
        
        
        JFrame frame = new JFrame("Guardar texto en variable");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400,200);

        //esto te despliega un recuadro que dice lo que se guardo, es para checar que se guarde bien, pero al final lo podemos quitar
        JOptionPane.showMessageDialog(frame, "Texto Guardado" + contrasenia);
        contraseniaTxt.setText("");
    }

    private void usuarioTxtActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("Evento detectado: " + evt.getActionCommand());
        // TODO add your handling code here:
    }

    private void botonIngresarActionPerformed(java.awt.event.ActionEvent evt) {
        //metodo para abrir el menu dependiendo el usuario
        String usuario = usuarioTxt.getText();
        String contrasenia = contraseniaTxt.getText();
        String rol = model.iniciarSesion(usuario, contrasenia);

        if(!rol.equals("")){
          viewFrame.setVisible(false);
          if(rol.equalsIgnoreCase("almacenista")){
            initMenuPrincipalAlmacen();
          }else if(rol.equalsIgnoreCase("vendedor")){
            initMenuPrincipalVendedor();
          }
        }
    }

    private void botonSalirSistemaActionPerformed(java.awt.event.ActionEvent evt) {
        //metodo cuando el usuario preiona el boton salir sistema para que se cierre el programa
        System.exit(0);
    }

    private void usuarioTxtMousePressed(java.awt.event.MouseEvent evt) {
        if(usuarioTxt.getText().equals("Ingrese su nombre de usuario")){
            usuarioTxt.setText("");
        }
        if(contraseniaTxt.getText().isEmpty()){
            contraseniaTxt.setText("Ingrese su contraseña");
        }
    }
    
    private void contraseniaTxtMousePressed(java.awt.event.MouseEvent evt) {
        if(contraseniaTxt.getText().equals("Ingrese su contraseña")){
        contraseniaTxt.setText("");
        }
        if(usuarioTxt.getText().isEmpty()){
        usuarioTxt.setText("Ingrese su nombre de usuario");
        }
    }

    public void initMenuPrincipalAlmacen(){        
        viewFrame2 = new JFrame("Menu Almacen");
        fondoPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        tituloBienvenidaAlmacen = new javax.swing.JLabel();
        subtituloopciones = new javax.swing.JLabel();
        logoCarrito = new javax.swing.JLabel();
        botonRevisarSolicitudes = new javax.swing.JButton();
        botonConsultarChips = new javax.swing.JButton();
        botonCerrarSesion = new javax.swing.JButton();
        botonRegistrarCaja = new javax.swing.JButton();
        viewFrame2.setVisible(true);

        viewFrame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewFrame2.setSize(new Dimension(800, 500));

        fondoPanel.setBackground(new java.awt.Color(255, 255, 255));
        fondoPanel.setForeground(new java.awt.Color(255, 255, 255));
        fondoPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        fondoPanel.setSize(new Dimension(800, 500));

        jPanel2.setBackground(new java.awt.Color(255, 255, 153));

        tituloBienvenidaAlmacen.setFont(new java.awt.Font("Cantarell Extra Bold", 0, 36)); 
        tituloBienvenidaAlmacen.setText("BIENVENIDO AL ALMACEN");

        subtituloopciones.setFont(new java.awt.Font("Cantarell", 0, 24)); 
        subtituloopciones.setText("Que accion deseas realizar?");

        logoCarrito.setIcon(new javax.swing.ImageIcon(getClass().getResource("imagenes/ForkliftTruck_Loaded_Black_icon-icons.com_54893.png"))); 
        logoCarrito.setText("jLabel1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(tituloBienvenidaAlmacen))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(subtituloopciones)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addComponent(logoCarrito, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(113, 113, 113))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(logoCarrito, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(tituloBienvenidaAlmacen)
                        .addGap(26, 26, 26)
                        .addComponent(subtituloopciones)))
                .addGap(14, 14, 14))
        );

        botonRevisarSolicitudes.setIcon(new javax.swing.ImageIcon(getClass().getResource("imagenes/quote_request_icon_217006.png")));
        botonRevisarSolicitudes.setText("Revisar solicitudes");
        botonRevisarSolicitudes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRevisarSolicitudesActionPerformed(evt);
            }
        });

        botonConsultarChips.setIcon(new javax.swing.ImageIcon(getClass().getResource("imagenes/chipsimsdcard-115842_115787.png")));
        botonConsultarChips.setText("Consultar Chips");
        botonConsultarChips.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConsultarChipsActionPerformed(evt);
            }
        });

        botonCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("imagenes/4115234-login-sign-in_114046.png")));
        botonCerrarSesion.setText("Cerrar sesion");
        botonCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCerrarSesionActionPerformed(evt);
            }
        });

        botonRegistrarCaja.setIcon(new javax.swing.ImageIcon(getClass().getResource("imagenes/delivery_box_boxes_shipping_warehouse_icon_225177.png")));
        botonRegistrarCaja.setText("Registrar caja");
        botonRegistrarCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarCajaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout fondoPanelLayout = new javax.swing.GroupLayout(fondoPanel);
        fondoPanel.setLayout(fondoPanelLayout);
        fondoPanelLayout.setHorizontalGroup(
            fondoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(fondoPanelLayout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addGroup(fondoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fondoPanelLayout.createSequentialGroup()
                        .addComponent(botonRegistrarCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(botonRevisarSolicitudes, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(fondoPanelLayout.createSequentialGroup()
                        .addComponent(botonConsultarChips, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(botonCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        fondoPanelLayout.setVerticalGroup(
            fondoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoPanelLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(fondoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonRegistrarCaja)
                    .addComponent(botonRevisarSolicitudes))
                .addGap(40, 40, 40)
                .addGroup(fondoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonConsultarChips)
                    .addComponent(botonCerrarSesion))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(viewFrame2.getContentPane());
        viewFrame2.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 445, Short.MAX_VALUE)
        );

        viewFrame2.pack();
    }

    private void botonRevisarSolicitudesActionPerformed(java.awt.event.ActionEvent evt) {
        // accion cuando se presiona el boton de Revisar Solicitudes
        model.revisarSolicitudes();
    }

    private void botonConsultarChipsActionPerformed(java.awt.event.ActionEvent evt) {
        // accion cuando se presiona el boton de Consultar Chips
        model.consultarChips();
    }

    private void botonCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {
        // Codigo para regresar al login
        if(viewFrame2 == null){
            viewFrame3.setVisible(false);
        }else{
            viewFrame2.setVisible(false);
        }
        initLogin();
    }

    private void botonRegistrarCajaActionPerformed(java.awt.event.ActionEvent evt) {
        //boton para abrir el sunmenu de EscanearCaja 
        initSubmenuEscanearCaja();

    }
    public void initSubmenuSolicitarChips(){
        viewFrame4 = new JFrame("Solicitud");
        jPanel4 = new JPanel();
        tituloSolicitud = new JLabel();
        subtituloenviada = new JLabel();
        logoCheck = new JLabel();
        viewFrame4.setVisible(true);

        viewFrame4.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        viewFrame4.setSize(new Dimension(800, 300));

        jPanel4.setBackground(new java.awt.Color(255, 255, 153));

        tituloSolicitud.setFont(new java.awt.Font("Cantarell Extra Bold", 0, 36)); // NOI18N
        tituloSolicitud.setText("SOLICITUD ENVIADA");

        subtituloenviada.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        subtituloenviada.setText("La solicitud se ha enviado con exito.");

        logoCheck.setIcon(new ImageIcon(getClass().getResource("imagenes/iconfinder-check-4341282_120572.png"))); // NOI18N
        logoCheck.setText("jLabel1");

        GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(tituloSolicitud)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(subtituloenviada)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addComponent(logoCheck, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
                .addGap(128, 128, 128))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(tituloSolicitud)
                        .addGap(18, 18, 18)
                        .addComponent(subtituloenviada)
                        .addGap(34, 34, 34))
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(logoCheck, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))))
        );

        GroupLayout layout = new GroupLayout(viewFrame4.getContentPane());
        viewFrame4.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        viewFrame4.pack();
    }

    public void initSubmenuEscanearChip(){
        viewFrame5 = new JFrame("Escanear Codigo Barras");
        jPanel5 = new javax.swing.JPanel();
        tituloEscaneaCodigo = new javax.swing.JLabel();
        subtituloChip = new javax.swing.JLabel();
        logoCodigoBarras = new javax.swing.JLabel();
        numerodeserie = new javax.swing.JTextField();
        viewFrame5.setVisible(true);

        viewFrame5.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        viewFrame5.setSize(new Dimension(800, 400));

        jPanel5.setBackground(new java.awt.Color(255, 255, 153));

        tituloEscaneaCodigo.setFont(new java.awt.Font("Cantarell Extra Bold", 0, 36)); // NOI18N
        tituloEscaneaCodigo.setText("Escanea el codigo de barras");

        subtituloChip.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        subtituloChip.setText("del chip");

        logoCodigoBarras.setIcon(new ImageIcon(getClass().getResource("imagenes/price-scan-scanner-bar-barcode-code_108573.png"))); // NOI18N

        numerodeserie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numerodeserieActionPerformed(evt);
            }
        });

        GroupLayout jPanel5Layout = new GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(tituloEscaneaCodigo)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(subtituloChip)
                                .addGap(222, 222, 222))
                            .addGroup(GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(numerodeserie, GroupLayout.PREFERRED_SIZE, 362, GroupLayout.PREFERRED_SIZE)
                                .addGap(81, 81, 81)))))
                .addComponent(logoCodigoBarras, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(logoCodigoBarras, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(tituloEscaneaCodigo)
                        .addGap(18, 18, 18)
                        .addComponent(subtituloChip)
                        .addGap(18, 18, 18)
                        .addComponent(numerodeserie, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)))
                .addGap(55, 55, 55))
        );

        GroupLayout layout = new GroupLayout(viewFrame5.getContentPane());
        viewFrame5.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );

        viewFrame5.pack();
    }

    private void numerodeserieActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // aqui iria la logica para el escaner de barras.
        String numeroChipIngresado = numerodeserie.getText();

        Chip chip = model.escanerChip(numeroChipIngresado);

        frame = new JFrame("Guardar texto en variable");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400,200);

        JOptionPane.showMessageDialog(frame, "Texto Guardado" + numeroChipIngresado);
        numerodeserie.setText("");

        // Dependiendo del estado actual del chip, se realiza la acción correspondiente
        if (chip.getEstadoActual() instanceof EstadoDisponible) {
            // El chip está disponible, lo pasamos a reservado
            model.reservarChip(numeroChipIngresado);
        } else if (chip.getEstadoActual() instanceof EstadoReservado) {
            // El chip está reservado, lo pasamos a disponible
            model.cancelarReservacionChip(numeroChipIngresado);
        } else if (chip.getEstadoActual() instanceof EstadoDisponible) {
            // El chip ya está vendido
            model.venderChip(numeroChipIngresado);
            System.out.println("El chip ya ha sido vendido. No se puede realizar ninguna otra acción.");
        } else {
            // Si el estado del chip no es reconocido
            System.out.println("Estado del chip desconocido. No se puede procesar.");
        }

        // Limpiar el campo de texto
        numerodeserie.setText("");
        
    } 


    public void initSubmenuEscanearCaja(){
        viewFrame6 = new JFrame("Escanear Codigo Barras de caja");
        jPanel6 = new javax.swing.JPanel();
        tituloEscaneaCod = new javax.swing.JLabel();
        subtituloCaja = new javax.swing.JLabel();
        logoCodigoBar = new javax.swing.JLabel();
        numerodeCaja = new javax.swing.JTextField();
        viewFrame6.setVisible(true);

        viewFrame6.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        viewFrame6.setSize(new Dimension(800, 400));

        jPanel6.setBackground(new java.awt.Color(255, 255, 153));

        tituloEscaneaCod.setFont(new java.awt.Font("Cantarell Extra Bold", 0, 36)); // NOI18N
        tituloEscaneaCod.setText("Escanea el codigo de barras");

        subtituloCaja.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        subtituloCaja.setText("de la caja a registrar");

        logoCodigoBar.setIcon(new javax.swing.ImageIcon(getClass().getResource("imagenes/price-scan-scanner-bar-barcode-code_108573.png"))); // NOI18N

        numerodeCaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numerodeCajaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(tituloEscaneaCod)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addComponent(numerodeCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(81, 81, 81))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addComponent(subtituloCaja)
                                .addGap(159, 159, 159)))))
                .addComponent(logoCodigoBar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(logoCodigoBar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(tituloEscaneaCod)
                        .addGap(18, 18, 18)
                        .addComponent(subtituloCaja)
                        .addGap(18, 18, 18)
                        .addComponent(numerodeCaja, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(55, 55, 55))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(viewFrame6.getContentPane());
        viewFrame6.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        viewFrame6.pack();
        
    }
    
    private void numerodeCajaActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // metodo cuando se escanea el codigo de barras de la caja
        String numeroCajaIngresado = numerodeCaja.getText();

        model.registrarCaja(numeroCajaIngresado);

        JFrame frame = new JFrame("Guardar texto en variable");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400,200);

        JOptionPane.showMessageDialog(frame, "Texto Guardado" + numeroCajaIngresado);
        numerodeCaja.setText("");
    } 
    
    public void initMenuPrincipalVendedor(){
        viewFrame3 = new JFrame("Manu Vendedor");
        fondoPane = new JPanel();
        jPanel3 = new JPanel();
        tituloBienvenidaVendedor = new JLabel();
        subtopciones = new JLabel();
        logoVendedor = new JLabel();
        botonVenderChip = new JButton();
        botonReservarChip = new JButton();
        botonCerrarSesion = new JButton();
        botonSolicitarChips = new JButton();
        botonCancelarReservacion = new JButton();
        viewFrame3.setVisible(true);

        viewFrame3.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        viewFrame3.setSize(new Dimension(800, 500));
        //viewFrame3.setMinimumSize(new Dimension(800, 600));

        fondoPane.setBackground(new Color(255, 255, 255));
        fondoPane.setForeground(new Color(255, 255, 255));
        fondoPane.setCursor(new Cursor(Cursor.HAND_CURSOR));


        jPanel3.setBackground(new Color(255, 255, 153));

        tituloBienvenidaVendedor.setFont(new Font("Cantarell Extra Bold", 0, 36));
        tituloBienvenidaVendedor.setText("BIENVENIDO VENDEDOR");

        subtopciones.setFont(new Font("Cantarell", 0, 24));
        subtopciones.setText("Que accion deseas realizar?");

        logoVendedor.setIcon(new ImageIcon(getClass().getResource("imagenes/salesman_avatar_icon_133993 (1).png")));

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(tituloBienvenidaVendedor)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(subtopciones)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addComponent(logoVendedor, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
                .addGap(128, 128, 128))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(tituloBienvenidaVendedor)
                        .addGap(18, 18, 18)
                        .addComponent(subtopciones)
                        .addGap(34, 34, 34))
                    .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(logoVendedor, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))))
        );

        botonVenderChip.setIcon(new ImageIcon(getClass().getResource("imagenes/pay_cash_payment_money_dollar_bill_icon_143267.png"))); // NOI18N
        botonVenderChip.setText("Vender chip");
        botonVenderChip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVenderChipActionPerformed(evt);
            }
        });

        botonReservarChip.setIcon(new ImageIcon(getClass().getResource("imagenes/4_104853.png"))); // NOI18N
        botonReservarChip.setText("Reservar chip");
        botonReservarChip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonReservarChipActionPerformed(evt);
            }
        });

        botonCerrarSesion.setIcon(new ImageIcon(getClass().getResource("imagenes/4115234-login-sign-in_114046.png"))); // NOI18N
        botonCerrarSesion.setText("Cerrar sesion");
        botonCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCerrarSesionActionPerformed(evt);
            }
        });

        botonSolicitarChips.setIcon(new ImageIcon(getClass().getResource("imagenes/chipsimsdcard-115842_115787.png"))); // NOI18N
        botonSolicitarChips.setText("Solicitar mas chips");
        botonSolicitarChips.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSolicitarChipsActionPerformed(evt);
            }
        });

        botonCancelarReservacion.setIcon(new ImageIcon(getClass().getResource("imagenes/signal-cellular-no-sim_117233.png"))); // NOI18N
        botonCancelarReservacion.setText("Cancelar reservacion");
        botonCancelarReservacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarReservacionActionPerformed(evt);
            }
        });

        GroupLayout fondoPaneLayout = new GroupLayout(fondoPane);
        fondoPane.setLayout(fondoPaneLayout);
        fondoPaneLayout.setHorizontalGroup(
            fondoPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addGroup(fondoPaneLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(botonSolicitarChips, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(botonVenderChip, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(botonReservarChip, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE))
            .addGroup(fondoPaneLayout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(botonCancelarReservacion, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(botonCerrarSesion, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE))
        );
        fondoPaneLayout.setVerticalGroup(
            fondoPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(fondoPaneLayout.createSequentialGroup()
                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(fondoPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(botonSolicitarChips)
                    .addComponent(botonVenderChip)
                    .addComponent(botonReservarChip))
                .addGap(30, 30, 30)
                .addGroup(fondoPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(botonCancelarReservacion)
                    .addComponent(botonCerrarSesion)))
        );

        GroupLayout layout = new GroupLayout(viewFrame3.getContentPane());
        viewFrame3.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(fondoPane, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(fondoPane, GroupLayout.PREFERRED_SIZE, 444, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        viewFrame3.pack();
    }                   

    private void botonVenderChipActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // metodo para cuando se presiona el boton Vender Chip, que abre el submenu para escanear el codigo de barras del chip
        initSubmenuEscanearChip();
    }                                               

    private void botonReservarChipActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // metodo para cuando se presiona el boton Reservar Chip, que abre el submenu para escanear el codigo de barras del chip
        initSubmenuEscanearChip();
    }                                                                                                  

    private void botonSolicitarChipsActionPerformed(java.awt.event.ActionEvent evt) {                                                    
       // metodo para solicitar chips al almacen
        model.solicitarMasChips();
    }                                                   

    private void botonCancelarReservacionActionPerformed(java.awt.event.ActionEvent evt) {                                                         
        // metodo para cuando se presiona el boton Cancelar Reservacion de chip, que abre el submenu para escanear el codigo de barras del chip
        initSubmenuEscanearChip();
    }
    
    public void actionPerformed(ActionEvent event){
        System.out.println("Evento no identificado: " + event.getActionCommand());
    }

    @Override
    public void actualizar(){
        
    }

}