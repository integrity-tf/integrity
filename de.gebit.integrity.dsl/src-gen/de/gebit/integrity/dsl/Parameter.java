/**
 */
package de.gebit.integrity.dsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.Parameter#getName <em>Name</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.Parameter#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see de.gebit.integrity.dsl.DslPackage#getParameter()
 * @model
 * @generated
 */
public interface Parameter extends EObject
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
   * @see #setName(ParameterName)
   * @see de.gebit.integrity.dsl.DslPackage#getParameter_Name()
   * @model containment="true"
   * @generated
   */
  ParameterName getName();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.Parameter#getName <em>Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' containment reference.
   * @see #getName()
   * @generated
   */
  void setName(ParameterName value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' containment reference.
   * @see #setValue(ValueOrEnumValueOrOperationCollection)
   * @see de.gebit.integrity.dsl.DslPackage#getParameter_Value()
   * @model containment="true"
   * @generated
   */
  ValueOrEnumValueOrOperationCollection getValue();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.Parameter#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(ValueOrEnumValueOrOperationCollection value);

} // Parameter
