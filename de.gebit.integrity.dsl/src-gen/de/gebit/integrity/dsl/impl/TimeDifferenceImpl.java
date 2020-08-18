/**
 */
package de.gebit.integrity.dsl.impl;

import de.gebit.integrity.dsl.DslPackage;
import de.gebit.integrity.dsl.TimeDifference;
import de.gebit.integrity.dsl.ValueOrEnumValueOrOperation;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Time Difference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.impl.TimeDifferenceImpl#getDirection <em>Direction</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.impl.TimeDifferenceImpl#getFixedValues <em>Fixed Values</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.impl.TimeDifferenceImpl#getCalculatedValue <em>Calculated Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TimeDifferenceImpl extends MinimalEObjectImpl.Container implements TimeDifference
{
  /**
   * The default value of the '{@link #getDirection() <em>Direction</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDirection()
   * @generated
   * @ordered
   */
  protected static final String DIRECTION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDirection() <em>Direction</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDirection()
   * @generated
   * @ordered
   */
  protected String direction = DIRECTION_EDEFAULT;

  /**
   * The cached value of the '{@link #getFixedValues() <em>Fixed Values</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFixedValues()
   * @generated
   * @ordered
   */
  protected EList<String> fixedValues;

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
  protected TimeDifferenceImpl()
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
    return DslPackage.Literals.TIME_DIFFERENCE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getDirection()
  {
    return direction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setDirection(String newDirection)
  {
    String oldDirection = direction;
    direction = newDirection;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.TIME_DIFFERENCE__DIRECTION, oldDirection, direction));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<String> getFixedValues()
  {
    if (fixedValues == null)
    {
      fixedValues = new EDataTypeEList<String>(String.class, this, DslPackage.TIME_DIFFERENCE__FIXED_VALUES);
    }
    return fixedValues;
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DslPackage.TIME_DIFFERENCE__CALCULATED_VALUE, oldCalculatedValue, newCalculatedValue);
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
        msgs = ((InternalEObject)calculatedValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DslPackage.TIME_DIFFERENCE__CALCULATED_VALUE, null, msgs);
      if (newCalculatedValue != null)
        msgs = ((InternalEObject)newCalculatedValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DslPackage.TIME_DIFFERENCE__CALCULATED_VALUE, null, msgs);
      msgs = basicSetCalculatedValue(newCalculatedValue, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.TIME_DIFFERENCE__CALCULATED_VALUE, newCalculatedValue, newCalculatedValue));
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
      case DslPackage.TIME_DIFFERENCE__CALCULATED_VALUE:
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
      case DslPackage.TIME_DIFFERENCE__DIRECTION:
        return getDirection();
      case DslPackage.TIME_DIFFERENCE__FIXED_VALUES:
        return getFixedValues();
      case DslPackage.TIME_DIFFERENCE__CALCULATED_VALUE:
        return getCalculatedValue();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case DslPackage.TIME_DIFFERENCE__DIRECTION:
        setDirection((String)newValue);
        return;
      case DslPackage.TIME_DIFFERENCE__FIXED_VALUES:
        getFixedValues().clear();
        getFixedValues().addAll((Collection<? extends String>)newValue);
        return;
      case DslPackage.TIME_DIFFERENCE__CALCULATED_VALUE:
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
      case DslPackage.TIME_DIFFERENCE__DIRECTION:
        setDirection(DIRECTION_EDEFAULT);
        return;
      case DslPackage.TIME_DIFFERENCE__FIXED_VALUES:
        getFixedValues().clear();
        return;
      case DslPackage.TIME_DIFFERENCE__CALCULATED_VALUE:
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
      case DslPackage.TIME_DIFFERENCE__DIRECTION:
        return DIRECTION_EDEFAULT == null ? direction != null : !DIRECTION_EDEFAULT.equals(direction);
      case DslPackage.TIME_DIFFERENCE__FIXED_VALUES:
        return fixedValues != null && !fixedValues.isEmpty();
      case DslPackage.TIME_DIFFERENCE__CALCULATED_VALUE:
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
    result.append(" (direction: ");
    result.append(direction);
    result.append(", fixedValues: ");
    result.append(fixedValues);
    result.append(')');
    return result.toString();
  }

} //TimeDifferenceImpl
