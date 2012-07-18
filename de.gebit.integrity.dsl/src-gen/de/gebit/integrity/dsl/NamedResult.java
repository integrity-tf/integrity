/**
 */
package de.gebit.integrity.dsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Named Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.NamedResult#getName <em>Name</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.NamedResult#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.gebit.integrity.dsl.DslPackage#getNamedResult()
 * @model
 * @generated
 */
public interface NamedResult extends EObject
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
   * @see #setName(ResultName)
   * @see de.gebit.integrity.dsl.DslPackage#getNamedResult_Name()
   * @model containment="true"
   * @generated
   */
  ResultName getName();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.NamedResult#getName <em>Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' containment reference.
   * @see #getName()
   * @generated
   */
  void setName(ResultName value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' containment reference.
   * @see #setValue(ValueOrEnumValueCollection)
   * @see de.gebit.integrity.dsl.DslPackage#getNamedResult_Value()
   * @model containment="true"
   * @generated
   */
  ValueOrEnumValueCollection getValue();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.NamedResult#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(ValueOrEnumValueCollection value);

} // NamedResult
