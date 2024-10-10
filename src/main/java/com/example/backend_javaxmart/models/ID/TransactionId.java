package com.example.backend_javaxmart.models.ID;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionId implements Serializable {
    private String qrcode;
    private String rfid;
    private Date date;
}