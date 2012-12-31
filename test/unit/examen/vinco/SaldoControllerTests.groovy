package examen.vinco



import org.junit.*
import grails.test.mixin.*

@TestFor(SaldoController)
@Mock(Saldo)
class SaldoControllerTests {


    def populateValidParams(params) {
      assert params != null
      // TODO: Populate valid properties like...
      //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/saldo/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.saldoInstanceList.size() == 0
        assert model.saldoInstanceTotal == 0
    }

    void testCreate() {
       def model = controller.create()

       assert model.saldoInstance != null
    }

    void testSave() {
        controller.save()

        assert model.saldoInstance != null
        assert view == '/saldo/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/saldo/show/1'
        assert controller.flash.message != null
        assert Saldo.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/saldo/list'


        populateValidParams(params)
        def saldo = new Saldo(params)

        assert saldo.save() != null

        params.id = saldo.id

        def model = controller.show()

        assert model.saldoInstance == saldo
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/saldo/list'


        populateValidParams(params)
        def saldo = new Saldo(params)

        assert saldo.save() != null

        params.id = saldo.id

        def model = controller.edit()

        assert model.saldoInstance == saldo
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/saldo/list'

        response.reset()


        populateValidParams(params)
        def saldo = new Saldo(params)

        assert saldo.save() != null

        // test invalid parameters in update
        params.id = saldo.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/saldo/edit"
        assert model.saldoInstance != null

        saldo.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/saldo/show/$saldo.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        saldo.clearErrors()

        populateValidParams(params)
        params.id = saldo.id
        params.version = -1
        controller.update()

        assert view == "/saldo/edit"
        assert model.saldoInstance != null
        assert model.saldoInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/saldo/list'

        response.reset()

        populateValidParams(params)
        def saldo = new Saldo(params)

        assert saldo.save() != null
        assert Saldo.count() == 1

        params.id = saldo.id

        controller.delete()

        assert Saldo.count() == 0
        assert Saldo.get(saldo.id) == null
        assert response.redirectedUrl == '/saldo/list'
    }
}
