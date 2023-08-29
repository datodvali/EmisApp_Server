package com.freeuniproject.emisapp.dto;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class StudentFinancesDTO {

    private Long id;

    private Long studentId;

    private double tuitionFee;

    private double scholarship;

    private double effectiveFee;

    private double tuitionFeePaid;

    private double debt;


}
