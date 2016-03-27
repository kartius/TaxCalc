package com.taxcalc.dao;

import com.taxcalc.dto.Tax;

/**
 * Created by KART on 27.03.2016.
 */
public interface TaxDAO {

    void addTax(Tax tax) throws Exception;
}
