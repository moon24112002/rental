package com.rental.user.entity;

import com.rental.config.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user_details")
public class UserDetails extends BaseEntity {

    private String phone;

    @Lob
    private byte[] licenseImage;

    private String approvalStatus;

}