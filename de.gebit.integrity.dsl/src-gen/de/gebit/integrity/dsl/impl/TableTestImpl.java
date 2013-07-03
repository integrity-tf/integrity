/**
 * <copyright>
 * </copyright>
 *

 */
package de.gebit.integrity.dsl.impl;

import de.gebit.integrity.dsl.DslPackage;
import de.gebit.integrity.dsl.Parameter;
import de.gebit.integrity.dsl.ParameterTableHeader;
import de.gebit.integrity.dsl.ResultTableHeader;
import de.gebit.integrity.dsl.TableTest;
import de.gebit.integrity.dsl.TableTestRow;
import de.gebit.integrity.dsl.TestDefinition;

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
 *   <li>{@link de.gebit.integrity.dsl.impl.TableTestImpl#getDefinition <em>Definition</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.impl.TableTestImpl#getParameters <em>Parameters</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.impl.TableTestImpl#getParameterHeaders <em>Parameter Headers</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.impl.TableTestImpl#getResultHeaders <em>Result Headers</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.impl.TableTestImpl#getDefaultResultColumn <em>Default Result Column</em>}</li>
 *   <li>{@link de.gebit.integrity.dsl.impl.TableTestImpl#getRows <em>Rows</em>}</li>
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
   * The cached value of the '{@link #getParameterHeaders() <em>Parameter Headers</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParameterHeaders()
   * @generated
   * @ordered
   */
  protected EList<ParameterTableHeader> parameterHeaders;

  /**
   * The cached value of the '{@link #getResultHeaders() <em>Result Headers</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getResultHeaders()
   * @generated
   * @ordered
   */
  protected EList<ResultTableHeader> resultHeaders;

  /**
   * The default value of the '{@link #getDefaultResultColumn() <em>Default Result Column</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDefaultResultColumn()
   * @generated
   * @ordered
   */
  protected static final String DEFAULT_RESULT_COLUMN_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDefaultResultColumn() <em>Default Result Column</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDefaultResultColumn()
   * @generated
   * @ordered
   */
  protected String defaultResultColumn = DEFAULT_RESULT_COLUMN_EDEFAULT;

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
  public EList<ParameterTableHeader> getParameterHeaders()
  {
    if (parameterHeaders == null)
    {
      parameterHeaders = new EObjectContainmentEList<ParameterTableHeader>(ParameterTableHeader.class, this, DslPackage.TABLE_TEST__PARAMETER_HEADERS);
    }
    return parameterHeaders;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ResultTableHeader> getResultHeaders()
  {
    if (resultHeaders == null)
    {
      resultHeaders = new EObjectContainmentEList<ResultTableHeader>(ResultTableHeader.class, this, DslPackage.TABLE_TEST__RESULT_HEADERS);
    }
    return resultHeaders;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDefaultResultColumn()
  {
    return defaultResultColumn;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDefaultResultColumn(String newDefaultResultColumn)
  {
    String oldDefaultResultColumn = defaultResultColumn;
    defaultResultColumn = newDefaultResultColumn;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.TABLE_TEST__DEFAULT_RESULT_COLUMN, oldDefaultResultColumn, defaultResultColumn));
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
      case DslPackage.TABLE_TEST__PARAMETER_HEADERS:
        return ((InternalEList<?>)getParameterHeaders()).basicRemove(otherEnd, msgs);
      case DslPackage.TABLE_TEST__RESULT_HEADERS:
        return ((InternalEList<?>)getResultHeaders()).basicRemove(otherEnd, msgs);
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
      case DslPackage.TABLE_TEST__PARAMETER_HEADERS:
        return getParameterHeaders();
      case DslPackage.TABLE_TEST__RESULT_HEADERS:
        return getResultHeaders();
      case DslPackage.TABLE_TEST__DEFAULT_RESULT_COLUMN:
        return getDefaultResultColumn();
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
      case DslPackage.TABLE_TEST__PARAMETER_HEADERS:
        getParameterHeaders().clear();
        getParameterHeaders().addAll((Collection<? extends ParameterTableHeader>)newValue);
        return;
      case DslPackage.TABLE_TEST__RESULT_HEADERS:
        getResultHeaders().clear();
        getResultHeaders().addAll((Collection<? extends ResultTableHeader>)newValue);
        return;
      case DslPackage.TABLE_TEST__DEFAULT_RESULT_COLUMN:
        setDefaultResultColumn((String)newValue);
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
      case DslPackage.TABLE_TEST__PARAMETER_HEADERS:
        getParameterHeaders().clear();
        return;
      case DslPackage.TABLE_TEST__RESULT_HEADERS:
        getResultHeaders().clear();
        return;
      case DslPackage.TABLE_TEST__DEFAULT_RESULT_COLUMN:
        setDefaultResultColumn(DEFAULT_RESULT_COLUMN_EDEFAULT);
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
      case DslPackage.TABLE_TEST__PARAMETER_HEADERS:
        return parameterHeaders != null && !parameterHeaders.isEmpty();
      case DslPackage.TABLE_TEST__RESULT_HEADERS:
        return resultHeaders != null && !resultHeaders.isEmpty();
      case DslPackage.TABLE_TEST__DEFAULT_RESULT_COLUMN:
        return DEFAULT_RESULT_COLUMN_EDEFAULT == null ? defaultResultColumn != null : !DEFAULT_RESULT_COLUMN_EDEFAULT.equals(defaultResultColumn);
      case DslPackage.TABLE_TEST__ROWS:
        return rows != null && !rows.isEmpty();
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
    result.append(" (defaultResultColumn: ");
    result.append(defaultResultColumn);
    result.append(')');
    return result.toString();
  }

} //TableTestImpl
