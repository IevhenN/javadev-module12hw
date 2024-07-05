
package home.hw.service;

        import home.hw.dao.DbInit;
        import home.hw.dao.HibernateUtil;
        import home.hw.entity.Planet;
        import org.junit.jupiter.api.AfterEach;
        import org.junit.jupiter.api.BeforeAll;
        import org.junit.jupiter.api.BeforeEach;
        import org.junit.jupiter.api.Test;

        import static org.junit.jupiter.api.Assertions.*;

class PlanetCrudServiceTest {
    private PlanetCrudService planetCrudService;
    @BeforeAll
    static void setUp(){
        HibernateUtil.getInstance();
        DbInit.initTestDb();
    }
    @BeforeEach
    void setPlanetService() {
        planetCrudService = new PlanetCrudService(HibernateUtil.getInstance().getTestSessionFactory());
    }

    @AfterEach
    void cleanUp() {
        planetCrudService = null;
    }
    @Test
    void ValidParamCreatePlanet() {
        //then
        String expected = "MRC";
        Planet planet = new Planet();
        planet.setName("Mercury");
        planet.setId(expected);

        //when
        String result = planetCrudService.create(planet);

        assertEquals(expected,result);
    }

    @Test
    void ValidUpdatePlanet(){
        //then
        String id = "MRC";
        Planet expected = planetCrudService.getById(id);
        expected.setName("Mercuryyy");
        //when
        planetCrudService.update(expected);
        Planet result = planetCrudService.getById(id);
        assertEquals(expected,result);
    }

    @Test
    void ValidDeletePlanet(){
        //then
        String id = "MRC";
        Planet expected = planetCrudService.getById(id);

        //when
        planetCrudService.delete(expected);
        Planet result = planetCrudService.getById(id);

        assertTrue(expected!=null&&result==null);
    }

}
