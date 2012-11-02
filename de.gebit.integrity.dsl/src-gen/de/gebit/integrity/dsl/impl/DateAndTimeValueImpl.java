/**
 * <copyright>
 * </copyright>
 *

 */
package de.gebit.integrity.dsl.impl;

import de.gebit.integrity.dsl.DateAndTimeValue;
import de.gebit.integrity.dsl.DslPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Date And Time Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.impl.DateAndTimeValueImpl#getDateValue <em>Date Value</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.impl.DateAndTimeValueImpl#getTimeValue <em>Time Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DateAndTimeValueImpl extends StaticValueImpl implements DateAndTimeValue
{
  /**
   * The default value of the '{@link #getDateValue() <em>Date Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDateValue()
   * @generated
   * @ordered
   */
  protected static final String DATE_VALUE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDateValue() <em>Date Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDateValue()
   * @generated
   * @ordered
   */
  protected String dateValue = DATE_VALUE_EDEFAULT;

  /**
   * The default value of the '{@link #getTimeValue() <em>Time Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTimeValue()
   * @generated
   * @ordered
   */
  protected static final String TIME_VALUE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTimeValue() <em>Time Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTimeValue()
   * @generated
   * @ordered
   */
  protected String timeValue = TIME_VALUE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DateAndTimeValueImpl()
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
    return DslPackage.Literals.DATE_AND_TIME_VALUE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDateValue()
  {
    return dateValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDateValue(String newDateValue)
  {
    String oldDateValue = dateValue;
    dateValue = newDateValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.DATE_AND_TIME_VALUE__DATE_VALUE, oldDateValue, dateValue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTimeValue()
  {
    return timeValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTimeValue(String newTimeValue)
  {
    String oldTimeValue = timeValue;
    timeValue = newTimeValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.DATE_AND_TIME_VALUE__TIME_VALUE, oldTimeValue, timeValue));
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
      case DslPackage.DATE_AND_TIME_VALUE__DATE_VALUE:
        return getDateValue();
      case DslPackage.DATE_AND_TIME_VALUE__TIME_VALUE:
        return getTimeValue();
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
      case DslPackage.DATE_AND_TIME_VALUE__DATE_VALUE:
        setDateValue((String)newValue);
        return;
      case DslPackage.DATE_AND_TIME_VALUE__TIME_VALUE:
        setTimeValue((String)newValue);
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
      case DslPackage.DATE_AND_TIME_VALUE__DATE_VALUE:
        setDateValue(DATE_VALUE_EDEFAULT);
        return;
      case DslPackage.DATE_AND_TIME_VALUE__TIME_VALUE:
        setTimeValue(TIME_VALUE_EDEFAULT);
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
      case DslPackage.DATE_AND_TIME_VALUE__DATE_VALUE:
        return DATE_VALUE_EDEFAULT == null ? dateValue != null : !DATE_VALUE_EDEFAULT.equals(dateValue);
      case DslPackage.DATE_AND_TIME_VALUE__TIME_VALUE:
        return TIME_VALUE_EDEFAULT == null ? timeValue != null : !TIME_VALUE_EDEFAULT.equals(timeValue);
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

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (dateValue: ");
    result.append(dateValue);
    result.append(", timeValue: ");
    result.append(timeValue);
    result.append(')');
    return result.toString();
  }

} //DateAndTimeValueImpl
