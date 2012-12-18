/**
 */
package de.gebit.integrity.dsl.impl;

import de.gebit.integrity.dsl.DslPackage;
import de.gebit.integrity.dsl.EnumValue;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.common.types.JvmEnumerationLiteral;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enum Value</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.impl.EnumValueImpl#getEnumValue <em>Enum Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EnumValueImpl extends ValueOrEnumValueOrOperationImpl implements EnumValue
{
  /**
   * The cached value of the '{@link #getEnumValue() <em>Enum Value</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEnumValue()
   * @generated
   * @ordered
   */
  protected JvmEnumerationLiteral enumValue;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EnumValueImpl()
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
    return DslPackage.Literals.ENUM_VALUE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JvmEnumerationLiteral getEnumValue()
  {
    if (enumValue != null && enumValue.eIsProxy())
    {
      InternalEObject oldEnumValue = (InternalEObject)enumValue;
      enumValue = (JvmEnumerationLiteral)eResolveProxy(oldEnumValue);
      if (enumValue != oldEnumValue)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, DslPackage.ENUM_VALUE__ENUM_VALUE, oldEnumValue, enumValue));
      }
    }
    return enumValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JvmEnumerationLiteral basicGetEnumValue()
  {
    return enumValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEnumValue(JvmEnumerationLiteral newEnumValue)
  {
    JvmEnumerationLiteral oldEnumValue = enumValue;
    enumValue = newEnumValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.ENUM_VALUE__ENUM_VALUE, oldEnumValue, enumValue));
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
      case DslPackage.ENUM_VALUE__ENUM_VALUE:
        if (resolve) return getEnumValue();
        return basicGetEnumValue();
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
      case DslPackage.ENUM_VALUE__ENUM_VALUE:
        setEnumValue((JvmEnumerationLiteral)newValue);
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
      case DslPackage.ENUM_VALUE__ENUM_VALUE:
        setEnumValue((JvmEnumerationLiteral)null);
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
      case DslPackage.ENUM_VALUE__ENUM_VALUE:
        return enumValue != null;
    }
    return super.eIsSet(featureID);
  }

} //EnumValueImpl
