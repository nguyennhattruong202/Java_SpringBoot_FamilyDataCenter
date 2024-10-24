package com.nnt.fdcweb.controllers.admin;

import com.nnt.fdcweb.model.Patient;
import com.nnt.fdcweb.services.PatientService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PatientController {

    @Autowired
    private PatientService patientService;

    @RequestMapping(value = "/admin/patients", method = RequestMethod.GET)
    public String patientList(Model model) {
        model.addAttribute("patients", (List<Patient>) this.patientService.findAll());
        return "admin/patients";
    }

    @RequestMapping(value = "/admin/patient/save", method = RequestMethod.GET)
    public String showPatientForm(Model model) {
        model.addAttribute("patient", new Patient());
        model.addAttribute("action", "/admin/patient/save");
        return "admin/patient-form";
    }
}
