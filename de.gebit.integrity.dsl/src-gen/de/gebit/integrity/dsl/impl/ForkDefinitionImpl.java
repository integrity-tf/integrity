/**
 */
package de.gebit.integrity.dsl.impl;

import de.gebit.integrity.dsl.DslPackage;
import de.gebit.integrity.dsl.ForkDefinition;
import de.gebit.integrity.dsl.ForkParameter;
import de.gebit.integrity.dsl.JavaClassReference;

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
 * An implementation of the model object '<em><b>Fork Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.impl.ForkDefinitionImpl#getPrivate <em>Private</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.impl.ForkDefinitionImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.impl.ForkDefinitionImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.impl.ForkDefinitionImpl#getForkerClass <em>Forker Class</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.impl.ForkDefinitionImpl#getParameters <em>Parameters</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ForkDefinitionImpl extends StatementImpl implements ForkDefinition
{
  /**
   * The default value of the '{@link #getPrivate() <em>Private</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPrivate()
   * @generated
   * @ordered
   */
  protected static final String PRIVATE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getPrivate() <em>Private</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPrivate()
   * @generated
   * @ordered
   */
  protected String private_ = PRIVATE_EDEFAULT;

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
   * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected static final String DESCRIPTION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected String description = DESCRIPTION_EDEFAULT;

  /**
   * The cached value of the '{@link #getForkerClass() <em>Forker Class</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getForkerClass()
   * @generated
   * @ordered
   */
  protected JavaClassReference forkerClass;

  /**
   * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParameters()
   * @generated
   * @ordered
   */
  protected EList<ForkParameter> parameters;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ForkDefinitionImpl()
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
    return DslPackage.Literals.FORK_DEFINITION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getPrivate()
  {
    return private_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPrivate(String newPrivate)
  {
    String oldPrivate = private_;
    private_ = newPrivate;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.FORK_DEFINITION__PRIVATE, oldPrivate, private_));
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
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.FORK_DEFINITION__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDescription()
  {
    return description;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDescription(String newDescription)
  {
    String oldDescription = description;
    description = newDescription;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.FORK_DEFINITION__DESCRIPTION, oldDescription, description));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JavaClassReference getForkerClass()
  {
    return forkerClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetForkerClass(JavaClassReference newForkerClass, NotificationChain msgs)
  {
    JavaClassReference oldForkerClass = forkerClass;
    forkerClass = newForkerClass;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DslPackage.FORK_DEFINITION__FORKER_CLASS, oldForkerClass, newForkerClass);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setForkerClass(JavaClassReference newForkerClass)
  {
    if (newForkerClass != forkerClass)
    {
      NotificationChain msgs = null;
      if (forkerClass != null)
        msgs = ((InternalEObject)forkerClass).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DslPackage.FORK_DEFINITION__FORKER_CLASS, null, msgs);
      if (newForkerClass != null)
        msgs = ((InternalEObject)newForkerClass).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DslPackage.FORK_DEFINITION__FORKER_CLASS, null, msgs);
      msgs = basicSetForkerClass(newForkerClass, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.FORK_DEFINITION__FORKER_CLASS, newForkerClass, newForkerClass));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ForkParameter> getParameters()
  {
    if (parameters == null)
    {
      parameters = new EObjectContainmentEList<ForkParameter>(ForkParameter.class, this, DslPackage.FORK_DEFINITION__PARAMETERS);
    }
    return parameters;
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
      case DslPackage.FORK_DEFINITION__FORKER_CLASS:
        return basicSetForkerClass(null, msgs);
      case DslPackage.FORK_DEFINITION__PARAMETERS:
        return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
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
      case DslPackage.FORK_DEFINITION__PRIVATE:
        return getPrivate();
      case DslPackage.FORK_DEFINITION__NAME:
        return getName();
      case DslPackage.FORK_DEFINITION__DESCRIPTION:
        return getDescription();
      case DslPackage.FORK_DEFINITION__FORKER_CLASS:
        return getForkerClass();
      case DslPackage.FORK_DEFINITION__PARAMETERS:
        return getParameters();
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
      case DslPackage.FORK_DEFINITION__PRIVATE:
        setPrivate((String)newValue);
        return;
      case DslPackage.FORK_DEFINITION__NAME:
        setName((String)newValue);
        return;
      case DslPackage.FORK_DEFINITION__DESCRIPTION:
        setDescription((String)newValue);
        return;
      case DslPackage.FORK_DEFINITION__FORKER_CLASS:
        setForkerClass((JavaClassReference)newValue);
        return;
      case DslPackage.FORK_DEFINITION__PARAMETERS:
        getParameters().clear();
        getParameters().addAll((Collection<? extends ForkParameter>)newValue);
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
      case DslPackage.FORK_DEFINITION__PRIVATE:
        setPrivate(PRIVATE_EDEFAULT);
        return;
      case DslPackage.FORK_DEFINITION__NAME:
        setName(NAME_EDEFAULT);
        return;
      case DslPackage.FORK_DEFINITION__DESCRIPTION:
        setDescription(DESCRIPTION_EDEFAULT);
        return;
      case DslPackage.FORK_DEFINITION__FORKER_CLASS:
        setForkerClass((JavaClassReference)null);
        return;
      case DslPackage.FORK_DEFINITION__PARAMETERS:
        getParameters().clear();
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
      case DslPackage.FORK_DEFINITION__PRIVATE:
        return PRIVATE_EDEFAULT == null ? private_ != null : !PRIVATE_EDEFAULT.equals(private_);
      case DslPackage.FORK_DEFINITION__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case DslPackage.FORK_DEFINITION__DESCRIPTION:
        return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
      case DslPackage.FORK_DEFINITION__FORKER_CLASS:
        return forkerClass != null;
      case DslPackage.FORK_DEFINITION__PARAMETERS:
        return parameters != null && !parameters.isEmpty();
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
    result.append(" (private: ");
    result.append(private_);
    result.append(", name: ");
    result.append(name);
    result.append(", description: ");
    result.append(description);
    result.append(')');
    return result.toString();
  }

} //ForkDefinitionImpl
