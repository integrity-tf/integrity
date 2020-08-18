/**
 */
package de.gebit.integrity.dsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Custom Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.CustomOperation#getPrefixOperand <em>Prefix Operand</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.CustomOperation#getDefinition <em>Definition</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.CustomOperation#getPostfixOperand <em>Postfix Operand</em>}</li>
 * </ul>
 *
 * @see de.gebit.integrity.dsl.DslPackage#getCustomOperation()
 * @model
 * @generated
 */
public interface CustomOperation extends Operation
{
  /**
   * Returns the value of the '<em><b>Prefix Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Prefix Operand</em>' containment reference.
   * @see #setPrefixOperand(ValueOrEnumValueOrOperationCollection)
   * @see de.gebit.integrity.dsl.DslPackage#getCustomOperation_PrefixOperand()
   * @model containment="true"
   * @generated
   */
  ValueOrEnumValueOrOperationCollection getPrefixOperand();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.CustomOperation#getPrefixOperand <em>Prefix Operand</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Prefix Operand</em>' containment reference.
   * @see #getPrefixOperand()
   * @generated
   */
  void setPrefixOperand(ValueOrEnumValueOrOperationCollection value);

  /**
   * Returns the value of the '<em><b>Definition</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Definition</em>' reference.
   * @see #setDefinition(OperationDefinition)
   * @see de.gebit.integrity.dsl.DslPackage#getCustomOperation_Definition()
   * @model
   * @generated
   */
  OperationDefinition getDefinition();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.CustomOperation#getDefinition <em>Definition</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Definition</em>' reference.
   * @see #getDefinition()
   * @generated
   */
  void setDefinition(OperationDefinition value);

  /**
   * Returns the value of the '<em><b>Postfix Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Postfix Operand</em>' containment reference.
   * @see #setPostfixOperand(ValueOrEnumValueOrOperationCollection)
   * @see de.gebit.integrity.dsl.DslPackage#getCustomOperation_PostfixOperand()
   * @model containment="true"
   * @generated
   */
  ValueOrEnumValueOrOperationCollection getPostfixOperand();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.CustomOperation#getPostfixOperand <em>Postfix Operand</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Postfix Operand</em>' containment reference.
   * @see #getPostfixOperand()
   * @generated
   */
  void setPostfixOperand(ValueOrEnumValueOrOperationCollection value);

} // CustomOperation
