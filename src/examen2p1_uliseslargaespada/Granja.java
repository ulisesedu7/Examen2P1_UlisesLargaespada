/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen2p1_uliseslargaespada;

import java.util.ArrayList;

/**
 *
 * @author ularg
 */
public class Granja {
  String nombreGranja;
  double dinero;
  ArrayList<Vaca> vacas = new ArrayList();
  ArrayList<Conejo> conejos = new ArrayList();
  ArrayList<Vegetal> vegetales = new ArrayList();
  int cantidadVegetales;
  boolean plantasCosechadas;
  boolean yaPlanto;

  public Granja(String nombreGranja) {
    this.nombreGranja = nombreGranja;
    this.dinero = 500;
    this.vacas = new ArrayList();
    this.conejos = new ArrayList();
    this.vegetales = new ArrayList();
    this.plantasCosechadas = false;
    this.yaPlanto = false;
    this.cantidadVegetales = 0;
  }

  public String getNombreGranja() {
    return nombreGranja;
  }

  public void setNombreGranja(String nombreGranja) {
    this.nombreGranja = nombreGranja;
  }

  public double getDinero() {
    return dinero;
  }

  public void setDinero(double dinero) {
    this.dinero = dinero;
  }

  public ArrayList<Vaca> getVacas() {
    return vacas;
  }

  public void setVacas(ArrayList<Vaca> vacas) {
    this.vacas = vacas;
  }

  public ArrayList<Conejo> getConejos() {
    return conejos;
  }

  public void setConejos(ArrayList<Conejo> conejos) {
    this.conejos = conejos;
  }

  public ArrayList<Vegetal> getVegetales() {
    return vegetales;
  }

  public void setVegetales(ArrayList<Vegetal> vegetales) {
    this.vegetales = vegetales;
  }

  public boolean isPlantasCosechadas() {
    return plantasCosechadas;
  }

  public void setPlantasCosechadas(boolean plantasCosechadas) {
    this.plantasCosechadas = plantasCosechadas;
  }

  public int getCantidadVegetales() {
    return cantidadVegetales;
  }

  public void setCantidadVegetales(int cantidadVegetales) {
    this.cantidadVegetales = cantidadVegetales;
  }

  public boolean isYaPlanto() {
    return yaPlanto;
  }

  public void setYaPlanto(boolean yaPlanto) {
    this.yaPlanto = yaPlanto;
  }
  
  /*
    Metodos manuales para la clase granja
  */
  // Metodos para agregar cosas
  public void addVaca(String nombreVaca){
    Vaca vacaNueva = new Vaca(nombreVaca);
    this.vacas.add(vacaNueva);
    this.dinero -= 350;
  }
  
  public void addConejo(String nombreConejo){
    Conejo conejoNuevo = new Conejo(nombreConejo);
    this.conejos.add(conejoNuevo);
    this.dinero -= 150;
  }
  
  public void addVegetal(){
    Vegetal vegetalNuevo = new Vegetal();
    this.vegetales.add(vegetalNuevo);
  }
  
  // Metodos para remover cosas luego de venderlas
  public void sellVaca() {
    Vaca vacaVendida = (Vaca) vacas.get(0);
    this.vacas.remove(0);
    this.dinero += vacaVendida.getPrecioVaca();
    
    System.out.println("Bye bye " + vacaVendida.getNombreVaca());
  }
  
  public void sellConejo() {
    Conejo conejoVendido = (Conejo) conejos.get(0);
    this.conejos.remove(0);
    this.dinero += conejoVendido.getPrecioConejo();
    
    System.out.println("Bye bye " + conejoVendido.getNombreConejo());
  }
  
  public void sellVegetal() {
    Vegetal vegetalVendido = (Vegetal) vegetales.get(0);
    this.vegetales.remove(0);
    this.dinero += vegetalVendido.getPrecioVegetal();
    
    System.out.println("Has vendido vegetales!");
  }
}
