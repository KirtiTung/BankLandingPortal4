package com.kirti.portal.config;

import java.io.Serializable;
import java.util.Properties;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.SequenceGenerator;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.internal.util.config.ConfigurationHelper;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.LongType;
import org.hibernate.type.Type;

import com.kirti.portal.entities.CustomerMasters;
import com.kirti.portal.entities.LoanAppDetailMasters;
import com.kirti.portal.entities.LoanApplications;

public class StringPrefixedSequenceIdGenerator extends SequenceStyleGenerator 
    implements Configurable {

    public static final String VALUE_PREFIX_PARAMETER = "valuePrefix";
    public static final String VALUE_PREFIX_DEFAULT = "";
    private String valuePrefix;

    public static final String NUMBER_FORMAT_PARAMETER = "numberFormat";
    public static final String NUMBER_FORMAT_DEFAULT = "%d";
    private String numberFormat;
    
    private String lastName="";
    

    @Override
    public Serializable generate(
            SharedSessionContractImplementor session, Object object) 
            throws HibernateException {
    	String lastName="";
    	if(object instanceof CustomerMasters)
    	 lastName = ((CustomerMasters) object).getCust_Last_Name();
    	if(object instanceof LoanApplications)
    		lastName=((LoanApplications) object).getType_Of_Loan();
    	
        return valuePrefix+lastName.substring(0, 2).toUpperCase() + String.format(numberFormat, 
            super.generate(session, object));
    }

    @Override
    public void configure(
            Type type, Properties params, ServiceRegistry serviceRegistry) 
            throws MappingException {
    	
        super.configure(LongType.INSTANCE, params, serviceRegistry);
        valuePrefix = ConfigurationHelper.getString(
            VALUE_PREFIX_PARAMETER, params, VALUE_PREFIX_DEFAULT);
        numberFormat = ConfigurationHelper.getString(
            NUMBER_FORMAT_PARAMETER, params, NUMBER_FORMAT_DEFAULT);
    }
}