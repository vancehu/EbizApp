package my.ebizapp.controller;

import my.ebizapp.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Properties;
import java.util.UUID;

/**
 * Created by Vance on 4/10/15.
 */
@Controller
public class WebController {

    @Autowired
    AreaRepository areaRepo;
    @Autowired
    CustomerRepository customerRepo;
    @Autowired
    SupplierRepository supplierRepo;
    @Autowired
    MessageRepository messageRepo;

    @RequestMapping("/customer/register")
    @ResponseBody
    public void customerRegister(@RequestParam String username, @RequestParam String password, @RequestParam(required =
            false) String orgName, @RequestParam String email, @RequestParam(required = false) String description,
                                 @RequestParam(required = false) String avatarLink, @RequestParam(required = false) String
                                         zipcode) {
        Area area = null;
        List<Area> result = areaRepo.findByZipcode(zipcode);
        if (result.size() > 0) {
            area = result.get(0);
        }
        customerRepo.save(new Customer(username, password, orgName, email, description, avatarLink, area));
    }

    @RequestMapping("/customer/login")
    @ResponseBody
    public boolean customerLogin(@RequestParam String username, @RequestParam String password, HttpSession session) {
        List<Customer> result = customerRepo.findByUsernameAndPassword(username, password);
        if (result.size() > 0) {
            session.removeAttribute("supplier");
            session.setAttribute("customer", result.get(0));
            //merge cart
            return true;
        } else {
            return false;
        }
    }

    @RequestMapping("/customer/logout")
    @ResponseBody
    public void customerLogout(HttpSession session) {
        session.removeAttribute("supplier");
        session.removeAttribute("customer");
    }

    @RequestMapping("/customer/getStatus")
    @ResponseBody
    public Customer customerGetStatus(HttpSession session) {
        if(session.getAttribute("customer") == null)
            throw new BadRequestException("invalid");
        return (Customer) session.getAttribute("customer");
    }

    @RequestMapping("/supplier/login")
    @ResponseBody
    public boolean supplierLogin(@RequestParam String username, @RequestParam String password, HttpSession session) {
        List<Customer> result = supplierRepo.findByUsernameAndPassword(username, password);
        if (result.size() > 0) {
            session.removeAttribute("customer");
            session.setAttribute("supplier", result.get(0));
            return true;
        } else {
            return false;
        }
    }

    @RequestMapping("/supplier/logout")
    @ResponseBody
    public void supplierLogout(HttpSession session) {
        session.removeAttribute("supplier");
        session.removeAttribute("customer");
    }

    @RequestMapping("/supplier/getStatus")
    @ResponseBody
    public Supplier supplierGetStatus(HttpSession session) {
        if(session.getAttribute("supplier") == null)
            throw new BadRequestException("invalid");
        return (Supplier) session.getAttribute("supplier");
    }

    void customerUpdate() {
    }

    void customerUpdatePassword() {
    }

    void supplierUpdate() {
    }

    void supplierUpdatePassword() {
    }

    void customerCheckUsernameAvailability() {
    }

    void customerCheckEmailAvailability() {
    }

    void supplierCheckUsernameAvailability() {
    }

    void supplierCheckEmailAvailability() {
    }



    void getCart() {
    }

    void addCart() {
    }

    void removeCart() {
    }




    @RequestMapping("/customer/sendMessage")
    @ResponseBody
    public void customerSendMessage(@RequestParam String message, @RequestParam long supplierId, HttpSession session) {
        if (session.getAttribute("customer") == null)
            throw new BadRequestException("invalidSession");
        messageRepo.save(new Message(message, (Customer) session.getAttribute("customer"), supplierRepo.findById(supplierId)
                .get(0), false));
    }

    @RequestMapping("/customer/getMessage")
    @ResponseBody
    public List<Message> customerGetMessage(HttpSession session) {
        if (session.getAttribute("customer") == null)
            throw new BadRequestException("invalidSession");
        return messageRepo.findByCustomerOrderByTimeDesc((Customer) session.getAttribute("customer"));
    }

    @RequestMapping("/customer/markMessageRead")
    void customerMarkMessageRead(@RequestParam long id, HttpSession session) {
        if (session.getAttribute("customer") == null)
            throw new BadRequestException("invalidSession");
        List<Message> result = messageRepo.findByIdAndCustomer(id, (Customer) session.getAttribute("customer"));
        if (result.size() > 0) {
            result.get(0).setHasRead(true);
        }
    }

    @RequestMapping("/supplier/sendMessage")
    @ResponseBody
    public void supplierSendMessage(@RequestParam String message, @RequestParam long customerId, HttpSession session) {
        if (session.getAttribute("supplier") == null)
            throw new BadRequestException("invalidSession");
        messageRepo.save(new Message(message, customerRepo.findById(customerId).get(0), (Supplier) session.getAttribute
                ("supplier"), false));
    }

    @RequestMapping("/supplier/getMessage")
    @ResponseBody
    public List<Message> supplierGetMessage(HttpSession session) {
        if (session.getAttribute("supplier") == null)
            throw new BadRequestException("invalidSession");
        return messageRepo.findBySupplierOrderByTimeDesc((Supplier) session.getAttribute("supplier"));
    }

    @RequestMapping("/supplier/markMessageRead")
    void supplierMarkMessageRead(@RequestParam long id, HttpSession session) {
        if (session.getAttribute("supplier") == null)
            throw new BadRequestException("invalidSession");
        List<Message> result = messageRepo.findByIdAndSupplier(id, (Supplier) session.getAttribute("supplier"));
        if (result.size() > 0) {
            result.get(0).setHasRead(true);
        }
    }


    void addProduct(){}
    void removeProduct(){}

}


