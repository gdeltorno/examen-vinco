package examen.vinco

class TemperaturaController {

    def temperaturaService

    def index = {

        def unidades = [
                "degreeCelsius",
                "degreeFahrenheit",
                "degreeRankine",
                "degreeReaumur",
                "kelvin"
        ]

        [unidades:unidades]
    }

    def convertir = { Temperatura cmd ->

      if (cmd.hasErrors()) {
          flash.message = "Los parámetros enviados no son válidos"
          redirect(action: "index")

      } else {
          try {
              def cantidad = params.double('cantidad')

              def resultado = temperaturaService.convertirTemperatura(cantidad, params?.unidadOrigen, params?.unidadFinal)

              render "El resultado de la conversión es: ${resultado}"

          } catch(Exception e) {
              flash.message = e?.cause
              redirect(action: "index")
          }
      }

    }
}
