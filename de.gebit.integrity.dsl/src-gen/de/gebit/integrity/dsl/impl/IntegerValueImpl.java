/**
 */
package de.gebit.integrity.dsl.impl;

import de.gebit.integrity.dsl.DslPackage;
import de.gebit.integrity.dsl.IntegerValue;

import java.math.BigInteger;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Integer Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.impl.IntegerValueImpl#getIntegerValue <em>Integer Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IntegerValueImpl extends StaticValueImpl implements IntegerValue
{
  /**
   * The default value of the '{@link #getIntegerValue() <em>Integer Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIntegerValue()
   * @generated
   * @ordered
   */
  protected static final BigInteger INTEGER_VALUE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getIntegerValue() <em>Integer Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getIntegerValue()
   * @generated
   * @ordered
   */
  protected BigInteger integerValue = INTEGER_VALUE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IntegerValueImpl()
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
    return DslPackage.Literals.INTEGER_VALUE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BigInteger getIntegerValue()
  {
    return integerValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setIntegerValue(BigInteger newIntegerValue)
  {
    BigInteger oldIntegerValue = integerValue;
    integerValue = newIntegerValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.INTEGER_VALUE__INTEGER_VALUE, oldIntegerValue, integerValue));
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
      case DslPackage.INTEGER_VALUE__INTEGER_VALUE:
        return getIntegerValue();
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
      case DslPackage.INTEGER_VALUE__INTEGER_VALUE:
        setIntegerValue((BigInteger)newValue);
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
      case DslPackage.INTEGER_VALUE__INTEGER_VALUE:
        setIntegerValue(INTEGER_VALUE_EDEFAULT);
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
      case DslPackage.INTEGER_VALUE__INTEGER_VALUE:
        return INTEGER_VALUE_EDEFAULT == null ? integerValue != null : !INTEGER_VALUE_EDEFAULT.equals(integerValue);
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
    result.append(" (integerValue: ");
    result.append(integerValue);
    result.append(')');
    return result.toString();
  }

} //IntegerValueImpl
