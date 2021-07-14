package ventatiquetes;

public class asiento {

    private String letra;
    private int numero;
    private boolean estado;

    public asiento() {
    }

    public asiento(String letra, int numero) {
        this.letra = letra;
        this.numero = numero;
    }

    public String getNombre() {
        return letra + numero;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
