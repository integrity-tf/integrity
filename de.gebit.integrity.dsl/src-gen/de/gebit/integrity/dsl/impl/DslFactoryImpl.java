/**
 * <copyright>
 * </copyright>
 *

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
      DslFactory theDslFactory = (DslFactory)EPackage.Registry.INSTANCE.getEFactory("http://integrity.dsl"); 
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
      case DslPackage.VISIBLE_SINGLE_LINE_COMMENT: return createVisibleSingleLineComment();
      case DslPackage.VISIBLE_MULTI_LINE_COMMENT: return createVisibleMultiLineComment();
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
      case DslPackage.OPERATION_DEFINITION: return createOperationDefinition();
      case DslPackage.SUITE_STATEMENT: return createSuiteStatement();
      case DslPackage.SUITE_STATEMENT_WITH_RESULT: return createSuiteStatementWithResult();
      case DslPackage.VARIABLE_DEFINITION: return createVariableDefinition();
      case DslPackage.CONSTANT_DEFINITION: return createConstantDefinition();
      case DslPackage.VARIANT_VALUE: return createVariantValue();
      case DslPackage.VARIABLE_ENTITY: return createVariableEntity();
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
      case DslPackage.SUITE: return createSuite();
      case DslPackage.SUITE_PARAMETER: return createSuiteParameter();
      case DslPackage.PARAMETER: return createParameter();
      case DslPackage.PARAMETER_NAME: return createParameterName();
      case DslPackage.FIXED_PARAMETER_NAME: return createFixedParameterName();
      case DslPackage.ARBITRARY_PARAMETER_OR_RESULT_NAME: return createArbitraryParameterOrResultName();
      case DslPackage.OPERATION: return createOperation();
      case DslPackage.VALUE_OR_ENUM_VALUE_OR_OPERATION_COLLECTION: return createValueOrEnumValueOrOperationCollection();
      case DslPackage.VALUE_OR_ENUM_VALUE_OR_OPERATION: return createValueOrEnumValueOrOperation();
      case DslPackage.VALUE: return createValue();
      case DslPackage.STATIC_VALUE: return createStaticValue();
      case DslPackage.INTEGER_VALUE: return createIntegerValue();
      case DslPackage.DECIMAL_VALUE: return createDecimalValue();
      case DslPackage.STRING_VALUE: return createStringValue();
      case DslPackage.BOOLEAN_VALUE: return createBooleanValue();
      case DslPackage.VARIABLE: return createVariable();
      case DslPackage.NULL_VALUE: return createNullValue();
      case DslPackage.ENUM_VALUE: return createEnumValue();
      case DslPackage.JAVA_CLASS_REFERENCE: return createJavaClassReference();
      case DslPackage.METHOD_REFERENCE: return createMethodReference();
      case DslPackage.EXECUTION_MULTIPLIER: return createExecutionMultiplier();
      case DslPackage.NULL: return createNull();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
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
