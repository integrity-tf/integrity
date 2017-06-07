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
  int SUITE_STATEMENT = 22;

  /**
   * The number of structural features of the '<em>Suite Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUITE_STATEMENT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.VisibleCommentImpl <em>Visible Comment</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.VisibleCommentImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getVisibleComment()
   * @generated
   */
  int VISIBLE_COMMENT = 2;

  /**
   * The feature id for the '<em><b>Content</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VISIBLE_COMMENT__CONTENT = SUITE_STATEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Visible Comment</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VISIBLE_COMMENT_FEATURE_COUNT = SUITE_STATEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.VisibleSingleLineCommentImpl <em>Visible Single Line Comment</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.VisibleSingleLineCommentImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getVisibleSingleLineComment()
   * @generated
   */
  int VISIBLE_SINGLE_LINE_COMMENT = 3;

  /**
   * The feature id for the '<em><b>Content</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VISIBLE_SINGLE_LINE_COMMENT__CONTENT = VISIBLE_COMMENT__CONTENT;

  /**
   * The number of structural features of the '<em>Visible Single Line Comment</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VISIBLE_SINGLE_LINE_COMMENT_FEATURE_COUNT = VISIBLE_COMMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.VisibleSingleLineNormalCommentImpl <em>Visible Single Line Normal Comment</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.VisibleSingleLineNormalCommentImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getVisibleSingleLineNormalComment()
   * @generated
   */
  int VISIBLE_SINGLE_LINE_NORMAL_COMMENT = 4;

  /**
   * The feature id for the '<em><b>Content</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VISIBLE_SINGLE_LINE_NORMAL_COMMENT__CONTENT = VISIBLE_SINGLE_LINE_COMMENT__CONTENT;

  /**
   * The number of structural features of the '<em>Visible Single Line Normal Comment</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VISIBLE_SINGLE_LINE_NORMAL_COMMENT_FEATURE_COUNT = VISIBLE_SINGLE_LINE_COMMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.VisibleSingleLineTitleCommentImpl <em>Visible Single Line Title Comment</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.VisibleSingleLineTitleCommentImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getVisibleSingleLineTitleComment()
   * @generated
   */
  int VISIBLE_SINGLE_LINE_TITLE_COMMENT = 5;

  /**
   * The feature id for the '<em><b>Content</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VISIBLE_SINGLE_LINE_TITLE_COMMENT__CONTENT = VISIBLE_SINGLE_LINE_COMMENT__CONTENT;

  /**
   * The number of structural features of the '<em>Visible Single Line Title Comment</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VISIBLE_SINGLE_LINE_TITLE_COMMENT_FEATURE_COUNT = VISIBLE_SINGLE_LINE_COMMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.VisibleMultiLineCommentImpl <em>Visible Multi Line Comment</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.VisibleMultiLineCommentImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getVisibleMultiLineComment()
   * @generated
   */
  int VISIBLE_MULTI_LINE_COMMENT = 6;

  /**
   * The feature id for the '<em><b>Content</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VISIBLE_MULTI_LINE_COMMENT__CONTENT = VISIBLE_COMMENT__CONTENT;

  /**
   * The number of structural features of the '<em>Visible Multi Line Comment</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VISIBLE_MULTI_LINE_COMMENT_FEATURE_COUNT = VISIBLE_COMMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.VisibleMultiLineNormalCommentImpl <em>Visible Multi Line Normal Comment</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.VisibleMultiLineNormalCommentImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getVisibleMultiLineNormalComment()
   * @generated
   */
  int VISIBLE_MULTI_LINE_NORMAL_COMMENT = 7;

  /**
   * The feature id for the '<em><b>Content</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VISIBLE_MULTI_LINE_NORMAL_COMMENT__CONTENT = VISIBLE_MULTI_LINE_COMMENT__CONTENT;

  /**
   * The number of structural features of the '<em>Visible Multi Line Normal Comment</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VISIBLE_MULTI_LINE_NORMAL_COMMENT_FEATURE_COUNT = VISIBLE_MULTI_LINE_COMMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.VisibleMultiLineTitleCommentImpl <em>Visible Multi Line Title Comment</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.VisibleMultiLineTitleCommentImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getVisibleMultiLineTitleComment()
   * @generated
   */
  int VISIBLE_MULTI_LINE_TITLE_COMMENT = 8;

  /**
   * The feature id for the '<em><b>Content</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VISIBLE_MULTI_LINE_TITLE_COMMENT__CONTENT = VISIBLE_MULTI_LINE_COMMENT__CONTENT;

  /**
   * The number of structural features of the '<em>Visible Multi Line Title Comment</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VISIBLE_MULTI_LINE_TITLE_COMMENT_FEATURE_COUNT = VISIBLE_MULTI_LINE_COMMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.VisibleDividerImpl <em>Visible Divider</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.VisibleDividerImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getVisibleDivider()
   * @generated
   */
  int VISIBLE_DIVIDER = 9;

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
  int PACKAGE_DEFINITION = 10;

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
  int PACKAGE_STATEMENT = 11;

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
  int IMPORT = 12;

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
  int FORK_DEFINITION = 13;

  /**
   * The feature id for the '<em><b>Private</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FORK_DEFINITION__PRIVATE = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FORK_DEFINITION__NAME = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FORK_DEFINITION__DESCRIPTION = STATEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Forker Class</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FORK_DEFINITION__FORKER_CLASS = STATEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FORK_DEFINITION__PARAMETERS = STATEMENT_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Fork Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FORK_DEFINITION_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.ForkParameterImpl <em>Fork Parameter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.ForkParameterImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getForkParameter()
   * @generated
   */
  int FORK_PARAMETER = 14;

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
  int VARIANT_DEFINITION = 15;

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
  int TEST_DEFINITION = 16;

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
  int CALL_DEFINITION = 17;

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
  int SUITE_DEFINITION = 18;

  /**
   * The feature id for the '<em><b>Private</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUITE_DEFINITION__PRIVATE = PACKAGE_STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Single Run</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUITE_DEFINITION__SINGLE_RUN = PACKAGE_STATEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUITE_DEFINITION__NAME = PACKAGE_STATEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUITE_DEFINITION__PARAMETERS = PACKAGE_STATEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Return</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUITE_DEFINITION__RETURN = PACKAGE_STATEMENT_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Dependencies</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUITE_DEFINITION__DEPENDENCIES = PACKAGE_STATEMENT_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Finalizers</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUITE_DEFINITION__FINALIZERS = PACKAGE_STATEMENT_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Statements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUITE_DEFINITION__STATEMENTS = PACKAGE_STATEMENT_FEATURE_COUNT + 7;

  /**
   * The number of structural features of the '<em>Suite Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUITE_DEFINITION_FEATURE_COUNT = PACKAGE_STATEMENT_FEATURE_COUNT + 8;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.SuiteParameterDefinitionImpl <em>Suite Parameter Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.SuiteParameterDefinitionImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getSuiteParameterDefinition()
   * @generated
   */
  int SUITE_PARAMETER_DEFINITION = 19;

  /**
   * The feature id for the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUITE_PARAMETER_DEFINITION__NAME = 0;

  /**
   * The feature id for the '<em><b>Default</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUITE_PARAMETER_DEFINITION__DEFAULT = 1;

  /**
   * The number of structural features of the '<em>Suite Parameter Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUITE_PARAMETER_DEFINITION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.SuiteReturnDefinitionImpl <em>Suite Return Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.SuiteReturnDefinitionImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getSuiteReturnDefinition()
   * @generated
   */
  int SUITE_RETURN_DEFINITION = 20;

  /**
   * The feature id for the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUITE_RETURN_DEFINITION__NAME = 0;

  /**
   * The number of structural features of the '<em>Suite Return Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUITE_RETURN_DEFINITION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.OperationDefinitionImpl <em>Operation Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.OperationDefinitionImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getOperationDefinition()
   * @generated
   */
  int OPERATION_DEFINITION = 21;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_DEFINITION__NAME = PACKAGE_STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operation Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_DEFINITION__OPERATION_TYPE = PACKAGE_STATEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Operation Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_DEFINITION_FEATURE_COUNT = PACKAGE_STATEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.SuiteStatementWithResultImpl <em>Suite Statement With Result</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.SuiteStatementWithResultImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getSuiteStatementWithResult()
   * @generated
   */
  int SUITE_STATEMENT_WITH_RESULT = 23;

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
  int VARIABLE_DEFINITION = 24;

  /**
   * The feature id for the '<em><b>Private</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DEFINITION__PRIVATE = PACKAGE_STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DEFINITION__NAME = PACKAGE_STATEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Initial Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DEFINITION__INITIAL_VALUE = PACKAGE_STATEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Variable Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DEFINITION_FEATURE_COUNT = PACKAGE_STATEMENT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.ConstantDefinitionImpl <em>Constant Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.ConstantDefinitionImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getConstantDefinition()
   * @generated
   */
  int CONSTANT_DEFINITION = 25;

  /**
   * The feature id for the '<em><b>Private</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT_DEFINITION__PRIVATE = PACKAGE_STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT_DEFINITION__NAME = PACKAGE_STATEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT_DEFINITION__VALUE = PACKAGE_STATEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Variant Values</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT_DEFINITION__VARIANT_VALUES = PACKAGE_STATEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Parameterized</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT_DEFINITION__PARAMETERIZED = PACKAGE_STATEMENT_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Constant Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT_DEFINITION_FEATURE_COUNT = PACKAGE_STATEMENT_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.VariableAssignmentImpl <em>Variable Assignment</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.VariableAssignmentImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getVariableAssignment()
   * @generated
   */
  int VARIABLE_ASSIGNMENT = 26;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_ASSIGNMENT__VALUE = SUITE_STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Target</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_ASSIGNMENT__TARGET = SUITE_STATEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Variable Assignment</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_ASSIGNMENT_FEATURE_COUNT = SUITE_STATEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.VariantValueImpl <em>Variant Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.VariantValueImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getVariantValue()
   * @generated
   */
  int VARIANT_VALUE = 27;

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
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.VariableOrConstantEntityImpl <em>Variable Or Constant Entity</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.VariableOrConstantEntityImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getVariableOrConstantEntity()
   * @generated
   */
  int VARIABLE_OR_CONSTANT_ENTITY = 30;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_OR_CONSTANT_ENTITY__NAME = 0;

  /**
   * The number of structural features of the '<em>Variable Or Constant Entity</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_OR_CONSTANT_ENTITY_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.VariableEntityImpl <em>Variable Entity</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.VariableEntityImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getVariableEntity()
   * @generated
   */
  int VARIABLE_ENTITY = 28;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_ENTITY__NAME = VARIABLE_OR_CONSTANT_ENTITY__NAME;

  /**
   * The number of structural features of the '<em>Variable Entity</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_ENTITY_FEATURE_COUNT = VARIABLE_OR_CONSTANT_ENTITY_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.ConstantEntityImpl <em>Constant Entity</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.ConstantEntityImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getConstantEntity()
   * @generated
   */
  int CONSTANT_ENTITY = 29;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT_ENTITY__NAME = VARIABLE_OR_CONSTANT_ENTITY__NAME;

  /**
   * The number of structural features of the '<em>Constant Entity</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT_ENTITY_FEATURE_COUNT = VARIABLE_OR_CONSTANT_ENTITY_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.TestImpl <em>Test</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.TestImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getTest()
   * @generated
   */
  int TEST = 31;

  /**
   * The feature id for the '<em><b>Checkpoint</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEST__CHECKPOINT = SUITE_STATEMENT_WITH_RESULT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Definition</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEST__DEFINITION = SUITE_STATEMENT_WITH_RESULT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEST__PARAMETERS = SUITE_STATEMENT_WITH_RESULT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Results</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEST__RESULTS = SUITE_STATEMENT_WITH_RESULT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Result</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEST__RESULT = SUITE_STATEMENT_WITH_RESULT_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Test</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEST_FEATURE_COUNT = SUITE_STATEMENT_WITH_RESULT_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.TableTestImpl <em>Table Test</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.TableTestImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getTableTest()
   * @generated
   */
  int TABLE_TEST = 32;

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
  int TABLE_TEST_ROW = 33;

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
  int PARAMETER_TABLE_HEADER = 34;

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
  int RESULT_TABLE_HEADER = 35;

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
  int PARAMETER_TABLE_VALUE = 36;

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
  int NAMED_RESULT = 37;

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
  int RESULT_NAME = 38;

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
  int FIXED_RESULT_NAME = 39;

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
  int CALL = 40;

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
  int NAMED_CALL_RESULT = 41;

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
  int SUITE = 42;

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
   * The feature id for the '<em><b>Return</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUITE__RETURN = SUITE_STATEMENT_WITH_RESULT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Fork</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUITE__FORK = SUITE_STATEMENT_WITH_RESULT_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Variants</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUITE__VARIANTS = SUITE_STATEMENT_WITH_RESULT_FEATURE_COUNT + 5;

  /**
   * The number of structural features of the '<em>Suite</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUITE_FEATURE_COUNT = SUITE_STATEMENT_WITH_RESULT_FEATURE_COUNT + 6;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.SuiteParameterImpl <em>Suite Parameter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.SuiteParameterImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getSuiteParameter()
   * @generated
   */
  int SUITE_PARAMETER = 43;

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
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.SuiteReturnImpl <em>Suite Return</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.SuiteReturnImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getSuiteReturn()
   * @generated
   */
  int SUITE_RETURN = 44;

  /**
   * The feature id for the '<em><b>Name</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUITE_RETURN__NAME = 0;

  /**
   * The feature id for the '<em><b>Target</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUITE_RETURN__TARGET = 1;

  /**
   * The number of structural features of the '<em>Suite Return</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUITE_RETURN_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.ParameterImpl <em>Parameter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.ParameterImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getParameter()
   * @generated
   */
  int PARAMETER = 45;

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
  int PARAMETER_NAME = 46;

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
  int FIXED_PARAMETER_NAME = 47;

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
  int ARBITRARY_PARAMETER_OR_RESULT_NAME = 48;

  /**
   * The feature id for the '<em><b>Identifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARBITRARY_PARAMETER_OR_RESULT_NAME__IDENTIFIER = RESULT_NAME_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>String Identifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARBITRARY_PARAMETER_OR_RESULT_NAME__STRING_IDENTIFIER = RESULT_NAME_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Arbitrary Parameter Or Result Name</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARBITRARY_PARAMETER_OR_RESULT_NAME_FEATURE_COUNT = RESULT_NAME_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.ValueOrEnumValueOrOperationImpl <em>Value Or Enum Value Or Operation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.ValueOrEnumValueOrOperationImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getValueOrEnumValueOrOperation()
   * @generated
   */
  int VALUE_OR_ENUM_VALUE_OR_OPERATION = 53;

  /**
   * The number of structural features of the '<em>Value Or Enum Value Or Operation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_OR_ENUM_VALUE_OR_OPERATION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.OperationImpl <em>Operation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.OperationImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getOperation()
   * @generated
   */
  int OPERATION = 49;

  /**
   * The number of structural features of the '<em>Operation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_FEATURE_COUNT = VALUE_OR_ENUM_VALUE_OR_OPERATION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.StandardOperationImpl <em>Standard Operation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.StandardOperationImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getStandardOperation()
   * @generated
   */
  int STANDARD_OPERATION = 50;

  /**
   * The feature id for the '<em><b>First Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STANDARD_OPERATION__FIRST_OPERAND = OPERATION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operators</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STANDARD_OPERATION__OPERATORS = OPERATION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>More Operands</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STANDARD_OPERATION__MORE_OPERANDS = OPERATION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Standard Operation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STANDARD_OPERATION_FEATURE_COUNT = OPERATION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.CustomOperationImpl <em>Custom Operation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.CustomOperationImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getCustomOperation()
   * @generated
   */
  int CUSTOM_OPERATION = 51;

  /**
   * The feature id for the '<em><b>Prefix Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CUSTOM_OPERATION__PREFIX_OPERAND = OPERATION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Definition</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CUSTOM_OPERATION__DEFINITION = OPERATION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Postfix Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CUSTOM_OPERATION__POSTFIX_OPERAND = OPERATION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Custom Operation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CUSTOM_OPERATION_FEATURE_COUNT = OPERATION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.ValueOrEnumValueOrOperationCollectionImpl <em>Value Or Enum Value Or Operation Collection</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.ValueOrEnumValueOrOperationCollectionImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getValueOrEnumValueOrOperationCollection()
   * @generated
   */
  int VALUE_OR_ENUM_VALUE_OR_OPERATION_COLLECTION = 52;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_OR_ENUM_VALUE_OR_OPERATION_COLLECTION__VALUE = 0;

  /**
   * The feature id for the '<em><b>More Values</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_OR_ENUM_VALUE_OR_OPERATION_COLLECTION__MORE_VALUES = 1;

  /**
   * The number of structural features of the '<em>Value Or Enum Value Or Operation Collection</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_OR_ENUM_VALUE_OR_OPERATION_COLLECTION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.ValueImpl <em>Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.ValueImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getValue()
   * @generated
   */
  int VALUE = 54;

  /**
   * The number of structural features of the '<em>Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VALUE_FEATURE_COUNT = VALUE_OR_ENUM_VALUE_OR_OPERATION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.ConstantValueImpl <em>Constant Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.ConstantValueImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getConstantValue()
   * @generated
   */
  int CONSTANT_VALUE = 55;

  /**
   * The number of structural features of the '<em>Constant Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT_VALUE_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.StaticValueImpl <em>Static Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.StaticValueImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getStaticValue()
   * @generated
   */
  int STATIC_VALUE = 56;

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
  int INTEGER_VALUE = 57;

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
  int DECIMAL_VALUE = 58;

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
  int STRING_VALUE = 59;

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
  int BOOLEAN_VALUE = 60;

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
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.DateValueImpl <em>Date Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.DateValueImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getDateValue()
   * @generated
   */
  int DATE_VALUE = 61;

  /**
   * The feature id for the '<em><b>Date Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATE_VALUE__DATE_VALUE = STATIC_VALUE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Date Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATE_VALUE_FEATURE_COUNT = STATIC_VALUE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.IsoDateValueImpl <em>Iso Date Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.IsoDateValueImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getIsoDateValue()
   * @generated
   */
  int ISO_DATE_VALUE = 62;

  /**
   * The feature id for the '<em><b>Date Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ISO_DATE_VALUE__DATE_VALUE = DATE_VALUE__DATE_VALUE;

  /**
   * The number of structural features of the '<em>Iso Date Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ISO_DATE_VALUE_FEATURE_COUNT = DATE_VALUE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.EuropeanDateValueImpl <em>European Date Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.EuropeanDateValueImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getEuropeanDateValue()
   * @generated
   */
  int EUROPEAN_DATE_VALUE = 63;

  /**
   * The feature id for the '<em><b>Date Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EUROPEAN_DATE_VALUE__DATE_VALUE = DATE_VALUE__DATE_VALUE;

  /**
   * The number of structural features of the '<em>European Date Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EUROPEAN_DATE_VALUE_FEATURE_COUNT = DATE_VALUE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.USDateValueImpl <em>US Date Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.USDateValueImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getUSDateValue()
   * @generated
   */
  int US_DATE_VALUE = 64;

  /**
   * The feature id for the '<em><b>Date Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int US_DATE_VALUE__DATE_VALUE = DATE_VALUE__DATE_VALUE;

  /**
   * The number of structural features of the '<em>US Date Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int US_DATE_VALUE_FEATURE_COUNT = DATE_VALUE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.TimeValueImpl <em>Time Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.TimeValueImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getTimeValue()
   * @generated
   */
  int TIME_VALUE = 65;

  /**
   * The feature id for the '<em><b>Time Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIME_VALUE__TIME_VALUE = STATIC_VALUE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Time Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIME_VALUE_FEATURE_COUNT = STATIC_VALUE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.IsoTimeValueImpl <em>Iso Time Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.IsoTimeValueImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getIsoTimeValue()
   * @generated
   */
  int ISO_TIME_VALUE = 66;

  /**
   * The feature id for the '<em><b>Time Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ISO_TIME_VALUE__TIME_VALUE = TIME_VALUE__TIME_VALUE;

  /**
   * The number of structural features of the '<em>Iso Time Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ISO_TIME_VALUE_FEATURE_COUNT = TIME_VALUE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.Simple24HrsTimeValueImpl <em>Simple24 Hrs Time Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.Simple24HrsTimeValueImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getSimple24HrsTimeValue()
   * @generated
   */
  int SIMPLE24_HRS_TIME_VALUE = 67;

  /**
   * The feature id for the '<em><b>Time Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE24_HRS_TIME_VALUE__TIME_VALUE = TIME_VALUE__TIME_VALUE;

  /**
   * The number of structural features of the '<em>Simple24 Hrs Time Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE24_HRS_TIME_VALUE_FEATURE_COUNT = TIME_VALUE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.Simple12HrsTimeValueImpl <em>Simple12 Hrs Time Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.Simple12HrsTimeValueImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getSimple12HrsTimeValue()
   * @generated
   */
  int SIMPLE12_HRS_TIME_VALUE = 68;

  /**
   * The feature id for the '<em><b>Time Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE12_HRS_TIME_VALUE__TIME_VALUE = TIME_VALUE__TIME_VALUE;

  /**
   * The number of structural features of the '<em>Simple12 Hrs Time Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE12_HRS_TIME_VALUE_FEATURE_COUNT = TIME_VALUE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.DateAndTimeValueImpl <em>Date And Time Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.DateAndTimeValueImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getDateAndTimeValue()
   * @generated
   */
  int DATE_AND_TIME_VALUE = 69;

  /**
   * The feature id for the '<em><b>Date Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATE_AND_TIME_VALUE__DATE_VALUE = STATIC_VALUE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Time Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATE_AND_TIME_VALUE__TIME_VALUE = STATIC_VALUE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Date And Time Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATE_AND_TIME_VALUE_FEATURE_COUNT = STATIC_VALUE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.IsoDateAndTimeValueImpl <em>Iso Date And Time Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.IsoDateAndTimeValueImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getIsoDateAndTimeValue()
   * @generated
   */
  int ISO_DATE_AND_TIME_VALUE = 70;

  /**
   * The feature id for the '<em><b>Date Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ISO_DATE_AND_TIME_VALUE__DATE_VALUE = DATE_AND_TIME_VALUE__DATE_VALUE;

  /**
   * The feature id for the '<em><b>Time Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ISO_DATE_AND_TIME_VALUE__TIME_VALUE = DATE_AND_TIME_VALUE__TIME_VALUE;

  /**
   * The number of structural features of the '<em>Iso Date And Time Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ISO_DATE_AND_TIME_VALUE_FEATURE_COUNT = DATE_AND_TIME_VALUE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.EuropeanDateAnd24HrsTimeValueImpl <em>European Date And24 Hrs Time Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.EuropeanDateAnd24HrsTimeValueImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getEuropeanDateAnd24HrsTimeValue()
   * @generated
   */
  int EUROPEAN_DATE_AND24_HRS_TIME_VALUE = 71;

  /**
   * The feature id for the '<em><b>Date Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EUROPEAN_DATE_AND24_HRS_TIME_VALUE__DATE_VALUE = DATE_AND_TIME_VALUE__DATE_VALUE;

  /**
   * The feature id for the '<em><b>Time Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EUROPEAN_DATE_AND24_HRS_TIME_VALUE__TIME_VALUE = DATE_AND_TIME_VALUE__TIME_VALUE;

  /**
   * The number of structural features of the '<em>European Date And24 Hrs Time Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EUROPEAN_DATE_AND24_HRS_TIME_VALUE_FEATURE_COUNT = DATE_AND_TIME_VALUE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.EuropeanDateAnd12HrsTimeValueImpl <em>European Date And12 Hrs Time Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.EuropeanDateAnd12HrsTimeValueImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getEuropeanDateAnd12HrsTimeValue()
   * @generated
   */
  int EUROPEAN_DATE_AND12_HRS_TIME_VALUE = 72;

  /**
   * The feature id for the '<em><b>Date Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EUROPEAN_DATE_AND12_HRS_TIME_VALUE__DATE_VALUE = DATE_AND_TIME_VALUE__DATE_VALUE;

  /**
   * The feature id for the '<em><b>Time Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EUROPEAN_DATE_AND12_HRS_TIME_VALUE__TIME_VALUE = DATE_AND_TIME_VALUE__TIME_VALUE;

  /**
   * The number of structural features of the '<em>European Date And12 Hrs Time Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EUROPEAN_DATE_AND12_HRS_TIME_VALUE_FEATURE_COUNT = DATE_AND_TIME_VALUE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.USDateAnd12HrsTimeValueImpl <em>US Date And12 Hrs Time Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.USDateAnd12HrsTimeValueImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getUSDateAnd12HrsTimeValue()
   * @generated
   */
  int US_DATE_AND12_HRS_TIME_VALUE = 73;

  /**
   * The feature id for the '<em><b>Date Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int US_DATE_AND12_HRS_TIME_VALUE__DATE_VALUE = DATE_AND_TIME_VALUE__DATE_VALUE;

  /**
   * The feature id for the '<em><b>Time Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int US_DATE_AND12_HRS_TIME_VALUE__TIME_VALUE = DATE_AND_TIME_VALUE__TIME_VALUE;

  /**
   * The number of structural features of the '<em>US Date And12 Hrs Time Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int US_DATE_AND12_HRS_TIME_VALUE_FEATURE_COUNT = DATE_AND_TIME_VALUE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.JavaConstantValueImpl <em>Java Constant Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.JavaConstantValueImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getJavaConstantValue()
   * @generated
   */
  int JAVA_CONSTANT_VALUE = 74;

  /**
   * The feature id for the '<em><b>Constant</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVA_CONSTANT_VALUE__CONSTANT = STATIC_VALUE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Java Constant Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVA_CONSTANT_VALUE_FEATURE_COUNT = STATIC_VALUE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.VariableImpl <em>Variable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.VariableImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getVariable()
   * @generated
   */
  int VARIABLE = 75;

  /**
   * The feature id for the '<em><b>Name</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE__NAME = VALUE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Attribute</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE__ATTRIBUTE = VALUE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Variable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_FEATURE_COUNT = VALUE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.VariableVariableImpl <em>Variable Variable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.VariableVariableImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getVariableVariable()
   * @generated
   */
  int VARIABLE_VARIABLE = 76;

  /**
   * The feature id for the '<em><b>Name</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_VARIABLE__NAME = 0;

  /**
   * The number of structural features of the '<em>Variable Variable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_VARIABLE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.ConstantImpl <em>Constant</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.ConstantImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getConstant()
   * @generated
   */
  int CONSTANT = 77;

  /**
   * The feature id for the '<em><b>Name</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT__NAME = CONSTANT_VALUE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Constant</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT_FEATURE_COUNT = CONSTANT_VALUE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.NullValueImpl <em>Null Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.NullValueImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getNullValue()
   * @generated
   */
  int NULL_VALUE = 78;

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
  int ENUM_VALUE = 79;

  /**
   * The feature id for the '<em><b>Enum Value</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_VALUE__ENUM_VALUE = VALUE_OR_ENUM_VALUE_OR_OPERATION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Enum Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUM_VALUE_FEATURE_COUNT = VALUE_OR_ENUM_VALUE_OR_OPERATION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.NestedObjectImpl <em>Nested Object</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.NestedObjectImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getNestedObject()
   * @generated
   */
  int NESTED_OBJECT = 80;

  /**
   * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NESTED_OBJECT__ATTRIBUTES = VALUE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Nested Object</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NESTED_OBJECT_FEATURE_COUNT = VALUE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.TypedNestedObjectImpl <em>Typed Nested Object</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.TypedNestedObjectImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getTypedNestedObject()
   * @generated
   */
  int TYPED_NESTED_OBJECT = 81;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPED_NESTED_OBJECT__TYPE = VALUE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Nested Object</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPED_NESTED_OBJECT__NESTED_OBJECT = VALUE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Typed Nested Object</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPED_NESTED_OBJECT_FEATURE_COUNT = VALUE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.KeyValuePairImpl <em>Key Value Pair</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.KeyValuePairImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getKeyValuePair()
   * @generated
   */
  int KEY_VALUE_PAIR = 82;

  /**
   * The feature id for the '<em><b>Identifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int KEY_VALUE_PAIR__IDENTIFIER = 0;

  /**
   * The feature id for the '<em><b>String Identifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int KEY_VALUE_PAIR__STRING_IDENTIFIER = 1;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int KEY_VALUE_PAIR__VALUE = 2;

  /**
   * The number of structural features of the '<em>Key Value Pair</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int KEY_VALUE_PAIR_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.JavaClassReferenceImpl <em>Java Class Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.JavaClassReferenceImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getJavaClassReference()
   * @generated
   */
  int JAVA_CLASS_REFERENCE = 83;

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
  int METHOD_REFERENCE = 84;

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
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.JavaConstantReferenceImpl <em>Java Constant Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.JavaConstantReferenceImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getJavaConstantReference()
   * @generated
   */
  int JAVA_CONSTANT_REFERENCE = 85;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVA_CONSTANT_REFERENCE__TYPE = 0;

  /**
   * The feature id for the '<em><b>Constant</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVA_CONSTANT_REFERENCE__CONSTANT = 1;

  /**
   * The number of structural features of the '<em>Java Constant Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVA_CONSTANT_REFERENCE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link de.gebit.integrity.dsl.impl.ExecutionMultiplierImpl <em>Execution Multiplier</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see de.gebit.integrity.dsl.impl.ExecutionMultiplierImpl
   * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getExecutionMultiplier()
   * @generated
   */
  int EXECUTION_MULTIPLIER = 86;

  /**
   * The feature id for the '<em><b>Count</b></em>' containment reference.
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
  int NULL = 87;

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
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.VisibleComment <em>Visible Comment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Visible Comment</em>'.
   * @see de.gebit.integrity.dsl.VisibleComment
   * @generated
   */
  EClass getVisibleComment();

  /**
   * Returns the meta object for the attribute '{@link de.gebit.integrity.dsl.VisibleComment#getContent <em>Content</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Content</em>'.
   * @see de.gebit.integrity.dsl.VisibleComment#getContent()
   * @see #getVisibleComment()
   * @generated
   */
  EAttribute getVisibleComment_Content();

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
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.VisibleSingleLineNormalComment <em>Visible Single Line Normal Comment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Visible Single Line Normal Comment</em>'.
   * @see de.gebit.integrity.dsl.VisibleSingleLineNormalComment
   * @generated
   */
  EClass getVisibleSingleLineNormalComment();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.VisibleSingleLineTitleComment <em>Visible Single Line Title Comment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Visible Single Line Title Comment</em>'.
   * @see de.gebit.integrity.dsl.VisibleSingleLineTitleComment
   * @generated
   */
  EClass getVisibleSingleLineTitleComment();

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
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.VisibleMultiLineNormalComment <em>Visible Multi Line Normal Comment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Visible Multi Line Normal Comment</em>'.
   * @see de.gebit.integrity.dsl.VisibleMultiLineNormalComment
   * @generated
   */
  EClass getVisibleMultiLineNormalComment();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.VisibleMultiLineTitleComment <em>Visible Multi Line Title Comment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Visible Multi Line Title Comment</em>'.
   * @see de.gebit.integrity.dsl.VisibleMultiLineTitleComment
   * @generated
   */
  EClass getVisibleMultiLineTitleComment();

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
   * Returns the meta object for the attribute '{@link de.gebit.integrity.dsl.ForkDefinition#getPrivate <em>Private</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Private</em>'.
   * @see de.gebit.integrity.dsl.ForkDefinition#getPrivate()
   * @see #getForkDefinition()
   * @generated
   */
  EAttribute getForkDefinition_Private();

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
   * Returns the meta object for the attribute '{@link de.gebit.integrity.dsl.SuiteDefinition#getPrivate <em>Private</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Private</em>'.
   * @see de.gebit.integrity.dsl.SuiteDefinition#getPrivate()
   * @see #getSuiteDefinition()
   * @generated
   */
  EAttribute getSuiteDefinition_Private();

  /**
   * Returns the meta object for the attribute '{@link de.gebit.integrity.dsl.SuiteDefinition#getSingleRun <em>Single Run</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Single Run</em>'.
   * @see de.gebit.integrity.dsl.SuiteDefinition#getSingleRun()
   * @see #getSuiteDefinition()
   * @generated
   */
  EAttribute getSuiteDefinition_SingleRun();

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
   * Returns the meta object for the containment reference list '{@link de.gebit.integrity.dsl.SuiteDefinition#getReturn <em>Return</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Return</em>'.
   * @see de.gebit.integrity.dsl.SuiteDefinition#getReturn()
   * @see #getSuiteDefinition()
   * @generated
   */
  EReference getSuiteDefinition_Return();

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
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.SuiteParameterDefinition <em>Suite Parameter Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Suite Parameter Definition</em>'.
   * @see de.gebit.integrity.dsl.SuiteParameterDefinition
   * @generated
   */
  EClass getSuiteParameterDefinition();

  /**
   * Returns the meta object for the containment reference '{@link de.gebit.integrity.dsl.SuiteParameterDefinition#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name</em>'.
   * @see de.gebit.integrity.dsl.SuiteParameterDefinition#getName()
   * @see #getSuiteParameterDefinition()
   * @generated
   */
  EReference getSuiteParameterDefinition_Name();

  /**
   * Returns the meta object for the containment reference '{@link de.gebit.integrity.dsl.SuiteParameterDefinition#getDefault <em>Default</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Default</em>'.
   * @see de.gebit.integrity.dsl.SuiteParameterDefinition#getDefault()
   * @see #getSuiteParameterDefinition()
   * @generated
   */
  EReference getSuiteParameterDefinition_Default();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.SuiteReturnDefinition <em>Suite Return Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Suite Return Definition</em>'.
   * @see de.gebit.integrity.dsl.SuiteReturnDefinition
   * @generated
   */
  EClass getSuiteReturnDefinition();

  /**
   * Returns the meta object for the containment reference '{@link de.gebit.integrity.dsl.SuiteReturnDefinition#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name</em>'.
   * @see de.gebit.integrity.dsl.SuiteReturnDefinition#getName()
   * @see #getSuiteReturnDefinition()
   * @generated
   */
  EReference getSuiteReturnDefinition_Name();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.OperationDefinition <em>Operation Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Operation Definition</em>'.
   * @see de.gebit.integrity.dsl.OperationDefinition
   * @generated
   */
  EClass getOperationDefinition();

  /**
   * Returns the meta object for the attribute '{@link de.gebit.integrity.dsl.OperationDefinition#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.gebit.integrity.dsl.OperationDefinition#getName()
   * @see #getOperationDefinition()
   * @generated
   */
  EAttribute getOperationDefinition_Name();

  /**
   * Returns the meta object for the containment reference '{@link de.gebit.integrity.dsl.OperationDefinition#getOperationType <em>Operation Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operation Type</em>'.
   * @see de.gebit.integrity.dsl.OperationDefinition#getOperationType()
   * @see #getOperationDefinition()
   * @generated
   */
  EReference getOperationDefinition_OperationType();

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
   * Returns the meta object for the attribute '{@link de.gebit.integrity.dsl.VariableDefinition#getPrivate <em>Private</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Private</em>'.
   * @see de.gebit.integrity.dsl.VariableDefinition#getPrivate()
   * @see #getVariableDefinition()
   * @generated
   */
  EAttribute getVariableDefinition_Private();

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
   * Returns the meta object for the attribute '{@link de.gebit.integrity.dsl.ConstantDefinition#getPrivate <em>Private</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Private</em>'.
   * @see de.gebit.integrity.dsl.ConstantDefinition#getPrivate()
   * @see #getConstantDefinition()
   * @generated
   */
  EAttribute getConstantDefinition_Private();

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
   * Returns the meta object for the attribute '{@link de.gebit.integrity.dsl.ConstantDefinition#getParameterized <em>Parameterized</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Parameterized</em>'.
   * @see de.gebit.integrity.dsl.ConstantDefinition#getParameterized()
   * @see #getConstantDefinition()
   * @generated
   */
  EAttribute getConstantDefinition_Parameterized();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.VariableAssignment <em>Variable Assignment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Variable Assignment</em>'.
   * @see de.gebit.integrity.dsl.VariableAssignment
   * @generated
   */
  EClass getVariableAssignment();

  /**
   * Returns the meta object for the containment reference '{@link de.gebit.integrity.dsl.VariableAssignment#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see de.gebit.integrity.dsl.VariableAssignment#getValue()
   * @see #getVariableAssignment()
   * @generated
   */
  EReference getVariableAssignment_Value();

  /**
   * Returns the meta object for the containment reference '{@link de.gebit.integrity.dsl.VariableAssignment#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Target</em>'.
   * @see de.gebit.integrity.dsl.VariableAssignment#getTarget()
   * @see #getVariableAssignment()
   * @generated
   */
  EReference getVariableAssignment_Target();

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
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.ConstantEntity <em>Constant Entity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Constant Entity</em>'.
   * @see de.gebit.integrity.dsl.ConstantEntity
   * @generated
   */
  EClass getConstantEntity();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.VariableOrConstantEntity <em>Variable Or Constant Entity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Variable Or Constant Entity</em>'.
   * @see de.gebit.integrity.dsl.VariableOrConstantEntity
   * @generated
   */
  EClass getVariableOrConstantEntity();

  /**
   * Returns the meta object for the attribute '{@link de.gebit.integrity.dsl.VariableOrConstantEntity#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see de.gebit.integrity.dsl.VariableOrConstantEntity#getName()
   * @see #getVariableOrConstantEntity()
   * @generated
   */
  EAttribute getVariableOrConstantEntity_Name();

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
   * Returns the meta object for the attribute '{@link de.gebit.integrity.dsl.Test#getCheckpoint <em>Checkpoint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Checkpoint</em>'.
   * @see de.gebit.integrity.dsl.Test#getCheckpoint()
   * @see #getTest()
   * @generated
   */
  EAttribute getTest_Checkpoint();

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
   * Returns the meta object for the containment reference list '{@link de.gebit.integrity.dsl.Suite#getReturn <em>Return</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Return</em>'.
   * @see de.gebit.integrity.dsl.Suite#getReturn()
   * @see #getSuite()
   * @generated
   */
  EReference getSuite_Return();

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
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.SuiteReturn <em>Suite Return</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Suite Return</em>'.
   * @see de.gebit.integrity.dsl.SuiteReturn
   * @generated
   */
  EClass getSuiteReturn();

  /**
   * Returns the meta object for the reference '{@link de.gebit.integrity.dsl.SuiteReturn#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Name</em>'.
   * @see de.gebit.integrity.dsl.SuiteReturn#getName()
   * @see #getSuiteReturn()
   * @generated
   */
  EReference getSuiteReturn_Name();

  /**
   * Returns the meta object for the containment reference '{@link de.gebit.integrity.dsl.SuiteReturn#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Target</em>'.
   * @see de.gebit.integrity.dsl.SuiteReturn#getTarget()
   * @see #getSuiteReturn()
   * @generated
   */
  EReference getSuiteReturn_Target();

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
   * Returns the meta object for the attribute '{@link de.gebit.integrity.dsl.ArbitraryParameterOrResultName#getStringIdentifier <em>String Identifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>String Identifier</em>'.
   * @see de.gebit.integrity.dsl.ArbitraryParameterOrResultName#getStringIdentifier()
   * @see #getArbitraryParameterOrResultName()
   * @generated
   */
  EAttribute getArbitraryParameterOrResultName_StringIdentifier();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.Operation <em>Operation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Operation</em>'.
   * @see de.gebit.integrity.dsl.Operation
   * @generated
   */
  EClass getOperation();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.StandardOperation <em>Standard Operation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Standard Operation</em>'.
   * @see de.gebit.integrity.dsl.StandardOperation
   * @generated
   */
  EClass getStandardOperation();

  /**
   * Returns the meta object for the containment reference '{@link de.gebit.integrity.dsl.StandardOperation#getFirstOperand <em>First Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>First Operand</em>'.
   * @see de.gebit.integrity.dsl.StandardOperation#getFirstOperand()
   * @see #getStandardOperation()
   * @generated
   */
  EReference getStandardOperation_FirstOperand();

  /**
   * Returns the meta object for the attribute list '{@link de.gebit.integrity.dsl.StandardOperation#getOperators <em>Operators</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Operators</em>'.
   * @see de.gebit.integrity.dsl.StandardOperation#getOperators()
   * @see #getStandardOperation()
   * @generated
   */
  EAttribute getStandardOperation_Operators();

  /**
   * Returns the meta object for the containment reference list '{@link de.gebit.integrity.dsl.StandardOperation#getMoreOperands <em>More Operands</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>More Operands</em>'.
   * @see de.gebit.integrity.dsl.StandardOperation#getMoreOperands()
   * @see #getStandardOperation()
   * @generated
   */
  EReference getStandardOperation_MoreOperands();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.CustomOperation <em>Custom Operation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Custom Operation</em>'.
   * @see de.gebit.integrity.dsl.CustomOperation
   * @generated
   */
  EClass getCustomOperation();

  /**
   * Returns the meta object for the containment reference '{@link de.gebit.integrity.dsl.CustomOperation#getPrefixOperand <em>Prefix Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Prefix Operand</em>'.
   * @see de.gebit.integrity.dsl.CustomOperation#getPrefixOperand()
   * @see #getCustomOperation()
   * @generated
   */
  EReference getCustomOperation_PrefixOperand();

  /**
   * Returns the meta object for the reference '{@link de.gebit.integrity.dsl.CustomOperation#getDefinition <em>Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Definition</em>'.
   * @see de.gebit.integrity.dsl.CustomOperation#getDefinition()
   * @see #getCustomOperation()
   * @generated
   */
  EReference getCustomOperation_Definition();

  /**
   * Returns the meta object for the containment reference '{@link de.gebit.integrity.dsl.CustomOperation#getPostfixOperand <em>Postfix Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Postfix Operand</em>'.
   * @see de.gebit.integrity.dsl.CustomOperation#getPostfixOperand()
   * @see #getCustomOperation()
   * @generated
   */
  EReference getCustomOperation_PostfixOperand();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.ValueOrEnumValueOrOperationCollection <em>Value Or Enum Value Or Operation Collection</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Value Or Enum Value Or Operation Collection</em>'.
   * @see de.gebit.integrity.dsl.ValueOrEnumValueOrOperationCollection
   * @generated
   */
  EClass getValueOrEnumValueOrOperationCollection();

  /**
   * Returns the meta object for the containment reference '{@link de.gebit.integrity.dsl.ValueOrEnumValueOrOperationCollection#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see de.gebit.integrity.dsl.ValueOrEnumValueOrOperationCollection#getValue()
   * @see #getValueOrEnumValueOrOperationCollection()
   * @generated
   */
  EReference getValueOrEnumValueOrOperationCollection_Value();

  /**
   * Returns the meta object for the containment reference list '{@link de.gebit.integrity.dsl.ValueOrEnumValueOrOperationCollection#getMoreValues <em>More Values</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>More Values</em>'.
   * @see de.gebit.integrity.dsl.ValueOrEnumValueOrOperationCollection#getMoreValues()
   * @see #getValueOrEnumValueOrOperationCollection()
   * @generated
   */
  EReference getValueOrEnumValueOrOperationCollection_MoreValues();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.ValueOrEnumValueOrOperation <em>Value Or Enum Value Or Operation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Value Or Enum Value Or Operation</em>'.
   * @see de.gebit.integrity.dsl.ValueOrEnumValueOrOperation
   * @generated
   */
  EClass getValueOrEnumValueOrOperation();

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
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.ConstantValue <em>Constant Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Constant Value</em>'.
   * @see de.gebit.integrity.dsl.ConstantValue
   * @generated
   */
  EClass getConstantValue();

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
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.DateValue <em>Date Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Date Value</em>'.
   * @see de.gebit.integrity.dsl.DateValue
   * @generated
   */
  EClass getDateValue();

  /**
   * Returns the meta object for the attribute '{@link de.gebit.integrity.dsl.DateValue#getDateValue <em>Date Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Date Value</em>'.
   * @see de.gebit.integrity.dsl.DateValue#getDateValue()
   * @see #getDateValue()
   * @generated
   */
  EAttribute getDateValue_DateValue();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.IsoDateValue <em>Iso Date Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Iso Date Value</em>'.
   * @see de.gebit.integrity.dsl.IsoDateValue
   * @generated
   */
  EClass getIsoDateValue();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.EuropeanDateValue <em>European Date Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>European Date Value</em>'.
   * @see de.gebit.integrity.dsl.EuropeanDateValue
   * @generated
   */
  EClass getEuropeanDateValue();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.USDateValue <em>US Date Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>US Date Value</em>'.
   * @see de.gebit.integrity.dsl.USDateValue
   * @generated
   */
  EClass getUSDateValue();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.TimeValue <em>Time Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Time Value</em>'.
   * @see de.gebit.integrity.dsl.TimeValue
   * @generated
   */
  EClass getTimeValue();

  /**
   * Returns the meta object for the attribute '{@link de.gebit.integrity.dsl.TimeValue#getTimeValue <em>Time Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Time Value</em>'.
   * @see de.gebit.integrity.dsl.TimeValue#getTimeValue()
   * @see #getTimeValue()
   * @generated
   */
  EAttribute getTimeValue_TimeValue();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.IsoTimeValue <em>Iso Time Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Iso Time Value</em>'.
   * @see de.gebit.integrity.dsl.IsoTimeValue
   * @generated
   */
  EClass getIsoTimeValue();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.Simple24HrsTimeValue <em>Simple24 Hrs Time Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Simple24 Hrs Time Value</em>'.
   * @see de.gebit.integrity.dsl.Simple24HrsTimeValue
   * @generated
   */
  EClass getSimple24HrsTimeValue();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.Simple12HrsTimeValue <em>Simple12 Hrs Time Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Simple12 Hrs Time Value</em>'.
   * @see de.gebit.integrity.dsl.Simple12HrsTimeValue
   * @generated
   */
  EClass getSimple12HrsTimeValue();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.DateAndTimeValue <em>Date And Time Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Date And Time Value</em>'.
   * @see de.gebit.integrity.dsl.DateAndTimeValue
   * @generated
   */
  EClass getDateAndTimeValue();

  /**
   * Returns the meta object for the attribute '{@link de.gebit.integrity.dsl.DateAndTimeValue#getDateValue <em>Date Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Date Value</em>'.
   * @see de.gebit.integrity.dsl.DateAndTimeValue#getDateValue()
   * @see #getDateAndTimeValue()
   * @generated
   */
  EAttribute getDateAndTimeValue_DateValue();

  /**
   * Returns the meta object for the attribute '{@link de.gebit.integrity.dsl.DateAndTimeValue#getTimeValue <em>Time Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Time Value</em>'.
   * @see de.gebit.integrity.dsl.DateAndTimeValue#getTimeValue()
   * @see #getDateAndTimeValue()
   * @generated
   */
  EAttribute getDateAndTimeValue_TimeValue();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.IsoDateAndTimeValue <em>Iso Date And Time Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Iso Date And Time Value</em>'.
   * @see de.gebit.integrity.dsl.IsoDateAndTimeValue
   * @generated
   */
  EClass getIsoDateAndTimeValue();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.EuropeanDateAnd24HrsTimeValue <em>European Date And24 Hrs Time Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>European Date And24 Hrs Time Value</em>'.
   * @see de.gebit.integrity.dsl.EuropeanDateAnd24HrsTimeValue
   * @generated
   */
  EClass getEuropeanDateAnd24HrsTimeValue();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.EuropeanDateAnd12HrsTimeValue <em>European Date And12 Hrs Time Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>European Date And12 Hrs Time Value</em>'.
   * @see de.gebit.integrity.dsl.EuropeanDateAnd12HrsTimeValue
   * @generated
   */
  EClass getEuropeanDateAnd12HrsTimeValue();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.USDateAnd12HrsTimeValue <em>US Date And12 Hrs Time Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>US Date And12 Hrs Time Value</em>'.
   * @see de.gebit.integrity.dsl.USDateAnd12HrsTimeValue
   * @generated
   */
  EClass getUSDateAnd12HrsTimeValue();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.JavaConstantValue <em>Java Constant Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Java Constant Value</em>'.
   * @see de.gebit.integrity.dsl.JavaConstantValue
   * @generated
   */
  EClass getJavaConstantValue();

  /**
   * Returns the meta object for the containment reference '{@link de.gebit.integrity.dsl.JavaConstantValue#getConstant <em>Constant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Constant</em>'.
   * @see de.gebit.integrity.dsl.JavaConstantValue#getConstant()
   * @see #getJavaConstantValue()
   * @generated
   */
  EReference getJavaConstantValue_Constant();

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
   * Returns the meta object for the attribute '{@link de.gebit.integrity.dsl.Variable#getAttribute <em>Attribute</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Attribute</em>'.
   * @see de.gebit.integrity.dsl.Variable#getAttribute()
   * @see #getVariable()
   * @generated
   */
  EAttribute getVariable_Attribute();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.VariableVariable <em>Variable Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Variable Variable</em>'.
   * @see de.gebit.integrity.dsl.VariableVariable
   * @generated
   */
  EClass getVariableVariable();

  /**
   * Returns the meta object for the reference '{@link de.gebit.integrity.dsl.VariableVariable#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Name</em>'.
   * @see de.gebit.integrity.dsl.VariableVariable#getName()
   * @see #getVariableVariable()
   * @generated
   */
  EReference getVariableVariable_Name();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.Constant <em>Constant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Constant</em>'.
   * @see de.gebit.integrity.dsl.Constant
   * @generated
   */
  EClass getConstant();

  /**
   * Returns the meta object for the reference '{@link de.gebit.integrity.dsl.Constant#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Name</em>'.
   * @see de.gebit.integrity.dsl.Constant#getName()
   * @see #getConstant()
   * @generated
   */
  EReference getConstant_Name();

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
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.NestedObject <em>Nested Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Nested Object</em>'.
   * @see de.gebit.integrity.dsl.NestedObject
   * @generated
   */
  EClass getNestedObject();

  /**
   * Returns the meta object for the containment reference list '{@link de.gebit.integrity.dsl.NestedObject#getAttributes <em>Attributes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Attributes</em>'.
   * @see de.gebit.integrity.dsl.NestedObject#getAttributes()
   * @see #getNestedObject()
   * @generated
   */
  EReference getNestedObject_Attributes();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.TypedNestedObject <em>Typed Nested Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Typed Nested Object</em>'.
   * @see de.gebit.integrity.dsl.TypedNestedObject
   * @generated
   */
  EClass getTypedNestedObject();

  /**
   * Returns the meta object for the containment reference '{@link de.gebit.integrity.dsl.TypedNestedObject#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see de.gebit.integrity.dsl.TypedNestedObject#getType()
   * @see #getTypedNestedObject()
   * @generated
   */
  EReference getTypedNestedObject_Type();

  /**
   * Returns the meta object for the containment reference '{@link de.gebit.integrity.dsl.TypedNestedObject#getNestedObject <em>Nested Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Nested Object</em>'.
   * @see de.gebit.integrity.dsl.TypedNestedObject#getNestedObject()
   * @see #getTypedNestedObject()
   * @generated
   */
  EReference getTypedNestedObject_NestedObject();

  /**
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.KeyValuePair <em>Key Value Pair</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Key Value Pair</em>'.
   * @see de.gebit.integrity.dsl.KeyValuePair
   * @generated
   */
  EClass getKeyValuePair();

  /**
   * Returns the meta object for the attribute '{@link de.gebit.integrity.dsl.KeyValuePair#getIdentifier <em>Identifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Identifier</em>'.
   * @see de.gebit.integrity.dsl.KeyValuePair#getIdentifier()
   * @see #getKeyValuePair()
   * @generated
   */
  EAttribute getKeyValuePair_Identifier();

  /**
   * Returns the meta object for the attribute '{@link de.gebit.integrity.dsl.KeyValuePair#getStringIdentifier <em>String Identifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>String Identifier</em>'.
   * @see de.gebit.integrity.dsl.KeyValuePair#getStringIdentifier()
   * @see #getKeyValuePair()
   * @generated
   */
  EAttribute getKeyValuePair_StringIdentifier();

  /**
   * Returns the meta object for the containment reference '{@link de.gebit.integrity.dsl.KeyValuePair#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see de.gebit.integrity.dsl.KeyValuePair#getValue()
   * @see #getKeyValuePair()
   * @generated
   */
  EReference getKeyValuePair_Value();

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
   * Returns the meta object for class '{@link de.gebit.integrity.dsl.JavaConstantReference <em>Java Constant Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Java Constant Reference</em>'.
   * @see de.gebit.integrity.dsl.JavaConstantReference
   * @generated
   */
  EClass getJavaConstantReference();

  /**
   * Returns the meta object for the reference '{@link de.gebit.integrity.dsl.JavaConstantReference#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Type</em>'.
   * @see de.gebit.integrity.dsl.JavaConstantReference#getType()
   * @see #getJavaConstantReference()
   * @generated
   */
  EReference getJavaConstantReference_Type();

  /**
   * Returns the meta object for the reference '{@link de.gebit.integrity.dsl.JavaConstantReference#getConstant <em>Constant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Constant</em>'.
   * @see de.gebit.integrity.dsl.JavaConstantReference#getConstant()
   * @see #getJavaConstantReference()
   * @generated
   */
  EReference getJavaConstantReference_Constant();

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
   * Returns the meta object for the containment reference '{@link de.gebit.integrity.dsl.ExecutionMultiplier#getCount <em>Count</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Count</em>'.
   * @see de.gebit.integrity.dsl.ExecutionMultiplier#getCount()
   * @see #getExecutionMultiplier()
   * @generated
   */
  EReference getExecutionMultiplier_Count();

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
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.VisibleCommentImpl <em>Visible Comment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.VisibleCommentImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getVisibleComment()
     * @generated
     */
    EClass VISIBLE_COMMENT = eINSTANCE.getVisibleComment();

    /**
     * The meta object literal for the '<em><b>Content</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VISIBLE_COMMENT__CONTENT = eINSTANCE.getVisibleComment_Content();

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
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.VisibleSingleLineNormalCommentImpl <em>Visible Single Line Normal Comment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.VisibleSingleLineNormalCommentImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getVisibleSingleLineNormalComment()
     * @generated
     */
    EClass VISIBLE_SINGLE_LINE_NORMAL_COMMENT = eINSTANCE.getVisibleSingleLineNormalComment();

    /**
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.VisibleSingleLineTitleCommentImpl <em>Visible Single Line Title Comment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.VisibleSingleLineTitleCommentImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getVisibleSingleLineTitleComment()
     * @generated
     */
    EClass VISIBLE_SINGLE_LINE_TITLE_COMMENT = eINSTANCE.getVisibleSingleLineTitleComment();

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
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.VisibleMultiLineNormalCommentImpl <em>Visible Multi Line Normal Comment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.VisibleMultiLineNormalCommentImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getVisibleMultiLineNormalComment()
     * @generated
     */
    EClass VISIBLE_MULTI_LINE_NORMAL_COMMENT = eINSTANCE.getVisibleMultiLineNormalComment();

    /**
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.VisibleMultiLineTitleCommentImpl <em>Visible Multi Line Title Comment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.VisibleMultiLineTitleCommentImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getVisibleMultiLineTitleComment()
     * @generated
     */
    EClass VISIBLE_MULTI_LINE_TITLE_COMMENT = eINSTANCE.getVisibleMultiLineTitleComment();

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
     * The meta object literal for the '<em><b>Private</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FORK_DEFINITION__PRIVATE = eINSTANCE.getForkDefinition_Private();

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
     * The meta object literal for the '<em><b>Private</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SUITE_DEFINITION__PRIVATE = eINSTANCE.getSuiteDefinition_Private();

    /**
     * The meta object literal for the '<em><b>Single Run</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SUITE_DEFINITION__SINGLE_RUN = eINSTANCE.getSuiteDefinition_SingleRun();

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
     * The meta object literal for the '<em><b>Return</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUITE_DEFINITION__RETURN = eINSTANCE.getSuiteDefinition_Return();

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
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.SuiteParameterDefinitionImpl <em>Suite Parameter Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.SuiteParameterDefinitionImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getSuiteParameterDefinition()
     * @generated
     */
    EClass SUITE_PARAMETER_DEFINITION = eINSTANCE.getSuiteParameterDefinition();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUITE_PARAMETER_DEFINITION__NAME = eINSTANCE.getSuiteParameterDefinition_Name();

    /**
     * The meta object literal for the '<em><b>Default</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUITE_PARAMETER_DEFINITION__DEFAULT = eINSTANCE.getSuiteParameterDefinition_Default();

    /**
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.SuiteReturnDefinitionImpl <em>Suite Return Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.SuiteReturnDefinitionImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getSuiteReturnDefinition()
     * @generated
     */
    EClass SUITE_RETURN_DEFINITION = eINSTANCE.getSuiteReturnDefinition();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUITE_RETURN_DEFINITION__NAME = eINSTANCE.getSuiteReturnDefinition_Name();

    /**
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.OperationDefinitionImpl <em>Operation Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.OperationDefinitionImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getOperationDefinition()
     * @generated
     */
    EClass OPERATION_DEFINITION = eINSTANCE.getOperationDefinition();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OPERATION_DEFINITION__NAME = eINSTANCE.getOperationDefinition_Name();

    /**
     * The meta object literal for the '<em><b>Operation Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OPERATION_DEFINITION__OPERATION_TYPE = eINSTANCE.getOperationDefinition_OperationType();

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
     * The meta object literal for the '<em><b>Private</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VARIABLE_DEFINITION__PRIVATE = eINSTANCE.getVariableDefinition_Private();

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
     * The meta object literal for the '<em><b>Private</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONSTANT_DEFINITION__PRIVATE = eINSTANCE.getConstantDefinition_Private();

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
     * The meta object literal for the '<em><b>Parameterized</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONSTANT_DEFINITION__PARAMETERIZED = eINSTANCE.getConstantDefinition_Parameterized();

    /**
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.VariableAssignmentImpl <em>Variable Assignment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.VariableAssignmentImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getVariableAssignment()
     * @generated
     */
    EClass VARIABLE_ASSIGNMENT = eINSTANCE.getVariableAssignment();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VARIABLE_ASSIGNMENT__VALUE = eINSTANCE.getVariableAssignment_Value();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VARIABLE_ASSIGNMENT__TARGET = eINSTANCE.getVariableAssignment_Target();

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
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.ConstantEntityImpl <em>Constant Entity</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.ConstantEntityImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getConstantEntity()
     * @generated
     */
    EClass CONSTANT_ENTITY = eINSTANCE.getConstantEntity();

    /**
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.VariableOrConstantEntityImpl <em>Variable Or Constant Entity</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.VariableOrConstantEntityImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getVariableOrConstantEntity()
     * @generated
     */
    EClass VARIABLE_OR_CONSTANT_ENTITY = eINSTANCE.getVariableOrConstantEntity();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VARIABLE_OR_CONSTANT_ENTITY__NAME = eINSTANCE.getVariableOrConstantEntity_Name();

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
     * The meta object literal for the '<em><b>Checkpoint</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TEST__CHECKPOINT = eINSTANCE.getTest_Checkpoint();

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
     * The meta object literal for the '<em><b>Return</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUITE__RETURN = eINSTANCE.getSuite_Return();

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
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.SuiteReturnImpl <em>Suite Return</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.SuiteReturnImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getSuiteReturn()
     * @generated
     */
    EClass SUITE_RETURN = eINSTANCE.getSuiteReturn();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUITE_RETURN__NAME = eINSTANCE.getSuiteReturn_Name();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUITE_RETURN__TARGET = eINSTANCE.getSuiteReturn_Target();

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
     * The meta object literal for the '<em><b>String Identifier</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ARBITRARY_PARAMETER_OR_RESULT_NAME__STRING_IDENTIFIER = eINSTANCE.getArbitraryParameterOrResultName_StringIdentifier();

    /**
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.OperationImpl <em>Operation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.OperationImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getOperation()
     * @generated
     */
    EClass OPERATION = eINSTANCE.getOperation();

    /**
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.StandardOperationImpl <em>Standard Operation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.StandardOperationImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getStandardOperation()
     * @generated
     */
    EClass STANDARD_OPERATION = eINSTANCE.getStandardOperation();

    /**
     * The meta object literal for the '<em><b>First Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STANDARD_OPERATION__FIRST_OPERAND = eINSTANCE.getStandardOperation_FirstOperand();

    /**
     * The meta object literal for the '<em><b>Operators</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STANDARD_OPERATION__OPERATORS = eINSTANCE.getStandardOperation_Operators();

    /**
     * The meta object literal for the '<em><b>More Operands</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STANDARD_OPERATION__MORE_OPERANDS = eINSTANCE.getStandardOperation_MoreOperands();

    /**
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.CustomOperationImpl <em>Custom Operation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.CustomOperationImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getCustomOperation()
     * @generated
     */
    EClass CUSTOM_OPERATION = eINSTANCE.getCustomOperation();

    /**
     * The meta object literal for the '<em><b>Prefix Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CUSTOM_OPERATION__PREFIX_OPERAND = eINSTANCE.getCustomOperation_PrefixOperand();

    /**
     * The meta object literal for the '<em><b>Definition</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CUSTOM_OPERATION__DEFINITION = eINSTANCE.getCustomOperation_Definition();

    /**
     * The meta object literal for the '<em><b>Postfix Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CUSTOM_OPERATION__POSTFIX_OPERAND = eINSTANCE.getCustomOperation_PostfixOperand();

    /**
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.ValueOrEnumValueOrOperationCollectionImpl <em>Value Or Enum Value Or Operation Collection</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.ValueOrEnumValueOrOperationCollectionImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getValueOrEnumValueOrOperationCollection()
     * @generated
     */
    EClass VALUE_OR_ENUM_VALUE_OR_OPERATION_COLLECTION = eINSTANCE.getValueOrEnumValueOrOperationCollection();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VALUE_OR_ENUM_VALUE_OR_OPERATION_COLLECTION__VALUE = eINSTANCE.getValueOrEnumValueOrOperationCollection_Value();

    /**
     * The meta object literal for the '<em><b>More Values</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VALUE_OR_ENUM_VALUE_OR_OPERATION_COLLECTION__MORE_VALUES = eINSTANCE.getValueOrEnumValueOrOperationCollection_MoreValues();

    /**
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.ValueOrEnumValueOrOperationImpl <em>Value Or Enum Value Or Operation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.ValueOrEnumValueOrOperationImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getValueOrEnumValueOrOperation()
     * @generated
     */
    EClass VALUE_OR_ENUM_VALUE_OR_OPERATION = eINSTANCE.getValueOrEnumValueOrOperation();

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
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.ConstantValueImpl <em>Constant Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.ConstantValueImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getConstantValue()
     * @generated
     */
    EClass CONSTANT_VALUE = eINSTANCE.getConstantValue();

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
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.DateValueImpl <em>Date Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.DateValueImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getDateValue()
     * @generated
     */
    EClass DATE_VALUE = eINSTANCE.getDateValue();

    /**
     * The meta object literal for the '<em><b>Date Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DATE_VALUE__DATE_VALUE = eINSTANCE.getDateValue_DateValue();

    /**
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.IsoDateValueImpl <em>Iso Date Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.IsoDateValueImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getIsoDateValue()
     * @generated
     */
    EClass ISO_DATE_VALUE = eINSTANCE.getIsoDateValue();

    /**
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.EuropeanDateValueImpl <em>European Date Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.EuropeanDateValueImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getEuropeanDateValue()
     * @generated
     */
    EClass EUROPEAN_DATE_VALUE = eINSTANCE.getEuropeanDateValue();

    /**
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.USDateValueImpl <em>US Date Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.USDateValueImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getUSDateValue()
     * @generated
     */
    EClass US_DATE_VALUE = eINSTANCE.getUSDateValue();

    /**
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.TimeValueImpl <em>Time Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.TimeValueImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getTimeValue()
     * @generated
     */
    EClass TIME_VALUE = eINSTANCE.getTimeValue();

    /**
     * The meta object literal for the '<em><b>Time Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TIME_VALUE__TIME_VALUE = eINSTANCE.getTimeValue_TimeValue();

    /**
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.IsoTimeValueImpl <em>Iso Time Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.IsoTimeValueImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getIsoTimeValue()
     * @generated
     */
    EClass ISO_TIME_VALUE = eINSTANCE.getIsoTimeValue();

    /**
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.Simple24HrsTimeValueImpl <em>Simple24 Hrs Time Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.Simple24HrsTimeValueImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getSimple24HrsTimeValue()
     * @generated
     */
    EClass SIMPLE24_HRS_TIME_VALUE = eINSTANCE.getSimple24HrsTimeValue();

    /**
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.Simple12HrsTimeValueImpl <em>Simple12 Hrs Time Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.Simple12HrsTimeValueImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getSimple12HrsTimeValue()
     * @generated
     */
    EClass SIMPLE12_HRS_TIME_VALUE = eINSTANCE.getSimple12HrsTimeValue();

    /**
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.DateAndTimeValueImpl <em>Date And Time Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.DateAndTimeValueImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getDateAndTimeValue()
     * @generated
     */
    EClass DATE_AND_TIME_VALUE = eINSTANCE.getDateAndTimeValue();

    /**
     * The meta object literal for the '<em><b>Date Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DATE_AND_TIME_VALUE__DATE_VALUE = eINSTANCE.getDateAndTimeValue_DateValue();

    /**
     * The meta object literal for the '<em><b>Time Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DATE_AND_TIME_VALUE__TIME_VALUE = eINSTANCE.getDateAndTimeValue_TimeValue();

    /**
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.IsoDateAndTimeValueImpl <em>Iso Date And Time Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.IsoDateAndTimeValueImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getIsoDateAndTimeValue()
     * @generated
     */
    EClass ISO_DATE_AND_TIME_VALUE = eINSTANCE.getIsoDateAndTimeValue();

    /**
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.EuropeanDateAnd24HrsTimeValueImpl <em>European Date And24 Hrs Time Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.EuropeanDateAnd24HrsTimeValueImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getEuropeanDateAnd24HrsTimeValue()
     * @generated
     */
    EClass EUROPEAN_DATE_AND24_HRS_TIME_VALUE = eINSTANCE.getEuropeanDateAnd24HrsTimeValue();

    /**
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.EuropeanDateAnd12HrsTimeValueImpl <em>European Date And12 Hrs Time Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.EuropeanDateAnd12HrsTimeValueImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getEuropeanDateAnd12HrsTimeValue()
     * @generated
     */
    EClass EUROPEAN_DATE_AND12_HRS_TIME_VALUE = eINSTANCE.getEuropeanDateAnd12HrsTimeValue();

    /**
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.USDateAnd12HrsTimeValueImpl <em>US Date And12 Hrs Time Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.USDateAnd12HrsTimeValueImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getUSDateAnd12HrsTimeValue()
     * @generated
     */
    EClass US_DATE_AND12_HRS_TIME_VALUE = eINSTANCE.getUSDateAnd12HrsTimeValue();

    /**
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.JavaConstantValueImpl <em>Java Constant Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.JavaConstantValueImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getJavaConstantValue()
     * @generated
     */
    EClass JAVA_CONSTANT_VALUE = eINSTANCE.getJavaConstantValue();

    /**
     * The meta object literal for the '<em><b>Constant</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference JAVA_CONSTANT_VALUE__CONSTANT = eINSTANCE.getJavaConstantValue_Constant();

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
     * The meta object literal for the '<em><b>Attribute</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VARIABLE__ATTRIBUTE = eINSTANCE.getVariable_Attribute();

    /**
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.VariableVariableImpl <em>Variable Variable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.VariableVariableImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getVariableVariable()
     * @generated
     */
    EClass VARIABLE_VARIABLE = eINSTANCE.getVariableVariable();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VARIABLE_VARIABLE__NAME = eINSTANCE.getVariableVariable_Name();

    /**
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.ConstantImpl <em>Constant</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.ConstantImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getConstant()
     * @generated
     */
    EClass CONSTANT = eINSTANCE.getConstant();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONSTANT__NAME = eINSTANCE.getConstant_Name();

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
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.NestedObjectImpl <em>Nested Object</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.NestedObjectImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getNestedObject()
     * @generated
     */
    EClass NESTED_OBJECT = eINSTANCE.getNestedObject();

    /**
     * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NESTED_OBJECT__ATTRIBUTES = eINSTANCE.getNestedObject_Attributes();

    /**
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.TypedNestedObjectImpl <em>Typed Nested Object</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.TypedNestedObjectImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getTypedNestedObject()
     * @generated
     */
    EClass TYPED_NESTED_OBJECT = eINSTANCE.getTypedNestedObject();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPED_NESTED_OBJECT__TYPE = eINSTANCE.getTypedNestedObject_Type();

    /**
     * The meta object literal for the '<em><b>Nested Object</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPED_NESTED_OBJECT__NESTED_OBJECT = eINSTANCE.getTypedNestedObject_NestedObject();

    /**
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.KeyValuePairImpl <em>Key Value Pair</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.KeyValuePairImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getKeyValuePair()
     * @generated
     */
    EClass KEY_VALUE_PAIR = eINSTANCE.getKeyValuePair();

    /**
     * The meta object literal for the '<em><b>Identifier</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute KEY_VALUE_PAIR__IDENTIFIER = eINSTANCE.getKeyValuePair_Identifier();

    /**
     * The meta object literal for the '<em><b>String Identifier</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute KEY_VALUE_PAIR__STRING_IDENTIFIER = eINSTANCE.getKeyValuePair_StringIdentifier();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference KEY_VALUE_PAIR__VALUE = eINSTANCE.getKeyValuePair_Value();

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
     * The meta object literal for the '{@link de.gebit.integrity.dsl.impl.JavaConstantReferenceImpl <em>Java Constant Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see de.gebit.integrity.dsl.impl.JavaConstantReferenceImpl
     * @see de.gebit.integrity.dsl.impl.DslPackageImpl#getJavaConstantReference()
     * @generated
     */
    EClass JAVA_CONSTANT_REFERENCE = eINSTANCE.getJavaConstantReference();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference JAVA_CONSTANT_REFERENCE__TYPE = eINSTANCE.getJavaConstantReference_Type();

    /**
     * The meta object literal for the '<em><b>Constant</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference JAVA_CONSTANT_REFERENCE__CONSTANT = eINSTANCE.getJavaConstantReference_Constant();

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
     * The meta object literal for the '<em><b>Count</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXECUTION_MULTIPLIER__COUNT = eINSTANCE.getExecutionMultiplier_Count();

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
