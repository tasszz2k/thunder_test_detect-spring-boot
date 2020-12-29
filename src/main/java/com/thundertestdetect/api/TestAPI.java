package com.thundertestdetect.api;


import com.thundertestdetect.dto.RawDataDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController = @Controller + @ResponseBody
@RestController
@CrossOrigin
public class TestAPI {

//    @Autowired
//    private IThunderTestResultService ThunderTestResultService;

    //@PostMapping = @RequestMapping + method
    @PostMapping(value = "/thunder_test/{request_id}")
    public RawDataDTO createThunderTestResult(@RequestBody RawDataDTO model,
                                              @PathVariable("request_id")  String request_id) {
        model.setRequest_id(request_id);
        return model;
    }

}