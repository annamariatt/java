package ee.bcs.java.controller;

import ch.qos.logback.core.net.server.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Client2Controller {

    private List<ClientDto> clients = new ArrayList();

    // http://localhost:8080/client?name=John&address=USA&age=33 (POST)
    @GetMapping("client/createClient")
    public String createClient(@RequestParam("name") String name,
                               @RequestParam("address") String address,
                               @RequestParam("age") Integer age) {
        //TODO lisa clients listi uus klient
        ClientDto client = new ClientDto();
        client.setName(name);
        client.setAddress(address);
        client.setAge(age);
        //result(0) = client;
        clients.add(client);
        return "Klient on loodud";
    }

    // http://localhost:8080/client (GET)
    @GetMapping("client")
    public List<ClientDto> getAllClient() {
        return clients;
        //TODO tagasta kõik kliendid
    }

    //http://localhost:8080/client/1
    @GetMapping("client/{id}")
    public ClientDto getClient(@PathVariable("id") int id) {
        return clients.get(id);
    }

    // http://localhost:8080/client/1 (DELETE)
    @DeleteMapping("client/{id}")
    public void deleteClient(@PathVariable("id") int id){
            clients.remove(id);
}

}
