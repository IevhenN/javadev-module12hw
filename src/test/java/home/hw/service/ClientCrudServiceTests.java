package home.hw.service;

import home.hw.dao.DbInit;
import home.hw.dao.HibernateUtil;
import home.hw.entity.Client;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClientCrudServiceTests {
    private ClientCrudService clientCrudService;

    @BeforeAll
    static void setUp() {
        HibernateUtil.getInstance();
        DbInit.initTestDb();
    }

    @BeforeEach
    void setClientService() {
        clientCrudService = new ClientCrudService(HibernateUtil.getInstance().getTestSessionFactory());
    }

    @AfterEach
    void cleanUp() {
        clientCrudService = null;
    }

    @Test
    void ValidParamCreateClient() {
        //then
        Client client = new Client();
        client.setName("Petrovich Arsen");

        //when
        Long id = clientCrudService.create(client);

        assertNotNull(id);
    }

    @Test
    void ValidUpdateClient() {
        //then
        Client expected = clientCrudService.getById(1L);
        expected.setName("New name");
        //when
        clientCrudService.update(expected);
        Client result = clientCrudService.getById(1L);
        assertEquals(expected, result);
    }

    @Test
    void ValidDeleteClient() {
        //then
        Client expected = clientCrudService.getById(3L);

        //when
        clientCrudService.delete(expected);
        Client result = clientCrudService.getById(3L);

        assertTrue(expected != null && result == null);
    }

}
