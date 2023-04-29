/**
 * Clase Moneda
 */
abstract class Moneda{
    /**
     * Metodo constructor de moneda
     */
    public Moneda(){}
    /**
     * Metodo que
     * @return : retorna la direccion de memoria de moneda
     */
    public Moneda getSerie(){
        return this;
    }

    /**
     * metodo que
     * @return : retorna el valor de la moneda
     */
    public abstract int getValor();

}