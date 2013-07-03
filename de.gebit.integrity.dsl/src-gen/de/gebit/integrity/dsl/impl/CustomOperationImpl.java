/**
 */
package de.gebit.integrity.dsl.impl;

import de.gebit.integrity.dsl.CustomOperation;
import de.gebit.integrity.dsl.DslPackage;
import de.gebit.integrity.dsl.OperationDefinition;
import de.gebit.integrity.dsl.ValueOrEnumValueOrOperationCollection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Custom Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.impl.CustomOperationImpl#getPrefixOperand <em>Prefix Operand</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.impl.CustomOperationImpl#getDefinition <em>Definition</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.impl.CustomOperationImpl#getPostfixOperand <em>Postfix Operand</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CustomOperationImpl extends OperationImpl implements CustomOperation
{
  /**
   * The cached value of the '{@link #getPrefixOperand() <em>Prefix Operand</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPrefixOperand()
   * @generated
   * @ordered
   */
  protected ValueOrEnumValueOrOperationCollection prefixOperand;

  /**
   * The cached value of the '{@link #getDefinition() <em>Definition</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDefinition()
   * @generated
   * @ordered
   */
  protected OperationDefinition definition;

  /**
   * The cached value of the '{@link #getPostfixOperand() <em>Postfix Operand</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPostfixOperand()
   * @generated
   * @ordered
   */
  protected ValueOrEnumValueOrOperationCollection postfixOperand;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CustomOperationImpl()
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
    return DslPackage.Literals.CUSTOM_OPERATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ValueOrEnumValueOrOperationCollection getPrefixOperand()
  {
    return prefixOperand;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPrefixOperand(ValueOrEnumValueOrOperationCollection newPrefixOperand, NotificationChain msgs)
  {
    ValueOrEnumValueOrOperationCollection oldPrefixOperand = prefixOperand;
    prefixOperand = newPrefixOperand;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DslPackage.CUSTOM_OPERATION__PREFIX_OPERAND, oldPrefixOperand, newPrefixOperand);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPrefixOperand(ValueOrEnumValueOrOperationCollection newPrefixOperand)
  {
    if (newPrefixOperand != prefixOperand)
    {
      NotificationChain msgs = null;
      if (prefixOperand != null)
        msgs = ((InternalEObject)prefixOperand).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DslPackage.CUSTOM_OPERATION__PREFIX_OPERAND, null, msgs);
      if (newPrefixOperand != null)
        msgs = ((InternalEObject)newPrefixOperand).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DslPackage.CUSTOM_OPERATION__PREFIX_OPERAND, null, msgs);
      msgs = basicSetPrefixOperand(newPrefixOperand, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.CUSTOM_OPERATION__PREFIX_OPERAND, newPrefixOperand, newPrefixOperand));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OperationDefinition getDefinition()
  {
    if (definition != null && definition.eIsProxy())
    {
      InternalEObject oldDefinition = (InternalEObject)definition;
      definition = (OperationDefinition)eResolveProxy(oldDefinition);
      if (definition != oldDefinition)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, DslPackage.CUSTOM_OPERATION__DEFINITION, oldDefinition, definition));
      }
    }
    return definition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OperationDefinition basicGetDefinition()
  {
    return definition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDefinition(OperationDefinition newDefinition)
  {
    OperationDefinition oldDefinition = definition;
    definition = newDefinition;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.CUSTOM_OPERATION__DEFINITION, oldDefinition, definition));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ValueOrEnumValueOrOperationCollection getPostfixOperand()
  {
    return postfixOperand;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPostfixOperand(ValueOrEnumValueOrOperationCollection newPostfixOperand, NotificationChain msgs)
  {
    ValueOrEnumValueOrOperationCollection oldPostfixOperand = postfixOperand;
    postfixOperand = newPostfixOperand;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DslPackage.CUSTOM_OPERATION__POSTFIX_OPERAND, oldPostfixOperand, newPostfixOperand);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPostfixOperand(ValueOrEnumValueOrOperationCollection newPostfixOperand)
  {
    if (newPostfixOperand != postfixOperand)
    {
      NotificationChain msgs = null;
      if (postfixOperand != null)
        msgs = ((InternalEObject)postfixOperand).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DslPackage.CUSTOM_OPERATION__POSTFIX_OPERAND, null, msgs);
      if (newPostfixOperand != null)
        msgs = ((InternalEObject)newPostfixOperand).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DslPackage.CUSTOM_OPERATION__POSTFIX_OPERAND, null, msgs);
      msgs = basicSetPostfixOperand(newPostfixOperand, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.CUSTOM_OPERATION__POSTFIX_OPERAND, newPostfixOperand, newPostfixOperand));
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
      case DslPackage.CUSTOM_OPERATION__PREFIX_OPERAND:
        return basicSetPrefixOperand(null, msgs);
      case DslPackage.CUSTOM_OPERATION__POSTFIX_OPERAND:
        return basicSetPostfixOperand(null, msgs);
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
      case DslPackage.CUSTOM_OPERATION__PREFIX_OPERAND:
        return getPrefixOperand();
      case DslPackage.CUSTOM_OPERATION__DEFINITION:
        if (resolve) return getDefinition();
        return basicGetDefinition();
      case DslPackage.CUSTOM_OPERATION__POSTFIX_OPERAND:
        return getPostfixOperand();
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
      case DslPackage.CUSTOM_OPERATION__PREFIX_OPERAND:
        setPrefixOperand((ValueOrEnumValueOrOperationCollection)newValue);
        return;
      case DslPackage.CUSTOM_OPERATION__DEFINITION:
        setDefinition((OperationDefinition)newValue);
        return;
      case DslPackage.CUSTOM_OPERATION__POSTFIX_OPERAND:
        setPostfixOperand((ValueOrEnumValueOrOperationCollection)newValue);
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
      case DslPackage.CUSTOM_OPERATION__PREFIX_OPERAND:
        setPrefixOperand((ValueOrEnumValueOrOperationCollection)null);
        return;
      case DslPackage.CUSTOM_OPERATION__DEFINITION:
        setDefinition((OperationDefinition)null);
        return;
      case DslPackage.CUSTOM_OPERATION__POSTFIX_OPERAND:
        setPostfixOperand((ValueOrEnumValueOrOperationCollection)null);
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
      case DslPackage.CUSTOM_OPERATION__PREFIX_OPERAND:
        return prefixOperand != null;
      case DslPackage.CUSTOM_OPERATION__DEFINITION:
        return definition != null;
      case DslPackage.CUSTOM_OPERATION__POSTFIX_OPERAND:
        return postfixOperand != null;
    }
    return super.eIsSet(featureID);
  }

} //CustomOperationImpl
