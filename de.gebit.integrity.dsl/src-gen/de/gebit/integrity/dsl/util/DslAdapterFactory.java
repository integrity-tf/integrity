/**
 */
package de.gebit.integrity.dsl.util;

import de.gebit.integrity.dsl.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see de.gebit.integrity.dsl.DslPackage
 * @generated
 */
public class DslAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static DslPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DslAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = DslPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DslSwitch<Adapter> modelSwitch =
    new DslSwitch<Adapter>()
    {
      @Override
      public Adapter caseModel(Model object)
      {
        return createModelAdapter();
      }
      @Override
      public Adapter caseStatement(Statement object)
      {
        return createStatementAdapter();
      }
      @Override
      public Adapter caseVisibleComment(VisibleComment object)
      {
        return createVisibleCommentAdapter();
      }
      @Override
      public Adapter caseVisibleSingleLineComment(VisibleSingleLineComment object)
      {
        return createVisibleSingleLineCommentAdapter();
      }
      @Override
      public Adapter caseVisibleMultiLineComment(VisibleMultiLineComment object)
      {
        return createVisibleMultiLineCommentAdapter();
      }
      @Override
      public Adapter caseVisibleDivider(VisibleDivider object)
      {
        return createVisibleDividerAdapter();
      }
      @Override
      public Adapter casePackageDefinition(PackageDefinition object)
      {
        return createPackageDefinitionAdapter();
      }
      @Override
      public Adapter casePackageStatement(PackageStatement object)
      {
        return createPackageStatementAdapter();
      }
      @Override
      public Adapter caseImport(Import object)
      {
        return createImportAdapter();
      }
      @Override
      public Adapter caseForkDefinition(ForkDefinition object)
      {
        return createForkDefinitionAdapter();
      }
      @Override
      public Adapter caseForkParameter(ForkParameter object)
      {
        return createForkParameterAdapter();
      }
      @Override
      public Adapter caseVariantDefinition(VariantDefinition object)
      {
        return createVariantDefinitionAdapter();
      }
      @Override
      public Adapter caseTestDefinition(TestDefinition object)
      {
        return createTestDefinitionAdapter();
      }
      @Override
      public Adapter caseCallDefinition(CallDefinition object)
      {
        return createCallDefinitionAdapter();
      }
      @Override
      public Adapter caseSuiteDefinition(SuiteDefinition object)
      {
        return createSuiteDefinitionAdapter();
      }
      @Override
      public Adapter caseOperationDefinition(OperationDefinition object)
      {
        return createOperationDefinitionAdapter();
      }
      @Override
      public Adapter caseSuiteStatement(SuiteStatement object)
      {
        return createSuiteStatementAdapter();
      }
      @Override
      public Adapter caseSuiteStatementWithResult(SuiteStatementWithResult object)
      {
        return createSuiteStatementWithResultAdapter();
      }
      @Override
      public Adapter caseVariableDefinition(VariableDefinition object)
      {
        return createVariableDefinitionAdapter();
      }
      @Override
      public Adapter caseConstantDefinition(ConstantDefinition object)
      {
        return createConstantDefinitionAdapter();
      }
      @Override
      public Adapter caseVariantValue(VariantValue object)
      {
        return createVariantValueAdapter();
      }
      @Override
      public Adapter caseVariableEntity(VariableEntity object)
      {
        return createVariableEntityAdapter();
      }
      @Override
      public Adapter caseConstantEntity(ConstantEntity object)
      {
        return createConstantEntityAdapter();
      }
      @Override
      public Adapter caseVariableOrConstantEntity(VariableOrConstantEntity object)
      {
        return createVariableOrConstantEntityAdapter();
      }
      @Override
      public Adapter caseTest(Test object)
      {
        return createTestAdapter();
      }
      @Override
      public Adapter caseTableTest(TableTest object)
      {
        return createTableTestAdapter();
      }
      @Override
      public Adapter caseTableTestRow(TableTestRow object)
      {
        return createTableTestRowAdapter();
      }
      @Override
      public Adapter caseParameterTableHeader(ParameterTableHeader object)
      {
        return createParameterTableHeaderAdapter();
      }
      @Override
      public Adapter caseResultTableHeader(ResultTableHeader object)
      {
        return createResultTableHeaderAdapter();
      }
      @Override
      public Adapter caseParameterTableValue(ParameterTableValue object)
      {
        return createParameterTableValueAdapter();
      }
      @Override
      public Adapter caseNamedResult(NamedResult object)
      {
        return createNamedResultAdapter();
      }
      @Override
      public Adapter caseResultName(ResultName object)
      {
        return createResultNameAdapter();
      }
      @Override
      public Adapter caseFixedResultName(FixedResultName object)
      {
        return createFixedResultNameAdapter();
      }
      @Override
      public Adapter caseCall(Call object)
      {
        return createCallAdapter();
      }
      @Override
      public Adapter caseNamedCallResult(NamedCallResult object)
      {
        return createNamedCallResultAdapter();
      }
      @Override
      public Adapter caseSuite(Suite object)
      {
        return createSuiteAdapter();
      }
      @Override
      public Adapter caseSuiteParameter(SuiteParameter object)
      {
        return createSuiteParameterAdapter();
      }
      @Override
      public Adapter caseParameter(Parameter object)
      {
        return createParameterAdapter();
      }
      @Override
      public Adapter caseParameterName(ParameterName object)
      {
        return createParameterNameAdapter();
      }
      @Override
      public Adapter caseFixedParameterName(FixedParameterName object)
      {
        return createFixedParameterNameAdapter();
      }
      @Override
      public Adapter caseArbitraryParameterOrResultName(ArbitraryParameterOrResultName object)
      {
        return createArbitraryParameterOrResultNameAdapter();
      }
      @Override
      public Adapter caseOperation(Operation object)
      {
        return createOperationAdapter();
      }
      @Override
      public Adapter caseStandardOperation(StandardOperation object)
      {
        return createStandardOperationAdapter();
      }
      @Override
      public Adapter caseCustomOperation(CustomOperation object)
      {
        return createCustomOperationAdapter();
      }
      @Override
      public Adapter caseValueOrEnumValueOrOperationCollection(ValueOrEnumValueOrOperationCollection object)
      {
        return createValueOrEnumValueOrOperationCollectionAdapter();
      }
      @Override
      public Adapter caseValueOrEnumValueOrOperation(ValueOrEnumValueOrOperation object)
      {
        return createValueOrEnumValueOrOperationAdapter();
      }
      @Override
      public Adapter caseValue(Value object)
      {
        return createValueAdapter();
      }
      @Override
      public Adapter caseStaticValue(StaticValue object)
      {
        return createStaticValueAdapter();
      }
      @Override
      public Adapter caseIntegerValue(IntegerValue object)
      {
        return createIntegerValueAdapter();
      }
      @Override
      public Adapter caseDecimalValue(DecimalValue object)
      {
        return createDecimalValueAdapter();
      }
      @Override
      public Adapter caseStringValue(StringValue object)
      {
        return createStringValueAdapter();
      }
      @Override
      public Adapter caseBooleanValue(BooleanValue object)
      {
        return createBooleanValueAdapter();
      }
      @Override
      public Adapter caseDateValue(DateValue object)
      {
        return createDateValueAdapter();
      }
      @Override
      public Adapter caseIsoDateValue(IsoDateValue object)
      {
        return createIsoDateValueAdapter();
      }
      @Override
      public Adapter caseEuropeanDateValue(EuropeanDateValue object)
      {
        return createEuropeanDateValueAdapter();
      }
      @Override
      public Adapter caseUSDateValue(USDateValue object)
      {
        return createUSDateValueAdapter();
      }
      @Override
      public Adapter caseTimeValue(TimeValue object)
      {
        return createTimeValueAdapter();
      }
      @Override
      public Adapter caseIsoTimeValue(IsoTimeValue object)
      {
        return createIsoTimeValueAdapter();
      }
      @Override
      public Adapter caseSimple24HrsTimeValue(Simple24HrsTimeValue object)
      {
        return createSimple24HrsTimeValueAdapter();
      }
      @Override
      public Adapter caseSimple12HrsTimeValue(Simple12HrsTimeValue object)
      {
        return createSimple12HrsTimeValueAdapter();
      }
      @Override
      public Adapter caseDateAndTimeValue(DateAndTimeValue object)
      {
        return createDateAndTimeValueAdapter();
      }
      @Override
      public Adapter caseIsoDateAndTimeValue(IsoDateAndTimeValue object)
      {
        return createIsoDateAndTimeValueAdapter();
      }
      @Override
      public Adapter caseEuropeanDateAnd24HrsTimeValue(EuropeanDateAnd24HrsTimeValue object)
      {
        return createEuropeanDateAnd24HrsTimeValueAdapter();
      }
      @Override
      public Adapter caseEuropeanDateAnd12HrsTimeValue(EuropeanDateAnd12HrsTimeValue object)
      {
        return createEuropeanDateAnd12HrsTimeValueAdapter();
      }
      @Override
      public Adapter caseUSDateAnd12HrsTimeValue(USDateAnd12HrsTimeValue object)
      {
        return createUSDateAnd12HrsTimeValueAdapter();
      }
      @Override
      public Adapter caseVariable(Variable object)
      {
        return createVariableAdapter();
      }
      @Override
      public Adapter caseNullValue(NullValue object)
      {
        return createNullValueAdapter();
      }
      @Override
      public Adapter caseEnumValue(EnumValue object)
      {
        return createEnumValueAdapter();
      }
      @Override
      public Adapter caseNestedObject(NestedObject object)
      {
        return createNestedObjectAdapter();
      }
      @Override
      public Adapter caseKeyValuePair(KeyValuePair object)
      {
        return createKeyValuePairAdapter();
      }
      @Override
      public Adapter caseJavaClassReference(JavaClassReference object)
      {
        return createJavaClassReferenceAdapter();
      }
      @Override
      public Adapter caseMethodReference(MethodReference object)
      {
        return createMethodReferenceAdapter();
      }
      @Override
      public Adapter caseExecutionMultiplier(ExecutionMultiplier object)
      {
        return createExecutionMultiplierAdapter();
      }
      @Override
      public Adapter caseNull(Null object)
      {
        return createNullAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.Model
   * @generated
   */
  public Adapter createModelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.Statement <em>Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.Statement
   * @generated
   */
  public Adapter createStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.VisibleComment <em>Visible Comment</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.VisibleComment
   * @generated
   */
  public Adapter createVisibleCommentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.VisibleSingleLineComment <em>Visible Single Line Comment</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.VisibleSingleLineComment
   * @generated
   */
  public Adapter createVisibleSingleLineCommentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.VisibleMultiLineComment <em>Visible Multi Line Comment</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.VisibleMultiLineComment
   * @generated
   */
  public Adapter createVisibleMultiLineCommentAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.VisibleDivider <em>Visible Divider</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.VisibleDivider
   * @generated
   */
  public Adapter createVisibleDividerAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.PackageDefinition <em>Package Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.PackageDefinition
   * @generated
   */
  public Adapter createPackageDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.PackageStatement <em>Package Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.PackageStatement
   * @generated
   */
  public Adapter createPackageStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.Import <em>Import</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.Import
   * @generated
   */
  public Adapter createImportAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.ForkDefinition <em>Fork Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.ForkDefinition
   * @generated
   */
  public Adapter createForkDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.ForkParameter <em>Fork Parameter</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.ForkParameter
   * @generated
   */
  public Adapter createForkParameterAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.VariantDefinition <em>Variant Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.VariantDefinition
   * @generated
   */
  public Adapter createVariantDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.TestDefinition <em>Test Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.TestDefinition
   * @generated
   */
  public Adapter createTestDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.CallDefinition <em>Call Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.CallDefinition
   * @generated
   */
  public Adapter createCallDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.SuiteDefinition <em>Suite Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.SuiteDefinition
   * @generated
   */
  public Adapter createSuiteDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.OperationDefinition <em>Operation Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.OperationDefinition
   * @generated
   */
  public Adapter createOperationDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.SuiteStatement <em>Suite Statement</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.SuiteStatement
   * @generated
   */
  public Adapter createSuiteStatementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.SuiteStatementWithResult <em>Suite Statement With Result</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.SuiteStatementWithResult
   * @generated
   */
  public Adapter createSuiteStatementWithResultAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.VariableDefinition <em>Variable Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.VariableDefinition
   * @generated
   */
  public Adapter createVariableDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.ConstantDefinition <em>Constant Definition</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.ConstantDefinition
   * @generated
   */
  public Adapter createConstantDefinitionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.VariantValue <em>Variant Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.VariantValue
   * @generated
   */
  public Adapter createVariantValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.VariableEntity <em>Variable Entity</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.VariableEntity
   * @generated
   */
  public Adapter createVariableEntityAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.ConstantEntity <em>Constant Entity</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.ConstantEntity
   * @generated
   */
  public Adapter createConstantEntityAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.VariableOrConstantEntity <em>Variable Or Constant Entity</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.VariableOrConstantEntity
   * @generated
   */
  public Adapter createVariableOrConstantEntityAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.Test <em>Test</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.Test
   * @generated
   */
  public Adapter createTestAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.TableTest <em>Table Test</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.TableTest
   * @generated
   */
  public Adapter createTableTestAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.TableTestRow <em>Table Test Row</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.TableTestRow
   * @generated
   */
  public Adapter createTableTestRowAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.ParameterTableHeader <em>Parameter Table Header</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.ParameterTableHeader
   * @generated
   */
  public Adapter createParameterTableHeaderAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.ResultTableHeader <em>Result Table Header</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.ResultTableHeader
   * @generated
   */
  public Adapter createResultTableHeaderAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.ParameterTableValue <em>Parameter Table Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.ParameterTableValue
   * @generated
   */
  public Adapter createParameterTableValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.NamedResult <em>Named Result</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.NamedResult
   * @generated
   */
  public Adapter createNamedResultAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.ResultName <em>Result Name</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.ResultName
   * @generated
   */
  public Adapter createResultNameAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.FixedResultName <em>Fixed Result Name</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.FixedResultName
   * @generated
   */
  public Adapter createFixedResultNameAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.Call <em>Call</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.Call
   * @generated
   */
  public Adapter createCallAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.NamedCallResult <em>Named Call Result</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.NamedCallResult
   * @generated
   */
  public Adapter createNamedCallResultAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.Suite <em>Suite</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.Suite
   * @generated
   */
  public Adapter createSuiteAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.SuiteParameter <em>Suite Parameter</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.SuiteParameter
   * @generated
   */
  public Adapter createSuiteParameterAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.Parameter <em>Parameter</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.Parameter
   * @generated
   */
  public Adapter createParameterAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.ParameterName <em>Parameter Name</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.ParameterName
   * @generated
   */
  public Adapter createParameterNameAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.FixedParameterName <em>Fixed Parameter Name</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.FixedParameterName
   * @generated
   */
  public Adapter createFixedParameterNameAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.ArbitraryParameterOrResultName <em>Arbitrary Parameter Or Result Name</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.ArbitraryParameterOrResultName
   * @generated
   */
  public Adapter createArbitraryParameterOrResultNameAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.Operation <em>Operation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.Operation
   * @generated
   */
  public Adapter createOperationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.StandardOperation <em>Standard Operation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.StandardOperation
   * @generated
   */
  public Adapter createStandardOperationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.CustomOperation <em>Custom Operation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.CustomOperation
   * @generated
   */
  public Adapter createCustomOperationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.ValueOrEnumValueOrOperationCollection <em>Value Or Enum Value Or Operation Collection</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.ValueOrEnumValueOrOperationCollection
   * @generated
   */
  public Adapter createValueOrEnumValueOrOperationCollectionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.ValueOrEnumValueOrOperation <em>Value Or Enum Value Or Operation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.ValueOrEnumValueOrOperation
   * @generated
   */
  public Adapter createValueOrEnumValueOrOperationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.Value <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.Value
   * @generated
   */
  public Adapter createValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.StaticValue <em>Static Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.StaticValue
   * @generated
   */
  public Adapter createStaticValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.IntegerValue <em>Integer Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.IntegerValue
   * @generated
   */
  public Adapter createIntegerValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.DecimalValue <em>Decimal Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.DecimalValue
   * @generated
   */
  public Adapter createDecimalValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.StringValue <em>String Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.StringValue
   * @generated
   */
  public Adapter createStringValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.BooleanValue <em>Boolean Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.BooleanValue
   * @generated
   */
  public Adapter createBooleanValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.DateValue <em>Date Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.DateValue
   * @generated
   */
  public Adapter createDateValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.IsoDateValue <em>Iso Date Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.IsoDateValue
   * @generated
   */
  public Adapter createIsoDateValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.EuropeanDateValue <em>European Date Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.EuropeanDateValue
   * @generated
   */
  public Adapter createEuropeanDateValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.USDateValue <em>US Date Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.USDateValue
   * @generated
   */
  public Adapter createUSDateValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.TimeValue <em>Time Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.TimeValue
   * @generated
   */
  public Adapter createTimeValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.IsoTimeValue <em>Iso Time Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.IsoTimeValue
   * @generated
   */
  public Adapter createIsoTimeValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.Simple24HrsTimeValue <em>Simple24 Hrs Time Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.Simple24HrsTimeValue
   * @generated
   */
  public Adapter createSimple24HrsTimeValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.Simple12HrsTimeValue <em>Simple12 Hrs Time Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.Simple12HrsTimeValue
   * @generated
   */
  public Adapter createSimple12HrsTimeValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.DateAndTimeValue <em>Date And Time Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.DateAndTimeValue
   * @generated
   */
  public Adapter createDateAndTimeValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.IsoDateAndTimeValue <em>Iso Date And Time Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.IsoDateAndTimeValue
   * @generated
   */
  public Adapter createIsoDateAndTimeValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.EuropeanDateAnd24HrsTimeValue <em>European Date And24 Hrs Time Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.EuropeanDateAnd24HrsTimeValue
   * @generated
   */
  public Adapter createEuropeanDateAnd24HrsTimeValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.EuropeanDateAnd12HrsTimeValue <em>European Date And12 Hrs Time Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.EuropeanDateAnd12HrsTimeValue
   * @generated
   */
  public Adapter createEuropeanDateAnd12HrsTimeValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.USDateAnd12HrsTimeValue <em>US Date And12 Hrs Time Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.USDateAnd12HrsTimeValue
   * @generated
   */
  public Adapter createUSDateAnd12HrsTimeValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.Variable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.Variable
   * @generated
   */
  public Adapter createVariableAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.NullValue <em>Null Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.NullValue
   * @generated
   */
  public Adapter createNullValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.EnumValue <em>Enum Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.EnumValue
   * @generated
   */
  public Adapter createEnumValueAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.NestedObject <em>Nested Object</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.NestedObject
   * @generated
   */
  public Adapter createNestedObjectAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.KeyValuePair <em>Key Value Pair</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.KeyValuePair
   * @generated
   */
  public Adapter createKeyValuePairAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.JavaClassReference <em>Java Class Reference</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.JavaClassReference
   * @generated
   */
  public Adapter createJavaClassReferenceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.MethodReference <em>Method Reference</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.MethodReference
   * @generated
   */
  public Adapter createMethodReferenceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.ExecutionMultiplier <em>Execution Multiplier</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.ExecutionMultiplier
   * @generated
   */
  public Adapter createExecutionMultiplierAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.Null <em>Null</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.Null
   * @generated
   */
  public Adapter createNullAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //DslAdapterFactory
