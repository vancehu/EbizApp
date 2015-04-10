package my.ebizapp.controller;

import my.ebizapp.model.Area;
import my.ebizapp.model.AreaRepository;
import my.ebizapp.model.Customer;
import my.ebizapp.model.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Vance on 4/10/15.
 */
@RestController
public class WebController {
    @Autowired
    AreaRepository areaRepo;
    CustomerRepository customerRepo;

    @RequestMapping("/addCustomer")
    public Iterable<Customer> addCustomer(@RequestParam String username, @RequestParam String password, @RequestParam(required = false) String orgName, @RequestParam String email, @RequestParam(required = false) String description, @RequestParam(required = false) String avatarLink, @RequestParam(required = false) String zipcode) {
        Area area = null;
        if(areaRepo.findByZipcode(zipcode).size()>0)
            area = areaRepo.findByZipcode(zipcode).get(0);
        customerRepo.save(new Customer(username, password, orgName, email, description, avatarLink, area));
        return customerRepo.findAll();
    }

}
