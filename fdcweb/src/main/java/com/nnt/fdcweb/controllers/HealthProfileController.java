package com.nnt.fdcweb.controllers;

import com.nnt.fdcweb.model.HealthProfile;
import com.nnt.fdcweb.model.Patient;
import com.nnt.fdcweb.services.HealthProfileService;
import com.nnt.fdcweb.services.HospitalService;
import com.nnt.fdcweb.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HealthProfileController {

    @Autowired
    private HospitalService hospitalService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private HealthProfileService healthProfileService;

    @RequestMapping(value = "/patient/{patientId}/create-health-profile", method = RequestMethod.GET)
    public String showCreateHealthProfile(@PathVariable(value = "patientId") Integer patientId, Model model) {
        Patient patient = this.patientService.findById(patientId);
        model.addAttribute("patient", patient);
        model.addAttribute("healthProfile", new HealthProfile());
        model.addAttribute("hospitalList", this.hospitalService.findAll());
        model.addAttribute("action", "/patient/" + patientId + "/create-health-profile");
        return "health-profile-form";
    }

    @RequestMapping(value = "/patient/{patientId}/create-health-profile", method = RequestMethod.POST)
    public String createHealthProfile(@ModelAttribute(value = "healthProfile") HealthProfile healthProfile,
            @PathVariable(value = "patientId") Integer patientId) {
        healthProfile.setPatient(this.patientService.findById(patientId));
        this.healthProfileService.insertOrUpdate(healthProfile);
        return "redirect:/patient/" + patientId;
    }
}
