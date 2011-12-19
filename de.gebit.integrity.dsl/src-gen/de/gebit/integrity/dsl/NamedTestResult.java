/**
 * <copyright>
 * </copyright>
 *

 */
package de.gebit.integrity.dsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Named Test Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.NamedTestResult#getName <em>Name</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.NamedTestResult#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.gebit.integrity.dsl.DslPackage#getNamedTestResult()
 * @model
 * @generated
 */
public interface NamedTestResult extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' containment reference.
   * @see #setName(TestResultName)
   * @see de.gebit.integrity.dsl.DslPackage#getNamedTestResult_Name()
   * @model containment="true"
   * @generated
   */
  TestResultName getName();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.NamedTestResult#getName <em>Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' containment reference.
   * @see #getName()
   * @generated
   */
  void setName(TestResultName value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' containment reference.
   * @see #setValue(ValueOrEnumValue)
   * @see de.gebit.integrity.dsl.DslPackage#getNamedTestResult_Value()
   * @model containment="true"
   * @generated
   */
  ValueOrEnumValue getValue();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.NamedTestResult#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(ValueOrEnumValue value);

} // NamedTestResult
