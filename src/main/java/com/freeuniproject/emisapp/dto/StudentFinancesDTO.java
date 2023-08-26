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

    private double tuitionFeePaid;

    private double scholarship;


}
