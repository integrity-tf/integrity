/**
 */
package de.gebit.integrity.dsl.impl;

import de.gebit.integrity.dsl.Call;
import de.gebit.integrity.dsl.CallDefinition;
import de.gebit.integrity.dsl.DslPackage;
import de.gebit.integrity.dsl.ExecutionMultiplier;
import de.gebit.integrity.dsl.NamedCallResult;
import de.gebit.integrity.dsl.Parameter;
import de.gebit.integrity.dsl.VariableVariable;

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
 * An implementation of the model object '<em><b>Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.impl.CallImpl#getMultiplier <em>Multiplier</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.impl.CallImpl#getDefinition <em>Definition</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.impl.CallImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.impl.CallImpl#getResults <em>Results</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.impl.CallImpl#getResult <em>Result</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CallImpl extends SuiteStatementWithResultImpl implements Call
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
  protected CallDefinition definition;

  /**
   * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParameters()
   * @generated
   * @ordered
   */
  protected EList<Parameter> parameters;

  /**
   * The cached value of the '{@link #getResults() <em>Results</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getResults()
   * @generated
   * @ordered
   */
  protected EList<NamedCallResult> results;

  /**
   * The cached value of the '{@link #getResult() <em>Result</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getResult()
   * @generated
   * @ordered
   */
  protected VariableVariable result;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CallImpl()
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
    return DslPackage.Literals.CALL;
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DslPackage.CALL__MULTIPLIER, oldMultiplier, newMultiplier);
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
        msgs = ((InternalEObject)multiplier).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DslPackage.CALL__MULTIPLIER, null, msgs);
      if (newMultiplier != null)
        msgs = ((InternalEObject)newMultiplier).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DslPackage.CALL__MULTIPLIER, null, msgs);
      msgs = basicSetMultiplier(newMultiplier, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.CALL__MULTIPLIER, newMultiplier, newMultiplier));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CallDefinition getDefinition()
  {
    if (definition != null && definition.eIsProxy())
    {
      InternalEObject oldDefinition = (InternalEObject)definition;
      definition = (CallDefinition)eResolveProxy(oldDefinition);
      if (definition != oldDefinition)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, DslPackage.CALL__DEFINITION, oldDefinition, definition));
      }
    }
    return definition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CallDefinition basicGetDefinition()
  {
    return definition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDefinition(CallDefinition newDefinition)
  {
    CallDefinition oldDefinition = definition;
    definition = newDefinition;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.CALL__DEFINITION, oldDefinition, definition));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Parameter> getParameters()
  {
    if (parameters == null)
    {
      parameters = new EObjectContainmentEList<Parameter>(Parameter.class, this, DslPackage.CALL__PARAMETERS);
    }
    return parameters;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<NamedCallResult> getResults()
  {
    if (results == null)
    {
      results = new EObjectContainmentEList<NamedCallResult>(NamedCallResult.class, this, DslPackage.CALL__RESULTS);
    }
    return results;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VariableVariable getResult()
  {
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetResult(VariableVariable newResult, NotificationChain msgs)
  {
    VariableVariable oldResult = result;
    result = newResult;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DslPackage.CALL__RESULT, oldResult, newResult);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setResult(VariableVariable newResult)
  {
    if (newResult != result)
    {
      NotificationChain msgs = null;
      if (result != null)
        msgs = ((InternalEObject)result).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DslPackage.CALL__RESULT, null, msgs);
      if (newResult != null)
        msgs = ((InternalEObject)newResult).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DslPackage.CALL__RESULT, null, msgs);
      msgs = basicSetResult(newResult, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.CALL__RESULT, newResult, newResult));
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
      case DslPackage.CALL__MULTIPLIER:
        return basicSetMultiplier(null, msgs);
      case DslPackage.CALL__PARAMETERS:
        return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
      case DslPackage.CALL__RESULTS:
        return ((InternalEList<?>)getResults()).basicRemove(otherEnd, msgs);
      case DslPackage.CALL__RESULT:
        return basicSetResult(null, msgs);
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
      case DslPackage.CALL__MULTIPLIER:
        return getMultiplier();
      case DslPackage.CALL__DEFINITION:
        if (resolve) return getDefinition();
        return basicGetDefinition();
      case DslPackage.CALL__PARAMETERS:
        return getParameters();
      case DslPackage.CALL__RESULTS:
        return getResults();
      case DslPackage.CALL__RESULT:
        return getResult();
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
      case DslPackage.CALL__MULTIPLIER:
        setMultiplier((ExecutionMultiplier)newValue);
        return;
      case DslPackage.CALL__DEFINITION:
        setDefinition((CallDefinition)newValue);
        return;
      case DslPackage.CALL__PARAMETERS:
        getParameters().clear();
        getParameters().addAll((Collection<? extends Parameter>)newValue);
        return;
      case DslPackage.CALL__RESULTS:
        getResults().clear();
        getResults().addAll((Collection<? extends NamedCallResult>)newValue);
        return;
      case DslPackage.CALL__RESULT:
        setResult((VariableVariable)newValue);
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
      case DslPackage.CALL__MULTIPLIER:
        setMultiplier((ExecutionMultiplier)null);
        return;
      case DslPackage.CALL__DEFINITION:
        setDefinition((CallDefinition)null);
        return;
      case DslPackage.CALL__PARAMETERS:
        getParameters().clear();
        return;
      case DslPackage.CALL__RESULTS:
        getResults().clear();
        return;
      case DslPackage.CALL__RESULT:
        setResult((VariableVariable)null);
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
      case DslPackage.CALL__MULTIPLIER:
        return multiplier != null;
      case DslPackage.CALL__DEFINITION:
        return definition != null;
      case DslPackage.CALL__PARAMETERS:
        return parameters != null && !parameters.isEmpty();
      case DslPackage.CALL__RESULTS:
        return results != null && !results.isEmpty();
      case DslPackage.CALL__RESULT:
        return result != null;
    }
    return super.eIsSet(featureID);
  }

} //CallImpl
