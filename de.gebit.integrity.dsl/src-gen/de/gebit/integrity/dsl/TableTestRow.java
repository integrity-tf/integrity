/**
 */
package de.gebit.integrity.dsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Table Test Row</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.TableTestRow#getValues <em>Values</em>}</li>
 * </ul>
 *
 * @see de.gebit.integrity.dsl.DslPackage#getTableTestRow()
 * @model
 * @generated
 */
public interface TableTestRow extends EObject
{
  /**
   * Returns the value of the '<em><b>Values</b></em>' containment reference list.
   * The list contents are of type {@link de.gebit.integrity.dsl.ParameterTableValue}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Values</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Values</em>' containment reference list.
   * @see de.gebit.integrity.dsl.DslPackage#getTableTestRow_Values()
   * @model containment="true"
   * @generated
   */
  EList<ParameterTableValue> getValues();

} // TableTestRow
