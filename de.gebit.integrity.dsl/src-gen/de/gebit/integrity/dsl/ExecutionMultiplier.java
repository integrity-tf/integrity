/**
 */
package de.gebit.integrity.dsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Execution Multiplier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.ExecutionMultiplier#getCount <em>Count</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.gebit.integrity.dsl.DslPackage#getExecutionMultiplier()
 * @model
 * @generated
 */
public interface ExecutionMultiplier extends EObject
{
  /**
   * Returns the value of the '<em><b>Count</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Count</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Count</em>' containment reference.
   * @see #setCount(ConstantValue)
   * @see de.gebit.integrity.dsl.DslPackage#getExecutionMultiplier_Count()
   * @model containment="true"
   * @generated
   */
  ConstantValue getCount();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.ExecutionMultiplier#getCount <em>Count</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Count</em>' containment reference.
   * @see #getCount()
   * @generated
   */
  void setCount(ConstantValue value);

} // ExecutionMultiplier
