package ru.Artem.telegrambot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.Artem.telegrambot.model.Client;
import ru.Artem.telegrambot.repository.ClientRepository;


@SpringBootTest
public class FillingTests {
    @Autowired
    private ClientRepository clientRepository;

    @Test
    void createTwoClients(){
        Client client1 = new Client();
        client1.setAddress("address1");
        client1.setExternalID(1L);
        client1.setName("Name");
        client1.setPhoneNum("+123121421");
        clientRepository.save(client1);

        Client client2 = new Client();
        client2.setAddress("address1");
        client2.setExternalID(1L);
        client2.setName("Name2");
        client2.setPhoneNum("1413525235");
        clientRepository.save(client2);
    }
}
