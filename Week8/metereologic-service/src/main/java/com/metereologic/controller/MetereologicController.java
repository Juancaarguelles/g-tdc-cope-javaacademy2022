package com.metereologic.controller;

import com.metereologic.persistence.models.MetereologicalData;
import com.metereologic.service.logicBusiness.MetereologicalDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MetereologicController
{
    @Autowired
    private MetereologicalDataService metereologicalDataService;



    @GetMapping({"/index", "/international"})
    public String showMetereologicalData(Model model)
    {
        model.addAttribute("datas", this.metereologicalDataService.listAll());
        return "index";
    }


    @GetMapping("/create")
    public String showCreateForm(Model model)
    {
        model.addAttribute("data", new MetereologicalData());
        return "create";
    }

    @PostMapping("/create")
    public String createMetereologicalData(@Validated @ModelAttribute("data") MetereologicalData metereologicalData,
                                           BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("data", metereologicalData);
            return "create";
        }
        this.metereologicalDataService.save(metereologicalData);
        redirectAttributes.addFlashAttribute("msg", "Metereological data added succesfully");
        return "redirect:/index";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(Model model, @PathVariable Integer id)
    {
        model.addAttribute("data", this.metereologicalDataService.getById(id));
        return "create";
    }

    @PostMapping("/edit/{id}")
    public String updateData(@PathVariable Integer id, @Validated @ModelAttribute MetereologicalData metereologicalData,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model)
    {
        MetereologicalData data = this.metereologicalDataService.getById(id);

        if(bindingResult.hasErrors())
        {
            model.addAttribute("data", metereologicalData);
            return "create";
        }

        data.setRegistryDate(metereologicalData.getRegistryDate());
        data.setTemperature(metereologicalData.getTemperature());
        data.setLat(metereologicalData.getLat());
        data.setLon(metereologicalData.getLon());
        data.setCity(metereologicalData.getCity());
        data.setState(metereologicalData.getState());

        this.metereologicalDataService.save(data);

        redirectAttributes.addFlashAttribute("msg", "Metereological data updated succesfully");

        return "redirect:/index";
    }

    @PostMapping("/delete/{id}")
    public String deleteData(@PathVariable Integer id)
    {
        this.metereologicalDataService.delete(id);
        return "redirect:/index";
    }

}
