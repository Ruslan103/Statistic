package com.report.statistic.service;

import com.report.statistic.model.Contract;
import com.report.statistic.repository.ContractRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ContractServiceImpl {
    private final ContractRepository contractRepository;

    public void addContract() {
        Contract contract = Contract.builder()
                .PO("PO")
                .clientName("clientName")
                .nameEPU("nameEPU")
                .addressEPU("addressEPU")
                .contractMethod("contractMethod")
                .contractNumber("contractNumber")
                .contractDate(LocalDate.now())
                .voltage(0.4)
                .reliabilityCategory(11)
                .powerMax(0.1)
                .powerNew(0.5)
                .contractCost(0.5)
                .deadline(0.5)
                .nameObject("nameObject")
                .status("status")
                .actDate(LocalDate.now())
                .build();
        contractRepository.save(contract);
    }

    public void getContract() {
        System.out.println(contractRepository.findAll());
    }

}
