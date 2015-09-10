/**
 */
package de.gebit.integrity.dsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Date And Time Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.DateAndTimeValue#getDateValue <em>Date Value</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.DateAndTimeValue#getTimeValue <em>Time Value</em>}</li>
 * </ul>
 *
 * @see de.gebit.integrity.dsl.DslPackage#getDateAndTimeValue()
 * @model
 * @generated
 */
public interface DateAndTimeValue extends StaticValue
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
   * @see de.gebit.integrity.dsl.DslPackage#getDateAndTimeValue_DateValue()
   * @model
   * @generated
   */
  String getDateValue();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.DateAndTimeValue#getDateValue <em>Date Value</em>}' attribute.
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
   * @see de.gebit.integrity.dsl.DslPackage#getDateAndTimeValue_TimeValue()
   * @model
   * @generated
   */
  String getTimeValue();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.DateAndTimeValue#getTimeValue <em>Time Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Time Value</em>' attribute.
   * @see #getTimeValue()
   * @generated
   */
  void setTimeValue(String value);

} // DateAndTimeValue
