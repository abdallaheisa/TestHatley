package com.test.demo.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;

@RestController
public class controller {
@Autowired
    SuperMarketList superMarketList;


    @GetMapping("getlist")
    public List<SuperMarket> getList(){

List<SuperMarket> SuperMarketList=superMarketList.findAll();


return  SuperMarketList;
    }
    @PostMapping(path = "psotsupermarket",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<SuperMarket> PsotLsit(@RequestBody SuperMarket superMarket,@RequestParam("img")MultipartFile file) throws IOException {

superMarket.setImage(file.getBytes());
        SuperMarket supermarket=superMarketList.save(superMarket);


        return  new ResponseEntity<>(superMarket, HttpStatus.CREATED);
    }
    @DeleteMapping("/supermarket/{id}")
    public ResponseEntity deleteSuperMarket(@PathVariable("id") int id){
        superMarketList.deleteById(id);


        return new ResponseEntity("Successfully!", HttpStatus.OK);
    }
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<SuperMarket> updatesupermarket(@RequestBody SuperMarket superMarket, @PathVariable("id") int id, @RequestParam("img")MultipartFile file) throws IOException {
        Optional<SuperMarket> listtoupdate = superMarketList.findById(id);
        if (listtoupdate.isPresent()) {
            SuperMarket SuperMarket = listtoupdate.get();
            SuperMarket.setNameArabic(superMarket.getNameArabic());
            SuperMarket.setEnglishName(superMarket.getEnglishName());
            SuperMarket.setAddress(superMarket.getAddress());
            SuperMarket.setImage(file.getBytes());
            return new ResponseEntity<>(superMarketList.save(SuperMarket), HttpStatus.OK);


        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
