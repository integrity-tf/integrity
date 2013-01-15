/**
 * <copyright>
 * </copyright>
 *

 */
package de.gebit.integrity.dsl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Standard Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.StandardOperation#getFirstOperand <em>First Operand</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.StandardOperation#getOperators <em>Operators</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.StandardOperation#getMoreOperands <em>More Operands</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.gebit.integrity.dsl.DslPackage#getStandardOperation()
 * @model
 * @generated
 */
public interface StandardOperation extends Operation
{
  /**
   * Returns the value of the '<em><b>First Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>First Operand</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>First Operand</em>' containment reference.
   * @see #setFirstOperand(ValueOrEnumValueOrOperation)
   * @see de.gebit.integrity.dsl.DslPackage#getStandardOperation_FirstOperand()
   * @model containment="true"
   * @generated
   */
  ValueOrEnumValueOrOperation getFirstOperand();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.StandardOperation#getFirstOperand <em>First Operand</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>First Operand</em>' containment reference.
   * @see #getFirstOperand()
   * @generated
   */
  void setFirstOperand(ValueOrEnumValueOrOperation value);

  /**
   * Returns the value of the '<em><b>Operators</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operators</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operators</em>' attribute list.
   * @see de.gebit.integrity.dsl.DslPackage#getStandardOperation_Operators()
   * @model unique="false"
   * @generated
   */
  EList<String> getOperators();

  /**
   * Returns the value of the '<em><b>More Operands</b></em>' containment reference list.
   * The list contents are of type {@link de.gebit.integrity.dsl.ValueOrEnumValueOrOperation}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>More Operands</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>More Operands</em>' containment reference list.
   * @see de.gebit.integrity.dsl.DslPackage#getStandardOperation_MoreOperands()
   * @model containment="true"
   * @generated
   */
  EList<ValueOrEnumValueOrOperation> getMoreOperands();

} // StandardOperation
