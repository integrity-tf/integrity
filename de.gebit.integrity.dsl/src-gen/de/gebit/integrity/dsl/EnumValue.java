/**
 */
package de.gebit.integrity.dsl;

import org.eclipse.xtext.common.types.JvmEnumerationLiteral;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enum Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.EnumValue#getEnumValue <em>Enum Value</em>}</li>
 * </ul>
 *
 * @see de.gebit.integrity.dsl.DslPackage#getEnumValue()
 * @model
 * @generated
 */
public interface EnumValue extends ValueOrEnumValueOrOperation
{
  /**
   * Returns the value of the '<em><b>Enum Value</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Enum Value</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Enum Value</em>' reference.
   * @see #setEnumValue(JvmEnumerationLiteral)
   * @see de.gebit.integrity.dsl.DslPackage#getEnumValue_EnumValue()
   * @model
   * @generated
   */
  JvmEnumerationLiteral getEnumValue();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.EnumValue#getEnumValue <em>Enum Value</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Enum Value</em>' reference.
   * @see #getEnumValue()
   * @generated
   */
  void setEnumValue(JvmEnumerationLiteral value);

} // EnumValue
