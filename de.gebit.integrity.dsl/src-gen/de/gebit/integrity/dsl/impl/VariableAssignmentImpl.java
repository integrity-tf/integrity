/**
 */
package de.gebit.integrity.dsl.impl;

import de.gebit.integrity.dsl.DslPackage;
import de.gebit.integrity.dsl.ValueOrEnumValueOrOperationCollection;
import de.gebit.integrity.dsl.VariableAssignment;
import de.gebit.integrity.dsl.VariableVariable;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable Assignment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.impl.VariableAssignmentImpl#getValue <em>Value</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.impl.VariableAssignmentImpl#getTarget <em>Target</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VariableAssignmentImpl extends SuiteStatementImpl implements VariableAssignment
{
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
   * The cached value of the '{@link #getTarget() <em>Target</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTarget()
   * @generated
   * @ordered
   */
  protected VariableVariable target;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected VariableAssignmentImpl()
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
    return DslPackage.Literals.VARIABLE_ASSIGNMENT;
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DslPackage.VARIABLE_ASSIGNMENT__VALUE, oldValue, newValue);
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
        msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DslPackage.VARIABLE_ASSIGNMENT__VALUE, null, msgs);
      if (newValue != null)
        msgs = ((InternalEObject)newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DslPackage.VARIABLE_ASSIGNMENT__VALUE, null, msgs);
      msgs = basicSetValue(newValue, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.VARIABLE_ASSIGNMENT__VALUE, newValue, newValue));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VariableVariable getTarget()
  {
    return target;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTarget(VariableVariable newTarget, NotificationChain msgs)
  {
    VariableVariable oldTarget = target;
    target = newTarget;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DslPackage.VARIABLE_ASSIGNMENT__TARGET, oldTarget, newTarget);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTarget(VariableVariable newTarget)
  {
    if (newTarget != target)
    {
      NotificationChain msgs = null;
      if (target != null)
        msgs = ((InternalEObject)target).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DslPackage.VARIABLE_ASSIGNMENT__TARGET, null, msgs);
      if (newTarget != null)
        msgs = ((InternalEObject)newTarget).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DslPackage.VARIABLE_ASSIGNMENT__TARGET, null, msgs);
      msgs = basicSetTarget(newTarget, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.VARIABLE_ASSIGNMENT__TARGET, newTarget, newTarget));
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
      case DslPackage.VARIABLE_ASSIGNMENT__VALUE:
        return basicSetValue(null, msgs);
      case DslPackage.VARIABLE_ASSIGNMENT__TARGET:
        return basicSetTarget(null, msgs);
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
      case DslPackage.VARIABLE_ASSIGNMENT__VALUE:
        return getValue();
      case DslPackage.VARIABLE_ASSIGNMENT__TARGET:
        return getTarget();
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
      case DslPackage.VARIABLE_ASSIGNMENT__VALUE:
        setValue((ValueOrEnumValueOrOperationCollection)newValue);
        return;
      case DslPackage.VARIABLE_ASSIGNMENT__TARGET:
        setTarget((VariableVariable)newValue);
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
      case DslPackage.VARIABLE_ASSIGNMENT__VALUE:
        setValue((ValueOrEnumValueOrOperationCollection)null);
        return;
      case DslPackage.VARIABLE_ASSIGNMENT__TARGET:
        setTarget((VariableVariable)null);
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
      case DslPackage.VARIABLE_ASSIGNMENT__VALUE:
        return value != null;
      case DslPackage.VARIABLE_ASSIGNMENT__TARGET:
        return target != null;
    }
    return super.eIsSet(featureID);
  }

} //VariableAssignmentImpl
