/**
 */
package de.gebit.integrity.dsl.impl;

import de.gebit.integrity.dsl.DslPackage;
import de.gebit.integrity.dsl.SuiteDefinition;
import de.gebit.integrity.dsl.SuiteParameterDefinition;
import de.gebit.integrity.dsl.SuiteReturnDefinition;
import de.gebit.integrity.dsl.SuiteStatement;

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
 * An implementation of the model object '<em><b>Suite Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.impl.SuiteDefinitionImpl#getPrivate <em>Private</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.impl.SuiteDefinitionImpl#getSingleRun <em>Single Run</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.impl.SuiteDefinitionImpl#getInlined <em>Inlined</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.impl.SuiteDefinitionImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.impl.SuiteDefinitionImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.impl.SuiteDefinitionImpl#getReturn <em>Return</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.impl.SuiteDefinitionImpl#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.impl.SuiteDefinitionImpl#getFinalizers <em>Finalizers</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.impl.SuiteDefinitionImpl#getStatements <em>Statements</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SuiteDefinitionImpl extends PackageStatementImpl implements SuiteDefinition
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
   * The default value of the '{@link #getSingleRun() <em>Single Run</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSingleRun()
   * @generated
   * @ordered
   */
  protected static final String SINGLE_RUN_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getSingleRun() <em>Single Run</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSingleRun()
   * @generated
   * @ordered
   */
  protected String singleRun = SINGLE_RUN_EDEFAULT;

  /**
   * The default value of the '{@link #getInlined() <em>Inlined</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInlined()
   * @generated
   * @ordered
   */
  protected static final String INLINED_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getInlined() <em>Inlined</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInlined()
   * @generated
   * @ordered
   */
  protected String inlined = INLINED_EDEFAULT;

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
   * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParameters()
   * @generated
   * @ordered
   */
  protected EList<SuiteParameterDefinition> parameters;

  /**
   * The cached value of the '{@link #getReturn() <em>Return</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReturn()
   * @generated
   * @ordered
   */
  protected EList<SuiteReturnDefinition> return_;

  /**
   * The cached value of the '{@link #getDependencies() <em>Dependencies</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDependencies()
   * @generated
   * @ordered
   */
  protected EList<SuiteDefinition> dependencies;

  /**
   * The cached value of the '{@link #getFinalizers() <em>Finalizers</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFinalizers()
   * @generated
   * @ordered
   */
  protected EList<SuiteDefinition> finalizers;

  /**
   * The cached value of the '{@link #getStatements() <em>Statements</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStatements()
   * @generated
   * @ordered
   */
  protected EList<SuiteStatement> statements;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SuiteDefinitionImpl()
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
    return DslPackage.Literals.SUITE_DEFINITION;
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
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.SUITE_DEFINITION__PRIVATE, oldPrivate, private_));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getSingleRun()
  {
    return singleRun;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSingleRun(String newSingleRun)
  {
    String oldSingleRun = singleRun;
    singleRun = newSingleRun;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.SUITE_DEFINITION__SINGLE_RUN, oldSingleRun, singleRun));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getInlined()
  {
    return inlined;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInlined(String newInlined)
  {
    String oldInlined = inlined;
    inlined = newInlined;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.SUITE_DEFINITION__INLINED, oldInlined, inlined));
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
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.SUITE_DEFINITION__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SuiteParameterDefinition> getParameters()
  {
    if (parameters == null)
    {
      parameters = new EObjectContainmentEList<SuiteParameterDefinition>(SuiteParameterDefinition.class, this, DslPackage.SUITE_DEFINITION__PARAMETERS);
    }
    return parameters;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SuiteReturnDefinition> getReturn()
  {
    if (return_ == null)
    {
      return_ = new EObjectContainmentEList<SuiteReturnDefinition>(SuiteReturnDefinition.class, this, DslPackage.SUITE_DEFINITION__RETURN);
    }
    return return_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SuiteDefinition> getDependencies()
  {
    if (dependencies == null)
    {
      dependencies = new EObjectResolvingEList<SuiteDefinition>(SuiteDefinition.class, this, DslPackage.SUITE_DEFINITION__DEPENDENCIES);
    }
    return dependencies;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SuiteDefinition> getFinalizers()
  {
    if (finalizers == null)
    {
      finalizers = new EObjectResolvingEList<SuiteDefinition>(SuiteDefinition.class, this, DslPackage.SUITE_DEFINITION__FINALIZERS);
    }
    return finalizers;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SuiteStatement> getStatements()
  {
    if (statements == null)
    {
      statements = new EObjectContainmentEList<SuiteStatement>(SuiteStatement.class, this, DslPackage.SUITE_DEFINITION__STATEMENTS);
    }
    return statements;
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
      case DslPackage.SUITE_DEFINITION__PARAMETERS:
        return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
      case DslPackage.SUITE_DEFINITION__RETURN:
        return ((InternalEList<?>)getReturn()).basicRemove(otherEnd, msgs);
      case DslPackage.SUITE_DEFINITION__STATEMENTS:
        return ((InternalEList<?>)getStatements()).basicRemove(otherEnd, msgs);
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
      case DslPackage.SUITE_DEFINITION__PRIVATE:
        return getPrivate();
      case DslPackage.SUITE_DEFINITION__SINGLE_RUN:
        return getSingleRun();
      case DslPackage.SUITE_DEFINITION__INLINED:
        return getInlined();
      case DslPackage.SUITE_DEFINITION__NAME:
        return getName();
      case DslPackage.SUITE_DEFINITION__PARAMETERS:
        return getParameters();
      case DslPackage.SUITE_DEFINITION__RETURN:
        return getReturn();
      case DslPackage.SUITE_DEFINITION__DEPENDENCIES:
        return getDependencies();
      case DslPackage.SUITE_DEFINITION__FINALIZERS:
        return getFinalizers();
      case DslPackage.SUITE_DEFINITION__STATEMENTS:
        return getStatements();
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
      case DslPackage.SUITE_DEFINITION__PRIVATE:
        setPrivate((String)newValue);
        return;
      case DslPackage.SUITE_DEFINITION__SINGLE_RUN:
        setSingleRun((String)newValue);
        return;
      case DslPackage.SUITE_DEFINITION__INLINED:
        setInlined((String)newValue);
        return;
      case DslPackage.SUITE_DEFINITION__NAME:
        setName((String)newValue);
        return;
      case DslPackage.SUITE_DEFINITION__PARAMETERS:
        getParameters().clear();
        getParameters().addAll((Collection<? extends SuiteParameterDefinition>)newValue);
        return;
      case DslPackage.SUITE_DEFINITION__RETURN:
        getReturn().clear();
        getReturn().addAll((Collection<? extends SuiteReturnDefinition>)newValue);
        return;
      case DslPackage.SUITE_DEFINITION__DEPENDENCIES:
        getDependencies().clear();
        getDependencies().addAll((Collection<? extends SuiteDefinition>)newValue);
        return;
      case DslPackage.SUITE_DEFINITION__FINALIZERS:
        getFinalizers().clear();
        getFinalizers().addAll((Collection<? extends SuiteDefinition>)newValue);
        return;
      case DslPackage.SUITE_DEFINITION__STATEMENTS:
        getStatements().clear();
        getStatements().addAll((Collection<? extends SuiteStatement>)newValue);
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
      case DslPackage.SUITE_DEFINITION__PRIVATE:
        setPrivate(PRIVATE_EDEFAULT);
        return;
      case DslPackage.SUITE_DEFINITION__SINGLE_RUN:
        setSingleRun(SINGLE_RUN_EDEFAULT);
        return;
      case DslPackage.SUITE_DEFINITION__INLINED:
        setInlined(INLINED_EDEFAULT);
        return;
      case DslPackage.SUITE_DEFINITION__NAME:
        setName(NAME_EDEFAULT);
        return;
      case DslPackage.SUITE_DEFINITION__PARAMETERS:
        getParameters().clear();
        return;
      case DslPackage.SUITE_DEFINITION__RETURN:
        getReturn().clear();
        return;
      case DslPackage.SUITE_DEFINITION__DEPENDENCIES:
        getDependencies().clear();
        return;
      case DslPackage.SUITE_DEFINITION__FINALIZERS:
        getFinalizers().clear();
        return;
      case DslPackage.SUITE_DEFINITION__STATEMENTS:
        getStatements().clear();
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
      case DslPackage.SUITE_DEFINITION__PRIVATE:
        return PRIVATE_EDEFAULT == null ? private_ != null : !PRIVATE_EDEFAULT.equals(private_);
      case DslPackage.SUITE_DEFINITION__SINGLE_RUN:
        return SINGLE_RUN_EDEFAULT == null ? singleRun != null : !SINGLE_RUN_EDEFAULT.equals(singleRun);
      case DslPackage.SUITE_DEFINITION__INLINED:
        return INLINED_EDEFAULT == null ? inlined != null : !INLINED_EDEFAULT.equals(inlined);
      case DslPackage.SUITE_DEFINITION__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case DslPackage.SUITE_DEFINITION__PARAMETERS:
        return parameters != null && !parameters.isEmpty();
      case DslPackage.SUITE_DEFINITION__RETURN:
        return return_ != null && !return_.isEmpty();
      case DslPackage.SUITE_DEFINITION__DEPENDENCIES:
        return dependencies != null && !dependencies.isEmpty();
      case DslPackage.SUITE_DEFINITION__FINALIZERS:
        return finalizers != null && !finalizers.isEmpty();
      case DslPackage.SUITE_DEFINITION__STATEMENTS:
        return statements != null && !statements.isEmpty();
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
    result.append(", singleRun: ");
    result.append(singleRun);
    result.append(", inlined: ");
    result.append(inlined);
    result.append(", name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //SuiteDefinitionImpl
