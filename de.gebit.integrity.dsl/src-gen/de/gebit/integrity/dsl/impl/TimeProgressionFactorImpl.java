/**
 */
package de.gebit.integrity.dsl.impl;

import de.gebit.integrity.dsl.DslPackage;
import de.gebit.integrity.dsl.TimeProgressionFactor;
import de.gebit.integrity.dsl.ValueOrEnumValueOrOperation;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Time Progression Factor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.impl.TimeProgressionFactorImpl#getFixedValue <em>Fixed Value</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.impl.TimeProgressionFactorImpl#getCalculatedValue <em>Calculated Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TimeProgressionFactorImpl extends MinimalEObjectImpl.Container implements TimeProgressionFactor
{
  /**
   * The default value of the '{@link #getFixedValue() <em>Fixed Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFixedValue()
   * @generated
   * @ordered
   */
  protected static final String FIXED_VALUE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getFixedValue() <em>Fixed Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFixedValue()
   * @generated
   * @ordered
   */
  protected String fixedValue = FIXED_VALUE_EDEFAULT;

  /**
   * The cached value of the '{@link #getCalculatedValue() <em>Calculated Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCalculatedValue()
   * @generated
   * @ordered
   */
  protected ValueOrEnumValueOrOperation calculatedValue;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TimeProgressionFactorImpl()
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
    return DslPackage.Literals.TIME_PROGRESSION_FACTOR;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getFixedValue()
  {
    return fixedValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setFixedValue(String newFixedValue)
  {
    String oldFixedValue = fixedValue;
    fixedValue = newFixedValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.TIME_PROGRESSION_FACTOR__FIXED_VALUE, oldFixedValue, fixedValue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ValueOrEnumValueOrOperation getCalculatedValue()
  {
    return calculatedValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCalculatedValue(ValueOrEnumValueOrOperation newCalculatedValue, NotificationChain msgs)
  {
    ValueOrEnumValueOrOperation oldCalculatedValue = calculatedValue;
    calculatedValue = newCalculatedValue;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DslPackage.TIME_PROGRESSION_FACTOR__CALCULATED_VALUE, oldCalculatedValue, newCalculatedValue);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setCalculatedValue(ValueOrEnumValueOrOperation newCalculatedValue)
  {
    if (newCalculatedValue != calculatedValue)
    {
      NotificationChain msgs = null;
      if (calculatedValue != null)
        msgs = ((InternalEObject)calculatedValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DslPackage.TIME_PROGRESSION_FACTOR__CALCULATED_VALUE, null, msgs);
      if (newCalculatedValue != null)
        msgs = ((InternalEObject)newCalculatedValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DslPackage.TIME_PROGRESSION_FACTOR__CALCULATED_VALUE, null, msgs);
      msgs = basicSetCalculatedValue(newCalculatedValue, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.TIME_PROGRESSION_FACTOR__CALCULATED_VALUE, newCalculatedValue, newCalculatedValue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case DslPackage.TIME_PROGRESSION_FACTOR__CALCULATED_VALUE:
        return basicSetCalculatedValue(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case DslPackage.TIME_PROGRESSION_FACTOR__FIXED_VALUE:
        return getFixedValue();
      case DslPackage.TIME_PROGRESSION_FACTOR__CALCULATED_VALUE:
        return getCalculatedValue();
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
      case DslPackage.TIME_PROGRESSION_FACTOR__FIXED_VALUE:
        setFixedValue((String)newValue);
        return;
      case DslPackage.TIME_PROGRESSION_FACTOR__CALCULATED_VALUE:
        setCalculatedValue((ValueOrEnumValueOrOperation)newValue);
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
      case DslPackage.TIME_PROGRESSION_FACTOR__FIXED_VALUE:
        setFixedValue(FIXED_VALUE_EDEFAULT);
        return;
      case DslPackage.TIME_PROGRESSION_FACTOR__CALCULATED_VALUE:
        setCalculatedValue((ValueOrEnumValueOrOperation)null);
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
      case DslPackage.TIME_PROGRESSION_FACTOR__FIXED_VALUE:
        return FIXED_VALUE_EDEFAULT == null ? fixedValue != null : !FIXED_VALUE_EDEFAULT.equals(fixedValue);
      case DslPackage.TIME_PROGRESSION_FACTOR__CALCULATED_VALUE:
        return calculatedValue != null;
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
    result.append(" (fixedValue: ");
    result.append(fixedValue);
    result.append(')');
    return result.toString();
  }

} //TimeProgressionFactorImpl
