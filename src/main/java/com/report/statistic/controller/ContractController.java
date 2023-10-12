package com.report.statistic.controller;

import com.report.statistic.model.Contract;
import com.report.statistic.service.ContractServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/contract")
public class ContractController {
   private final ContractServiceImpl contractService;
    @PostMapping
    public int addContract(){
      //  contractService.addContract();
        return 1;
    }
    @GetMapping
    public int getContract(){
        contractService.getContract();
        return 1;
    }
}
