package com.report.statistic.service;

import com.report.statistic.model.Contract;
import com.report.statistic.repository.ContractRepository;
import lombok.RequiredArgsConstructor;
import org.dhatim.fastexcel.reader.ExcelReaderException;
import org.dhatim.fastexcel.reader.ReadableWorkbook;
import org.dhatim.fastexcel.reader.Row;
import org.dhatim.fastexcel.reader.Sheet;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class ContractServiceImpl {
    private final ContractRepository contractRepository;

    public void addContract() {
//        Contract contract = Contract.builder()
//                .PO("PO")
//                .clientName("clientName")
//                .nameEPU("nameEPU")
//                .addressEPU("addressEPU")
//                .contractMethod("contractMethod")
//                .contractNumber("contractNumber")
//                .contractDate(LocalDate.now())
//                .voltage(0.4)
//                .reliabilityCategory(11)
//                .powerMax(0.1)
//                .powerNew(0.5)
//                .contractCost(0.5)
//                .deadline(0.5)
//                .nameObject("nameObject")
//                .status("status")
//                .actDate(LocalDate.now())
//                .build();
        //    contractRepository.save(contract);

        String fileLocation = "src/main/resources/application_4.xlsx";
        try (FileInputStream file = new FileInputStream(fileLocation); ReadableWorkbook wb = new ReadableWorkbook(file)) {
            Sheet sheet = wb.getFirstSheet();
            try (Stream<Row> rows = sheet.openStream()) {
                rows.forEach(r -> {
                    String PO = r.getCellText(1);
                    String clientName = r.getCellText(3);
                    String nameEPU = r.getCellText(6);
                    String addressEPU = r.getCellText(8);
                    String contractMethod = r.getCellText(14);
                    String contractNumber = r.getCellText(15);
                    LocalDate contractDate = r.getCellAsDate(16).isPresent()
                            ? LocalDate.from(r.getCellAsDate(16).get())
                            : null;
                    Double voltage;
                    try {
                        voltage = r.getCellText(17).isEmpty() ? null
                                : Double.parseDouble(r.getCellText(17).replaceAll("\\s+", ""));
                    } catch (NumberFormatException e) {
                        voltage = null;
                    }

                    Integer reliabilityCategory;
                    try {
                        reliabilityCategory = r.getCellText(18).isEmpty() ? null
                                : Integer.parseInt(r.getCellText(18));
                    } catch (NumberFormatException e) {
                        reliabilityCategory = null;
                    }


                    Double powerMax = r.getCellText(25).isEmpty() ? null
                            : Double.parseDouble(r.getCellText(25));

                    Double powerNew = Double.parseDouble(r.getCellText(26));
                    Double contractCost;
                    try {
                        contractCost = Double.parseDouble(r.getCellText(33));
                    } catch (NumberFormatException e) {
                        contractCost = null;
                    }
                    Double deadline = Double.parseDouble(r.getCellText(41));
                    String nameObject = r.getCellText(48);
                    String status = r.getCellText(157);
                    LocalDate actDate;
                    try {
                        actDate = r.getCellAsDate(170).isPresent()
                                ? LocalDate.from(r.getCellAsDate(170).get())
                                : null;
                    } catch (ExcelReaderException e) {
                        actDate = LocalDate.ofEpochDay(1900 - 1 - 1);
                    }
                    Contract contract = Contract.builder()
                            .PO(PO)
                            .clientName(clientName)
                            .nameEPU(nameEPU)
                            .addressEPU(addressEPU)
                            .contractMethod(contractMethod)
                            .contractNumber(contractNumber)
                            .contractDate(contractDate)
                            .voltage(voltage)
                            .reliabilityCategory(reliabilityCategory)
                            .powerMax(powerMax)
                            .powerNew(powerNew)
                            .contractCost(contractCost)
                            .deadline(deadline)
                            .nameObject(null) //исправить
                            .status(status)
                            .actDate(null) // исправить
                            .build();
                    contractRepository.save(contract);
                });
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public void getContract() {
        System.out.println(contractRepository.findAll());
    }

}
