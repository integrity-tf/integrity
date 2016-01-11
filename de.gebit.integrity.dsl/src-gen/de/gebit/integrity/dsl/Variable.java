/**
 */
package de.gebit.integrity.dsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.Variable#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see de.gebit.integrity.dsl.DslPackage#getVariable()
 * @model
 * @generated
 */
public interface Variable extends Value
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' reference.
   * @see #setName(VariableOrConstantEntity)
   * @see de.gebit.integrity.dsl.DslPackage#getVariable_Name()
   * @model
   * @generated
   */
  VariableOrConstantEntity getName();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.Variable#getName <em>Name</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' reference.
   * @see #getName()
   * @generated
   */
  void setName(VariableOrConstantEntity value);

} // Variable
