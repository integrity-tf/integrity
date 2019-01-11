/**
 */
package de.gebit.integrity.dsl.impl;

import de.gebit.integrity.dsl.ArbitraryParameterOrResultName;
import de.gebit.integrity.dsl.BooleanValue;
import de.gebit.integrity.dsl.Call;
import de.gebit.integrity.dsl.CallDefinition;
import de.gebit.integrity.dsl.Constant;
import de.gebit.integrity.dsl.ConstantDefinition;
import de.gebit.integrity.dsl.ConstantEntity;
import de.gebit.integrity.dsl.ConstantValue;
import de.gebit.integrity.dsl.CustomOperation;
import de.gebit.integrity.dsl.DateAndTimeValue;
import de.gebit.integrity.dsl.DateValue;
import de.gebit.integrity.dsl.DecimalValue;
import de.gebit.integrity.dsl.DocumentationComment;
import de.gebit.integrity.dsl.DslFactory;
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
import de.gebit.integrity.dsl.Inexistent;
import de.gebit.integrity.dsl.InexistentValue;
import de.gebit.integrity.dsl.IntegerValue;
import de.gebit.integrity.dsl.IsoDateAndTimeValue;
import de.gebit.integrity.dsl.IsoDateValue;
import de.gebit.integrity.dsl.IsoTimeValue;
import de.gebit.integrity.dsl.JavaClassReference;
import de.gebit.integrity.dsl.JavaConstantReference;
import de.gebit.integrity.dsl.JavaConstantValue;
import de.gebit.integrity.dsl.KeyValuePair;
import de.gebit.integrity.dsl.MethodReference;
import de.gebit.integrity.dsl.Model;
import de.gebit.integrity.dsl.NamedCallResult;
import de.gebit.integrity.dsl.NamedResult;
import de.gebit.integrity.dsl.NestedObject;
import de.gebit.integrity.dsl.Null;
import de.gebit.integrity.dsl.NullValue;
import de.gebit.integrity.dsl.Operation;
import de.gebit.integrity.dsl.OperationDefinition;
import de.gebit.integrity.dsl.PackageDefinition;
import de.gebit.integrity.dsl.PackageStatement;
import de.gebit.integrity.dsl.Parameter;
import de.gebit.integrity.dsl.ParameterName;
import de.gebit.integrity.dsl.ParameterTableHeader;
import de.gebit.integrity.dsl.ParameterTableValue;
import de.gebit.integrity.dsl.ResultName;
import de.gebit.integrity.dsl.ResultTableHeader;
import de.gebit.integrity.dsl.Simple12HrsTimeValue;
import de.gebit.integrity.dsl.Simple24HrsTimeValue;
import de.gebit.integrity.dsl.StandardOperation;
import de.gebit.integrity.dsl.Statement;
import de.gebit.integrity.dsl.StaticValue;
import de.gebit.integrity.dsl.StringValue;
import de.gebit.integrity.dsl.Suite;
import de.gebit.integrity.dsl.SuiteDefinition;
import de.gebit.integrity.dsl.SuiteParameter;
import de.gebit.integrity.dsl.SuiteParameterDefinition;
import de.gebit.integrity.dsl.SuiteReturn;
import de.gebit.integrity.dsl.SuiteReturnDefinition;
import de.gebit.integrity.dsl.SuiteStatement;
import de.gebit.integrity.dsl.SuiteStatementWithResult;
import de.gebit.integrity.dsl.TableTest;
import de.gebit.integrity.dsl.TableTestRow;
import de.gebit.integrity.dsl.Test;
import de.gebit.integrity.dsl.TestDefinition;
import de.gebit.integrity.dsl.TimeDifference;
import de.gebit.integrity.dsl.TimeProgressionFactor;
import de.gebit.integrity.dsl.TimeSet;
import de.gebit.integrity.dsl.TimeValue;
import de.gebit.integrity.dsl.TypedNestedObject;
import de.gebit.integrity.dsl.USDateAnd12HrsTimeValue;
import de.gebit.integrity.dsl.USDateValue;
import de.gebit.integrity.dsl.Value;
import de.gebit.integrity.dsl.ValueOrEnumValueOrOperation;
import de.gebit.integrity.dsl.ValueOrEnumValueOrOperationCollection;
import de.gebit.integrity.dsl.Variable;
import de.gebit.integrity.dsl.VariableAssignment;
import de.gebit.integrity.dsl.VariableDefinition;
import de.gebit.integrity.dsl.VariableEntity;
import de.gebit.integrity.dsl.VariableOrConstantEntity;
import de.gebit.integrity.dsl.VariableVariable;
import de.gebit.integrity.dsl.VariantDefinition;
import de.gebit.integrity.dsl.VariantValue;
import de.gebit.integrity.dsl.VisibleComment;
import de.gebit.integrity.dsl.VisibleDivider;
import de.gebit.integrity.dsl.VisibleMultiLineComment;
import de.gebit.integrity.dsl.VisibleMultiLineNormalComment;
import de.gebit.integrity.dsl.VisibleMultiLineTitleComment;
import de.gebit.integrity.dsl.VisibleSingleLineComment;
import de.gebit.integrity.dsl.VisibleSingleLineNormalComment;
import de.gebit.integrity.dsl.VisibleSingleLineTitleComment;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.xtext.common.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DslPackageImpl extends EPackageImpl implements DslPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass modelEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass statementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass visibleCommentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass visibleSingleLineCommentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass visibleSingleLineNormalCommentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass visibleSingleLineTitleCommentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass visibleMultiLineCommentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass visibleMultiLineNormalCommentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass visibleMultiLineTitleCommentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass visibleDividerEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass packageDefinitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass packageStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass importEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass forkDefinitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass forkParameterEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass variantDefinitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass testDefinitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass callDefinitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass suiteDefinitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass suiteParameterDefinitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass suiteReturnDefinitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass operationDefinitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass suiteStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass suiteStatementWithResultEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass variableDefinitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass constantDefinitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass variableAssignmentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass variantValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass variableEntityEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass constantEntityEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass variableOrConstantEntityEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass testEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tableTestEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tableTestRowEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass parameterTableHeaderEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass resultTableHeaderEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass parameterTableValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass namedResultEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass resultNameEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass fixedResultNameEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass callEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass namedCallResultEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass timeSetEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass timeProgressionFactorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass timeDifferenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass suiteEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass suiteParameterEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass suiteReturnEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass parameterEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass parameterNameEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass fixedParameterNameEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass arbitraryParameterOrResultNameEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass operationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass standardOperationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass customOperationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass valueOrEnumValueOrOperationCollectionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass valueOrEnumValueOrOperationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass valueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass constantValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass staticValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass integerValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass decimalValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass stringValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass booleanValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass dateValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass isoDateValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass europeanDateValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass usDateValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass timeValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass isoTimeValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass simple24HrsTimeValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass simple12HrsTimeValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass dateAndTimeValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass isoDateAndTimeValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass europeanDateAnd24HrsTimeValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass europeanDateAnd12HrsTimeValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass usDateAnd12HrsTimeValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass javaConstantValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass variableEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass variableVariableEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass constantEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nullValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass inexistentValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass enumValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nestedObjectEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typedNestedObjectEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass keyValuePairEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass javaClassReferenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass methodReferenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass javaConstantReferenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass executionMultiplierEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass documentationCommentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nullEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass inexistentEClass = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see de.gebit.integrity.dsl.DslPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private DslPackageImpl()
  {
    super(eNS_URI, DslFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   *
   * <p>This method is used to initialize {@link DslPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static DslPackage init()
  {
    if (isInited) return (DslPackage)EPackage.Registry.INSTANCE.getEPackage(DslPackage.eNS_URI);

    // Obtain or create and register package
    Object registeredDslPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
    DslPackageImpl theDslPackage = registeredDslPackage instanceof DslPackageImpl ? (DslPackageImpl)registeredDslPackage : new DslPackageImpl();

    isInited = true;

    // Initialize simple dependencies
    TypesPackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theDslPackage.createPackageContents();

    // Initialize created meta-data
    theDslPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theDslPackage.freeze();

    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(DslPackage.eNS_URI, theDslPackage);
    return theDslPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getModel()
  {
    return modelEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_Imports()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModel_Statements()
  {
    return (EReference)modelEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStatement()
  {
    return statementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStatement_Documentation()
  {
    return (EReference)statementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getStatement_Name()
  {
    return (EAttribute)statementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVisibleComment()
  {
    return visibleCommentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVisibleComment_Content()
  {
    return (EAttribute)visibleCommentEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVisibleSingleLineComment()
  {
    return visibleSingleLineCommentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVisibleSingleLineNormalComment()
  {
    return visibleSingleLineNormalCommentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVisibleSingleLineTitleComment()
  {
    return visibleSingleLineTitleCommentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVisibleMultiLineComment()
  {
    return visibleMultiLineCommentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVisibleMultiLineNormalComment()
  {
    return visibleMultiLineNormalCommentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVisibleMultiLineTitleComment()
  {
    return visibleMultiLineTitleCommentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVisibleDivider()
  {
    return visibleDividerEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVisibleDivider_Content()
  {
    return (EAttribute)visibleDividerEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPackageDefinition()
  {
    return packageDefinitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPackageDefinition_Statements()
  {
    return (EReference)packageDefinitionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPackageStatement()
  {
    return packageStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getImport()
  {
    return importEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getImport_ImportedNamespace()
  {
    return (EAttribute)importEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getForkDefinition()
  {
    return forkDefinitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getForkDefinition_Private()
  {
    return (EAttribute)forkDefinitionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getForkDefinition_Description()
  {
    return (EAttribute)forkDefinitionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getForkDefinition_ForkerClass()
  {
    return (EReference)forkDefinitionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getForkDefinition_BaseFork()
  {
    return (EReference)forkDefinitionEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getForkDefinition_Parameters()
  {
    return (EReference)forkDefinitionEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getForkParameter()
  {
    return forkParameterEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getForkParameter_Name()
  {
    return (EReference)forkParameterEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getForkParameter_Value()
  {
    return (EReference)forkParameterEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVariantDefinition()
  {
    return variantDefinitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVariantDefinition_Description()
  {
    return (EAttribute)variantDefinitionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTestDefinition()
  {
    return testDefinitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTestDefinition_Documentation()
  {
    return (EReference)testDefinitionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTestDefinition_Name()
  {
    return (EAttribute)testDefinitionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTestDefinition_FixtureMethod()
  {
    return (EReference)testDefinitionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCallDefinition()
  {
    return callDefinitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCallDefinition_Documentation()
  {
    return (EReference)callDefinitionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getCallDefinition_Name()
  {
    return (EAttribute)callDefinitionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCallDefinition_FixtureMethod()
  {
    return (EReference)callDefinitionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSuiteDefinition()
  {
    return suiteDefinitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSuiteDefinition_Documentation()
  {
    return (EReference)suiteDefinitionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSuiteDefinition_Private()
  {
    return (EAttribute)suiteDefinitionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSuiteDefinition_SingleRun()
  {
    return (EAttribute)suiteDefinitionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSuiteDefinition_Inlined()
  {
    return (EAttribute)suiteDefinitionEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSuiteDefinition_Name()
  {
    return (EAttribute)suiteDefinitionEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSuiteDefinition_Parameters()
  {
    return (EReference)suiteDefinitionEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSuiteDefinition_Return()
  {
    return (EReference)suiteDefinitionEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSuiteDefinition_Dependencies()
  {
    return (EReference)suiteDefinitionEClass.getEStructuralFeatures().get(7);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSuiteDefinition_Finalizers()
  {
    return (EReference)suiteDefinitionEClass.getEStructuralFeatures().get(8);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSuiteDefinition_Statements()
  {
    return (EReference)suiteDefinitionEClass.getEStructuralFeatures().get(9);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSuiteParameterDefinition()
  {
    return suiteParameterDefinitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSuiteParameterDefinition_Name()
  {
    return (EReference)suiteParameterDefinitionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSuiteParameterDefinition_Default()
  {
    return (EReference)suiteParameterDefinitionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSuiteReturnDefinition()
  {
    return suiteReturnDefinitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSuiteReturnDefinition_Name()
  {
    return (EReference)suiteReturnDefinitionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOperationDefinition()
  {
    return operationDefinitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getOperationDefinition_Name()
  {
    return (EAttribute)operationDefinitionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOperationDefinition_OperationType()
  {
    return (EReference)operationDefinitionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSuiteStatement()
  {
    return suiteStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSuiteStatementWithResult()
  {
    return suiteStatementWithResultEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVariableDefinition()
  {
    return variableDefinitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVariableDefinition_Private()
  {
    return (EAttribute)variableDefinitionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVariableDefinition_Name()
  {
    return (EReference)variableDefinitionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVariableDefinition_InitialValue()
  {
    return (EReference)variableDefinitionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConstantDefinition()
  {
    return constantDefinitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConstantDefinition_Documentation()
  {
    return (EReference)constantDefinitionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getConstantDefinition_Private()
  {
    return (EAttribute)constantDefinitionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConstantDefinition_Name()
  {
    return (EReference)constantDefinitionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConstantDefinition_Value()
  {
    return (EReference)constantDefinitionEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConstantDefinition_VariantValues()
  {
    return (EReference)constantDefinitionEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getConstantDefinition_Parameterized()
  {
    return (EAttribute)constantDefinitionEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVariableAssignment()
  {
    return variableAssignmentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVariableAssignment_Value()
  {
    return (EReference)variableAssignmentEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVariableAssignment_Target()
  {
    return (EReference)variableAssignmentEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVariantValue()
  {
    return variantValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVariantValue_Names()
  {
    return (EReference)variantValueEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVariantValue_Value()
  {
    return (EReference)variantValueEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVariableEntity()
  {
    return variableEntityEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConstantEntity()
  {
    return constantEntityEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVariableOrConstantEntity()
  {
    return variableOrConstantEntityEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVariableOrConstantEntity_Name()
  {
    return (EAttribute)variableOrConstantEntityEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTest()
  {
    return testEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTest_Checkpoint()
  {
    return (EAttribute)testEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTest_Definition()
  {
    return (EReference)testEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTest_Parameters()
  {
    return (EReference)testEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTest_Results()
  {
    return (EReference)testEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTest_Result()
  {
    return (EReference)testEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTableTest()
  {
    return tableTestEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTableTest_Definition()
  {
    return (EReference)tableTestEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTableTest_Parameters()
  {
    return (EReference)tableTestEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTableTest_ParameterHeaders()
  {
    return (EReference)tableTestEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTableTest_ResultHeaders()
  {
    return (EReference)tableTestEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTableTest_DefaultResultColumn()
  {
    return (EAttribute)tableTestEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTableTest_Rows()
  {
    return (EReference)tableTestEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTableTestRow()
  {
    return tableTestRowEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTableTestRow_Values()
  {
    return (EReference)tableTestRowEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getParameterTableHeader()
  {
    return parameterTableHeaderEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getParameterTableHeader_Name()
  {
    return (EReference)parameterTableHeaderEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getResultTableHeader()
  {
    return resultTableHeaderEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getResultTableHeader_Name()
  {
    return (EReference)resultTableHeaderEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getParameterTableValue()
  {
    return parameterTableValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getParameterTableValue_Value()
  {
    return (EReference)parameterTableValueEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNamedResult()
  {
    return namedResultEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNamedResult_Name()
  {
    return (EReference)namedResultEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNamedResult_Value()
  {
    return (EReference)namedResultEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getResultName()
  {
    return resultNameEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFixedResultName()
  {
    return fixedResultNameEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFixedResultName_Field()
  {
    return (EReference)fixedResultNameEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCall()
  {
    return callEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCall_Multiplier()
  {
    return (EReference)callEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCall_Definition()
  {
    return (EReference)callEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCall_Parameters()
  {
    return (EReference)callEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCall_Results()
  {
    return (EReference)callEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCall_Result()
  {
    return (EReference)callEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNamedCallResult()
  {
    return namedCallResultEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNamedCallResult_Name()
  {
    return (EReference)namedCallResultEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNamedCallResult_Target()
  {
    return (EReference)namedCallResultEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTimeSet()
  {
    return timeSetEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTimeSet_Live()
  {
    return (EAttribute)timeSetEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTimeSet_StartTime()
  {
    return (EReference)timeSetEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTimeSet_DiffTime()
  {
    return (EReference)timeSetEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTimeSet_ProgressionMode()
  {
    return (EAttribute)timeSetEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTimeSet_ProgressionFactor()
  {
    return (EReference)timeSetEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTimeSet_Forks()
  {
    return (EReference)timeSetEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTimeSet_MasterFork()
  {
    return (EAttribute)timeSetEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTimeProgressionFactor()
  {
    return timeProgressionFactorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTimeProgressionFactor_FixedValue()
  {
    return (EAttribute)timeProgressionFactorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTimeProgressionFactor_CalculatedValue()
  {
    return (EReference)timeProgressionFactorEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTimeDifference()
  {
    return timeDifferenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTimeDifference_Direction()
  {
    return (EAttribute)timeDifferenceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTimeDifference_FixedValues()
  {
    return (EAttribute)timeDifferenceEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTimeDifference_CalculatedValue()
  {
    return (EReference)timeDifferenceEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSuite()
  {
    return suiteEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSuite_Inlined()
  {
    return (EAttribute)suiteEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSuite_Multiplier()
  {
    return (EReference)suiteEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSuite_Definition()
  {
    return (EReference)suiteEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSuite_Parameters()
  {
    return (EReference)suiteEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSuite_Return()
  {
    return (EReference)suiteEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSuite_Fork()
  {
    return (EReference)suiteEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSuite_Variants()
  {
    return (EReference)suiteEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSuiteParameter()
  {
    return suiteParameterEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSuiteParameter_Name()
  {
    return (EReference)suiteParameterEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSuiteParameter_Value()
  {
    return (EReference)suiteParameterEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSuiteReturn()
  {
    return suiteReturnEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSuiteReturn_Name()
  {
    return (EReference)suiteReturnEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSuiteReturn_Target()
  {
    return (EReference)suiteReturnEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getParameter()
  {
    return parameterEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getParameter_Name()
  {
    return (EReference)parameterEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getParameter_Value()
  {
    return (EReference)parameterEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getParameterName()
  {
    return parameterNameEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFixedParameterName()
  {
    return fixedParameterNameEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFixedParameterName_Annotation()
  {
    return (EReference)fixedParameterNameEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getArbitraryParameterOrResultName()
  {
    return arbitraryParameterOrResultNameEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getArbitraryParameterOrResultName_Identifier()
  {
    return (EAttribute)arbitraryParameterOrResultNameEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getArbitraryParameterOrResultName_StringIdentifier()
  {
    return (EAttribute)arbitraryParameterOrResultNameEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOperation()
  {
    return operationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStandardOperation()
  {
    return standardOperationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStandardOperation_FirstOperand()
  {
    return (EReference)standardOperationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getStandardOperation_Operators()
  {
    return (EAttribute)standardOperationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStandardOperation_MoreOperands()
  {
    return (EReference)standardOperationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCustomOperation()
  {
    return customOperationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCustomOperation_PrefixOperand()
  {
    return (EReference)customOperationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCustomOperation_Definition()
  {
    return (EReference)customOperationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCustomOperation_PostfixOperand()
  {
    return (EReference)customOperationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getValueOrEnumValueOrOperationCollection()
  {
    return valueOrEnumValueOrOperationCollectionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getValueOrEnumValueOrOperationCollection_Value()
  {
    return (EReference)valueOrEnumValueOrOperationCollectionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getValueOrEnumValueOrOperationCollection_MoreValues()
  {
    return (EReference)valueOrEnumValueOrOperationCollectionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getValueOrEnumValueOrOperation()
  {
    return valueOrEnumValueOrOperationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getValue()
  {
    return valueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConstantValue()
  {
    return constantValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStaticValue()
  {
    return staticValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIntegerValue()
  {
    return integerValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIntegerValue_IntegerValue()
  {
    return (EAttribute)integerValueEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDecimalValue()
  {
    return decimalValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDecimalValue_DecimalValue()
  {
    return (EAttribute)decimalValueEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStringValue()
  {
    return stringValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getStringValue_StringValue()
  {
    return (EAttribute)stringValueEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBooleanValue()
  {
    return booleanValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getBooleanValue_BooleanValue()
  {
    return (EAttribute)booleanValueEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDateValue()
  {
    return dateValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDateValue_DateValue()
  {
    return (EAttribute)dateValueEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIsoDateValue()
  {
    return isoDateValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEuropeanDateValue()
  {
    return europeanDateValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUSDateValue()
  {
    return usDateValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTimeValue()
  {
    return timeValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTimeValue_TimeValue()
  {
    return (EAttribute)timeValueEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIsoTimeValue()
  {
    return isoTimeValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSimple24HrsTimeValue()
  {
    return simple24HrsTimeValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSimple12HrsTimeValue()
  {
    return simple12HrsTimeValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDateAndTimeValue()
  {
    return dateAndTimeValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDateAndTimeValue_DateValue()
  {
    return (EAttribute)dateAndTimeValueEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDateAndTimeValue_TimeValue()
  {
    return (EAttribute)dateAndTimeValueEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIsoDateAndTimeValue()
  {
    return isoDateAndTimeValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEuropeanDateAnd24HrsTimeValue()
  {
    return europeanDateAnd24HrsTimeValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEuropeanDateAnd12HrsTimeValue()
  {
    return europeanDateAnd12HrsTimeValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUSDateAnd12HrsTimeValue()
  {
    return usDateAnd12HrsTimeValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getJavaConstantValue()
  {
    return javaConstantValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getJavaConstantValue_Constant()
  {
    return (EReference)javaConstantValueEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVariable()
  {
    return variableEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVariable_Name()
  {
    return (EReference)variableEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVariable_Attribute()
  {
    return (EAttribute)variableEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVariableVariable()
  {
    return variableVariableEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVariableVariable_Name()
  {
    return (EReference)variableVariableEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConstant()
  {
    return constantEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConstant_Name()
  {
    return (EReference)constantEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNullValue()
  {
    return nullValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInexistentValue()
  {
    return inexistentValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEnumValue()
  {
    return enumValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEnumValue_EnumValue()
  {
    return (EReference)enumValueEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNestedObject()
  {
    return nestedObjectEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNestedObject_Attributes()
  {
    return (EReference)nestedObjectEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypedNestedObject()
  {
    return typedNestedObjectEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTypedNestedObject_Type()
  {
    return (EReference)typedNestedObjectEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTypedNestedObject_NestedObject()
  {
    return (EReference)typedNestedObjectEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getKeyValuePair()
  {
    return keyValuePairEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getKeyValuePair_Identifier()
  {
    return (EAttribute)keyValuePairEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getKeyValuePair_StringIdentifier()
  {
    return (EAttribute)keyValuePairEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getKeyValuePair_Value()
  {
    return (EReference)keyValuePairEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getJavaClassReference()
  {
    return javaClassReferenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getJavaClassReference_Type()
  {
    return (EReference)javaClassReferenceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMethodReference()
  {
    return methodReferenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMethodReference_Type()
  {
    return (EReference)methodReferenceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getMethodReference_Method()
  {
    return (EReference)methodReferenceEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getJavaConstantReference()
  {
    return javaConstantReferenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getJavaConstantReference_Type()
  {
    return (EReference)javaConstantReferenceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getJavaConstantReference_Constant()
  {
    return (EReference)javaConstantReferenceEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExecutionMultiplier()
  {
    return executionMultiplierEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExecutionMultiplier_Count()
  {
    return (EReference)executionMultiplierEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDocumentationComment()
  {
    return documentationCommentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDocumentationComment_Content()
  {
    return (EAttribute)documentationCommentEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNull()
  {
    return nullEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInexistent()
  {
    return inexistentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DslFactory getDslFactory()
  {
    return (DslFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    modelEClass = createEClass(MODEL);
    createEReference(modelEClass, MODEL__IMPORTS);
    createEReference(modelEClass, MODEL__STATEMENTS);

    statementEClass = createEClass(STATEMENT);
    createEReference(statementEClass, STATEMENT__DOCUMENTATION);
    createEAttribute(statementEClass, STATEMENT__NAME);

    visibleCommentEClass = createEClass(VISIBLE_COMMENT);
    createEAttribute(visibleCommentEClass, VISIBLE_COMMENT__CONTENT);

    visibleSingleLineCommentEClass = createEClass(VISIBLE_SINGLE_LINE_COMMENT);

    visibleSingleLineNormalCommentEClass = createEClass(VISIBLE_SINGLE_LINE_NORMAL_COMMENT);

    visibleSingleLineTitleCommentEClass = createEClass(VISIBLE_SINGLE_LINE_TITLE_COMMENT);

    visibleMultiLineCommentEClass = createEClass(VISIBLE_MULTI_LINE_COMMENT);

    visibleMultiLineNormalCommentEClass = createEClass(VISIBLE_MULTI_LINE_NORMAL_COMMENT);

    visibleMultiLineTitleCommentEClass = createEClass(VISIBLE_MULTI_LINE_TITLE_COMMENT);

    visibleDividerEClass = createEClass(VISIBLE_DIVIDER);
    createEAttribute(visibleDividerEClass, VISIBLE_DIVIDER__CONTENT);

    packageDefinitionEClass = createEClass(PACKAGE_DEFINITION);
    createEReference(packageDefinitionEClass, PACKAGE_DEFINITION__STATEMENTS);

    packageStatementEClass = createEClass(PACKAGE_STATEMENT);

    importEClass = createEClass(IMPORT);
    createEAttribute(importEClass, IMPORT__IMPORTED_NAMESPACE);

    forkDefinitionEClass = createEClass(FORK_DEFINITION);
    createEAttribute(forkDefinitionEClass, FORK_DEFINITION__PRIVATE);
    createEAttribute(forkDefinitionEClass, FORK_DEFINITION__DESCRIPTION);
    createEReference(forkDefinitionEClass, FORK_DEFINITION__FORKER_CLASS);
    createEReference(forkDefinitionEClass, FORK_DEFINITION__BASE_FORK);
    createEReference(forkDefinitionEClass, FORK_DEFINITION__PARAMETERS);

    forkParameterEClass = createEClass(FORK_PARAMETER);
    createEReference(forkParameterEClass, FORK_PARAMETER__NAME);
    createEReference(forkParameterEClass, FORK_PARAMETER__VALUE);

    variantDefinitionEClass = createEClass(VARIANT_DEFINITION);
    createEAttribute(variantDefinitionEClass, VARIANT_DEFINITION__DESCRIPTION);

    testDefinitionEClass = createEClass(TEST_DEFINITION);
    createEReference(testDefinitionEClass, TEST_DEFINITION__DOCUMENTATION);
    createEAttribute(testDefinitionEClass, TEST_DEFINITION__NAME);
    createEReference(testDefinitionEClass, TEST_DEFINITION__FIXTURE_METHOD);

    callDefinitionEClass = createEClass(CALL_DEFINITION);
    createEReference(callDefinitionEClass, CALL_DEFINITION__DOCUMENTATION);
    createEAttribute(callDefinitionEClass, CALL_DEFINITION__NAME);
    createEReference(callDefinitionEClass, CALL_DEFINITION__FIXTURE_METHOD);

    suiteDefinitionEClass = createEClass(SUITE_DEFINITION);
    createEReference(suiteDefinitionEClass, SUITE_DEFINITION__DOCUMENTATION);
    createEAttribute(suiteDefinitionEClass, SUITE_DEFINITION__PRIVATE);
    createEAttribute(suiteDefinitionEClass, SUITE_DEFINITION__SINGLE_RUN);
    createEAttribute(suiteDefinitionEClass, SUITE_DEFINITION__INLINED);
    createEAttribute(suiteDefinitionEClass, SUITE_DEFINITION__NAME);
    createEReference(suiteDefinitionEClass, SUITE_DEFINITION__PARAMETERS);
    createEReference(suiteDefinitionEClass, SUITE_DEFINITION__RETURN);
    createEReference(suiteDefinitionEClass, SUITE_DEFINITION__DEPENDENCIES);
    createEReference(suiteDefinitionEClass, SUITE_DEFINITION__FINALIZERS);
    createEReference(suiteDefinitionEClass, SUITE_DEFINITION__STATEMENTS);

    suiteParameterDefinitionEClass = createEClass(SUITE_PARAMETER_DEFINITION);
    createEReference(suiteParameterDefinitionEClass, SUITE_PARAMETER_DEFINITION__NAME);
    createEReference(suiteParameterDefinitionEClass, SUITE_PARAMETER_DEFINITION__DEFAULT);

    suiteReturnDefinitionEClass = createEClass(SUITE_RETURN_DEFINITION);
    createEReference(suiteReturnDefinitionEClass, SUITE_RETURN_DEFINITION__NAME);

    operationDefinitionEClass = createEClass(OPERATION_DEFINITION);
    createEAttribute(operationDefinitionEClass, OPERATION_DEFINITION__NAME);
    createEReference(operationDefinitionEClass, OPERATION_DEFINITION__OPERATION_TYPE);

    suiteStatementEClass = createEClass(SUITE_STATEMENT);

    suiteStatementWithResultEClass = createEClass(SUITE_STATEMENT_WITH_RESULT);

    variableDefinitionEClass = createEClass(VARIABLE_DEFINITION);
    createEAttribute(variableDefinitionEClass, VARIABLE_DEFINITION__PRIVATE);
    createEReference(variableDefinitionEClass, VARIABLE_DEFINITION__NAME);
    createEReference(variableDefinitionEClass, VARIABLE_DEFINITION__INITIAL_VALUE);

    constantDefinitionEClass = createEClass(CONSTANT_DEFINITION);
    createEReference(constantDefinitionEClass, CONSTANT_DEFINITION__DOCUMENTATION);
    createEAttribute(constantDefinitionEClass, CONSTANT_DEFINITION__PRIVATE);
    createEReference(constantDefinitionEClass, CONSTANT_DEFINITION__NAME);
    createEReference(constantDefinitionEClass, CONSTANT_DEFINITION__VALUE);
    createEReference(constantDefinitionEClass, CONSTANT_DEFINITION__VARIANT_VALUES);
    createEAttribute(constantDefinitionEClass, CONSTANT_DEFINITION__PARAMETERIZED);

    variableAssignmentEClass = createEClass(VARIABLE_ASSIGNMENT);
    createEReference(variableAssignmentEClass, VARIABLE_ASSIGNMENT__VALUE);
    createEReference(variableAssignmentEClass, VARIABLE_ASSIGNMENT__TARGET);

    variantValueEClass = createEClass(VARIANT_VALUE);
    createEReference(variantValueEClass, VARIANT_VALUE__NAMES);
    createEReference(variantValueEClass, VARIANT_VALUE__VALUE);

    variableEntityEClass = createEClass(VARIABLE_ENTITY);

    constantEntityEClass = createEClass(CONSTANT_ENTITY);

    variableOrConstantEntityEClass = createEClass(VARIABLE_OR_CONSTANT_ENTITY);
    createEAttribute(variableOrConstantEntityEClass, VARIABLE_OR_CONSTANT_ENTITY__NAME);

    testEClass = createEClass(TEST);
    createEAttribute(testEClass, TEST__CHECKPOINT);
    createEReference(testEClass, TEST__DEFINITION);
    createEReference(testEClass, TEST__PARAMETERS);
    createEReference(testEClass, TEST__RESULTS);
    createEReference(testEClass, TEST__RESULT);

    tableTestEClass = createEClass(TABLE_TEST);
    createEReference(tableTestEClass, TABLE_TEST__DEFINITION);
    createEReference(tableTestEClass, TABLE_TEST__PARAMETERS);
    createEReference(tableTestEClass, TABLE_TEST__PARAMETER_HEADERS);
    createEReference(tableTestEClass, TABLE_TEST__RESULT_HEADERS);
    createEAttribute(tableTestEClass, TABLE_TEST__DEFAULT_RESULT_COLUMN);
    createEReference(tableTestEClass, TABLE_TEST__ROWS);

    tableTestRowEClass = createEClass(TABLE_TEST_ROW);
    createEReference(tableTestRowEClass, TABLE_TEST_ROW__VALUES);

    parameterTableHeaderEClass = createEClass(PARAMETER_TABLE_HEADER);
    createEReference(parameterTableHeaderEClass, PARAMETER_TABLE_HEADER__NAME);

    resultTableHeaderEClass = createEClass(RESULT_TABLE_HEADER);
    createEReference(resultTableHeaderEClass, RESULT_TABLE_HEADER__NAME);

    parameterTableValueEClass = createEClass(PARAMETER_TABLE_VALUE);
    createEReference(parameterTableValueEClass, PARAMETER_TABLE_VALUE__VALUE);

    namedResultEClass = createEClass(NAMED_RESULT);
    createEReference(namedResultEClass, NAMED_RESULT__NAME);
    createEReference(namedResultEClass, NAMED_RESULT__VALUE);

    resultNameEClass = createEClass(RESULT_NAME);

    fixedResultNameEClass = createEClass(FIXED_RESULT_NAME);
    createEReference(fixedResultNameEClass, FIXED_RESULT_NAME__FIELD);

    callEClass = createEClass(CALL);
    createEReference(callEClass, CALL__MULTIPLIER);
    createEReference(callEClass, CALL__DEFINITION);
    createEReference(callEClass, CALL__PARAMETERS);
    createEReference(callEClass, CALL__RESULTS);
    createEReference(callEClass, CALL__RESULT);

    namedCallResultEClass = createEClass(NAMED_CALL_RESULT);
    createEReference(namedCallResultEClass, NAMED_CALL_RESULT__NAME);
    createEReference(namedCallResultEClass, NAMED_CALL_RESULT__TARGET);

    timeSetEClass = createEClass(TIME_SET);
    createEAttribute(timeSetEClass, TIME_SET__LIVE);
    createEReference(timeSetEClass, TIME_SET__START_TIME);
    createEReference(timeSetEClass, TIME_SET__DIFF_TIME);
    createEAttribute(timeSetEClass, TIME_SET__PROGRESSION_MODE);
    createEReference(timeSetEClass, TIME_SET__PROGRESSION_FACTOR);
    createEReference(timeSetEClass, TIME_SET__FORKS);
    createEAttribute(timeSetEClass, TIME_SET__MASTER_FORK);

    timeProgressionFactorEClass = createEClass(TIME_PROGRESSION_FACTOR);
    createEAttribute(timeProgressionFactorEClass, TIME_PROGRESSION_FACTOR__FIXED_VALUE);
    createEReference(timeProgressionFactorEClass, TIME_PROGRESSION_FACTOR__CALCULATED_VALUE);

    timeDifferenceEClass = createEClass(TIME_DIFFERENCE);
    createEAttribute(timeDifferenceEClass, TIME_DIFFERENCE__DIRECTION);
    createEAttribute(timeDifferenceEClass, TIME_DIFFERENCE__FIXED_VALUES);
    createEReference(timeDifferenceEClass, TIME_DIFFERENCE__CALCULATED_VALUE);

    suiteEClass = createEClass(SUITE);
    createEAttribute(suiteEClass, SUITE__INLINED);
    createEReference(suiteEClass, SUITE__MULTIPLIER);
    createEReference(suiteEClass, SUITE__DEFINITION);
    createEReference(suiteEClass, SUITE__PARAMETERS);
    createEReference(suiteEClass, SUITE__RETURN);
    createEReference(suiteEClass, SUITE__FORK);
    createEReference(suiteEClass, SUITE__VARIANTS);

    suiteParameterEClass = createEClass(SUITE_PARAMETER);
    createEReference(suiteParameterEClass, SUITE_PARAMETER__NAME);
    createEReference(suiteParameterEClass, SUITE_PARAMETER__VALUE);

    suiteReturnEClass = createEClass(SUITE_RETURN);
    createEReference(suiteReturnEClass, SUITE_RETURN__NAME);
    createEReference(suiteReturnEClass, SUITE_RETURN__TARGET);

    parameterEClass = createEClass(PARAMETER);
    createEReference(parameterEClass, PARAMETER__NAME);
    createEReference(parameterEClass, PARAMETER__VALUE);

    parameterNameEClass = createEClass(PARAMETER_NAME);

    fixedParameterNameEClass = createEClass(FIXED_PARAMETER_NAME);
    createEReference(fixedParameterNameEClass, FIXED_PARAMETER_NAME__ANNOTATION);

    arbitraryParameterOrResultNameEClass = createEClass(ARBITRARY_PARAMETER_OR_RESULT_NAME);
    createEAttribute(arbitraryParameterOrResultNameEClass, ARBITRARY_PARAMETER_OR_RESULT_NAME__IDENTIFIER);
    createEAttribute(arbitraryParameterOrResultNameEClass, ARBITRARY_PARAMETER_OR_RESULT_NAME__STRING_IDENTIFIER);

    operationEClass = createEClass(OPERATION);

    standardOperationEClass = createEClass(STANDARD_OPERATION);
    createEReference(standardOperationEClass, STANDARD_OPERATION__FIRST_OPERAND);
    createEAttribute(standardOperationEClass, STANDARD_OPERATION__OPERATORS);
    createEReference(standardOperationEClass, STANDARD_OPERATION__MORE_OPERANDS);

    customOperationEClass = createEClass(CUSTOM_OPERATION);
    createEReference(customOperationEClass, CUSTOM_OPERATION__PREFIX_OPERAND);
    createEReference(customOperationEClass, CUSTOM_OPERATION__DEFINITION);
    createEReference(customOperationEClass, CUSTOM_OPERATION__POSTFIX_OPERAND);

    valueOrEnumValueOrOperationCollectionEClass = createEClass(VALUE_OR_ENUM_VALUE_OR_OPERATION_COLLECTION);
    createEReference(valueOrEnumValueOrOperationCollectionEClass, VALUE_OR_ENUM_VALUE_OR_OPERATION_COLLECTION__VALUE);
    createEReference(valueOrEnumValueOrOperationCollectionEClass, VALUE_OR_ENUM_VALUE_OR_OPERATION_COLLECTION__MORE_VALUES);

    valueOrEnumValueOrOperationEClass = createEClass(VALUE_OR_ENUM_VALUE_OR_OPERATION);

    valueEClass = createEClass(VALUE);

    constantValueEClass = createEClass(CONSTANT_VALUE);

    staticValueEClass = createEClass(STATIC_VALUE);

    integerValueEClass = createEClass(INTEGER_VALUE);
    createEAttribute(integerValueEClass, INTEGER_VALUE__INTEGER_VALUE);

    decimalValueEClass = createEClass(DECIMAL_VALUE);
    createEAttribute(decimalValueEClass, DECIMAL_VALUE__DECIMAL_VALUE);

    stringValueEClass = createEClass(STRING_VALUE);
    createEAttribute(stringValueEClass, STRING_VALUE__STRING_VALUE);

    booleanValueEClass = createEClass(BOOLEAN_VALUE);
    createEAttribute(booleanValueEClass, BOOLEAN_VALUE__BOOLEAN_VALUE);

    dateValueEClass = createEClass(DATE_VALUE);
    createEAttribute(dateValueEClass, DATE_VALUE__DATE_VALUE);

    isoDateValueEClass = createEClass(ISO_DATE_VALUE);

    europeanDateValueEClass = createEClass(EUROPEAN_DATE_VALUE);

    usDateValueEClass = createEClass(US_DATE_VALUE);

    timeValueEClass = createEClass(TIME_VALUE);
    createEAttribute(timeValueEClass, TIME_VALUE__TIME_VALUE);

    isoTimeValueEClass = createEClass(ISO_TIME_VALUE);

    simple24HrsTimeValueEClass = createEClass(SIMPLE24_HRS_TIME_VALUE);

    simple12HrsTimeValueEClass = createEClass(SIMPLE12_HRS_TIME_VALUE);

    dateAndTimeValueEClass = createEClass(DATE_AND_TIME_VALUE);
    createEAttribute(dateAndTimeValueEClass, DATE_AND_TIME_VALUE__DATE_VALUE);
    createEAttribute(dateAndTimeValueEClass, DATE_AND_TIME_VALUE__TIME_VALUE);

    isoDateAndTimeValueEClass = createEClass(ISO_DATE_AND_TIME_VALUE);

    europeanDateAnd24HrsTimeValueEClass = createEClass(EUROPEAN_DATE_AND24_HRS_TIME_VALUE);

    europeanDateAnd12HrsTimeValueEClass = createEClass(EUROPEAN_DATE_AND12_HRS_TIME_VALUE);

    usDateAnd12HrsTimeValueEClass = createEClass(US_DATE_AND12_HRS_TIME_VALUE);

    javaConstantValueEClass = createEClass(JAVA_CONSTANT_VALUE);
    createEReference(javaConstantValueEClass, JAVA_CONSTANT_VALUE__CONSTANT);

    variableEClass = createEClass(VARIABLE);
    createEReference(variableEClass, VARIABLE__NAME);
    createEAttribute(variableEClass, VARIABLE__ATTRIBUTE);

    variableVariableEClass = createEClass(VARIABLE_VARIABLE);
    createEReference(variableVariableEClass, VARIABLE_VARIABLE__NAME);

    constantEClass = createEClass(CONSTANT);
    createEReference(constantEClass, CONSTANT__NAME);

    nullValueEClass = createEClass(NULL_VALUE);

    inexistentValueEClass = createEClass(INEXISTENT_VALUE);

    enumValueEClass = createEClass(ENUM_VALUE);
    createEReference(enumValueEClass, ENUM_VALUE__ENUM_VALUE);

    nestedObjectEClass = createEClass(NESTED_OBJECT);
    createEReference(nestedObjectEClass, NESTED_OBJECT__ATTRIBUTES);

    typedNestedObjectEClass = createEClass(TYPED_NESTED_OBJECT);
    createEReference(typedNestedObjectEClass, TYPED_NESTED_OBJECT__TYPE);
    createEReference(typedNestedObjectEClass, TYPED_NESTED_OBJECT__NESTED_OBJECT);

    keyValuePairEClass = createEClass(KEY_VALUE_PAIR);
    createEAttribute(keyValuePairEClass, KEY_VALUE_PAIR__IDENTIFIER);
    createEAttribute(keyValuePairEClass, KEY_VALUE_PAIR__STRING_IDENTIFIER);
    createEReference(keyValuePairEClass, KEY_VALUE_PAIR__VALUE);

    javaClassReferenceEClass = createEClass(JAVA_CLASS_REFERENCE);
    createEReference(javaClassReferenceEClass, JAVA_CLASS_REFERENCE__TYPE);

    methodReferenceEClass = createEClass(METHOD_REFERENCE);
    createEReference(methodReferenceEClass, METHOD_REFERENCE__TYPE);
    createEReference(methodReferenceEClass, METHOD_REFERENCE__METHOD);

    javaConstantReferenceEClass = createEClass(JAVA_CONSTANT_REFERENCE);
    createEReference(javaConstantReferenceEClass, JAVA_CONSTANT_REFERENCE__TYPE);
    createEReference(javaConstantReferenceEClass, JAVA_CONSTANT_REFERENCE__CONSTANT);

    executionMultiplierEClass = createEClass(EXECUTION_MULTIPLIER);
    createEReference(executionMultiplierEClass, EXECUTION_MULTIPLIER__COUNT);

    documentationCommentEClass = createEClass(DOCUMENTATION_COMMENT);
    createEAttribute(documentationCommentEClass, DOCUMENTATION_COMMENT__CONTENT);

    nullEClass = createEClass(NULL);

    inexistentEClass = createEClass(INEXISTENT);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    visibleCommentEClass.getESuperTypes().add(this.getSuiteStatement());
    visibleSingleLineCommentEClass.getESuperTypes().add(this.getVisibleComment());
    visibleSingleLineNormalCommentEClass.getESuperTypes().add(this.getVisibleSingleLineComment());
    visibleSingleLineTitleCommentEClass.getESuperTypes().add(this.getVisibleSingleLineComment());
    visibleMultiLineCommentEClass.getESuperTypes().add(this.getVisibleComment());
    visibleMultiLineNormalCommentEClass.getESuperTypes().add(this.getVisibleMultiLineComment());
    visibleMultiLineTitleCommentEClass.getESuperTypes().add(this.getVisibleMultiLineComment());
    visibleDividerEClass.getESuperTypes().add(this.getSuiteStatement());
    packageDefinitionEClass.getESuperTypes().add(this.getStatement());
    forkDefinitionEClass.getESuperTypes().add(this.getStatement());
    forkDefinitionEClass.getESuperTypes().add(this.getPackageStatement());
    variantDefinitionEClass.getESuperTypes().add(this.getStatement());
    variantDefinitionEClass.getESuperTypes().add(this.getPackageStatement());
    testDefinitionEClass.getESuperTypes().add(this.getPackageStatement());
    callDefinitionEClass.getESuperTypes().add(this.getPackageStatement());
    suiteDefinitionEClass.getESuperTypes().add(this.getPackageStatement());
    operationDefinitionEClass.getESuperTypes().add(this.getPackageStatement());
    suiteStatementWithResultEClass.getESuperTypes().add(this.getSuiteStatement());
    variableDefinitionEClass.getESuperTypes().add(this.getPackageStatement());
    variableDefinitionEClass.getESuperTypes().add(this.getSuiteStatement());
    constantDefinitionEClass.getESuperTypes().add(this.getPackageStatement());
    constantDefinitionEClass.getESuperTypes().add(this.getSuiteStatement());
    variableAssignmentEClass.getESuperTypes().add(this.getSuiteStatement());
    variableEntityEClass.getESuperTypes().add(this.getVariableOrConstantEntity());
    constantEntityEClass.getESuperTypes().add(this.getVariableOrConstantEntity());
    testEClass.getESuperTypes().add(this.getSuiteStatementWithResult());
    tableTestEClass.getESuperTypes().add(this.getSuiteStatementWithResult());
    fixedResultNameEClass.getESuperTypes().add(this.getResultName());
    callEClass.getESuperTypes().add(this.getSuiteStatementWithResult());
    timeSetEClass.getESuperTypes().add(this.getSuiteStatement());
    suiteEClass.getESuperTypes().add(this.getSuiteStatementWithResult());
    fixedParameterNameEClass.getESuperTypes().add(this.getParameterName());
    arbitraryParameterOrResultNameEClass.getESuperTypes().add(this.getResultName());
    arbitraryParameterOrResultNameEClass.getESuperTypes().add(this.getParameterName());
    operationEClass.getESuperTypes().add(this.getValueOrEnumValueOrOperation());
    standardOperationEClass.getESuperTypes().add(this.getOperation());
    customOperationEClass.getESuperTypes().add(this.getOperation());
    valueEClass.getESuperTypes().add(this.getValueOrEnumValueOrOperation());
    staticValueEClass.getESuperTypes().add(this.getValue());
    staticValueEClass.getESuperTypes().add(this.getConstantValue());
    integerValueEClass.getESuperTypes().add(this.getStaticValue());
    decimalValueEClass.getESuperTypes().add(this.getStaticValue());
    stringValueEClass.getESuperTypes().add(this.getStaticValue());
    booleanValueEClass.getESuperTypes().add(this.getStaticValue());
    dateValueEClass.getESuperTypes().add(this.getStaticValue());
    isoDateValueEClass.getESuperTypes().add(this.getDateValue());
    europeanDateValueEClass.getESuperTypes().add(this.getDateValue());
    usDateValueEClass.getESuperTypes().add(this.getDateValue());
    timeValueEClass.getESuperTypes().add(this.getStaticValue());
    isoTimeValueEClass.getESuperTypes().add(this.getTimeValue());
    simple24HrsTimeValueEClass.getESuperTypes().add(this.getTimeValue());
    simple12HrsTimeValueEClass.getESuperTypes().add(this.getTimeValue());
    dateAndTimeValueEClass.getESuperTypes().add(this.getStaticValue());
    isoDateAndTimeValueEClass.getESuperTypes().add(this.getDateAndTimeValue());
    europeanDateAnd24HrsTimeValueEClass.getESuperTypes().add(this.getDateAndTimeValue());
    europeanDateAnd12HrsTimeValueEClass.getESuperTypes().add(this.getDateAndTimeValue());
    usDateAnd12HrsTimeValueEClass.getESuperTypes().add(this.getDateAndTimeValue());
    javaConstantValueEClass.getESuperTypes().add(this.getStaticValue());
    variableEClass.getESuperTypes().add(this.getValue());
    constantEClass.getESuperTypes().add(this.getConstantValue());
    nullValueEClass.getESuperTypes().add(this.getStaticValue());
    inexistentValueEClass.getESuperTypes().add(this.getStaticValue());
    enumValueEClass.getESuperTypes().add(this.getValueOrEnumValueOrOperation());
    nestedObjectEClass.getESuperTypes().add(this.getValue());
    typedNestedObjectEClass.getESuperTypes().add(this.getValue());
    nullEClass.getESuperTypes().add(this.getNullValue());
    inexistentEClass.getESuperTypes().add(this.getInexistentValue());

    // Initialize classes and features; add operations and parameters
    initEClass(modelEClass, Model.class, "Model", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getModel_Imports(), this.getImport(), null, "imports", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModel_Statements(), this.getStatement(), null, "statements", null, 0, -1, Model.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(statementEClass, Statement.class, "Statement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getStatement_Documentation(), this.getDocumentationComment(), null, "documentation", null, 0, 1, Statement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getStatement_Name(), ecorePackage.getEString(), "name", null, 0, 1, Statement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(visibleCommentEClass, VisibleComment.class, "VisibleComment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVisibleComment_Content(), ecorePackage.getEString(), "content", null, 0, 1, VisibleComment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(visibleSingleLineCommentEClass, VisibleSingleLineComment.class, "VisibleSingleLineComment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(visibleSingleLineNormalCommentEClass, VisibleSingleLineNormalComment.class, "VisibleSingleLineNormalComment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(visibleSingleLineTitleCommentEClass, VisibleSingleLineTitleComment.class, "VisibleSingleLineTitleComment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(visibleMultiLineCommentEClass, VisibleMultiLineComment.class, "VisibleMultiLineComment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(visibleMultiLineNormalCommentEClass, VisibleMultiLineNormalComment.class, "VisibleMultiLineNormalComment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(visibleMultiLineTitleCommentEClass, VisibleMultiLineTitleComment.class, "VisibleMultiLineTitleComment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(visibleDividerEClass, VisibleDivider.class, "VisibleDivider", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVisibleDivider_Content(), ecorePackage.getEString(), "content", null, 0, 1, VisibleDivider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(packageDefinitionEClass, PackageDefinition.class, "PackageDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPackageDefinition_Statements(), this.getPackageStatement(), null, "statements", null, 0, -1, PackageDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(packageStatementEClass, PackageStatement.class, "PackageStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(importEClass, Import.class, "Import", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getImport_ImportedNamespace(), ecorePackage.getEString(), "importedNamespace", null, 0, 1, Import.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(forkDefinitionEClass, ForkDefinition.class, "ForkDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getForkDefinition_Private(), ecorePackage.getEString(), "private", null, 0, 1, ForkDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getForkDefinition_Description(), ecorePackage.getEString(), "description", null, 0, 1, ForkDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getForkDefinition_ForkerClass(), this.getJavaClassReference(), null, "forkerClass", null, 0, 1, ForkDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getForkDefinition_BaseFork(), this.getForkDefinition(), null, "baseFork", null, 0, 1, ForkDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getForkDefinition_Parameters(), this.getForkParameter(), null, "parameters", null, 0, -1, ForkDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(forkParameterEClass, ForkParameter.class, "ForkParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getForkParameter_Name(), this.getFixedParameterName(), null, "name", null, 0, 1, ForkParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getForkParameter_Value(), this.getValueOrEnumValueOrOperation(), null, "value", null, 0, 1, ForkParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(variantDefinitionEClass, VariantDefinition.class, "VariantDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVariantDefinition_Description(), ecorePackage.getEString(), "description", null, 0, 1, VariantDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(testDefinitionEClass, TestDefinition.class, "TestDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTestDefinition_Documentation(), this.getDocumentationComment(), null, "documentation", null, 0, 1, TestDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTestDefinition_Name(), ecorePackage.getEString(), "name", null, 0, 1, TestDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTestDefinition_FixtureMethod(), this.getMethodReference(), null, "fixtureMethod", null, 0, 1, TestDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(callDefinitionEClass, CallDefinition.class, "CallDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCallDefinition_Documentation(), this.getDocumentationComment(), null, "documentation", null, 0, 1, CallDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getCallDefinition_Name(), ecorePackage.getEString(), "name", null, 0, 1, CallDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCallDefinition_FixtureMethod(), this.getMethodReference(), null, "fixtureMethod", null, 0, 1, CallDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(suiteDefinitionEClass, SuiteDefinition.class, "SuiteDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSuiteDefinition_Documentation(), this.getDocumentationComment(), null, "documentation", null, 0, 1, SuiteDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSuiteDefinition_Private(), ecorePackage.getEString(), "private", null, 0, 1, SuiteDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSuiteDefinition_SingleRun(), ecorePackage.getEString(), "singleRun", null, 0, 1, SuiteDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSuiteDefinition_Inlined(), ecorePackage.getEString(), "inlined", null, 0, 1, SuiteDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSuiteDefinition_Name(), ecorePackage.getEString(), "name", null, 0, 1, SuiteDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSuiteDefinition_Parameters(), this.getSuiteParameterDefinition(), null, "parameters", null, 0, -1, SuiteDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSuiteDefinition_Return(), this.getSuiteReturnDefinition(), null, "return", null, 0, -1, SuiteDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSuiteDefinition_Dependencies(), this.getSuiteDefinition(), null, "dependencies", null, 0, -1, SuiteDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSuiteDefinition_Finalizers(), this.getSuiteDefinition(), null, "finalizers", null, 0, -1, SuiteDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSuiteDefinition_Statements(), this.getSuiteStatement(), null, "statements", null, 0, -1, SuiteDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(suiteParameterDefinitionEClass, SuiteParameterDefinition.class, "SuiteParameterDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSuiteParameterDefinition_Name(), this.getVariableEntity(), null, "name", null, 0, 1, SuiteParameterDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSuiteParameterDefinition_Default(), this.getValueOrEnumValueOrOperationCollection(), null, "default", null, 0, 1, SuiteParameterDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(suiteReturnDefinitionEClass, SuiteReturnDefinition.class, "SuiteReturnDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSuiteReturnDefinition_Name(), this.getVariableEntity(), null, "name", null, 0, 1, SuiteReturnDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(operationDefinitionEClass, OperationDefinition.class, "OperationDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getOperationDefinition_Name(), ecorePackage.getEString(), "name", null, 0, 1, OperationDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getOperationDefinition_OperationType(), this.getJavaClassReference(), null, "operationType", null, 0, 1, OperationDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(suiteStatementEClass, SuiteStatement.class, "SuiteStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(suiteStatementWithResultEClass, SuiteStatementWithResult.class, "SuiteStatementWithResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(variableDefinitionEClass, VariableDefinition.class, "VariableDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVariableDefinition_Private(), ecorePackage.getEString(), "private", null, 0, 1, VariableDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVariableDefinition_Name(), this.getVariableEntity(), null, "name", null, 0, 1, VariableDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVariableDefinition_InitialValue(), this.getValueOrEnumValueOrOperationCollection(), null, "initialValue", null, 0, 1, VariableDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(constantDefinitionEClass, ConstantDefinition.class, "ConstantDefinition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getConstantDefinition_Documentation(), this.getDocumentationComment(), null, "documentation", null, 0, 1, ConstantDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getConstantDefinition_Private(), ecorePackage.getEString(), "private", null, 0, 1, ConstantDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getConstantDefinition_Name(), this.getConstantEntity(), null, "name", null, 0, 1, ConstantDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getConstantDefinition_Value(), this.getValueOrEnumValueOrOperationCollection(), null, "value", null, 0, 1, ConstantDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getConstantDefinition_VariantValues(), this.getVariantValue(), null, "variantValues", null, 0, -1, ConstantDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getConstantDefinition_Parameterized(), ecorePackage.getEString(), "parameterized", null, 0, 1, ConstantDefinition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(variableAssignmentEClass, VariableAssignment.class, "VariableAssignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getVariableAssignment_Value(), this.getValueOrEnumValueOrOperationCollection(), null, "value", null, 0, 1, VariableAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVariableAssignment_Target(), this.getVariableVariable(), null, "target", null, 0, 1, VariableAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(variantValueEClass, VariantValue.class, "VariantValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getVariantValue_Names(), this.getVariantDefinition(), null, "names", null, 0, -1, VariantValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getVariantValue_Value(), this.getValueOrEnumValueOrOperationCollection(), null, "value", null, 0, 1, VariantValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(variableEntityEClass, VariableEntity.class, "VariableEntity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(constantEntityEClass, ConstantEntity.class, "ConstantEntity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(variableOrConstantEntityEClass, VariableOrConstantEntity.class, "VariableOrConstantEntity", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVariableOrConstantEntity_Name(), ecorePackage.getEString(), "name", null, 0, 1, VariableOrConstantEntity.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(testEClass, Test.class, "Test", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTest_Checkpoint(), ecorePackage.getEString(), "checkpoint", null, 0, 1, Test.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTest_Definition(), this.getTestDefinition(), null, "definition", null, 0, 1, Test.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTest_Parameters(), this.getParameter(), null, "parameters", null, 0, -1, Test.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTest_Results(), this.getNamedResult(), null, "results", null, 0, -1, Test.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTest_Result(), this.getValueOrEnumValueOrOperationCollection(), null, "result", null, 0, 1, Test.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(tableTestEClass, TableTest.class, "TableTest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTableTest_Definition(), this.getTestDefinition(), null, "definition", null, 0, 1, TableTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTableTest_Parameters(), this.getParameter(), null, "parameters", null, 0, -1, TableTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTableTest_ParameterHeaders(), this.getParameterTableHeader(), null, "parameterHeaders", null, 0, -1, TableTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTableTest_ResultHeaders(), this.getResultTableHeader(), null, "resultHeaders", null, 0, -1, TableTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTableTest_DefaultResultColumn(), ecorePackage.getEString(), "defaultResultColumn", null, 0, 1, TableTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTableTest_Rows(), this.getTableTestRow(), null, "rows", null, 0, -1, TableTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(tableTestRowEClass, TableTestRow.class, "TableTestRow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTableTestRow_Values(), this.getParameterTableValue(), null, "values", null, 0, -1, TableTestRow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(parameterTableHeaderEClass, ParameterTableHeader.class, "ParameterTableHeader", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getParameterTableHeader_Name(), this.getParameterName(), null, "name", null, 0, 1, ParameterTableHeader.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(resultTableHeaderEClass, ResultTableHeader.class, "ResultTableHeader", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getResultTableHeader_Name(), this.getResultName(), null, "name", null, 0, 1, ResultTableHeader.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(parameterTableValueEClass, ParameterTableValue.class, "ParameterTableValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getParameterTableValue_Value(), this.getValueOrEnumValueOrOperationCollection(), null, "value", null, 0, 1, ParameterTableValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(namedResultEClass, NamedResult.class, "NamedResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getNamedResult_Name(), this.getResultName(), null, "name", null, 0, 1, NamedResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getNamedResult_Value(), this.getValueOrEnumValueOrOperationCollection(), null, "value", null, 0, 1, NamedResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(resultNameEClass, ResultName.class, "ResultName", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(fixedResultNameEClass, FixedResultName.class, "FixedResultName", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFixedResultName_Field(), theTypesPackage.getJvmField(), null, "field", null, 0, 1, FixedResultName.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(callEClass, Call.class, "Call", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCall_Multiplier(), this.getExecutionMultiplier(), null, "multiplier", null, 0, 1, Call.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCall_Definition(), this.getCallDefinition(), null, "definition", null, 0, 1, Call.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCall_Parameters(), this.getParameter(), null, "parameters", null, 0, -1, Call.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCall_Results(), this.getNamedCallResult(), null, "results", null, 0, -1, Call.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCall_Result(), this.getVariableVariable(), null, "result", null, 0, 1, Call.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(namedCallResultEClass, NamedCallResult.class, "NamedCallResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getNamedCallResult_Name(), this.getResultName(), null, "name", null, 0, 1, NamedCallResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getNamedCallResult_Target(), this.getVariableVariable(), null, "target", null, 0, 1, NamedCallResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(timeSetEClass, TimeSet.class, "TimeSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTimeSet_Live(), ecorePackage.getEString(), "live", null, 0, 1, TimeSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTimeSet_StartTime(), this.getValueOrEnumValueOrOperation(), null, "startTime", null, 0, 1, TimeSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTimeSet_DiffTime(), this.getTimeDifference(), null, "diffTime", null, 0, 1, TimeSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTimeSet_ProgressionMode(), ecorePackage.getEString(), "progressionMode", null, 0, 1, TimeSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTimeSet_ProgressionFactor(), this.getTimeProgressionFactor(), null, "progressionFactor", null, 0, 1, TimeSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTimeSet_Forks(), this.getForkDefinition(), null, "forks", null, 0, -1, TimeSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTimeSet_MasterFork(), ecorePackage.getEString(), "masterFork", null, 0, 1, TimeSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(timeProgressionFactorEClass, TimeProgressionFactor.class, "TimeProgressionFactor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTimeProgressionFactor_FixedValue(), ecorePackage.getEString(), "fixedValue", null, 0, 1, TimeProgressionFactor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTimeProgressionFactor_CalculatedValue(), this.getValueOrEnumValueOrOperation(), null, "calculatedValue", null, 0, 1, TimeProgressionFactor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(timeDifferenceEClass, TimeDifference.class, "TimeDifference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTimeDifference_Direction(), ecorePackage.getEString(), "direction", null, 0, 1, TimeDifference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTimeDifference_FixedValues(), ecorePackage.getEString(), "fixedValues", null, 0, -1, TimeDifference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTimeDifference_CalculatedValue(), this.getValueOrEnumValueOrOperation(), null, "calculatedValue", null, 0, 1, TimeDifference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(suiteEClass, Suite.class, "Suite", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getSuite_Inlined(), ecorePackage.getEString(), "inlined", null, 0, 1, Suite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSuite_Multiplier(), this.getExecutionMultiplier(), null, "multiplier", null, 0, 1, Suite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSuite_Definition(), this.getSuiteDefinition(), null, "definition", null, 0, 1, Suite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSuite_Parameters(), this.getSuiteParameter(), null, "parameters", null, 0, -1, Suite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSuite_Return(), this.getSuiteReturn(), null, "return", null, 0, -1, Suite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSuite_Fork(), this.getForkDefinition(), null, "fork", null, 0, 1, Suite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSuite_Variants(), this.getVariantDefinition(), null, "variants", null, 0, -1, Suite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(suiteParameterEClass, SuiteParameter.class, "SuiteParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSuiteParameter_Name(), this.getVariableOrConstantEntity(), null, "name", null, 0, 1, SuiteParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSuiteParameter_Value(), this.getValueOrEnumValueOrOperationCollection(), null, "value", null, 0, 1, SuiteParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(suiteReturnEClass, SuiteReturn.class, "SuiteReturn", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSuiteReturn_Name(), this.getSuiteReturnDefinition(), null, "name", null, 0, 1, SuiteReturn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getSuiteReturn_Target(), this.getVariableVariable(), null, "target", null, 0, 1, SuiteReturn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(parameterEClass, Parameter.class, "Parameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getParameter_Name(), this.getParameterName(), null, "name", null, 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getParameter_Value(), this.getValueOrEnumValueOrOperationCollection(), null, "value", null, 0, 1, Parameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(parameterNameEClass, ParameterName.class, "ParameterName", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(fixedParameterNameEClass, FixedParameterName.class, "FixedParameterName", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFixedParameterName_Annotation(), theTypesPackage.getJvmAnnotationReference(), null, "annotation", null, 0, 1, FixedParameterName.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(arbitraryParameterOrResultNameEClass, ArbitraryParameterOrResultName.class, "ArbitraryParameterOrResultName", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getArbitraryParameterOrResultName_Identifier(), ecorePackage.getEString(), "identifier", null, 0, 1, ArbitraryParameterOrResultName.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getArbitraryParameterOrResultName_StringIdentifier(), ecorePackage.getEString(), "stringIdentifier", null, 0, 1, ArbitraryParameterOrResultName.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(operationEClass, Operation.class, "Operation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(standardOperationEClass, StandardOperation.class, "StandardOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getStandardOperation_FirstOperand(), this.getValueOrEnumValueOrOperation(), null, "firstOperand", null, 0, 1, StandardOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getStandardOperation_Operators(), ecorePackage.getEString(), "operators", null, 0, -1, StandardOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getStandardOperation_MoreOperands(), this.getValueOrEnumValueOrOperation(), null, "moreOperands", null, 0, -1, StandardOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(customOperationEClass, CustomOperation.class, "CustomOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCustomOperation_PrefixOperand(), this.getValueOrEnumValueOrOperationCollection(), null, "prefixOperand", null, 0, 1, CustomOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCustomOperation_Definition(), this.getOperationDefinition(), null, "definition", null, 0, 1, CustomOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCustomOperation_PostfixOperand(), this.getValueOrEnumValueOrOperationCollection(), null, "postfixOperand", null, 0, 1, CustomOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(valueOrEnumValueOrOperationCollectionEClass, ValueOrEnumValueOrOperationCollection.class, "ValueOrEnumValueOrOperationCollection", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getValueOrEnumValueOrOperationCollection_Value(), this.getValueOrEnumValueOrOperation(), null, "value", null, 0, 1, ValueOrEnumValueOrOperationCollection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getValueOrEnumValueOrOperationCollection_MoreValues(), this.getValueOrEnumValueOrOperation(), null, "moreValues", null, 0, -1, ValueOrEnumValueOrOperationCollection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(valueOrEnumValueOrOperationEClass, ValueOrEnumValueOrOperation.class, "ValueOrEnumValueOrOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(valueEClass, Value.class, "Value", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(constantValueEClass, ConstantValue.class, "ConstantValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(staticValueEClass, StaticValue.class, "StaticValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(integerValueEClass, IntegerValue.class, "IntegerValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getIntegerValue_IntegerValue(), ecorePackage.getEBigInteger(), "integerValue", null, 0, 1, IntegerValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(decimalValueEClass, DecimalValue.class, "DecimalValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getDecimalValue_DecimalValue(), ecorePackage.getEBigDecimal(), "decimalValue", null, 0, 1, DecimalValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(stringValueEClass, StringValue.class, "StringValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getStringValue_StringValue(), ecorePackage.getEString(), "stringValue", null, 0, 1, StringValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(booleanValueEClass, BooleanValue.class, "BooleanValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getBooleanValue_BooleanValue(), ecorePackage.getEString(), "booleanValue", null, 0, 1, BooleanValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(dateValueEClass, DateValue.class, "DateValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getDateValue_DateValue(), ecorePackage.getEString(), "dateValue", null, 0, 1, DateValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(isoDateValueEClass, IsoDateValue.class, "IsoDateValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(europeanDateValueEClass, EuropeanDateValue.class, "EuropeanDateValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(usDateValueEClass, USDateValue.class, "USDateValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(timeValueEClass, TimeValue.class, "TimeValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTimeValue_TimeValue(), ecorePackage.getEString(), "timeValue", null, 0, 1, TimeValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(isoTimeValueEClass, IsoTimeValue.class, "IsoTimeValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(simple24HrsTimeValueEClass, Simple24HrsTimeValue.class, "Simple24HrsTimeValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(simple12HrsTimeValueEClass, Simple12HrsTimeValue.class, "Simple12HrsTimeValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(dateAndTimeValueEClass, DateAndTimeValue.class, "DateAndTimeValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getDateAndTimeValue_DateValue(), ecorePackage.getEString(), "dateValue", null, 0, 1, DateAndTimeValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getDateAndTimeValue_TimeValue(), ecorePackage.getEString(), "timeValue", null, 0, 1, DateAndTimeValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(isoDateAndTimeValueEClass, IsoDateAndTimeValue.class, "IsoDateAndTimeValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(europeanDateAnd24HrsTimeValueEClass, EuropeanDateAnd24HrsTimeValue.class, "EuropeanDateAnd24HrsTimeValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(europeanDateAnd12HrsTimeValueEClass, EuropeanDateAnd12HrsTimeValue.class, "EuropeanDateAnd12HrsTimeValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(usDateAnd12HrsTimeValueEClass, USDateAnd12HrsTimeValue.class, "USDateAnd12HrsTimeValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(javaConstantValueEClass, JavaConstantValue.class, "JavaConstantValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getJavaConstantValue_Constant(), this.getJavaConstantReference(), null, "constant", null, 0, 1, JavaConstantValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(variableEClass, Variable.class, "Variable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getVariable_Name(), this.getVariableOrConstantEntity(), null, "name", null, 0, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getVariable_Attribute(), ecorePackage.getEString(), "attribute", null, 0, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(variableVariableEClass, VariableVariable.class, "VariableVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getVariableVariable_Name(), this.getVariableEntity(), null, "name", null, 0, 1, VariableVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(constantEClass, Constant.class, "Constant", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getConstant_Name(), this.getConstantEntity(), null, "name", null, 0, 1, Constant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(nullValueEClass, NullValue.class, "NullValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(inexistentValueEClass, InexistentValue.class, "InexistentValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(enumValueEClass, EnumValue.class, "EnumValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getEnumValue_EnumValue(), theTypesPackage.getJvmEnumerationLiteral(), null, "enumValue", null, 0, 1, EnumValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(nestedObjectEClass, NestedObject.class, "NestedObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getNestedObject_Attributes(), this.getKeyValuePair(), null, "attributes", null, 0, -1, NestedObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(typedNestedObjectEClass, TypedNestedObject.class, "TypedNestedObject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTypedNestedObject_Type(), this.getJavaClassReference(), null, "type", null, 0, 1, TypedNestedObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTypedNestedObject_NestedObject(), this.getNestedObject(), null, "nestedObject", null, 0, 1, TypedNestedObject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(keyValuePairEClass, KeyValuePair.class, "KeyValuePair", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getKeyValuePair_Identifier(), ecorePackage.getEString(), "identifier", null, 0, 1, KeyValuePair.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getKeyValuePair_StringIdentifier(), ecorePackage.getEString(), "stringIdentifier", null, 0, 1, KeyValuePair.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getKeyValuePair_Value(), this.getValueOrEnumValueOrOperationCollection(), null, "value", null, 0, 1, KeyValuePair.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(javaClassReferenceEClass, JavaClassReference.class, "JavaClassReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getJavaClassReference_Type(), theTypesPackage.getJvmType(), null, "type", null, 0, 1, JavaClassReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(methodReferenceEClass, MethodReference.class, "MethodReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getMethodReference_Type(), theTypesPackage.getJvmType(), null, "type", null, 0, 1, MethodReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getMethodReference_Method(), theTypesPackage.getJvmOperation(), null, "method", null, 0, 1, MethodReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(javaConstantReferenceEClass, JavaConstantReference.class, "JavaConstantReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getJavaConstantReference_Type(), theTypesPackage.getJvmType(), null, "type", null, 0, 1, JavaConstantReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getJavaConstantReference_Constant(), theTypesPackage.getJvmField(), null, "constant", null, 0, 1, JavaConstantReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(executionMultiplierEClass, ExecutionMultiplier.class, "ExecutionMultiplier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getExecutionMultiplier_Count(), this.getConstantValue(), null, "count", null, 0, 1, ExecutionMultiplier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(documentationCommentEClass, DocumentationComment.class, "DocumentationComment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getDocumentationComment_Content(), ecorePackage.getEString(), "content", null, 0, 1, DocumentationComment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(nullEClass, Null.class, "Null", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(inexistentEClass, Inexistent.class, "Inexistent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    // Create resource
    createResource(eNS_URI);
  }

} //DslPackageImpl
