package com.report.statistic.model;


import lombok.*;
import javax.persistence.*;

import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "contract")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name = "PO")
    String PO; // ПО филиала
    @Column(name = "clientName")
    String clientName; //Наименование заявителя
    @Column(name = "nameEPU")
    String nameEPU;//Наименование энергопринимающих объектов (для объектов генерации также указывается тип генерации)
    @Column(name = "addressEPU")
    String addressEPU; //Адрес объекта
    @Column(name = "contractMethod")
    String contractMethod; // способ выполнения
    @Column(name = "contractNumber")
    String contractNumber; // номер договора
    @Column(name = "contractDate")
    LocalDate contractDate; // дата договора
    @Column(name = "voltage")
    Double voltage;// уровень напряжения, кВ
    @Column(name = "reliabilityCategory")
    Integer reliabilityCategory; // категория надежности
    @Column(name = "powerMax")
    Double powerMax; //Максимальная мощность, кВт
    @Column(name = "powerNew")
    Double powerNew; // Вновь присоединяемая мощность
    @Column(name = "contractCost")
    Double contractCost; //Стоимость договора, тыс. руб. с НДС
    @Column(name = "deadline")
    Double deadline; //Срок выполнения мероприятий по ТП (с учетом дополнительного соглашения)
    @Column(name = "nameObject")
    String nameObject;// Наименование объекта (титул)
    @Column(name = "status")
    String status; // текущая стадия
    @Column(name = "actDate")
    LocalDate actDate;// дата Акт ТП

    @Override
    public String toString() {
        return "Contract{" +
                "PO='" + PO + '\'' +
                ", clientName='" + clientName + '\'' +
                ", nameEPU='" + nameEPU + '\'' +
                ", addressEPU='" + addressEPU + '\'' +
                ", contractMethod='" + contractMethod + '\'' +
                ", contractNumber='" + contractNumber + '\'' +
                ", contractDate=" + contractDate +
                ", voltage=" + voltage +
                ", reliabilityCategory=" + reliabilityCategory +
                ", powerMax=" + powerMax +
                ", powerNew=" + powerNew +
                ", contractCost=" + contractCost +
                ", deadline=" + deadline +
                ", nameObject='" + nameObject + '\'' +
                ", status='" + status + '\'' +
                ", actDate=" + actDate +
                '}';
    }
}
