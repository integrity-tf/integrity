/**
 * <copyright>
 * </copyright>
 *

 */
package de.gebit.integrity.dsl;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.gebit.integrity.dsl.DslPackage
 * @generated
 */
public interface DslFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  DslFactory eINSTANCE = de.gebit.integrity.dsl.impl.DslFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Model</em>'.
   * @generated
   */
  Model createModel();

  /**
   * Returns a new object of class '<em>Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Statement</em>'.
   * @generated
   */
  Statement createStatement();

  /**
   * Returns a new object of class '<em>Visible Comment</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Visible Comment</em>'.
   * @generated
   */
  VisibleComment createVisibleComment();

  /**
   * Returns a new object of class '<em>Visible Single Line Comment</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Visible Single Line Comment</em>'.
   * @generated
   */
  VisibleSingleLineComment createVisibleSingleLineComment();

  /**
   * Returns a new object of class '<em>Visible Single Line Normal Comment</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Visible Single Line Normal Comment</em>'.
   * @generated
   */
  VisibleSingleLineNormalComment createVisibleSingleLineNormalComment();

  /**
   * Returns a new object of class '<em>Visible Single Line Title Comment</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Visible Single Line Title Comment</em>'.
   * @generated
   */
  VisibleSingleLineTitleComment createVisibleSingleLineTitleComment();

  /**
   * Returns a new object of class '<em>Visible Multi Line Comment</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Visible Multi Line Comment</em>'.
   * @generated
   */
  VisibleMultiLineComment createVisibleMultiLineComment();

  /**
   * Returns a new object of class '<em>Visible Multi Line Normal Comment</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Visible Multi Line Normal Comment</em>'.
   * @generated
   */
  VisibleMultiLineNormalComment createVisibleMultiLineNormalComment();

  /**
   * Returns a new object of class '<em>Visible Multi Line Title Comment</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Visible Multi Line Title Comment</em>'.
   * @generated
   */
  VisibleMultiLineTitleComment createVisibleMultiLineTitleComment();

  /**
   * Returns a new object of class '<em>Visible Divider</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Visible Divider</em>'.
   * @generated
   */
  VisibleDivider createVisibleDivider();

  /**
   * Returns a new object of class '<em>Package Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Package Definition</em>'.
   * @generated
   */
  PackageDefinition createPackageDefinition();

  /**
   * Returns a new object of class '<em>Package Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Package Statement</em>'.
   * @generated
   */
  PackageStatement createPackageStatement();

  /**
   * Returns a new object of class '<em>Import</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Import</em>'.
   * @generated
   */
  Import createImport();

  /**
   * Returns a new object of class '<em>Fork Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Fork Definition</em>'.
   * @generated
   */
  ForkDefinition createForkDefinition();

  /**
   * Returns a new object of class '<em>Fork Parameter</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Fork Parameter</em>'.
   * @generated
   */
  ForkParameter createForkParameter();

  /**
   * Returns a new object of class '<em>Variant Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Variant Definition</em>'.
   * @generated
   */
  VariantDefinition createVariantDefinition();

  /**
   * Returns a new object of class '<em>Test Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Test Definition</em>'.
   * @generated
   */
  TestDefinition createTestDefinition();

  /**
   * Returns a new object of class '<em>Call Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Call Definition</em>'.
   * @generated
   */
  CallDefinition createCallDefinition();

  /**
   * Returns a new object of class '<em>Suite Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Suite Definition</em>'.
   * @generated
   */
  SuiteDefinition createSuiteDefinition();

  /**
   * Returns a new object of class '<em>Operation Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Operation Definition</em>'.
   * @generated
   */
  OperationDefinition createOperationDefinition();

  /**
   * Returns a new object of class '<em>Suite Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Suite Statement</em>'.
   * @generated
   */
  SuiteStatement createSuiteStatement();

  /**
   * Returns a new object of class '<em>Suite Statement With Result</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Suite Statement With Result</em>'.
   * @generated
   */
  SuiteStatementWithResult createSuiteStatementWithResult();

  /**
   * Returns a new object of class '<em>Variable Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Variable Definition</em>'.
   * @generated
   */
  VariableDefinition createVariableDefinition();

  /**
   * Returns a new object of class '<em>Constant Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Constant Definition</em>'.
   * @generated
   */
  ConstantDefinition createConstantDefinition();

  /**
   * Returns a new object of class '<em>Variant Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Variant Value</em>'.
   * @generated
   */
  VariantValue createVariantValue();

  /**
   * Returns a new object of class '<em>Variable Entity</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Variable Entity</em>'.
   * @generated
   */
  VariableEntity createVariableEntity();

  /**
   * Returns a new object of class '<em>Constant Entity</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Constant Entity</em>'.
   * @generated
   */
  ConstantEntity createConstantEntity();

  /**
   * Returns a new object of class '<em>Variable Or Constant Entity</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Variable Or Constant Entity</em>'.
   * @generated
   */
  VariableOrConstantEntity createVariableOrConstantEntity();

  /**
   * Returns a new object of class '<em>Test</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Test</em>'.
   * @generated
   */
  Test createTest();

  /**
   * Returns a new object of class '<em>Table Test</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Table Test</em>'.
   * @generated
   */
  TableTest createTableTest();

  /**
   * Returns a new object of class '<em>Table Test Row</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Table Test Row</em>'.
   * @generated
   */
  TableTestRow createTableTestRow();

  /**
   * Returns a new object of class '<em>Parameter Table Header</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Parameter Table Header</em>'.
   * @generated
   */
  ParameterTableHeader createParameterTableHeader();

  /**
   * Returns a new object of class '<em>Result Table Header</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Result Table Header</em>'.
   * @generated
   */
  ResultTableHeader createResultTableHeader();

  /**
   * Returns a new object of class '<em>Parameter Table Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Parameter Table Value</em>'.
   * @generated
   */
  ParameterTableValue createParameterTableValue();

  /**
   * Returns a new object of class '<em>Named Result</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Named Result</em>'.
   * @generated
   */
  NamedResult createNamedResult();

  /**
   * Returns a new object of class '<em>Result Name</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Result Name</em>'.
   * @generated
   */
  ResultName createResultName();

  /**
   * Returns a new object of class '<em>Fixed Result Name</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Fixed Result Name</em>'.
   * @generated
   */
  FixedResultName createFixedResultName();

  /**
   * Returns a new object of class '<em>Call</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Call</em>'.
   * @generated
   */
  Call createCall();

  /**
   * Returns a new object of class '<em>Named Call Result</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Named Call Result</em>'.
   * @generated
   */
  NamedCallResult createNamedCallResult();

  /**
   * Returns a new object of class '<em>Suite</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Suite</em>'.
   * @generated
   */
  Suite createSuite();

  /**
   * Returns a new object of class '<em>Suite Parameter</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Suite Parameter</em>'.
   * @generated
   */
  SuiteParameter createSuiteParameter();

  /**
   * Returns a new object of class '<em>Parameter</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Parameter</em>'.
   * @generated
   */
  Parameter createParameter();

  /**
   * Returns a new object of class '<em>Parameter Name</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Parameter Name</em>'.
   * @generated
   */
  ParameterName createParameterName();

  /**
   * Returns a new object of class '<em>Fixed Parameter Name</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Fixed Parameter Name</em>'.
   * @generated
   */
  FixedParameterName createFixedParameterName();

  /**
   * Returns a new object of class '<em>Arbitrary Parameter Or Result Name</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Arbitrary Parameter Or Result Name</em>'.
   * @generated
   */
  ArbitraryParameterOrResultName createArbitraryParameterOrResultName();

  /**
   * Returns a new object of class '<em>Operation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Operation</em>'.
   * @generated
   */
  Operation createOperation();

  /**
   * Returns a new object of class '<em>Standard Operation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Standard Operation</em>'.
   * @generated
   */
  StandardOperation createStandardOperation();

  /**
   * Returns a new object of class '<em>Custom Operation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Custom Operation</em>'.
   * @generated
   */
  CustomOperation createCustomOperation();

  /**
   * Returns a new object of class '<em>Value Or Enum Value Or Operation Collection</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Value Or Enum Value Or Operation Collection</em>'.
   * @generated
   */
  ValueOrEnumValueOrOperationCollection createValueOrEnumValueOrOperationCollection();

  /**
   * Returns a new object of class '<em>Value Or Enum Value Or Operation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Value Or Enum Value Or Operation</em>'.
   * @generated
   */
  ValueOrEnumValueOrOperation createValueOrEnumValueOrOperation();

  /**
   * Returns a new object of class '<em>Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Value</em>'.
   * @generated
   */
  Value createValue();

  /**
   * Returns a new object of class '<em>Constant Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Constant Value</em>'.
   * @generated
   */
  ConstantValue createConstantValue();

  /**
   * Returns a new object of class '<em>Static Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Static Value</em>'.
   * @generated
   */
  StaticValue createStaticValue();

  /**
   * Returns a new object of class '<em>Integer Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Integer Value</em>'.
   * @generated
   */
  IntegerValue createIntegerValue();

  /**
   * Returns a new object of class '<em>Decimal Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Decimal Value</em>'.
   * @generated
   */
  DecimalValue createDecimalValue();

  /**
   * Returns a new object of class '<em>String Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>String Value</em>'.
   * @generated
   */
  StringValue createStringValue();

  /**
   * Returns a new object of class '<em>Boolean Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Boolean Value</em>'.
   * @generated
   */
  BooleanValue createBooleanValue();

  /**
   * Returns a new object of class '<em>Date Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Date Value</em>'.
   * @generated
   */
  DateValue createDateValue();

  /**
   * Returns a new object of class '<em>Iso Date Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Iso Date Value</em>'.
   * @generated
   */
  IsoDateValue createIsoDateValue();

  /**
   * Returns a new object of class '<em>European Date Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>European Date Value</em>'.
   * @generated
   */
  EuropeanDateValue createEuropeanDateValue();

  /**
   * Returns a new object of class '<em>US Date Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>US Date Value</em>'.
   * @generated
   */
  USDateValue createUSDateValue();

  /**
   * Returns a new object of class '<em>Time Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Time Value</em>'.
   * @generated
   */
  TimeValue createTimeValue();

  /**
   * Returns a new object of class '<em>Iso Time Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Iso Time Value</em>'.
   * @generated
   */
  IsoTimeValue createIsoTimeValue();

  /**
   * Returns a new object of class '<em>Simple24 Hrs Time Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Simple24 Hrs Time Value</em>'.
   * @generated
   */
  Simple24HrsTimeValue createSimple24HrsTimeValue();

  /**
   * Returns a new object of class '<em>Simple12 Hrs Time Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Simple12 Hrs Time Value</em>'.
   * @generated
   */
  Simple12HrsTimeValue createSimple12HrsTimeValue();

  /**
   * Returns a new object of class '<em>Date And Time Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Date And Time Value</em>'.
   * @generated
   */
  DateAndTimeValue createDateAndTimeValue();

  /**
   * Returns a new object of class '<em>Iso Date And Time Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Iso Date And Time Value</em>'.
   * @generated
   */
  IsoDateAndTimeValue createIsoDateAndTimeValue();

  /**
   * Returns a new object of class '<em>European Date And24 Hrs Time Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>European Date And24 Hrs Time Value</em>'.
   * @generated
   */
  EuropeanDateAnd24HrsTimeValue createEuropeanDateAnd24HrsTimeValue();

  /**
   * Returns a new object of class '<em>European Date And12 Hrs Time Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>European Date And12 Hrs Time Value</em>'.
   * @generated
   */
  EuropeanDateAnd12HrsTimeValue createEuropeanDateAnd12HrsTimeValue();

  /**
   * Returns a new object of class '<em>US Date And12 Hrs Time Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>US Date And12 Hrs Time Value</em>'.
   * @generated
   */
  USDateAnd12HrsTimeValue createUSDateAnd12HrsTimeValue();

  /**
   * Returns a new object of class '<em>Variable</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Variable</em>'.
   * @generated
   */
  Variable createVariable();

  /**
   * Returns a new object of class '<em>Variable Variable</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Variable Variable</em>'.
   * @generated
   */
  VariableVariable createVariableVariable();

  /**
   * Returns a new object of class '<em>Constant</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Constant</em>'.
   * @generated
   */
  Constant createConstant();

  /**
   * Returns a new object of class '<em>Null Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Null Value</em>'.
   * @generated
   */
  NullValue createNullValue();

  /**
   * Returns a new object of class '<em>Enum Value</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Enum Value</em>'.
   * @generated
   */
  EnumValue createEnumValue();

  /**
   * Returns a new object of class '<em>Nested Object</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Nested Object</em>'.
   * @generated
   */
  NestedObject createNestedObject();

  /**
   * Returns a new object of class '<em>Key Value Pair</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Key Value Pair</em>'.
   * @generated
   */
  KeyValuePair createKeyValuePair();

  /**
   * Returns a new object of class '<em>Java Class Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Java Class Reference</em>'.
   * @generated
   */
  JavaClassReference createJavaClassReference();

  /**
   * Returns a new object of class '<em>Method Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Method Reference</em>'.
   * @generated
   */
  MethodReference createMethodReference();

  /**
   * Returns a new object of class '<em>Execution Multiplier</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Execution Multiplier</em>'.
   * @generated
   */
  ExecutionMultiplier createExecutionMultiplier();

  /**
   * Returns a new object of class '<em>Null</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Null</em>'.
   * @generated
   */
  Null createNull();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  DslPackage getDslPackage();

} //DslFactory
