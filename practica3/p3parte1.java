package practica3;

import java.util.Scanner;

public class p3parte1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String nombre, numero;
        double tipo, importe;

//se crea objeto cuenta1 sin parámetros
//se ejecuta el constructor por defecto
        System.out.println("Bienvenido. Introduce los datos para crear una cuenta, por favor:");
        Cuenta cuenta1 = new Cuenta();

        System.out.print("Nombre: ");
        nombre = sc.nextLine();
        System.out.print("Número de cuenta: ");
        numero = sc.nextLine();
        System.out.print("Tipo de interes: ");
        tipo = sc.nextDouble();
        System.out.print("Saldo: ");
        importe = sc.nextDouble();

        cuenta1.setNombre(nombre);
        cuenta1.setNumeroCuenta(numero);
        cuenta1.setTipoInteres(tipo);
        cuenta1.setSaldo(importe);


//Copia de cuenta1 para tener otra a la que hacer la transferencia
        Cuenta cuenta2 = new Cuenta(cuenta1);

        System.out.println("Elige que quieres hacer:");
        System.out.println("1. Ingreso");
        System.out.println("2. Reintegro");
        System.out.println("3. Transferencia");
        System.out.println("4. Salir");
        int opcion;
        boolean salir = false;

        while (!salir) {

            System.out.println("Elige que quieres hacer:");
            System.out.println("1. Ingreso");
            System.out.println("2. Reintegro");
            System.out.println("3. Transferencia");
            System.out.println("4. Salir");

            System.out.println("Escribe una de las opciones");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("¿Cuánto quieres ingresar?");
                    int ingresar;
                    ingresar = sc.nextInt();
                    cuenta1.ingreso(ingresar);
                    System.out.println("Este es el saldo de la cuenta.");
                    System.out.println("Saldo: " + cuenta1.getSaldo());
                    System.out.println();
                    break;
                case 2:
                    System.out.println("¿Cuánto quieres retirar?");
                    int retirar;
                    retirar = sc.nextInt();
                    cuenta1.reintegro(retirar);
                    System.out.println("Este es el saldo de la cuenta.");
                    System.out.println("Saldo: " + cuenta1.getSaldo());
                    System.out.println();
                    break;
                case 3:
                    System.out.println("¿Cuánto quieres transferir?");
                    int transferir;
                    transferir = sc.nextInt();
                    cuenta1.transferencia(cuenta2, transferir);
                    System.out.println("Este es el saldo de la cuenta a la que se ha hecho la transferencia, que es una copia de la primera.");
                    System.out.println("Saldo: " + cuenta2.getSaldo());
                    System.out.println("Este es el saldo de la cuenta desde la que se ha hecho la transferencia.");
                    System.out.println("Saldo: " + cuenta1.getSaldo());
                    System.out.println();
                    break;
                case 4:
                    salir = true;
                    break;
                default:
                    System.out.println("Solo números entre 1 y 4");

            }

        }
    }

    public static class Cuenta {

        private String nombre;
        private String numeroCuenta;
        private double tipoInteres;
        private double saldo;

        //Constructor por defecto
        public Cuenta() {
        }

        //Constructor con parámetros
        public Cuenta(String nombre, String numeroCuenta, double tipoInteres, double saldo) {
            this.nombre = nombre;
            this.numeroCuenta = numeroCuenta;
            this.tipoInteres = tipoInteres;
            this.saldo = saldo;
        }

        //Constructor copia
        public Cuenta(final Cuenta c) {
            nombre = c.nombre;
            numeroCuenta = c.numeroCuenta;
            tipoInteres = c.tipoInteres;
            saldo = c.saldo;
        }

        //getters y setters
        public void setNombre(String s) {
            nombre = s;
        }

        public void setNumeroCuenta(String s) {
            numeroCuenta = s;
        }

        public void setTipoInteres(double n) {
            tipoInteres = n;
        }

        public void setSaldo(double n) {
            saldo = n;
        }

        public String getNombre() {
            return nombre;
        }

        public String getNumeroCuenta() {
            return numeroCuenta;
        }

        public double getTipoInteres() {
            return tipoInteres;
        }

        public double getSaldo() {
            return saldo;
        }

        //método ingreso
        public boolean ingreso(double n) {
            boolean ingresoCorrecto = true;
            if (n < 0) {
                ingresoCorrecto = false;
            } else {
                saldo = saldo + n;
            }
            return ingresoCorrecto;
        }

        //método reintegro
        public boolean reintegro(double n) {
            boolean reintegroCorrecto = true;
            if (n < 0) {
                reintegroCorrecto = false;
            } else if (saldo >= n) {
                saldo -= n;
            } else {
                reintegroCorrecto = false;
            }
            return reintegroCorrecto;
        }

        //método transferencia
        public boolean transferencia(Cuenta c, double n) {
            boolean correcto = true;
            if (n < 0) {
                correcto = false;
            } else if (saldo >= n) {
                reintegro(n);
                c.ingreso(n);
            } else {
                correcto = false;
            }
            return correcto;
        }
    }
}
