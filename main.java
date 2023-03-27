/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programacuerposcelestes;

import ExcepcionesCuerpoCeleste.ExcepcionesCuerpoCeleste;
import modelo.CuerpoCeleste;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.*;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static final long serialVersionUID = 1L;
    File sistemaSolar = new File("C:\\Users\\David\\Desktop\\sistemaSolar.txt");
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<CuerpoCeleste> cc = new ArrayList();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        //declaraciones
        Scanner sc = new Scanner(System.in);
        String continuar = "n";
        byte opcion;
        //creamos el bucle para el menu
        while (continuar.equalsIgnoreCase("n")) {
            try {
                desplegarMenu();
                opcion = sc.nextByte();

                //en caso de que no se elija ninguna opcion del menu
                errorMenu(opcion);

                switch (opcion) {

                    case 1:
                        añadirCuerpo();

                        break;

                    case 2:

                        break;

                    case 3:
                        break;

                    case 4:
                        break;

                    case 5:
                        break;

                    case 6:
                        break;

                    case 7:
                        System.out.println("Desea salir?");
                        sc.nextLine();  //limpiamos el buffer
                        continuar = sc.nextLine();
                        break;
                }

                while (!continuar.equalsIgnoreCase("s") && !continuar.equalsIgnoreCase("n")) {
                    System.out.println("por favor, ingrese una opcion valida S/N");
                    continuar = sc.nextLine();
                }
            } catch (ExcepcionesCuerpoCeleste ex) {
                System.out.println(ex.getMessage());
            }   catch(NumberFormatException ex){
                System.out.println("debe ingresar un valor numerico");
            }
        }

    }

    //metodo menu
    private static void desplegarMenu() {
        System.out.println("Seleccione una de las siguientes opciones");
        System.out.println("1. Añadir cuerpo celeste");
        System.out.println("2. Listar cuerpos celestes");
        System.out.println("3. Buscar cuerpo celeste por codigo");
        System.out.println("4. Buscar cuepo celeste por tipo");
        System.out.println("5. Borrar cuerpo celeste");
        System.out.println("6. Borrar fichero de cuerpos celestes");
        System.out.println("7. Salir de la aplicacion");
    }

    private static void añadirCuerpo() {
        String codigoCuerpoL = " ";//3digitos
        short codigoCuerpo;//3digitos
        String nombre = "123123123123123123";    //15caracteres
        int diametro;
        String diametroL = "312315523";
        String tipoObjeto = "";

        //codigoObjeto
        while (!(codigoCuerpoL.length() == 3 && codigoCuerpoL.matches("\\d+"))) {
            try {
                System.out.println("Indique el codigo del objeto");
                codigoCuerpoL = sc.nextLine();
                codigoCuerpo = Short.parseShort(codigoCuerpoL);

                errorCodigoCuerpo(codigoCuerpoL);
            } catch (ExcepcionesCuerpoCeleste ex) {
                System.out.println(ex.getMessage());
            } catch (NumberFormatException ex) {
                System.out.println("El valor ingresado tiene que ser numerico");
            }
        }

        //nombre
        while (nombre.length() > 15) {
            try {
                System.out.println("Ingrese el nombre del objeto");
                nombre = sc.nextLine();
                errorNombre(nombre);
            } catch (ExcepcionesCuerpoCeleste ex) {
                System.out.println(ex.getMessage());
            }
        }

        //tipoObjeto
        while (!tipoObjeto.equalsIgnoreCase("planeta") && !tipoObjeto.equalsIgnoreCase("planetaEnano") && !tipoObjeto.equalsIgnoreCase("luna")) {
            try {
                System.out.println("Ingrese el tipo de objeto sin espacios");
                tipoObjeto = sc.nextLine();
                errorTipoObjeto(tipoObjeto);
            } catch (ExcepcionesCuerpoCeleste ex) {
                System.out.println(ex.getMessage());
            }
        }

        //diametro
        while (diametroL.length() > 6 && diametroL.matches("\\d+")) {
            try {
                
                System.out.println("Ingrese el diametro del objeto");
                diametroL = sc.nextLine();
                diametro = Integer.parseInt(diametroL);
                errorDiametro(diametroL);
                
            } catch (ExcepcionesCuerpoCeleste ex) {
                System.out.println(ex.getMessage());
            } catch (NumberFormatException ex) {
                System.out.println("El valor ingresado tiene que ser numerico");
            }

        }

    }

    //excepciones
    private static void errorCodigoCuerpo(String codigoCuerpoL) throws ExcepcionesCuerpoCeleste {
        if (codigoCuerpoL.length() != 3) {
            throw new ExcepcionesCuerpoCeleste("La longitud del codigo tiene que ser de 3 cifras");
        }
    }

    private static void errorNombre(String nombre) throws ExcepcionesCuerpoCeleste {
        if (nombre.length() > 15) {
            throw new ExcepcionesCuerpoCeleste("El nombre tiene que ser de maximo 15 caracteres");
        }
    }

    private static void errorTipoObjeto(String tipoObjeto) throws ExcepcionesCuerpoCeleste {
        if (!tipoObjeto.equalsIgnoreCase("planeta") && !tipoObjeto.equalsIgnoreCase("planetaEnano") && !tipoObjeto.equalsIgnoreCase("luna")) {
            throw new ExcepcionesCuerpoCeleste("El tipo ingresado debe ser uno de los siguientes: planeta - planetaEnano - luna");
        }
    }

    private static void errorDiametro(String diametroL) throws ExcepcionesCuerpoCeleste {
        if (diametroL.length() >= 6) {
            throw new ExcepcionesCuerpoCeleste("El diametro debe ser inferior a 6 digitos");
        } 
    }
    
    private static void errorMenu(int opcion)throws ExcepcionesCuerpoCeleste{
         if (opcion < 1 || opcion > 7) {
                    throw new ExcepcionesCuerpoCeleste("El numero introducido tiene que estar entre el 1 y 7");
                } else if(!opcion.matches("\\d+")){
                throw new ExcepcionesCuerpoCeleste("Tiene que ingresar un numero");
                }
        
    }

}

//BufferedReader br = new BufferedReader(new FileReader("malaga.txt")); <- indica el archivo a leer
//br.readLine() <-- lee la linea
//br.close(); <-- deja de leer
// /r/n <-- salto de linea

