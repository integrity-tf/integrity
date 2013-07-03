/**
 */
package de.gebit.integrity.dsl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Package Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.PackageDefinition#getName <em>Name</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.PackageDefinition#getStatements <em>Statements</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.gebit.integrity.dsl.DslPackage#getPackageDefinition()
 * @model
 * @generated
 */
public interface PackageDefinition extends Statement
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see de.gebit.integrity.dsl.DslPackage#getPackageDefinition_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.PackageDefinition#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Statements</b></em>' containment reference list.
   * The list contents are of type {@link de.gebit.integrity.dsl.PackageStatement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Statements</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Statements</em>' containment reference list.
   * @see de.gebit.integrity.dsl.DslPackage#getPackageDefinition_Statements()
   * @model containment="true"
   * @generated
   */
  EList<PackageStatement> getStatements();

} // PackageDefinition
