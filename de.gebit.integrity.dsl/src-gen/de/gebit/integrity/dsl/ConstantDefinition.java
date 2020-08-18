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
 * </p>
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.ConstantDefinition#getDocumentation <em>Documentation</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.ConstantDefinition#getPrivate <em>Private</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.ConstantDefinition#getName <em>Name</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.ConstantDefinition#getValue <em>Value</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.ConstantDefinition#getVariantValues <em>Variant Values</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.ConstantDefinition#getParameterized <em>Parameterized</em>}</li>
 * </ul>
 *
 * @see de.gebit.integrity.dsl.DslPackage#getConstantDefinition()
 * @model
 * @generated
 */
public interface ConstantDefinition extends PackageStatement, SuiteStatement
{
  /**
   * Returns the value of the '<em><b>Documentation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Documentation</em>' containment reference.
   * @see #setDocumentation(DocumentationComment)
   * @see de.gebit.integrity.dsl.DslPackage#getConstantDefinition_Documentation()
   * @model containment="true"
   * @generated
   */
  DocumentationComment getDocumentation();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.ConstantDefinition#getDocumentation <em>Documentation</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Documentation</em>' containment reference.
   * @see #getDocumentation()
   * @generated
   */
  void setDocumentation(DocumentationComment value);

  /**
   * Returns the value of the '<em><b>Private</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Private</em>' attribute.
   * @see #setPrivate(String)
   * @see de.gebit.integrity.dsl.DslPackage#getConstantDefinition_Private()
   * @model
   * @generated
   */
  String getPrivate();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.ConstantDefinition#getPrivate <em>Private</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Private</em>' attribute.
   * @see #getPrivate()
   * @generated
   */
  void setPrivate(String value);

  /**
   * Returns the value of the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' containment reference.
   * @see #setName(ConstantEntity)
   * @see de.gebit.integrity.dsl.DslPackage#getConstantDefinition_Name()
   * @model containment="true"
   * @generated
   */
  ConstantEntity getName();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.ConstantDefinition#getName <em>Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' containment reference.
   * @see #getName()
   * @generated
   */
  void setName(ConstantEntity value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' containment reference.
   * @see #setValue(ValueOrEnumValueOrOperationCollection)
   * @see de.gebit.integrity.dsl.DslPackage#getConstantDefinition_Value()
   * @model containment="true"
   * @generated
   */
  ValueOrEnumValueOrOperationCollection getValue();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.ConstantDefinition#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(ValueOrEnumValueOrOperationCollection value);

  /**
   * Returns the value of the '<em><b>Variant Values</b></em>' containment reference list.
   * The list contents are of type {@link de.gebit.integrity.dsl.VariantValue}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Variant Values</em>' containment reference list.
   * @see de.gebit.integrity.dsl.DslPackage#getConstantDefinition_VariantValues()
   * @model containment="true"
   * @generated
   */
  EList<VariantValue> getVariantValues();

  /**
   * Returns the value of the '<em><b>Parameterized</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameterized</em>' attribute.
   * @see #setParameterized(String)
   * @see de.gebit.integrity.dsl.DslPackage#getConstantDefinition_Parameterized()
   * @model
   * @generated
   */
  String getParameterized();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.ConstantDefinition#getParameterized <em>Parameterized</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Parameterized</em>' attribute.
   * @see #getParameterized()
   * @generated
   */
  void setParameterized(String value);

} // ConstantDefinition
