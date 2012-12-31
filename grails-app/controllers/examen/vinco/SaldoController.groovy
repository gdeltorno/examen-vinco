package examen.vinco

class SaldoController {

    def scaffold = true

    def saldoService

    def upload = {

    }

    def uploadFile = {

        def file = request.getFile('file')


        if (file?.empty) {
            flash.message = "El archivo ${file.originalFilename} está vacío"
            redirect(action: "upload")
        }

        try {
            def contenido = file?.inputStream?.readLines()

            saldoService.importarSaldos(contenido)

            flash.message = "Carga de archivo de saldos ${file?.originalFilename} exitosa"
            redirect(action: "upload")

        } catch (Exception e) {
            flash.message = e?.cause
            redirect(action: "upload")

        }
    }
}
