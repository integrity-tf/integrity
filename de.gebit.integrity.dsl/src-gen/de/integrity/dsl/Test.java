/**
 * <copyright>
 * </copyright>
 *

 */
package de.integrity.dsl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Test</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.integrity.dsl.Test#getDefinition <em>Definition</em>}</li>
 *   <li>{@link de.integrity.dsl.Test#getParameters <em>Parameters</em>}</li>
 *   <li>{@link de.integrity.dsl.Test#getResults <em>Results</em>}</li>
 *   <li>{@link de.integrity.dsl.Test#getResult <em>Result</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.integrity.dsl.DslPackage#getTest()
 * @model
 * @generated
 */
public interface Test extends SuiteStatementWithResult
{
  /**
   * Returns the value of the '<em><b>Definition</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Definition</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Definition</em>' reference.
   * @see #setDefinition(TestDefinition)
   * @see de.integrity.dsl.DslPackage#getTest_Definition()
   * @model
   * @generated
   */
  TestDefinition getDefinition();

  /**
   * Sets the value of the '{@link de.integrity.dsl.Test#getDefinition <em>Definition</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Definition</em>' reference.
   * @see #getDefinition()
   * @generated
   */
  void setDefinition(TestDefinition value);

  /**
   * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
   * The list contents are of type {@link de.integrity.dsl.Parameter}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameters</em>' containment reference list.
   * @see de.integrity.dsl.DslPackage#getTest_Parameters()
   * @model containment="true"
   * @generated
   */
  EList<Parameter> getParameters();

  /**
   * Returns the value of the '<em><b>Results</b></em>' containment reference list.
   * The list contents are of type {@link de.integrity.dsl.NamedTestResult}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Results</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Results</em>' containment reference list.
   * @see de.integrity.dsl.DslPackage#getTest_Results()
   * @model containment="true"
   * @generated
   */
  EList<NamedTestResult> getResults();

  /**
   * Returns the value of the '<em><b>Result</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Result</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Result</em>' containment reference.
   * @see #setResult(ValueOrEnumValue)
   * @see de.integrity.dsl.DslPackage#getTest_Result()
   * @model containment="true"
   * @generated
   */
  ValueOrEnumValue getResult();

  /**
   * Sets the value of the '{@link de.integrity.dsl.Test#getResult <em>Result</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Result</em>' containment reference.
   * @see #getResult()
   * @generated
   */
  void setResult(ValueOrEnumValue value);

} // Test
