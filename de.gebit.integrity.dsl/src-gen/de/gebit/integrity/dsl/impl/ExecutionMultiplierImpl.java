/**
 */
package de.gebit.integrity.dsl.impl;

import de.gebit.integrity.dsl.DslPackage;
import de.gebit.integrity.dsl.ExecutionMultiplier;

import java.math.BigInteger;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Execution Multiplier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.impl.ExecutionMultiplierImpl#getCount <em>Count</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExecutionMultiplierImpl extends MinimalEObjectImpl.Container implements ExecutionMultiplier
{
  /**
   * The default value of the '{@link #getCount() <em>Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCount()
   * @generated
   * @ordered
   */
  protected static final BigInteger COUNT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getCount() <em>Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCount()
   * @generated
   * @ordered
   */
  protected BigInteger count = COUNT_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ExecutionMultiplierImpl()
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
    return DslPackage.Literals.EXECUTION_MULTIPLIER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BigInteger getCount()
  {
    return count;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCount(BigInteger newCount)
  {
    BigInteger oldCount = count;
    count = newCount;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.EXECUTION_MULTIPLIER__COUNT, oldCount, count));
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
      case DslPackage.EXECUTION_MULTIPLIER__COUNT:
        return getCount();
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
      case DslPackage.EXECUTION_MULTIPLIER__COUNT:
        setCount((BigInteger)newValue);
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
      case DslPackage.EXECUTION_MULTIPLIER__COUNT:
        setCount(COUNT_EDEFAULT);
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
      case DslPackage.EXECUTION_MULTIPLIER__COUNT:
        return COUNT_EDEFAULT == null ? count != null : !COUNT_EDEFAULT.equals(count);
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
    result.append(" (count: ");
    result.append(count);
    result.append(')');
    return result.toString();
  }

} //ExecutionMultiplierImpl
