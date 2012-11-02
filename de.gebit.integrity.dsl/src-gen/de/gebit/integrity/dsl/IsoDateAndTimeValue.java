/**
 * <copyright>
 * </copyright>
 *

 */
package de.gebit.integrity.dsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Iso Date And Time Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.IsoDateAndTimeValue#getDateValue <em>Date Value</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.IsoDateAndTimeValue#getTimeValue <em>Time Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.gebit.integrity.dsl.DslPackage#getIsoDateAndTimeValue()
 * @model
 * @generated
 */
public interface IsoDateAndTimeValue extends DateAndTimeValue
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
   * @see de.gebit.integrity.dsl.DslPackage#getIsoDateAndTimeValue_DateValue()
   * @model
   * @generated
   */
  String getDateValue();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.IsoDateAndTimeValue#getDateValue <em>Date Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Date Value</em>' attribute.
   * @see #getDateValue()
   * @generated
   */
  void setDateValue(String value);

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
   * @see de.gebit.integrity.dsl.DslPackage#getIsoDateAndTimeValue_TimeValue()
   * @model
   * @generated
   */
  String getTimeValue();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.IsoDateAndTimeValue#getTimeValue <em>Time Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Time Value</em>' attribute.
   * @see #getTimeValue()
   * @generated
   */
  void setTimeValue(String value);

} // IsoDateAndTimeValue
