package com.nnt.fdcweb.controllers.admin;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PatientController {

//    @Autowired
//    private PatientService patientService;

//    @RequestMapping(value = "/admin/patients", method = RequestMethod.GET)
//    public String patientList(Model model) {
//        model.addAttribute("patients", (List<Patient>) this.patientService.findAll());
//        return "admin/patients";
//    }

//    @RequestMapping(value = "/admin/patient/save", method = RequestMethod.GET)
//    public String showPatientForm(Model model) {
//        model.addAttribute("patient", new Patient());
//        model.addAttribute("action", "/admin/patient/save");
//        return "admin/patient-form";
//    }

//    @RequestMapping(value = "/admin/patient/save", method = RequestMethod.POST)
//    public String savePatient(@ModelAttribute(value = "patient") Patient patient, RedirectAttributes ra) {
//        try {
//            this.patientService.insert(patient);
//            ra.addFlashAttribute("result", true);
//            ra.addFlashAttribute("message", "Thêm thông tin thành công");
//        } catch (Exception e) {
//            ra.addFlashAttribute("result", false);
//            ra.addFlashAttribute("message", "Thêm thông tin thất bại");
//            System.out.println("An exception occurred during insert: " + e.getMessage());
//        }
//        return "redirect:/admin/patients";
//    }

//    @RequestMapping(value = "/admin/patient/{patientId}", method = RequestMethod.GET)
//    public String showPatientInformation(Model model, @PathVariable(value = "patientId") Integer patientId, RedirectAttributes ra) {
//        try {
//            Patient patient = this.patientService.findById(patientId);
//            model.addAttribute("patient", patient);
//            model.addAttribute("action", "/admin/patient/" + patient.getPatientId());
//            return "admin/patient-form";
//        } catch (Exception e) {
//            ra.addFlashAttribute("result", false);
//            ra.addFlashAttribute("message", "Có lỗi xảy ra");
//            System.out.println("An exception occurred during find patient by id: " + e.getMessage());
//            return "redirect:/admin/patients";
//        }
//    }

//    @RequestMapping(value = "/admin/patient/{patientId}", method = RequestMethod.POST)
//    public String updatePatient(@ModelAttribute(value = "patient") Patient patient, @PathVariable Integer patientId, RedirectAttributes ra) {
//        try {
//            Patient patientFind = this.patientService.findById(patientId);
//            patientFind.setFullname(patient.getFullname());
//            patientFind.setGender(patient.getGender());
//            patientFind.setDateOfBirth(patient.getDateOfBirth());
//            patientFind.setPhone(patient.getPhone());
//            patientFind.setEmail(patient.getEmail());
//            patientFind.setIdNumber(patient.getIdNumber());
//            patientFind.setAddress(patient.getAddress());
//            patientFind.setNote(patient.getNote());
//            this.patientService.update(patientFind);
//            ra.addFlashAttribute("result", true);
//            ra.addFlashAttribute("message", "Cập nhật thông tin thành công");
//        } catch (Exception e) {
//            ra.addFlashAttribute("result", false);
//            ra.addFlashAttribute("message", "Cập nhật thông tin thất bại");
//            System.out.println("An exception occurred during update patient: " + e.getMessage());
//        }
//        return "redirect:/admin/patients";
//    }

//    @RequestMapping(value = "/admin/patient/delete/{patientId}", method = RequestMethod.GET)
//    public String deletePatient(@PathVariable Integer patientId, RedirectAttributes ra) {
//        try {
//            this.patientService.deleteById(patientId);
//            ra.addFlashAttribute("result", true);
//            ra.addFlashAttribute("message", "Xóa thành công");
//        } catch (Exception e) {
//            ra.addFlashAttribute("result", false);
//            ra.addFlashAttribute("message", "Xóa thất bại");
//            System.out.println("An exception occurred during delete patient: " + e.getMessage());
//        }
//        return "redirect:/admin/patients";
//    }

//    @RequestMapping(value = "/admin/patient/delete-patients", method = RequestMethod.POST)
//    public String deletePatients(@RequestParam(value = "patientIds", required = false) List<Integer> patientIds, RedirectAttributes ra) {
//        if (patientIds == null || patientIds.isEmpty()) {
//            ra.addFlashAttribute("result", false);
//            ra.addFlashAttribute("message", "Xóa thất bại");
//            return "redirect:/admin/patients";
//        }
//        try {
//            this.patientService.deleteAllById(patientIds);
//            ra.addFlashAttribute("result", true);
//            ra.addFlashAttribute("message", "Xóa thành công");
//        } catch (Exception e) {
//            ra.addFlashAttribute("result", false);
//            ra.addFlashAttribute("message", "Xóa thất bại");
//            System.out.println("An exception occurred during delete patient: " + e.getMessage());
//        }
//        return "redirect:/admin/patients";
//    }
}
