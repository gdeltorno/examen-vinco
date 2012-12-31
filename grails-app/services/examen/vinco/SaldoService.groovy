package examen.vinco

class SaldoService {

    def importarSaldos(List contenido) throws Exception {
        Saldo.withTransaction { tx ->

            def contador = 1

            for (linea in contenido){
                List info = lineaToInfo(linea?.toString())
                 println info
                if (!info){
                    tx.setRollbackOnly()
                    throw new Exception("Ocurrió un error en la línea ${contador}")
                } else {

                    Saldo saldoInstance = new Saldo(
                            username: info[0],
                            moneda:  info[1],
                            usuario: info[2]
                    )
                    if(!saldoInstance.validate() || !saldoInstance.save()) {
                        tx.setRollbackOnly()
                        throw new Exception("Ocurrió un error al guardar el registro de la línea ${contador}")
                    }

                }
                contador++
            }
            tx.flush()
        }

    }

    List lineaToInfo(String linea) {
         List info = linea.tokenize(',')
         if (info.size() == 3) {
            return info
         } else {
            return null
         }
    }

}

