/**
 */
package de.gebit.integrity.dsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Suite Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.SuiteParameter#getName <em>Name</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.SuiteParameter#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see de.gebit.integrity.dsl.DslPackage#getSuiteParameter()
 * @model
 * @generated
 */
public interface SuiteParameter extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' reference.
   * @see #setName(VariableOrConstantEntity)
   * @see de.gebit.integrity.dsl.DslPackage#getSuiteParameter_Name()
   * @model
   * @generated
   */
  VariableOrConstantEntity getName();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.SuiteParameter#getName <em>Name</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' reference.
   * @see #getName()
   * @generated
   */
  void setName(VariableOrConstantEntity value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' containment reference.
   * @see #setValue(ValueOrEnumValueOrOperationCollection)
   * @see de.gebit.integrity.dsl.DslPackage#getSuiteParameter_Value()
   * @model containment="true"
   * @generated
   */
  ValueOrEnumValueOrOperationCollection getValue();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.SuiteParameter#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(ValueOrEnumValueOrOperationCollection value);

} // SuiteParameter
