/**
 */
package de.gebit.integrity.dsl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.common.types.JvmType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Java Class Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.JavaClassReference#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.gebit.integrity.dsl.DslPackage#getJavaClassReference()
 * @model
 * @generated
 */
public interface JavaClassReference extends EObject
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' reference.
   * @see #setType(JvmType)
   * @see de.gebit.integrity.dsl.DslPackage#getJavaClassReference_Type()
   * @model
   * @generated
   */
  JvmType getType();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.JavaClassReference#getType <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' reference.
   * @see #getType()
   * @generated
   */
  void setType(JvmType value);

} // JavaClassReference
