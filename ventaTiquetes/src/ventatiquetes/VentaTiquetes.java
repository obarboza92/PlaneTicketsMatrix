package ventatiquetes;

import javax.swing.JOptionPane;

public class VentaTiquetes {

    public static void main(String[] args) {

        ventas v1 = new ventas();

        int opcion = 0;

        JOptionPane.showMessageDialog(null, " Bienvenido a la venta de tiquetes del Aeropuerto Juan Santamaria ");
        JOptionPane.showMessageDialog(null, " Indicaciones generales: \n"
                + "• Al momento de reservar un asiento se mostraran en consola todos los asientos separados por clase \n"
                + "• Los asientos verdes son los disponibles y los rojos los reservados \n"
                + "• En la opcion 4 puede consultar la disponibilidad de los asientos por clase y en total");
        do {

            // mensaje de bienvenida
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1. Reservar asiento \n"
                        + "2. Eliminar reserva de asiento \n"
                        + "3. Mostrar asientos de avion \n"
                        + "4. Disponibilidad asientos \n"
                        + "5. Salir", " Menu de Opciones", 3));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Caracter invalido");
            }

            switch (opcion) {

                case 1:
                    v1.venderAsiento();
                    break;
                case 2:
                    v1.eliminarAsiento();
                    break;
                case 3:
                    System.out.println(v1.verAsientos());
                    break;
                case 4:
                    System.out.println(v1.disponibilidadAsientos());
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Adios");
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Intente de Nuevo");
                    break;
            }

        } while (opcion <= 6);

    }

}
