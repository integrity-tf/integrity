/**
 */
package de.gebit.integrity.dsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Named Call Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.NamedCallResult#getName <em>Name</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.NamedCallResult#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see de.gebit.integrity.dsl.DslPackage#getNamedCallResult()
 * @model
 * @generated
 */
public interface NamedCallResult extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' containment reference.
   * @see #setName(ResultName)
   * @see de.gebit.integrity.dsl.DslPackage#getNamedCallResult_Name()
   * @model containment="true"
   * @generated
   */
  ResultName getName();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.NamedCallResult#getName <em>Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' containment reference.
   * @see #getName()
   * @generated
   */
  void setName(ResultName value);

  /**
   * Returns the value of the '<em><b>Target</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target</em>' containment reference.
   * @see #setTarget(VariableVariable)
   * @see de.gebit.integrity.dsl.DslPackage#getNamedCallResult_Target()
   * @model containment="true"
   * @generated
   */
  VariableVariable getTarget();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.NamedCallResult#getTarget <em>Target</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' containment reference.
   * @see #getTarget()
   * @generated
   */
  void setTarget(VariableVariable value);

} // NamedCallResult
