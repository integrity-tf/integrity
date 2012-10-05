/**
 */
package de.gebit.integrity.dsl;

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
 * @see de.gebit.integrity.dsl.DslFactory
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
  DslPackage eINSTANCE = de.gebit.integrity.dsl.impl.DslPackageImpl.init();

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.ModelImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getModel()
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
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.StatementImpl <em>Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.StatementImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getStatement()
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
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.SuiteStatementImpl <em>Suite Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.SuiteStatementImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getSuiteStatement()
   * @generated
   */
  int SUITE_STATEMENT = 14;

  /**
   * The number of structural features of the '<em>Suite Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUITE_STATEMENT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.VisibleSingleLineCommentImpl <em>Visible Single Line Comment</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.VisibleSingleLineCommentImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getVisibleSingleLineComment()
   * @generated
   */
  int VISIBLE_SINGLE_LINE_COMMENT = 2;

  /**
   * The feature id for the '<em><b>Content</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VISIBLE_SINGLE_LINE_COMMENT__CONTENT = SUITE_STATEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Visible Single Line Comment</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VISIBLE_SINGLE_LINE_COMMENT_FEATURE_COUNT = SUITE_STATEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.VisibleMultiLineCommentImpl <em>Visible Multi Line Comment</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.VisibleMultiLineCommentImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getVisibleMultiLineComment()
   * @generated
   */
  int VISIBLE_MULTI_LINE_COMMENT = 3;

  /**
   * The feature id for the '<em><b>Content</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VISIBLE_MULTI_LINE_COMMENT__CONTENT = SUITE_STATEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Visible Multi Line Comment</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VISIBLE_MULTI_LINE_COMMENT_FEATURE_COUNT = SUITE_STATEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.VisibleDividerImpl <em>Visible Divider</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.VisibleDividerImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getVisibleDivider()
   * @generated
   */
  int VISIBLE_DIVIDER = 4;

  /**
   * The feature id for the '<em><b>Content</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VISIBLE_DIVIDER__CONTENT = SUITE_STATEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Visible Divider</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VISIBLE_DIVIDER_FEATURE_COUNT = SUITE_STATEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.PackageDefinitionImpl <em>Package Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.PackageDefinitionImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getPackageDefinition()
   * @generated
   */
  int PACKAGE_DEFINITION = 5;

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
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.PackageStatementImpl <em>Package Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.PackageStatementImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getPackageStatement()
   * @generated
   */
  int PACKAGE_STATEMENT = 6;

  /**
   * The number of structural features of the '<em>Package Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACKAGE_STATEMENT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.ImportImpl <em>Import</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.ImportImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getImport()
   * @generated
   */
  int IMPORT = 7;

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
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.ForkDefinitionImpl <em>Fork Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.ForkDefinitionImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getForkDefinition()
   * @generated
   */
  int FORK_DEFINITION = 8;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FORK_DEFINITION__NAME = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FORK_DEFINITION__DESCRIPTION = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Forker Class</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FORK_DEFINITION__FORKER_CLASS = STATEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FORK_DEFINITION__PARAMETERS = STATEMENT_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Fork Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FORK_DEFINITION_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.ForkParameterImpl <em>Fork Parameter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.ForkParameterImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getForkParameter()
   * @generated
   */
  int FORK_PARAMETER = 9;

  /**
   * The feature id for the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FORK_PARAMETER__NAME = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FORK_PARAMETER__VALUE = 1;

  /**
   * The number of structural features of the '<em>Fork Parameter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FORK_PARAMETER_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.VariantDefinitionImpl <em>Variant Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.VariantDefinitionImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getVariantDefinition()
   * @generated
   */
  int VARIANT_DEFINITION = 10;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIANT_DEFINITION__NAME = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIANT_DEFINITION__DESCRIPTION = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Variant Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIANT_DEFINITION_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.TestDefinitionImpl <em>Test Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.TestDefinitionImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getTestDefinition()
   * @generated
   */
  int TEST_DEFINITION = 11;

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
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.CallDefinitionImpl <em>Call Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.CallDefinitionImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getCallDefinition()
   * @generated
   */
  int CALL_DEFINITION = 12;

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
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.SuiteDefinitionImpl <em>Suite Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.SuiteDefinitionImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getSuiteDefinition()
   * @generated
   */
  int SUITE_DEFINITION = 13;

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
   * The feature id for the '<em><b>Finalizers</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUITE_DEFINITION__FINALIZERS = PACKAGE_STATEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Statements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUITE_DEFINITION__STATEMENTS = PACKAGE_STATEMENT_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Suite Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUITE_DEFINITION_FEATURE_COUNT = PACKAGE_STATEMENT_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.SuiteStatementWithResultImpl <em>Suite Statement With Result</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.SuiteStatementWithResultImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getSuiteStatementWithResult()
   * @generated
   */
  int SUITE_STATEMENT_WITH_RESULT = 15;

  /**
   * The number of structural features of the '<em>Suite Statement With Result</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUITE_STATEMENT_WITH_RESULT_FEATURE_COUNT = SUITE_STATEMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.VariableDefinitionImpl <em>Variable Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.VariableDefinitionImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getVariableDefinition()
   * @generated
   */
  int VARIABLE_DEFINITION = 16;

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
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.ConstantDefinitionImpl <em>Constant Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.ConstantDefinitionImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getConstantDefinition()
   * @generated
   */
  int CONSTANT_DEFINITION = 17;

  /**
   * The feature id for the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT_DEFINITION__NAME = PACKAGE_STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT_DEFINITION__VALUE = PACKAGE_STATEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Variant Values</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT_DEFINITION__VARIANT_VALUES = PACKAGE_STATEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Constant Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT_DEFINITION_FEATURE_COUNT = PACKAGE_STATEMENT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.VariantValueImpl <em>Variant Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.VariantValueImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getVariantValue()
   * @generated
   */
  int VARIANT_VALUE = 18;

  /**
   * The feature id for the '<em><b>Names</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIANT_VALUE__NAMES = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIANT_VALUE__VALUE = 1;

  /**
   * The number of structural features of the '<em>Variant Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIANT_VALUE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.VariableEntityImpl <em>Variable Entity</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.VariableEntityImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getVariableEntity()
   * @generated
   */
  int VARIABLE_ENTITY = 19;

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
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.TestImpl <em>Test</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.TestImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getTest()
   * @generated
   */
  int TEST = 20;

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
   * The feature id for the '<em><b>Results</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEST__RESULTS = SUITE_STATEMENT_WITH_RESULT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Result</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEST__RESULT = SUITE_STATEMENT_WITH_RESULT_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Test</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEST_FEATURE_COUNT = SUITE_STATEMENT_WITH_RESULT_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.TableTestImpl <em>Table Test</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.TableTestImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getTableTest()
   * @generated
   */
  int TABLE_TEST = 21;

  /**
   * The feature id for the '<em><b>Definition</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TABLE_TEST__DEFINITION = SUITE_STATEMENT_WITH_RESULT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TABLE_TEST__PARAMETERS = SUITE_STATEMENT_WITH_RESULT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Parameter Headers</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TABLE_TEST__PARAMETER_HEADERS = SUITE_STATEMENT_WITH_RESULT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Result Headers</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TABLE_TEST__RESULT_HEADERS = SUITE_STATEMENT_WITH_RESULT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Default Result Column</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TABLE_TEST__DEFAULT_RESULT_COLUMN = SUITE_STATEMENT_WITH_RESULT_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Rows</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TABLE_TEST__ROWS = SUITE_STATEMENT_WITH_RESULT_FEATURE_COUNT + 5;

  /**
   * The number of structural features of the '<em>Table Test</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TABLE_TEST_FEATURE_COUNT = SUITE_STATEMENT_WITH_RESULT_FEATURE_COUNT + 6;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.TableTestRowImpl <em>Table Test Row</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.TableTestRowImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getTableTestRow()
   * @generated
   */
  int TABLE_TEST_ROW = 22;

  /**
   * The feature id for the '<em><b>Values</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TABLE_TEST_ROW__VALUES = 0;

  /**
   * The number of structural features of the '<em>Table Test Row</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TABLE_TEST_ROW_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.ParameterTableHeaderImpl <em>Parameter Table Header</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.ParameterTableHeaderImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getParameterTableHeader()
   * @generated
   */
  int PARAMETER_TABLE_HEADER = 23;

  /**
   * The feature id for the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_TABLE_HEADER__NAME = 0;

  /**
   * The number of structural features of the '<em>Parameter Table Header</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_TABLE_HEADER_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.ResultTableHeaderImpl <em>Result Table Header</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.ResultTableHeaderImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getResultTableHeader()
   * @generated
   */
  int RESULT_TABLE_HEADER = 24;

  /**
   * The feature id for the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_TABLE_HEADER__NAME = 0;

  /**
   * The number of structural features of the '<em>Result Table Header</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_TABLE_HEADER_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.ParameterTableValueImpl <em>Parameter Table Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.ParameterTableValueImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getParameterTableValue()
   * @generated
   */
  int PARAMETER_TABLE_VALUE = 25;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_TABLE_VALUE__VALUE = 0;

  /**
   * The number of structural features of the '<em>Parameter Table Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_TABLE_VALUE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.NamedResultImpl <em>Named Result</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.NamedResultImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getNamedResult()
   * @generated
   */
  int NAMED_RESULT = 26;

  /**
   * The feature id for the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_RESULT__NAME = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_RESULT__VALUE = 1;

  /**
   * The number of structural features of the '<em>Named Result</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_RESULT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.ResultNameImpl <em>Result Name</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.ResultNameImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getResultName()
   * @generated
   */
  int RESULT_NAME = 27;

  /**
   * The number of structural features of the '<em>Result Name</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RESULT_NAME_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.FixedResultNameImpl <em>Fixed Result Name</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.FixedResultNameImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getFixedResultName()
   * @generated
   */
  int FIXED_RESULT_NAME = 28;

  /**
   * The feature id for the '<em><b>Field</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIXED_RESULT_NAME__FIELD = RESULT_NAME_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Fixed Result Name</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIXED_RESULT_NAME_FEATURE_COUNT = RESULT_NAME_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.CallImpl <em>Call</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.CallImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getCall()
   * @generated
   */
  int CALL = 29;

  /**
   * The feature id for the '<em><b>Multiplier</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CALL__MULTIPLIER = SUITE_STATEMENT_WITH_RESULT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Definition</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CALL__DEFINITION = SUITE_STATEMENT_WITH_RESULT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CALL__PARAMETERS = SUITE_STATEMENT_WITH_RESULT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Results</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CALL__RESULTS = SUITE_STATEMENT_WITH_RESULT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Result</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CALL__RESULT = SUITE_STATEMENT_WITH_RESULT_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Call</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CALL_FEATURE_COUNT = SUITE_STATEMENT_WITH_RESULT_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.NamedCallResultImpl <em>Named Call Result</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.NamedCallResultImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getNamedCallResult()
   * @generated
   */
  int NAMED_CALL_RESULT = 30;

  /**
   * The feature id for the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_CALL_RESULT__NAME = 0;

  /**
   * The feature id for the '<em><b>Target</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_CALL_RESULT__TARGET = 1;

  /**
   * The number of structural features of the '<em>Named Call Result</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_CALL_RESULT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.SuiteImpl <em>Suite</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.SuiteImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getSuite()
   * @generated
   */
  int SUITE = 31;

  /**
   * The feature id for the '<em><b>Multiplier</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUITE__MULTIPLIER = SUITE_STATEMENT_WITH_RESULT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Definition</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUITE__DEFINITION = SUITE_STATEMENT_WITH_RESULT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUITE__PARAMETERS = SUITE_STATEMENT_WITH_RESULT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Fork</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUITE__FORK = SUITE_STATEMENT_WITH_RESULT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Variants</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUITE__VARIANTS = SUITE_STATEMENT_WITH_RESULT_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Suite</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUITE_FEATURE_COUNT = SUITE_STATEMENT_WITH_RESULT_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.SuiteParameterImpl <em>Suite Parameter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.SuiteParameterImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getSuiteParameter()
   * @generated
   */
  int SUITE_PARAMETER = 32;

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
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.ParameterImpl <em>Parameter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.ParameterImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getParameter()
   * @generated
   */
  int PARAMETER = 33;

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
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.ParameterNameImpl <em>Parameter Name</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.ParameterNameImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getParameterName()
   * @generated
   */
  int PARAMETER_NAME = 34;

  /**
   * The number of structural features of the '<em>Parameter Name</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_NAME_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.FixedParameterNameImpl <em>Fixed Parameter Name</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.FixedParameterNameImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getFixedParameterName()
   * @generated
   */
  int FIXED_PARAMETER_NAME = 35;

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
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.ArbitraryParameterOrResultNameImpl <em>Arbitrary Parameter Or Result Name</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.ArbitraryParameterOrResultNameImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getArbitraryParameterOrResultName()
   * @generated
   */
  int ARBITRARY_PARAMETER_OR_RESULT_NAME = 36;

  /**
   * The feature id for the '<em><b>Identifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARBITRARY_PARAMETER_OR_RESULT_NAME__IDENTIFIER = RESULT_NAME_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Arbitrary Parameter Or Result Name</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARBITRARY_PARAMETER_OR_RESULT_NAME_FEATURE_COUNT = RESULT_NAME_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.ValueOrEnumValueCollectionImpl <em>Value Or Enum Value Collection</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.ValueOrEnumValueCollectionImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getValueOrEnumValueCollection()
   * @generated
   */
  int VALUE_OR_ENUM_VALUE_COLLECTION = 37;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_OR_ENUM_VALUE_COLLECTION__VALUE = 0;

  /**
   * The feature id for the '<em><b>More Values</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_OR_ENUM_VALUE_COLLECTION__MORE_VALUES = 1;

  /**
   * The number of structural features of the '<em>Value Or Enum Value Collection</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_OR_ENUM_VALUE_COLLECTION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.ValueOrEnumValueImpl <em>Value Or Enum Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.ValueOrEnumValueImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getValueOrEnumValue()
   * @generated
   */
  int VALUE_OR_ENUM_VALUE = 38;

  /**
   * The number of structural features of the '<em>Value Or Enum Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_OR_ENUM_VALUE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.ValueImpl <em>Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.ValueImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getValue()
   * @generated
   */
  int VALUE = 39;

  /**
   * The number of structural features of the '<em>Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_FEATURE_COUNT = VALUE_OR_ENUM_VALUE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.StaticValueImpl <em>Static Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.StaticValueImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getStaticValue()
   * @generated
   */
  int STATIC_VALUE = 40;

  /**
   * The number of structural features of the '<em>Static Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATIC_VALUE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.IntegerValueImpl <em>Integer Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.IntegerValueImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getIntegerValue()
   * @generated
   */
  int INTEGER_VALUE = 41;

  /**
   * The feature id for the '<em><b>Integer Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTEGER_VALUE__INTEGER_VALUE = STATIC_VALUE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Integer Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTEGER_VALUE_FEATURE_COUNT = STATIC_VALUE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.DecimalValueImpl <em>Decimal Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.DecimalValueImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getDecimalValue()
   * @generated
   */
  int DECIMAL_VALUE = 42;

  /**
   * The feature id for the '<em><b>Decimal Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECIMAL_VALUE__DECIMAL_VALUE = STATIC_VALUE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Decimal Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DECIMAL_VALUE_FEATURE_COUNT = STATIC_VALUE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.StringValueImpl <em>String Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.StringValueImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getStringValue()
   * @generated
   */
  int STRING_VALUE = 43;

  /**
   * The feature id for the '<em><b>String Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_VALUE__STRING_VALUE = STATIC_VALUE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>String Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_VALUE_FEATURE_COUNT = STATIC_VALUE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.BooleanValueImpl <em>Boolean Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.BooleanValueImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getBooleanValue()
   * @generated
   */
  int BOOLEAN_VALUE = 44;

  /**
   * The feature id for the '<em><b>Boolean Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_VALUE__BOOLEAN_VALUE = STATIC_VALUE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Boolean Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_VALUE_FEATURE_COUNT = STATIC_VALUE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.VariableImpl <em>Variable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.VariableImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getVariable()
   * @generated
   */
  int VARIABLE = 45;

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
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.NullValueImpl <em>Null Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.NullValueImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getNullValue()
   * @generated
   */
  int NULL_VALUE = 46;

  /**
   * The number of structural features of the '<em>Null Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NULL_VALUE_FEATURE_COUNT = STATIC_VALUE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.EnumValueImpl <em>Enum Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.EnumValueImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getEnumValue()
   * @generated
   */
  int ENUM_VALUE = 47;

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
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.JavaClassReferenceImpl <em>Java Class Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.JavaClassReferenceImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getJavaClassReference()
   * @generated
   */
  int JAVA_CLASS_REFERENCE = 48;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVA_CLASS_REFERENCE__TYPE = 0;

  /**
   * The number of structural features of the '<em>Java Class Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVA_CLASS_REFERENCE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.MethodReferenceImpl <em>Method Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.MethodReferenceImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getMethodReference()
   * @generated
   */
  int METHOD_REFERENCE = 49;

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
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.ExecutionMultiplierImpl <em>Execution Multiplier</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.ExecutionMultiplierImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getExecutionMultiplier()
   * @generated
   */
  int EXECUTION_MULTIPLIER = 50;

  /**
   * The feature id for the '<em><b>Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXECUTION_MULTIPLIER__COUNT = 0;

  /**
   * The number of structural features of the '<em>Execution Multiplier</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXECUTION_MULTIPLIER_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.NullImpl <em>Null</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.NullImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getNull()
   * @generated
   */
  int NULL = 51;

  /**
   * The number of structural features of the '<em>Null</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NULL_FEATURE_COUNT = NULL_VALUE_FEATURE_COUNT + 0;


  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see de.gebit.integrity.dsl.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the containment reference list '{@link de.gebit.integrity.dsl.Model#getStatements <em>Statements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Statements</em>'.
   * @see de.gebit.integrity.dsl.Model#getStatements()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Statements();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.Statement <em>Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Statement</em>'.
   * @see de.gebit.integrity.dsl.Statement
   * @generated
   */
  EClass getStatement();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.VisibleSingleLineComment <em>Visible Single Line Comment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Visible Single Line Comment</em>'.
   * @see de.gebit.integrity.dsl.VisibleSingleLineComment
   * @generated
   */
  EClass getVisibleSingleLineComment();

  /**
   * Returns the meta object for the attribute '{@link de.gebit.integrity.dsl.VisibleSingleLineComment#getContent <em>Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Content</em>'.
   * @see de.gebit.integrity.dsl.VisibleSingleLineComment#getContent()
   * @see #getVisibleSingleLineComment()
   * @generated
   */
  EAttribute getVisibleSingleLineComment_Content();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.VisibleMultiLineComment <em>Visible Multi Line Comment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Visible Multi Line Comment</em>'.
   * @see de.gebit.integrity.dsl.VisibleMultiLineComment
   * @generated
   */
  EClass getVisibleMultiLineComment();

  /**
   * Returns the meta object for the attribute '{@link de.gebit.integrity.dsl.VisibleMultiLineComment#getContent <em>Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Content</em>'.
   * @see de.gebit.integrity.dsl.VisibleMultiLineComment#getContent()
   * @see #getVisibleMultiLineComment()
   * @generated
   */
  EAttribute getVisibleMultiLineComment_Content();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.VisibleDivider <em>Visible Divider</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Visible Divider</em>'.
   * @see de.gebit.integrity.dsl.VisibleDivider
   * @generated
   */
  EClass getVisibleDivider();

  /**
   * Returns the meta object for the attribute '{@link de.gebit.integrity.dsl.VisibleDivider#getContent <em>Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Content</em>'.
   * @see de.gebit.integrity.dsl.VisibleDivider#getContent()
   * @see #getVisibleDivider()
   * @generated
   */
  EAttribute getVisibleDivider_Content();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.PackageDefinition <em>Package Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Package Definition</em>'.
   * @see de.gebit.integrity.dsl.PackageDefinition
   * @generated
   */
  EClass getPackageDefinition();

  /**
   * Returns the meta object for the attribute '{@link de.gebit.integrity.dsl.PackageDefinition#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.gebit.integrity.dsl.PackageDefinition#getName()
   * @see #getPackageDefinition()
   * @generated
   */
  EAttribute getPackageDefinition_Name();

  /**
   * Returns the meta object for the containment reference list '{@link de.gebit.integrity.dsl.PackageDefinition#getStatements <em>Statements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Statements</em>'.
   * @see de.gebit.integrity.dsl.PackageDefinition#getStatements()
   * @see #getPackageDefinition()
   * @generated
   */
  EReference getPackageDefinition_Statements();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.PackageStatement <em>Package Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Package Statement</em>'.
   * @see de.gebit.integrity.dsl.PackageStatement
   * @generated
   */
  EClass getPackageStatement();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.Import <em>Import</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Import</em>'.
   * @see de.gebit.integrity.dsl.Import
   * @generated
   */
  EClass getImport();

  /**
   * Returns the meta object for the attribute '{@link de.gebit.integrity.dsl.Import#getImportedNamespace <em>Imported Namespace</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Imported Namespace</em>'.
   * @see de.gebit.integrity.dsl.Import#getImportedNamespace()
   * @see #getImport()
   * @generated
   */
  EAttribute getImport_ImportedNamespace();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.ForkDefinition <em>Fork Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Fork Definition</em>'.
   * @see de.gebit.integrity.dsl.ForkDefinition
   * @generated
   */
  EClass getForkDefinition();

  /**
   * Returns the meta object for the attribute '{@link de.gebit.integrity.dsl.ForkDefinition#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.gebit.integrity.dsl.ForkDefinition#getName()
   * @see #getForkDefinition()
   * @generated
   */
  EAttribute getForkDefinition_Name();

  /**
   * Returns the meta object for the attribute '{@link de.gebit.integrity.dsl.ForkDefinition#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Description</em>'.
   * @see de.gebit.integrity.dsl.ForkDefinition#getDescription()
   * @see #getForkDefinition()
   * @generated
   */
  EAttribute getForkDefinition_Description();

  /**
   * Returns the meta object for the containment reference '{@link de.gebit.integrity.dsl.ForkDefinition#getForkerClass <em>Forker Class</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Forker Class</em>'.
   * @see de.gebit.integrity.dsl.ForkDefinition#getForkerClass()
   * @see #getForkDefinition()
   * @generated
   */
  EReference getForkDefinition_ForkerClass();

  /**
   * Returns the meta object for the containment reference list '{@link de.gebit.integrity.dsl.ForkDefinition#getParameters <em>Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameters</em>'.
   * @see de.gebit.integrity.dsl.ForkDefinition#getParameters()
   * @see #getForkDefinition()
   * @generated
   */
  EReference getForkDefinition_Parameters();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.ForkParameter <em>Fork Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Fork Parameter</em>'.
   * @see de.gebit.integrity.dsl.ForkParameter
   * @generated
   */
  EClass getForkParameter();

  /**
   * Returns the meta object for the containment reference '{@link de.gebit.integrity.dsl.ForkParameter#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name</em>'.
   * @see de.gebit.integrity.dsl.ForkParameter#getName()
   * @see #getForkParameter()
   * @generated
   */
  EReference getForkParameter_Name();

  /**
   * Returns the meta object for the containment reference '{@link de.gebit.integrity.dsl.ForkParameter#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see de.gebit.integrity.dsl.ForkParameter#getValue()
   * @see #getForkParameter()
   * @generated
   */
  EReference getForkParameter_Value();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.VariantDefinition <em>Variant Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Variant Definition</em>'.
   * @see de.gebit.integrity.dsl.VariantDefinition
   * @generated
   */
  EClass getVariantDefinition();

  /**
   * Returns the meta object for the attribute '{@link de.gebit.integrity.dsl.VariantDefinition#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.gebit.integrity.dsl.VariantDefinition#getName()
   * @see #getVariantDefinition()
   * @generated
   */
  EAttribute getVariantDefinition_Name();

  /**
   * Returns the meta object for the attribute '{@link de.gebit.integrity.dsl.VariantDefinition#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Description</em>'.
   * @see de.gebit.integrity.dsl.VariantDefinition#getDescription()
   * @see #getVariantDefinition()
   * @generated
   */
  EAttribute getVariantDefinition_Description();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.TestDefinition <em>Test Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Test Definition</em>'.
   * @see de.gebit.integrity.dsl.TestDefinition
   * @generated
   */
  EClass getTestDefinition();

  /**
   * Returns the meta object for the attribute '{@link de.gebit.integrity.dsl.TestDefinition#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.gebit.integrity.dsl.TestDefinition#getName()
   * @see #getTestDefinition()
   * @generated
   */
  EAttribute getTestDefinition_Name();

  /**
   * Returns the meta object for the containment reference '{@link de.gebit.integrity.dsl.TestDefinition#getFixtureMethod <em>Fixture Method</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Fixture Method</em>'.
   * @see de.gebit.integrity.dsl.TestDefinition#getFixtureMethod()
   * @see #getTestDefinition()
   * @generated
   */
  EReference getTestDefinition_FixtureMethod();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.CallDefinition <em>Call Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Call Definition</em>'.
   * @see de.gebit.integrity.dsl.CallDefinition
   * @generated
   */
  EClass getCallDefinition();

  /**
   * Returns the meta object for the attribute '{@link de.gebit.integrity.dsl.CallDefinition#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.gebit.integrity.dsl.CallDefinition#getName()
   * @see #getCallDefinition()
   * @generated
   */
  EAttribute getCallDefinition_Name();

  /**
   * Returns the meta object for the containment reference '{@link de.gebit.integrity.dsl.CallDefinition#getFixtureMethod <em>Fixture Method</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Fixture Method</em>'.
   * @see de.gebit.integrity.dsl.CallDefinition#getFixtureMethod()
   * @see #getCallDefinition()
   * @generated
   */
  EReference getCallDefinition_FixtureMethod();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.SuiteDefinition <em>Suite Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Suite Definition</em>'.
   * @see de.gebit.integrity.dsl.SuiteDefinition
   * @generated
   */
  EClass getSuiteDefinition();

  /**
   * Returns the meta object for the attribute '{@link de.gebit.integrity.dsl.SuiteDefinition#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.gebit.integrity.dsl.SuiteDefinition#getName()
   * @see #getSuiteDefinition()
   * @generated
   */
  EAttribute getSuiteDefinition_Name();

  /**
   * Returns the meta object for the containment reference list '{@link de.gebit.integrity.dsl.SuiteDefinition#getParameters <em>Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameters</em>'.
   * @see de.gebit.integrity.dsl.SuiteDefinition#getParameters()
   * @see #getSuiteDefinition()
   * @generated
   */
  EReference getSuiteDefinition_Parameters();

  /**
   * Returns the meta object for the reference list '{@link de.gebit.integrity.dsl.SuiteDefinition#getDependencies <em>Dependencies</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Dependencies</em>'.
   * @see de.gebit.integrity.dsl.SuiteDefinition#getDependencies()
   * @see #getSuiteDefinition()
   * @generated
   */
  EReference getSuiteDefinition_Dependencies();

  /**
   * Returns the meta object for the reference list '{@link de.gebit.integrity.dsl.SuiteDefinition#getFinalizers <em>Finalizers</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Finalizers</em>'.
   * @see de.gebit.integrity.dsl.SuiteDefinition#getFinalizers()
   * @see #getSuiteDefinition()
   * @generated
   */
  EReference getSuiteDefinition_Finalizers();

  /**
   * Returns the meta object for the containment reference list '{@link de.gebit.integrity.dsl.SuiteDefinition#getStatements <em>Statements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Statements</em>'.
   * @see de.gebit.integrity.dsl.SuiteDefinition#getStatements()
   * @see #getSuiteDefinition()
   * @generated
   */
  EReference getSuiteDefinition_Statements();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.SuiteStatement <em>Suite Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Suite Statement</em>'.
   * @see de.gebit.integrity.dsl.SuiteStatement
   * @generated
   */
  EClass getSuiteStatement();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.SuiteStatementWithResult <em>Suite Statement With Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Suite Statement With Result</em>'.
   * @see de.gebit.integrity.dsl.SuiteStatementWithResult
   * @generated
   */
  EClass getSuiteStatementWithResult();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.VariableDefinition <em>Variable Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Variable Definition</em>'.
   * @see de.gebit.integrity.dsl.VariableDefinition
   * @generated
   */
  EClass getVariableDefinition();

  /**
   * Returns the meta object for the containment reference '{@link de.gebit.integrity.dsl.VariableDefinition#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name</em>'.
   * @see de.gebit.integrity.dsl.VariableDefinition#getName()
   * @see #getVariableDefinition()
   * @generated
   */
  EReference getVariableDefinition_Name();

  /**
   * Returns the meta object for the containment reference '{@link de.gebit.integrity.dsl.VariableDefinition#getInitialValue <em>Initial Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Initial Value</em>'.
   * @see de.gebit.integrity.dsl.VariableDefinition#getInitialValue()
   * @see #getVariableDefinition()
   * @generated
   */
  EReference getVariableDefinition_InitialValue();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.ConstantDefinition <em>Constant Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Constant Definition</em>'.
   * @see de.gebit.integrity.dsl.ConstantDefinition
   * @generated
   */
  EClass getConstantDefinition();

  /**
   * Returns the meta object for the containment reference '{@link de.gebit.integrity.dsl.ConstantDefinition#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name</em>'.
   * @see de.gebit.integrity.dsl.ConstantDefinition#getName()
   * @see #getConstantDefinition()
   * @generated
   */
  EReference getConstantDefinition_Name();

  /**
   * Returns the meta object for the containment reference '{@link de.gebit.integrity.dsl.ConstantDefinition#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see de.gebit.integrity.dsl.ConstantDefinition#getValue()
   * @see #getConstantDefinition()
   * @generated
   */
  EReference getConstantDefinition_Value();

  /**
   * Returns the meta object for the containment reference list '{@link de.gebit.integrity.dsl.ConstantDefinition#getVariantValues <em>Variant Values</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Variant Values</em>'.
   * @see de.gebit.integrity.dsl.ConstantDefinition#getVariantValues()
   * @see #getConstantDefinition()
   * @generated
   */
  EReference getConstantDefinition_VariantValues();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.VariantValue <em>Variant Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Variant Value</em>'.
   * @see de.gebit.integrity.dsl.VariantValue
   * @generated
   */
  EClass getVariantValue();

  /**
   * Returns the meta object for the reference list '{@link de.gebit.integrity.dsl.VariantValue#getNames <em>Names</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Names</em>'.
   * @see de.gebit.integrity.dsl.VariantValue#getNames()
   * @see #getVariantValue()
   * @generated
   */
  EReference getVariantValue_Names();

  /**
   * Returns the meta object for the containment reference '{@link de.gebit.integrity.dsl.VariantValue#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see de.gebit.integrity.dsl.VariantValue#getValue()
   * @see #getVariantValue()
   * @generated
   */
  EReference getVariantValue_Value();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.VariableEntity <em>Variable Entity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Variable Entity</em>'.
   * @see de.gebit.integrity.dsl.VariableEntity
   * @generated
   */
  EClass getVariableEntity();

  /**
   * Returns the meta object for the attribute '{@link de.gebit.integrity.dsl.VariableEntity#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.gebit.integrity.dsl.VariableEntity#getName()
   * @see #getVariableEntity()
   * @generated
   */
  EAttribute getVariableEntity_Name();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.Test <em>Test</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Test</em>'.
   * @see de.gebit.integrity.dsl.Test
   * @generated
   */
  EClass getTest();

  /**
   * Returns the meta object for the reference '{@link de.gebit.integrity.dsl.Test#getDefinition <em>Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Definition</em>'.
   * @see de.gebit.integrity.dsl.Test#getDefinition()
   * @see #getTest()
   * @generated
   */
  EReference getTest_Definition();

  /**
   * Returns the meta object for the containment reference list '{@link de.gebit.integrity.dsl.Test#getParameters <em>Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameters</em>'.
   * @see de.gebit.integrity.dsl.Test#getParameters()
   * @see #getTest()
   * @generated
   */
  EReference getTest_Parameters();

  /**
   * Returns the meta object for the containment reference list '{@link de.gebit.integrity.dsl.Test#getResults <em>Results</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Results</em>'.
   * @see de.gebit.integrity.dsl.Test#getResults()
   * @see #getTest()
   * @generated
   */
  EReference getTest_Results();

  /**
   * Returns the meta object for the containment reference '{@link de.gebit.integrity.dsl.Test#getResult <em>Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Result</em>'.
   * @see de.gebit.integrity.dsl.Test#getResult()
   * @see #getTest()
   * @generated
   */
  EReference getTest_Result();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.TableTest <em>Table Test</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Table Test</em>'.
   * @see de.gebit.integrity.dsl.TableTest
   * @generated
   */
  EClass getTableTest();

  /**
   * Returns the meta object for the reference '{@link de.gebit.integrity.dsl.TableTest#getDefinition <em>Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Definition</em>'.
   * @see de.gebit.integrity.dsl.TableTest#getDefinition()
   * @see #getTableTest()
   * @generated
   */
  EReference getTableTest_Definition();

  /**
   * Returns the meta object for the containment reference list '{@link de.gebit.integrity.dsl.TableTest#getParameters <em>Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameters</em>'.
   * @see de.gebit.integrity.dsl.TableTest#getParameters()
   * @see #getTableTest()
   * @generated
   */
  EReference getTableTest_Parameters();

  /**
   * Returns the meta object for the containment reference list '{@link de.gebit.integrity.dsl.TableTest#getParameterHeaders <em>Parameter Headers</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameter Headers</em>'.
   * @see de.gebit.integrity.dsl.TableTest#getParameterHeaders()
   * @see #getTableTest()
   * @generated
   */
  EReference getTableTest_ParameterHeaders();

  /**
   * Returns the meta object for the containment reference list '{@link de.gebit.integrity.dsl.TableTest#getResultHeaders <em>Result Headers</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Result Headers</em>'.
   * @see de.gebit.integrity.dsl.TableTest#getResultHeaders()
   * @see #getTableTest()
   * @generated
   */
  EReference getTableTest_ResultHeaders();

  /**
   * Returns the meta object for the attribute '{@link de.gebit.integrity.dsl.TableTest#getDefaultResultColumn <em>Default Result Column</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Default Result Column</em>'.
   * @see de.gebit.integrity.dsl.TableTest#getDefaultResultColumn()
   * @see #getTableTest()
   * @generated
   */
  EAttribute getTableTest_DefaultResultColumn();

  /**
   * Returns the meta object for the containment reference list '{@link de.gebit.integrity.dsl.TableTest#getRows <em>Rows</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Rows</em>'.
   * @see de.gebit.integrity.dsl.TableTest#getRows()
   * @see #getTableTest()
   * @generated
   */
  EReference getTableTest_Rows();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.TableTestRow <em>Table Test Row</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Table Test Row</em>'.
   * @see de.gebit.integrity.dsl.TableTestRow
   * @generated
   */
  EClass getTableTestRow();

  /**
   * Returns the meta object for the containment reference list '{@link de.gebit.integrity.dsl.TableTestRow#getValues <em>Values</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Values</em>'.
   * @see de.gebit.integrity.dsl.TableTestRow#getValues()
   * @see #getTableTestRow()
   * @generated
   */
  EReference getTableTestRow_Values();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.ParameterTableHeader <em>Parameter Table Header</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parameter Table Header</em>'.
   * @see de.gebit.integrity.dsl.ParameterTableHeader
   * @generated
   */
  EClass getParameterTableHeader();

  /**
   * Returns the meta object for the containment reference '{@link de.gebit.integrity.dsl.ParameterTableHeader#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name</em>'.
   * @see de.gebit.integrity.dsl.ParameterTableHeader#getName()
   * @see #getParameterTableHeader()
   * @generated
   */
  EReference getParameterTableHeader_Name();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.ResultTableHeader <em>Result Table Header</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Result Table Header</em>'.
   * @see de.gebit.integrity.dsl.ResultTableHeader
   * @generated
   */
  EClass getResultTableHeader();

  /**
   * Returns the meta object for the containment reference '{@link de.gebit.integrity.dsl.ResultTableHeader#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name</em>'.
   * @see de.gebit.integrity.dsl.ResultTableHeader#getName()
   * @see #getResultTableHeader()
   * @generated
   */
  EReference getResultTableHeader_Name();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.ParameterTableValue <em>Parameter Table Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parameter Table Value</em>'.
   * @see de.gebit.integrity.dsl.ParameterTableValue
   * @generated
   */
  EClass getParameterTableValue();

  /**
   * Returns the meta object for the containment reference '{@link de.gebit.integrity.dsl.ParameterTableValue#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see de.gebit.integrity.dsl.ParameterTableValue#getValue()
   * @see #getParameterTableValue()
   * @generated
   */
  EReference getParameterTableValue_Value();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.NamedResult <em>Named Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Named Result</em>'.
   * @see de.gebit.integrity.dsl.NamedResult
   * @generated
   */
  EClass getNamedResult();

  /**
   * Returns the meta object for the containment reference '{@link de.gebit.integrity.dsl.NamedResult#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name</em>'.
   * @see de.gebit.integrity.dsl.NamedResult#getName()
   * @see #getNamedResult()
   * @generated
   */
  EReference getNamedResult_Name();

  /**
   * Returns the meta object for the containment reference '{@link de.gebit.integrity.dsl.NamedResult#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see de.gebit.integrity.dsl.NamedResult#getValue()
   * @see #getNamedResult()
   * @generated
   */
  EReference getNamedResult_Value();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.ResultName <em>Result Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Result Name</em>'.
   * @see de.gebit.integrity.dsl.ResultName
   * @generated
   */
  EClass getResultName();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.FixedResultName <em>Fixed Result Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Fixed Result Name</em>'.
   * @see de.gebit.integrity.dsl.FixedResultName
   * @generated
   */
  EClass getFixedResultName();

  /**
   * Returns the meta object for the reference '{@link de.gebit.integrity.dsl.FixedResultName#getField <em>Field</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Field</em>'.
   * @see de.gebit.integrity.dsl.FixedResultName#getField()
   * @see #getFixedResultName()
   * @generated
   */
  EReference getFixedResultName_Field();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.Call <em>Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Call</em>'.
   * @see de.gebit.integrity.dsl.Call
   * @generated
   */
  EClass getCall();

  /**
   * Returns the meta object for the containment reference '{@link de.gebit.integrity.dsl.Call#getMultiplier <em>Multiplier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Multiplier</em>'.
   * @see de.gebit.integrity.dsl.Call#getMultiplier()
   * @see #getCall()
   * @generated
   */
  EReference getCall_Multiplier();

  /**
   * Returns the meta object for the reference '{@link de.gebit.integrity.dsl.Call#getDefinition <em>Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Definition</em>'.
   * @see de.gebit.integrity.dsl.Call#getDefinition()
   * @see #getCall()
   * @generated
   */
  EReference getCall_Definition();

  /**
   * Returns the meta object for the containment reference list '{@link de.gebit.integrity.dsl.Call#getParameters <em>Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameters</em>'.
   * @see de.gebit.integrity.dsl.Call#getParameters()
   * @see #getCall()
   * @generated
   */
  EReference getCall_Parameters();

  /**
   * Returns the meta object for the containment reference list '{@link de.gebit.integrity.dsl.Call#getResults <em>Results</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Results</em>'.
   * @see de.gebit.integrity.dsl.Call#getResults()
   * @see #getCall()
   * @generated
   */
  EReference getCall_Results();

  /**
   * Returns the meta object for the containment reference '{@link de.gebit.integrity.dsl.Call#getResult <em>Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Result</em>'.
   * @see de.gebit.integrity.dsl.Call#getResult()
   * @see #getCall()
   * @generated
   */
  EReference getCall_Result();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.NamedCallResult <em>Named Call Result</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Named Call Result</em>'.
   * @see de.gebit.integrity.dsl.NamedCallResult
   * @generated
   */
  EClass getNamedCallResult();

  /**
   * Returns the meta object for the containment reference '{@link de.gebit.integrity.dsl.NamedCallResult#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name</em>'.
   * @see de.gebit.integrity.dsl.NamedCallResult#getName()
   * @see #getNamedCallResult()
   * @generated
   */
  EReference getNamedCallResult_Name();

  /**
   * Returns the meta object for the containment reference '{@link de.gebit.integrity.dsl.NamedCallResult#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Target</em>'.
   * @see de.gebit.integrity.dsl.NamedCallResult#getTarget()
   * @see #getNamedCallResult()
   * @generated
   */
  EReference getNamedCallResult_Target();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.Suite <em>Suite</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Suite</em>'.
   * @see de.gebit.integrity.dsl.Suite
   * @generated
   */
  EClass getSuite();

  /**
   * Returns the meta object for the containment reference '{@link de.gebit.integrity.dsl.Suite#getMultiplier <em>Multiplier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Multiplier</em>'.
   * @see de.gebit.integrity.dsl.Suite#getMultiplier()
   * @see #getSuite()
   * @generated
   */
  EReference getSuite_Multiplier();

  /**
   * Returns the meta object for the reference '{@link de.gebit.integrity.dsl.Suite#getDefinition <em>Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Definition</em>'.
   * @see de.gebit.integrity.dsl.Suite#getDefinition()
   * @see #getSuite()
   * @generated
   */
  EReference getSuite_Definition();

  /**
   * Returns the meta object for the containment reference list '{@link de.gebit.integrity.dsl.Suite#getParameters <em>Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameters</em>'.
   * @see de.gebit.integrity.dsl.Suite#getParameters()
   * @see #getSuite()
   * @generated
   */
  EReference getSuite_Parameters();

  /**
   * Returns the meta object for the reference '{@link de.gebit.integrity.dsl.Suite#getFork <em>Fork</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Fork</em>'.
   * @see de.gebit.integrity.dsl.Suite#getFork()
   * @see #getSuite()
   * @generated
   */
  EReference getSuite_Fork();

  /**
   * Returns the meta object for the reference list '{@link de.gebit.integrity.dsl.Suite#getVariants <em>Variants</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Variants</em>'.
   * @see de.gebit.integrity.dsl.Suite#getVariants()
   * @see #getSuite()
   * @generated
   */
  EReference getSuite_Variants();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.SuiteParameter <em>Suite Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Suite Parameter</em>'.
   * @see de.gebit.integrity.dsl.SuiteParameter
   * @generated
   */
  EClass getSuiteParameter();

  /**
   * Returns the meta object for the reference '{@link de.gebit.integrity.dsl.SuiteParameter#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Name</em>'.
   * @see de.gebit.integrity.dsl.SuiteParameter#getName()
   * @see #getSuiteParameter()
   * @generated
   */
  EReference getSuiteParameter_Name();

  /**
   * Returns the meta object for the containment reference '{@link de.gebit.integrity.dsl.SuiteParameter#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see de.gebit.integrity.dsl.SuiteParameter#getValue()
   * @see #getSuiteParameter()
   * @generated
   */
  EReference getSuiteParameter_Value();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.Parameter <em>Parameter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parameter</em>'.
   * @see de.gebit.integrity.dsl.Parameter
   * @generated
   */
  EClass getParameter();

  /**
   * Returns the meta object for the containment reference '{@link de.gebit.integrity.dsl.Parameter#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name</em>'.
   * @see de.gebit.integrity.dsl.Parameter#getName()
   * @see #getParameter()
   * @generated
   */
  EReference getParameter_Name();

  /**
   * Returns the meta object for the containment reference '{@link de.gebit.integrity.dsl.Parameter#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see de.gebit.integrity.dsl.Parameter#getValue()
   * @see #getParameter()
   * @generated
   */
  EReference getParameter_Value();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.ParameterName <em>Parameter Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parameter Name</em>'.
   * @see de.gebit.integrity.dsl.ParameterName
   * @generated
   */
  EClass getParameterName();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.FixedParameterName <em>Fixed Parameter Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Fixed Parameter Name</em>'.
   * @see de.gebit.integrity.dsl.FixedParameterName
   * @generated
   */
  EClass getFixedParameterName();

  /**
   * Returns the meta object for the reference '{@link de.gebit.integrity.dsl.FixedParameterName#getAnnotation <em>Annotation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Annotation</em>'.
   * @see de.gebit.integrity.dsl.FixedParameterName#getAnnotation()
   * @see #getFixedParameterName()
   * @generated
   */
  EReference getFixedParameterName_Annotation();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.ArbitraryParameterOrResultName <em>Arbitrary Parameter Or Result Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Arbitrary Parameter Or Result Name</em>'.
   * @see de.gebit.integrity.dsl.ArbitraryParameterOrResultName
   * @generated
   */
  EClass getArbitraryParameterOrResultName();

  /**
   * Returns the meta object for the attribute '{@link de.gebit.integrity.dsl.ArbitraryParameterOrResultName#getIdentifier <em>Identifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Identifier</em>'.
   * @see de.gebit.integrity.dsl.ArbitraryParameterOrResultName#getIdentifier()
   * @see #getArbitraryParameterOrResultName()
   * @generated
   */
  EAttribute getArbitraryParameterOrResultName_Identifier();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.ValueOrEnumValueCollection <em>Value Or Enum Value Collection</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Value Or Enum Value Collection</em>'.
   * @see de.gebit.integrity.dsl.ValueOrEnumValueCollection
   * @generated
   */
  EClass getValueOrEnumValueCollection();

  /**
   * Returns the meta object for the containment reference '{@link de.gebit.integrity.dsl.ValueOrEnumValueCollection#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see de.gebit.integrity.dsl.ValueOrEnumValueCollection#getValue()
   * @see #getValueOrEnumValueCollection()
   * @generated
   */
  EReference getValueOrEnumValueCollection_Value();

  /**
   * Returns the meta object for the containment reference list '{@link de.gebit.integrity.dsl.ValueOrEnumValueCollection#getMoreValues <em>More Values</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>More Values</em>'.
   * @see de.gebit.integrity.dsl.ValueOrEnumValueCollection#getMoreValues()
   * @see #getValueOrEnumValueCollection()
   * @generated
   */
  EReference getValueOrEnumValueCollection_MoreValues();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.ValueOrEnumValue <em>Value Or Enum Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Value Or Enum Value</em>'.
   * @see de.gebit.integrity.dsl.ValueOrEnumValue
   * @generated
   */
  EClass getValueOrEnumValue();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.Value <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Value</em>'.
   * @see de.gebit.integrity.dsl.Value
   * @generated
   */
  EClass getValue();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.StaticValue <em>Static Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Static Value</em>'.
   * @see de.gebit.integrity.dsl.StaticValue
   * @generated
   */
  EClass getStaticValue();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.IntegerValue <em>Integer Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Integer Value</em>'.
   * @see de.gebit.integrity.dsl.IntegerValue
   * @generated
   */
  EClass getIntegerValue();

  /**
   * Returns the meta object for the attribute '{@link de.gebit.integrity.dsl.IntegerValue#getIntegerValue <em>Integer Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Integer Value</em>'.
   * @see de.gebit.integrity.dsl.IntegerValue#getIntegerValue()
   * @see #getIntegerValue()
   * @generated
   */
  EAttribute getIntegerValue_IntegerValue();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.DecimalValue <em>Decimal Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Decimal Value</em>'.
   * @see de.gebit.integrity.dsl.DecimalValue
   * @generated
   */
  EClass getDecimalValue();

  /**
   * Returns the meta object for the attribute '{@link de.gebit.integrity.dsl.DecimalValue#getDecimalValue <em>Decimal Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Decimal Value</em>'.
   * @see de.gebit.integrity.dsl.DecimalValue#getDecimalValue()
   * @see #getDecimalValue()
   * @generated
   */
  EAttribute getDecimalValue_DecimalValue();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.StringValue <em>String Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>String Value</em>'.
   * @see de.gebit.integrity.dsl.StringValue
   * @generated
   */
  EClass getStringValue();

  /**
   * Returns the meta object for the attribute '{@link de.gebit.integrity.dsl.StringValue#getStringValue <em>String Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>String Value</em>'.
   * @see de.gebit.integrity.dsl.StringValue#getStringValue()
   * @see #getStringValue()
   * @generated
   */
  EAttribute getStringValue_StringValue();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.BooleanValue <em>Boolean Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Boolean Value</em>'.
   * @see de.gebit.integrity.dsl.BooleanValue
   * @generated
   */
  EClass getBooleanValue();

  /**
   * Returns the meta object for the attribute '{@link de.gebit.integrity.dsl.BooleanValue#getBooleanValue <em>Boolean Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Boolean Value</em>'.
   * @see de.gebit.integrity.dsl.BooleanValue#getBooleanValue()
   * @see #getBooleanValue()
   * @generated
   */
  EAttribute getBooleanValue_BooleanValue();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.Variable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Variable</em>'.
   * @see de.gebit.integrity.dsl.Variable
   * @generated
   */
  EClass getVariable();

  /**
   * Returns the meta object for the reference '{@link de.gebit.integrity.dsl.Variable#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Name</em>'.
   * @see de.gebit.integrity.dsl.Variable#getName()
   * @see #getVariable()
   * @generated
   */
  EReference getVariable_Name();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.NullValue <em>Null Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Null Value</em>'.
   * @see de.gebit.integrity.dsl.NullValue
   * @generated
   */
  EClass getNullValue();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.EnumValue <em>Enum Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Enum Value</em>'.
   * @see de.gebit.integrity.dsl.EnumValue
   * @generated
   */
  EClass getEnumValue();

  /**
   * Returns the meta object for the reference '{@link de.gebit.integrity.dsl.EnumValue#getEnumValue <em>Enum Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Enum Value</em>'.
   * @see de.gebit.integrity.dsl.EnumValue#getEnumValue()
   * @see #getEnumValue()
   * @generated
   */
  EReference getEnumValue_EnumValue();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.JavaClassReference <em>Java Class Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Java Class Reference</em>'.
   * @see de.gebit.integrity.dsl.JavaClassReference
   * @generated
   */
  EClass getJavaClassReference();

  /**
   * Returns the meta object for the reference '{@link de.gebit.integrity.dsl.JavaClassReference#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see de.gebit.integrity.dsl.JavaClassReference#getType()
   * @see #getJavaClassReference()
   * @generated
   */
  EReference getJavaClassReference_Type();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.MethodReference <em>Method Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Method Reference</em>'.
   * @see de.gebit.integrity.dsl.MethodReference
   * @generated
   */
  EClass getMethodReference();

  /**
   * Returns the meta object for the reference '{@link de.gebit.integrity.dsl.MethodReference#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see de.gebit.integrity.dsl.MethodReference#getType()
   * @see #getMethodReference()
   * @generated
   */
  EReference getMethodReference_Type();

  /**
   * Returns the meta object for the reference '{@link de.gebit.integrity.dsl.MethodReference#getMethod <em>Method</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Method</em>'.
   * @see de.gebit.integrity.dsl.MethodReference#getMethod()
   * @see #getMethodReference()
   * @generated
   */
  EReference getMethodReference_Method();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.ExecutionMultiplier <em>Execution Multiplier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Execution Multiplier</em>'.
   * @see de.gebit.integrity.dsl.ExecutionMultiplier
   * @generated
   */
  EClass getExecutionMultiplier();

  /**
   * Returns the meta object for the attribute '{@link de.gebit.integrity.dsl.ExecutionMultiplier#getCount <em>Count</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Count</em>'.
   * @see de.gebit.integrity.dsl.ExecutionMultiplier#getCount()
   * @see #getExecutionMultiplier()
   * @generated
   */
  EAttribute getExecutionMultiplier_Count();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.Null <em>Null</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Null</em>'.
   * @see de.gebit.integrity.dsl.Null
   * @generated
   */
  EClass getNull();

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
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.ModelImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getModel()
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
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.StatementImpl <em>Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.StatementImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getStatement()
     * @generated
     */
    EClass STATEMENT = eINSTANCE.getStatement();

    /**
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.VisibleSingleLineCommentImpl <em>Visible Single Line Comment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.VisibleSingleLineCommentImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getVisibleSingleLineComment()
     * @generated
     */
    EClass VISIBLE_SINGLE_LINE_COMMENT = eINSTANCE.getVisibleSingleLineComment();

    /**
     * The meta object literal for the '<em><b>Content</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VISIBLE_SINGLE_LINE_COMMENT__CONTENT = eINSTANCE.getVisibleSingleLineComment_Content();

    /**
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.VisibleMultiLineCommentImpl <em>Visible Multi Line Comment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.VisibleMultiLineCommentImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getVisibleMultiLineComment()
     * @generated
     */
    EClass VISIBLE_MULTI_LINE_COMMENT = eINSTANCE.getVisibleMultiLineComment();

    /**
     * The meta object literal for the '<em><b>Content</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VISIBLE_MULTI_LINE_COMMENT__CONTENT = eINSTANCE.getVisibleMultiLineComment_Content();

    /**
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.VisibleDividerImpl <em>Visible Divider</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.VisibleDividerImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getVisibleDivider()
     * @generated
     */
    EClass VISIBLE_DIVIDER = eINSTANCE.getVisibleDivider();

    /**
     * The meta object literal for the '<em><b>Content</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VISIBLE_DIVIDER__CONTENT = eINSTANCE.getVisibleDivider_Content();

    /**
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.PackageDefinitionImpl <em>Package Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.PackageDefinitionImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getPackageDefinition()
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
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.PackageStatementImpl <em>Package Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.PackageStatementImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getPackageStatement()
     * @generated
     */
    EClass PACKAGE_STATEMENT = eINSTANCE.getPackageStatement();

    /**
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.ImportImpl <em>Import</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.ImportImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getImport()
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
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.ForkDefinitionImpl <em>Fork Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.ForkDefinitionImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getForkDefinition()
     * @generated
     */
    EClass FORK_DEFINITION = eINSTANCE.getForkDefinition();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FORK_DEFINITION__NAME = eINSTANCE.getForkDefinition_Name();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FORK_DEFINITION__DESCRIPTION = eINSTANCE.getForkDefinition_Description();

    /**
     * The meta object literal for the '<em><b>Forker Class</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FORK_DEFINITION__FORKER_CLASS = eINSTANCE.getForkDefinition_ForkerClass();

    /**
     * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FORK_DEFINITION__PARAMETERS = eINSTANCE.getForkDefinition_Parameters();

    /**
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.ForkParameterImpl <em>Fork Parameter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.ForkParameterImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getForkParameter()
     * @generated
     */
    EClass FORK_PARAMETER = eINSTANCE.getForkParameter();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FORK_PARAMETER__NAME = eINSTANCE.getForkParameter_Name();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FORK_PARAMETER__VALUE = eINSTANCE.getForkParameter_Value();

    /**
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.VariantDefinitionImpl <em>Variant Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.VariantDefinitionImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getVariantDefinition()
     * @generated
     */
    EClass VARIANT_DEFINITION = eINSTANCE.getVariantDefinition();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VARIANT_DEFINITION__NAME = eINSTANCE.getVariantDefinition_Name();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VARIANT_DEFINITION__DESCRIPTION = eINSTANCE.getVariantDefinition_Description();

    /**
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.TestDefinitionImpl <em>Test Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.TestDefinitionImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getTestDefinition()
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
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.CallDefinitionImpl <em>Call Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.CallDefinitionImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getCallDefinition()
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
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.SuiteDefinitionImpl <em>Suite Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.SuiteDefinitionImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getSuiteDefinition()
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
     * The meta object literal for the '<em><b>Finalizers</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUITE_DEFINITION__FINALIZERS = eINSTANCE.getSuiteDefinition_Finalizers();

    /**
     * The meta object literal for the '<em><b>Statements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUITE_DEFINITION__STATEMENTS = eINSTANCE.getSuiteDefinition_Statements();

    /**
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.SuiteStatementImpl <em>Suite Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.SuiteStatementImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getSuiteStatement()
     * @generated
     */
    EClass SUITE_STATEMENT = eINSTANCE.getSuiteStatement();

    /**
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.SuiteStatementWithResultImpl <em>Suite Statement With Result</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.SuiteStatementWithResultImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getSuiteStatementWithResult()
     * @generated
     */
    EClass SUITE_STATEMENT_WITH_RESULT = eINSTANCE.getSuiteStatementWithResult();

    /**
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.VariableDefinitionImpl <em>Variable Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.VariableDefinitionImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getVariableDefinition()
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
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.ConstantDefinitionImpl <em>Constant Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.ConstantDefinitionImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getConstantDefinition()
     * @generated
     */
    EClass CONSTANT_DEFINITION = eINSTANCE.getConstantDefinition();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONSTANT_DEFINITION__NAME = eINSTANCE.getConstantDefinition_Name();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONSTANT_DEFINITION__VALUE = eINSTANCE.getConstantDefinition_Value();

    /**
     * The meta object literal for the '<em><b>Variant Values</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONSTANT_DEFINITION__VARIANT_VALUES = eINSTANCE.getConstantDefinition_VariantValues();

    /**
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.VariantValueImpl <em>Variant Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.VariantValueImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getVariantValue()
     * @generated
     */
    EClass VARIANT_VALUE = eINSTANCE.getVariantValue();

    /**
     * The meta object literal for the '<em><b>Names</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VARIANT_VALUE__NAMES = eINSTANCE.getVariantValue_Names();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VARIANT_VALUE__VALUE = eINSTANCE.getVariantValue_Value();

    /**
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.VariableEntityImpl <em>Variable Entity</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.VariableEntityImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getVariableEntity()
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
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.TestImpl <em>Test</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.TestImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getTest()
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
     * The meta object literal for the '<em><b>Results</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TEST__RESULTS = eINSTANCE.getTest_Results();

    /**
     * The meta object literal for the '<em><b>Result</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TEST__RESULT = eINSTANCE.getTest_Result();

    /**
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.TableTestImpl <em>Table Test</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.TableTestImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getTableTest()
     * @generated
     */
    EClass TABLE_TEST = eINSTANCE.getTableTest();

    /**
     * The meta object literal for the '<em><b>Definition</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TABLE_TEST__DEFINITION = eINSTANCE.getTableTest_Definition();

    /**
     * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TABLE_TEST__PARAMETERS = eINSTANCE.getTableTest_Parameters();

    /**
     * The meta object literal for the '<em><b>Parameter Headers</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TABLE_TEST__PARAMETER_HEADERS = eINSTANCE.getTableTest_ParameterHeaders();

    /**
     * The meta object literal for the '<em><b>Result Headers</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TABLE_TEST__RESULT_HEADERS = eINSTANCE.getTableTest_ResultHeaders();

    /**
     * The meta object literal for the '<em><b>Default Result Column</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TABLE_TEST__DEFAULT_RESULT_COLUMN = eINSTANCE.getTableTest_DefaultResultColumn();

    /**
     * The meta object literal for the '<em><b>Rows</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TABLE_TEST__ROWS = eINSTANCE.getTableTest_Rows();

    /**
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.TableTestRowImpl <em>Table Test Row</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.TableTestRowImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getTableTestRow()
     * @generated
     */
    EClass TABLE_TEST_ROW = eINSTANCE.getTableTestRow();

    /**
     * The meta object literal for the '<em><b>Values</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TABLE_TEST_ROW__VALUES = eINSTANCE.getTableTestRow_Values();

    /**
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.ParameterTableHeaderImpl <em>Parameter Table Header</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.ParameterTableHeaderImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getParameterTableHeader()
     * @generated
     */
    EClass PARAMETER_TABLE_HEADER = eINSTANCE.getParameterTableHeader();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARAMETER_TABLE_HEADER__NAME = eINSTANCE.getParameterTableHeader_Name();

    /**
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.ResultTableHeaderImpl <em>Result Table Header</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.ResultTableHeaderImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getResultTableHeader()
     * @generated
     */
    EClass RESULT_TABLE_HEADER = eINSTANCE.getResultTableHeader();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RESULT_TABLE_HEADER__NAME = eINSTANCE.getResultTableHeader_Name();

    /**
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.ParameterTableValueImpl <em>Parameter Table Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.ParameterTableValueImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getParameterTableValue()
     * @generated
     */
    EClass PARAMETER_TABLE_VALUE = eINSTANCE.getParameterTableValue();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARAMETER_TABLE_VALUE__VALUE = eINSTANCE.getParameterTableValue_Value();

    /**
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.NamedResultImpl <em>Named Result</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.NamedResultImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getNamedResult()
     * @generated
     */
    EClass NAMED_RESULT = eINSTANCE.getNamedResult();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NAMED_RESULT__NAME = eINSTANCE.getNamedResult_Name();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NAMED_RESULT__VALUE = eINSTANCE.getNamedResult_Value();

    /**
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.ResultNameImpl <em>Result Name</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.ResultNameImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getResultName()
     * @generated
     */
    EClass RESULT_NAME = eINSTANCE.getResultName();

    /**
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.FixedResultNameImpl <em>Fixed Result Name</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.FixedResultNameImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getFixedResultName()
     * @generated
     */
    EClass FIXED_RESULT_NAME = eINSTANCE.getFixedResultName();

    /**
     * The meta object literal for the '<em><b>Field</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FIXED_RESULT_NAME__FIELD = eINSTANCE.getFixedResultName_Field();

    /**
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.CallImpl <em>Call</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.CallImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getCall()
     * @generated
     */
    EClass CALL = eINSTANCE.getCall();

    /**
     * The meta object literal for the '<em><b>Multiplier</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CALL__MULTIPLIER = eINSTANCE.getCall_Multiplier();

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
     * The meta object literal for the '<em><b>Results</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CALL__RESULTS = eINSTANCE.getCall_Results();

    /**
     * The meta object literal for the '<em><b>Result</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CALL__RESULT = eINSTANCE.getCall_Result();

    /**
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.NamedCallResultImpl <em>Named Call Result</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.NamedCallResultImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getNamedCallResult()
     * @generated
     */
    EClass NAMED_CALL_RESULT = eINSTANCE.getNamedCallResult();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NAMED_CALL_RESULT__NAME = eINSTANCE.getNamedCallResult_Name();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NAMED_CALL_RESULT__TARGET = eINSTANCE.getNamedCallResult_Target();

    /**
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.SuiteImpl <em>Suite</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.SuiteImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getSuite()
     * @generated
     */
    EClass SUITE = eINSTANCE.getSuite();

    /**
     * The meta object literal for the '<em><b>Multiplier</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUITE__MULTIPLIER = eINSTANCE.getSuite_Multiplier();

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
     * The meta object literal for the '<em><b>Fork</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUITE__FORK = eINSTANCE.getSuite_Fork();

    /**
     * The meta object literal for the '<em><b>Variants</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUITE__VARIANTS = eINSTANCE.getSuite_Variants();

    /**
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.SuiteParameterImpl <em>Suite Parameter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.SuiteParameterImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getSuiteParameter()
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
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.ParameterImpl <em>Parameter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.ParameterImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getParameter()
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
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.ParameterNameImpl <em>Parameter Name</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.ParameterNameImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getParameterName()
     * @generated
     */
    EClass PARAMETER_NAME = eINSTANCE.getParameterName();

    /**
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.FixedParameterNameImpl <em>Fixed Parameter Name</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.FixedParameterNameImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getFixedParameterName()
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
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.ArbitraryParameterOrResultNameImpl <em>Arbitrary Parameter Or Result Name</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.ArbitraryParameterOrResultNameImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getArbitraryParameterOrResultName()
     * @generated
     */
    EClass ARBITRARY_PARAMETER_OR_RESULT_NAME = eINSTANCE.getArbitraryParameterOrResultName();

    /**
     * The meta object literal for the '<em><b>Identifier</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ARBITRARY_PARAMETER_OR_RESULT_NAME__IDENTIFIER = eINSTANCE.getArbitraryParameterOrResultName_Identifier();

    /**
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.ValueOrEnumValueCollectionImpl <em>Value Or Enum Value Collection</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.ValueOrEnumValueCollectionImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getValueOrEnumValueCollection()
     * @generated
     */
    EClass VALUE_OR_ENUM_VALUE_COLLECTION = eINSTANCE.getValueOrEnumValueCollection();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VALUE_OR_ENUM_VALUE_COLLECTION__VALUE = eINSTANCE.getValueOrEnumValueCollection_Value();

    /**
     * The meta object literal for the '<em><b>More Values</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VALUE_OR_ENUM_VALUE_COLLECTION__MORE_VALUES = eINSTANCE.getValueOrEnumValueCollection_MoreValues();

    /**
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.ValueOrEnumValueImpl <em>Value Or Enum Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.ValueOrEnumValueImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getValueOrEnumValue()
     * @generated
     */
    EClass VALUE_OR_ENUM_VALUE = eINSTANCE.getValueOrEnumValue();

    /**
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.ValueImpl <em>Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.ValueImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getValue()
     * @generated
     */
    EClass VALUE = eINSTANCE.getValue();

    /**
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.StaticValueImpl <em>Static Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.StaticValueImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getStaticValue()
     * @generated
     */
    EClass STATIC_VALUE = eINSTANCE.getStaticValue();

    /**
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.IntegerValueImpl <em>Integer Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.IntegerValueImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getIntegerValue()
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
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.DecimalValueImpl <em>Decimal Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.DecimalValueImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getDecimalValue()
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
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.StringValueImpl <em>String Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.StringValueImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getStringValue()
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
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.BooleanValueImpl <em>Boolean Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.BooleanValueImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getBooleanValue()
     * @generated
     */
    EClass BOOLEAN_VALUE = eINSTANCE.getBooleanValue();

    /**
     * The meta object literal for the '<em><b>Boolean Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BOOLEAN_VALUE__BOOLEAN_VALUE = eINSTANCE.getBooleanValue_BooleanValue();

    /**
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.VariableImpl <em>Variable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.VariableImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getVariable()
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
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.NullValueImpl <em>Null Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.NullValueImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getNullValue()
     * @generated
     */
    EClass NULL_VALUE = eINSTANCE.getNullValue();

    /**
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.EnumValueImpl <em>Enum Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.EnumValueImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getEnumValue()
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
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.JavaClassReferenceImpl <em>Java Class Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.JavaClassReferenceImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getJavaClassReference()
     * @generated
     */
    EClass JAVA_CLASS_REFERENCE = eINSTANCE.getJavaClassReference();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference JAVA_CLASS_REFERENCE__TYPE = eINSTANCE.getJavaClassReference_Type();

    /**
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.MethodReferenceImpl <em>Method Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.MethodReferenceImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getMethodReference()
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

    /**
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.ExecutionMultiplierImpl <em>Execution Multiplier</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.ExecutionMultiplierImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getExecutionMultiplier()
     * @generated
     */
    EClass EXECUTION_MULTIPLIER = eINSTANCE.getExecutionMultiplier();

    /**
     * The meta object literal for the '<em><b>Count</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EXECUTION_MULTIPLIER__COUNT = eINSTANCE.getExecutionMultiplier_Count();

    /**
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.NullImpl <em>Null</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.NullImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getNull()
     * @generated
     */
    EClass NULL = eINSTANCE.getNull();

  }

} //DslPackage
