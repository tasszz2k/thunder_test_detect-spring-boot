package com.thundertestdetect.api;


import com.thundertestdetect.dto.RawDataDTO;
import com.thundertestdetect.dto.ThunderTestResultDTO;
import com.thundertestdetect.service.base.IThunerTestResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

//@RestController = @Controller + @ResponseBody
@RestController
@CrossOrigin
public class TestAPI {

   @Autowired
   private IThunerTestResultService thunerTestResultService;

   @GetMapping (value = "/thunder_test")
   public ModelAndView configThunderTest(){
       return new ModelAndView("index");
   }

    //@PostMapping = @RequestMapping + method
    @PostMapping(value = "/thunder_test/{request_id}")
    public ThunderTestResultDTO createThunderTestResult(@RequestBody RawDataDTO model,
                                                        @PathVariable("request_id")  String request_id) {
        model.setRequest_id(request_id);
        return thunerTestResultService.callApi(request_id, model);
    }

}