package bs.springframework.petclinic.controllers;

import bs.springframework.petclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping("/owners/find")
    public String findOwners(){
        return "Not Implemented";
    }

    @GetMapping("/owners/{ownerId}")
    public ModelAndView showOwner(@PathVariable Long ownerId) {
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        System.out.println(ownerService.findById(ownerId).toString());

        mav.addObject(ownerService.findById(ownerId));
        return mav;
    }

}
