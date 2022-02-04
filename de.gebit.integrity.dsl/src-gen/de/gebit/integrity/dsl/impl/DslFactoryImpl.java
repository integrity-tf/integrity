/**
 */
package de.gebit.integrity.dsl.impl;

import de.gebit.integrity.dsl.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DslFactoryImpl extends EFactoryImpl implements DslFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static DslFactory init()
  {
    try
    {
      DslFactory theDslFactory = (DslFactory)EPackage.Registry.INSTANCE.getEFactory(DslPackage.eNS_URI);
      if (theDslFactory != null)
      {
        return theDslFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new DslFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DslFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case DslPackage.MODEL: return createModel();
      case DslPackage.STATEMENT: return createStatement();
      case DslPackage.VISIBLE_COMMENT: return createVisibleComment();
      case DslPackage.VISIBLE_SINGLE_LINE_COMMENT: return createVisibleSingleLineComment();
      case DslPackage.VISIBLE_SINGLE_LINE_NORMAL_COMMENT: return createVisibleSingleLineNormalComment();
      case DslPackage.VISIBLE_SINGLE_LINE_TITLE_COMMENT: return createVisibleSingleLineTitleComment();
      case DslPackage.VISIBLE_MULTI_LINE_COMMENT: return createVisibleMultiLineComment();
      case DslPackage.VISIBLE_MULTI_LINE_NORMAL_COMMENT: return createVisibleMultiLineNormalComment();
      case DslPackage.VISIBLE_MULTI_LINE_TITLE_COMMENT: return createVisibleMultiLineTitleComment();
      case DslPackage.VISIBLE_DIVIDER: return createVisibleDivider();
      case DslPackage.PACKAGE_DEFINITION: return createPackageDefinition();
      case DslPackage.PACKAGE_STATEMENT: return createPackageStatement();
      case DslPackage.IMPORT: return createImport();
      case DslPackage.FORK_DEFINITION: return createForkDefinition();
      case DslPackage.FORK_PARAMETER: return createForkParameter();
      case DslPackage.VARIANT_DEFINITION: return createVariantDefinition();
      case DslPackage.TEST_DEFINITION: return createTestDefinition();
      case DslPackage.CALL_DEFINITION: return createCallDefinition();
      case DslPackage.SUITE_DEFINITION: return createSuiteDefinition();
      case DslPackage.SUITE_PARAMETER_DEFINITION: return createSuiteParameterDefinition();
      case DslPackage.SUITE_RETURN_DEFINITION: return createSuiteReturnDefinition();
      case DslPackage.OPERATION_DEFINITION: return createOperationDefinition();
      case DslPackage.SUITE_STATEMENT: return createSuiteStatement();
      case DslPackage.SUITE_STATEMENT_WITH_RESULT: return createSuiteStatementWithResult();
      case DslPackage.VARIABLE_DEFINITION: return createVariableDefinition();
      case DslPackage.CONSTANT_DEFINITION: return createConstantDefinition();
      case DslPackage.VARIABLE_ASSIGNMENT: return createVariableAssignment();
      case DslPackage.VARIANT_VALUE: return createVariantValue();
      case DslPackage.VARIABLE_ENTITY: return createVariableEntity();
      case DslPackage.CONSTANT_ENTITY: return createConstantEntity();
      case DslPackage.VARIABLE_OR_CONSTANT_ENTITY: return createVariableOrConstantEntity();
      case DslPackage.TEST: return createTest();
      case DslPackage.TABLE_TEST: return createTableTest();
      case DslPackage.TABLE_TEST_ROW: return createTableTestRow();
      case DslPackage.PARAMETER_TABLE_HEADER: return createParameterTableHeader();
      case DslPackage.RESULT_TABLE_HEADER: return createResultTableHeader();
      case DslPackage.PARAMETER_TABLE_VALUE: return createParameterTableValue();
      case DslPackage.NAMED_RESULT: return createNamedResult();
      case DslPackage.RESULT_NAME: return createResultName();
      case DslPackage.FIXED_RESULT_NAME: return createFixedResultName();
      case DslPackage.CALL: return createCall();
      case DslPackage.NAMED_CALL_RESULT: return createNamedCallResult();
      case DslPackage.TIME_SET: return createTimeSet();
      case DslPackage.TIME_PROGRESSION_FACTOR: return createTimeProgressionFactor();
      case DslPackage.TIME_DIFFERENCE: return createTimeDifference();
      case DslPackage.SUITE: return createSuite();
      case DslPackage.SUITE_PARAMETER: return createSuiteParameter();
      case DslPackage.SUITE_RETURN: return createSuiteReturn();
      case DslPackage.PARAMETER: return createParameter();
      case DslPackage.PARAMETER_NAME: return createParameterName();
      case DslPackage.FIXED_PARAMETER_NAME: return createFixedParameterName();
      case DslPackage.ARBITRARY_PARAMETER_OR_RESULT_NAME: return createArbitraryParameterOrResultName();
      case DslPackage.OPERATION: return createOperation();
      case DslPackage.STANDARD_OPERATION: return createStandardOperation();
      case DslPackage.CUSTOM_OPERATION: return createCustomOperation();
      case DslPackage.VALUE_OR_ENUM_VALUE_OR_OPERATION_COLLECTION: return createValueOrEnumValueOrOperationCollection();
      case DslPackage.VALUE_OR_ENUM_VALUE_OR_OPERATION: return createValueOrEnumValueOrOperation();
      case DslPackage.VALUE: return createValue();
      case DslPackage.CONSTANT_VALUE: return createConstantValue();
      case DslPackage.STATIC_VALUE: return createStaticValue();
      case DslPackage.INTEGER_VALUE: return createIntegerValue();
      case DslPackage.DECIMAL_VALUE: return createDecimalValue();
      case DslPackage.STRING_VALUE: return createStringValue();
      case DslPackage.REGEX_VALUE: return createRegexValue();
      case DslPackage.BOOLEAN_VALUE: return createBooleanValue();
      case DslPackage.DATE_VALUE: return createDateValue();
      case DslPackage.ISO_DATE_VALUE: return createIsoDateValue();
      case DslPackage.EUROPEAN_DATE_VALUE: return createEuropeanDateValue();
      case DslPackage.US_DATE_VALUE: return createUSDateValue();
      case DslPackage.TIME_VALUE: return createTimeValue();
      case DslPackage.ISO_TIME_VALUE: return createIsoTimeValue();
      case DslPackage.SIMPLE24_HRS_TIME_VALUE: return createSimple24HrsTimeValue();
      case DslPackage.SIMPLE12_HRS_TIME_VALUE: return createSimple12HrsTimeValue();
      case DslPackage.DATE_AND_TIME_VALUE: return createDateAndTimeValue();
      case DslPackage.ISO_DATE_AND_TIME_VALUE: return createIsoDateAndTimeValue();
      case DslPackage.EUROPEAN_DATE_AND24_HRS_TIME_VALUE: return createEuropeanDateAnd24HrsTimeValue();
      case DslPackage.EUROPEAN_DATE_AND12_HRS_TIME_VALUE: return createEuropeanDateAnd12HrsTimeValue();
      case DslPackage.US_DATE_AND12_HRS_TIME_VALUE: return createUSDateAnd12HrsTimeValue();
      case DslPackage.JAVA_CONSTANT_VALUE: return createJavaConstantValue();
      case DslPackage.VARIABLE: return createVariable();
      case DslPackage.VARIABLE_VARIABLE: return createVariableVariable();
      case DslPackage.CONSTANT: return createConstant();
      case DslPackage.NULL_VALUE: return createNullValue();
      case DslPackage.INEXISTENT_VALUE: return createInexistentValue();
      case DslPackage.EMPTY_VALUE: return createEmptyValue();
      case DslPackage.ENUM_VALUE: return createEnumValue();
      case DslPackage.NESTED_OBJECT: return createNestedObject();
      case DslPackage.TYPED_NESTED_OBJECT: return createTypedNestedObject();
      case DslPackage.KEY_VALUE_PAIR: return createKeyValuePair();
      case DslPackage.JAVA_CLASS_REFERENCE: return createJavaClassReference();
      case DslPackage.METHOD_REFERENCE: return createMethodReference();
      case DslPackage.JAVA_CONSTANT_REFERENCE: return createJavaConstantReference();
      case DslPackage.EXECUTION_MULTIPLIER: return createExecutionMultiplier();
      case DslPackage.DOCUMENTATION_COMMENT: return createDocumentationComment();
      case DslPackage.NULL: return createNull();
      case DslPackage.INEXISTENT: return createInexistent();
      case DslPackage.EMPTY: return createEmpty();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Model createModel()
  {
    ModelImpl model = new ModelImpl();
    return model;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Statement createStatement()
  {
    StatementImpl statement = new StatementImpl();
    return statement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public VisibleComment createVisibleComment()
  {
    VisibleCommentImpl visibleComment = new VisibleCommentImpl();
    return visibleComment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public VisibleSingleLineComment createVisibleSingleLineComment()
  {
    VisibleSingleLineCommentImpl visibleSingleLineComment = new VisibleSingleLineCommentImpl();
    return visibleSingleLineComment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public VisibleSingleLineNormalComment createVisibleSingleLineNormalComment()
  {
    VisibleSingleLineNormalCommentImpl visibleSingleLineNormalComment = new VisibleSingleLineNormalCommentImpl();
    return visibleSingleLineNormalComment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public VisibleSingleLineTitleComment createVisibleSingleLineTitleComment()
  {
    VisibleSingleLineTitleCommentImpl visibleSingleLineTitleComment = new VisibleSingleLineTitleCommentImpl();
    return visibleSingleLineTitleComment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public VisibleMultiLineComment createVisibleMultiLineComment()
  {
    VisibleMultiLineCommentImpl visibleMultiLineComment = new VisibleMultiLineCommentImpl();
    return visibleMultiLineComment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public VisibleMultiLineNormalComment createVisibleMultiLineNormalComment()
  {
    VisibleMultiLineNormalCommentImpl visibleMultiLineNormalComment = new VisibleMultiLineNormalCommentImpl();
    return visibleMultiLineNormalComment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public VisibleMultiLineTitleComment createVisibleMultiLineTitleComment()
  {
    VisibleMultiLineTitleCommentImpl visibleMultiLineTitleComment = new VisibleMultiLineTitleCommentImpl();
    return visibleMultiLineTitleComment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public VisibleDivider createVisibleDivider()
  {
    VisibleDividerImpl visibleDivider = new VisibleDividerImpl();
    return visibleDivider;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PackageDefinition createPackageDefinition()
  {
    PackageDefinitionImpl packageDefinition = new PackageDefinitionImpl();
    return packageDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public PackageStatement createPackageStatement()
  {
    PackageStatementImpl packageStatement = new PackageStatementImpl();
    return packageStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Import createImport()
  {
    ImportImpl import_ = new ImportImpl();
    return import_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ForkDefinition createForkDefinition()
  {
    ForkDefinitionImpl forkDefinition = new ForkDefinitionImpl();
    return forkDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ForkParameter createForkParameter()
  {
    ForkParameterImpl forkParameter = new ForkParameterImpl();
    return forkParameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public VariantDefinition createVariantDefinition()
  {
    VariantDefinitionImpl variantDefinition = new VariantDefinitionImpl();
    return variantDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TestDefinition createTestDefinition()
  {
    TestDefinitionImpl testDefinition = new TestDefinitionImpl();
    return testDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public CallDefinition createCallDefinition()
  {
    CallDefinitionImpl callDefinition = new CallDefinitionImpl();
    return callDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public SuiteDefinition createSuiteDefinition()
  {
    SuiteDefinitionImpl suiteDefinition = new SuiteDefinitionImpl();
    return suiteDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public SuiteParameterDefinition createSuiteParameterDefinition()
  {
    SuiteParameterDefinitionImpl suiteParameterDefinition = new SuiteParameterDefinitionImpl();
    return suiteParameterDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public SuiteReturnDefinition createSuiteReturnDefinition()
  {
    SuiteReturnDefinitionImpl suiteReturnDefinition = new SuiteReturnDefinitionImpl();
    return suiteReturnDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public OperationDefinition createOperationDefinition()
  {
    OperationDefinitionImpl operationDefinition = new OperationDefinitionImpl();
    return operationDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public SuiteStatement createSuiteStatement()
  {
    SuiteStatementImpl suiteStatement = new SuiteStatementImpl();
    return suiteStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public SuiteStatementWithResult createSuiteStatementWithResult()
  {
    SuiteStatementWithResultImpl suiteStatementWithResult = new SuiteStatementWithResultImpl();
    return suiteStatementWithResult;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public VariableDefinition createVariableDefinition()
  {
    VariableDefinitionImpl variableDefinition = new VariableDefinitionImpl();
    return variableDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ConstantDefinition createConstantDefinition()
  {
    ConstantDefinitionImpl constantDefinition = new ConstantDefinitionImpl();
    return constantDefinition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public VariableAssignment createVariableAssignment()
  {
    VariableAssignmentImpl variableAssignment = new VariableAssignmentImpl();
    return variableAssignment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public VariantValue createVariantValue()
  {
    VariantValueImpl variantValue = new VariantValueImpl();
    return variantValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public VariableEntity createVariableEntity()
  {
    VariableEntityImpl variableEntity = new VariableEntityImpl();
    return variableEntity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ConstantEntity createConstantEntity()
  {
    ConstantEntityImpl constantEntity = new ConstantEntityImpl();
    return constantEntity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public VariableOrConstantEntity createVariableOrConstantEntity()
  {
    VariableOrConstantEntityImpl variableOrConstantEntity = new VariableOrConstantEntityImpl();
    return variableOrConstantEntity;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Test createTest()
  {
    TestImpl test = new TestImpl();
    return test;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TableTest createTableTest()
  {
    TableTestImpl tableTest = new TableTestImpl();
    return tableTest;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TableTestRow createTableTestRow()
  {
    TableTestRowImpl tableTestRow = new TableTestRowImpl();
    return tableTestRow;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ParameterTableHeader createParameterTableHeader()
  {
    ParameterTableHeaderImpl parameterTableHeader = new ParameterTableHeaderImpl();
    return parameterTableHeader;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ResultTableHeader createResultTableHeader()
  {
    ResultTableHeaderImpl resultTableHeader = new ResultTableHeaderImpl();
    return resultTableHeader;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ParameterTableValue createParameterTableValue()
  {
    ParameterTableValueImpl parameterTableValue = new ParameterTableValueImpl();
    return parameterTableValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NamedResult createNamedResult()
  {
    NamedResultImpl namedResult = new NamedResultImpl();
    return namedResult;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ResultName createResultName()
  {
    ResultNameImpl resultName = new ResultNameImpl();
    return resultName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public FixedResultName createFixedResultName()
  {
    FixedResultNameImpl fixedResultName = new FixedResultNameImpl();
    return fixedResultName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Call createCall()
  {
    CallImpl call = new CallImpl();
    return call;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NamedCallResult createNamedCallResult()
  {
    NamedCallResultImpl namedCallResult = new NamedCallResultImpl();
    return namedCallResult;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TimeSet createTimeSet()
  {
    TimeSetImpl timeSet = new TimeSetImpl();
    return timeSet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TimeProgressionFactor createTimeProgressionFactor()
  {
    TimeProgressionFactorImpl timeProgressionFactor = new TimeProgressionFactorImpl();
    return timeProgressionFactor;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TimeDifference createTimeDifference()
  {
    TimeDifferenceImpl timeDifference = new TimeDifferenceImpl();
    return timeDifference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Suite createSuite()
  {
    SuiteImpl suite = new SuiteImpl();
    return suite;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public SuiteParameter createSuiteParameter()
  {
    SuiteParameterImpl suiteParameter = new SuiteParameterImpl();
    return suiteParameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public SuiteReturn createSuiteReturn()
  {
    SuiteReturnImpl suiteReturn = new SuiteReturnImpl();
    return suiteReturn;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Parameter createParameter()
  {
    ParameterImpl parameter = new ParameterImpl();
    return parameter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ParameterName createParameterName()
  {
    ParameterNameImpl parameterName = new ParameterNameImpl();
    return parameterName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public FixedParameterName createFixedParameterName()
  {
    FixedParameterNameImpl fixedParameterName = new FixedParameterNameImpl();
    return fixedParameterName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ArbitraryParameterOrResultName createArbitraryParameterOrResultName()
  {
    ArbitraryParameterOrResultNameImpl arbitraryParameterOrResultName = new ArbitraryParameterOrResultNameImpl();
    return arbitraryParameterOrResultName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Operation createOperation()
  {
    OperationImpl operation = new OperationImpl();
    return operation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public StandardOperation createStandardOperation()
  {
    StandardOperationImpl standardOperation = new StandardOperationImpl();
    return standardOperation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public CustomOperation createCustomOperation()
  {
    CustomOperationImpl customOperation = new CustomOperationImpl();
    return customOperation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ValueOrEnumValueOrOperationCollection createValueOrEnumValueOrOperationCollection()
  {
    ValueOrEnumValueOrOperationCollectionImpl valueOrEnumValueOrOperationCollection = new ValueOrEnumValueOrOperationCollectionImpl();
    return valueOrEnumValueOrOperationCollection;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ValueOrEnumValueOrOperation createValueOrEnumValueOrOperation()
  {
    ValueOrEnumValueOrOperationImpl valueOrEnumValueOrOperation = new ValueOrEnumValueOrOperationImpl();
    return valueOrEnumValueOrOperation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Value createValue()
  {
    ValueImpl value = new ValueImpl();
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ConstantValue createConstantValue()
  {
    ConstantValueImpl constantValue = new ConstantValueImpl();
    return constantValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public StaticValue createStaticValue()
  {
    StaticValueImpl staticValue = new StaticValueImpl();
    return staticValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public IntegerValue createIntegerValue()
  {
    IntegerValueImpl integerValue = new IntegerValueImpl();
    return integerValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DecimalValue createDecimalValue()
  {
    DecimalValueImpl decimalValue = new DecimalValueImpl();
    return decimalValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public StringValue createStringValue()
  {
    StringValueImpl stringValue = new StringValueImpl();
    return stringValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public RegexValue createRegexValue()
  {
    RegexValueImpl regexValue = new RegexValueImpl();
    return regexValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public BooleanValue createBooleanValue()
  {
    BooleanValueImpl booleanValue = new BooleanValueImpl();
    return booleanValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DateValue createDateValue()
  {
    DateValueImpl dateValue = new DateValueImpl();
    return dateValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public IsoDateValue createIsoDateValue()
  {
    IsoDateValueImpl isoDateValue = new IsoDateValueImpl();
    return isoDateValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EuropeanDateValue createEuropeanDateValue()
  {
    EuropeanDateValueImpl europeanDateValue = new EuropeanDateValueImpl();
    return europeanDateValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public USDateValue createUSDateValue()
  {
    USDateValueImpl usDateValue = new USDateValueImpl();
    return usDateValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TimeValue createTimeValue()
  {
    TimeValueImpl timeValue = new TimeValueImpl();
    return timeValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public IsoTimeValue createIsoTimeValue()
  {
    IsoTimeValueImpl isoTimeValue = new IsoTimeValueImpl();
    return isoTimeValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Simple24HrsTimeValue createSimple24HrsTimeValue()
  {
    Simple24HrsTimeValueImpl simple24HrsTimeValue = new Simple24HrsTimeValueImpl();
    return simple24HrsTimeValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Simple12HrsTimeValue createSimple12HrsTimeValue()
  {
    Simple12HrsTimeValueImpl simple12HrsTimeValue = new Simple12HrsTimeValueImpl();
    return simple12HrsTimeValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DateAndTimeValue createDateAndTimeValue()
  {
    DateAndTimeValueImpl dateAndTimeValue = new DateAndTimeValueImpl();
    return dateAndTimeValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public IsoDateAndTimeValue createIsoDateAndTimeValue()
  {
    IsoDateAndTimeValueImpl isoDateAndTimeValue = new IsoDateAndTimeValueImpl();
    return isoDateAndTimeValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EuropeanDateAnd24HrsTimeValue createEuropeanDateAnd24HrsTimeValue()
  {
    EuropeanDateAnd24HrsTimeValueImpl europeanDateAnd24HrsTimeValue = new EuropeanDateAnd24HrsTimeValueImpl();
    return europeanDateAnd24HrsTimeValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EuropeanDateAnd12HrsTimeValue createEuropeanDateAnd12HrsTimeValue()
  {
    EuropeanDateAnd12HrsTimeValueImpl europeanDateAnd12HrsTimeValue = new EuropeanDateAnd12HrsTimeValueImpl();
    return europeanDateAnd12HrsTimeValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public USDateAnd12HrsTimeValue createUSDateAnd12HrsTimeValue()
  {
    USDateAnd12HrsTimeValueImpl usDateAnd12HrsTimeValue = new USDateAnd12HrsTimeValueImpl();
    return usDateAnd12HrsTimeValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public JavaConstantValue createJavaConstantValue()
  {
    JavaConstantValueImpl javaConstantValue = new JavaConstantValueImpl();
    return javaConstantValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Variable createVariable()
  {
    VariableImpl variable = new VariableImpl();
    return variable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public VariableVariable createVariableVariable()
  {
    VariableVariableImpl variableVariable = new VariableVariableImpl();
    return variableVariable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Constant createConstant()
  {
    ConstantImpl constant = new ConstantImpl();
    return constant;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NullValue createNullValue()
  {
    NullValueImpl nullValue = new NullValueImpl();
    return nullValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public InexistentValue createInexistentValue()
  {
    InexistentValueImpl inexistentValue = new InexistentValueImpl();
    return inexistentValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EmptyValue createEmptyValue()
  {
    EmptyValueImpl emptyValue = new EmptyValueImpl();
    return emptyValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EnumValue createEnumValue()
  {
    EnumValueImpl enumValue = new EnumValueImpl();
    return enumValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NestedObject createNestedObject()
  {
    NestedObjectImpl nestedObject = new NestedObjectImpl();
    return nestedObject;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public TypedNestedObject createTypedNestedObject()
  {
    TypedNestedObjectImpl typedNestedObject = new TypedNestedObjectImpl();
    return typedNestedObject;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public KeyValuePair createKeyValuePair()
  {
    KeyValuePairImpl keyValuePair = new KeyValuePairImpl();
    return keyValuePair;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public JavaClassReference createJavaClassReference()
  {
    JavaClassReferenceImpl javaClassReference = new JavaClassReferenceImpl();
    return javaClassReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public MethodReference createMethodReference()
  {
    MethodReferenceImpl methodReference = new MethodReferenceImpl();
    return methodReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public JavaConstantReference createJavaConstantReference()
  {
    JavaConstantReferenceImpl javaConstantReference = new JavaConstantReferenceImpl();
    return javaConstantReference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ExecutionMultiplier createExecutionMultiplier()
  {
    ExecutionMultiplierImpl executionMultiplier = new ExecutionMultiplierImpl();
    return executionMultiplier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DocumentationComment createDocumentationComment()
  {
    DocumentationCommentImpl documentationComment = new DocumentationCommentImpl();
    return documentationComment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Null createNull()
  {
    NullImpl null_ = new NullImpl();
    return null_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Inexistent createInexistent()
  {
    InexistentImpl inexistent = new InexistentImpl();
    return inexistent;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Empty createEmpty()
  {
    EmptyImpl empty = new EmptyImpl();
    return empty;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public DslPackage getDslPackage()
  {
    return (DslPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static DslPackage getPackage()
  {
    return DslPackage.eINSTANCE;
  }

} //DslFactoryImpl
