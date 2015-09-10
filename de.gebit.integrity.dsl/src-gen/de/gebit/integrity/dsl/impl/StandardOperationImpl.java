/**
 */
package de.gebit.integrity.dsl.impl;

import de.gebit.integrity.dsl.DslPackage;
import de.gebit.integrity.dsl.StandardOperation;
import de.gebit.integrity.dsl.ValueOrEnumValueOrOperation;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Standard Operation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.impl.StandardOperationImpl#getFirstOperand <em>First Operand</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.impl.StandardOperationImpl#getOperators <em>Operators</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.impl.StandardOperationImpl#getMoreOperands <em>More Operands</em>}</li>
 * </ul>
 *
 * @generated
 */
public class StandardOperationImpl extends OperationImpl implements StandardOperation
{
  /**
   * The cached value of the '{@link #getFirstOperand() <em>First Operand</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFirstOperand()
   * @generated
   * @ordered
   */
  protected ValueOrEnumValueOrOperation firstOperand;

  /**
   * The cached value of the '{@link #getOperators() <em>Operators</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOperators()
   * @generated
   * @ordered
   */
  protected EList<String> operators;

  /**
   * The cached value of the '{@link #getMoreOperands() <em>More Operands</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMoreOperands()
   * @generated
   * @ordered
   */
  protected EList<ValueOrEnumValueOrOperation> moreOperands;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected StandardOperationImpl()
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
    return DslPackage.Literals.STANDARD_OPERATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ValueOrEnumValueOrOperation getFirstOperand()
  {
    return firstOperand;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFirstOperand(ValueOrEnumValueOrOperation newFirstOperand, NotificationChain msgs)
  {
    ValueOrEnumValueOrOperation oldFirstOperand = firstOperand;
    firstOperand = newFirstOperand;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DslPackage.STANDARD_OPERATION__FIRST_OPERAND, oldFirstOperand, newFirstOperand);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFirstOperand(ValueOrEnumValueOrOperation newFirstOperand)
  {
    if (newFirstOperand != firstOperand)
    {
      NotificationChain msgs = null;
      if (firstOperand != null)
        msgs = ((InternalEObject)firstOperand).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DslPackage.STANDARD_OPERATION__FIRST_OPERAND, null, msgs);
      if (newFirstOperand != null)
        msgs = ((InternalEObject)newFirstOperand).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DslPackage.STANDARD_OPERATION__FIRST_OPERAND, null, msgs);
      msgs = basicSetFirstOperand(newFirstOperand, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.STANDARD_OPERATION__FIRST_OPERAND, newFirstOperand, newFirstOperand));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getOperators()
  {
    if (operators == null)
    {
      operators = new EDataTypeEList<String>(String.class, this, DslPackage.STANDARD_OPERATION__OPERATORS);
    }
    return operators;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ValueOrEnumValueOrOperation> getMoreOperands()
  {
    if (moreOperands == null)
    {
      moreOperands = new EObjectContainmentEList<ValueOrEnumValueOrOperation>(ValueOrEnumValueOrOperation.class, this, DslPackage.STANDARD_OPERATION__MORE_OPERANDS);
    }
    return moreOperands;
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
      case DslPackage.STANDARD_OPERATION__FIRST_OPERAND:
        return basicSetFirstOperand(null, msgs);
      case DslPackage.STANDARD_OPERATION__MORE_OPERANDS:
        return ((InternalEList<?>)getMoreOperands()).basicRemove(otherEnd, msgs);
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
      case DslPackage.STANDARD_OPERATION__FIRST_OPERAND:
        return getFirstOperand();
      case DslPackage.STANDARD_OPERATION__OPERATORS:
        return getOperators();
      case DslPackage.STANDARD_OPERATION__MORE_OPERANDS:
        return getMoreOperands();
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
      case DslPackage.STANDARD_OPERATION__FIRST_OPERAND:
        setFirstOperand((ValueOrEnumValueOrOperation)newValue);
        return;
      case DslPackage.STANDARD_OPERATION__OPERATORS:
        getOperators().clear();
        getOperators().addAll((Collection<? extends String>)newValue);
        return;
      case DslPackage.STANDARD_OPERATION__MORE_OPERANDS:
        getMoreOperands().clear();
        getMoreOperands().addAll((Collection<? extends ValueOrEnumValueOrOperation>)newValue);
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
      case DslPackage.STANDARD_OPERATION__FIRST_OPERAND:
        setFirstOperand((ValueOrEnumValueOrOperation)null);
        return;
      case DslPackage.STANDARD_OPERATION__OPERATORS:
        getOperators().clear();
        return;
      case DslPackage.STANDARD_OPERATION__MORE_OPERANDS:
        getMoreOperands().clear();
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
      case DslPackage.STANDARD_OPERATION__FIRST_OPERAND:
        return firstOperand != null;
      case DslPackage.STANDARD_OPERATION__OPERATORS:
        return operators != null && !operators.isEmpty();
      case DslPackage.STANDARD_OPERATION__MORE_OPERANDS:
        return moreOperands != null && !moreOperands.isEmpty();
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
    result.append(" (operators: ");
    result.append(operators);
    result.append(')');
    return result.toString();
  }

} //StandardOperationImpl
