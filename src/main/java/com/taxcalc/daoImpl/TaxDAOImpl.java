package com.taxcalc.daoImpl;

import com.taxcalc.dao.TaxDAO;
import com.taxcalc.dto.Tax;
//import com.taxcalc.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by KART on 27.03.2016.
 */
public class TaxDAOImpl implements TaxDAO {
    @Autowired
    private SessionFactory getSessionFactory;

    @Override
    public void addTax(Tax tax) throws Exception{
        getSessionFactory.getCurrentSession().persist(tax);
    }
}
