//package testes;
//
//import java.sql.Timestamp;
//
//
//import model.Actor;
//
//import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
//import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
//import org.apache.jmeter.samplers.SampleResult;
//import org.apache.jmeter.threads.JMeterContextService;
//import org.apache.jmeter.threads.JMeterVariables;
//
//import dao.GenericDAO;
//
//public class JMeterTestJPA extends AbstractJavaSamplerClient {
//
//	
//
//	/**
//	 * 2) setupTest() Where you do any initialization (only once per thread)
//	 * such as reading in the parameters, creating the Hessian proxy, etc.
//	 */
//
//	/*
//	 * @Override public void setupTest(JavaSamplerContext context) { for
//	 * (Iterator<String> it = context.getParameterNamesIterator();
//	 * it.hasNext();) { String paramName = it.next(); mapParams.put(paramName,
//	 * context.getParameter(paramName)); } }
//	 */
//	
//	/**
//	 * 3) runTest()
//	 * JMeter will invoke it for each iteration of the test. 
//	 * This is where you would put code that invokes the service's methods and evaluate its result.
//	 * The method returns a "org.apache.jmeter.samplers.SampleResult" 
//	 * object which is what you use to communicate the results to JMeter. 
//	 */
//	
//	public SampleResult runTest(JavaSamplerContext context) {
//		SampleResult result = new SampleResult();
//
//		try {
//
//			JMeterVariables vars = JMeterContextService.getContext().getVariables();
//			vars.put("demo", "demoVariableContent");
//			result.setSampleLabel("TESTE Framework ORM");
//			result.setDataType(SampleResult.TEXT);
//			result.sampleStart();
//			//GenericDAO.setEm(); 
//			Actor a = new Actor("John"
//					+ new Timestamp(System.currentTimeMillis()), "Snow" + " "
//					+ new Timestamp(System.currentTimeMillis()));
//			//GenericDAO.getEm();
//			GenericDAO.save(a);
//			
//			
//			//result.setResponseCodeOK();
//			//result.setResponseMessageOK();
//			result.sampleEnd();
//
//			result.setSuccessful(true);
//			result.setSampleLabel("SUCCESS: " + a.getFirstName());
//
//		} catch (Throwable e) {
//			result.sampleEnd();
//			result.setSampleLabel("FAILED: '" + e.getMessage() + "' || "
//					+ e.toString());
//			result.setSuccessful(false);
//
//			e.printStackTrace();
//			System.out.println("\n\n\n");
//		}
//
//		return result;
//
//	}
//	/**
//	 * 1) getDefaultParameters() This method is where you set parameters that
//	 * you would like to get in JMeter Java Reqeust GUI. You do this by
//	 * instantiating a org.apache.jmeter.config.Arguments and calling its
//	 * addArgument method for each parameter.
//	 */
//
//	/*
//	 * public Arguments getDefaultParameters() { Arguments args = new
//	 * Arguments(); args.addArgument("Service URL", "");
//	 * args.addArgument("User Name", ""); args.addArgument("Password", "");
//	 * return args;
//	 * 
//	 * }
//	 */
//
//}
//
////http://henry-tech-notes.blogspot.com.br/2006/10/testing-hessian-services-with-jmeter.html
///*ext Abstract Sample{
// *  private Map<String, String> mapParams = new HashMap<String, String>();
// *  private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
// * runTest{
// * 
//		 * Student student = new Student();
//		 * student.setStudentname(mapParams.get("name")+" "+new
//		 * Date().getTime()); Session session =
//		 * sessionFactory.openSession(); session.save(student);
//		 * session.flush(); session.close();
//		 
// * }*/
