/**
 */
package de.gebit.integrity.dsl.impl;

import de.gebit.integrity.dsl.DslPackage;
import de.gebit.integrity.dsl.ExecutionMultiplier;
import de.gebit.integrity.dsl.ForkDefinition;
import de.gebit.integrity.dsl.Suite;
import de.gebit.integrity.dsl.SuiteDefinition;
import de.gebit.integrity.dsl.SuiteParameter;
import de.gebit.integrity.dsl.VariantDefinition;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Suite</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.impl.SuiteImpl#getMultiplier <em>Multiplier</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.impl.SuiteImpl#getDefinition <em>Definition</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.impl.SuiteImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.impl.SuiteImpl#getFork <em>Fork</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.impl.SuiteImpl#getVariants <em>Variants</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SuiteImpl extends StatementImpl implements Suite
{
  /**
   * The cached value of the '{@link #getMultiplier() <em>Multiplier</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMultiplier()
   * @generated
   * @ordered
   */
  protected ExecutionMultiplier multiplier;

  /**
   * The cached value of the '{@link #getDefinition() <em>Definition</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDefinition()
   * @generated
   * @ordered
   */
  protected SuiteDefinition definition;

  /**
   * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParameters()
   * @generated
   * @ordered
   */
  protected EList<SuiteParameter> parameters;

  /**
   * The cached value of the '{@link #getFork() <em>Fork</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFork()
   * @generated
   * @ordered
   */
  protected ForkDefinition fork;

  /**
   * The cached value of the '{@link #getVariants() <em>Variants</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVariants()
   * @generated
   * @ordered
   */
  protected EList<VariantDefinition> variants;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SuiteImpl()
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
    return DslPackage.Literals.SUITE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExecutionMultiplier getMultiplier()
  {
    return multiplier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMultiplier(ExecutionMultiplier newMultiplier, NotificationChain msgs)
  {
    ExecutionMultiplier oldMultiplier = multiplier;
    multiplier = newMultiplier;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DslPackage.SUITE__MULTIPLIER, oldMultiplier, newMultiplier);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMultiplier(ExecutionMultiplier newMultiplier)
  {
    if (newMultiplier != multiplier)
    {
      NotificationChain msgs = null;
      if (multiplier != null)
        msgs = ((InternalEObject)multiplier).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DslPackage.SUITE__MULTIPLIER, null, msgs);
      if (newMultiplier != null)
        msgs = ((InternalEObject)newMultiplier).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DslPackage.SUITE__MULTIPLIER, null, msgs);
      msgs = basicSetMultiplier(newMultiplier, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.SUITE__MULTIPLIER, newMultiplier, newMultiplier));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SuiteDefinition getDefinition()
  {
    if (definition != null && definition.eIsProxy())
    {
      InternalEObject oldDefinition = (InternalEObject)definition;
      definition = (SuiteDefinition)eResolveProxy(oldDefinition);
      if (definition != oldDefinition)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, DslPackage.SUITE__DEFINITION, oldDefinition, definition));
      }
    }
    return definition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SuiteDefinition basicGetDefinition()
  {
    return definition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDefinition(SuiteDefinition newDefinition)
  {
    SuiteDefinition oldDefinition = definition;
    definition = newDefinition;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.SUITE__DEFINITION, oldDefinition, definition));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SuiteParameter> getParameters()
  {
    if (parameters == null)
    {
      parameters = new EObjectContainmentEList<SuiteParameter>(SuiteParameter.class, this, DslPackage.SUITE__PARAMETERS);
    }
    return parameters;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ForkDefinition getFork()
  {
    if (fork != null && fork.eIsProxy())
    {
      InternalEObject oldFork = (InternalEObject)fork;
      fork = (ForkDefinition)eResolveProxy(oldFork);
      if (fork != oldFork)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, DslPackage.SUITE__FORK, oldFork, fork));
      }
    }
    return fork;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ForkDefinition basicGetFork()
  {
    return fork;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFork(ForkDefinition newFork)
  {
    ForkDefinition oldFork = fork;
    fork = newFork;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.SUITE__FORK, oldFork, fork));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<VariantDefinition> getVariants()
  {
    if (variants == null)
    {
      variants = new EObjectResolvingEList<VariantDefinition>(VariantDefinition.class, this, DslPackage.SUITE__VARIANTS);
    }
    return variants;
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
      case DslPackage.SUITE__MULTIPLIER:
        return basicSetMultiplier(null, msgs);
      case DslPackage.SUITE__PARAMETERS:
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
      case DslPackage.SUITE__MULTIPLIER:
        return getMultiplier();
      case DslPackage.SUITE__DEFINITION:
        if (resolve) return getDefinition();
        return basicGetDefinition();
      case DslPackage.SUITE__PARAMETERS:
        return getParameters();
      case DslPackage.SUITE__FORK:
        if (resolve) return getFork();
        return basicGetFork();
      case DslPackage.SUITE__VARIANTS:
        return getVariants();
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
      case DslPackage.SUITE__MULTIPLIER:
        setMultiplier((ExecutionMultiplier)newValue);
        return;
      case DslPackage.SUITE__DEFINITION:
        setDefinition((SuiteDefinition)newValue);
        return;
      case DslPackage.SUITE__PARAMETERS:
        getParameters().clear();
        getParameters().addAll((Collection<? extends SuiteParameter>)newValue);
        return;
      case DslPackage.SUITE__FORK:
        setFork((ForkDefinition)newValue);
        return;
      case DslPackage.SUITE__VARIANTS:
        getVariants().clear();
        getVariants().addAll((Collection<? extends VariantDefinition>)newValue);
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
      case DslPackage.SUITE__MULTIPLIER:
        setMultiplier((ExecutionMultiplier)null);
        return;
      case DslPackage.SUITE__DEFINITION:
        setDefinition((SuiteDefinition)null);
        return;
      case DslPackage.SUITE__PARAMETERS:
        getParameters().clear();
        return;
      case DslPackage.SUITE__FORK:
        setFork((ForkDefinition)null);
        return;
      case DslPackage.SUITE__VARIANTS:
        getVariants().clear();
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
      case DslPackage.SUITE__MULTIPLIER:
        return multiplier != null;
      case DslPackage.SUITE__DEFINITION:
        return definition != null;
      case DslPackage.SUITE__PARAMETERS:
        return parameters != null && !parameters.isEmpty();
      case DslPackage.SUITE__FORK:
        return fork != null;
      case DslPackage.SUITE__VARIANTS:
        return variants != null && !variants.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //SuiteImpl
