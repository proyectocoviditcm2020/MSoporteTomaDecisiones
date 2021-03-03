/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import domain.Clasificador;
import javax.swing.JOptionPane;

/**
 *
 * @author J. Alfredo Brambila Hdez.
 */
public class Main {
    public static void main(String[] args) {
	Clasificador c = new Clasificador();
	c.archivoEntrenamiento("DataBase/dataTodos.arff");
	//double[] nuevoPaciente = {1,1,4,8,1,7,8,2,99,99,68,1,2,2,2,1,2,2,2,1,2,2,2,1,2,99,2,97,99,97,99,0};
	double[] nuevoPaciente = {1,2,12,30,1,30,30,1,97,2,58,1,2,2,2,1,2,2,2,1,2,2,1,2,2,1,2,97,99,97,97,0,2};
	System.out.println("Tamaño array: " + nuevoPaciente.length);
	int clasificacion = c.clasificarPaciente(nuevoPaciente);
	System.out.println("Class Int: " + (clasificacion+1));
	System.out.println("clasificacion: " + c.clasificacionPorCaso(clasificacion));
	JOptionPane.showMessageDialog(null, "Clase: " + (clasificacion+1)+"\n"+c.clasificacionPorCaso(clasificacion), "Clasificación", JOptionPane.INFORMATION_MESSAGE);
    }
}
