package testes;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.persistence.EntityManager;

import model.Actor;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.threads.JMeterContextService;
import org.apache.jmeter.threads.JMeterVariables;
import org.eclipse.persistence.sessions.Session;
import org.eclipse.persistence.sessions.factories.SessionFactory;

import persistencia.GerenciadorPersistencia;
import dao.GenericDAO;

public class JMeterTestJPA extends AbstractJavaSamplerClient {

   // private Map<String, String> mapParams = new HashMap<String, String>();
    //private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
   /*
    @Override
    public void setupTest(JavaSamplerContext context) {
        for (Iterator<String> it = context.getParameterNamesIterator(); it.hasNext();) {
            String paramName =  it.next();
            mapParams.put(paramName, context.getParameter(paramName));
        }
    }*/
	private EntityManager em = GerenciadorPersistencia.getEntityManager();
	
    public SampleResult runTest(JavaSamplerContext context) {
        SampleResult result = new SampleResult();

        try {

            JMeterVariables vars = JMeterContextService.getContext().getVariables();
            vars.put("demo", "demoVariableContent");

            result.sampleStart();
/*
            Student student = new Student();
            student.setStudentname(mapParams.get("name")+" "+new Date().getTime());
            Session session = sessionFactory.openSession();
            session.save(student);
            session.flush();
            session.close();*/
            Actor a = new Actor("John"+new Timestamp(System.currentTimeMillis()),
            		"Snow"+" "+new Timestamp(System.currentTimeMillis()));
            em.getTransaction().begin();
            em.persist(a);
            //System.out.println(classe.toString()+"--> salvo com sucesso!");
            //efetua a Transação
            em.getTransaction().commit();
        	//GenericDAO.gravaBD(a);

            result.sampleEnd();

            
            result.setSuccessful(true);
            result.setSampleLabel("SUCCESS: " + a.getFirstName());

        } catch (Throwable e) {
            result.sampleEnd();
            result.setSampleLabel("FAILED: '" + e.getMessage() + "' || " + e.toString());
            result.setSuccessful(false);

            e.printStackTrace();
            System.out.println("\n\n\n");
        }

        return result;
    }
/*
    @Override
    public Arguments getDefaultParameters() {

        Arguments params = new Arguments();

        params.addArgument("name", "edw");

        return params;
    }*/

}
