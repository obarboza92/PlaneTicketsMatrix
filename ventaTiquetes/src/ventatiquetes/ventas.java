package ventatiquetes;

import javax.swing.JOptionPane;

public class ventas {

    int p1 = 0;
    int p2 = 0;
    int p3 = 0;
    int primeraLlena = 0;
    int segundaLlena = 0;
    int terceraLlena = 0;
    boolean compraRealizada = false;
    int noExistePrimera = 0;
    int noExisteSegunda = 0;
    int noExisteTercera = 0;

    String ANSI_RESET = "\u001B[0m";
    String ANSI_RED = "\u001B[31m";
    String ANSI_GREEN = "\u001B[32m";

    asiento a1 = new asiento();

    asiento[][] primeraClase = new asiento[10][5];
    asiento[][] segundaClase = new asiento[10][5];
    asiento[][] terceraClase = new asiento[10][5];

    // Rellena la matriz de asientos poniendo una letra y un número en cada espacio, además asigna el precio según la lógica determinada
    public void generarAsientos() {
        for (int f = 0; f < primeraClase.length; f++) {
            for (int c = 0; c < primeraClase[f].length; c++) {
                primeraClase[f][c] = new asiento(String.valueOf((char) (f + 65)), c + 1);
            }
        }

        //------------------//
        for (int f = 0; f < segundaClase.length; f++) {
            for (int c = 0; c < segundaClase[f].length; c++) {
                segundaClase[f][c] = new asiento(String.valueOf((char) (f + 75)), c + 1);
            }
        }

        //------------------//
        for (int f = 0; f < terceraClase.length; f++) {
            for (int c = 0; c < terceraClase[f].length; c++) {
                terceraClase[f][c] = new asiento(String.valueOf((char) (f + 97)), c + 1);
            }
        }
    }
    
    // Metodo que recorre las matrices y muestra el estado de los asientos por medio del color rojo(reservado) y verde(disponible)    
    public String verAsientos() {
        if (!compraRealizada) {
            generarAsientos();
        }
        String str = "";
        str += "Primera Clase\n";
        for (int f = 0; f < primeraClase.length; f++) {
            for (int c = 0; c < primeraClase[f].length; c++) {
                if (!primeraClase[f][c].isEstado()) {
                    str += ANSI_GREEN;
                } else {
                    str += ANSI_RED;
                }
                str += primeraClase[f][c].getNombre() + " ";
                str += ANSI_RESET;
            }
            str += "\n";
        }
        str += "--------------\n";
        str += "Segunda Clase\n";
        for (int f = 0; f < segundaClase.length; f++) {
            for (int c = 0; c < segundaClase[f].length; c++) {
                if (!segundaClase[f][c].isEstado()) {
                    str += ANSI_GREEN;
                } else {
                    str += ANSI_RED;
                }
                str += segundaClase[f][c].getNombre() + " ";
                str += ANSI_RESET;
            }
            str += "\n";
        }
        str += "--------------\n";
        str += "Tercera Clase\n";
        for (int f = 0; f < terceraClase.length; f++) {
            for (int c = 0; c < terceraClase[f].length; c++) {
                if (!terceraClase[f][c].isEstado()) {
                    str += ANSI_GREEN;
                } else {
                    str += ANSI_RED;
                }
                str += terceraClase[f][c].getNombre() + " ";
                str += ANSI_RESET;
            }
            str += "\n";
        }
        return str;
    }

    // Metodo para vender asientos, por defecto todos estan verdes, conforme se reserven se colorean rojos
    public void venderAsiento() {
        int clase = 0;
        int cantAsientos = 0;
        int contAsientos = 0;
        int cantAsientosCheck = 0;
        String numAsiento = "";
        System.out.println(verAsientos());
        /*if (!compraRealizada) {
            generarAsientos();
        }*/
        do {
            try {
                clase = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "Selecciona la clase deseada: \n"
                        + "1. Primera Clase \n"
                        + "2. Segunda Clase \n"
                        + "3. Tercera Clase", " Menu de Opciones", 3));

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Caracter invalido, intente de nuevo");
            }
            if (clase < 1 || clase > 3) {
                JOptionPane.showMessageDialog(null, "Opcion Incorrecta, intente de nuevo");
            }
        } while (clase < 1 || clase > 3);

        do {
            try {
                cantAsientos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de asientos a reservar: "));
                cantAsientosCheck = 1;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Caracter invalido");
            }
        } while (cantAsientosCheck == 0);

        switch (clase) {

            case 1:
                while (contAsientos < cantAsientos) {

                    numAsiento = JOptionPane.showInputDialog("Ingrese el asiento: ");

                    noExistePrimera = 1;
                    for (int f = 0; f < primeraClase.length; f++) {
                        for (int c = 0; c < primeraClase[f].length; c++) {
                            if (numAsiento.equals(primeraClase[f][c].getNombre())) {
                                if (!primeraClase[f][c].isEstado()) {
                                    primeraClase[f][c].setEstado(true);
                                    compraRealizada = true;
                                    JOptionPane.showMessageDialog(null, "Reserva realizada con exito");
                                    noExistePrimera = 0;
                                    primeraLlena++;
                                    break;
                                } else {
                                    JOptionPane.showMessageDialog(null, "Asiento ya fue reservado");
                                    noExistePrimera = 0;
                                    break;
                                }
                            }
                        }
                    }
                    if (primeraLlena == 50) {
                        JOptionPane.showMessageDialog(null, "Clase llena, intente en segunda o tercera clase");
                    }
                    contAsientos++;
                    if (noExistePrimera == 1) {
                        JOptionPane.showMessageDialog(null, "Asiento no existe en esta clase");
                        contAsientos--;
                    }
                }
                break;

            case 2:
                while (contAsientos < cantAsientos) {
                    numAsiento = JOptionPane.showInputDialog("Ingrese el asiento: ");
                    noExisteSegunda = 1;
                    for (int f = 0; f < segundaClase.length; f++) {
                        for (int c = 0; c < segundaClase[f].length; c++) {
                            if (numAsiento.equals(segundaClase[f][c].getNombre())) {
                                if (!segundaClase[f][c].isEstado()) {
                                    segundaClase[f][c].setEstado(true);
                                    compraRealizada = true;
                                    JOptionPane.showMessageDialog(null, "Reserva realizada con exito");
                                    noExisteSegunda = 0;
                                    segundaLlena++;
                                    break;
                                } else {
                                    JOptionPane.showMessageDialog(null, "Asiento ya fue reservado");
                                    noExistePrimera = 0;
                                    break;
                                }
                            }
                        }
                    }
                    if (segundaLlena == 50) {
                        JOptionPane.showMessageDialog(null, "Clase llena, intente en primera o tercera clase");
                    }
                    contAsientos++;
                    if (noExisteSegunda == 1) {
                        JOptionPane.showMessageDialog(null, "Asiento no existe en esta clase");
                        contAsientos--;
                    }
                }
                break;
            case 3:
                while (contAsientos < cantAsientos) {
                    numAsiento = JOptionPane.showInputDialog("Ingrese el asiento: ");
                    noExisteTercera = 1;
                    for (int f = 0; f < terceraClase.length; f++) {
                        for (int c = 0; c < terceraClase[f].length; c++) {
                            if (numAsiento.equals(terceraClase[f][c].getNombre())) {
                                if (!terceraClase[f][c].isEstado()) {
                                    terceraClase[f][c].setEstado(true);
                                    compraRealizada = true;
                                    JOptionPane.showMessageDialog(null, "Reserva realizada con exito");
                                    noExisteTercera = 0;
                                    terceraLlena++;
                                    break;
                                } else {
                                    JOptionPane.showMessageDialog(null, "Asiento ya fue reservado");
                                    noExistePrimera = 0;
                                    break;
                                }
                            }
                        }
                    }
                    if (terceraLlena == 50) {
                        JOptionPane.showMessageDialog(null, "Clase llena, intente en primera o segunda clase");
                    }
                    contAsientos++;
                    if (noExisteTercera == 1) {
                        JOptionPane.showMessageDialog(null, "Asiento no existe en esta clase");
                        contAsientos--;
                    }
                }
                break;

            default:
                JOptionPane.showMessageDialog(null, "Intente de Nuevo");
                break;
        }
    }
    
    // Metodo para eliminar el asiento seleccionado de la reserva
    public void eliminarAsiento() {
        int clase = 0;
        String numAsiento = "";
        if (!compraRealizada) {
            generarAsientos();
        }
        try {
            clase = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Selecciona la clase deseada: \n"
                    + "1. Primera Clase \n"
                    + "2. Segunda Clase \n"
                    + "3. Tercera Clase", " Menu de Opciones", 3));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Caracter invalido");
        }

        switch (clase) {

            case 1:
                numAsiento = JOptionPane.showInputDialog("Ingrese el asiento: ");
                noExistePrimera = 1;
                for (int f = 0; f < primeraClase.length; f++) {
                    for (int c = 0; c < primeraClase[f].length; c++) {
                        if (numAsiento.equals(primeraClase[f][c].getNombre())) {
                            if (primeraClase[f][c].isEstado()) {
                                primeraClase[f][c].setEstado(false);
                                compraRealizada = true;
                                JOptionPane.showMessageDialog(null, "Reserva liberada con exito");
                                noExistePrimera = 0;
                                break;
                            } else {
                                JOptionPane.showMessageDialog(null, "Asiento se encuentra disponible");
                                noExistePrimera = 0;
                                break;
                            }
                        }
                    }
                }
                if (noExistePrimera == 1) {
                    JOptionPane.showMessageDialog(null, "Asiento no existe en esta clase");
                }
                break;
            case 2:
                numAsiento = JOptionPane.showInputDialog("Ingrese el asiento: ");
                noExisteSegunda = 1;
                for (int f = 0; f < segundaClase.length; f++) {
                    for (int c = 0; c < segundaClase[f].length; c++) {
                        if (numAsiento.equals(segundaClase[f][c].getNombre())) {
                            if (segundaClase[f][c].isEstado()) {
                                segundaClase[f][c].setEstado(false);
                                compraRealizada = true;
                                JOptionPane.showMessageDialog(null, "Reserva liberada con exito");
                                noExisteSegunda = 0;
                                break;
                            } else {
                                JOptionPane.showMessageDialog(null, "Asiento se encuentra disponible");
                                noExisteSegunda = 0;
                                break;
                            }
                        }
                    }
                }
                if (noExisteSegunda == 1) {
                    JOptionPane.showMessageDialog(null, "Asiento no existe en esta clase");
                }
                break;
            case 3:
                numAsiento = JOptionPane.showInputDialog("Ingrese el asiento: ");
                noExisteTercera = 1;
                for (int f = 0; f < terceraClase.length; f++) {
                    for (int c = 0; c < terceraClase[f].length; c++) {
                        if (numAsiento.equals(terceraClase[f][c].getNombre())) {
                            if (terceraClase[f][c].isEstado()) {
                                terceraClase[f][c].setEstado(false);
                                compraRealizada = true;
                                JOptionPane.showMessageDialog(null, "Reserva liberada con exito");
                                noExisteTercera = 0;
                                break;
                            } else {
                                JOptionPane.showMessageDialog(null, "Asiento se encuentra disponible");
                                noExisteTercera = 0;
                                break;
                            }
                        }
                    }
                }
                if (noExisteTercera == 1) {
                    JOptionPane.showMessageDialog(null, "Asiento no existe en esta clase");
                }
                break;

            default:
                JOptionPane.showMessageDialog(null, "Intente de Nuevo");
                break;
        }
    }
    
    // metodo que muestra un resumen de la ocupacion de las clases y el total
    public String disponibilidadAsientos() {

        if (!compraRealizada) {
            generarAsientos();
        }
        p1 = 0;
        p2 = 0;
        p3 = 0;
        String info = "Primera clase: %d/50\n"
                + "Segunda clase: %d/50\n"
                + "Tercera clase: %d/50\n"
                + "Total: %d/150";

        for (int f = 0; f < primeraClase.length; f++) {
            for (int c = 0; c < primeraClase[f].length; c++) {
                asiento temp = primeraClase[f][c];
                if (temp.isEstado()) {
                    p1++;
                }
            }
        }

        for (int f = 0; f < segundaClase.length; f++) {
            for (int c = 0; c < segundaClase[f].length; c++) {
                asiento temp = segundaClase[f][c];
                if (temp.isEstado()) {
                    p2++;
                }
            }
        }

        for (int f = 0; f < terceraClase.length; f++) {
            for (int c = 0; c < terceraClase[f].length; c++) {
                asiento temp = terceraClase[f][c];
                if (temp.isEstado()) {
                    p3++;
                }
            }
        }

        return String.format(info, p1, p2, p3, (p1 + p2 + p3));
    }
}
