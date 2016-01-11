/**
 */
package de.gebit.integrity.dsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.OperationDefinition#getName <em>Name</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.OperationDefinition#getOperationType <em>Operation Type</em>}</li>
 * </ul>
 *
 * @see de.gebit.integrity.dsl.DslPackage#getOperationDefinition()
 * @model
 * @generated
 */
public interface OperationDefinition extends PackageStatement
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
   * @see de.gebit.integrity.dsl.DslPackage#getOperationDefinition_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.OperationDefinition#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Operation Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Operation Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Operation Type</em>' containment reference.
   * @see #setOperationType(JavaClassReference)
   * @see de.gebit.integrity.dsl.DslPackage#getOperationDefinition_OperationType()
   * @model containment="true"
   * @generated
   */
  JavaClassReference getOperationType();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.OperationDefinition#getOperationType <em>Operation Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operation Type</em>' containment reference.
   * @see #getOperationType()
   * @generated
   */
  void setOperationType(JavaClassReference value);

} // OperationDefinition
