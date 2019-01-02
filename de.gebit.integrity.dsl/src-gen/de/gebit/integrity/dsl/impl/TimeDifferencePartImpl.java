/**
 */
package de.gebit.integrity.dsl.impl;

import de.gebit.integrity.dsl.DslPackage;
import de.gebit.integrity.dsl.TimeDifferencePart;

import java.math.BigInteger;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Time Difference Part</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.impl.TimeDifferencePartImpl#getValue <em>Value</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.impl.TimeDifferencePartImpl#getTemporalUnit <em>Temporal Unit</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TimeDifferencePartImpl extends MinimalEObjectImpl.Container implements TimeDifferencePart
{
  /**
   * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected static final BigInteger VALUE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected BigInteger value = VALUE_EDEFAULT;

  /**
   * The default value of the '{@link #getTemporalUnit() <em>Temporal Unit</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTemporalUnit()
   * @generated
   * @ordered
   */
  protected static final String TEMPORAL_UNIT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTemporalUnit() <em>Temporal Unit</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTemporalUnit()
   * @generated
   * @ordered
   */
  protected String temporalUnit = TEMPORAL_UNIT_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TimeDifferencePartImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return DslPackage.Literals.TIME_DIFFERENCE_PART;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BigInteger getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValue(BigInteger newValue)
  {
    BigInteger oldValue = value;
    value = newValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.TIME_DIFFERENCE_PART__VALUE, oldValue, value));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTemporalUnit()
  {
    return temporalUnit;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTemporalUnit(String newTemporalUnit)
  {
    String oldTemporalUnit = temporalUnit;
    temporalUnit = newTemporalUnit;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.TIME_DIFFERENCE_PART__TEMPORAL_UNIT, oldTemporalUnit, temporalUnit));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case DslPackage.TIME_DIFFERENCE_PART__VALUE:
        return getValue();
      case DslPackage.TIME_DIFFERENCE_PART__TEMPORAL_UNIT:
        return getTemporalUnit();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case DslPackage.TIME_DIFFERENCE_PART__VALUE:
        setValue((BigInteger)newValue);
        return;
      case DslPackage.TIME_DIFFERENCE_PART__TEMPORAL_UNIT:
        setTemporalUnit((String)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case DslPackage.TIME_DIFFERENCE_PART__VALUE:
        setValue(VALUE_EDEFAULT);
        return;
      case DslPackage.TIME_DIFFERENCE_PART__TEMPORAL_UNIT:
        setTemporalUnit(TEMPORAL_UNIT_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case DslPackage.TIME_DIFFERENCE_PART__VALUE:
        return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
      case DslPackage.TIME_DIFFERENCE_PART__TEMPORAL_UNIT:
        return TEMPORAL_UNIT_EDEFAULT == null ? temporalUnit != null : !TEMPORAL_UNIT_EDEFAULT.equals(temporalUnit);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (value: ");
    result.append(value);
    result.append(", temporalUnit: ");
    result.append(temporalUnit);
    result.append(')');
    return result.toString();
  }

} //TimeDifferencePartImpl
