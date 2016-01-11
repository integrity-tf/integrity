/**
 */
package de.gebit.integrity.dsl.impl;

import de.gebit.integrity.dsl.CallDefinition;
import de.gebit.integrity.dsl.DslPackage;
import de.gebit.integrity.dsl.MethodReference;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Call Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.impl.CallDefinitionImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.impl.CallDefinitionImpl#getFixtureMethod <em>Fixture Method</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CallDefinitionImpl extends PackageStatementImpl implements CallDefinition
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
   * The cached value of the '{@link #getFixtureMethod() <em>Fixture Method</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFixtureMethod()
   * @generated
   * @ordered
   */
  protected MethodReference fixtureMethod;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CallDefinitionImpl()
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
    return DslPackage.Literals.CALL_DEFINITION;
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
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.CALL_DEFINITION__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MethodReference getFixtureMethod()
  {
    return fixtureMethod;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFixtureMethod(MethodReference newFixtureMethod, NotificationChain msgs)
  {
    MethodReference oldFixtureMethod = fixtureMethod;
    fixtureMethod = newFixtureMethod;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DslPackage.CALL_DEFINITION__FIXTURE_METHOD, oldFixtureMethod, newFixtureMethod);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFixtureMethod(MethodReference newFixtureMethod)
  {
    if (newFixtureMethod != fixtureMethod)
    {
      NotificationChain msgs = null;
      if (fixtureMethod != null)
        msgs = ((InternalEObject)fixtureMethod).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DslPackage.CALL_DEFINITION__FIXTURE_METHOD, null, msgs);
      if (newFixtureMethod != null)
        msgs = ((InternalEObject)newFixtureMethod).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DslPackage.CALL_DEFINITION__FIXTURE_METHOD, null, msgs);
      msgs = basicSetFixtureMethod(newFixtureMethod, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.CALL_DEFINITION__FIXTURE_METHOD, newFixtureMethod, newFixtureMethod));
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
      case DslPackage.CALL_DEFINITION__FIXTURE_METHOD:
        return basicSetFixtureMethod(null, msgs);
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
      case DslPackage.CALL_DEFINITION__NAME:
        return getName();
      case DslPackage.CALL_DEFINITION__FIXTURE_METHOD:
        return getFixtureMethod();
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
      case DslPackage.CALL_DEFINITION__NAME:
        setName((String)newValue);
        return;
      case DslPackage.CALL_DEFINITION__FIXTURE_METHOD:
        setFixtureMethod((MethodReference)newValue);
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
      case DslPackage.CALL_DEFINITION__NAME:
        setName(NAME_EDEFAULT);
        return;
      case DslPackage.CALL_DEFINITION__FIXTURE_METHOD:
        setFixtureMethod((MethodReference)null);
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
      case DslPackage.CALL_DEFINITION__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case DslPackage.CALL_DEFINITION__FIXTURE_METHOD:
        return fixtureMethod != null;
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

} //CallDefinitionImpl
