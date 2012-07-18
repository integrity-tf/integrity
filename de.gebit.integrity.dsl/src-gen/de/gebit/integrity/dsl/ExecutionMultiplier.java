/**
 */
package de.gebit.integrity.dsl;

import java.math.BigInteger;

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
   * Returns the value of the '<em><b>Count</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Count</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Count</em>' attribute.
   * @see #setCount(BigInteger)
   * @see de.gebit.integrity.dsl.DslPackage#getExecutionMultiplier_Count()
   * @model
   * @generated
   */
  BigInteger getCount();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.ExecutionMultiplier#getCount <em>Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Count</em>' attribute.
   * @see #getCount()
   * @generated
   */
  void setCount(BigInteger value);

} // ExecutionMultiplier
