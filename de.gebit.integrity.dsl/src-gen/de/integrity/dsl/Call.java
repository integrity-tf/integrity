/**
 * <copyright>
 * </copyright>
 *

 */
package de.integrity.dsl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.integrity.dsl.Call#getDefinition <em>Definition</em>}</li>
 *   <li>{@link de.integrity.dsl.Call#getParameters <em>Parameters</em>}</li>
 *   <li>{@link de.integrity.dsl.Call#getResult <em>Result</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.integrity.dsl.DslPackage#getCall()
 * @model
 * @generated
 */
public interface Call extends SuiteStatement
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
   * @see #setDefinition(CallDefinition)
   * @see de.integrity.dsl.DslPackage#getCall_Definition()
   * @model
   * @generated
   */
  CallDefinition getDefinition();

  /**
   * Sets the value of the '{@link de.integrity.dsl.Call#getDefinition <em>Definition</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Definition</em>' reference.
   * @see #getDefinition()
   * @generated
   */
  void setDefinition(CallDefinition value);

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
   * @see de.integrity.dsl.DslPackage#getCall_Parameters()
   * @model containment="true"
   * @generated
   */
  EList<Parameter> getParameters();

  /**
   * Returns the value of the '<em><b>Result</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Result</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Result</em>' containment reference.
   * @see #setResult(Variable)
   * @see de.integrity.dsl.DslPackage#getCall_Result()
   * @model containment="true"
   * @generated
   */
  Variable getResult();

  /**
   * Sets the value of the '{@link de.integrity.dsl.Call#getResult <em>Result</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Result</em>' containment reference.
   * @see #getResult()
   * @generated
   */
  void setResult(Variable value);

} // Call
