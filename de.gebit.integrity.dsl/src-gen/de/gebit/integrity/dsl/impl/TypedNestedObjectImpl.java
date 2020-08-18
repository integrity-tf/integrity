/**
 */
package de.gebit.integrity.dsl.impl;

import de.gebit.integrity.dsl.DslPackage;
import de.gebit.integrity.dsl.JavaClassReference;
import de.gebit.integrity.dsl.NestedObject;
import de.gebit.integrity.dsl.TypedNestedObject;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Typed Nested Object</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.impl.TypedNestedObjectImpl#getType <em>Type</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.impl.TypedNestedObjectImpl#getNestedObject <em>Nested Object</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TypedNestedObjectImpl extends ValueImpl implements TypedNestedObject
{
  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected JavaClassReference type;

  /**
   * The cached value of the '{@link #getNestedObject() <em>Nested Object</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getNestedObject()
   * @generated
   * @ordered
   */
  protected NestedObject nestedObject;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TypedNestedObjectImpl()
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
    return DslPackage.Literals.TYPED_NESTED_OBJECT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public JavaClassReference getType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetType(JavaClassReference newType, NotificationChain msgs)
  {
    JavaClassReference oldType = type;
    type = newType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DslPackage.TYPED_NESTED_OBJECT__TYPE, oldType, newType);
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
  public void setType(JavaClassReference newType)
  {
    if (newType != type)
    {
      NotificationChain msgs = null;
      if (type != null)
        msgs = ((InternalEObject)type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DslPackage.TYPED_NESTED_OBJECT__TYPE, null, msgs);
      if (newType != null)
        msgs = ((InternalEObject)newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DslPackage.TYPED_NESTED_OBJECT__TYPE, null, msgs);
      msgs = basicSetType(newType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.TYPED_NESTED_OBJECT__TYPE, newType, newType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NestedObject getNestedObject()
  {
    return nestedObject;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetNestedObject(NestedObject newNestedObject, NotificationChain msgs)
  {
    NestedObject oldNestedObject = nestedObject;
    nestedObject = newNestedObject;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DslPackage.TYPED_NESTED_OBJECT__NESTED_OBJECT, oldNestedObject, newNestedObject);
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
  public void setNestedObject(NestedObject newNestedObject)
  {
    if (newNestedObject != nestedObject)
    {
      NotificationChain msgs = null;
      if (nestedObject != null)
        msgs = ((InternalEObject)nestedObject).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DslPackage.TYPED_NESTED_OBJECT__NESTED_OBJECT, null, msgs);
      if (newNestedObject != null)
        msgs = ((InternalEObject)newNestedObject).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DslPackage.TYPED_NESTED_OBJECT__NESTED_OBJECT, null, msgs);
      msgs = basicSetNestedObject(newNestedObject, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.TYPED_NESTED_OBJECT__NESTED_OBJECT, newNestedObject, newNestedObject));
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
      case DslPackage.TYPED_NESTED_OBJECT__TYPE:
        return basicSetType(null, msgs);
      case DslPackage.TYPED_NESTED_OBJECT__NESTED_OBJECT:
        return basicSetNestedObject(null, msgs);
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
      case DslPackage.TYPED_NESTED_OBJECT__TYPE:
        return getType();
      case DslPackage.TYPED_NESTED_OBJECT__NESTED_OBJECT:
        return getNestedObject();
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
      case DslPackage.TYPED_NESTED_OBJECT__TYPE:
        setType((JavaClassReference)newValue);
        return;
      case DslPackage.TYPED_NESTED_OBJECT__NESTED_OBJECT:
        setNestedObject((NestedObject)newValue);
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
      case DslPackage.TYPED_NESTED_OBJECT__TYPE:
        setType((JavaClassReference)null);
        return;
      case DslPackage.TYPED_NESTED_OBJECT__NESTED_OBJECT:
        setNestedObject((NestedObject)null);
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
      case DslPackage.TYPED_NESTED_OBJECT__TYPE:
        return type != null;
      case DslPackage.TYPED_NESTED_OBJECT__NESTED_OBJECT:
        return nestedObject != null;
    }
    return super.eIsSet(featureID);
  }

} //TypedNestedObjectImpl
