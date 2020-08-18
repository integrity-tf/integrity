/**
 */
package de.gebit.integrity.dsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Suite Return</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.SuiteReturn#getName <em>Name</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.SuiteReturn#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see de.gebit.integrity.dsl.DslPackage#getSuiteReturn()
 * @model
 * @generated
 */
public interface SuiteReturn extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' reference.
   * @see #setName(SuiteReturnDefinition)
   * @see de.gebit.integrity.dsl.DslPackage#getSuiteReturn_Name()
   * @model
   * @generated
   */
  SuiteReturnDefinition getName();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.SuiteReturn#getName <em>Name</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' reference.
   * @see #getName()
   * @generated
   */
  void setName(SuiteReturnDefinition value);

  /**
   * Returns the value of the '<em><b>Target</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target</em>' containment reference.
   * @see #setTarget(VariableVariable)
   * @see de.gebit.integrity.dsl.DslPackage#getSuiteReturn_Target()
   * @model containment="true"
   * @generated
   */
  VariableVariable getTarget();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.SuiteReturn#getTarget <em>Target</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' containment reference.
   * @see #getTarget()
   * @generated
   */
  void setTarget(VariableVariable value);

} // SuiteReturn
