package com.company;

import Database.ConnectionFactory;
import Controllers.*;
import Models.*;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        Locadora carros = new Locadora();
        LocadoraController locar = new LocadoraController();

        carros.setMarca(JOptionPane.showInputDialog("Digite a marca do carro? "));
        carros.setModelo(JOptionPane.showInputDialog("Digite a modelo do carro? "));
        carros.setAno(Integer.parseInt(JOptionPane.showInputDialog("Digite o ano do carro? ")));
        carros.setCor(JOptionPane.showInputDialog("Digite a cor do carro? "));
        carros.setMotorizacao(Double.parseDouble(JOptionPane.showInputDialog("Digite a motorização do carro? ")));
        carros.setQuilometragem(Double.parseDouble(JOptionPane.showInputDialog("Digite a quilometragem do carro? ")));
        carros.setValorVeiculo(Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do carro? ")));
        carros.setQtdPortas(Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de portas do carro? ")));
        carros.setDonoAtual(JOptionPane.showInputDialog("Digite o dono atual do carro? "));
        carros.setPlaca(JOptionPane.showInputDialog("Digite a placa do carro? "));

        locar.store(carros);
    }
}
