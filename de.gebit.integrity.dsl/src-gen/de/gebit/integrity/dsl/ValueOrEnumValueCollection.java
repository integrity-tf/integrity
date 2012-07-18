/**
 */
package de.gebit.integrity.dsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Value Or Enum Value Collection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.ValueOrEnumValueCollection#getValue <em>Value</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.ValueOrEnumValueCollection#getMoreValues <em>More Values</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.gebit.integrity.dsl.DslPackage#getValueOrEnumValueCollection()
 * @model
 * @generated
 */
public interface ValueOrEnumValueCollection extends EObject
{
  /**
   * Returns the value of the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' containment reference.
   * @see #setValue(ValueOrEnumValue)
   * @see de.gebit.integrity.dsl.DslPackage#getValueOrEnumValueCollection_Value()
   * @model containment="true"
   * @generated
   */
  ValueOrEnumValue getValue();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.ValueOrEnumValueCollection#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(ValueOrEnumValue value);

  /**
   * Returns the value of the '<em><b>More Values</b></em>' containment reference list.
   * The list contents are of type {@link de.gebit.integrity.dsl.ValueOrEnumValue}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>More Values</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>More Values</em>' containment reference list.
   * @see de.gebit.integrity.dsl.DslPackage#getValueOrEnumValueCollection_MoreValues()
   * @model containment="true"
   * @generated
   */
  EList<ValueOrEnumValue> getMoreValues();

} // ValueOrEnumValueCollection
