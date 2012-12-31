package examen.vinco

import grails.validation.Validateable

@Validateable
class Temperatura {
    Double cantidad
    String unidadOrigen
    String unidadFinal

    static constraints = {
        cantidad(nullable: false)
        unidadOrigen(blank: false, inList: ["degreeCelsius",
                "degreeFahrenheit",
                "degreeRankine",
                "degreeReaumur",
                "kelvin"])
        unidadFinal(blank: false, inList: ["degreeCelsius",
                "degreeFahrenheit",
                "degreeRankine",
                "degreeReaumur",
                "kelvin"])
    }
}
