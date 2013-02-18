package de.gebit.integrity.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import de.gebit.integrity.dsl.ArbitraryParameterOrResultName;
import de.gebit.integrity.dsl.BooleanValue;
import de.gebit.integrity.dsl.Call;
import de.gebit.integrity.dsl.CallDefinition;
import de.gebit.integrity.dsl.Constant;
import de.gebit.integrity.dsl.ConstantDefinition;
import de.gebit.integrity.dsl.ConstantEntity;
import de.gebit.integrity.dsl.CustomOperation;
import de.gebit.integrity.dsl.DecimalValue;
import de.gebit.integrity.dsl.DslPackage;
import de.gebit.integrity.dsl.EnumValue;
import de.gebit.integrity.dsl.EuropeanDateAnd12HrsTimeValue;
import de.gebit.integrity.dsl.EuropeanDateAnd24HrsTimeValue;
import de.gebit.integrity.dsl.EuropeanDateValue;
import de.gebit.integrity.dsl.ExecutionMultiplier;
import de.gebit.integrity.dsl.FixedParameterName;
import de.gebit.integrity.dsl.FixedResultName;
import de.gebit.integrity.dsl.ForkDefinition;
import de.gebit.integrity.dsl.ForkParameter;
import de.gebit.integrity.dsl.Import;
import de.gebit.integrity.dsl.IntegerValue;
import de.gebit.integrity.dsl.IsoDateAndTimeValue;
import de.gebit.integrity.dsl.IsoDateValue;
import de.gebit.integrity.dsl.IsoTimeValue;
import de.gebit.integrity.dsl.JavaClassReference;
import de.gebit.integrity.dsl.KeyValuePair;
import de.gebit.integrity.dsl.MethodReference;
import de.gebit.integrity.dsl.Model;
import de.gebit.integrity.dsl.NamedCallResult;
import de.gebit.integrity.dsl.NamedResult;
import de.gebit.integrity.dsl.NestedObject;
import de.gebit.integrity.dsl.Null;
import de.gebit.integrity.dsl.OperationDefinition;
import de.gebit.integrity.dsl.PackageDefinition;
import de.gebit.integrity.dsl.Parameter;
import de.gebit.integrity.dsl.ParameterTableHeader;
import de.gebit.integrity.dsl.ParameterTableValue;
import de.gebit.integrity.dsl.ResultTableHeader;
import de.gebit.integrity.dsl.Simple12HrsTimeValue;
import de.gebit.integrity.dsl.Simple24HrsTimeValue;
import de.gebit.integrity.dsl.StandardOperation;
import de.gebit.integrity.dsl.StringValue;
import de.gebit.integrity.dsl.Suite;
import de.gebit.integrity.dsl.SuiteDefinition;
import de.gebit.integrity.dsl.SuiteParameter;
import de.gebit.integrity.dsl.TableTest;
import de.gebit.integrity.dsl.TableTestRow;
import de.gebit.integrity.dsl.Test;
import de.gebit.integrity.dsl.TestDefinition;
import de.gebit.integrity.dsl.USDateAnd12HrsTimeValue;
import de.gebit.integrity.dsl.USDateValue;
import de.gebit.integrity.dsl.ValueOrEnumValueOrOperationCollection;
import de.gebit.integrity.dsl.Variable;
import de.gebit.integrity.dsl.VariableDefinition;
import de.gebit.integrity.dsl.VariableEntity;
import de.gebit.integrity.dsl.VariableVariable;
import de.gebit.integrity.dsl.VariantDefinition;
import de.gebit.integrity.dsl.VariantValue;
import de.gebit.integrity.dsl.VisibleDivider;
import de.gebit.integrity.dsl.VisibleMultiLineNormalComment;
import de.gebit.integrity.dsl.VisibleMultiLineTitleComment;
import de.gebit.integrity.dsl.VisibleSingleLineNormalComment;
import de.gebit.integrity.dsl.VisibleSingleLineTitleComment;
import de.gebit.integrity.services.DSLGrammarAccess;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public abstract class AbstractDSLSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private DSLGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == DslPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case DslPackage.ARBITRARY_PARAMETER_OR_RESULT_NAME:
				if(context == grammarAccess.getArbitraryParameterOrResultNameRule() ||
				   context == grammarAccess.getParameterNameRule() ||
				   context == grammarAccess.getResultNameRule()) {
					sequence_ArbitraryParameterOrResultName(context, (ArbitraryParameterOrResultName) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.BOOLEAN_VALUE:
				if(context == grammarAccess.getBooleanValueRule() ||
				   context == grammarAccess.getConstantValueRule() ||
				   context == grammarAccess.getStaticValueRule() ||
				   context == grammarAccess.getValueRule() ||
				   context == grammarAccess.getValueOrEnumValueOrOperationRule()) {
					sequence_BooleanValue(context, (BooleanValue) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.CALL:
				if(context == grammarAccess.getCallRule() ||
				   context == grammarAccess.getSuiteStatementRule() ||
				   context == grammarAccess.getSuiteStatementWithResultRule()) {
					sequence_Call(context, (Call) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.CALL_DEFINITION:
				if(context == grammarAccess.getCallDefinitionRule() ||
				   context == grammarAccess.getPackageStatementRule()) {
					sequence_CallDefinition(context, (CallDefinition) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.CONSTANT:
				if(context == grammarAccess.getConstantRule() ||
				   context == grammarAccess.getConstantValueRule()) {
					sequence_Constant(context, (Constant) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.CONSTANT_DEFINITION:
				if(context == grammarAccess.getConstantDefinitionRule() ||
				   context == grammarAccess.getPackageStatementRule() ||
				   context == grammarAccess.getSuiteStatementRule()) {
					sequence_ConstantDefinition(context, (ConstantDefinition) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.CONSTANT_ENTITY:
				if(context == grammarAccess.getConstantEntityRule() ||
				   context == grammarAccess.getVariableOrConstantEntityRule()) {
					sequence_ConstantEntity(context, (ConstantEntity) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.CUSTOM_OPERATION:
				if(context == grammarAccess.getCustomOperationRule() ||
				   context == grammarAccess.getOperationRule() ||
				   context == grammarAccess.getValueOrEnumValueOrOperationRule()) {
					sequence_CustomOperation(context, (CustomOperation) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.DECIMAL_VALUE:
				if(context == grammarAccess.getConstantValueRule() ||
				   context == grammarAccess.getDecimalValueRule() ||
				   context == grammarAccess.getStaticValueRule() ||
				   context == grammarAccess.getValueRule() ||
				   context == grammarAccess.getValueOrEnumValueOrOperationRule()) {
					sequence_DecimalValue(context, (DecimalValue) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.ENUM_VALUE:
				if(context == grammarAccess.getEnumValueRule() ||
				   context == grammarAccess.getValueOrEnumValueOrOperationRule()) {
					sequence_EnumValue(context, (EnumValue) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.EUROPEAN_DATE_AND12_HRS_TIME_VALUE:
				if(context == grammarAccess.getConstantValueRule() ||
				   context == grammarAccess.getDateAndTimeValueRule() ||
				   context == grammarAccess.getEuropeanDateAnd12HrsTimeValueRule() ||
				   context == grammarAccess.getStaticValueRule() ||
				   context == grammarAccess.getValueRule() ||
				   context == grammarAccess.getValueOrEnumValueOrOperationRule()) {
					sequence_EuropeanDateAnd12HrsTimeValue(context, (EuropeanDateAnd12HrsTimeValue) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.EUROPEAN_DATE_AND24_HRS_TIME_VALUE:
				if(context == grammarAccess.getConstantValueRule() ||
				   context == grammarAccess.getDateAndTimeValueRule() ||
				   context == grammarAccess.getEuropeanDateAnd24HrsTimeValueRule() ||
				   context == grammarAccess.getStaticValueRule() ||
				   context == grammarAccess.getValueRule() ||
				   context == grammarAccess.getValueOrEnumValueOrOperationRule()) {
					sequence_EuropeanDateAnd24HrsTimeValue(context, (EuropeanDateAnd24HrsTimeValue) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.EUROPEAN_DATE_VALUE:
				if(context == grammarAccess.getConstantValueRule() ||
				   context == grammarAccess.getDateValueRule() ||
				   context == grammarAccess.getEuropeanDateValueRule() ||
				   context == grammarAccess.getStaticValueRule() ||
				   context == grammarAccess.getValueRule() ||
				   context == grammarAccess.getValueOrEnumValueOrOperationRule()) {
					sequence_EuropeanDateValue(context, (EuropeanDateValue) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.EXECUTION_MULTIPLIER:
				if(context == grammarAccess.getExecutionMultiplierRule()) {
					sequence_ExecutionMultiplier(context, (ExecutionMultiplier) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.FIXED_PARAMETER_NAME:
				if(context == grammarAccess.getFixedParameterNameRule() ||
				   context == grammarAccess.getParameterNameRule()) {
					sequence_FixedParameterName(context, (FixedParameterName) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.FIXED_RESULT_NAME:
				if(context == grammarAccess.getFixedResultNameRule() ||
				   context == grammarAccess.getResultNameRule()) {
					sequence_FixedResultName(context, (FixedResultName) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.FORK_DEFINITION:
				if(context == grammarAccess.getForkDefinitionRule() ||
				   context == grammarAccess.getPackageStatementRule() ||
				   context == grammarAccess.getStatementRule()) {
					sequence_ForkDefinition(context, (ForkDefinition) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.FORK_PARAMETER:
				if(context == grammarAccess.getForkParameterRule()) {
					sequence_ForkParameter(context, (ForkParameter) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.IMPORT:
				if(context == grammarAccess.getImportRule() ||
				   context == grammarAccess.getPackageStatementRule() ||
				   context == grammarAccess.getStatementRule()) {
					sequence_Import(context, (Import) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.INTEGER_VALUE:
				if(context == grammarAccess.getConstantValueRule() ||
				   context == grammarAccess.getIntegerValueRule() ||
				   context == grammarAccess.getStaticValueRule() ||
				   context == grammarAccess.getValueRule() ||
				   context == grammarAccess.getValueOrEnumValueOrOperationRule()) {
					sequence_IntegerValue(context, (IntegerValue) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.ISO_DATE_AND_TIME_VALUE:
				if(context == grammarAccess.getConstantValueRule() ||
				   context == grammarAccess.getDateAndTimeValueRule() ||
				   context == grammarAccess.getIsoDateAndTimeValueRule() ||
				   context == grammarAccess.getStaticValueRule() ||
				   context == grammarAccess.getValueRule() ||
				   context == grammarAccess.getValueOrEnumValueOrOperationRule()) {
					sequence_IsoDateAndTimeValue(context, (IsoDateAndTimeValue) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.ISO_DATE_VALUE:
				if(context == grammarAccess.getConstantValueRule() ||
				   context == grammarAccess.getDateValueRule() ||
				   context == grammarAccess.getIsoDateValueRule() ||
				   context == grammarAccess.getStaticValueRule() ||
				   context == grammarAccess.getValueRule() ||
				   context == grammarAccess.getValueOrEnumValueOrOperationRule()) {
					sequence_IsoDateValue(context, (IsoDateValue) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.ISO_TIME_VALUE:
				if(context == grammarAccess.getConstantValueRule() ||
				   context == grammarAccess.getIsoTimeValueRule() ||
				   context == grammarAccess.getStaticValueRule() ||
				   context == grammarAccess.getTimeValueRule() ||
				   context == grammarAccess.getValueRule() ||
				   context == grammarAccess.getValueOrEnumValueOrOperationRule()) {
					sequence_IsoTimeValue(context, (IsoTimeValue) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.JAVA_CLASS_REFERENCE:
				if(context == grammarAccess.getJavaClassReferenceRule()) {
					sequence_JavaClassReference(context, (JavaClassReference) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.KEY_VALUE_PAIR:
				if(context == grammarAccess.getKeyValuePairRule()) {
					sequence_KeyValuePair(context, (KeyValuePair) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.METHOD_REFERENCE:
				if(context == grammarAccess.getMethodReferenceRule()) {
					sequence_MethodReference(context, (MethodReference) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.MODEL:
				if(context == grammarAccess.getModelRule()) {
					sequence_Model(context, (Model) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.NAMED_CALL_RESULT:
				if(context == grammarAccess.getNamedCallResultRule()) {
					sequence_NamedCallResult(context, (NamedCallResult) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.NAMED_RESULT:
				if(context == grammarAccess.getNamedResultRule()) {
					sequence_NamedResult(context, (NamedResult) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.NESTED_OBJECT:
				if(context == grammarAccess.getNestedObjectRule() ||
				   context == grammarAccess.getValueRule() ||
				   context == grammarAccess.getValueOrEnumValueOrOperationRule()) {
					sequence_NestedObject(context, (NestedObject) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.NULL:
				if(context == grammarAccess.getConstantValueRule() ||
				   context == grammarAccess.getNullValueRule() ||
				   context == grammarAccess.getStaticValueRule() ||
				   context == grammarAccess.getValueRule() ||
				   context == grammarAccess.getValueOrEnumValueOrOperationRule()) {
					sequence_NullValue(context, (Null) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.OPERATION_DEFINITION:
				if(context == grammarAccess.getOperationDefinitionRule() ||
				   context == grammarAccess.getPackageStatementRule()) {
					sequence_OperationDefinition(context, (OperationDefinition) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.PACKAGE_DEFINITION:
				if(context == grammarAccess.getPackageDefinitionRule() ||
				   context == grammarAccess.getStatementRule()) {
					sequence_PackageDefinition(context, (PackageDefinition) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.PARAMETER:
				if(context == grammarAccess.getParameterRule()) {
					sequence_Parameter(context, (Parameter) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.PARAMETER_TABLE_HEADER:
				if(context == grammarAccess.getParameterTableHeaderRule()) {
					sequence_ParameterTableHeader(context, (ParameterTableHeader) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.PARAMETER_TABLE_VALUE:
				if(context == grammarAccess.getParameterTableValueRule()) {
					sequence_ParameterTableValue(context, (ParameterTableValue) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.RESULT_TABLE_HEADER:
				if(context == grammarAccess.getResultTableHeaderRule()) {
					sequence_ResultTableHeader(context, (ResultTableHeader) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.SIMPLE12_HRS_TIME_VALUE:
				if(context == grammarAccess.getConstantValueRule() ||
				   context == grammarAccess.getSimple12HrsTimeValueRule() ||
				   context == grammarAccess.getStaticValueRule() ||
				   context == grammarAccess.getTimeValueRule() ||
				   context == grammarAccess.getValueRule() ||
				   context == grammarAccess.getValueOrEnumValueOrOperationRule()) {
					sequence_Simple12HrsTimeValue(context, (Simple12HrsTimeValue) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.SIMPLE24_HRS_TIME_VALUE:
				if(context == grammarAccess.getConstantValueRule() ||
				   context == grammarAccess.getSimple24HrsTimeValueRule() ||
				   context == grammarAccess.getStaticValueRule() ||
				   context == grammarAccess.getTimeValueRule() ||
				   context == grammarAccess.getValueRule() ||
				   context == grammarAccess.getValueOrEnumValueOrOperationRule()) {
					sequence_Simple24HrsTimeValue(context, (Simple24HrsTimeValue) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.STANDARD_OPERATION:
				if(context == grammarAccess.getOperationRule() ||
				   context == grammarAccess.getStandardOperationRule() ||
				   context == grammarAccess.getValueOrEnumValueOrOperationRule()) {
					sequence_StandardOperation(context, (StandardOperation) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.STRING_VALUE:
				if(context == grammarAccess.getConstantValueRule() ||
				   context == grammarAccess.getStaticValueRule() ||
				   context == grammarAccess.getStringValueRule() ||
				   context == grammarAccess.getValueRule() ||
				   context == grammarAccess.getValueOrEnumValueOrOperationRule()) {
					sequence_StringValue(context, (StringValue) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.SUITE:
				if(context == grammarAccess.getSuiteRule() ||
				   context == grammarAccess.getSuiteStatementRule() ||
				   context == grammarAccess.getSuiteStatementWithResultRule()) {
					sequence_Suite(context, (Suite) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.SUITE_DEFINITION:
				if(context == grammarAccess.getPackageStatementRule() ||
				   context == grammarAccess.getSuiteDefinitionRule()) {
					sequence_SuiteDefinition(context, (SuiteDefinition) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.SUITE_PARAMETER:
				if(context == grammarAccess.getSuiteParameterRule()) {
					sequence_SuiteParameter(context, (SuiteParameter) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.TABLE_TEST:
				if(context == grammarAccess.getSuiteStatementRule() ||
				   context == grammarAccess.getSuiteStatementWithResultRule() ||
				   context == grammarAccess.getTableTestRule()) {
					sequence_TableTest(context, (TableTest) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.TABLE_TEST_ROW:
				if(context == grammarAccess.getTableTestRowRule()) {
					sequence_TableTestRow(context, (TableTestRow) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.TEST:
				if(context == grammarAccess.getSuiteStatementRule() ||
				   context == grammarAccess.getSuiteStatementWithResultRule() ||
				   context == grammarAccess.getTestRule()) {
					sequence_Test(context, (Test) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.TEST_DEFINITION:
				if(context == grammarAccess.getPackageStatementRule() ||
				   context == grammarAccess.getTestDefinitionRule()) {
					sequence_TestDefinition(context, (TestDefinition) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.US_DATE_AND12_HRS_TIME_VALUE:
				if(context == grammarAccess.getConstantValueRule() ||
				   context == grammarAccess.getDateAndTimeValueRule() ||
				   context == grammarAccess.getStaticValueRule() ||
				   context == grammarAccess.getUSDateAnd12HrsTimeValueRule() ||
				   context == grammarAccess.getValueRule() ||
				   context == grammarAccess.getValueOrEnumValueOrOperationRule()) {
					sequence_USDateAnd12HrsTimeValue(context, (USDateAnd12HrsTimeValue) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.US_DATE_VALUE:
				if(context == grammarAccess.getConstantValueRule() ||
				   context == grammarAccess.getDateValueRule() ||
				   context == grammarAccess.getStaticValueRule() ||
				   context == grammarAccess.getUSDateValueRule() ||
				   context == grammarAccess.getValueRule() ||
				   context == grammarAccess.getValueOrEnumValueOrOperationRule()) {
					sequence_USDateValue(context, (USDateValue) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.VALUE_OR_ENUM_VALUE_OR_OPERATION_COLLECTION:
				if(context == grammarAccess.getValueOrEnumValueOrOperationCollectionRule()) {
					sequence_ValueOrEnumValueOrOperationCollection(context, (ValueOrEnumValueOrOperationCollection) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.VARIABLE:
				if(context == grammarAccess.getValueRule() ||
				   context == grammarAccess.getValueOrEnumValueOrOperationRule() ||
				   context == grammarAccess.getVariableRule()) {
					sequence_Variable(context, (Variable) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.VARIABLE_DEFINITION:
				if(context == grammarAccess.getPackageStatementRule() ||
				   context == grammarAccess.getSuiteStatementRule() ||
				   context == grammarAccess.getVariableDefinitionRule()) {
					sequence_VariableDefinition(context, (VariableDefinition) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.VARIABLE_ENTITY:
				if(context == grammarAccess.getVariableEntityRule() ||
				   context == grammarAccess.getVariableOrConstantEntityRule()) {
					sequence_VariableEntity(context, (VariableEntity) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.VARIABLE_VARIABLE:
				if(context == grammarAccess.getVariableVariableRule()) {
					sequence_VariableVariable(context, (VariableVariable) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.VARIANT_DEFINITION:
				if(context == grammarAccess.getPackageStatementRule() ||
				   context == grammarAccess.getStatementRule() ||
				   context == grammarAccess.getVariantDefinitionRule()) {
					sequence_VariantDefinition(context, (VariantDefinition) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.VARIANT_VALUE:
				if(context == grammarAccess.getVariantValueRule()) {
					sequence_VariantValue(context, (VariantValue) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.VISIBLE_DIVIDER:
				if(context == grammarAccess.getSuiteStatementRule() ||
				   context == grammarAccess.getVisibleDividerRule()) {
					sequence_VisibleDivider(context, (VisibleDivider) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.VISIBLE_MULTI_LINE_NORMAL_COMMENT:
				if(context == grammarAccess.getSuiteStatementRule() ||
				   context == grammarAccess.getVisibleCommentRule() ||
				   context == grammarAccess.getVisibleMultiLineCommentRule() ||
				   context == grammarAccess.getVisibleMultiLineNormalCommentRule()) {
					sequence_VisibleMultiLineNormalComment(context, (VisibleMultiLineNormalComment) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.VISIBLE_MULTI_LINE_TITLE_COMMENT:
				if(context == grammarAccess.getSuiteStatementRule() ||
				   context == grammarAccess.getVisibleCommentRule() ||
				   context == grammarAccess.getVisibleMultiLineCommentRule() ||
				   context == grammarAccess.getVisibleMultiLineTitleCommentRule()) {
					sequence_VisibleMultiLineTitleComment(context, (VisibleMultiLineTitleComment) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.VISIBLE_SINGLE_LINE_NORMAL_COMMENT:
				if(context == grammarAccess.getSuiteStatementRule() ||
				   context == grammarAccess.getVisibleCommentRule() ||
				   context == grammarAccess.getVisibleSingleLineCommentRule() ||
				   context == grammarAccess.getVisibleSingleLineNormalCommentRule()) {
					sequence_VisibleSingleLineNormalComment(context, (VisibleSingleLineNormalComment) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.VISIBLE_SINGLE_LINE_TITLE_COMMENT:
				if(context == grammarAccess.getSuiteStatementRule() ||
				   context == grammarAccess.getVisibleCommentRule() ||
				   context == grammarAccess.getVisibleSingleLineCommentRule() ||
				   context == grammarAccess.getVisibleSingleLineTitleCommentRule()) {
					sequence_VisibleSingleLineTitleComment(context, (VisibleSingleLineTitleComment) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     identifier=ID
	 */
	protected void sequence_ArbitraryParameterOrResultName(EObject context, ArbitraryParameterOrResultName semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.ARBITRARY_PARAMETER_OR_RESULT_NAME__IDENTIFIER) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.ARBITRARY_PARAMETER_OR_RESULT_NAME__IDENTIFIER));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getArbitraryParameterOrResultNameAccess().getIdentifierIDTerminalRuleCall_1_0(), semanticObject.getIdentifier());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (booleanValue=BOOLEAN_TRUE | booleanValue=BOOLEAN_FALSE)
	 */
	protected void sequence_BooleanValue(EObject context, BooleanValue semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=QualifiedName fixtureMethod=MethodReference)
	 */
	protected void sequence_CallDefinition(EObject context, CallDefinition semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.CALL_DEFINITION__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.CALL_DEFINITION__NAME));
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.CALL_DEFINITION__FIXTURE_METHOD) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.CALL_DEFINITION__FIXTURE_METHOD));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getCallDefinitionAccess().getNameQualifiedNameParserRuleCall_2_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getCallDefinitionAccess().getFixtureMethodMethodReferenceParserRuleCall_6_0(), semanticObject.getFixtureMethod());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         multiplier=ExecutionMultiplier? 
	 *         definition=[CallDefinition|QualifiedName] 
	 *         parameters+=Parameter* 
	 *         results+=NamedCallResult* 
	 *         result=VariableVariable?
	 *     )
	 */
	protected void sequence_Call(EObject context, Call semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ConstantEntity ((value=ValueOrEnumValueOrOperation? variantValues+=VariantValue*) | parameterized='parameterized'))
	 */
	protected void sequence_ConstantDefinition(EObject context, ConstantDefinition semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=QualifiedName
	 */
	protected void sequence_ConstantEntity(EObject context, ConstantEntity semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.VARIABLE_OR_CONSTANT_ENTITY__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.VARIABLE_OR_CONSTANT_ENTITY__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getConstantEntityAccess().getNameQualifiedNameParserRuleCall_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     name=[ConstantEntity|QualifiedName]
	 */
	protected void sequence_Constant(EObject context, Constant semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.CONSTANT__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.CONSTANT__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getConstantAccess().getNameConstantEntityQualifiedNameParserRuleCall_0_1(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         prefixOperand=ValueOrEnumValueOrOperationCollection? 
	 *         definition=[OperationDefinition|QualifiedName] 
	 *         postfixOperand=ValueOrEnumValueOrOperationCollection?
	 *     )
	 */
	protected void sequence_CustomOperation(EObject context, CustomOperation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     decimalValue=DECIMAL
	 */
	protected void sequence_DecimalValue(EObject context, DecimalValue semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.DECIMAL_VALUE__DECIMAL_VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.DECIMAL_VALUE__DECIMAL_VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getDecimalValueAccess().getDecimalValueDECIMALTerminalRuleCall_0(), semanticObject.getDecimalValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     enumValue=[JvmEnumerationLiteral|UPPERCASE_ID]
	 */
	protected void sequence_EnumValue(EObject context, EnumValue semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.ENUM_VALUE__ENUM_VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.ENUM_VALUE__ENUM_VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getEnumValueAccess().getEnumValueJvmEnumerationLiteralUPPERCASE_IDTerminalRuleCall_0_1(), semanticObject.getEnumValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (dateValue=EURODATE timeValue=TWELVEHRSTIME)
	 */
	protected void sequence_EuropeanDateAnd12HrsTimeValue(EObject context, EuropeanDateAnd12HrsTimeValue semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.DATE_AND_TIME_VALUE__DATE_VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.DATE_AND_TIME_VALUE__DATE_VALUE));
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.DATE_AND_TIME_VALUE__TIME_VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.DATE_AND_TIME_VALUE__TIME_VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getEuropeanDateAnd12HrsTimeValueAccess().getDateValueEURODATETerminalRuleCall_0_0(), semanticObject.getDateValue());
		feeder.accept(grammarAccess.getEuropeanDateAnd12HrsTimeValueAccess().getTimeValueTWELVEHRSTIMETerminalRuleCall_2_0(), semanticObject.getTimeValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (dateValue=EURODATE timeValue=TWENTYFOURHRSTIME)
	 */
	protected void sequence_EuropeanDateAnd24HrsTimeValue(EObject context, EuropeanDateAnd24HrsTimeValue semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.DATE_AND_TIME_VALUE__DATE_VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.DATE_AND_TIME_VALUE__DATE_VALUE));
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.DATE_AND_TIME_VALUE__TIME_VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.DATE_AND_TIME_VALUE__TIME_VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getEuropeanDateAnd24HrsTimeValueAccess().getDateValueEURODATETerminalRuleCall_0_0(), semanticObject.getDateValue());
		feeder.accept(grammarAccess.getEuropeanDateAnd24HrsTimeValueAccess().getTimeValueTWENTYFOURHRSTIMETerminalRuleCall_2_0(), semanticObject.getTimeValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     dateValue=EURODATE
	 */
	protected void sequence_EuropeanDateValue(EObject context, EuropeanDateValue semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.DATE_VALUE__DATE_VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.DATE_VALUE__DATE_VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getEuropeanDateValueAccess().getDateValueEURODATETerminalRuleCall_0(), semanticObject.getDateValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     count=ConstantValue
	 */
	protected void sequence_ExecutionMultiplier(EObject context, ExecutionMultiplier semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.EXECUTION_MULTIPLIER__COUNT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.EXECUTION_MULTIPLIER__COUNT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getExecutionMultiplierAccess().getCountConstantValueParserRuleCall_0_0(), semanticObject.getCount());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     annotation=[JvmAnnotationReference|ID]
	 */
	protected void sequence_FixedParameterName(EObject context, FixedParameterName semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.FIXED_PARAMETER_NAME__ANNOTATION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.FIXED_PARAMETER_NAME__ANNOTATION));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getFixedParameterNameAccess().getAnnotationJvmAnnotationReferenceIDTerminalRuleCall_0_1(), semanticObject.getAnnotation());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     field=[JvmField|ID]
	 */
	protected void sequence_FixedResultName(EObject context, FixedResultName semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.FIXED_RESULT_NAME__FIELD) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.FIXED_RESULT_NAME__FIELD));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getFixedResultNameAccess().getFieldJvmFieldIDTerminalRuleCall_0_1(), semanticObject.getField());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=QualifiedName description=STRING? forkerClass=JavaClassReference? parameters+=ForkParameter*)
	 */
	protected void sequence_ForkDefinition(EObject context, ForkDefinition semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=FixedParameterName value=ValueOrEnumValueOrOperation)
	 */
	protected void sequence_ForkParameter(EObject context, ForkParameter semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.FORK_PARAMETER__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.FORK_PARAMETER__NAME));
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.FORK_PARAMETER__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.FORK_PARAMETER__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getForkParameterAccess().getNameFixedParameterNameParserRuleCall_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getForkParameterAccess().getValueValueOrEnumValueOrOperationParserRuleCall_4_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     importedNamespace=QualifiedNameWithWildcard
	 */
	protected void sequence_Import(EObject context, Import semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.IMPORT__IMPORTED_NAMESPACE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.IMPORT__IMPORTED_NAMESPACE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameWithWildcardParserRuleCall_2_0(), semanticObject.getImportedNamespace());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     integerValue=INTEGER
	 */
	protected void sequence_IntegerValue(EObject context, IntegerValue semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.INTEGER_VALUE__INTEGER_VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.INTEGER_VALUE__INTEGER_VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getIntegerValueAccess().getIntegerValueINTEGERTerminalRuleCall_0(), semanticObject.getIntegerValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (dateValue=ISODATE timeValue=ISOTIME)
	 */
	protected void sequence_IsoDateAndTimeValue(EObject context, IsoDateAndTimeValue semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.DATE_AND_TIME_VALUE__DATE_VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.DATE_AND_TIME_VALUE__DATE_VALUE));
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.DATE_AND_TIME_VALUE__TIME_VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.DATE_AND_TIME_VALUE__TIME_VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getIsoDateAndTimeValueAccess().getDateValueISODATETerminalRuleCall_0_0(), semanticObject.getDateValue());
		feeder.accept(grammarAccess.getIsoDateAndTimeValueAccess().getTimeValueISOTIMETerminalRuleCall_1_0(), semanticObject.getTimeValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     dateValue=ISODATE
	 */
	protected void sequence_IsoDateValue(EObject context, IsoDateValue semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.DATE_VALUE__DATE_VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.DATE_VALUE__DATE_VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getIsoDateValueAccess().getDateValueISODATETerminalRuleCall_0(), semanticObject.getDateValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     timeValue=ISOTIME
	 */
	protected void sequence_IsoTimeValue(EObject context, IsoTimeValue semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.TIME_VALUE__TIME_VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.TIME_VALUE__TIME_VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getIsoTimeValueAccess().getTimeValueISOTIMETerminalRuleCall_0(), semanticObject.getTimeValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     type=[JvmType|QualifiedJavaClassName]
	 */
	protected void sequence_JavaClassReference(EObject context, JavaClassReference semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.JAVA_CLASS_REFERENCE__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.JAVA_CLASS_REFERENCE__TYPE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getJavaClassReferenceAccess().getTypeJvmTypeQualifiedJavaClassNameParserRuleCall_0_1(), semanticObject.getType());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (identifier=ID value=ValueOrEnumValueOrOperationCollection)
	 */
	protected void sequence_KeyValuePair(EObject context, KeyValuePair semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.KEY_VALUE_PAIR__IDENTIFIER) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.KEY_VALUE_PAIR__IDENTIFIER));
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.KEY_VALUE_PAIR__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.KEY_VALUE_PAIR__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getKeyValuePairAccess().getIdentifierIDTerminalRuleCall_0_0(), semanticObject.getIdentifier());
		feeder.accept(grammarAccess.getKeyValuePairAccess().getValueValueOrEnumValueOrOperationCollectionParserRuleCall_4_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (type=[JvmType|QualifiedJavaClassName] method=[JvmOperation|ID])
	 */
	protected void sequence_MethodReference(EObject context, MethodReference semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.METHOD_REFERENCE__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.METHOD_REFERENCE__TYPE));
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.METHOD_REFERENCE__METHOD) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.METHOD_REFERENCE__METHOD));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getMethodReferenceAccess().getTypeJvmTypeQualifiedJavaClassNameParserRuleCall_0_0_1(), semanticObject.getType());
		feeder.accept(grammarAccess.getMethodReferenceAccess().getMethodJvmOperationIDTerminalRuleCall_2_0_1(), semanticObject.getMethod());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (statements+=Statement*)
	 */
	protected void sequence_Model(EObject context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=ResultName target=VariableVariable)
	 */
	protected void sequence_NamedCallResult(EObject context, NamedCallResult semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.NAMED_CALL_RESULT__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.NAMED_CALL_RESULT__NAME));
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.NAMED_CALL_RESULT__TARGET) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.NAMED_CALL_RESULT__TARGET));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getNamedCallResultAccess().getNameResultNameParserRuleCall_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getNamedCallResultAccess().getTargetVariableVariableParserRuleCall_4_0(), semanticObject.getTarget());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=ResultName value=ValueOrEnumValueOrOperationCollection)
	 */
	protected void sequence_NamedResult(EObject context, NamedResult semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.NAMED_RESULT__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.NAMED_RESULT__NAME));
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.NAMED_RESULT__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.NAMED_RESULT__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getNamedResultAccess().getNameResultNameParserRuleCall_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getNamedResultAccess().getValueValueOrEnumValueOrOperationCollectionParserRuleCall_4_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     attributes+=KeyValuePair+
	 */
	protected void sequence_NestedObject(EObject context, NestedObject semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {Null}
	 */
	protected void sequence_NullValue(EObject context, Null semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=QualifiedName operationType=[JvmType|QualifiedJavaClassName])
	 */
	protected void sequence_OperationDefinition(EObject context, OperationDefinition semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.OPERATION_DEFINITION__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.OPERATION_DEFINITION__NAME));
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.OPERATION_DEFINITION__OPERATION_TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.OPERATION_DEFINITION__OPERATION_TYPE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getOperationDefinitionAccess().getNameQualifiedNameParserRuleCall_2_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getOperationDefinitionAccess().getOperationTypeJvmTypeQualifiedJavaClassNameParserRuleCall_6_0_1(), semanticObject.getOperationType());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=QualifiedName statements+=PackageStatement*)
	 */
	protected void sequence_PackageDefinition(EObject context, PackageDefinition semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=ParameterName
	 */
	protected void sequence_ParameterTableHeader(EObject context, ParameterTableHeader semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.PARAMETER_TABLE_HEADER__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.PARAMETER_TABLE_HEADER__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getParameterTableHeaderAccess().getNameParameterNameParserRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     value=ValueOrEnumValueOrOperationCollection
	 */
	protected void sequence_ParameterTableValue(EObject context, ParameterTableValue semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.PARAMETER_TABLE_VALUE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.PARAMETER_TABLE_VALUE__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getParameterTableValueAccess().getValueValueOrEnumValueOrOperationCollectionParserRuleCall_1_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=ParameterName value=ValueOrEnumValueOrOperationCollection)
	 */
	protected void sequence_Parameter(EObject context, Parameter semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.PARAMETER__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.PARAMETER__NAME));
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.PARAMETER__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.PARAMETER__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getParameterAccess().getNameParameterNameParserRuleCall_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getParameterAccess().getValueValueOrEnumValueOrOperationCollectionParserRuleCall_4_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     name=ResultName
	 */
	protected void sequence_ResultTableHeader(EObject context, ResultTableHeader semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.RESULT_TABLE_HEADER__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.RESULT_TABLE_HEADER__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getResultTableHeaderAccess().getNameResultNameParserRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     timeValue=TWELVEHRSTIME
	 */
	protected void sequence_Simple12HrsTimeValue(EObject context, Simple12HrsTimeValue semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.TIME_VALUE__TIME_VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.TIME_VALUE__TIME_VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSimple12HrsTimeValueAccess().getTimeValueTWELVEHRSTIMETerminalRuleCall_0(), semanticObject.getTimeValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     timeValue=TWENTYFOURHRSTIME
	 */
	protected void sequence_Simple24HrsTimeValue(EObject context, Simple24HrsTimeValue semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.TIME_VALUE__TIME_VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.TIME_VALUE__TIME_VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSimple24HrsTimeValueAccess().getTimeValueTWENTYFOURHRSTIMETerminalRuleCall_0(), semanticObject.getTimeValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         firstOperand=ValueOrEnumValueOrOperation 
	 *         (
	 *             (
	 *                 operators+='+' | 
	 *                 operators+='-' | 
	 *                 operators+='*' | 
	 *                 operators+='/' | 
	 *                 operators+='%' | 
	 *                 operators+='..'
	 *             ) 
	 *             moreOperands+=ValueOrEnumValueOrOperation
	 *         )+
	 *     )
	 */
	protected void sequence_StandardOperation(EObject context, StandardOperation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     stringValue=STRING
	 */
	protected void sequence_StringValue(EObject context, StringValue semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.STRING_VALUE__STRING_VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.STRING_VALUE__STRING_VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getStringValueAccess().getStringValueSTRINGTerminalRuleCall_0(), semanticObject.getStringValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name=QualifiedName 
	 *         parameters+=VariableEntity* 
	 *         dependencies+=[SuiteDefinition|QualifiedName]* 
	 *         finalizers+=[SuiteDefinition|QualifiedName]* 
	 *         statements+=SuiteStatement*
	 *     )
	 */
	protected void sequence_SuiteDefinition(EObject context, SuiteDefinition semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=[VariableOrConstantEntity|QualifiedName] value=Value)
	 */
	protected void sequence_SuiteParameter(EObject context, SuiteParameter semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.SUITE_PARAMETER__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.SUITE_PARAMETER__NAME));
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.SUITE_PARAMETER__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.SUITE_PARAMETER__VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getSuiteParameterAccess().getNameVariableOrConstantEntityQualifiedNameParserRuleCall_0_0_1(), semanticObject.getName());
		feeder.accept(grammarAccess.getSuiteParameterAccess().getValueValueParserRuleCall_4_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         multiplier=ExecutionMultiplier? 
	 *         definition=[SuiteDefinition|QualifiedName] 
	 *         parameters+=SuiteParameter* 
	 *         fork=[ForkDefinition|QualifiedName]? 
	 *         variants+=[VariantDefinition|QualifiedName]*
	 *     )
	 */
	protected void sequence_Suite(EObject context, Suite semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     values+=ParameterTableValue+
	 */
	protected void sequence_TableTestRow(EObject context, TableTestRow semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         definition=[TestDefinition|QualifiedName] 
	 *         parameters+=Parameter* 
	 *         parameterHeaders+=ParameterTableHeader* 
	 *         resultHeaders+=ResultTableHeader* 
	 *         defaultResultColumn='='? 
	 *         rows+=TableTestRow+
	 *     )
	 */
	protected void sequence_TableTest(EObject context, TableTest semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=QualifiedName fixtureMethod=MethodReference)
	 */
	protected void sequence_TestDefinition(EObject context, TestDefinition semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.TEST_DEFINITION__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.TEST_DEFINITION__NAME));
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.TEST_DEFINITION__FIXTURE_METHOD) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.TEST_DEFINITION__FIXTURE_METHOD));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getTestDefinitionAccess().getNameQualifiedNameParserRuleCall_2_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getTestDefinitionAccess().getFixtureMethodMethodReferenceParserRuleCall_6_0(), semanticObject.getFixtureMethod());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (definition=[TestDefinition|QualifiedName] parameters+=Parameter* results+=NamedResult* result=ValueOrEnumValueOrOperationCollection?)
	 */
	protected void sequence_Test(EObject context, Test semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (dateValue=USDATE timeValue=TWELVEHRSTIME)
	 */
	protected void sequence_USDateAnd12HrsTimeValue(EObject context, USDateAnd12HrsTimeValue semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.DATE_AND_TIME_VALUE__DATE_VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.DATE_AND_TIME_VALUE__DATE_VALUE));
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.DATE_AND_TIME_VALUE__TIME_VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.DATE_AND_TIME_VALUE__TIME_VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getUSDateAnd12HrsTimeValueAccess().getDateValueUSDATETerminalRuleCall_0_0(), semanticObject.getDateValue());
		feeder.accept(grammarAccess.getUSDateAnd12HrsTimeValueAccess().getTimeValueTWELVEHRSTIMETerminalRuleCall_2_0(), semanticObject.getTimeValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     dateValue=USDATE
	 */
	protected void sequence_USDateValue(EObject context, USDateValue semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.DATE_VALUE__DATE_VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.DATE_VALUE__DATE_VALUE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getUSDateValueAccess().getDateValueUSDATETerminalRuleCall_0(), semanticObject.getDateValue());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (value=ValueOrEnumValueOrOperation moreValues+=ValueOrEnumValueOrOperation*)
	 */
	protected void sequence_ValueOrEnumValueOrOperationCollection(EObject context, ValueOrEnumValueOrOperationCollection semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=VariableEntity initialValue=ValueOrEnumValueOrOperation?)
	 */
	protected void sequence_VariableDefinition(EObject context, VariableDefinition semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=QualifiedName
	 */
	protected void sequence_VariableEntity(EObject context, VariableEntity semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.VARIABLE_OR_CONSTANT_ENTITY__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.VARIABLE_OR_CONSTANT_ENTITY__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getVariableEntityAccess().getNameQualifiedNameParserRuleCall_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     name=[VariableEntity|QualifiedName]
	 */
	protected void sequence_VariableVariable(EObject context, VariableVariable semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.VARIABLE_VARIABLE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.VARIABLE_VARIABLE__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getVariableVariableAccess().getNameVariableEntityQualifiedNameParserRuleCall_0_1(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     name=[VariableOrConstantEntity|QualifiedName]
	 */
	protected void sequence_Variable(EObject context, Variable semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.VARIABLE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.VARIABLE__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getVariableAccess().getNameVariableOrConstantEntityQualifiedNameParserRuleCall_0_1(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=QualifiedName description=STRING?)
	 */
	protected void sequence_VariantDefinition(EObject context, VariantDefinition semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (names+=[VariantDefinition|QualifiedName]+ value=ValueOrEnumValueOrOperation)
	 */
	protected void sequence_VariantValue(EObject context, VariantValue semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     content=DIVIDER
	 */
	protected void sequence_VisibleDivider(EObject context, VisibleDivider semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.VISIBLE_DIVIDER__CONTENT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.VISIBLE_DIVIDER__CONTENT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getVisibleDividerAccess().getContentDIVIDERTerminalRuleCall_0_0(), semanticObject.getContent());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     content=ML_VISIBLE_COMMENT
	 */
	protected void sequence_VisibleMultiLineNormalComment(EObject context, VisibleMultiLineNormalComment semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.VISIBLE_COMMENT__CONTENT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.VISIBLE_COMMENT__CONTENT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getVisibleMultiLineNormalCommentAccess().getContentML_VISIBLE_COMMENTTerminalRuleCall_0_0(), semanticObject.getContent());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     content=ML_VISIBLE_TITLE_COMMENT
	 */
	protected void sequence_VisibleMultiLineTitleComment(EObject context, VisibleMultiLineTitleComment semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.VISIBLE_COMMENT__CONTENT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.VISIBLE_COMMENT__CONTENT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getVisibleMultiLineTitleCommentAccess().getContentML_VISIBLE_TITLE_COMMENTTerminalRuleCall_0_0(), semanticObject.getContent());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     content=SL_VISIBLE_COMMENT
	 */
	protected void sequence_VisibleSingleLineNormalComment(EObject context, VisibleSingleLineNormalComment semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.VISIBLE_COMMENT__CONTENT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.VISIBLE_COMMENT__CONTENT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getVisibleSingleLineNormalCommentAccess().getContentSL_VISIBLE_COMMENTTerminalRuleCall_0_0(), semanticObject.getContent());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     content=SL_VISIBLE_TITLE_COMMENT
	 */
	protected void sequence_VisibleSingleLineTitleComment(EObject context, VisibleSingleLineTitleComment semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.VISIBLE_COMMENT__CONTENT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.VISIBLE_COMMENT__CONTENT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getVisibleSingleLineTitleCommentAccess().getContentSL_VISIBLE_TITLE_COMMENTTerminalRuleCall_0_0(), semanticObject.getContent());
		feeder.finish();
	}
}
