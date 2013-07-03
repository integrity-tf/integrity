/**
 * <copyright>
 * </copyright>
 *

 */
package de.gebit.integrity.dsl;

import java.math.BigInteger;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Integer Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.IntegerValue#getIntegerValue <em>Integer Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.gebit.integrity.dsl.DslPackage#getIntegerValue()
 * @model
 * @generated
 */
public interface IntegerValue extends StaticValue
{
  /**
   * Returns the value of the '<em><b>Integer Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Integer Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Integer Value</em>' attribute.
   * @see #setIntegerValue(BigInteger)
   * @see de.gebit.integrity.dsl.DslPackage#getIntegerValue_IntegerValue()
   * @model
   * @generated
   */
  BigInteger getIntegerValue();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.IntegerValue#getIntegerValue <em>Integer Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Integer Value</em>' attribute.
   * @see #getIntegerValue()
   * @generated
   */
  void setIntegerValue(BigInteger value);

} // IntegerValue
