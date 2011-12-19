/**
 * <copyright>
 * </copyright>
 *

 */
package de.integrity.dsl.impl;

import de.integrity.dsl.DslPackage;
import de.integrity.dsl.Parameter;
import de.integrity.dsl.ParameterTableHeader;
import de.integrity.dsl.TableTest;
import de.integrity.dsl.TableTestRow;
import de.integrity.dsl.TestDefinition;

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
 * An implementation of the model object '<em><b>Table Test</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.integrity.dsl.impl.TableTestImpl#getDefinition <em>Definition</em>}</li>
 *   <li>{@link de.integrity.dsl.impl.TableTestImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link de.integrity.dsl.impl.TableTestImpl#getHeaders <em>Headers</em>}</li>
 *   <li>{@link de.integrity.dsl.impl.TableTestImpl#getRows <em>Rows</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TableTestImpl extends SuiteStatementWithResultImpl implements TableTest
{
  /**
   * The cached value of the '{@link #getDefinition() <em>Definition</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDefinition()
   * @generated
   * @ordered
   */
  protected TestDefinition definition;

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
   * The cached value of the '{@link #getHeaders() <em>Headers</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getHeaders()
   * @generated
   * @ordered
   */
  protected EList<ParameterTableHeader> headers;

  /**
   * The cached value of the '{@link #getRows() <em>Rows</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRows()
   * @generated
   * @ordered
   */
  protected EList<TableTestRow> rows;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TableTestImpl()
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
    return DslPackage.Literals.TABLE_TEST;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TestDefinition getDefinition()
  {
    if (definition != null && definition.eIsProxy())
    {
      InternalEObject oldDefinition = (InternalEObject)definition;
      definition = (TestDefinition)eResolveProxy(oldDefinition);
      if (definition != oldDefinition)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, DslPackage.TABLE_TEST__DEFINITION, oldDefinition, definition));
      }
    }
    return definition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TestDefinition basicGetDefinition()
  {
    return definition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDefinition(TestDefinition newDefinition)
  {
    TestDefinition oldDefinition = definition;
    definition = newDefinition;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.TABLE_TEST__DEFINITION, oldDefinition, definition));
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
      parameters = new EObjectContainmentEList<Parameter>(Parameter.class, this, DslPackage.TABLE_TEST__PARAMETERS);
    }
    return parameters;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ParameterTableHeader> getHeaders()
  {
    if (headers == null)
    {
      headers = new EObjectContainmentEList<ParameterTableHeader>(ParameterTableHeader.class, this, DslPackage.TABLE_TEST__HEADERS);
    }
    return headers;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TableTestRow> getRows()
  {
    if (rows == null)
    {
      rows = new EObjectContainmentEList<TableTestRow>(TableTestRow.class, this, DslPackage.TABLE_TEST__ROWS);
    }
    return rows;
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
      case DslPackage.TABLE_TEST__PARAMETERS:
        return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
      case DslPackage.TABLE_TEST__HEADERS:
        return ((InternalEList<?>)getHeaders()).basicRemove(otherEnd, msgs);
      case DslPackage.TABLE_TEST__ROWS:
        return ((InternalEList<?>)getRows()).basicRemove(otherEnd, msgs);
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
      case DslPackage.TABLE_TEST__DEFINITION:
        if (resolve) return getDefinition();
        return basicGetDefinition();
      case DslPackage.TABLE_TEST__PARAMETERS:
        return getParameters();
      case DslPackage.TABLE_TEST__HEADERS:
        return getHeaders();
      case DslPackage.TABLE_TEST__ROWS:
        return getRows();
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
      case DslPackage.TABLE_TEST__DEFINITION:
        setDefinition((TestDefinition)newValue);
        return;
      case DslPackage.TABLE_TEST__PARAMETERS:
        getParameters().clear();
        getParameters().addAll((Collection<? extends Parameter>)newValue);
        return;
      case DslPackage.TABLE_TEST__HEADERS:
        getHeaders().clear();
        getHeaders().addAll((Collection<? extends ParameterTableHeader>)newValue);
        return;
      case DslPackage.TABLE_TEST__ROWS:
        getRows().clear();
        getRows().addAll((Collection<? extends TableTestRow>)newValue);
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
      case DslPackage.TABLE_TEST__DEFINITION:
        setDefinition((TestDefinition)null);
        return;
      case DslPackage.TABLE_TEST__PARAMETERS:
        getParameters().clear();
        return;
      case DslPackage.TABLE_TEST__HEADERS:
        getHeaders().clear();
        return;
      case DslPackage.TABLE_TEST__ROWS:
        getRows().clear();
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
      case DslPackage.TABLE_TEST__DEFINITION:
        return definition != null;
      case DslPackage.TABLE_TEST__PARAMETERS:
        return parameters != null && !parameters.isEmpty();
      case DslPackage.TABLE_TEST__HEADERS:
        return headers != null && !headers.isEmpty();
      case DslPackage.TABLE_TEST__ROWS:
        return rows != null && !rows.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //TableTestImpl
