package org.talend.designer.codegen.translators.technical;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;

public class TJobStructureCatcherBeginJava
{
  protected static String nl;
  public static synchronized TJobStructureCatcherBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TJobStructureCatcherBeginJava result = new TJobStructureCatcherBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tfor (JobStructureCatcherUtils.JobStructureCatcherMessage jcm : ";
  protected final String TEXT_3 = ".getMessages()) {" + NL + "\t\torg.talend.logging.audit.Context log_context_";
  protected final String TEXT_4 = " = null;" + NL + "\t\tif(jcm.component_name == null) {//job level log" + NL + "\t\t\tif(jcm.status == null) {//job start" + NL + "\t\t\t\tlog_context_";
  protected final String TEXT_5 = " = org.talend.job.audit.JobContextBuilder.create().jobName(jcm.job_name).jobId(jcm.job_id).jobVersion(jcm.job_version).timestamp(jcm.moment).build();" + NL + "\t\t\t\tauditLogger_";
  protected final String TEXT_6 = ".jobstart(log_context_";
  protected final String TEXT_7 = ");" + NL + "\t\t\t} else {//job end" + NL + "\t\t\t\tlong timeMS = jcm.end_time - jcm.start_time;" + NL + "\t\t\t\tString duration = String.format(java.util.Locale.US, \"%1$.2fs\", (timeMS * 1.0)/1000);" + NL + "\t\t\t" + NL + "\t\t\t\tlog_context_";
  protected final String TEXT_8 = " = org.talend.job.audit.JobContextBuilder.create().jobName(jcm.job_name).jobId(jcm.job_id).jobVersion(jcm.job_version)" + NL + "\t\t\t\t\t.timestamp(jcm.moment).duration(duration).status(jcm.status).build();" + NL + "\t\t\t\tauditLogger_";
  protected final String TEXT_9 = ".jobstop(log_context_";
  protected final String TEXT_10 = ");" + NL + "\t\t\t}" + NL + "\t\t} else if(jcm.current_connector == null) {//component log" + NL + "\t\t\tlog_context_";
  protected final String TEXT_11 = " = org.talend.job.audit.JobContextBuilder.create().jobName(jcm.job_name).jobId(jcm.job_id).jobVersion(jcm.job_version)" + NL + "\t\t\t\t.connectorType(jcm.component_name).connectorId(jcm.component_id).build();" + NL + "\t\t\tauditLogger_";
  protected final String TEXT_12 = ".runcomponent(log_context_";
  protected final String TEXT_13 = ");" + NL + "\t\t} else {//component connector meter log" + NL + "\t\t\tlong timeMS = jcm.end_time - jcm.start_time;" + NL + "\t\t\tString duration = String.format(java.util.Locale.US, \"%1$.2fs\", (timeMS * 1.0)/1000);" + NL + "\t\t\t" + NL + "\t\t\tif(jcm.current_connector_as_input) {//log current component input line" + NL + "\t\t\t\tlog_context_";
  protected final String TEXT_14 = " = org.talend.job.audit.JobContextBuilder.create().jobName(jcm.job_name).jobId(jcm.job_id).jobVersion(jcm.job_version)" + NL + "\t\t\t\t\t.connectorType(jcm.component_name).connectorId(jcm.component_id)" + NL + "\t\t\t\t\t.connectionName(jcm.current_connector).connectionType(jcm.current_connector_type)" + NL + "\t\t\t\t\t.rows(jcm.total_row_number).duration(duration).build();" + NL + "\t\t\t\tauditLogger_";
  protected final String TEXT_15 = ".flowInput(log_context_";
  protected final String TEXT_16 = ");" + NL + "\t\t\t} else {//log current component output/reject line" + NL + "\t\t\t\tlog_context_";
  protected final String TEXT_17 = ".flowOutput(log_context_";
  protected final String TEXT_18 = ");" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_19 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();


    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(TEXT_19);
    return stringBuffer.toString();
  }
}
