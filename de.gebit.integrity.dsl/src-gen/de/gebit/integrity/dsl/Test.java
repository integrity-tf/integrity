/**
 */
package de.gebit.integrity.dsl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Test</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.Test#getDefinition <em>Definition</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.Test#getParameters <em>Parameters</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.Test#getResults <em>Results</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.Test#getResult <em>Result</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.gebit.integrity.dsl.DslPackage#getTest()
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
   * @see de.gebit.integrity.dsl.DslPackage#getTest_Definition()
   * @model
   * @generated
   */
  TestDefinition getDefinition();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.Test#getDefinition <em>Definition</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Definition</em>' reference.
   * @see #getDefinition()
   * @generated
   */
  void setDefinition(TestDefinition value);

  /**
   * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
   * The list contents are of type {@link de.gebit.integrity.dsl.Parameter}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameters</em>' containment reference list.
   * @see de.gebit.integrity.dsl.DslPackage#getTest_Parameters()
   * @model containment="true"
   * @generated
   */
  EList<Parameter> getParameters();

  /**
   * Returns the value of the '<em><b>Results</b></em>' containment reference list.
   * The list contents are of type {@link de.gebit.integrity.dsl.NamedResult}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Results</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Results</em>' containment reference list.
   * @see de.gebit.integrity.dsl.DslPackage#getTest_Results()
   * @model containment="true"
   * @generated
   */
  EList<NamedResult> getResults();

  /**
   * Returns the value of the '<em><b>Result</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Result</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Result</em>' containment reference.
   * @see #setResult(ValueOrEnumValueCollection)
   * @see de.gebit.integrity.dsl.DslPackage#getTest_Result()
   * @model containment="true"
   * @generated
   */
  ValueOrEnumValueCollection getResult();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.Test#getResult <em>Result</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Result</em>' containment reference.
   * @see #getResult()
   * @generated
   */
  void setResult(ValueOrEnumValueCollection value);

} // Test
