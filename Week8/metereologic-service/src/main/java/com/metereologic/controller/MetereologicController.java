package com.metereologic.controller;

import com.metereologic.persistence.models.Location;
import com.metereologic.persistence.models.MetereologicalData;
import com.metereologic.service.logicBusiness.LocationService;
import com.metereologic.service.logicBusiness.MetereologicalDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class MetereologicController
{
    @Autowired
    private MetereologicalDataService metereologicalDataService;

    @Autowired
    private LocationService locationService;

    @GetMapping("/locationIndex")
    public String show(Model model)
    {
        model.addAttribute("locations", this.locationService.listAll());
        return "locationIndex";
    }

    @GetMapping("/location/create")
    public String showNewLocationForm(Model model)
    {
        model.addAttribute("location", new Location());
        return "create_location";
    }

    @PostMapping("/location/create")
    public String createNewLocation(@Validated @ModelAttribute("location") Location location, BindingResult bindingResult,
                                    RedirectAttributes redirectAttributes, Model model)
    {
        if(bindingResult.hasErrors())
        {
            model.addAttribute("location", location);
            return "create_location";
        }

        this.locationService.save(location);
        redirectAttributes.addFlashAttribute("msg", "Location has been added succesfully");
        return "redirect:/locationIndex";
    }
}
