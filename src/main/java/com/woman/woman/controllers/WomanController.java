package com.woman.woman.controllers;

import com.woman.woman.dao.WomanDao;
import com.woman.woman.models.Woman;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class WomanController {

    @Autowired
    private WomanDao womanDao;

    @CrossOrigin
    @RequestMapping(value = "api/womans", method =  RequestMethod.GET)
    public List<Woman> getWomans() {

        return womanDao.getWomans();

        // List<Woman> womans = new ArrayList<>();

//        Woman woman = new Woman();
//        woman.setId(1L);
//        woman.setTitle("Wonder woman - Age");
//        woman.setDescription("She is amazing");
//        woman.setImg("https://media.glamour.mx/photos/6190b4bdf5ed039ceea8a85e/16:9/w_1280,c_limit/164947.jpg");
//
//        Woman woman2 = new Woman();
//        woman2.setId(2L);
//        woman2.setTitle("Super Girl - Winter");
//        woman2.setDescription("She is cutty");
//        woman2.setImg("https://as01.epimg.net/meristation/imagenes/2020/09/23/noticias/1600858881_274435_1600858918_noticia_normal.jpg");
//
//        Woman woman3 = new Woman();
//        woman3.setId(3L);
//        woman3.setTitle("Cat woman - Marvel");
//        woman3.setDescription("She is wild");
//        woman3.setImg("https://i.ytimg.com/vi/NigM-ssao40/maxresdefault.jpg");
//
//        womans.add(woman);
//        womans.add(woman2);
//        womans.add(woman3);

        // return womans;
    }

    @CrossOrigin
    @RequestMapping(value = "api/womans", method =  RequestMethod.POST)
    public void createWoman(@RequestBody Woman woman) {
        womanDao.create(woman);
    }

    @CrossOrigin
    @RequestMapping(value = "api/womans/{id}", method =  RequestMethod.DELETE)
    public void deleteWoman(@PathVariable Long id) {
        womanDao.delete(id);
    }

    @CrossOrigin
    @RequestMapping(value = "api/womans/find", method =  RequestMethod.POST)
    public String findWoman(@RequestBody Woman woman) {
        if (womanDao.checkWoman(woman)) {
            return "OK";
        }
        return "FAIL";
    }
}