package fr.kissy.gcm.rest.server.application;

import fr.kissy.gcm.rest.server.config.ApplicationConfig;
import fr.kissy.module.rest.application.AbstractJavaApplicationInitializer;

/**
 * @author Guillaume Le Biller (<i>lebiller@ekino.com</i>)
 * @version $Id$
 */
public class JavaApplicationInitializer extends AbstractJavaApplicationInitializer {
    @Override
    protected Class getJavaConfiguration() {
        return ApplicationConfig.class;
    }
}
