package bs.springframework.petclinic.controllers;

import bs.springframework.petclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"/owners","/owners/index","/owners/index.html"})
    //Spring automatically injects Model when it calls this method
    public String listOwners(Model model){
        // "owners" is the name of the property/attribute inside of the model
        model.addAttribute("owners", ownerService.findAll());

        //Returns the owners index page
        return "owners/index";
    }

    @RequestMapping("/find")
    public String findOwners(){
        return "Not Implemented";
    }

}
