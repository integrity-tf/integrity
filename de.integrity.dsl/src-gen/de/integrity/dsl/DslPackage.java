/**
 * <copyright>
 * </copyright>
 *

 */
package de.integrity.dsl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.integrity.dsl.DslFactory
 * @model kind="package"
 * @generated
 */
public interface DslPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "dsl";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://integrity.dsl";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "dsl";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  DslPackage eINSTANCE = de.integrity.dsl.impl.DslPackageImpl.init();

  /**
   * The meta object id for the '{@link de.integrity.dsl.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.integrity.dsl.impl.ModelImpl
   * @see de.integrity.dsl.impl.DslPackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Statements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__STATEMENTS = 0;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link de.integrity.dsl.impl.StatementImpl <em>Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.integrity.dsl.impl.StatementImpl
   * @see de.integrity.dsl.impl.DslPackageImpl#getStatement()
   * @generated
   */
  int STATEMENT = 1;

  /**
   * The number of structural features of the '<em>Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link de.integrity.dsl.impl.PackageDefinitionImpl <em>Package Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.integrity.dsl.impl.PackageDefinitionImpl
   * @see de.integrity.dsl.impl.DslPackageImpl#getPackageDefinition()
   * @generated
   */
  int PACKAGE_DEFINITION = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACKAGE_DEFINITION__NAME = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Statements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACKAGE_DEFINITION__STATEMENTS = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Package Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACKAGE_DEFINITION_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link de.integrity.dsl.impl.PackageStatementImpl <em>Package Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.integrity.dsl.impl.PackageStatementImpl
   * @see de.integrity.dsl.impl.DslPackageImpl#getPackageStatement()
   * @generated
   */
  int PACKAGE_STATEMENT = 3;

  /**
   * The number of structural features of the '<em>Package Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACKAGE_STATEMENT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link de.integrity.dsl.impl.ImportImpl <em>Import</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.integrity.dsl.impl.ImportImpl
   * @see de.integrity.dsl.impl.DslPackageImpl#getImport()
   * @generated
   */
  int IMPORT = 4;

  /**
   * The feature id for the '<em><b>Imported Namespace</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT__IMPORTED_NAMESPACE = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Import</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPORT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.integrity.dsl.impl.TestDefinitionImpl <em>Test Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.integrity.dsl.impl.TestDefinitionImpl
   * @see de.integrity.dsl.impl.DslPackageImpl#getTestDefinition()
   * @generated
   */
  int TEST_DEFINITION = 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEST_DEFINITION__NAME = PACKAGE_STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Fixture Method</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEST_DEFINITION__FIXTURE_METHOD = PACKAGE_STATEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Test Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEST_DEFINITION_FEATURE_COUNT = PACKAGE_STATEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link de.integrity.dsl.impl.CallDefinitionImpl <em>Call Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.integrity.dsl.impl.CallDefinitionImpl
   * @see de.integrity.dsl.impl.DslPackageImpl#getCallDefinition()
   * @generated
   */
  int CALL_DEFINITION = 6;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CALL_DEFINITION__NAME = PACKAGE_STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Fixture Method</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CALL_DEFINITION__FIXTURE_METHOD = PACKAGE_STATEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Call Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CALL_DEFINITION_FEATURE_COUNT = PACKAGE_STATEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link de.integrity.dsl.impl.SuiteDefinitionImpl <em>Suite Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.integrity.dsl.impl.SuiteDefinitionImpl
   * @see de.integrity.dsl.impl.DslPackageImpl#getSuiteDefinition()
   * @generated
   */
  int SUITE_DEFINITION = 7;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUITE_DEFINITION__NAME = PACKAGE_STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUITE_DEFINITION__PARAMETERS = PACKAGE_STATEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Dependencies</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUITE_DEFINITION__DEPENDENCIES = PACKAGE_STATEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Statements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUITE_DEFINITION__STATEMENTS = PACKAGE_STATEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Finalizers</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUITE_DEFINITION__FINALIZERS = PACKAGE_STATEMENT_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Suite Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUITE_DEFINITION_FEATURE_COUNT = PACKAGE_STATEMENT_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link de.integrity.dsl.impl.SuiteStatementImpl <em>Suite Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.integrity.dsl.impl.SuiteStatementImpl
   * @see de.integrity.dsl.impl.DslPackageImpl#getSuiteStatement()
   * @generated
   */
  int SUITE_STATEMENT = 8;

  /**
   * The number of structural features of the '<em>Suite Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUITE_STATEMENT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link de.integrity.dsl.impl.SuiteStatementWithResultImpl <em>Suite Statement With Result</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.integrity.dsl.impl.SuiteStatementWithResultImpl
   * @see de.integrity.dsl.impl.DslPackageImpl#getSuiteStatementWithResult()
   * @generated
   */
  int SUITE_STATEMENT_WITH_RESULT = 9;

  /**
   * The number of structural features of the '<em>Suite Statement With Result</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUITE_STATEMENT_WITH_RESULT_FEATURE_COUNT = SUITE_STATEMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link de.integrity.dsl.impl.VariableDefinitionImpl <em>Variable Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.integrity.dsl.impl.VariableDefinitionImpl
   * @see de.integrity.dsl.impl.DslPackageImpl#getVariableDefinition()
   * @generated
   */
  int VARIABLE_DEFINITION = 10;

  /**
   * The feature id for the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DEFINITION__NAME = PACKAGE_STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Initial Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DEFINITION__INITIAL_VALUE = PACKAGE_STATEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Variable Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DEFINITION_FEATURE_COUNT = PACKAGE_STATEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link de.integrity.dsl.impl.VariableEntityImpl <em>Variable Entity</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.integrity.dsl.impl.VariableEntityImpl
   * @see de.integrity.dsl.impl.DslPackageImpl#getVariableEntity()
   * @generated
   */
  int VARIABLE_ENTITY = 11;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_ENTITY__NAME = 0;

  /**
   * The number of structural features of the '<em>Variable Entity</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_ENTITY_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link de.integrity.dsl.impl.TestImpl <em>Test</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.integrity.dsl.impl.TestImpl
   * @see de.integrity.dsl.impl.DslPackageImpl#getTest()
   * @generated
   */
  int TEST = 12;

  /**
   * The feature id for the '<em><b>Definition</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEST__DEFINITION = SUITE_STATEMENT_WITH_RESULT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEST__PARAMETERS = SUITE_STATEMENT_WITH_RESULT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Result</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEST__RESULT = SUITE_STATEMENT_WITH_RESULT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Test</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEST_FEATURE_COUNT = SUITE_STATEMENT_WITH_RESULT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link de.integrity.dsl.impl.CallImpl <em>Call</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.integrity.dsl.impl.CallImpl
   * @see de.integrity.dsl.impl.DslPackageImpl#getCall()
   * @generated
   */
  int CALL = 13;

  /**
   * The feature id for the '<em><b>Definition</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CALL__DEFINITION = SUITE_STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CALL__PARAMETERS = SUITE_STATEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Result</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CALL__RESULT = SUITE_STATEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Call</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CALL_FEATURE_COUNT = SUITE_STATEMENT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link de.integrity.dsl.impl.SuiteImpl <em>Suite</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.integrity.dsl.impl.SuiteImpl
   * @see de.integrity.dsl.impl.DslPackageImpl#getSuite()
   * @generated
   */
  int SUITE = 14;

  /**
   * The feature id for the '<em><b>Definition</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUITE__DEFINITION = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUITE__PARAMETERS = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Suite</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUITE_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link de.integrity.dsl.impl.SuiteParameterImpl <em>Suite Parameter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.integrity.dsl.impl.SuiteParameterImpl
   * @see de.integrity.dsl.impl.DslPackageImpl#getSuiteParameter()
   * @generated
   */
  int SUITE_PARAMETER = 15;

  /**
   * The feature id for the '<em><b>Name</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUITE_PARAMETER__NAME = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUITE_PARAMETER__VALUE = 1;

  /**
   * The number of structural features of the '<em>Suite Parameter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUITE_PARAMETER_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.integrity.dsl.impl.ParameterImpl <em>Parameter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.integrity.dsl.impl.ParameterImpl
   * @see de.integrity.dsl.impl.DslPackageImpl#getParameter()
   * @generated
   */
  int PARAMETER = 16;

  /**
   * The feature id for the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER__NAME = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER__VALUE = 1;

  /**
   * The number of structural features of the '<em>Parameter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.integrity.dsl.impl.ParameterNameImpl <em>Parameter Name</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.integrity.dsl.impl.ParameterNameImpl
   * @see de.integrity.dsl.impl.DslPackageImpl#getParameterName()
   * @generated
   */
  int PARAMETER_NAME = 17;

  /**
   * The number of structural features of the '<em>Parameter Name</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_NAME_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link de.integrity.dsl.impl.FixedParameterNameImpl <em>Fixed Parameter Name</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.integrity.dsl.impl.FixedParameterNameImpl
   * @see de.integrity.dsl.impl.DslPackageImpl#getFixedParameterName()
   * @generated
   */
  int FIXED_PARAMETER_NAME = 18;

  /**
   * The feature id for the '<em><b>Annotation</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIXED_PARAMETER_NAME__ANNOTATION = PARAMETER_NAME_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Fixed Parameter Name</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIXED_PARAMETER_NAME_FEATURE_COUNT = PARAMETER_NAME_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.integrity.dsl.impl.ArbitraryParameterNameImpl <em>Arbitrary Parameter Name</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.integrity.dsl.impl.ArbitraryParameterNameImpl
   * @see de.integrity.dsl.impl.DslPackageImpl#getArbitraryParameterName()
   * @generated
   */
  int ARBITRARY_PARAMETER_NAME = 19;

  /**
   * The feature id for the '<em><b>Identifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARBITRARY_PARAMETER_NAME__IDENTIFIER = PARAMETER_NAME_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Arbitrary Parameter Name</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARBITRARY_PARAMETER_NAME_FEATURE_COUNT = PARAMETER_NAME_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.integrity.dsl.impl.ValueOrEnumValueImpl <em>Value Or Enum Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.integrity.dsl.impl.ValueOrEnumValueImpl
   * @see de.integrity.dsl.impl.DslPackageImpl#getValueOrEnumValue()
   * @generated
   */
  int VALUE_OR_ENUM_VALUE = 20;

  /**
   * The number of structural features of the '<em>Value Or Enum Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_OR_ENUM_VALUE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link de.integrity.dsl.impl.ValueImpl <em>Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.integrity.dsl.impl.ValueImpl
   * @see de.integrity.dsl.impl.DslPackageImpl#getValue()
   * @generated
   */
  int VALUE = 21;

  /**
   * The number of structural features of the '<em>Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_FEATURE_COUNT = VALUE_OR_ENUM_VALUE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link de.integrity.dsl.impl.IntegerValueImpl <em>Integer Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.integrity.dsl.impl.IntegerValueImpl
   * @see de.integrity.dsl.impl.DslPackageImpl#getIntegerValue()
   * @generated
   */
  int INTEGER_VALUE = 22;

  /**
   * The feature id for the '<em><b>Integer Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTEGER_VALUE__INTEGER_VALUE = VALUE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Integer Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTEGER_VALUE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.integrity.dsl.impl.DecimalValueImpl <em>Decimal Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.integrity.dsl.impl.DecimalValueImpl
   * @see de.integrity.dsl.impl.DslPackageImpl#getDecimalValue()
   * @generated
   */
  int DECIMAL_VALUE = 23;

  /**
   * The feature id for the '<em><b>Decimal Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECIMAL_VALUE__DECIMAL_VALUE = VALUE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Decimal Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECIMAL_VALUE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.integrity.dsl.impl.StringValueImpl <em>String Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.integrity.dsl.impl.StringValueImpl
   * @see de.integrity.dsl.impl.DslPackageImpl#getStringValue()
   * @generated
   */
  int STRING_VALUE = 24;

  /**
   * The feature id for the '<em><b>String Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_VALUE__STRING_VALUE = VALUE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>String Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_VALUE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.integrity.dsl.impl.VariableImpl <em>Variable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.integrity.dsl.impl.VariableImpl
   * @see de.integrity.dsl.impl.DslPackageImpl#getVariable()
   * @generated
   */
  int VARIABLE = 25;

  /**
   * The feature id for the '<em><b>Name</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE__NAME = VALUE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Variable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.integrity.dsl.impl.EnumValueImpl <em>Enum Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.integrity.dsl.impl.EnumValueImpl
   * @see de.integrity.dsl.impl.DslPackageImpl#getEnumValue()
   * @generated
   */
  int ENUM_VALUE = 26;

  /**
   * The feature id for the '<em><b>Enum Value</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_VALUE__ENUM_VALUE = VALUE_OR_ENUM_VALUE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Enum Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_VALUE_FEATURE_COUNT = VALUE_OR_ENUM_VALUE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.integrity.dsl.impl.MethodReferenceImpl <em>Method Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.integrity.dsl.impl.MethodReferenceImpl
   * @see de.integrity.dsl.impl.DslPackageImpl#getMethodReference()
   * @generated
   */
  int METHOD_REFERENCE = 27;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD_REFERENCE__TYPE = 0;

  /**
   * The feature id for the '<em><b>Method</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD_REFERENCE__METHOD = 1;

  /**
   * The number of structural features of the '<em>Method Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD_REFERENCE_FEATURE_COUNT = 2;


  /**
   * Returns the meta object for class '{@link de.integrity.dsl.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see de.integrity.dsl.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the containment reference list '{@link de.integrity.dsl.Model#getStatements <em>Statements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Statements</em>'.
   * @see de.integrity.dsl.Model#getStatements()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Statements();

  /**
   * Returns the meta object for class '{@link de.integrity.dsl.Statement <em>Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Statement</em>'.
   * @see de.integrity.dsl.Statement
   * @generated
   */
  EClass getStatement();

  /**
   * Returns the meta object for class '{@link de.integrity.dsl.PackageDefinition <em>Package Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Package Definition</em>'.
   * @see de.integrity.dsl.PackageDefinition
   * @generated
   */
  EClass getPackageDefinition();

  /**
   * Returns the meta object for the attribute '{@link de.integrity.dsl.PackageDefinition#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.integrity.dsl.PackageDefinition#getName()
   * @see #getPackageDefinition()
   * @generated
   */
  EAttribute getPackageDefinition_Name();

  /**
   * Returns the meta object for the containment reference list '{@link de.integrity.dsl.PackageDefinition#getStatements <em>Statements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Statements</em>'.
   * @see de.integrity.dsl.PackageDefinition#getStatements()
   * @see #getPackageDefinition()
   * @generated
   */
  EReference getPackageDefinition_Statements();

  /**
   * Returns the meta object for class '{@link de.integrity.dsl.PackageStatement <em>Package Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Package Statement</em>'.
   * @see de.integrity.dsl.PackageStatement
   * @generated
   */
  EClass getPackageStatement();

  /**
   * Returns the meta object for class '{@link de.integrity.dsl.Import <em>Import</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Import</em>'.
   * @see de.integrity.dsl.Import
   * @generated
   */
  EClass getImport();

  /**
   * Returns the meta object for the attribute '{@link de.integrity.dsl.Import#getImportedNamespace <em>Imported Namespace</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Imported Namespace</em>'.
   * @see de.integrity.dsl.Import#getImportedNamespace()
   * @see #getImport()
   * @generated
   */
  EAttribute getImport_ImportedNamespace();

  /**
   * Returns the meta object for class '{@link de.integrity.dsl.TestDefinition <em>Test Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Test Definition</em>'.
   * @see de.integrity.dsl.TestDefinition
   * @generated
   */
  EClass getTestDefinition();

  /**
   * Returns the meta object for the attribute '{@link de.integrity.dsl.TestDefinition#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.integrity.dsl.TestDefinition#getName()
   * @see #getTestDefinition()
   * @generated
   */
  EAttribute getTestDefinition_Name();

  /**
   * Returns the meta object for the containment reference '{@link de.integrity.dsl.TestDefinition#getFixtureMethod <em>Fixture Method</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Fixture Method</em>'.
   * @see de.integrity.dsl.TestDefinition#getFixtureMethod()
   * @see #getTestDefinition()
   * @generated
   */
  EReference getTestDefinition_FixtureMethod();

  /**
   * Returns the meta object for class '{@link de.integrity.dsl.CallDefinition <em>Call Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Call Definition</em>'.
   * @see de.integrity.dsl.CallDefinition
   * @generated
   */
  EClass getCallDefinition();

  /**
   * Returns the meta object for the attribute '{@link de.integrity.dsl.CallDefinition#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.integrity.dsl.CallDefinition#getName()
   * @see #getCallDefinition()
   * @generated
   */
  EAttribute getCallDefinition_Name();

  /**
   * Returns the meta object for the containment reference '{@link de.integrity.dsl.CallDefinition#getFixtureMethod <em>Fixture Method</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Fixture Method</em>'.
   * @see de.integrity.dsl.CallDefinition#getFixtureMethod()
   * @see #getCallDefinition()
   * @generated
   */
  EReference getCallDefinition_FixtureMethod();

  /**
   * Returns the meta object for class '{@link de.integrity.dsl.SuiteDefinition <em>Suite Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Suite Definition</em>'.
   * @see de.integrity.dsl.SuiteDefinition
   * @generated
   */
  EClass getSuiteDefinition();

  /**
   * Returns the meta object for the attribute '{@link de.integrity.dsl.SuiteDefinition#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.integrity.dsl.SuiteDefinition#getName()
   * @see #getSuiteDefinition()
   * @generated
   */
  EAttribute getSuiteDefinition_Name();

  /**
   * Returns the meta object for the containment reference list '{@link de.integrity.dsl.SuiteDefinition#getParameters <em>Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameters</em>'.
   * @see de.integrity.dsl.SuiteDefinition#getParameters()
   * @see #getSuiteDefinition()
   * @generated
   */
  EReference getSuiteDefinition_Parameters();

  /**
   * Returns the meta object for the reference list '{@link de.integrity.dsl.SuiteDefinition#getDependencies <em>Dependencies</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Dependencies</em>'.
   * @see de.integrity.dsl.SuiteDefinition#getDependencies()
   * @see #getSuiteDefinition()
   * @generated
   */
  EReference getSuiteDefinition_Dependencies();

  /**
   * Returns the meta object for the containment reference list '{@link de.integrity.dsl.SuiteDefinition#getStatements <em>Statements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Statements</em>'.
   * @see de.integrity.dsl.SuiteDefinition#getStatements()
   * @see #getSuiteDefinition()
   * @generated
   */
  EReference getSuiteDefinition_Statements();

  /**
   * Returns the meta object for the reference list '{@link de.integrity.dsl.SuiteDefinition#getFinalizers <em>Finalizers</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Finalizers</em>'.
   * @see de.integrity.dsl.SuiteDefinition#getFinalizers()
   * @see #getSuiteDefinition()
   * @generated
   */
  EReference getSuiteDefinition_Finalizers();

  /**
   * Returns the meta object for class '{@link de.integrity.dsl.SuiteStatement <em>Suite Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Suite Statement</em>'.
   * @see de.integrity.dsl.SuiteStatement
   * @generated
   */
  EClass getSuiteStatement();

  /**
   * Returns the meta object for class '{@link de.integrity.dsl.SuiteStatementWithResult <em>Suite Statement With Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Suite Statement With Result</em>'.
   * @see de.integrity.dsl.SuiteStatementWithResult
   * @generated
   */
  EClass getSuiteStatementWithResult();

  /**
   * Returns the meta object for class '{@link de.integrity.dsl.VariableDefinition <em>Variable Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Variable Definition</em>'.
   * @see de.integrity.dsl.VariableDefinition
   * @generated
   */
  EClass getVariableDefinition();

  /**
   * Returns the meta object for the containment reference '{@link de.integrity.dsl.VariableDefinition#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name</em>'.
   * @see de.integrity.dsl.VariableDefinition#getName()
   * @see #getVariableDefinition()
   * @generated
   */
  EReference getVariableDefinition_Name();

  /**
   * Returns the meta object for the containment reference '{@link de.integrity.dsl.VariableDefinition#getInitialValue <em>Initial Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Initial Value</em>'.
   * @see de.integrity.dsl.VariableDefinition#getInitialValue()
   * @see #getVariableDefinition()
   * @generated
   */
  EReference getVariableDefinition_InitialValue();

  /**
   * Returns the meta object for class '{@link de.integrity.dsl.VariableEntity <em>Variable Entity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Variable Entity</em>'.
   * @see de.integrity.dsl.VariableEntity
   * @generated
   */
  EClass getVariableEntity();

  /**
   * Returns the meta object for the attribute '{@link de.integrity.dsl.VariableEntity#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.integrity.dsl.VariableEntity#getName()
   * @see #getVariableEntity()
   * @generated
   */
  EAttribute getVariableEntity_Name();

  /**
   * Returns the meta object for class '{@link de.integrity.dsl.Test <em>Test</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Test</em>'.
   * @see de.integrity.dsl.Test
   * @generated
   */
  EClass getTest();

  /**
   * Returns the meta object for the reference '{@link de.integrity.dsl.Test#getDefinition <em>Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Definition</em>'.
   * @see de.integrity.dsl.Test#getDefinition()
   * @see #getTest()
   * @generated
   */
  EReference getTest_Definition();

  /**
   * Returns the meta object for the containment reference list '{@link de.integrity.dsl.Test#getParameters <em>Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameters</em>'.
   * @see de.integrity.dsl.Test#getParameters()
   * @see #getTest()
   * @generated
   */
  EReference getTest_Parameters();

  /**
   * Returns the meta object for the containment reference '{@link de.integrity.dsl.Test#getResult <em>Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Result</em>'.
   * @see de.integrity.dsl.Test#getResult()
   * @see #getTest()
   * @generated
   */
  EReference getTest_Result();

  /**
   * Returns the meta object for class '{@link de.integrity.dsl.Call <em>Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Call</em>'.
   * @see de.integrity.dsl.Call
   * @generated
   */
  EClass getCall();

  /**
   * Returns the meta object for the reference '{@link de.integrity.dsl.Call#getDefinition <em>Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Definition</em>'.
   * @see de.integrity.dsl.Call#getDefinition()
   * @see #getCall()
   * @generated
   */
  EReference getCall_Definition();

  /**
   * Returns the meta object for the containment reference list '{@link de.integrity.dsl.Call#getParameters <em>Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameters</em>'.
   * @see de.integrity.dsl.Call#getParameters()
   * @see #getCall()
   * @generated
   */
  EReference getCall_Parameters();

  /**
   * Returns the meta object for the containment reference '{@link de.integrity.dsl.Call#getResult <em>Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Result</em>'.
   * @see de.integrity.dsl.Call#getResult()
   * @see #getCall()
   * @generated
   */
  EReference getCall_Result();

  /**
   * Returns the meta object for class '{@link de.integrity.dsl.Suite <em>Suite</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Suite</em>'.
   * @see de.integrity.dsl.Suite
   * @generated
   */
  EClass getSuite();

  /**
   * Returns the meta object for the reference '{@link de.integrity.dsl.Suite#getDefinition <em>Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Definition</em>'.
   * @see de.integrity.dsl.Suite#getDefinition()
   * @see #getSuite()
   * @generated
   */
  EReference getSuite_Definition();

  /**
   * Returns the meta object for the containment reference list '{@link de.integrity.dsl.Suite#getParameters <em>Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameters</em>'.
   * @see de.integrity.dsl.Suite#getParameters()
   * @see #getSuite()
   * @generated
   */
  EReference getSuite_Parameters();

  /**
   * Returns the meta object for class '{@link de.integrity.dsl.SuiteParameter <em>Suite Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Suite Parameter</em>'.
   * @see de.integrity.dsl.SuiteParameter
   * @generated
   */
  EClass getSuiteParameter();

  /**
   * Returns the meta object for the reference '{@link de.integrity.dsl.SuiteParameter#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Name</em>'.
   * @see de.integrity.dsl.SuiteParameter#getName()
   * @see #getSuiteParameter()
   * @generated
   */
  EReference getSuiteParameter_Name();

  /**
   * Returns the meta object for the containment reference '{@link de.integrity.dsl.SuiteParameter#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see de.integrity.dsl.SuiteParameter#getValue()
   * @see #getSuiteParameter()
   * @generated
   */
  EReference getSuiteParameter_Value();

  /**
   * Returns the meta object for class '{@link de.integrity.dsl.Parameter <em>Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parameter</em>'.
   * @see de.integrity.dsl.Parameter
   * @generated
   */
  EClass getParameter();

  /**
   * Returns the meta object for the containment reference '{@link de.integrity.dsl.Parameter#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name</em>'.
   * @see de.integrity.dsl.Parameter#getName()
   * @see #getParameter()
   * @generated
   */
  EReference getParameter_Name();

  /**
   * Returns the meta object for the containment reference '{@link de.integrity.dsl.Parameter#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see de.integrity.dsl.Parameter#getValue()
   * @see #getParameter()
   * @generated
   */
  EReference getParameter_Value();

  /**
   * Returns the meta object for class '{@link de.integrity.dsl.ParameterName <em>Parameter Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parameter Name</em>'.
   * @see de.integrity.dsl.ParameterName
   * @generated
   */
  EClass getParameterName();

  /**
   * Returns the meta object for class '{@link de.integrity.dsl.FixedParameterName <em>Fixed Parameter Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Fixed Parameter Name</em>'.
   * @see de.integrity.dsl.FixedParameterName
   * @generated
   */
  EClass getFixedParameterName();

  /**
   * Returns the meta object for the reference '{@link de.integrity.dsl.FixedParameterName#getAnnotation <em>Annotation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Annotation</em>'.
   * @see de.integrity.dsl.FixedParameterName#getAnnotation()
   * @see #getFixedParameterName()
   * @generated
   */
  EReference getFixedParameterName_Annotation();

  /**
   * Returns the meta object for class '{@link de.integrity.dsl.ArbitraryParameterName <em>Arbitrary Parameter Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Arbitrary Parameter Name</em>'.
   * @see de.integrity.dsl.ArbitraryParameterName
   * @generated
   */
  EClass getArbitraryParameterName();

  /**
   * Returns the meta object for the attribute '{@link de.integrity.dsl.ArbitraryParameterName#getIdentifier <em>Identifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Identifier</em>'.
   * @see de.integrity.dsl.ArbitraryParameterName#getIdentifier()
   * @see #getArbitraryParameterName()
   * @generated
   */
  EAttribute getArbitraryParameterName_Identifier();

  /**
   * Returns the meta object for class '{@link de.integrity.dsl.ValueOrEnumValue <em>Value Or Enum Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Value Or Enum Value</em>'.
   * @see de.integrity.dsl.ValueOrEnumValue
   * @generated
   */
  EClass getValueOrEnumValue();

  /**
   * Returns the meta object for class '{@link de.integrity.dsl.Value <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Value</em>'.
   * @see de.integrity.dsl.Value
   * @generated
   */
  EClass getValue();

  /**
   * Returns the meta object for class '{@link de.integrity.dsl.IntegerValue <em>Integer Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Integer Value</em>'.
   * @see de.integrity.dsl.IntegerValue
   * @generated
   */
  EClass getIntegerValue();

  /**
   * Returns the meta object for the attribute '{@link de.integrity.dsl.IntegerValue#getIntegerValue <em>Integer Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Integer Value</em>'.
   * @see de.integrity.dsl.IntegerValue#getIntegerValue()
   * @see #getIntegerValue()
   * @generated
   */
  EAttribute getIntegerValue_IntegerValue();

  /**
   * Returns the meta object for class '{@link de.integrity.dsl.DecimalValue <em>Decimal Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Decimal Value</em>'.
   * @see de.integrity.dsl.DecimalValue
   * @generated
   */
  EClass getDecimalValue();

  /**
   * Returns the meta object for the attribute '{@link de.integrity.dsl.DecimalValue#getDecimalValue <em>Decimal Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Decimal Value</em>'.
   * @see de.integrity.dsl.DecimalValue#getDecimalValue()
   * @see #getDecimalValue()
   * @generated
   */
  EAttribute getDecimalValue_DecimalValue();

  /**
   * Returns the meta object for class '{@link de.integrity.dsl.StringValue <em>String Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>String Value</em>'.
   * @see de.integrity.dsl.StringValue
   * @generated
   */
  EClass getStringValue();

  /**
   * Returns the meta object for the attribute '{@link de.integrity.dsl.StringValue#getStringValue <em>String Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>String Value</em>'.
   * @see de.integrity.dsl.StringValue#getStringValue()
   * @see #getStringValue()
   * @generated
   */
  EAttribute getStringValue_StringValue();

  /**
   * Returns the meta object for class '{@link de.integrity.dsl.Variable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Variable</em>'.
   * @see de.integrity.dsl.Variable
   * @generated
   */
  EClass getVariable();

  /**
   * Returns the meta object for the reference '{@link de.integrity.dsl.Variable#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Name</em>'.
   * @see de.integrity.dsl.Variable#getName()
   * @see #getVariable()
   * @generated
   */
  EReference getVariable_Name();

  /**
   * Returns the meta object for class '{@link de.integrity.dsl.EnumValue <em>Enum Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Enum Value</em>'.
   * @see de.integrity.dsl.EnumValue
   * @generated
   */
  EClass getEnumValue();

  /**
   * Returns the meta object for the reference '{@link de.integrity.dsl.EnumValue#getEnumValue <em>Enum Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Enum Value</em>'.
   * @see de.integrity.dsl.EnumValue#getEnumValue()
   * @see #getEnumValue()
   * @generated
   */
  EReference getEnumValue_EnumValue();

  /**
   * Returns the meta object for class '{@link de.integrity.dsl.MethodReference <em>Method Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Method Reference</em>'.
   * @see de.integrity.dsl.MethodReference
   * @generated
   */
  EClass getMethodReference();

  /**
   * Returns the meta object for the reference '{@link de.integrity.dsl.MethodReference#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see de.integrity.dsl.MethodReference#getType()
   * @see #getMethodReference()
   * @generated
   */
  EReference getMethodReference_Type();

  /**
   * Returns the meta object for the reference '{@link de.integrity.dsl.MethodReference#getMethod <em>Method</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Method</em>'.
   * @see de.integrity.dsl.MethodReference#getMethod()
   * @see #getMethodReference()
   * @generated
   */
  EReference getMethodReference_Method();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  DslFactory getDslFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link de.integrity.dsl.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.integrity.dsl.impl.ModelImpl
     * @see de.integrity.dsl.impl.DslPackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Statements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__STATEMENTS = eINSTANCE.getModel_Statements();

    /**
     * The meta object literal for the '{@link de.integrity.dsl.impl.StatementImpl <em>Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.integrity.dsl.impl.StatementImpl
     * @see de.integrity.dsl.impl.DslPackageImpl#getStatement()
     * @generated
     */
    EClass STATEMENT = eINSTANCE.getStatement();

    /**
     * The meta object literal for the '{@link de.integrity.dsl.impl.PackageDefinitionImpl <em>Package Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.integrity.dsl.impl.PackageDefinitionImpl
     * @see de.integrity.dsl.impl.DslPackageImpl#getPackageDefinition()
     * @generated
     */
    EClass PACKAGE_DEFINITION = eINSTANCE.getPackageDefinition();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PACKAGE_DEFINITION__NAME = eINSTANCE.getPackageDefinition_Name();

    /**
     * The meta object literal for the '<em><b>Statements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PACKAGE_DEFINITION__STATEMENTS = eINSTANCE.getPackageDefinition_Statements();

    /**
     * The meta object literal for the '{@link de.integrity.dsl.impl.PackageStatementImpl <em>Package Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.integrity.dsl.impl.PackageStatementImpl
     * @see de.integrity.dsl.impl.DslPackageImpl#getPackageStatement()
     * @generated
     */
    EClass PACKAGE_STATEMENT = eINSTANCE.getPackageStatement();

    /**
     * The meta object literal for the '{@link de.integrity.dsl.impl.ImportImpl <em>Import</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.integrity.dsl.impl.ImportImpl
     * @see de.integrity.dsl.impl.DslPackageImpl#getImport()
     * @generated
     */
    EClass IMPORT = eINSTANCE.getImport();

    /**
     * The meta object literal for the '<em><b>Imported Namespace</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute IMPORT__IMPORTED_NAMESPACE = eINSTANCE.getImport_ImportedNamespace();

    /**
     * The meta object literal for the '{@link de.integrity.dsl.impl.TestDefinitionImpl <em>Test Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.integrity.dsl.impl.TestDefinitionImpl
     * @see de.integrity.dsl.impl.DslPackageImpl#getTestDefinition()
     * @generated
     */
    EClass TEST_DEFINITION = eINSTANCE.getTestDefinition();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TEST_DEFINITION__NAME = eINSTANCE.getTestDefinition_Name();

    /**
     * The meta object literal for the '<em><b>Fixture Method</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TEST_DEFINITION__FIXTURE_METHOD = eINSTANCE.getTestDefinition_FixtureMethod();

    /**
     * The meta object literal for the '{@link de.integrity.dsl.impl.CallDefinitionImpl <em>Call Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.integrity.dsl.impl.CallDefinitionImpl
     * @see de.integrity.dsl.impl.DslPackageImpl#getCallDefinition()
     * @generated
     */
    EClass CALL_DEFINITION = eINSTANCE.getCallDefinition();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CALL_DEFINITION__NAME = eINSTANCE.getCallDefinition_Name();

    /**
     * The meta object literal for the '<em><b>Fixture Method</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CALL_DEFINITION__FIXTURE_METHOD = eINSTANCE.getCallDefinition_FixtureMethod();

    /**
     * The meta object literal for the '{@link de.integrity.dsl.impl.SuiteDefinitionImpl <em>Suite Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.integrity.dsl.impl.SuiteDefinitionImpl
     * @see de.integrity.dsl.impl.DslPackageImpl#getSuiteDefinition()
     * @generated
     */
    EClass SUITE_DEFINITION = eINSTANCE.getSuiteDefinition();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SUITE_DEFINITION__NAME = eINSTANCE.getSuiteDefinition_Name();

    /**
     * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUITE_DEFINITION__PARAMETERS = eINSTANCE.getSuiteDefinition_Parameters();

    /**
     * The meta object literal for the '<em><b>Dependencies</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUITE_DEFINITION__DEPENDENCIES = eINSTANCE.getSuiteDefinition_Dependencies();

    /**
     * The meta object literal for the '<em><b>Statements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUITE_DEFINITION__STATEMENTS = eINSTANCE.getSuiteDefinition_Statements();

    /**
     * The meta object literal for the '<em><b>Finalizers</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUITE_DEFINITION__FINALIZERS = eINSTANCE.getSuiteDefinition_Finalizers();

    /**
     * The meta object literal for the '{@link de.integrity.dsl.impl.SuiteStatementImpl <em>Suite Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.integrity.dsl.impl.SuiteStatementImpl
     * @see de.integrity.dsl.impl.DslPackageImpl#getSuiteStatement()
     * @generated
     */
    EClass SUITE_STATEMENT = eINSTANCE.getSuiteStatement();

    /**
     * The meta object literal for the '{@link de.integrity.dsl.impl.SuiteStatementWithResultImpl <em>Suite Statement With Result</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.integrity.dsl.impl.SuiteStatementWithResultImpl
     * @see de.integrity.dsl.impl.DslPackageImpl#getSuiteStatementWithResult()
     * @generated
     */
    EClass SUITE_STATEMENT_WITH_RESULT = eINSTANCE.getSuiteStatementWithResult();

    /**
     * The meta object literal for the '{@link de.integrity.dsl.impl.VariableDefinitionImpl <em>Variable Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.integrity.dsl.impl.VariableDefinitionImpl
     * @see de.integrity.dsl.impl.DslPackageImpl#getVariableDefinition()
     * @generated
     */
    EClass VARIABLE_DEFINITION = eINSTANCE.getVariableDefinition();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VARIABLE_DEFINITION__NAME = eINSTANCE.getVariableDefinition_Name();

    /**
     * The meta object literal for the '<em><b>Initial Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VARIABLE_DEFINITION__INITIAL_VALUE = eINSTANCE.getVariableDefinition_InitialValue();

    /**
     * The meta object literal for the '{@link de.integrity.dsl.impl.VariableEntityImpl <em>Variable Entity</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.integrity.dsl.impl.VariableEntityImpl
     * @see de.integrity.dsl.impl.DslPackageImpl#getVariableEntity()
     * @generated
     */
    EClass VARIABLE_ENTITY = eINSTANCE.getVariableEntity();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VARIABLE_ENTITY__NAME = eINSTANCE.getVariableEntity_Name();

    /**
     * The meta object literal for the '{@link de.integrity.dsl.impl.TestImpl <em>Test</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.integrity.dsl.impl.TestImpl
     * @see de.integrity.dsl.impl.DslPackageImpl#getTest()
     * @generated
     */
    EClass TEST = eINSTANCE.getTest();

    /**
     * The meta object literal for the '<em><b>Definition</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TEST__DEFINITION = eINSTANCE.getTest_Definition();

    /**
     * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TEST__PARAMETERS = eINSTANCE.getTest_Parameters();

    /**
     * The meta object literal for the '<em><b>Result</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TEST__RESULT = eINSTANCE.getTest_Result();

    /**
     * The meta object literal for the '{@link de.integrity.dsl.impl.CallImpl <em>Call</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.integrity.dsl.impl.CallImpl
     * @see de.integrity.dsl.impl.DslPackageImpl#getCall()
     * @generated
     */
    EClass CALL = eINSTANCE.getCall();

    /**
     * The meta object literal for the '<em><b>Definition</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CALL__DEFINITION = eINSTANCE.getCall_Definition();

    /**
     * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CALL__PARAMETERS = eINSTANCE.getCall_Parameters();

    /**
     * The meta object literal for the '<em><b>Result</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CALL__RESULT = eINSTANCE.getCall_Result();

    /**
     * The meta object literal for the '{@link de.integrity.dsl.impl.SuiteImpl <em>Suite</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.integrity.dsl.impl.SuiteImpl
     * @see de.integrity.dsl.impl.DslPackageImpl#getSuite()
     * @generated
     */
    EClass SUITE = eINSTANCE.getSuite();

    /**
     * The meta object literal for the '<em><b>Definition</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUITE__DEFINITION = eINSTANCE.getSuite_Definition();

    /**
     * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUITE__PARAMETERS = eINSTANCE.getSuite_Parameters();

    /**
     * The meta object literal for the '{@link de.integrity.dsl.impl.SuiteParameterImpl <em>Suite Parameter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.integrity.dsl.impl.SuiteParameterImpl
     * @see de.integrity.dsl.impl.DslPackageImpl#getSuiteParameter()
     * @generated
     */
    EClass SUITE_PARAMETER = eINSTANCE.getSuiteParameter();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUITE_PARAMETER__NAME = eINSTANCE.getSuiteParameter_Name();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUITE_PARAMETER__VALUE = eINSTANCE.getSuiteParameter_Value();

    /**
     * The meta object literal for the '{@link de.integrity.dsl.impl.ParameterImpl <em>Parameter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.integrity.dsl.impl.ParameterImpl
     * @see de.integrity.dsl.impl.DslPackageImpl#getParameter()
     * @generated
     */
    EClass PARAMETER = eINSTANCE.getParameter();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARAMETER__NAME = eINSTANCE.getParameter_Name();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARAMETER__VALUE = eINSTANCE.getParameter_Value();

    /**
     * The meta object literal for the '{@link de.integrity.dsl.impl.ParameterNameImpl <em>Parameter Name</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.integrity.dsl.impl.ParameterNameImpl
     * @see de.integrity.dsl.impl.DslPackageImpl#getParameterName()
     * @generated
     */
    EClass PARAMETER_NAME = eINSTANCE.getParameterName();

    /**
     * The meta object literal for the '{@link de.integrity.dsl.impl.FixedParameterNameImpl <em>Fixed Parameter Name</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.integrity.dsl.impl.FixedParameterNameImpl
     * @see de.integrity.dsl.impl.DslPackageImpl#getFixedParameterName()
     * @generated
     */
    EClass FIXED_PARAMETER_NAME = eINSTANCE.getFixedParameterName();

    /**
     * The meta object literal for the '<em><b>Annotation</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FIXED_PARAMETER_NAME__ANNOTATION = eINSTANCE.getFixedParameterName_Annotation();

    /**
     * The meta object literal for the '{@link de.integrity.dsl.impl.ArbitraryParameterNameImpl <em>Arbitrary Parameter Name</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.integrity.dsl.impl.ArbitraryParameterNameImpl
     * @see de.integrity.dsl.impl.DslPackageImpl#getArbitraryParameterName()
     * @generated
     */
    EClass ARBITRARY_PARAMETER_NAME = eINSTANCE.getArbitraryParameterName();

    /**
     * The meta object literal for the '<em><b>Identifier</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ARBITRARY_PARAMETER_NAME__IDENTIFIER = eINSTANCE.getArbitraryParameterName_Identifier();

    /**
     * The meta object literal for the '{@link de.integrity.dsl.impl.ValueOrEnumValueImpl <em>Value Or Enum Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.integrity.dsl.impl.ValueOrEnumValueImpl
     * @see de.integrity.dsl.impl.DslPackageImpl#getValueOrEnumValue()
     * @generated
     */
    EClass VALUE_OR_ENUM_VALUE = eINSTANCE.getValueOrEnumValue();

    /**
     * The meta object literal for the '{@link de.integrity.dsl.impl.ValueImpl <em>Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.integrity.dsl.impl.ValueImpl
     * @see de.integrity.dsl.impl.DslPackageImpl#getValue()
     * @generated
     */
    EClass VALUE = eINSTANCE.getValue();

    /**
     * The meta object literal for the '{@link de.integrity.dsl.impl.IntegerValueImpl <em>Integer Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.integrity.dsl.impl.IntegerValueImpl
     * @see de.integrity.dsl.impl.DslPackageImpl#getIntegerValue()
     * @generated
     */
    EClass INTEGER_VALUE = eINSTANCE.getIntegerValue();

    /**
     * The meta object literal for the '<em><b>Integer Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INTEGER_VALUE__INTEGER_VALUE = eINSTANCE.getIntegerValue_IntegerValue();

    /**
     * The meta object literal for the '{@link de.integrity.dsl.impl.DecimalValueImpl <em>Decimal Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.integrity.dsl.impl.DecimalValueImpl
     * @see de.integrity.dsl.impl.DslPackageImpl#getDecimalValue()
     * @generated
     */
    EClass DECIMAL_VALUE = eINSTANCE.getDecimalValue();

    /**
     * The meta object literal for the '<em><b>Decimal Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DECIMAL_VALUE__DECIMAL_VALUE = eINSTANCE.getDecimalValue_DecimalValue();

    /**
     * The meta object literal for the '{@link de.integrity.dsl.impl.StringValueImpl <em>String Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.integrity.dsl.impl.StringValueImpl
     * @see de.integrity.dsl.impl.DslPackageImpl#getStringValue()
     * @generated
     */
    EClass STRING_VALUE = eINSTANCE.getStringValue();

    /**
     * The meta object literal for the '<em><b>String Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STRING_VALUE__STRING_VALUE = eINSTANCE.getStringValue_StringValue();

    /**
     * The meta object literal for the '{@link de.integrity.dsl.impl.VariableImpl <em>Variable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.integrity.dsl.impl.VariableImpl
     * @see de.integrity.dsl.impl.DslPackageImpl#getVariable()
     * @generated
     */
    EClass VARIABLE = eINSTANCE.getVariable();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VARIABLE__NAME = eINSTANCE.getVariable_Name();

    /**
     * The meta object literal for the '{@link de.integrity.dsl.impl.EnumValueImpl <em>Enum Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.integrity.dsl.impl.EnumValueImpl
     * @see de.integrity.dsl.impl.DslPackageImpl#getEnumValue()
     * @generated
     */
    EClass ENUM_VALUE = eINSTANCE.getEnumValue();

    /**
     * The meta object literal for the '<em><b>Enum Value</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ENUM_VALUE__ENUM_VALUE = eINSTANCE.getEnumValue_EnumValue();

    /**
     * The meta object literal for the '{@link de.integrity.dsl.impl.MethodReferenceImpl <em>Method Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.integrity.dsl.impl.MethodReferenceImpl
     * @see de.integrity.dsl.impl.DslPackageImpl#getMethodReference()
     * @generated
     */
    EClass METHOD_REFERENCE = eINSTANCE.getMethodReference();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference METHOD_REFERENCE__TYPE = eINSTANCE.getMethodReference_Type();

    /**
     * The meta object literal for the '<em><b>Method</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference METHOD_REFERENCE__METHOD = eINSTANCE.getMethodReference_Method();

  }

} //DslPackage
