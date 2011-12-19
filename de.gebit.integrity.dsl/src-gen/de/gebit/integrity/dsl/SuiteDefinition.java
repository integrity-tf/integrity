/**
 * <copyright>
 * </copyright>
 *

 */
package de.gebit.integrity.dsl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Suite Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.SuiteDefinition#getName <em>Name</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.SuiteDefinition#getParameters <em>Parameters</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.SuiteDefinition#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.SuiteDefinition#getStatements <em>Statements</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.SuiteDefinition#getFinalizers <em>Finalizers</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.gebit.integrity.dsl.DslPackage#getSuiteDefinition()
 * @model
 * @generated
 */
public interface SuiteDefinition extends PackageStatement
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
   * @see de.gebit.integrity.dsl.DslPackage#getSuiteDefinition_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.SuiteDefinition#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
   * The list contents are of type {@link de.gebit.integrity.dsl.VariableEntity}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameters</em>' containment reference list.
   * @see de.gebit.integrity.dsl.DslPackage#getSuiteDefinition_Parameters()
   * @model containment="true"
   * @generated
   */
  EList<VariableEntity> getParameters();

  /**
   * Returns the value of the '<em><b>Dependencies</b></em>' reference list.
   * The list contents are of type {@link de.gebit.integrity.dsl.SuiteDefinition}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Dependencies</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Dependencies</em>' reference list.
   * @see de.gebit.integrity.dsl.DslPackage#getSuiteDefinition_Dependencies()
   * @model
   * @generated
   */
  EList<SuiteDefinition> getDependencies();

  /**
   * Returns the value of the '<em><b>Statements</b></em>' containment reference list.
   * The list contents are of type {@link de.gebit.integrity.dsl.SuiteStatement}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Statements</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Statements</em>' containment reference list.
   * @see de.gebit.integrity.dsl.DslPackage#getSuiteDefinition_Statements()
   * @model containment="true"
   * @generated
   */
  EList<SuiteStatement> getStatements();

  /**
   * Returns the value of the '<em><b>Finalizers</b></em>' reference list.
   * The list contents are of type {@link de.gebit.integrity.dsl.SuiteDefinition}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Finalizers</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Finalizers</em>' reference list.
   * @see de.gebit.integrity.dsl.DslPackage#getSuiteDefinition_Finalizers()
   * @model
   * @generated
   */
  EList<SuiteDefinition> getFinalizers();

} // SuiteDefinition
