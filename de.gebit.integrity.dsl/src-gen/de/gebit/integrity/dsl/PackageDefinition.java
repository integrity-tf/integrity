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
 * </p>
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.PackageDefinition#getStatements <em>Statements</em>}</li>
 * </ul>
 *
 * @see de.gebit.integrity.dsl.DslPackage#getPackageDefinition()
 * @model
 * @generated
 */
public interface PackageDefinition extends Statement
{
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
