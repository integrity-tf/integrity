/**
 */
package de.gebit.integrity.dsl.impl;

import de.gebit.integrity.dsl.DslPackage;
import de.gebit.integrity.dsl.OperationDefinition;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.xtext.common.types.JvmType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.impl.OperationDefinitionImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.impl.OperationDefinitionImpl#getOperationType <em>Operation Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OperationDefinitionImpl extends PackageStatementImpl implements OperationDefinition
{
  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getOperationType() <em>Operation Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperationType()
   * @generated
   * @ordered
   */
  protected JvmType operationType;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected OperationDefinitionImpl()
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
    return DslPackage.Literals.OPERATION_DEFINITION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.OPERATION_DEFINITION__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JvmType getOperationType()
  {
    if (operationType != null && operationType.eIsProxy())
    {
      InternalEObject oldOperationType = (InternalEObject)operationType;
      operationType = (JvmType)eResolveProxy(oldOperationType);
      if (operationType != oldOperationType)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, DslPackage.OPERATION_DEFINITION__OPERATION_TYPE, oldOperationType, operationType));
      }
    }
    return operationType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JvmType basicGetOperationType()
  {
    return operationType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOperationType(JvmType newOperationType)
  {
    JvmType oldOperationType = operationType;
    operationType = newOperationType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.OPERATION_DEFINITION__OPERATION_TYPE, oldOperationType, operationType));
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
      case DslPackage.OPERATION_DEFINITION__NAME:
        return getName();
      case DslPackage.OPERATION_DEFINITION__OPERATION_TYPE:
        if (resolve) return getOperationType();
        return basicGetOperationType();
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
      case DslPackage.OPERATION_DEFINITION__NAME:
        setName((String)newValue);
        return;
      case DslPackage.OPERATION_DEFINITION__OPERATION_TYPE:
        setOperationType((JvmType)newValue);
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
      case DslPackage.OPERATION_DEFINITION__NAME:
        setName(NAME_EDEFAULT);
        return;
      case DslPackage.OPERATION_DEFINITION__OPERATION_TYPE:
        setOperationType((JvmType)null);
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
      case DslPackage.OPERATION_DEFINITION__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case DslPackage.OPERATION_DEFINITION__OPERATION_TYPE:
        return operationType != null;
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
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //OperationDefinitionImpl
