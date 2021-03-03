/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domain;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JComboBox;
import support.ConexionDB;

/**
 *
 * @author J. Alfredo Brambila Hdez.
 */
public class CSVDataGet {

    
    private String ruta="";
    
    //DataBase\Catalogos
    public CSVDataGet() {
	//System.out.println(""+System.getProperty("user.dir"));
	this.ruta = "" + System.getProperty("user.dir") + "\\DataBase\\Catalogos\\";
	//this.ruta = "C:\\Users\\al_x3\\Documents\\Maestria\\OPTEX\\TMA\\BDBogota\\";
	
    }
    
    public String getRuta() {
	return ruta;
    }
    
    //Obtener Sector
    public void getSector(JComboBox sector) {
	sector.removeAllItems();
	try {
	    ConexionDB conDB = new ConexionDB();
	    Connection conn = conDB.getConexion(ruta);
	    Statement stmt = conn.createStatement();
	    //clave,descripcion
	    ResultSet resultSet = stmt.executeQuery("SELECT clave,descripcion FROM sector ORDER BY clave ASC");
	    
	    while(resultSet.next()) {
		sector.addItem(new ComboItem(resultSet.getString("descripcion"),resultSet.getString("clave")));
	    }
	    conn.close();
	} catch(Exception e) {
	    System.out.println("Sector Error:  " + e);
	}
    }
    
    //Obtener campo Sexo
    public void getSexo(JComboBox sector) {
	sector.removeAllItems();
	try {
	    ConexionDB conDB = new ConexionDB();
	    Connection conn = conDB.getConexion(ruta);
	    Statement stmt = conn.createStatement();
	    //clave,descripcion
	    ResultSet resultSet = stmt.executeQuery("SELECT clave,descripcion FROM sexo ORDER BY clave ASC");
	    
	    while(resultSet.next()) {
		sector.addItem(new ComboItem(resultSet.getString("descripcion"),resultSet.getString("clave")));
	    }
	    conn.close();
	} catch(Exception e) {
	    System.out.println("Campo Sexo Error:  " + e);
	}
    }
    
    //Obtener campo Si_No
    public void getSi_No(JComboBox sector) {
	sector.removeAllItems();
	try {
	    ConexionDB conDB = new ConexionDB();
	    Connection conn = conDB.getConexion(ruta);
	    Statement stmt = conn.createStatement();
	    //clave,descripcion
	    ResultSet resultSet = stmt.executeQuery("SELECT clave,descripcion FROM si_no ORDER BY clave ASC");
	    
	    while(resultSet.next()) {
		sector.addItem(new ComboItem(resultSet.getString("descripcion"),resultSet.getString("clave")));
	    }
	    conn.close();
	} catch(Exception e) {
	    System.out.println("Campo Si_No Error:  " + e);
	}
    }
    
    //Obtener clave,clasificacion,descripcion
    public void getClasificacionFinal(JComboBox sector) {
	sector.removeAllItems();
	try {
	    ConexionDB conDB = new ConexionDB();
	    Connection conn = conDB.getConexion(ruta);
	    Statement stmt = conn.createStatement();
	    //clave,descripcion
	    ResultSet resultSet = stmt.executeQuery("SELECT clave,clasificacion,descripcion FROM clasificacion_final ORDER BY clave ASC");
	    
	    while(resultSet.next()) {
		sector.addItem(new ComboItem(resultSet.getString("clasificacion"),resultSet.getString("clave")));
	    }
	    conn.close();
	} catch(Exception e) {
	    System.out.println("Clasif Final Error:  " + e);
	}
    }
    
    // entidad cve_entidad,nombre,abreviatura
    public void getEntidad(JComboBox sector) {
	sector.removeAllItems();
	try {
	    ConexionDB conDB = new ConexionDB();
	    Connection conn = conDB.getConexion(ruta);
	    Statement stmt = conn.createStatement();
	    //clave,descripcion
	    ResultSet resultSet = stmt.executeQuery("SELECT cve_entidad,nombre FROM entidad ORDER BY cve_entidad ASC");
	    
	    while(resultSet.next()) {
		sector.addItem(new ComboItem(resultSet.getString("nombre"),resultSet.getString("cve_entidad")));
	    }
	    conn.close();
	} catch(Exception e) {
	    System.out.println("Entidad Error:  " + e);
	}
    }
    
    //municipio cve_municipio,nombre,clave
    public void getMunicipio(JComboBox sector) {
	sector.removeAllItems();
	try {
	    ConexionDB conDB = new ConexionDB();
	    Connection conn = conDB.getConexion(ruta);
	    Statement stmt = conn.createStatement();
	    //clave,descripcion
	    ResultSet resultSet = stmt.executeQuery("SELECT cve_municipio,nombre FROM municipio ORDER BY cve_municipio ASC");
	    
	    while(resultSet.next()) {
		sector.addItem(new ComboItem(resultSet.getString("nombre"),resultSet.getString("cve_municipio")));
	    }
	    conn.close();
	} catch(Exception e) {
	    System.out.println("Municipio Error:  " + e);
	}
    }
    
    //nacionalidad clave,descripcion
    public void getNacionalidad(JComboBox sector) {
	sector.removeAllItems();
	try {
	    ConexionDB conDB = new ConexionDB();
	    Connection conn = conDB.getConexion(ruta);
	    Statement stmt = conn.createStatement();
	    //clave,descripcion
	    ResultSet resultSet = stmt.executeQuery("SELECT clave,descripcion FROM nacionalidad ORDER BY clave ASC");
	    
	    while(resultSet.next()) {
		sector.addItem(new ComboItem(resultSet.getString("descripcion"),resultSet.getString("clave")));
	    }
	    conn.close();
	} catch(Exception e) {
	    System.out.println("Nacionalidad Error:  " + e);
	}
    }
    
    //origen clave,descripcion
    public void getOrigen(JComboBox sector) {
	sector.removeAllItems();
	try {
	    ConexionDB conDB = new ConexionDB();
	    Connection conn = conDB.getConexion(ruta);
	    Statement stmt = conn.createStatement();
	    //clave,descripcion
	    ResultSet resultSet = stmt.executeQuery("SELECT clave,descripcion FROM origen ORDER BY clave ASC");
	    
	    while(resultSet.next()) {
		sector.addItem(new ComboItem(resultSet.getString("descripcion"),resultSet.getString("clave")));
	    }
	    conn.close();
	} catch(Exception e) {
	    System.out.println("Origen Error:  " + e);
	}
    }
    
    //paciente clave,descripcion
    public void getPaciente(JComboBox sector) {
	sector.removeAllItems();
	try {
	    ConexionDB conDB = new ConexionDB();
	    Connection conn = conDB.getConexion(ruta);
	    Statement stmt = conn.createStatement();
	    //clave,descripcion
	    ResultSet resultSet = stmt.executeQuery("SELECT clave,descripcion FROM paciente ORDER BY clave ASC");
	    
	    while(resultSet.next()) {
		sector.addItem(new ComboItem(resultSet.getString("descripcion"),resultSet.getString("clave")));
	    }
	    conn.close();
	} catch(Exception e) {
	    System.out.println("Paciente Error:  " + e);
	}
    }
    
    //resultado_lab clave,descripcion
    public void getResultadoLab(JComboBox sector) {
	sector.removeAllItems();
	try {
	    ConexionDB conDB = new ConexionDB();
	    Connection conn = conDB.getConexion(ruta);
	    Statement stmt = conn.createStatement();
	    //clave,descripcion
	    ResultSet resultSet = stmt.executeQuery("SELECT clave,descripcion FROM resultado_lab ORDER BY clave ASC");
	    
	    while(resultSet.next()) {
		sector.addItem(new ComboItem(resultSet.getString("descripcion"),resultSet.getString("clave")));
	    }
	    conn.close();
	} catch(Exception e) {
	    System.out.println("resultado_lab Error:  " + e);
	}
    }
    
    //resultado_lab clave,descripcion
    public void getCluster(JComboBox sector) {
	sector.removeAllItems();
	try {
	    ConexionDB conDB = new ConexionDB();
	    Connection conn = conDB.getConexion(ruta);
	    Statement stmt = conn.createStatement();
	    //clave,descripcion
	    ResultSet resultSet = stmt.executeQuery("SELECT clave,descripcion FROM cluster ORDER BY clave ASC");
	    
	    while(resultSet.next()) {
		sector.addItem(new ComboItem(resultSet.getString("descripcion"),resultSet.getString("clave")));
	    }
	    conn.close();
	} catch(Exception e) {
	    System.out.println("resultado_lab Error:  " + e);
	}
    }
    
    public void getEdad(JComboBox sector) {
	sector.removeAllItems();
	try {
	    for(int i=0; i<=130; i++)
	    sector.addItem(new ComboItem(i+"",i+""));
	    
	} catch(Exception e) {
	    System.out.println("resultado_lab Error:  " + e);
	}
    }
    
}
