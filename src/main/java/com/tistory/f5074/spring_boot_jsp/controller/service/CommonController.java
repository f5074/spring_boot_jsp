package com.tistory.f5074.spring_boot_jsp.controller.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CommonController {

    @RequestMapping(value = { "/", "/index"}, method = RequestMethod.GET)
    public String index(){
        return "/index";
    }

    @RequestMapping(value = { "drawingPage", "drawing/user/drawingPage" }, method = RequestMethod.GET)
    public String drawingPage() {
        return "drawing/user/drawingPage";
    }

    @RequestMapping(value = { "iconPage", "drawing/user/iconPage" }, method = RequestMethod.GET)
    public String iconPage() {
        return "drawing/user/iconPage";
    }

    @RequestMapping(value = { "equipmentPage", "drawing/user/equipmentPage" }, method = RequestMethod.GET)
    public String equipmentPage() {
        return "drawing/user/equipmentPage";
    }

    @RequestMapping(value = { "managementPage", "drawing/user/managementPage" }, method = RequestMethod.GET)
    public String managementPage() {
        return "drawing/user/managementPage";
    }

    @RequestMapping(value = { "uploadFilePage", "drawing/user/uploadFilePage" }, method = RequestMethod.GET)
    public String uploadFilePage() {
        return "drawing/user/uploadFilePage";
    }

}
