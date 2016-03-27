package com.taxcalc.dto;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by KART on 14.03.2016.
 */
@Entity
@Table(name = "tax")
public class Tax {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "date_time")
    private Date dateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }
}
