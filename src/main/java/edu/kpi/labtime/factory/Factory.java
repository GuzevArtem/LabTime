package edu.kpi.labtime.factory;

import org.hibernate.SessionFactory;
import javax.persistence.Persistence;

public class Factory {
    private final static Factory INSTANCE = new Factory();

    final private SessionFactory sessionFactory;

    public Factory(){
        sessionFactory = (SessionFactory) Persistence.createEntityManagerFactory( "org.hibernate.tutorial.jpa" );
    }

    public static Factory getInstance(){
        return INSTANCE;
    }


}
