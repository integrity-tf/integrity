/**
 * <copyright>
 * </copyright>
 *

 */
package de.integrity.dsl;

import org.eclipse.xtext.common.types.JvmField;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fixed Test Result Name</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.integrity.dsl.FixedTestResultName#getField <em>Field</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.integrity.dsl.DslPackage#getFixedTestResultName()
 * @model
 * @generated
 */
public interface FixedTestResultName extends TestResultName
{
  /**
   * Returns the value of the '<em><b>Field</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Field</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Field</em>' reference.
   * @see #setField(JvmField)
   * @see de.integrity.dsl.DslPackage#getFixedTestResultName_Field()
   * @model
   * @generated
   */
  JvmField getField();

  /**
   * Sets the value of the '{@link de.integrity.dsl.FixedTestResultName#getField <em>Field</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Field</em>' reference.
   * @see #getField()
   * @generated
   */
  void setField(JvmField value);

} // FixedTestResultName
