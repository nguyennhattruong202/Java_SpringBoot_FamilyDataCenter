package com.nnt.fdcweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
//    
//    @Autowired
//    private WpTable1Service wpTable1Service;
    
    @GetMapping("/")
    public String showIndex() {
        return "index";
    }
    
//    @GetMapping("/delete/{id}")
//    public String delete(@PathVariable("id") Integer id, RedirectAttributes ra) {
//        try {
//            this.wpTable1Service.deleteById(id);
//            ra.addFlashAttribute("message", "Delete completed");
//        } catch (Exception e) {
//            ra.addFlashAttribute("message", "Delete failed");
//            System.out.println("An exception occurred during delete: " + e.getMessage());
//        }
//        return "redirect:/";
//    }
//    
//    @GetMapping("/save")
//    public String showInsertForm(Model model) {
//        model.addAttribute("wpTable1", new WpTable1());
//        return "formWpTable1";
//    }
//    
//    @PostMapping("/save")
//    public String insert(WpTable1 wpTable1, RedirectAttributes ra) {
//        try {
//            if (wpTable1.getDateOfBirth() == null) {
//                wpTable1.setDateOfBirth(null);
//            }
//            this.wpTable1Service.insert(wpTable1);
//            ra.addFlashAttribute("message", "Add completed");
//        } catch (Exception e) {
//            ra.addFlashAttribute("message", "Add failed");
//            System.out.println("An exception occurred during insert: " + e.getMessage());
//        }
//        return "redirect:/";
//    }
//    
//    @GetMapping("/edit/{id}")
//    public String showUpdate(@PathVariable("id") Integer id, Model model) {
//        WpTable1 wpTable1 = this.wpTable1Service.findById(id);
//        model.addAttribute("action", "/edit/" + id);
//        model.addAttribute("wpTable1", wpTable1);
//        return "updateForm";
//    }
//    
//    @PostMapping("/edit/{id}")
//    public String update(@PathVariable("id") Integer id, @ModelAttribute(value = "wpTable1") WpTable1 wpTable1,
//            RedirectAttributes ra) {
//        WpTable1 wpTable1Find = this.wpTable1Service.findById(id);
//        wpTable1Find.setFullname(wpTable1.getFullname());
//        wpTable1Find.setDateOfBirth(wpTable1.getDateOfBirth());
//        this.wpTable1Service.update(wpTable1Find);
//        ra.addFlashAttribute("message", "Update completed");
//        return "redirect:/";
//    }
}
