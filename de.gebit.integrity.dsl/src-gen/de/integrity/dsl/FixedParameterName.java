/**
 * <copyright>
 * </copyright>
 *

 */
package de.integrity.dsl;

import org.eclipse.xtext.common.types.JvmAnnotationReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fixed Parameter Name</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.integrity.dsl.FixedParameterName#getAnnotation <em>Annotation</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.integrity.dsl.DslPackage#getFixedParameterName()
 * @model
 * @generated
 */
public interface FixedParameterName extends ParameterName
{
  /**
   * Returns the value of the '<em><b>Annotation</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Annotation</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Annotation</em>' reference.
   * @see #setAnnotation(JvmAnnotationReference)
   * @see de.integrity.dsl.DslPackage#getFixedParameterName_Annotation()
   * @model
   * @generated
   */
  JvmAnnotationReference getAnnotation();

  /**
   * Sets the value of the '{@link de.integrity.dsl.FixedParameterName#getAnnotation <em>Annotation</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Annotation</em>' reference.
   * @see #getAnnotation()
   * @generated
   */
  void setAnnotation(JvmAnnotationReference value);

} // FixedParameterName
