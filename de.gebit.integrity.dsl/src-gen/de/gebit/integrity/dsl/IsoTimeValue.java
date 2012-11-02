/**
 * <copyright>
 * </copyright>
 *

 */
package de.gebit.integrity.dsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Iso Time Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.IsoTimeValue#getTimeValue <em>Time Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.gebit.integrity.dsl.DslPackage#getIsoTimeValue()
 * @model
 * @generated
 */
public interface IsoTimeValue extends TimeValue
{
  /**
   * Returns the value of the '<em><b>Time Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Time Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Time Value</em>' attribute.
   * @see #setTimeValue(String)
   * @see de.gebit.integrity.dsl.DslPackage#getIsoTimeValue_TimeValue()
   * @model
   * @generated
   */
  String getTimeValue();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.IsoTimeValue#getTimeValue <em>Time Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Time Value</em>' attribute.
   * @see #getTimeValue()
   * @generated
   */
  void setTimeValue(String value);

} // IsoTimeValue
