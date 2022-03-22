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
    public String showLocations(Model model)
    {
        model.addAttribute("locations", this.locationService.listAll());
        return "locationIndex";
    }

    @GetMapping("/index")
    public String showMetereologicalData(Model model)
    {
        model.addAttribute("datas", this.metereologicalDataService.listAll());
        return "index";
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

    @GetMapping("/create")
    public String showCreateForm(Model model)
    {
        model.addAttribute("data", new MetereologicalData());
        model.addAttribute("locations", this.locationService.listAll());
        return "create";
    }

    @PostMapping("/create")
    public String createMetereologicalData(@Validated @ModelAttribute("data") MetereologicalData metereologicalData,
                                           BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("data", metereologicalData);
            model.addAttribute("locations", this.locationService.listAll());
            return "create";
        }
        System.out.println("The id is : "+metereologicalData.getLocId());
        metereologicalData.setLocation(this.locationService.getById(metereologicalData.getLocId()));
        //System.out.println(metereologicalData);
        this.metereologicalDataService.save(metereologicalData);
        redirectAttributes.addFlashAttribute("msg", "Metereological data added succesfully");
        return "redirect:/index";
    }

    @GetMapping("/location/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model)
    {
        model.addAttribute("location", this.locationService.getById(id));
        return "create_location";
    }

    @PostMapping("/location/edit/{id}")
    public String updateLocation(@PathVariable Integer id, @Validated @ModelAttribute("location")Location location,
                                 BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model)
    {
        Location tempLocation = this.locationService.getById(id);

        if(bindingResult.hasErrors())
        {
            model.addAttribute("location", location);
            return "create_location";
        }

        tempLocation.setLat(location.getLat());
        tempLocation.setLon(location.getLon());
        tempLocation.setCity(location.getCity());
        tempLocation.setState(location.getState());

        this.locationService.save(tempLocation);

        redirectAttributes.addFlashAttribute("msg", "Location updated successfully");
        return "redirect:/locationIndex";
    }

    @PostMapping("/location/delete/{id}")
    public String deleteLocation(@PathVariable Integer id, RedirectAttributes redirectAttributes)
    {
        this.locationService.delete(id);
        redirectAttributes.addFlashAttribute("msg", "Location has been deleted succesfully");
        return "redirect:/locationIndex";
    }
}
