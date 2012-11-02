/**
 * <copyright>
 * </copyright>
 *

 */
package de.gebit.integrity.dsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Iso Date Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.IsoDateValue#getDateValue <em>Date Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.gebit.integrity.dsl.DslPackage#getIsoDateValue()
 * @model
 * @generated
 */
public interface IsoDateValue extends DateValue
{
  /**
   * Returns the value of the '<em><b>Date Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Date Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Date Value</em>' attribute.
   * @see #setDateValue(String)
   * @see de.gebit.integrity.dsl.DslPackage#getIsoDateValue_DateValue()
   * @model
   * @generated
   */
  String getDateValue();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.IsoDateValue#getDateValue <em>Date Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Date Value</em>' attribute.
   * @see #getDateValue()
   * @generated
   */
  void setDateValue(String value);

} // IsoDateValue
