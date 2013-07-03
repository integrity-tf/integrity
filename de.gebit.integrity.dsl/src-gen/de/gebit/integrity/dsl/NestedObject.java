/**
 */
package de.gebit.integrity.dsl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Nested Object</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.NestedObject#getAttributes <em>Attributes</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.gebit.integrity.dsl.DslPackage#getNestedObject()
 * @model
 * @generated
 */
public interface NestedObject extends Value
{
  /**
   * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
   * The list contents are of type {@link de.gebit.integrity.dsl.KeyValuePair}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Attributes</em>' containment reference list.
   * @see de.gebit.integrity.dsl.DslPackage#getNestedObject_Attributes()
   * @model containment="true"
   * @generated
   */
  EList<KeyValuePair> getAttributes();

} // NestedObject
