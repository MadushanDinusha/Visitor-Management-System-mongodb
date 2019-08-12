package com.visitor.visitormanagementsystem.controller;

import com.visitor.domain.Visitor;
import com.visitor.visitormanagementsystem.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/")
public class VisitorController {

    @Autowired
    private VisitorService visitorService;

    @GetMapping("/")
    public String getIndex(){
        return "index";
    }

    @RequestMapping(value = "/createVisitor", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> createCampaign(@RequestBody Visitor visitor) {
        try {
            visitorService.save(visitor);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Campaign creation failed", HttpStatus.BAD_REQUEST);
        }
    }
}
