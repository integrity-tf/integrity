/**
 */
package de.gebit.integrity.dsl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Typed Nested Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.TypedNestedObject#getType <em>Type</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.TypedNestedObject#getNestedObject <em>Nested Object</em>}</li>
 * </ul>
 *
 * @see de.gebit.integrity.dsl.DslPackage#getTypedNestedObject()
 * @model
 * @generated
 */
public interface TypedNestedObject extends Value
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' containment reference.
   * @see #setType(JavaClassReference)
   * @see de.gebit.integrity.dsl.DslPackage#getTypedNestedObject_Type()
   * @model containment="true"
   * @generated
   */
  JavaClassReference getType();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.TypedNestedObject#getType <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' containment reference.
   * @see #getType()
   * @generated
   */
  void setType(JavaClassReference value);

  /**
   * Returns the value of the '<em><b>Nested Object</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Nested Object</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Nested Object</em>' containment reference.
   * @see #setNestedObject(NestedObject)
   * @see de.gebit.integrity.dsl.DslPackage#getTypedNestedObject_NestedObject()
   * @model containment="true"
   * @generated
   */
  NestedObject getNestedObject();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.TypedNestedObject#getNestedObject <em>Nested Object</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Nested Object</em>' containment reference.
   * @see #getNestedObject()
   * @generated
   */
  void setNestedObject(NestedObject value);

} // TypedNestedObject
