package com.taxcalc.sericeImpl;

import com.taxcalc.dao.TaxDAO;
import com.taxcalc.daoImpl.TaxDAOImpl;
import com.taxcalc.dto.Tax;
import com.taxcalc.service.TaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by KART on 27.03.2016.
 */
public class TaxServiceImpl implements TaxService {

    @Autowired
    private TaxDAO taxDAO;

    @Override
    @Transactional
    public void addTax(Tax t) throws Exception{
      taxDAO.addTax(t);
    }
}
