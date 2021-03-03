/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

import javax.swing.JOptionPane;
import weka.classifiers.Classifier;
import weka.classifiers.trees.J48;
import weka.core.DenseInstance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

/**
 *
 * @author J. Alfredo Brambila Hdez.
 */
public class Clasificador {

    Classifier j48;
    DataSource source;
    Instances data;
	    
    public void archivoEntrenamiento(String archivoEntrenamiento) {
	try {
	    System.out.println("file " + archivoEntrenamiento);
	    source = new DataSource(archivoEntrenamiento);
	    data = source.getDataSet();
	    System.out.println("Atributos: " + data.numAttributes());
	    data.setClassIndex(data.numAttributes()-1);
	    
	    j48 = new J48();
	    j48.buildClassifier(data);
	    System.out.println("Arbol");
	    System.out.println(j48);
	} catch(Exception e) {
	    System.out.println("Exception " + e);
	}
    }
    
    public String clasificacionPorCaso(int valor) {
	//String[] clasificacion = {"CASO DE COVID-19 CONFIRMADO POR ASOCIACIÓN CLÍNICA EPIDEMIOLÓGICA", "CASO DE COVID-19 CONFIRMADO POR COMITÉ DE  DICTAMINACIÓN", "CASO DE SARS-COV-2  CONFIRMADO POR LABORATORIO", "INVÁLIDO POR LABORATORIO", "NO REALIZADO POR LABORATORIO", "CASO SOSPECHOSO", "NEGATIVO A SARS-COV-2 POR LABORATORIO"};
	String[] clasificacion = {"CONFIRMADO", "CONFIRMADO", "CONFIRMADO", "INVÁLIDO", "INDETERMINADO", "SOSPECHOSO", "NEGATIVO"};
	return clasificacion[valor];
    }
    
    public String clasificacionPorCluster(int valor) {
	//String[] clasificacion = {"Cluster 1", "Cluster 2", "Cluster 3"};
	String[] clasificacion = {"CRÍTICOS", "NO CRÍTICOS", "RECUPERADOS"};
	return clasificacion[valor];
    }
    
    public int clasificarPaciente(double[] lectura) {
	double resultado = -1;
	String[] clasificacion = {"CASO DE COVID-19 CONFIRMADO POR ASOCIACIÓN CLÍNICA EPIDEMIOLÓGICA", "CASO DE COVID-19 CONFIRMADO POR COMITÉ DE  DICTAMINACIÓN", "CASO DE SARS-COV-2  CONFIRMADO POR LABORATORIO", "INVÁLIDO POR LABORATORIO", "NO REALIZADO POR LABORATORIO", "CASO SOSPECHOSO", "NEGATIVO A SARS-COV-2 POR LABORATORIO"};
	try {
	    //DenseInstance inst = new DenseInstance(1.0, lectura);
	    DenseInstance inst = new DenseInstance(lectura.length);
	    inst.setDataset(data);
	    for(int i=0; i<lectura.length; i++)
		inst.setValue(i, lectura[i]);
	    //inst.setC
	    //inst.setClassMissing();
	    System.out.println(inst);
	    System.out.println("Clasifica");
	    resultado = j48.classifyInstance(inst);
	   // System.out.println("Clasificacion: " + (int) resultado + " " + clasificacion[(int) resultado]);
	} catch (Exception e) {
	    System.out.println("Error en clasificación: " + e);
	    JOptionPane.showMessageDialog(null, "Error en clasificación: " + e, "Error", JOptionPane.ERROR_MESSAGE);
	}
	return (int) resultado;
    }
    
    
    
    public String clasificaComoCaso(String[] valores) {
	double[] vecValores = new double[valores.length];
	vecValores[0] = Double.parseDouble(valores[valores.length-1]);
	for(int i=1; i<valores.length; i++) {
	    vecValores[i] = Double.parseDouble(valores[i-1]);
	}
	
	return clasificacionPorCaso(clasificarPaciente(vecValores));
    }
    
    public String clasificaComoCasoO(String[] valores) {
	double[] vecValores = new double[valores.length];
	//vecValores[0] = Double.parseDouble(valores[valores.length-1]);
	for(int i=0; i<valores.length; i++) {
	    vecValores[i] = Double.parseDouble(valores[i]);
	}
	
	return clasificacionPorCaso(clasificarPaciente(vecValores));
    }
    
    public String clasificaComoCluster(String[] valores) {
	double[] vecValores = new double[valores.length];
	//vecValores[0] = Double.parseDouble(valores[valores.length-1]);
	for(int i=0; i<valores.length; i++) {
	    vecValores[i] = Double.parseDouble(valores[i]);
	}
	//vecValores[valores.length-1] = Double.parseDouble(valores[i-1]);
	return clasificacionPorCluster(clasificarPaciente(vecValores));
    }
    
    /*public int clasificarFalla(double[] lectura) {
	double result=-1;
	//sinfalla,falla1,falla2,falla3,falla4,falla5,falla6,falla7,falla8,falla9
	String[] fallasStr = {"SIN FALLA","FALLA 1","FALLA 2","FALLA 3","FALLA 4","FALLA 5","FALLA 6","FALLA 7","FALLA 8","FALLA 9"};
	try {
	    DenseInstance inst = new DenseInstance(1.0,lectura);
	    inst.setDataset(data);
	    //inst.setC
	    inst.setClassMissing();
	    System.out.println(inst);
	    System.out.println("Clasifica");
	    result = j48.classifyInstance(inst);
	    System.out.println("Clasificacion: " + (int)result + " " + fallasStr[(int)result]);
	    
	} catch(Exception e) {
	    System.out.println("Exception " + e);
	}
	return (int)result;
    }*/
}
