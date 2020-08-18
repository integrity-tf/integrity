/**
 */
package de.gebit.integrity.dsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter Table Header</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.ParameterTableHeader#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see de.gebit.integrity.dsl.DslPackage#getParameterTableHeader()
 * @model
 * @generated
 */
public interface ParameterTableHeader extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' containment reference.
   * @see #setName(ParameterName)
   * @see de.gebit.integrity.dsl.DslPackage#getParameterTableHeader_Name()
   * @model containment="true"
   * @generated
   */
  ParameterName getName();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.ParameterTableHeader#getName <em>Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' containment reference.
   * @see #getName()
   * @generated
   */
  void setName(ParameterName value);

} // ParameterTableHeader
