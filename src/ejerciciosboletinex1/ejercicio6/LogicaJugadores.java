package ejerciciosboletinex1.ejercicio6;

import java.util.ArrayList;
import java.util.List;

public class LogicaJugadores {
    private static List<Jugador> listaJugadores = new ArrayList<>();
    
    public static List<Jugador> getListaJugadores() {
        return listaJugadores;
    }
    
    public static void añadirJugador(Jugador jugador) {
        listaJugadores.add(jugador);
    }
}