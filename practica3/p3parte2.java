package practica3;

import java.util.Scanner;

public class p3parte2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String nombre, apellido;
        double telefono, saldomovil;

//se crea objeto cuenta1 sin parámetros
//se ejecuta el constructor por defecto
        System.out.println("Bienvenido. Introduce los datos para crear un usuario de un teléfono móvil, por favor:");
        Usuario usuario1 = new Usuario();

        System.out.print("Nombre: ");
        nombre = sc.nextLine();
        System.out.print("Apellido: ");
        apellido = sc.nextLine();
        System.out.print("Número de teléfono: ");
        telefono = sc.nextDouble();
        System.out.print("Saldo del móvil: ");
        saldomovil = sc.nextDouble();

        usuario1.setNombre(nombre);
        usuario1.setApellido(apellido);
        usuario1.setTelefono(telefono);
        usuario1.setSaldoMovil(saldomovil);

        System.out.println("Elige que quieres hacer:");
        System.out.println("1. Recargar");
        System.out.println("2. Gastar");
        System.out.println("3. Salir");
        int opcion;
        boolean salir = false;

        while (!salir) {

            System.out.println("Elige que quieres hacer:");
            System.out.println("1. Recargar");
            System.out.println("2. Gastar");
            System.out.println("3. Salir");

            System.out.println("Elige la opción que quieres: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("¿Cuánto dinero quieres recargar?");
                    int recargar;
                    recargar = sc.nextInt();
                    usuario1.recarga(recargar);
                    System.out.println("Este es el saldo actual del móvil.");
                    System.out.println("Saldo: " + usuario1.getSaldoMovil());
                    System.out.println();
                    break;
                case 2:
                    System.out.println("¿Cuánto dinero vas a gastar?");
                    int gastar;
                    gastar = sc.nextInt();
                    usuario1.gasto(gastar);
                    System.out.println("Este es el saldo actual del móvil.");
                    System.out.println("Saldo: " + usuario1.getSaldoMovil());
                    System.out.println();
                    break;
                case 3:
                    salir = true;
                    break;
                default:
                    System.out.println("Solo números entre 1 y 3");

            }

        }
    }

    public static class Usuario {

        private String nombre;
        private String apellido;
        private double telefono;
        private double saldomovil;

        //Constructor por defecto
        public Usuario() {
        }

        //Constructor con parámetros
        public Usuario(String nombre, String apellido, double telefono, double saldomovil) {
            this.nombre = nombre;
            this.apellido = apellido;
            this.telefono = telefono;
            this.saldomovil = saldomovil;
        }

        //Constructor copia
        public Usuario(final Usuario c) {
            nombre = c.nombre;
            apellido = c.apellido;
            telefono = c.telefono;
            saldomovil = c.saldomovil;
        }

        //getters y setters
        public void setNombre(String s) {
            nombre = s;
        }

        public void setApellido(String s) {
            apellido = s;
        }

        public void setTelefono(double n) {
            telefono = n;
        }

        public void setSaldoMovil(double n) {
            saldomovil = n;
        }

        public String getNombre() {
            return nombre;
        }

        public String getApellido() {
            return apellido;
        }

        public double getNDni() {
            return telefono;
        }

        public double getSaldoMovil() {
            return saldomovil;
        }

        //método recarga
        public boolean recarga(double n) {
            boolean recargaCorrecta = true;
            if (n < 0) {
                recargaCorrecta = false;
            } else {
                saldomovil = saldomovil + n;
            }
            return recargaCorrecta;
        }

        //método gasto
        public boolean gasto(double n) {
            boolean gastoCorrecto = true;
            if (n < 0) {
                gastoCorrecto = false;
            } else if (saldomovil >= n) {
                saldomovil -= n;
            } else {
                gastoCorrecto = false;
            }
            return gastoCorrecto;
        }
    }
}
