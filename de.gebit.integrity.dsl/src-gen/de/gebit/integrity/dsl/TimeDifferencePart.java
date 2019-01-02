/**
 */
package de.gebit.integrity.dsl;

import java.math.BigInteger;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Time Difference Part</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.TimeDifferencePart#getValue <em>Value</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.TimeDifferencePart#getTemporalUnit <em>Temporal Unit</em>}</li>
 * </ul>
 *
 * @see de.gebit.integrity.dsl.DslPackage#getTimeDifferencePart()
 * @model
 * @generated
 */
public interface TimeDifferencePart extends EObject
{
  /**
   * Returns the value of the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' attribute.
   * @see #setValue(BigInteger)
   * @see de.gebit.integrity.dsl.DslPackage#getTimeDifferencePart_Value()
   * @model
   * @generated
   */
  BigInteger getValue();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.TimeDifferencePart#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see #getValue()
   * @generated
   */
  void setValue(BigInteger value);

  /**
   * Returns the value of the '<em><b>Temporal Unit</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Temporal Unit</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Temporal Unit</em>' attribute.
   * @see #setTemporalUnit(String)
   * @see de.gebit.integrity.dsl.DslPackage#getTimeDifferencePart_TemporalUnit()
   * @model
   * @generated
   */
  String getTemporalUnit();

  /**
   * Sets the value of the '{@link de.gebit.integrity.dsl.TimeDifferencePart#getTemporalUnit <em>Temporal Unit</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Temporal Unit</em>' attribute.
   * @see #getTemporalUnit()
   * @generated
   */
  void setTemporalUnit(String value);

} // TimeDifferencePart
