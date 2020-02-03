package org.talend.designer.codegen.translators.common;

import java.util.Vector;
import java.util.Map;
import java.util.List;
import java.util.Collection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.IProcess;

public class Header_additionalJava
{
  protected static String nl;
  public static synchronized Header_additionalJava create(String lineSeparator)
  {
    nl = lineSeparator;
    Header_additionalJava result = new Header_additionalJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "\t/**" + NL + "\t * Access bean implemented as inner class in order to avoid incompatible" + NL + "\t * changes of existing interfaces and central code generation modules." + NL + "\t */" + NL + "\tpublic final TalendESBJobBean esbJobBean = new TalendESBJobBean() {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * Initialize a job for multiple exchange processing" + NL + "\t\t * in a route." + NL + "\t\t *" + NL + "\t\t * @param exchange the route message exchange" + NL + "\t\t */" + NL + "\t\tpublic void prepareJob(String[] contextArgs) {" + NL + "\t\t\tinitializeJobForRoute(contextArgs);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * Cleanup of resources from a job for multiple" + NL + "\t\t * message exchange processing." + NL + "\t\t */" + NL + "\t\tpublic void discardJob() {" + NL + "\t\t\tdestroyJobForRoute();" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * Run as a single-use job" + NL + "\t\t *" + NL + "\t\t * @param exchangeData the data map containing the route message exchange" + NL + "\t\t * @param contextArgs arguments passed in the context" + NL + "\t\t */" + NL + "\t\tpublic void runSingleUseJob(java.util.Map<String, Object> exchangeData, String[] contextArgs) {" + NL + "\t\t\tsingleUseRouterExchange = (org.apache.camel.Exchange) exchangeData.get(\"exchange\");" + NL + "\t\t\tint success = runJobInTOS(contextArgs);" + NL + "\t\t\tif (success != 0) {" + NL + "\t\t\t\tthrow new RuntimeException(\"Job execution failure - details see stderr. \");" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * Run as prepared multi-use job" + NL + "\t\t *" + NL + "\t\t * @param exchangeData the data map containing the route message exchange" + NL + "\t\t * @param contextArgs arguments passed in the context" + NL + "\t\t */" + NL + "\t\tpublic void runPreparedJob(java.util.Map<String, Object> exchangeData, String[] contextArgs) {" + NL + "\t\t\tevaluateContextArgs(contextArgs);" + NL + "\t\t\torg.apache.camel.Exchange exchange = (org.apache.camel.Exchange) exchangeData.get(\"exchange\");" + NL + "\t\t\tprocess(exchange);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * Get the class of the underlying job" + NL + "\t\t *" + NL + "\t\t * @return the job class" + NL + "\t\t */" + NL + "\t\tpublic Class<?> getJobClass() {" + NL + "\t\t\treturn jobClass();" + NL + "\t\t}" + NL + "" + NL + "\t\tprivate void evaluateContextArgs(String[] contextArgs) {" + NL + "\t\t\tif (contextArgs == null) {" + NL + "\t\t\t\treturn;" + NL + "\t\t\t}" + NL + "\t\t\tString lastStr = \"\";" + NL + "\t\t\tfor (String arg : contextArgs) {" + NL + "\t\t\t\tif (arg.equalsIgnoreCase(\"--context_param\")) {" + NL + "\t\t\t\t\tlastStr = arg;" + NL + "\t\t\t\t} else if (lastStr.equals(\"\")) {" + NL + "\t\t\t\t\tevalParam(arg);" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tevalParam(lastStr + \" \" + arg);" + NL + "\t\t\t\t\tlastStr = \"\";" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t};" + NL + "" + NL + "\tprivate final JobLifecycleSemaphore lifeCycleMonitor = new JobLifecycleSemaphore();" + NL + "\tprivate org.apache.camel.Exchange singleUseRouterExchange = null;" + NL + "\tprivate boolean initialize = false;" + NL + "\tprivate static final String ROUTER_EXCHANGE = \"ROUTER_EXCHANGE\";" + NL + "" + NL + "\tpublic void process(org.apache.camel.Exchange routerExchange) {" + NL + "\t\tfinal java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>(this.globalMap);" + NL + "" + NL + "\t\ttry {" + NL + "\t\t\tglobalMap.put(ROUTER_EXCHANGE, routerExchange);" + NL + "" + NL + "\t\t\t// pass DataSource" + NL + "\t\t\tjava.util.Map<String, routines.system.TalendDataSource> talendDataSources =" + NL + "\t\t\t\t(java.util.Map<String, routines.system.TalendDataSource>) this.globalMap.get(KEY_DB_DATASOURCES);" + NL + "\t\t\tif (null != talendDataSources) {" + NL + "\t\t\t\tjava.util.Map<String, routines.system.TalendDataSource> restDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();" + NL + "\t\t\t\tfor (java.util.Map.Entry<String, routines.system.TalendDataSource> talendDataSourceEntry : talendDataSources.entrySet()) {" + NL + "\t\t\t\t\trestDataSources.put(talendDataSourceEntry.getKey(), new routines.system.TalendDataSource(talendDataSourceEntry.getValue().getRawDataSource()));" + NL + "\t\t\t\t}" + NL + "\t\t\t\tglobalMap.put(KEY_DB_DATASOURCES, restDataSources);" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tthis.";
  protected final String TEXT_2 = "_LoopProcess(globalMap);" + NL + "" + NL + "\t\t} catch (TalendException e) {" + NL + "\t\t\tException ex = e;" + NL + "\t\t\twhile ( ex instanceof TalendException ) {" + NL + "\t\t\t\tex = ((TalendException) ex).getException();" + NL + "\t\t\t\tex.printStackTrace(System.out);" + NL + "\t\t\t\torg.apache.log4j.Logger.getRootLogger().error(ex);" + NL + "\t\t\t}" + NL + "\t\t\tthrow new RuntimeException(ex);" + NL + "\t\t\t" + NL + "\t\t} finally {" + NL + "\t\t\t// close DB connections" + NL + "\t\t\ttry {" + NL + "\t\t\t\tjava.util.Map<String, routines.system.TalendDataSource> routeDataSources =" + NL + "\t\t\t\t\t(java.util.Map<String, routines.system.TalendDataSource>) globalMap.get(KEY_DB_DATASOURCES);" + NL + "\t\t\t\tif (null != routeDataSources) {" + NL + "\t\t\t\t\tfor (routines.system.TalendDataSource routeDataSource : routeDataSources.values()) {" + NL + "\t\t\t\t\t\trouteDataSource.close();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t} catch (Throwable e) {" + NL + "\t\t\t\te.printStackTrace(System.err);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Initialize the job and wait for execution" + NL + "\t * " + NL + "\t * @param contextArgs" + NL + "\t */" + NL + "\tpublic void initializeJobForRoute(final String[] contextArgs) {" + NL + "\t\tthis.execStat = false;" + NL + "\t\tthis.initialize = true;" + NL + "" + NL + "\t\tsynchronized (lifeCycleMonitor) {" + NL + "\t\t\tnew Thread(" + NL + "\t\t\t\tnew Runnable() {" + NL + "\t\t\t\t\tpublic void run() {" + NL + "\t\t\t\t\t\trunJobInTOS(contextArgs);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t).start();" + NL + "" + NL + "\t\t\ttry {" + NL + "\t\t\t\tlifeCycleMonitor.waitForUpState();" + NL + "\t\t\t} catch (InterruptedException e) {" + NL + "\t\t\t\torg.apache.log4j.Logger.getRootLogger().error(\"Lifecycle Monitor Exception\", e);" + NL + "\t\t\t\tthrow new RuntimeException(e);" + NL + "\t\t\t}" + NL + "\t\t} // end synchronized" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Wait for bean shutdown to resume and " + NL + "\t * execute the shutdown portion of runJobInTOS()" + NL + "\t */" + NL + "\tprivate void holdReadyState() {" + NL + "\t\t" + NL + "\t\tinitialize = false;" + NL + "\t\t" + NL + "\t\tsynchronized (lifeCycleMonitor) {" + NL + "\t\t\tlifeCycleMonitor.signalUpState();" + NL + "\t\t\ttry {" + NL + "\t\t\t\tlifeCycleMonitor.waitForDownState();" + NL + "\t\t\t} catch (InterruptedException e) {" + NL + "\t\t\t\torg.apache.log4j.Logger.getRootLogger().error(\"Lifecycle Monitor Exception\", e);" + NL + "\t\t\t\tthrow new RuntimeException(e);" + NL + "\t\t\t}" + NL + "\t\t} // end synchronized" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Bean Destructor" + NL + "\t * " + NL + "\t * Notifies the waiting thread to wrap up the job" + NL + "\t */" + NL + "\tpublic void destroyJobForRoute() {" + NL + "\t\tsynchronized (lifeCycleMonitor) {" + NL + "\t\t\tlifeCycleMonitor.signalDownState();" + NL + "\t\t} // end synchronized" + NL + "\t}" + NL + "" + NL + "\tprivate Class<?> jobClass() {" + NL + "\t\treturn getClass();" + NL + "\t}" + NL;
  protected final String TEXT_3 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
Vector v = (Vector) codeGenArgument.getArgument();
IProcess process = (IProcess) v.get(0);

boolean jobHasRouteInputComponent = !process.getNodesOfType("tRouteInput").isEmpty();
boolean jobHasRouteOutputComponent = !process.getNodesOfType("tRouteOutput").isEmpty();
boolean jobHasRouteFaultComponent = !process.getNodesOfType("tRouteFault").isEmpty();

if (jobHasRouteInputComponent || jobHasRouteOutputComponent || jobHasRouteFaultComponent) {

List<? extends INode> routeInputComponentsList = process.getNodesOfType("tRouteInput");
INode node = routeInputComponentsList.get(0);
String cid = node.getUniqueName();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    
}

    stringBuffer.append(TEXT_3);
    return stringBuffer.toString();
  }
}
