/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.educacionit.java.advanced.thread;

/**
 *
 * @author instructor
 */
public class Caballo extends Thread {

    static int RETARDO = 100;
    private String nombre;
    private boolean finalizado = false;
    private long horaini = 0;
    private long horafin = 0;
    private int posicion = 0;
    private Meta meta;

    // Constructor
    public Caballo(String nombre, Meta meta) {
        this.nombre = nombre;
        this.meta = meta;
    }

    @Override
    public void run() {
        while (!meta.cruza(this)) {
            horafin = System.currentTimeMillis(); // Va capturando el tiempo que tarda
            try {
                sleep(RETARDO);
            } catch (InterruptedException e) {
            }
            avanza();
            System.out.println(nombre+" : "+posicion+ " metros:");
        }

        this.finalizado = true;
    }

    //Incrementa x, también incrementa el número de frame de la imagen
    public synchronized void avanza() {
        int incremento = 0;

        while (incremento == 0) {
            incremento = (int) ((Math.random() * 10) + (Math.random() * 5));
        }
        posicion += incremento;
        if (((int) (Math.random() * 10)) == 3) {
            posicion += 10;
        }
    }

    public int getPosicion() {
        return posicion;
    }

    public String getNombre() {
        return nombre;
    }

}
