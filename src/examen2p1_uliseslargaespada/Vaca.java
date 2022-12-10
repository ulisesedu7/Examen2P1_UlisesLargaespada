/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen2p1_uliseslargaespada;

/**
 *
 * @author ularg
 */
public class Vaca {
  String nombreVaca;
  double precioVaca;

  public Vaca(String nombreVaca) {
    this.nombreVaca = nombreVaca;
    this.precioVaca = 400;
  }

  public String getNombreVaca() {
    return nombreVaca;
  }

  public void setNombreVaca(String nombreVaca) {
    this.nombreVaca = nombreVaca;
  }

  public double getPrecioVaca() {
    return precioVaca;
  }

  public void setPrecioVaca(double precioVaca) {
    this.precioVaca = precioVaca;
  }
  
}
