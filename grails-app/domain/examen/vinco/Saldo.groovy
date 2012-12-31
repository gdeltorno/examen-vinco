package examen.vinco

class Saldo {
    String username
    Double moneda
    String usuario


    static constraints = {
        username matches: "[0-9]+", maxSize: 10, blank: false
        moneda nullable: false, min: 0d
        username blank: false
    }

}
