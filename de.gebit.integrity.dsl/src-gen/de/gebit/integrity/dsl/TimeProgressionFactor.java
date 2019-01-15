/**
 */
package de.gebit.integrity.dsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Time Progression Factor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.TimeProgressionFactor#getFixedValue <em>Fixed Value</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.TimeProgressionFactor#getCalculatedValue <em>Calculated Value</em>}</li>
 * </ul>
 *
 * @see de.gebit.integrity.dsl.DslPackage#getTimeProgressionFactor()
 * @model
 * @generated
 */
public interface TimeProgressionFactor extends EObject
{
  /**
   * Returns the value of the '<em><b>Fixed Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Fixed Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Fixed Value</em>' attribute.
   * @see #setFixedValue(String)
   * @see de.gebit.integrity.dsl.DslPackage#getTimeProgressionFactor_FixedValue()
   * @model
   * @generated
   */
  String getFixedValue();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.TimeProgressionFactor#getFixedValue <em>Fixed Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Fixed Value</em>' attribute.
   * @see #getFixedValue()
   * @generated
   */
  void setFixedValue(String value);

  /**
   * Returns the value of the '<em><b>Calculated Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Calculated Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Calculated Value</em>' containment reference.
   * @see #setCalculatedValue(ValueOrEnumValueOrOperation)
   * @see de.gebit.integrity.dsl.DslPackage#getTimeProgressionFactor_CalculatedValue()
   * @model containment="true"
   * @generated
   */
  ValueOrEnumValueOrOperation getCalculatedValue();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.TimeProgressionFactor#getCalculatedValue <em>Calculated Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Calculated Value</em>' containment reference.
   * @see #getCalculatedValue()
   * @generated
   */
  void setCalculatedValue(ValueOrEnumValueOrOperation value);

} // TimeProgressionFactor
