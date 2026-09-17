package com.ecogame.view;

import javax.swing.*;

public class JanelaJogo extends JFrame {

    private final PainelJogo painelJogo;

    public JanelaJogo() {
        setTitle("Coleta Certa - Educação Ambiental");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        painelJogo = new PainelJogo();
        add(painelJogo);

        pack();
        setLocationRelativeTo(null);
    }

    @Override
    public void setVisible(boolean visivel) {
        super.setVisible(visivel);
        if (visivel) {
            painelJogo.requestFocusInWindow();
        }
    }
}
