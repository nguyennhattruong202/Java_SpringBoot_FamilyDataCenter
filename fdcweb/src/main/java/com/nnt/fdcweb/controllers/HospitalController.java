package com.nnt.fdcweb.controllers;

import com.nnt.fdcweb.model.Hospital;
import com.nnt.fdcweb.services.HospitalService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

    @RequestMapping(value = "/hospital-list", method = RequestMethod.GET)
    public String hospitalList(Model model) {
        model.addAttribute("hospitalList", (List<Hospital>) this.hospitalService.findAll());
        return "hospital-list";
    }

    @RequestMapping(value = "/hospital/add", method = RequestMethod.GET)
    public String showHospitalForm(Model model) {
        model.addAttribute("hospital", new Hospital());
        model.addAttribute("actionForm", "/hospital/add");
        model.addAttribute("submitButton", "Submit");
        return "hospital-form";
    }

    @RequestMapping(value = "/hospital/add", method = RequestMethod.POST)
    public String addHospital(@ModelAttribute(value = "hospital") Hospital hospital) {
        try {
            this.hospitalService.insertOrUpdate(hospital);
        } catch (Exception e) {
            System.out.println("An exception occurred during insert into hospital: " + e.getMessage());
        }
        return "redirect:/hospital-list";
    }
}
