/**
 * <copyright>
 * </copyright>
 *

 */
package de.gebit.integrity.dsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.Operation#getPrefixOperand <em>Prefix Operand</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.Operation#getDefinition <em>Definition</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.Operation#getPostfixOperand <em>Postfix Operand</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.gebit.integrity.dsl.DslPackage#getOperation()
 * @model
 * @generated
 */
public interface Operation extends OperationOrValueCollection
{
  /**
   * Returns the value of the '<em><b>Prefix Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Prefix Operand</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Prefix Operand</em>' containment reference.
   * @see #setPrefixOperand(OperationOrValueCollection)
   * @see de.gebit.integrity.dsl.DslPackage#getOperation_PrefixOperand()
   * @model containment="true"
   * @generated
   */
  OperationOrValueCollection getPrefixOperand();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.Operation#getPrefixOperand <em>Prefix Operand</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Prefix Operand</em>' containment reference.
   * @see #getPrefixOperand()
   * @generated
   */
  void setPrefixOperand(OperationOrValueCollection value);

  /**
   * Returns the value of the '<em><b>Definition</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Definition</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Definition</em>' reference.
   * @see #setDefinition(OperationDefinition)
   * @see de.gebit.integrity.dsl.DslPackage#getOperation_Definition()
   * @model
   * @generated
   */
  OperationDefinition getDefinition();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.Operation#getDefinition <em>Definition</em>}' reference.
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
   * <p>
   * If the meaning of the '<em>Postfix Operand</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Postfix Operand</em>' containment reference.
   * @see #setPostfixOperand(OperationOrValueCollection)
   * @see de.gebit.integrity.dsl.DslPackage#getOperation_PostfixOperand()
   * @model containment="true"
   * @generated
   */
  OperationOrValueCollection getPostfixOperand();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.Operation#getPostfixOperand <em>Postfix Operand</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Postfix Operand</em>' containment reference.
   * @see #getPostfixOperand()
   * @generated
   */
  void setPostfixOperand(OperationOrValueCollection value);

} // Operation
