/**
 * <copyright>
 * </copyright>
 *

 */
package de.gebit.integrity.dsl;

import java.math.BigDecimal;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Decimal Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.DecimalValue#getDecimalValue <em>Decimal Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.gebit.integrity.dsl.DslPackage#getDecimalValue()
 * @model
 * @generated
 */
public interface DecimalValue extends Value
{
  /**
   * Returns the value of the '<em><b>Decimal Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Decimal Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Decimal Value</em>' attribute.
   * @see #setDecimalValue(BigDecimal)
   * @see de.gebit.integrity.dsl.DslPackage#getDecimalValue_DecimalValue()
   * @model
   * @generated
   */
  BigDecimal getDecimalValue();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.DecimalValue#getDecimalValue <em>Decimal Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Decimal Value</em>' attribute.
   * @see #getDecimalValue()
   * @generated
   */
  void setDecimalValue(BigDecimal value);

} // DecimalValue
