/**
 */
package de.gebit.integrity.dsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Key Value Pair</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.KeyValuePair#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.KeyValuePair#getStringIdentifier <em>String Identifier</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.KeyValuePair#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see de.gebit.integrity.dsl.DslPackage#getKeyValuePair()
 * @model
 * @generated
 */
public interface KeyValuePair extends EObject
{
  /**
   * Returns the value of the '<em><b>Identifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Identifier</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Identifier</em>' attribute.
   * @see #setIdentifier(String)
   * @see de.gebit.integrity.dsl.DslPackage#getKeyValuePair_Identifier()
   * @model
   * @generated
   */
  String getIdentifier();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.KeyValuePair#getIdentifier <em>Identifier</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Identifier</em>' attribute.
   * @see #getIdentifier()
   * @generated
   */
  void setIdentifier(String value);

  /**
   * Returns the value of the '<em><b>String Identifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>String Identifier</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>String Identifier</em>' attribute.
   * @see #setStringIdentifier(String)
   * @see de.gebit.integrity.dsl.DslPackage#getKeyValuePair_StringIdentifier()
   * @model
   * @generated
   */
  String getStringIdentifier();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.KeyValuePair#getStringIdentifier <em>String Identifier</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>String Identifier</em>' attribute.
   * @see #getStringIdentifier()
   * @generated
   */
  void setStringIdentifier(String value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' containment reference.
   * @see #setValue(ValueOrEnumValueOrOperationCollection)
   * @see de.gebit.integrity.dsl.DslPackage#getKeyValuePair_Value()
   * @model containment="true"
   * @generated
   */
  ValueOrEnumValueOrOperationCollection getValue();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.KeyValuePair#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(ValueOrEnumValueOrOperationCollection value);

} // KeyValuePair
