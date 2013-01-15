/**
 * <copyright>
 * </copyright>
 *

 */
package de.gebit.integrity.dsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fork Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.ForkParameter#getName <em>Name</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.ForkParameter#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.gebit.integrity.dsl.DslPackage#getForkParameter()
 * @model
 * @generated
 */
public interface ForkParameter extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' containment reference.
   * @see #setName(FixedParameterName)
   * @see de.gebit.integrity.dsl.DslPackage#getForkParameter_Name()
   * @model containment="true"
   * @generated
   */
  FixedParameterName getName();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.ForkParameter#getName <em>Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' containment reference.
   * @see #getName()
   * @generated
   */
  void setName(FixedParameterName value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' containment reference.
   * @see #setValue(ValueOrEnumValueOrOperation)
   * @see de.gebit.integrity.dsl.DslPackage#getForkParameter_Value()
   * @model containment="true"
   * @generated
   */
  ValueOrEnumValueOrOperation getValue();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.ForkParameter#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(ValueOrEnumValueOrOperation value);

} // ForkParameter
