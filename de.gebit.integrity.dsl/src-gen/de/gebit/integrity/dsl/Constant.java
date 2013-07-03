/**
 */
package de.gebit.integrity.dsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constant</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.Constant#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.gebit.integrity.dsl.DslPackage#getConstant()
 * @model
 * @generated
 */
public interface Constant extends ConstantValue
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
   * @see #setName(ConstantEntity)
   * @see de.gebit.integrity.dsl.DslPackage#getConstant_Name()
   * @model
   * @generated
   */
  ConstantEntity getName();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.Constant#getName <em>Name</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' reference.
   * @see #getName()
   * @generated
   */
  void setName(ConstantEntity value);

} // Constant
