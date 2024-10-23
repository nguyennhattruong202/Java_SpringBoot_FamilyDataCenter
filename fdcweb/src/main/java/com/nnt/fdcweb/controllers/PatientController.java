package com.nnt.fdcweb.controllers;

import com.nnt.fdcweb.model.HealthProfile;
import com.nnt.fdcweb.model.Patient;
import com.nnt.fdcweb.services.HealthProfileService;
import com.nnt.fdcweb.services.HospitalService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.nnt.fdcweb.services.PatientService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PatientController {

    @Autowired
    private PatientService patientService;
    @Autowired
    private HealthProfileService healthProfileService;

    @GetMapping("/patient-list")
    public String patientList(Model model) {
        model.addAttribute("patientList", (List<Patient>) this.patientService.findAll());
        return "patient-list";
    }

    @GetMapping("/patient/add")
    public String showPatientForm(Model model) {
        model.addAttribute("patient", new Patient());
        model.addAttribute("actionPatientForm", "/patient/add");
        model.addAttribute("submitPatientForm", "Submit");
        return "patient-form";
    }

    @PostMapping("/patient/add")
    public String addPatient(Patient patient) {
        try {
            this.patientService.insert(patient);
        } catch (Exception e) {
            System.out.println("An exception occurred during insert: " + e.getMessage());
        }
        return "redirect:/patient-list";
    }

    @RequestMapping(value = "/patient/{patientId}", method = RequestMethod.GET)
    public String showPatient(Model model, @PathVariable(value = "patientId") Integer patientId) {
        try {
            Patient patient = this.patientService.findById(patientId);
            model.addAttribute("patient", patient);
            model.addAttribute("healthProfileList", this.healthProfileService.findHealthProfileByPatientId(patientId));
            model.addAttribute("action", "/patient/" + patient.getPatientId());
            model.addAttribute("submitPatientForm", "Update");
            return "patient-form";
        } catch (Exception e) {
            System.out.println("An exception occurred during find patient by id: " + e.getMessage());
            return "redirect:/patient-list";
        }
    }

    @RequestMapping(value = "/patient/{patientId}", method = RequestMethod.POST)
    public String updatePatient(@ModelAttribute(value = "patient") Patient patient, @PathVariable Integer patientId) {
        try {
            Patient patientFind = this.patientService.findById(patientId);
            patientFind.setFullname(patient.getFullname());
            patientFind.setGender(patient.getGender());
            patientFind.setDateOfBirth(patient.getDateOfBirth());
            patientFind.setPhone(patient.getPhone());
            patientFind.setEmail(patient.getEmail());
            patientFind.setIdNumber(patient.getIdNumber());
            patientFind.setAddress(patient.getAddress());
            patientFind.setNote(patient.getNote());
            this.patientService.update(patientFind);
        } catch (Exception e) {
            System.out.println("An exception occurred during update patient: " + e.getMessage());
        }
        return "redirect:/patient-list";
    }
}
