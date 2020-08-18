/**
 */
package de.gebit.integrity.dsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Assignment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.VariableAssignment#getValue <em>Value</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.VariableAssignment#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @see de.gebit.integrity.dsl.DslPackage#getVariableAssignment()
 * @model
 * @generated
 */
public interface VariableAssignment extends SuiteStatement
{
  /**
   * Returns the value of the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' containment reference.
   * @see #setValue(ValueOrEnumValueOrOperationCollection)
   * @see de.gebit.integrity.dsl.DslPackage#getVariableAssignment_Value()
   * @model containment="true"
   * @generated
   */
  ValueOrEnumValueOrOperationCollection getValue();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.VariableAssignment#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(ValueOrEnumValueOrOperationCollection value);

  /**
   * Returns the value of the '<em><b>Target</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target</em>' containment reference.
   * @see #setTarget(VariableVariable)
   * @see de.gebit.integrity.dsl.DslPackage#getVariableAssignment_Target()
   * @model containment="true"
   * @generated
   */
  VariableVariable getTarget();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.VariableAssignment#getTarget <em>Target</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' containment reference.
   * @see #getTarget()
   * @generated
   */
  void setTarget(VariableVariable value);

} // VariableAssignment
