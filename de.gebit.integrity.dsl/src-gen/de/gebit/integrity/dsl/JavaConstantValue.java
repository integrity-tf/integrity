/**
 */
package de.gebit.integrity.dsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Java Constant Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.JavaConstantValue#getConstant <em>Constant</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.gebit.integrity.dsl.DslPackage#getJavaConstantValue()
 * @model
 * @generated
 */
public interface JavaConstantValue extends StaticValue
{
  /**
   * Returns the value of the '<em><b>Constant</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Constant</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Constant</em>' containment reference.
   * @see #setConstant(JavaConstantReference)
   * @see de.gebit.integrity.dsl.DslPackage#getJavaConstantValue_Constant()
   * @model containment="true"
   * @generated
   */
  JavaConstantReference getConstant();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.JavaConstantValue#getConstant <em>Constant</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Constant</em>' containment reference.
   * @see #getConstant()
   * @generated
   */
  void setConstant(JavaConstantReference value);

} // JavaConstantValue
