package ui;

import data.Tarea;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TareaRenderer extends JPanel implements ListCellRenderer<Tarea> {

    private JLabel nameLabel = new JLabel();
    private JLabel fechaLabel = new JLabel();
    private JLabel descripcionLabel = new JLabel();
    private JLabel estadoLabel = new JLabel();
    JPanel panelMain = new JPanel(new BorderLayout(50, 50));
    JPanel panelRigth = new JPanel(new GridLayout(2, 1));
    JPanel panelLeft = new JPanel(new GridLayout(2, 1));

    public TareaRenderer() {
        //setBackground(Color.GREEN);
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setLayout(new BorderLayout(5, 5));


        panelLeft.add(descripcionLabel);
        panelLeft.add(nameLabel);

        panelRigth.add(fechaLabel);
        panelRigth.add(estadoLabel);

        panelMain.add(panelRigth, BorderLayout.EAST);
        panelMain.add(panelLeft, BorderLayout.WEST);

        add(panelMain);

    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Tarea> list,
                                                  Tarea tarea, int index, boolean isSelected, boolean cellHasFocus) {

        nameLabel.setText(tarea.getNombre());

        nameLabel.setBorder(new EmptyBorder(5, 5, 0, 0));

        descripcionLabel.setText(tarea.getDescripcion());
        descripcionLabel.setBorder(new EmptyBorder(5, 5, 0, 0));
        descripcionLabel.setFont(new Font("arial", 1, 16));

        fechaLabel.setText(tarea.getFecha());
        fechaLabel.setBorder(new EmptyBorder(5, 5, 0, 10));

        estadoLabel.setText(tarea.getEstado());
        estadoLabel.setBorder(new EmptyBorder(5, 5, 0, 10));

        switch (tarea.getEstado()) {
            case "Por Hacer" -> {
                Color color =  new Color(0xFFFF5959, true);

                panelMain.setBackground(color);
                panelLeft.setBackground(color);
                panelRigth.setBackground(color);
                break;
            }

            case "En Proceso" -> {
                Color color =  new Color(0xFFFFF02E, true);
                panelMain.setBackground(color);
                panelLeft.setBackground(color);
                panelRigth.setBackground(color);
                break;
            }

            case "Terminada" -> {
                panelMain.setBackground(Color.GREEN);
                panelLeft.setBackground(Color.GREEN);
                panelRigth.setBackground(Color.GREEN);
                break;
            }
        }

        return this;
    }

}