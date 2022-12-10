/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package examen2p1_uliseslargaespada;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author ularg
 */
public class Examen2P1_UlisesLargaespada {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    // TODO code application logic here
    mainMenu();
  }

  public static void mainMenu() {
    // Initialize scanner
    Scanner entry = new Scanner(System.in);

    System.out.println("-- Bienvenido al programa para resolver el examen 2 --");
    System.out.println("---Vamos a jugar un mini Stardew Valley---");

    do {
      System.out.println("Elija que opcion deseas: ");
      System.out.println("1 - Comenzar Juego!");
      System.out.println("2 - Instrucciones");
      System.out.println("3 - Salir \n");

      System.out.print("Ingrese la opcion: ");
      int option = entry.nextInt();

      switch (option) {
        case 1 ->
          mainGame();

        case 2 ->
          instrucciones();

        case 3 ->
          System.out.println("Gracias por usar jugar, feliz dia!");

        default ->
          System.out.println("Elija una opcion de las anteriores");
      }

      // Salir del programa 
      if (option == 3) {
        break;
      }
    } while (true);
  }

  // Funcion para mostrar las instrucciones al usuario
  public static void instrucciones() {
    System.out.println("En Stardew Valley podras simular tu vida tranquila en una granja, libre de la programacion, trabajo y universidad \n");

    System.out.println("--------------------------");
    System.out.println("REGLAS GENERALES");
    System.out.println("Primero tendras que crear tu jugador y granja con sus nombres respectivos");
    System.out.println("Iniciaras el juego con 500 de gald");
    System.out.println("Tendras la oportunidad de realizar 5 acciones, pero solo puedes hacer una cada dia, asi que debes escoger bien");
    System.out.println("Las accioens son: ");
    System.out.println("1 - Plantar Cosechas --> Al seleccionar esta opcion podras plantar las cosechas que decidas, las cuales tomaran 5 dias en poder ser cosechadas");
    System.out.println("2 - Cosechar las Cosechas --> Luego de que una planta este cosechada podras reclamarla y guardarla");
    System.out.println("3 - Conseguir Animales --> En esta opcion podras comprar ya sean vacas o conejos");
    System.out.println("4 - Vender Cosas --> Si cuentas con animales o cosechas podras venderlas ");
    System.out.println("5 - Dormir --> Puedes descansar un dia y asi dejarlo pasar");
    System.out.println("-------------------------- \n");

    System.out.println("--------------------------");
    System.out.println("PRECIOS");
    System.out.println("1. Compra de animales");
    System.out.println("--a) Vacas: 350 gald");
    System.out.println("--b) Conejos: 150 gald");
    System.out.println("2. Ventas");
    System.out.println("--a) Vacas: 400 gald");
    System.out.println("--b) Conejos: 170 gald");
    System.out.println("--c) Vegetales: 100 gald");
    System.out.println("-------------------------- \n");

    System.out.println("--------------------------");
    System.out.println("FIN DEL JUEGO");
    System.out.println("No te dare spoiler, solo que una vez tengas 10000 de gald habras desbloqueado la opcion para conocer el final del juego.");
    System.out.println("-------------------------- \n");
  }

  // Funcion para el menu inicial del juego
  public static void mainGame() {
    // Contadores
    int days = 1;
    int daysCosecha = 5;

    // Initialize scanner
    Scanner entry = new Scanner(System.in);

    System.out.println("<--- BIENVENIDO A STAREW VALLEY --->");
    // Ask for the name to create the game
    System.out.println("Como se llama tu jugador?");
    System.out.print("Ingresa su nombre: ");

    String nombre = entry.nextLine();

    System.out.println("Bienvenido " + nombre + ", espero disfrutes el juego!");
    System.out.println("Primero, tienes que crear tu granja!");
    System.out.println("Como llamaras tu granja?");

    String granjaName = entry.nextLine();

    System.out.println("Genial, hoy comienzas tu vida en la granja: " + granjaName);

    Granja granja = new Granja(granjaName);

    // Iniciar menu repetitivo
    do {
      // Dinero inicial para check si ha llegado a la meta o no
      double dinero = granja.getDinero();

      System.out.println("<---------- DIA: " + days + " ---------->");

      // Empezar a contar dias si hay plantas cosechandose
      if (granja.isPlantasCosechadas()) {
        if (daysCosecha > 0) {
          System.out.println("Faltan " + daysCosecha + " para que esten listas las cosechas!");
        }

        daysCosecha--;

        if (daysCosecha < 0) {
          System.out.println("Tus cosechas estan listas para retirarlas!!!");
          granja.setPlantasCosechadas(false);

          // Reiniciar dias
          daysCosecha = 5;
        }
      }

      System.out.println("Que quieres hacer en este dia?");
      System.out.println("1 - Plantar Cosechas");
      System.out.println("2 - Cosechar las Cosechas");
      System.out.println("3 - Conseguir Animales");
      System.out.println("4 - Vender Cosas");
      System.out.println("5 - Dormir \n");

      if (dinero >= 5000) {
        System.out.println("--Has conseguido suficiente dinero como para retirarte--");
        System.out.println("Ya puede conocer el final del juego...");
        System.out.println("Selecciona 7 para ver el final \n");
      }

      System.out.print("Ingrese la opcion: ");
      int option = entry.nextInt();

      switch (option) {
        case 1 -> {
          granja = plantarCosechas(granja);
        }

        case 2 -> {
          granja = cosechar(granja);
        }

        case 3 -> {
          granja = comprarAnimales(granja);
        }

        case 4 -> {
          granja = venderCosas(granja);
        }

        case 5 -> {
          System.out.println("Ve a dormir, ten un buen descanso!");
        }

        case 7 -> {

        }

        default ->
          System.out.println("Elija una opcion de las anteriores");
      }

      // Aumentar dia tras finalizar una accion 
      days++;

      System.out.println("<---------- FIN DEL DIA ----------> \n");

      if (dinero >= 5000 && option == 7) {
        finalOfGame(nombre, granja);
        break;
      }
    } while (true);

  }

  // Metodo para plantar las cosechas
  public static Granja plantarCosechas(Granja granja) {
    // Initialize scanner
    Scanner entry = new Scanner(System.in);

    if (granja.isPlantasCosechadas()) {
      System.out.println("No puedes plantar ahorita, porque ya tienes plantas en proceso...");
      return granja;
    } else {
      if (granja.isYaPlanto()) {
        System.out.println("No puedes plantar ahorita, primero tienes que colectar las cosechas...");
        return granja;
      } else {
        System.out.println("Cuantas cosechas deseas plantar?");
        int cantidadCosechas = entry.nextInt();

        granja.setCantidadVegetales(cantidadCosechas);

        granja.setPlantasCosechadas(true);
        granja.setYaPlanto(true);

        System.out.println("PLANTANDO COSECHAS...");
        System.out.println("Las cosechas tardan 5 dias en estar");

        return granja;
      }
    }
  }

  // Metodo para Cosechar las cosechas
  public static Granja cosechar(Granja granja) {
    if (!granja.isYaPlanto()) {
      System.out.println("No has plantado todavia... Primero debes de plantar para poder cosechar!");
      return granja;
    } else {
      if (granja.isPlantasCosechadas()) {
        System.out.println("LAS COSECHAS NO ESTAN LISTAS TODAVIA");
        return granja;
      } else {
        System.out.println("Ya!! Tus cosechas estan listas, puedes retirarlas");
        for (int i = 1; i <= granja.getCantidadVegetales(); i += 1) {
          System.out.println("Retirando la cosecha " + i + "...");
          granja.addVegetal();
        }

        System.out.println("Listo, has recogido todas tus cosechas!");

        granja.setCantidadVegetales(0);

        // Actualizar ya planto a falso para indicar que se recogieron las cosechas
        granja.setYaPlanto(false);
        return granja;
      }
    }
  }

  // Metodo para Conseguir animales
  public static Granja comprarAnimales(Granja granja) {
    // Initialize scanner
    Scanner entry = new Scanner(System.in);

    double dineroActual = granja.getDinero();

    if (dineroActual <= 0) {
      System.out.println("No tienes dinero para comprar cosas, ponte a trabajar!");
    } else {
      do {
        System.out.println("Cantidad de dinero actual: " + dineroActual);
        System.out.println("Que animales desea?");
        System.out.println("  1 - Conejos -> 150 gald");
        System.out.println("  2 - Vacas -> 350 gald");

        int option = entry.nextInt();

        switch (option) {
          case 1 -> {
            if (dineroActual < 150) {
              System.out.println("No tienes dinero suficiente para comprar conejos, ponte a trabajar!");
            } else {
              System.out.println("Cuantos conejos deseas?");
              int conejos = entry.nextInt();

              if (dineroActual < 150 * conejos) {
                System.out.println("No tienes tanto dinero para comprar esa cantidad de conejos, ponte a trabajar mas!");
              } else {
                // Reiniciar entry
                entry.nextLine();

                // Pedir conejos
                for (int i = 1; i <= conejos; i += 1) {
                  System.out.println("Ingrese el nombre de su nuevo conejo: ");

                  String nombreConejo = entry.nextLine();

                  granja.addConejo(nombreConejo);

                  System.out.println(nombreConejo + " ha sido enviado a la granja!");
                }

                System.out.println("Tu nueva cantidad de dinero es: " + granja.getDinero());
              }
            }
          }

          case 2 -> {
            if (dineroActual < 350) {
              System.out.println("No tienes dinero suficiente para comprar vacas, ponte a trabajar!");
            } else {
              System.out.println("Cuantas vacas deseas?");
              int vacas = entry.nextInt();

              if (dineroActual < 350 * vacas) {
                System.out.println("No tienes tanto dinero para comprar esa cantidad de vacas, ponte a trabajar mas!");
              } else {
                // Reiniciar entry
                entry.nextLine();

                // Pedir conejos
                for (int i = 1; i <= vacas; i += 1) {
                  System.out.println("Ingrese el nombre de su nueva vaca: ");

                  String nombreVaca = entry.nextLine();

                  granja.addVaca(nombreVaca);

                  System.out.println(nombreVaca + " ha sido enviado a la granja!");
                }

                System.out.println("Tu nueva cantidad de dinero es: " + granja.getDinero());
              }
            }
          }

          default ->
            System.out.println("Elija una opcion de las anteriores");
        }

        if (option == 1 || option == 2) {
          break;
        }
      } while (true);
    }

    return granja;
  }

  // Metodo para vender cosas
  public static Granja venderCosas(Granja granja) {
    // Initialize scanner
    Scanner entry = new Scanner(System.in);

    System.out.println("---------ANALISIS DE GRANJA---------");
    System.out.println("Tienes " + granja.getVegetales().size() + " Vegetales");
    System.out.println("Tienes " + granja.getVacas().size() + " Vacas");
    System.out.println("Tienes " + granja.getConejos().size() + " Conejos");
    System.out.println("Tu dinero actual es: " + granja.getDinero());
    System.out.println("------------------------------------ \n");

    do {
      System.out.println("Seleccione una opcion para vender: ");
      System.out.println("1. Vegetales");
      System.out.println("2. Vacas");
      System.out.println("3. Conejos");

      int option = entry.nextInt();

      switch (option) {
        case 1 -> {
          if (granja.getVegetales().isEmpty()) {
            System.out.println("No tienes vegetales para vender!");
          } else {
            System.out.println("La cantidad de vegetales que tienes es: " + granja.getVegetales().size());
            System.out.print("Ingrese la cantidad a vender: ");

            int cantidadVender = entry.nextInt();

            if (cantidadVender > granja.getVegetales().size()) {
              System.out.println("No puedes vender mas de los que tienes!");
            } else {
              for (int i = 1; i <= cantidadVender; i += 1) {
                granja.sellVegetal();
              }

              System.out.println("Se han vendido " + cantidadVender);
            }
          }

          System.out.println("Tu nueva cantidad de dinero es: " + granja.getDinero());
        }

        case 2 -> {
          if (granja.getVacas().isEmpty()) {
            System.out.println("No tienes vacas para vender!");
          } else {
            System.out.println("La cantidad de vacas que tienes es: " + granja.getVacas().size());
            System.out.println("Y sus nombres son: ");

            for (int i = 0; i < granja.getVacas().size(); i += 1) {
              Vaca vaca = (Vaca) granja.getVacas().get(i);
              System.out.println(vaca.getNombreVaca());
            }

            System.out.println("Ingrese la cantidad a vender: ");

            int cantidadVender = entry.nextInt();

            if (cantidadVender > granja.getVacas().size()) {
              System.out.println("No puedes vender mas de los que tienes!");
            } else {
              for (int i = 1; i <= cantidadVender; i += 1) {
                granja.sellVaca();
              }

              System.out.println("Se han vendido " + cantidadVender);
            }
          }

          System.out.println("Tu nueva cantidad de dinero es: " + granja.getDinero());
        }

        case 3 -> {
          if (granja.getConejos().isEmpty()) {
            System.out.println("No tienes conejos para vender!");
          } else {
            System.out.println("La cantidad de conejos que tienes es: " + granja.getConejos().size());
            System.out.println("Y sus nombres son: ");

            for (int i = 0; i < granja.getConejos().size(); i += 1) {
              Conejo conejo = (Conejo) granja.getConejos().get(i);
              System.out.println(conejo.getNombreConejo());
            }

            System.out.println("Ingrese la cantidad a vender: ");

            int cantidadVender = entry.nextInt();

            if (cantidadVender > granja.getConejos().size()) {
              System.out.println("No puedes vender mas de los que tienes!");
            } else {
              for (int i = 1; i <= cantidadVender; i += 1) {
                granja.sellConejo();
              }
              System.out.println("Se han vendido " + cantidadVender);
            }
          }

          System.out.println("Tu nueva cantidad de dinero es: " + granja.getDinero());
        }

        default ->
          System.out.println("Elija una opcion de las anteriores");
      }

      if (option == 1 || option == 2 || option == 3) {
        break;
      }
    } while (true);

    return granja;
  }

  // Funcion para el final del juego
  public static void finalOfGame(String nombre, Granja granja) {
    System.out.println("Luego de haber obtenido " + granja.getDinero() + " gald...");
    System.out.println("Y de haber obtenido todos estos recursos: ");

    System.out.println("---------ANALISIS DE GRANJA---------");
    System.out.println("Tienes " + granja.getVegetales().size() + " Vegetales");
    System.out.println("Tienes " + granja.getVacas().size() + " Vacas");
    System.out.println("Tienes " + granja.getConejos().size() + " Conejos");
    System.out.println("------------------------------------ \n");

    System.out.println(nombre + " decidio retirarse, y vivir una vida aun mas tranquila...");
    System.out.println("Se caso con el amor de su vida, tuvo hijos, los vio crecer, compuso mucha musica...");
    System.out.println("Nunca regreso a la vida cotidiana...");
    System.out.println("Estuvo siemopre alejado de todo ajetreo de la vida, trabajo, universidad y programacion... ");
    System.out.println("Para vivir en el campo, en paz, soledad, y feliz de la vida!! \n");

    System.out.println("------THE END------");

    System.exit(0);
  }
}
