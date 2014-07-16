/**
 */
package de.gebit.integrity.dsl.impl;

import de.gebit.integrity.dsl.ConstantDefinition;
import de.gebit.integrity.dsl.ConstantEntity;
import de.gebit.integrity.dsl.DslPackage;
import de.gebit.integrity.dsl.ValueOrEnumValueOrOperationCollection;
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
 *   <li>{@link de.gebit.integrity.dsl.impl.ConstantDefinitionImpl#getParameterized <em>Parameterized</em>}</li>
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
  protected ConstantEntity name;

  /**
   * The cached value of the '{@link #getValue() <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected ValueOrEnumValueOrOperationCollection value;

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
   * The default value of the '{@link #getParameterized() <em>Parameterized</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParameterized()
   * @generated
   * @ordered
   */
  protected static final String PARAMETERIZED_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getParameterized() <em>Parameterized</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParameterized()
   * @generated
   * @ordered
   */
  protected String parameterized = PARAMETERIZED_EDEFAULT;

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
  public ConstantEntity getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetName(ConstantEntity newName, NotificationChain msgs)
  {
    ConstantEntity oldName = name;
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
  public void setName(ConstantEntity newName)
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
  public ValueOrEnumValueOrOperationCollection getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetValue(ValueOrEnumValueOrOperationCollection newValue, NotificationChain msgs)
  {
    ValueOrEnumValueOrOperationCollection oldValue = value;
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
  public void setValue(ValueOrEnumValueOrOperationCollection newValue)
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
  public String getParameterized()
  {
    return parameterized;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setParameterized(String newParameterized)
  {
    String oldParameterized = parameterized;
    parameterized = newParameterized;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.CONSTANT_DEFINITION__PARAMETERIZED, oldParameterized, parameterized));
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
      case DslPackage.CONSTANT_DEFINITION__PARAMETERIZED:
        return getParameterized();
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
        setName((ConstantEntity)newValue);
        return;
      case DslPackage.CONSTANT_DEFINITION__VALUE:
        setValue((ValueOrEnumValueOrOperationCollection)newValue);
        return;
      case DslPackage.CONSTANT_DEFINITION__VARIANT_VALUES:
        getVariantValues().clear();
        getVariantValues().addAll((Collection<? extends VariantValue>)newValue);
        return;
      case DslPackage.CONSTANT_DEFINITION__PARAMETERIZED:
        setParameterized((String)newValue);
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
        setName((ConstantEntity)null);
        return;
      case DslPackage.CONSTANT_DEFINITION__VALUE:
        setValue((ValueOrEnumValueOrOperationCollection)null);
        return;
      case DslPackage.CONSTANT_DEFINITION__VARIANT_VALUES:
        getVariantValues().clear();
        return;
      case DslPackage.CONSTANT_DEFINITION__PARAMETERIZED:
        setParameterized(PARAMETERIZED_EDEFAULT);
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
      case DslPackage.CONSTANT_DEFINITION__PARAMETERIZED:
        return PARAMETERIZED_EDEFAULT == null ? parameterized != null : !PARAMETERIZED_EDEFAULT.equals(parameterized);
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
    result.append(" (parameterized: ");
    result.append(parameterized);
    result.append(')');
    return result.toString();
  }

} //ConstantDefinitionImpl
