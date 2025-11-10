/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciosboletinex1.proyectoFinalRepaso.logica;

import ejerciciosboletinex1.proyectoFinalRepaso.dto.Heroe;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class LogicaHeroes {

     private static ArrayList<Heroe> añadirHeroe = new ArrayList<>();

 
    public static void añadirheroe(Heroe heroe) {
        añadirHeroe.add(heroe);
    }

    public static List<Heroe> getListaClientes() { 
        return añadirHeroe;
    }



    
    
}
