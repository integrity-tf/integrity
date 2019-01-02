/**
 */
package de.gebit.integrity.dsl.impl;

import de.gebit.integrity.dsl.DecimalValue;
import de.gebit.integrity.dsl.DslPackage;

import java.math.BigDecimal;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Decimal Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.impl.DecimalValueImpl#getDecimalValue <em>Decimal Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DecimalValueImpl extends StaticValueImpl implements DecimalValue
{
  /**
   * The default value of the '{@link #getDecimalValue() <em>Decimal Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDecimalValue()
   * @generated
   * @ordered
   */
  protected static final BigDecimal DECIMAL_VALUE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDecimalValue() <em>Decimal Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDecimalValue()
   * @generated
   * @ordered
   */
  protected BigDecimal decimalValue = DECIMAL_VALUE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DecimalValueImpl()
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
    return DslPackage.Literals.DECIMAL_VALUE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BigDecimal getDecimalValue()
  {
    return decimalValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDecimalValue(BigDecimal newDecimalValue)
  {
    BigDecimal oldDecimalValue = decimalValue;
    decimalValue = newDecimalValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.DECIMAL_VALUE__DECIMAL_VALUE, oldDecimalValue, decimalValue));
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
      case DslPackage.DECIMAL_VALUE__DECIMAL_VALUE:
        return getDecimalValue();
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
      case DslPackage.DECIMAL_VALUE__DECIMAL_VALUE:
        setDecimalValue((BigDecimal)newValue);
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
      case DslPackage.DECIMAL_VALUE__DECIMAL_VALUE:
        setDecimalValue(DECIMAL_VALUE_EDEFAULT);
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
      case DslPackage.DECIMAL_VALUE__DECIMAL_VALUE:
        return DECIMAL_VALUE_EDEFAULT == null ? decimalValue != null : !DECIMAL_VALUE_EDEFAULT.equals(decimalValue);
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
    result.append(" (decimalValue: ");
    result.append(decimalValue);
    result.append(')');
    return result.toString();
  }

} //DecimalValueImpl
