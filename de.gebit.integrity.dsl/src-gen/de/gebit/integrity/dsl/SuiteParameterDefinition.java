/**
 */
package de.gebit.integrity.dsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Suite Parameter Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.SuiteParameterDefinition#getName <em>Name</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.SuiteParameterDefinition#getDefault <em>Default</em>}</li>
 * </ul>
 *
 * @see de.gebit.integrity.dsl.DslPackage#getSuiteParameterDefinition()
 * @model
 * @generated
 */
public interface SuiteParameterDefinition extends EObject
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
   * @see #setName(VariableEntity)
   * @see de.gebit.integrity.dsl.DslPackage#getSuiteParameterDefinition_Name()
   * @model containment="true"
   * @generated
   */
  VariableEntity getName();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.SuiteParameterDefinition#getName <em>Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' containment reference.
   * @see #getName()
   * @generated
   */
  void setName(VariableEntity value);

  /**
   * Returns the value of the '<em><b>Default</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Default</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Default</em>' containment reference.
   * @see #setDefault(ValueOrEnumValueOrOperationCollection)
   * @see de.gebit.integrity.dsl.DslPackage#getSuiteParameterDefinition_Default()
   * @model containment="true"
   * @generated
   */
  ValueOrEnumValueOrOperationCollection getDefault();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.SuiteParameterDefinition#getDefault <em>Default</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Default</em>' containment reference.
   * @see #getDefault()
   * @generated
   */
  void setDefault(ValueOrEnumValueOrOperationCollection value);

} // SuiteParameterDefinition
