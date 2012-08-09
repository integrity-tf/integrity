/**
 */
package de.gebit.integrity.dsl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constant Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.ConstantDefinition#getName <em>Name</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.ConstantDefinition#getValue <em>Value</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.ConstantDefinition#getVariantValues <em>Variant Values</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.gebit.integrity.dsl.DslPackage#getConstantDefinition()
 * @model
 * @generated
 */
public interface ConstantDefinition extends PackageStatement, SuiteStatement
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
   * @see de.gebit.integrity.dsl.DslPackage#getConstantDefinition_Name()
   * @model containment="true"
   * @generated
   */
  VariableEntity getName();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.ConstantDefinition#getName <em>Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' containment reference.
   * @see #getName()
   * @generated
   */
  void setName(VariableEntity value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' containment reference.
   * @see #setValue(StaticValue)
   * @see de.gebit.integrity.dsl.DslPackage#getConstantDefinition_Value()
   * @model containment="true"
   * @generated
   */
  StaticValue getValue();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.ConstantDefinition#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(StaticValue value);

  /**
   * Returns the value of the '<em><b>Variant Values</b></em>' containment reference list.
   * The list contents are of type {@link de.gebit.integrity.dsl.VariantValue}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Variant Values</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Variant Values</em>' containment reference list.
   * @see de.gebit.integrity.dsl.DslPackage#getConstantDefinition_VariantValues()
   * @model containment="true"
   * @generated
   */
  EList<VariantValue> getVariantValues();

} // ConstantDefinition
