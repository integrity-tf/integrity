/**
 */
package de.gebit.integrity.dsl;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Java Constant Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.JavaConstantReference#getType <em>Type</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.JavaConstantReference#getConstant <em>Constant</em>}</li>
 * </ul>
 *
 * @see de.gebit.integrity.dsl.DslPackage#getJavaConstantReference()
 * @model
 * @generated
 */
public interface JavaConstantReference extends EObject
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' reference.
   * @see #setType(JvmType)
   * @see de.gebit.integrity.dsl.DslPackage#getJavaConstantReference_Type()
   * @model
   * @generated
   */
  JvmType getType();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.JavaConstantReference#getType <em>Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' reference.
   * @see #getType()
   * @generated
   */
  void setType(JvmType value);

  /**
   * Returns the value of the '<em><b>Constant</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Constant</em>' reference.
   * @see #setConstant(JvmField)
   * @see de.gebit.integrity.dsl.DslPackage#getJavaConstantReference_Constant()
   * @model
   * @generated
   */
  JvmField getConstant();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.JavaConstantReference#getConstant <em>Constant</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Constant</em>' reference.
   * @see #getConstant()
   * @generated
   */
  void setConstant(JvmField value);

} // JavaConstantReference
