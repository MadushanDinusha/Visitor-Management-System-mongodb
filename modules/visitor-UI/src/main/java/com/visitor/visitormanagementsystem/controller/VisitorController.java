package com.visitor.visitormanagementsystem.controller;

import com.visitor.domain.Visitor;
import com.visitor.visitormanagementsystem.service.VisitorService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping(value = "/")
public class VisitorController {

    private static final Logger LOGGER = LogManager.getLogger(VisitorController.class);

    @Autowired
    private VisitorService visitorService;

    @GetMapping("/")
    public String getIndex(){
        return "index";
    }

    @RequestMapping(value = "/createVisitor", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> createVisitor(@RequestBody Visitor visitor) {
        try {
            LOGGER.info("sending visitor to process {}",visitor);
            visitorService.processVisitorSave(visitor);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Campaign creation failed", HttpStatus.BAD_REQUEST);
        }
    }
}
