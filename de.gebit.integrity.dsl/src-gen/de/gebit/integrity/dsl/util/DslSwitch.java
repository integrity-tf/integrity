/**
 */
package de.gebit.integrity.dsl.util;

import de.gebit.integrity.dsl.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see de.gebit.integrity.dsl.DslPackage
 * @generated
 */
public class DslSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static DslPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DslSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = DslPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @parameter ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case DslPackage.MODEL:
      {
        Model model = (Model)theEObject;
        T result = caseModel(model);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.STATEMENT:
      {
        Statement statement = (Statement)theEObject;
        T result = caseStatement(statement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.VISIBLE_SINGLE_LINE_COMMENT:
      {
        VisibleSingleLineComment visibleSingleLineComment = (VisibleSingleLineComment)theEObject;
        T result = caseVisibleSingleLineComment(visibleSingleLineComment);
        if (result == null) result = caseSuiteStatement(visibleSingleLineComment);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.VISIBLE_MULTI_LINE_COMMENT:
      {
        VisibleMultiLineComment visibleMultiLineComment = (VisibleMultiLineComment)theEObject;
        T result = caseVisibleMultiLineComment(visibleMultiLineComment);
        if (result == null) result = caseSuiteStatement(visibleMultiLineComment);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.VISIBLE_DIVIDER:
      {
        VisibleDivider visibleDivider = (VisibleDivider)theEObject;
        T result = caseVisibleDivider(visibleDivider);
        if (result == null) result = caseSuiteStatement(visibleDivider);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.PACKAGE_DEFINITION:
      {
        PackageDefinition packageDefinition = (PackageDefinition)theEObject;
        T result = casePackageDefinition(packageDefinition);
        if (result == null) result = caseStatement(packageDefinition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.PACKAGE_STATEMENT:
      {
        PackageStatement packageStatement = (PackageStatement)theEObject;
        T result = casePackageStatement(packageStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.IMPORT:
      {
        Import import_ = (Import)theEObject;
        T result = caseImport(import_);
        if (result == null) result = caseStatement(import_);
        if (result == null) result = casePackageStatement(import_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.FORK_DEFINITION:
      {
        ForkDefinition forkDefinition = (ForkDefinition)theEObject;
        T result = caseForkDefinition(forkDefinition);
        if (result == null) result = caseStatement(forkDefinition);
        if (result == null) result = casePackageStatement(forkDefinition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.FORK_PARAMETER:
      {
        ForkParameter forkParameter = (ForkParameter)theEObject;
        T result = caseForkParameter(forkParameter);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.VARIANT_DEFINITION:
      {
        VariantDefinition variantDefinition = (VariantDefinition)theEObject;
        T result = caseVariantDefinition(variantDefinition);
        if (result == null) result = caseStatement(variantDefinition);
        if (result == null) result = casePackageStatement(variantDefinition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.TEST_DEFINITION:
      {
        TestDefinition testDefinition = (TestDefinition)theEObject;
        T result = caseTestDefinition(testDefinition);
        if (result == null) result = casePackageStatement(testDefinition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.CALL_DEFINITION:
      {
        CallDefinition callDefinition = (CallDefinition)theEObject;
        T result = caseCallDefinition(callDefinition);
        if (result == null) result = casePackageStatement(callDefinition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.SUITE_DEFINITION:
      {
        SuiteDefinition suiteDefinition = (SuiteDefinition)theEObject;
        T result = caseSuiteDefinition(suiteDefinition);
        if (result == null) result = casePackageStatement(suiteDefinition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.SUITE_STATEMENT:
      {
        SuiteStatement suiteStatement = (SuiteStatement)theEObject;
        T result = caseSuiteStatement(suiteStatement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.SUITE_STATEMENT_WITH_RESULT:
      {
        SuiteStatementWithResult suiteStatementWithResult = (SuiteStatementWithResult)theEObject;
        T result = caseSuiteStatementWithResult(suiteStatementWithResult);
        if (result == null) result = caseSuiteStatement(suiteStatementWithResult);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.VARIABLE_DEFINITION:
      {
        VariableDefinition variableDefinition = (VariableDefinition)theEObject;
        T result = caseVariableDefinition(variableDefinition);
        if (result == null) result = casePackageStatement(variableDefinition);
        if (result == null) result = caseSuiteStatement(variableDefinition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.CONSTANT_DEFINITION:
      {
        ConstantDefinition constantDefinition = (ConstantDefinition)theEObject;
        T result = caseConstantDefinition(constantDefinition);
        if (result == null) result = casePackageStatement(constantDefinition);
        if (result == null) result = caseSuiteStatement(constantDefinition);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.VARIANT_VALUE:
      {
        VariantValue variantValue = (VariantValue)theEObject;
        T result = caseVariantValue(variantValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.VARIABLE_ENTITY:
      {
        VariableEntity variableEntity = (VariableEntity)theEObject;
        T result = caseVariableEntity(variableEntity);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.TEST:
      {
        Test test = (Test)theEObject;
        T result = caseTest(test);
        if (result == null) result = caseSuiteStatementWithResult(test);
        if (result == null) result = caseSuiteStatement(test);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.TABLE_TEST:
      {
        TableTest tableTest = (TableTest)theEObject;
        T result = caseTableTest(tableTest);
        if (result == null) result = caseSuiteStatementWithResult(tableTest);
        if (result == null) result = caseSuiteStatement(tableTest);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.TABLE_TEST_ROW:
      {
        TableTestRow tableTestRow = (TableTestRow)theEObject;
        T result = caseTableTestRow(tableTestRow);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.PARAMETER_TABLE_HEADER:
      {
        ParameterTableHeader parameterTableHeader = (ParameterTableHeader)theEObject;
        T result = caseParameterTableHeader(parameterTableHeader);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.RESULT_TABLE_HEADER:
      {
        ResultTableHeader resultTableHeader = (ResultTableHeader)theEObject;
        T result = caseResultTableHeader(resultTableHeader);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.PARAMETER_TABLE_VALUE:
      {
        ParameterTableValue parameterTableValue = (ParameterTableValue)theEObject;
        T result = caseParameterTableValue(parameterTableValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.NAMED_RESULT:
      {
        NamedResult namedResult = (NamedResult)theEObject;
        T result = caseNamedResult(namedResult);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.RESULT_NAME:
      {
        ResultName resultName = (ResultName)theEObject;
        T result = caseResultName(resultName);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.FIXED_RESULT_NAME:
      {
        FixedResultName fixedResultName = (FixedResultName)theEObject;
        T result = caseFixedResultName(fixedResultName);
        if (result == null) result = caseResultName(fixedResultName);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.CALL:
      {
        Call call = (Call)theEObject;
        T result = caseCall(call);
        if (result == null) result = caseSuiteStatementWithResult(call);
        if (result == null) result = caseSuiteStatement(call);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.NAMED_CALL_RESULT:
      {
        NamedCallResult namedCallResult = (NamedCallResult)theEObject;
        T result = caseNamedCallResult(namedCallResult);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.SUITE:
      {
        Suite suite = (Suite)theEObject;
        T result = caseSuite(suite);
        if (result == null) result = caseSuiteStatementWithResult(suite);
        if (result == null) result = caseSuiteStatement(suite);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.SUITE_PARAMETER:
      {
        SuiteParameter suiteParameter = (SuiteParameter)theEObject;
        T result = caseSuiteParameter(suiteParameter);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.PARAMETER:
      {
        Parameter parameter = (Parameter)theEObject;
        T result = caseParameter(parameter);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.PARAMETER_NAME:
      {
        ParameterName parameterName = (ParameterName)theEObject;
        T result = caseParameterName(parameterName);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.FIXED_PARAMETER_NAME:
      {
        FixedParameterName fixedParameterName = (FixedParameterName)theEObject;
        T result = caseFixedParameterName(fixedParameterName);
        if (result == null) result = caseParameterName(fixedParameterName);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.ARBITRARY_PARAMETER_OR_RESULT_NAME:
      {
        ArbitraryParameterOrResultName arbitraryParameterOrResultName = (ArbitraryParameterOrResultName)theEObject;
        T result = caseArbitraryParameterOrResultName(arbitraryParameterOrResultName);
        if (result == null) result = caseResultName(arbitraryParameterOrResultName);
        if (result == null) result = caseParameterName(arbitraryParameterOrResultName);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.VALUE_OR_ENUM_VALUE_COLLECTION:
      {
        ValueOrEnumValueCollection valueOrEnumValueCollection = (ValueOrEnumValueCollection)theEObject;
        T result = caseValueOrEnumValueCollection(valueOrEnumValueCollection);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.VALUE_OR_ENUM_VALUE:
      {
        ValueOrEnumValue valueOrEnumValue = (ValueOrEnumValue)theEObject;
        T result = caseValueOrEnumValue(valueOrEnumValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.VALUE:
      {
        Value value = (Value)theEObject;
        T result = caseValue(value);
        if (result == null) result = caseValueOrEnumValue(value);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.STATIC_VALUE:
      {
        StaticValue staticValue = (StaticValue)theEObject;
        T result = caseStaticValue(staticValue);
        if (result == null) result = caseValue(staticValue);
        if (result == null) result = caseValueOrEnumValue(staticValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.INTEGER_VALUE:
      {
        IntegerValue integerValue = (IntegerValue)theEObject;
        T result = caseIntegerValue(integerValue);
        if (result == null) result = caseStaticValue(integerValue);
        if (result == null) result = caseValue(integerValue);
        if (result == null) result = caseValueOrEnumValue(integerValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.DECIMAL_VALUE:
      {
        DecimalValue decimalValue = (DecimalValue)theEObject;
        T result = caseDecimalValue(decimalValue);
        if (result == null) result = caseStaticValue(decimalValue);
        if (result == null) result = caseValue(decimalValue);
        if (result == null) result = caseValueOrEnumValue(decimalValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.STRING_VALUE:
      {
        StringValue stringValue = (StringValue)theEObject;
        T result = caseStringValue(stringValue);
        if (result == null) result = caseStaticValue(stringValue);
        if (result == null) result = caseValue(stringValue);
        if (result == null) result = caseValueOrEnumValue(stringValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.BOOLEAN_VALUE:
      {
        BooleanValue booleanValue = (BooleanValue)theEObject;
        T result = caseBooleanValue(booleanValue);
        if (result == null) result = caseStaticValue(booleanValue);
        if (result == null) result = caseValue(booleanValue);
        if (result == null) result = caseValueOrEnumValue(booleanValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.VARIABLE:
      {
        Variable variable = (Variable)theEObject;
        T result = caseVariable(variable);
        if (result == null) result = caseValue(variable);
        if (result == null) result = caseValueOrEnumValue(variable);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.NULL_VALUE:
      {
        NullValue nullValue = (NullValue)theEObject;
        T result = caseNullValue(nullValue);
        if (result == null) result = caseStaticValue(nullValue);
        if (result == null) result = caseValue(nullValue);
        if (result == null) result = caseValueOrEnumValue(nullValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.ENUM_VALUE:
      {
        EnumValue enumValue = (EnumValue)theEObject;
        T result = caseEnumValue(enumValue);
        if (result == null) result = caseValueOrEnumValue(enumValue);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.JAVA_CLASS_REFERENCE:
      {
        JavaClassReference javaClassReference = (JavaClassReference)theEObject;
        T result = caseJavaClassReference(javaClassReference);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.METHOD_REFERENCE:
      {
        MethodReference methodReference = (MethodReference)theEObject;
        T result = caseMethodReference(methodReference);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.EXECUTION_MULTIPLIER:
      {
        ExecutionMultiplier executionMultiplier = (ExecutionMultiplier)theEObject;
        T result = caseExecutionMultiplier(executionMultiplier);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case DslPackage.NULL:
      {
        Null null_ = (Null)theEObject;
        T result = caseNull(null_);
        if (result == null) result = caseNullValue(null_);
        if (result == null) result = caseStaticValue(null_);
        if (result == null) result = caseValue(null_);
        if (result == null) result = caseValueOrEnumValue(null_);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Model</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Model</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseModel(Model object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStatement(Statement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Visible Single Line Comment</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Visible Single Line Comment</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVisibleSingleLineComment(VisibleSingleLineComment object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Visible Multi Line Comment</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Visible Multi Line Comment</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVisibleMultiLineComment(VisibleMultiLineComment object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Visible Divider</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Visible Divider</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVisibleDivider(VisibleDivider object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Package Definition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Package Definition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePackageDefinition(PackageDefinition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Package Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Package Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePackageStatement(PackageStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Import</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Import</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseImport(Import object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Fork Definition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Fork Definition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseForkDefinition(ForkDefinition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Fork Parameter</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Fork Parameter</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseForkParameter(ForkParameter object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Variant Definition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Variant Definition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVariantDefinition(VariantDefinition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Test Definition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Test Definition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTestDefinition(TestDefinition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Call Definition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Call Definition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCallDefinition(CallDefinition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Suite Definition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Suite Definition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSuiteDefinition(SuiteDefinition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Suite Statement</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Suite Statement</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSuiteStatement(SuiteStatement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Suite Statement With Result</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Suite Statement With Result</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSuiteStatementWithResult(SuiteStatementWithResult object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Variable Definition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Variable Definition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVariableDefinition(VariableDefinition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Constant Definition</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Constant Definition</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConstantDefinition(ConstantDefinition object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Variant Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Variant Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVariantValue(VariantValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Variable Entity</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Variable Entity</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVariableEntity(VariableEntity object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Test</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Test</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTest(Test object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Table Test</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Table Test</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTableTest(TableTest object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Table Test Row</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Table Test Row</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTableTestRow(TableTestRow object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Parameter Table Header</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Parameter Table Header</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseParameterTableHeader(ParameterTableHeader object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Result Table Header</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Result Table Header</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseResultTableHeader(ResultTableHeader object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Parameter Table Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Parameter Table Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseParameterTableValue(ParameterTableValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Named Result</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Named Result</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNamedResult(NamedResult object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Result Name</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Result Name</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseResultName(ResultName object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Fixed Result Name</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Fixed Result Name</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFixedResultName(FixedResultName object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Call</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Call</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCall(Call object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Named Call Result</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Named Call Result</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNamedCallResult(NamedCallResult object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Suite</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Suite</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSuite(Suite object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Suite Parameter</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Suite Parameter</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSuiteParameter(SuiteParameter object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Parameter</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Parameter</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseParameter(Parameter object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Parameter Name</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Parameter Name</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseParameterName(ParameterName object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Fixed Parameter Name</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Fixed Parameter Name</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseFixedParameterName(FixedParameterName object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Arbitrary Parameter Or Result Name</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Arbitrary Parameter Or Result Name</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseArbitraryParameterOrResultName(ArbitraryParameterOrResultName object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Value Or Enum Value Collection</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Value Or Enum Value Collection</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseValueOrEnumValueCollection(ValueOrEnumValueCollection object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Value Or Enum Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Value Or Enum Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseValueOrEnumValue(ValueOrEnumValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseValue(Value object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Static Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Static Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStaticValue(StaticValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Integer Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Integer Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIntegerValue(IntegerValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Decimal Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Decimal Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDecimalValue(DecimalValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>String Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>String Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStringValue(StringValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Boolean Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Boolean Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBooleanValue(BooleanValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Variable</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Variable</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseVariable(Variable object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Null Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Null Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNullValue(NullValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Enum Value</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Enum Value</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEnumValue(EnumValue object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Java Class Reference</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Java Class Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseJavaClassReference(JavaClassReference object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Method Reference</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Method Reference</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMethodReference(MethodReference object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Execution Multiplier</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Execution Multiplier</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExecutionMultiplier(ExecutionMultiplier object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Null</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Null</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNull(Null object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //DslSwitch
