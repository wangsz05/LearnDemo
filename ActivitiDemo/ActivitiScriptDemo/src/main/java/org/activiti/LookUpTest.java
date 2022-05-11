package org.activiti;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class LookUpTest {

    public void setLookUpTest(String lookUpTest) throws NamingException {
        InitialContext initialContext = new InitialContext();
        initialContext.lookup(lookUpTest);
    }
}
