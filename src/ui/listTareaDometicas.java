
package ui;


import data.Tarea;
import network.TareaRetrofit;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class listTareaDometicas extends JFrame {

    private JButton agregar;
    private JButton buscar;
    private JScrollPane scrollPane = new JScrollPane();
    private JList<Tarea> lista;
    private JTextField buscarTextField;

    public listTareaDometicas() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Lista De Tarea Domesticas");
        this.setLayout(null);
        this.setBounds(600, 200, 540, 600);
        this.setContentPane(PanelPrincipal());
        this.setVisible(true);
    }


    private JPanel PanelPrincipal() {
        JPanel panel = new JPanel();
        ConfigurarButton();
        llenarLista();
        panel.setLayout(null);
        panel.add(buscarTextField);
        panel.add(scrollPane);
        panel.add(agregar);
        panel.add(buscar);
        return panel;
    }

    private void llenarLista() {

        DefaultListModel model = new DefaultListModel<Tarea>();

        TareaRetrofit api = new TareaRetrofit();

        api.listaCitas().forEach(tarea -> {
                    tarea.setTareaId(tarea.getTareaId());
                    tarea.setNombre(tarea.getNombre());
                    tarea.setEstado(tarea.getEstado());
                    tarea.setDescripcion(tarea.getDescripcion());
                    tarea.setFecha(tarea.getFecha());
                    tarea.setEmpleadoId(tarea.getEmpleadoId());
                    model.addElement(tarea);
                }

        );

        lista = new JList(model);
        scrollPane.setBounds(10, 50, 500, 500);
        scrollPane.setBorder(new LineBorder(Color.CYAN, 5, true));
        lista.setCellRenderer(new TareaRenderer());

        scrollPane.setViewportView(lista);


    }

    private void ConfigurarButton() {
        ImageIcon icono = new ImageIcon("src/resources/buscarIcono.png");

        buscarTextField = textField();
        buscarTextField.setBounds(10, 10, 250, 30);
        buscar = new JButton("");
        buscar.setIcon(new ImageIcon(icono.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
        buscar.setBounds(270, 10, 75, 30);
        buscar.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                //OpcionEliminar();
            }
        });

        agregar = new JButton("");
        icono = new ImageIcon("src/resources/AgregarIcono.png");
        agregar.setIcon(new ImageIcon(icono.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH)));
        agregar.setBounds(360, 10, 75, 30);
        agregar.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                OpcionAgregar();
            }
        });


    }

    private void OpcionAgregar() {
        new registroTareaDometicas();
    }

    private JTextField textField() {
        JTextField jTextField = new JTextField();
        jTextField.setForeground(Color.BLACK);
        jTextField.setFont(new Font("arial", 1, 16));
        return jTextField;
    }
}