/**
 * <copyright>
 * </copyright>
 *

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
      public Adapter caseVariableEntity(VariableEntity object)
      {
        return createVariableEntityAdapter();
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
      public Adapter caseValueOrEnumValueCollection(ValueOrEnumValueCollection object)
      {
        return createValueOrEnumValueCollectionAdapter();
      }
      @Override
      public Adapter caseValueOrEnumValue(ValueOrEnumValue object)
      {
        return createValueOrEnumValueAdapter();
      }
      @Override
      public Adapter caseValue(Value object)
      {
        return createValueAdapter();
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
      public Adapter caseMethodReference(MethodReference object)
      {
        return createMethodReferenceAdapter();
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
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.ValueOrEnumValueCollection <em>Value Or Enum Value Collection</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.ValueOrEnumValueCollection
   * @generated
   */
  public Adapter createValueOrEnumValueCollectionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link de.gebit.integrity.dsl.ValueOrEnumValue <em>Value Or Enum Value</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see de.gebit.integrity.dsl.ValueOrEnumValue
   * @generated
   */
  public Adapter createValueOrEnumValueAdapter()
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
