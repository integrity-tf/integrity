/**
 * <copyright>
 * </copyright>
 *

 */
package de.integrity.dsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Table Test Row</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.integrity.dsl.TableTestRow#getValues <em>Values</em>}</li>
 *   <li>{@link de.integrity.dsl.TableTestRow#getResult <em>Result</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.integrity.dsl.DslPackage#getTableTestRow()
 * @model
 * @generated
 */
public interface TableTestRow extends EObject
{
  /**
   * Returns the value of the '<em><b>Values</b></em>' containment reference list.
   * The list contents are of type {@link de.integrity.dsl.ParameterTableValue}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Values</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Values</em>' containment reference list.
   * @see de.integrity.dsl.DslPackage#getTableTestRow_Values()
   * @model containment="true"
   * @generated
   */
  EList<ParameterTableValue> getValues();

  /**
   * Returns the value of the '<em><b>Result</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Result</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Result</em>' containment reference.
   * @see #setResult(ValueOrEnumValue)
   * @see de.integrity.dsl.DslPackage#getTableTestRow_Result()
   * @model containment="true"
   * @generated
   */
  ValueOrEnumValue getResult();

  /**
   * Sets the value of the '{@link de.integrity.dsl.TableTestRow#getResult <em>Result</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Result</em>' containment reference.
   * @see #getResult()
   * @generated
   */
  void setResult(ValueOrEnumValue value);

} // TableTestRow
