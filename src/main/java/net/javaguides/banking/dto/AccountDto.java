package net.javaguides.banking.dto;

import lombok.*;

@Data
@AllArgsConstructor
public class AccountDto {

    private Long id;
    private String accountHolderName;
    private Double balance;
}
