/**
 */
package de.gebit.integrity.dsl.impl;

import de.gebit.integrity.dsl.ConstantDefinition;
import de.gebit.integrity.dsl.DslPackage;
import de.gebit.integrity.dsl.StaticValue;
import de.gebit.integrity.dsl.VariableEntity;
import de.gebit.integrity.dsl.VariantValue;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Constant Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.impl.ConstantDefinitionImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.impl.ConstantDefinitionImpl#getValue <em>Value</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.impl.ConstantDefinitionImpl#getVariantValues <em>Variant Values</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConstantDefinitionImpl extends PackageStatementImpl implements ConstantDefinition
{
  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected VariableEntity name;

  /**
   * The cached value of the '{@link #getValue() <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected StaticValue value;

  /**
   * The cached value of the '{@link #getVariantValues() <em>Variant Values</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVariantValues()
   * @generated
   * @ordered
   */
  protected EList<VariantValue> variantValues;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ConstantDefinitionImpl()
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
    return DslPackage.Literals.CONSTANT_DEFINITION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VariableEntity getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetName(VariableEntity newName, NotificationChain msgs)
  {
    VariableEntity oldName = name;
    name = newName;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DslPackage.CONSTANT_DEFINITION__NAME, oldName, newName);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(VariableEntity newName)
  {
    if (newName != name)
    {
      NotificationChain msgs = null;
      if (name != null)
        msgs = ((InternalEObject)name).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DslPackage.CONSTANT_DEFINITION__NAME, null, msgs);
      if (newName != null)
        msgs = ((InternalEObject)newName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DslPackage.CONSTANT_DEFINITION__NAME, null, msgs);
      msgs = basicSetName(newName, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.CONSTANT_DEFINITION__NAME, newName, newName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StaticValue getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetValue(StaticValue newValue, NotificationChain msgs)
  {
    StaticValue oldValue = value;
    value = newValue;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DslPackage.CONSTANT_DEFINITION__VALUE, oldValue, newValue);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValue(StaticValue newValue)
  {
    if (newValue != value)
    {
      NotificationChain msgs = null;
      if (value != null)
        msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DslPackage.CONSTANT_DEFINITION__VALUE, null, msgs);
      if (newValue != null)
        msgs = ((InternalEObject)newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DslPackage.CONSTANT_DEFINITION__VALUE, null, msgs);
      msgs = basicSetValue(newValue, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.CONSTANT_DEFINITION__VALUE, newValue, newValue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<VariantValue> getVariantValues()
  {
    if (variantValues == null)
    {
      variantValues = new EObjectContainmentEList<VariantValue>(VariantValue.class, this, DslPackage.CONSTANT_DEFINITION__VARIANT_VALUES);
    }
    return variantValues;
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
      case DslPackage.CONSTANT_DEFINITION__NAME:
        return basicSetName(null, msgs);
      case DslPackage.CONSTANT_DEFINITION__VALUE:
        return basicSetValue(null, msgs);
      case DslPackage.CONSTANT_DEFINITION__VARIANT_VALUES:
        return ((InternalEList<?>)getVariantValues()).basicRemove(otherEnd, msgs);
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
      case DslPackage.CONSTANT_DEFINITION__NAME:
        return getName();
      case DslPackage.CONSTANT_DEFINITION__VALUE:
        return getValue();
      case DslPackage.CONSTANT_DEFINITION__VARIANT_VALUES:
        return getVariantValues();
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
      case DslPackage.CONSTANT_DEFINITION__NAME:
        setName((VariableEntity)newValue);
        return;
      case DslPackage.CONSTANT_DEFINITION__VALUE:
        setValue((StaticValue)newValue);
        return;
      case DslPackage.CONSTANT_DEFINITION__VARIANT_VALUES:
        getVariantValues().clear();
        getVariantValues().addAll((Collection<? extends VariantValue>)newValue);
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
      case DslPackage.CONSTANT_DEFINITION__NAME:
        setName((VariableEntity)null);
        return;
      case DslPackage.CONSTANT_DEFINITION__VALUE:
        setValue((StaticValue)null);
        return;
      case DslPackage.CONSTANT_DEFINITION__VARIANT_VALUES:
        getVariantValues().clear();
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
      case DslPackage.CONSTANT_DEFINITION__NAME:
        return name != null;
      case DslPackage.CONSTANT_DEFINITION__VALUE:
        return value != null;
      case DslPackage.CONSTANT_DEFINITION__VARIANT_VALUES:
        return variantValues != null && !variantValues.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ConstantDefinitionImpl
