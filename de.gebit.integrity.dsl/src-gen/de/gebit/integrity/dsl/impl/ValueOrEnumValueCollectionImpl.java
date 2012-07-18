/**
 */
package de.gebit.integrity.dsl.impl;

import de.gebit.integrity.dsl.DslPackage;
import de.gebit.integrity.dsl.ValueOrEnumValue;
import de.gebit.integrity.dsl.ValueOrEnumValueCollection;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Value Or Enum Value Collection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.impl.ValueOrEnumValueCollectionImpl#getValue <em>Value</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.impl.ValueOrEnumValueCollectionImpl#getMoreValues <em>More Values</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ValueOrEnumValueCollectionImpl extends MinimalEObjectImpl.Container implements ValueOrEnumValueCollection
{
  /**
   * The cached value of the '{@link #getValue() <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected ValueOrEnumValue value;

  /**
   * The cached value of the '{@link #getMoreValues() <em>More Values</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMoreValues()
   * @generated
   * @ordered
   */
  protected EList<ValueOrEnumValue> moreValues;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ValueOrEnumValueCollectionImpl()
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
    return DslPackage.Literals.VALUE_OR_ENUM_VALUE_COLLECTION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ValueOrEnumValue getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetValue(ValueOrEnumValue newValue, NotificationChain msgs)
  {
    ValueOrEnumValue oldValue = value;
    value = newValue;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DslPackage.VALUE_OR_ENUM_VALUE_COLLECTION__VALUE, oldValue, newValue);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValue(ValueOrEnumValue newValue)
  {
    if (newValue != value)
    {
      NotificationChain msgs = null;
      if (value != null)
        msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DslPackage.VALUE_OR_ENUM_VALUE_COLLECTION__VALUE, null, msgs);
      if (newValue != null)
        msgs = ((InternalEObject)newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DslPackage.VALUE_OR_ENUM_VALUE_COLLECTION__VALUE, null, msgs);
      msgs = basicSetValue(newValue, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.VALUE_OR_ENUM_VALUE_COLLECTION__VALUE, newValue, newValue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ValueOrEnumValue> getMoreValues()
  {
    if (moreValues == null)
    {
      moreValues = new EObjectContainmentEList<ValueOrEnumValue>(ValueOrEnumValue.class, this, DslPackage.VALUE_OR_ENUM_VALUE_COLLECTION__MORE_VALUES);
    }
    return moreValues;
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
      case DslPackage.VALUE_OR_ENUM_VALUE_COLLECTION__VALUE:
        return basicSetValue(null, msgs);
      case DslPackage.VALUE_OR_ENUM_VALUE_COLLECTION__MORE_VALUES:
        return ((InternalEList<?>)getMoreValues()).basicRemove(otherEnd, msgs);
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
      case DslPackage.VALUE_OR_ENUM_VALUE_COLLECTION__VALUE:
        return getValue();
      case DslPackage.VALUE_OR_ENUM_VALUE_COLLECTION__MORE_VALUES:
        return getMoreValues();
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
      case DslPackage.VALUE_OR_ENUM_VALUE_COLLECTION__VALUE:
        setValue((ValueOrEnumValue)newValue);
        return;
      case DslPackage.VALUE_OR_ENUM_VALUE_COLLECTION__MORE_VALUES:
        getMoreValues().clear();
        getMoreValues().addAll((Collection<? extends ValueOrEnumValue>)newValue);
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
      case DslPackage.VALUE_OR_ENUM_VALUE_COLLECTION__VALUE:
        setValue((ValueOrEnumValue)null);
        return;
      case DslPackage.VALUE_OR_ENUM_VALUE_COLLECTION__MORE_VALUES:
        getMoreValues().clear();
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
      case DslPackage.VALUE_OR_ENUM_VALUE_COLLECTION__VALUE:
        return value != null;
      case DslPackage.VALUE_OR_ENUM_VALUE_COLLECTION__MORE_VALUES:
        return moreValues != null && !moreValues.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ValueOrEnumValueCollectionImpl
