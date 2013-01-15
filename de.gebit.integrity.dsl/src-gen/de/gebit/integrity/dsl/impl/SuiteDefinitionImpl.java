/**
 */
package de.gebit.integrity.dsl.impl;

import de.gebit.integrity.dsl.ConstantEntity;
import de.gebit.integrity.dsl.DslPackage;
import de.gebit.integrity.dsl.SuiteDefinition;
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
 * <ul>
 *   <li>{@link de.gebit.integrity.dsl.impl.SuiteDefinitionImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.impl.SuiteDefinitionImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.impl.SuiteDefinitionImpl#getDependencies <em>Dependencies</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.impl.SuiteDefinitionImpl#getFinalizers <em>Finalizers</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.impl.SuiteDefinitionImpl#getStatements <em>Statements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SuiteDefinitionImpl extends PackageStatementImpl implements SuiteDefinition
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
   * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParameters()
   * @generated
   * @ordered
   */
  protected EList<ConstantEntity> parameters;

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
  public EList<ConstantEntity> getParameters()
  {
    if (parameters == null)
    {
      parameters = new EObjectContainmentEList<ConstantEntity>(ConstantEntity.class, this, DslPackage.SUITE_DEFINITION__PARAMETERS);
    }
    return parameters;
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
      case DslPackage.SUITE_DEFINITION__NAME:
        return getName();
      case DslPackage.SUITE_DEFINITION__PARAMETERS:
        return getParameters();
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
      case DslPackage.SUITE_DEFINITION__NAME:
        setName((String)newValue);
        return;
      case DslPackage.SUITE_DEFINITION__PARAMETERS:
        getParameters().clear();
        getParameters().addAll((Collection<? extends ConstantEntity>)newValue);
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
      case DslPackage.SUITE_DEFINITION__NAME:
        setName(NAME_EDEFAULT);
        return;
      case DslPackage.SUITE_DEFINITION__PARAMETERS:
        getParameters().clear();
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
      case DslPackage.SUITE_DEFINITION__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case DslPackage.SUITE_DEFINITION__PARAMETERS:
        return parameters != null && !parameters.isEmpty();
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
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //SuiteDefinitionImpl
