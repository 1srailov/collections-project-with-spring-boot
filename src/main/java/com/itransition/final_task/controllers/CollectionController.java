package com.itransition.final_task.controllers;


import com.itransition.final_task.dto.request.CollectionRequest;
import com.itransition.final_task.dto.request.CollectionColumnsRequest;
import com.itransition.final_task.dto.response.MessageResponse;
import com.itransition.final_task.services.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/collection")
public class CollectionController{

    @Autowired
    private CollectionService collectionService;


    @PostMapping()
    public ResponseEntity<?> addCollection(@ModelAttribute CollectionRequest collectionRequest, HttpServletRequest request){
       return collectionService.createCollection(collectionRequest, request.getHeader("Authorization").substring(7));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCollection(@PathVariable Long id, HttpServletRequest request){
        return collectionService.deleteCollection(id, request.getHeader("Authorization").substring(7));
    }

    @GetMapping("/get-all/{page}")
    public ResponseEntity<?> getAllByPagination(@PathVariable Integer page){
        return collectionService.getAllByPage(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return collectionService.getById(id);
    }

    @GetMapping("/get-top")
    public ResponseEntity<?> getTopCollections(){
        return collectionService.getTop5Collections();
    }


}
