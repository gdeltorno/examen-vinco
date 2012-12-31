package examen.vinco
import groovyx.net.ws.WSClient

class TemperaturaService {

    def convertirTemperatura(def cantidad, def unidadOrigen, def unidadFinal) {

        try {
            def proxy = new WSClient("http://www.webservicex.net/ConvertTemperature.asmx?WSDL", this.class.classLoader)

            proxy.initialize()

            def resultado = proxy.ConvertTemp(cantidad, unidadOrigen, unidadFinal)

            return resultado

        } catch(all) {
            throw new Exception("No se pudo convertir la temperatura")
        }
    }
}
