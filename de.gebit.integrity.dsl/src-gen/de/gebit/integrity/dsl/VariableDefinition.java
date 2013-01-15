/**
 */
package de.gebit.integrity.dsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.VariableDefinition#getName <em>Name</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.VariableDefinition#getInitialValue <em>Initial Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.gebit.integrity.dsl.DslPackage#getVariableDefinition()
 * @model
 * @generated
 */
public interface VariableDefinition extends PackageStatement, SuiteStatement
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
   * @see de.gebit.integrity.dsl.DslPackage#getVariableDefinition_Name()
   * @model containment="true"
   * @generated
   */
  VariableEntity getName();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.VariableDefinition#getName <em>Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' containment reference.
   * @see #getName()
   * @generated
   */
  void setName(VariableEntity value);

  /**
   * Returns the value of the '<em><b>Initial Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Initial Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Initial Value</em>' containment reference.
   * @see #setInitialValue(ValueOrEnumValueOrOperation)
   * @see de.gebit.integrity.dsl.DslPackage#getVariableDefinition_InitialValue()
   * @model containment="true"
   * @generated
   */
  ValueOrEnumValueOrOperation getInitialValue();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.VariableDefinition#getInitialValue <em>Initial Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Initial Value</em>' containment reference.
   * @see #getInitialValue()
   * @generated
   */
  void setInitialValue(ValueOrEnumValueOrOperation value);

} // VariableDefinition
